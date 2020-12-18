/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingalgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        File file = new File("bigvar.txt");
        Scanner sc = new Scanner(file);

        String[] arry;
        arry = sc.nextLine().split(" ", 0);

        int n = Integer.parseInt(arry[0]);

        Priority prio = new Priority(n);
        SRTF srtf = new SRTF(n);
        RRQueue rr = new RRQueue(4);
        SJF sjf = new SJF(n);
        FCFS fcfs = new FCFS(n);
        PriorityNon prin = new PriorityNon(n);
        MultiLevelQ mlq = new MultiLevelQ();
        int c = 1;
        
        for (int i=0;i<n;i++) {
            arry = sc.nextLine().split(" ", 0);
            int temp_burst_time = Integer.parseInt(arry[0]);
            int temp_arrival_time = Integer.parseInt(arry[1]);
            int temp_priority = Integer.parseInt(arry[2]);
            
            
            prio.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c));
            srtf.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c));
            rr.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c));
            sjf.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c));
            fcfs.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c));
            prin.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c));
            mlq.addP(new PCB(temp_burst_time,temp_arrival_time,temp_priority,c),1);
            c++;
            
        }
        System.out.println("Priority ");
        prio.run();
        System.out.println();
        System.out.println("Non Preemptive Priority");
        
        prin.run();
        System.out.println();
        System.out.println("SRTF");
        
        srtf.run();
        System.out.println();
        System.out.println("Round Robin q=4");
        
        rr.run();
        System.out.println();
        System.out.println("SJF");
        
        sjf.run();
        System.out.println();
        System.out.println("FCFS");
        
        fcfs.run();
        System.out.println();
        System.out.println("MLQ");
        mlq.run();
        System.out.println();
       
    }
}
