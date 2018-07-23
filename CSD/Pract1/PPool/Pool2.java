// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
    private int kids = 0;
    private int instructors = 0;
    private int maxKids;
    
    public synchronized void  init(int ki, int cap){maxKids = ki;}
    
    public synchronized void kidSwims() throws InterruptedException {
        while (instructors == 0 || (kids+1) > (maxKids * instructors)){//COMPLETAR la condició 
            log.waitingToSwim();//per a visualitzar la posició del nadador 
            wait(); 
        }
        kids++;//Actualitza estat (COMPLETAR)
        log.swimming(); //per a visualitzar la posició del nadador 
    }
    
    public synchronized void kidRests(){
        log.resting();
        kids--;
        notifyAll();//Si necessari, avisa del nou estat a altres fils 
    }
        
    public synchronized void instructorSwims(){
        log.swimming();
        instructors++;
        notifyAll();//Si necessari, avisa del nou estat a altres fils 
    }
    
    public synchronized void instructorRests()throws InterruptedException{
        while(kids > 0 && instructors == 1 || ((instructors-1) * maxKids) < kids){//COMPLETAR la condició 
            log.waitingToRest();//per a visualitzar la posició del nadador 
            wait(); 
        }
        instructors--;//Actualitza estat (COMPLETAR)
        log.resting(); //per a visualitzar la posició del nadador 
        notifyAll();//Si necessari, avisa del nou estat a altres fils 
    }
}
