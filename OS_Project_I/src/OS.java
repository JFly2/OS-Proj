import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OS {
    public static void main (String[] args){
        PCB[] processTable = new PCB[100];
        int processAdded = 0;
        int global_time = 0;
        int pid = -1;
        int processCount = 0;
        
        try {
            Scanner fscan = new Scanner(new File("OS_Project_I/processes1.txt"));
            while (fscan.hasNextLine()){
                fscan.nextLine();
                processCount++;
            }
            fscan.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
        try {
            while (processAdded < processCount) {
                Scanner fscan = new Scanner(new File("OS_Project_I/processes1.txt"));
                while (fscan.hasNextLine()){
                    String line = fscan.nextLine();
                    String[] token = line.split(" ");
                    String processName = token[0];

                    int priority = Integer.parseInt(token[1]);
                    int arrivalTime = Integer.parseInt(token[2]);
                    
                    if (global_time == arrivalTime){

                    int burstTime = Integer.parseInt(token[3]);
                    int XAR = Integer.parseInt(token[4], 16);
                    int XDI = Integer.parseInt(token[5], 16);
                    int XDO = Integer.parseInt(token[6], 16);
                    int PC = Integer.parseInt(token[7], 16);
                    int IR = Integer.parseInt(token[8], 16);
                    int EMIT = Integer.parseInt(token[9], 16);
                    int RR = Integer.parseInt(token[10], 16);
                    int PSW = Integer.parseInt(token[11], 16);
                    int R0 = Integer.parseInt(token[12], 16);
                    int R1 = Integer.parseInt(token[13], 16);
                    int R2 = Integer.parseInt(token[14], 16);
                    int R3 = Integer.parseInt(token[15], 16);
                    int R4 = Integer.parseInt(token[16], 16);
                    int R5 = Integer.parseInt(token[17], 16);
                    int R6 = Integer.parseInt(token[18], 16);
                    int R7 = Integer.parseInt(token[19], 16);

                        RegisterSet registerSet = new RegisterSet(XAR, XDI, XDO, PC, IR, EMIT, RR, PSW, R0, R1, R2, R3, R4, R5, R6, R7);
                        PCB pcb = new PCB(-1, processName, priority, arrivalTime, burstTime, 'n', -1, registerSet);
                        pcb.setNextPCB(pid);
                        pcb.setPPID(pcb.getNextPCB());
                        processTable[processAdded++] = pcb;
                        pid++;
                    }
                }
                global_time++;
                fscan.close();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        for (PCB process: processTable){
            if(process != null) {
                System.out.println(process);
            }
        }
    }
}

