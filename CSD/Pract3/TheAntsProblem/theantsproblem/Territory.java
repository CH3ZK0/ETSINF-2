package theantsproblem;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CountDownLatch;

public class Territory {
    private int tam; // Matrix size
    private boolean occupied[][];
    
    //String description = "Basic Java Synchronization (using synchronized)";
    //String description="ReentrantLock with 1 Condition";//1er exercici
    //String description="ReentrantLock with multiple Conditions";//2on exercici
    String description="Using Barriers";//3er exercici
    
    private Log log;
    private ReentrantLock lock;
    
    //private Condition cond;//1er exercici
    private Condition[][] cond;//2on exercici
    CountDownLatch barrera;//3er exercici
    
    public String getDesc() {
        return description;
    }

    public Territory(int tamT, Log l) {
        tam = tamT;
        occupied = new boolean[tam][tam];
        log = l;
        lock = new ReentrantLock();
        
        //cond = lock.newCondition();//1er exercici
        cond = new Condition[tam][tam];//2on exercici
        barrera = new CountDownLatch(15);//3er exercici
        
        // Initializing the matrix
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                occupied[i][j] = false;
                cond[i][j]=lock.newCondition();
            }
        }
    }

    public int getTam() {
        return tam;
    }

    public void putAnt(Ant h, int x, int y) {
        try{
            lock.lock();
            while (occupied[x][y]) {
                try {
                    // Write in the log: ant waiting
                    log.writeLog(LogItem.PUT, h.getid(), x, y, 
                    LogItem.WAITINS,"Ant " + h.getid() +
                    " waiting for [" + x + "," + y + "]");
                    
                    barrera.countDown();//3er exercici les que esperen a entrar
                    //cond.await();//1er exercici
                    cond[x][y].await();//2on exercici
                    
                } catch (InterruptedException e) {
                }
            }
            
            occupied[x][y] = true;
            h.setPosition(x, y);
            // Write in the log: ant inside territory
            log.writeLog(LogItem.PUT, h.getid(), x, y, 
            LogItem.OK, "Ant " + h.getid() + " : [" + x + "," + y +
            "]  inside");
            
            //cond.signalAll();//1er exercici
            //cond[x][y].signalAll();//2on exercici  
            barrera.countDown();//3er exercici les que entren
            try{
                if(barrera.getCount() > 0){//3er exercici
                    lock.unlock();//3er exercici
                    barrera.await();//3er exercici
                    lock.lock();//3er exercici
                }
            }catch (InterruptedException e) {
            }
        }finally{
            lock.unlock();
        }
    }

    public void takeAnt(Ant h) {
        try{
            lock.lock();
            int x = h.getX();
            int y = h.getY();
            occupied[x][y] = false;
            // Write in the log: ant outside territory
            log.writeLog(LogItem.TAKE, h.getid(), x, y, LogItem.OUT,
            "Ant " + h.getid() + " : [" + x + "," + y + "] out");
            
            //cond.signal();//1er exercici
            cond[x][y].signal();//2on exercici
        }finally{
            lock.unlock();
        }
    }

    public void moves(Ant h, int x1, int y1, int step) {
        try{
            lock.lock();
            int x = h.getX();
            int y = h.getY();
            while (occupied[x1][y1]) {
                try {
                    // Write in the log: ant waiting
                    log.writeLog(LogItem.MOVE, h.getid(), x1, 
                    y1, LogItem.WAIT,"Ant " + h.getid() + 
                    " waiting for [" + x1 + "," + y1 + "]");
                    
                    //cond.await();//1er exercici
                    cond[x1][y1].await();//2on exercici
                } catch (InterruptedException e) {
                }
            }
            occupied[x][y] = false;
            occupied[x1][y1] = true;
            h.setX(x1);
            h.setY(y1);
            // Write in the log: ant moving
            log.writeLog(LogItem.MOVE, h.getid(), x1, y1, LogItem.OK,
            "Ant " + h.getid() + " : [" + x + "," + y + "] -> [" 
            + x1 + "," + y1 + "] step:" + step);
            
            //cond.signal();//1er exercici
            cond[x][y].signal();//2on exercici
        }finally{
            lock.unlock();
        }
    }
}
