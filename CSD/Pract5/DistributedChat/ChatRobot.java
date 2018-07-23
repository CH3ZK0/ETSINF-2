// This file must be implemented when completing activity 2
//

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

//
// ChatRobot implementation
//
public class ChatRobot implements MessageListener{

	private ChatConfiguration conf;
	private IChatServer srv = null;   // We just connect to one single server
	private IChatUser myUser = null;  // Our own user

	private String nsHost = "localhost";
   	//private int nsPort = 1099;
   	private int nsPort = 9000;
   	
   	private String serverName = "TestServer";
   	private String channelName = "#Friends";

	public ChatRobot (ChatConfiguration c) throws Exception{
		conf = c;
		doConnect();
		doJoinChannel();
	}

	//
	// The first thing to do before chatting is to connect to a ChatServer!!
	//
	// For us, connect means to locate it, register a new user into it and retrieve its channel list.
	// On success, returns the server channel list.
	//
	public void doConnect () throws Exception {

		// Locate server using the name service
		try {
			Registry reg = LocateRegistry.getRegistry (nsHost, nsPort);

			srv = (IChatServer) reg.lookup (serverName);
			//System.out.println ("LOG==> ChatServer: " + srv);
		} catch (java.rmi.ConnectException e) {
			throw new Exception ("rmiregistry not found at '" + nsHost + ":" + nsPort + "'");
		} catch (java.rmi.NotBoundException e) {
			throw new Exception ("Server '" + serverName + "' not found.");
		}

		// Once we've got the server, we create a local user object and register it into the server
		myUser = new ChatUser ("Robot", this);
		boolean done = srv.connectUser (myUser);
		if (!done){ 
			throw new Exception ("Nick already in use");
		}
	}

	//
	// To chat in a channel we require users to join.
	// On success, returns the user list
	//
	public void doJoinChannel () throws Exception {

		IChatChannel ch = srv.getChannel (channelName);
		if (ch == null) {throw new Exception ("Channel not found");}

		ch.join (myUser); // join 
	}

	public void messageArrived (IChatMessage msg) {
		try {
			IChatUser src = msg.getSender();
			Remote dst = msg.getDestination();
			String str = msg.getText();

			if (src == null && str.startsWith(ChatChannel.JOIN)) {

				String nick = str.substring (ChatChannel.JOIN.length() + 1);
				IChatChannel c_dst = (IChatChannel) dst;

				String resposta = "Hola " + nick;

				IChatMessage c_msg = new ChatMessage(myUser, c_dst, resposta);
				c_dst.sendMessage (c_msg);
			}
		} catch (Exception e) {
			System.out.println("Error when receiving message: " + e.getMessage());
		}
	}

   	public static void main (String args [] ) throws Exception{

    	System.out.println ("To be implemented");

		ChatRobot cr = new ChatRobot (ChatConfiguration.parse (args));

		System.out.println ("Robot connected.");

    	while(true);
   	}
}