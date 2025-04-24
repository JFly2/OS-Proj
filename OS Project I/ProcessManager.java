
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProcessManager {
  public static void main(String[] args) {
    try {
      ProcessTable processTable = new ProcessTable();
      int processedProcesses = 0;
      int prevIndex = -1;

      int nextPCB = prevIndex;

      while (processedProcesses < processTable.max) {
        Scanner fscan = new Scanner(new File("processes1.txt"));

        while (fscan.hasNextLine()) {
          String line = fscan.nextLine();
          String[] token = line.split(" ");

          String processName = token[0];
          int processPriority = Integer.parseInt(token[1]);
          int processArrivalTime = Integer.parseInt(token[2]);
          int processBurst = Integer.parseInt(token[3]);

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

          if (processArrivalTime == processedProcesses) {
            PCB pcb = new PCB(prevIndex, 'n', processName, processPriority, processArrivalTime, processBurst, nextPCB, registerSet);

            processTable.addProcess(pcb);

            prevIndex = processTable.size() - 1;

            nextPCB++;
          }
        }

        fscan.close();
        processedProcesses++;

      }
        processTable.printTable();

      } catch(FileNotFoundException e){
        e.printStackTrace();
      }
    }
  }


