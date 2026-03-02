import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OS {

    public static void main(String[] args) {

        // Data structures
        PCB[] processTable = new PCB[50];
        Queue<Integer> ReadyQ = new LinkedList<>();
        int TerminatedQ = -1;
        int global_time = 0;
        int CPU = -1;
        int CPU_time = 0;
        int terminatedProcesses = 0;
        int processCount = 0;
        boolean ReadyQchanged = false;
        boolean TerminatedQchanged = false;

        ArrayList<String> list = new ArrayList<>();
        Random rand = new Random();

        // Load input file into memory
        try {
            Scanner fscan = new Scanner(new File("processes2.txt"));
            while (fscan.hasNextLine()) {
                list.add(fscan.nextLine());
                processCount++;
            }
            fscan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Main simulation loop
        while (terminatedProcesses < processCount) {

            // Process admission
            for (int i = 0; i < list.size(); i++) {

                String[] token = list.get(i).split(" ");
                String processName = token[0];
                int priority = Integer.parseInt(token[1]);
                int arrivalTime = Integer.parseInt(token[2]);

                if (global_time == arrivalTime && !isFull(processTable)) {

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

                    RegisterSet registerSet = new RegisterSet(
                            XAR, XDI, XDO, PC, IR, EMIT, RR, PSW,
                            R0, R1, R2, R3, R4, R5, R6, R7
                    );

                    PCB pcb = new PCB(-1, processName, priority,
                            arrivalTime, burstTime, 'n', -1, registerSet);

                    pcb.setProcessState('r');

                    for (int j = 0; j < processTable.length; j++) {
                        if (processTable[j] == null) {
                            processTable[j] = pcb;
                            ReadyQ.add(j);
                            ReadyQchanged = true;
                            break;
                        }
                    }
                }

                else if (arrivalTime == global_time && isFull(processTable)) {
                    arrivalTime++;
                    token[2] = Integer.toString(arrivalTime);
                    list.set(i, String.join(" ", token));
                }
            }

            // Clear terminated queue
            if (TerminatedQ != -1) {
                processTable[TerminatedQ] = null;
                TerminatedQ = -1;
                terminatedProcesses++;
                TerminatedQchanged = true;
            }

            // CPU scheduling (FCFS)
            if (CPU == -1) {
                if (!ReadyQ.isEmpty()) {
                    CPU = ReadyQ.remove();
                    processTable[CPU].setProcessState('e');
                    ReadyQchanged = true;
                }
            } else {
                CPU_time++;
                processTable[CPU].registerSet.setR0(rand.nextInt(65535));

                if (CPU_time >= processTable[CPU].burstTime) {
                    processTable[CPU].setProcessState('t');
                    TerminatedQ = CPU;
                    CPU = -1;
                    CPU_time = 0;
                    TerminatedQchanged = true;
                }
            }

            // Display ReadyQ changes
            if (ReadyQchanged) {
                System.out.println("ReadyQ: " + ReadyQ);
                ReadyQchanged = false;
            }

            // Display TerminatedQ changes
            if (TerminatedQchanged) {
                System.out.println("TerminatedQ: " + TerminatedQ);
                TerminatedQchanged = false;
            }

            // Advance global clock
            global_time++;
        }
    }

    // Check if process table is full
    public static boolean isFull(PCB[] processTable) {
        for (PCB process : processTable) {
            if (process == null) {
                return false;
            }
        }
        return true;
    }
}
