/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingalgorithms;

/**
 *
 * @author dell
 */
public class PCB implements Comparable {
    int bursttime;
    long pid;
    int arrivaltime;
    int completiontime;
    int priority;
    int bursttimestatic;
    static int pidc = 0;
    
    PCB(int bt,int at){
        bursttime=bt;
        bursttimestatic=bt;
        arrivaltime=at;
        completiontime = -1;
        priority=-1;
        pidc++;
        pid=pidc;
        
    }
    
     
    
    PCB(int bt,int at,int pr){
        bursttime=bt;
        bursttimestatic=bt;
        arrivaltime=at;
        completiontime = -1;
        priority=pr;
        pidc++;
        pid=pidc;
    }
    
    PCB(int bt,int at,int pr,int pid){
        bursttime=bt;
        bursttimestatic=bt;
        arrivaltime=at;
        completiontime = -1;
        priority=pr;
        
        this.pid=pid;
    }
    
    PCB(int bt,int at,boolean f){
        bursttime=bt;
        bursttimestatic=bt;
        arrivaltime=at;
        completiontime = -1;
        if(f==false){
            pid=-1;
        }
        else{
            
        
        pidc++;
        pid=pidc;
    
        }
    }
    
    public int turnar(){
        return completiontime-arrivaltime;
    }
    public int waitt(){
        return (turnar()-bursttimestatic);
    }
    
    
   

    @Override
    public int compareTo(Object o) {
       int compare=((PCB)o).arrivaltime;
        
        return this.arrivaltime-compare;
    }
    
    
}
