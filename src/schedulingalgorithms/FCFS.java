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
import java.util.Scanner;
import java.util.ArrayList;

public class FCFS {
    
    
    int numofp;
    PCB[] readyq;
    int t=0;
    
    FCFS(int n){
        numofp=0;
        readyq=new PCB[n];
        
    }
    
    public void addP(PCB ad){
        readyq[numofp]=ad;
        numofp++;
    }
    
    public int select(){
        int min = Integer.MAX_VALUE;
        int ret = -1;
        
        for (int i = 0;i<readyq.length;i++){
            if(readyq[i].arrivaltime<min && readyq[i].completiontime==-1 ){
               if(readyq[i].arrivaltime<=t){
                min=readyq[i].arrivaltime;
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
                
                System.out.print("["+t +"]  ");
                t++;
                
      
            }
            else if(i==-1){
                break;
            }
            else{
                
                System.out.print("["+t+"] "+readyq[i].pid+" ");
                forward(readyq[i]);
            }
        }
        System.out.print("["+t+"]");
        
        
    }
    
    public void printCt(){
        for (int i = 0;i<readyq.length;i++){
            System.out.println(readyq[i].completiontime);
            
            
        }
        
    }
    
    public double avgWt(){
        int sum = 0;
        for (int i = 0;i<readyq.length;i++){
            sum=sum+readyq[i].waitt();
            
            
            
            
        }
        return sum/(double)numofp;
        
    }
    
    //=====================================================================================
    
    public static void run2() {
          int i = 0;
          int k = 0;
          int temp_burst_time = 0;
          int temp_arrival_time = 0;
          Scanner scan = new Scanner(System.in);
          System.out.print("Enter the number of processes you want to enter: ");
          int total_processes = scan.nextInt();
          System.out.println("");
          PCB pcb[] = new PCB[total_processes];
          for (i = 0; i < total_processes; i ++) {
               System.out.print("Enter the process " + (i + 1) + " burst time: ");
               temp_burst_time = scan.nextInt();
               System.out.print("Enter the process " + (i + 1) + " arrival time: ");
               temp_arrival_time = scan.nextInt();
               pcb[i] = new PCB(temp_burst_time, temp_arrival_time);
               System.out.println();
          }
          ArrayList<PCB> present_tasks = new ArrayList<PCB>();
          PCB present_task = null;
          PCB present_task_resetter = new PCB(Integer.MAX_VALUE, 0, false);
          present_task = present_task_resetter;
          int present_time = 0;
          int task_completion_time = 0;
          int task_counter = 0;
          while (true) {
               for (i = 0; i < pcb.length; i ++) {
                    if (pcb[i].arrivaltime == present_time) {
                         present_tasks.add(pcb[i]);
                    }
               }
               if (!present_tasks.isEmpty()) {
                    if (task_completion_time == 0) {
                         for (i = 0; i < present_tasks.size(); i ++) {
                              if (present_task.bursttime > present_tasks.get(i).bursttime) {
                                   present_task = present_tasks.get(0);
                              }
                         }
                         for (i = 0; i < pcb.length; i ++) {
                              if (present_task.pid == pcb[i].pid) {
                                   
                                   break;
                              }
                         }
                         task_completion_time = present_task.bursttime;
                         for (k = 0; k < present_tasks.size(); k ++)  {
                              if (present_tasks.get(k) == present_task) {
                                   present_tasks.remove(k);
                                   break;
                              }
                         }
                         task_counter = task_counter + 1;
                    }
               }
               present_time = present_time + 1;
               if (task_completion_time != 0) {
                    task_completion_time = task_completion_time - 1;
               }
               if (task_completion_time == 0) {
                    for (i = 0; i < pcb.length; i ++) {
                         if (present_task.pid == pcb[i].pid) {
                              pcb[i].completiontime = present_time;
                              present_task = present_task_resetter;
                              break;
                         }
                    }
               }
               if (task_counter == pcb.length && task_completion_time == 0) {
                    break;
               }
          }
          for (i = 0; i < pcb.length; i ++) {
               System.out.println("Process Id: " + (pcb[i].pid ) + "| Process Arrival Time: " + pcb[i].arrivaltime +  " | Process Completion Time: " + pcb[i].completiontime);
          }
     }
    
    
    
     
}

