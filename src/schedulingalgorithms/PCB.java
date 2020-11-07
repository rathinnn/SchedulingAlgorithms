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
public class PCB {
    int bursttime;
    long pid;
    int arrivaltime;
    int completiontime;
    int priority;
    static int pidc = 0;
    
    PCB(int bt,int at){
        bursttime=bt;
        arrivaltime=at;
        completiontime = -1;
        priority=-1;
        pidc++;
        pid=pidc;
        
    }
    
     
    
    PCB(int bt,int at,int pr){
        bursttime=bt;
        arrivaltime=at;
        completiontime = -1;
        priority=pr;
        pidc++;
        pid=pidc;
    }
    
    public int turnar(){
        return completiontime-arrivaltime;
    }
    public int waitt(){
        return (turnar()-bursttime);
    }
    
    
}
