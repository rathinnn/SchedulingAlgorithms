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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

*/
        PriorityNon s1 = new PriorityNon(5);
        s1.addP(new PCB(10,0,3));
        s1.addP(new PCB(1,0,1));
        s1.addP(new PCB(2,0,4));
        s1.addP(new PCB(1,0,5));
        s1.addP(new PCB(5,0,2));
        
        s1.run();
        System.out.println();
        
        System.out.println(s1.avgWt());
        
        
        
    }
}
