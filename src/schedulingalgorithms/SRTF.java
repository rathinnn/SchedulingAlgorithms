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
public class SRTF {
    int numofp;
    PCB[] readyq;
    static int t=0;
    
    SRTF(int n){
        numofp=0;
        readyq=new PCB[n];
        
    }
    
    public void addP(PCB ad){
        readyq[numofp]=ad;
        numofp++;
    }
    public boolean check(){
        for (int i = 0;i<readyq.length;i++){
            if(readyq[i].completiontime!=-1){
                return false;
            }
            
        }
        return true;
    }
    public int select(){
        int min = Integer.MAX_VALUE;
        int ret = -1;
        
        for (int i = 0;i<readyq.length;i++){
            if(readyq[i].bursttime<min && readyq[i].completiontime==-1 ){
               if(readyq[i].arrivaltime<=t){
                min=readyq[i].bursttime;
                ret=i;
               }
               else if(min==Integer.MAX_VALUE){
                   ret=-2;
               }
            }
        }
        
        return ret;
    }
    
    public void forward(PCB cur){
        cur.bursttime=cur.bursttime-1;
        t=t+1;
        if(cur.bursttime==0){
            cur.completiontime=t;
        }
        
    }
    
    public void run(){
        int i;
        while(true){
            
            
            i=select();
            if(i==-2){
                
                t++;
      
            }
            else if(i==-1){
                break;
            }
            else{
                forward(readyq[i]);
            }
        }
        
        
    }
    
    public void printCt(){
        for (int i = 0;i<readyq.length;i++){
            System.out.println(readyq[i].completiontime);
            
            
        }
        
    }
    
    
}
