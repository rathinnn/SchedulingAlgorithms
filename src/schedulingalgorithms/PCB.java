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
    
    public int turnar(){
        return completiontime-arrivaltime;
    }
    public int waitt(){
        return (turnar()-bursttime);
    }
    
    
}
