// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    
    int cont = 0;
    
    public LimitedTable(StateManager state) {
        super(state);
    }
    
     public synchronized void exit(int id){
        state.exit(id);
        cont--;
        notifyAll();
    }
    
    public synchronized void enter(int id)throws InterruptedException{
        while(cont==4){
            state.wenter(id);
            wait();
        }
        state.enter(id);
        cont++;
    }
}
