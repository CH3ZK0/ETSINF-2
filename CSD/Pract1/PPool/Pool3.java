// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    private int kids = 0;
    private int instructors = 0;
    private int maxKids;
    private int Cap = 0;
    private int maxCap;
    
    public synchronized void  init(int ki, int cap){
        maxKids = ki;
        maxCap = cap;
    }
    
    public synchronized void kidSwims() throws InterruptedException {
        while (instructors == 0 || (kids+1) > (maxKids * instructors) || Cap >= maxCap){//COMPLETAR la condició 
            log.waitingToSwim();//per a visualitzar la posició del nadador 
            wait(); 
        }
        kids++;//Actualitza estat (COMPLETAR)
        log.swimming(); //per a visualitzar la posició del nadador 
        Cap++;
    }
    
    public synchronized void kidRests(){
        log.resting();
        kids--;
        Cap--;
        notifyAll();//Si necessari, avisa del nou estat a altres fils 
    }
        
    public synchronized void instructorSwims()throws InterruptedException{
        while(Cap >= maxCap){
            wait();
        }
        log.swimming();
        instructors++;
        Cap++;
        notifyAll();//Si necessari, avisa del nou estat a altres fils 
    }
    
    public synchronized void instructorRests()throws InterruptedException{
        while(kids > 0 && instructors == 1 || ((instructors-1) * maxKids) < kids){//COMPLETAR la condició 
            log.waitingToRest();//per a visualitzar la posició del nadador 
            wait(); 
        }
        instructors--;//Actualitza estat (COMPLETAR)
        Cap--;
        log.resting(); //per a visualitzar la posició del nadador   
        notifyAll();//Si necessari, avisa del nou estat a altres fils 
    }
}
