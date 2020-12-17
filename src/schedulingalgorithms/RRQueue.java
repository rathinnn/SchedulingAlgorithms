/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingalgorithms;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

/**
 *
 * @author dell
 */
public class RRQueue {
    int q;
    int numofp;
    int cur=0;
    
    int t=0;
    ArrayList<PCB> readyq;
    
    RRQueue(int q){
        numofp=0;
        readyq=new ArrayList<>();
        this.q=q;
    }
    
    public void addP(PCB ad){
        readyq.add(ad);
        
        
        numofp++;
    }
    
    public PCB removeP(int i){
        PCB ret=readyq.remove(i);
        numofp--;
        return ret;
      
        
    }
    
    
    
   
    
    public int oneiter(){
       
        int ret=-1;
        
        for (PCB u : readyq){
            if(u.completiontime==-1){
                if(u.arrivaltime<=t){
                    System.out.print("["+t+"] "+u.pid+" ");
                    t=t+Math.min(q, u.bursttime);
                    u.bursttime=u.bursttime-Math.min(q, u.bursttime);
                    
                    ret=0;
                
                    if(u.bursttime==0){
                        u.completiontime=t;
                    }
                }
                else if(ret==-1){
                   ret=-2;
               }
                
            }
            
            
        }
        return ret;
    }
    
    public void run(){
        Collections.sort(readyq);
        int flag = -2;
        while(flag!=-1){
            flag=oneiter();
            if(flag==-2){
                System.out.print("["+t+"]"+" ");
                t=t+1;
            }
        }
        System.out.print("["+t+"]");
    }
    
    public void printCt(){
        for (PCB u : readyq){
            System.out.println(u.completiontime);
            
            
        }
        
    }
    
    public double avgWt(){
        int sum = 0;
        for (int i = 0;i<readyq.size();i++){
            sum=sum+readyq.get(i).waitt();
            
            
            
        }
        
        return sum/(double)numofp;
        
    }
    
    
}

