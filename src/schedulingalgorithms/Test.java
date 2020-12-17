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
        // TODO code application logic here
        /*
        SRTF s1 = new SRTF(5);
        s1.addP(new PCB(6,2));
        s1.addP(new PCB(2,5));
        s1.addP(new PCB(8,1));
        s1.addP(new PCB(3,0));
        s1.addP(new PCB(4,4));
        
        s1.run();
        
        s1.printCt();

        
        Priority p1 = new Priority(5);
        p1.addP(new PCB(4,0,1));
        p1.addP(new PCB(3,0,2));
        p1.addP(new PCB(7,6,1));
        p1.addP(new PCB(4,11,3));
        p1.addP(new PCB(2,12,2));
        
        p1.run();
        
        p1.printCt();
    
        
        


        
        RRQueue r1 = new RRQueue(3);
        r1.addP(new PCB(5,0));
        r1.addP(new PCB(3,1));
        r1.addP(new PCB(8,2));
        r1.addP(new PCB(6,3));
       
        
        r1.run();
        
        r1.printCt();


        MultiLevelQ m1 = new MultiLevelQ();
        m1.addP(new PCB(8,0),1);
        m1.addP(new PCB(3,0),1);
        m1.addP(new PCB(4,0),2);
        
       
        
        m1.run();
        
        m1.printCt();

 
        
      
        SJF s1 = new SJF(5);
        s1.addP(new PCB(6,2));
        s1.addP(new PCB(2,5));
        s1.addP(new PCB(8,1));
        s1.addP(new PCB(3,0));
        s1.addP(new PCB(4,4));
        
        s1.run();
        System.out.println();
        
        System.out.println(s1.avgWt());


        Priority s1 = new Priority(5);
        s1.addP(new PCB(10,0,3));
        s1.addP(new PCB(1,0,1));
        s1.addP(new PCB(2,0,4));
        s1.addP(new PCB(1,0,5));
        s1.addP(new PCB(5,0,2));
        
        s1.run();
        System.out.println();
        
        System.out.println(s1.avgWt());
        
        
    
        MultiLevelQ m1 = new MultiLevelQ();
        m1.addP(new PCB(8,0),1);
        m1.addP(new PCB(3,0),1);
        m1.addP(new PCB(4,0),2);
        
       
        
        m1.run();
        
        //m1.printCt();
        //r1.printCt();

        
        
        Priority s1 = new Priority(2);
        s1.addP(new PCB(4,0,2));
        s1.addP(new PCB(5,1,1));
        s1.run();
        System.out.println(s1.avgWt());
        PriorityNon s2 = new PriorityNon(2);
        s2.addP(new PCB(4,0,2));
        s2.addP(new PCB(5,1,1));
        s2.run();
        System.out.println(s2.avgWt());

        
        
        RRQueue s2 = new RRQueue(6);
        s2.addP(new PCB(4,0,2));
        s2.addP(new PCB(5,1,1));
        s2.run();
        System.out.println(s2.avgWt());
        
        s2.printCt();
        
        FCFS s1 = new FCFS(2);
        s1.addP(new PCB(4,0,2));
        s1.addP(new PCB(5,1,1));
        s1.run();
        System.out.println(s1.avgWt());
        
        s1.printCt();
        
        */
        
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
