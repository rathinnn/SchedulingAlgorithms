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
public class MultiLevelQ {
    RRQueue q1;
    RRQueue q2;
    RRQueue q3;
    
    MultiLevelQ(){
        q1=new RRQueue(3);
        q2=new RRQueue(4);
        q3=new RRQueue(100);
        
    }
    
    public void addP(PCB ad,int i){
        switch(i){
            case 1:
                q1.addP(ad);
                break;
            case 2:
                q2.addP(ad);
                break;
            case 3:
                q3.addP(ad);
                break;
        }
        
    }
    
    public int iterforLevel1(){
        
        int ret=-1;
        
        for (int i = 0;i<q1.readyq.size();i++){
            PCB u=q1.readyq.get(i);
            if(u.completiontime==-1){
                if(u.arrivaltime<=q1.t){
                    System.out.print("["+q1.t+"] "+u.pid+" ");
                    q1.t=q1.t+Math.min(q1.q, u.bursttime);
                    u.bursttime=u.bursttime-Math.min(q1.q, u.bursttime);
                    ret=0;
                
                    if(u.bursttime==0){
                        u.completiontime=q1.t;
                    }
                    else{
                        q2.addP(q1.removeP(i));
                    }
                }
                else if(ret==-1){
                   ret=-2;
               }
                
            }
            
        
        }
        
        return ret;
        
    }
    
    public int iterforLevel2(){
        
        int ret=-1;
        int i = 0;
        for ( i = 0;i<q2.readyq.size();i++){
            PCB u=q2.readyq.get(i);
            if(u.completiontime==-1){
                if(u.arrivaltime<=q2.t){
                    System.out.print("["+q2.t+"] "+u.pid+" ");
                    q2.t=q2.t+Math.min(q2.q, u.bursttime);
                    u.bursttime=u.bursttime-Math.min(q2.q, u.bursttime);
                    ret=0;
                
                    if(u.bursttime==0){
                        u.completiontime=q2.t;
                    }
                    else{
                        q3.addP(q2.removeP(i));
                    }
                }
                else if(ret==-1){
                   ret=-2;
               }
                
            }
            
          
        }
        
        return ret;
        
    }
    
    
    public int iterforLevel3(){
        
        int ret=-1;
        int i = 0;
        for (PCB u : q3.readyq){
            if(u.completiontime==-1){
                if(u.arrivaltime<=q3.t){
                    System.out.print("["+q3.t+"] "+u.pid+" ");
                    q3.t=q3.t+Math.min(q3.q, u.bursttime);
                    u.bursttime=u.bursttime-Math.min(q3.q, u.bursttime);
                    ret=0;
                
                    if(u.bursttime==0){
                        u.completiontime=q3.t;
                    }
                    
                }
                else if(ret==-1){
                   ret=-2;
               }
                
            }
            
        i++;   
        }
        return ret;
        
    }
    
     public void run(){
        int flag = -2;
        while(flag!=-1){
            flag=iterforLevel1();
            if(flag==-2){
                System.out.print(q1.t+"[     ]");
                q1.t=q1.t+1;
            }
        }
        q2.t=q1.t;
        flag = -2;
        while(flag!=-1){
            flag=iterforLevel2();
            if(flag==-2){
                System.out.print(q2.t+"[     ]");
                q2.t=q2.t+1;
            }
        }
        q3.t=q2.t;
        flag = -2;
        while(flag!=-1){
            flag=iterforLevel3();
            if(flag==-2){
                System.out.print(q3.t+"[     ]");
                q3.t=q3.t+1;
            }
        }
        System.out.print("["+q3.t+"]");
    }
     
     public void printCt(){
        for (PCB u : q1.readyq){
            System.out.println(u.pid+" :"+u.completiontime);
            
            
        }
        
        for (PCB u : q2.readyq){
            System.out.println(u.pid+" :"+u.completiontime);
            
            
        }
        
        for (PCB u : q3.readyq){
            System.out.println(u.pid+" :"+ u.completiontime);
            
            
        }
        
    }
    
    
}
