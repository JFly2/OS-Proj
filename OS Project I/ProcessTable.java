
public class ProcessTable  {
  int max = 100;
  PCB[] processTable = new PCB[max];
  int index = 0;
  public boolean isFull() {
    return index == max;
  }
  public void addProcess(PCB process){
  if (!isFull()){
    processTable[index] = process;
    index++;
  } else {
    System.out.println("Error: Process table is full.");
  }
  }

  public PCB getProcess(int pid){
  if (pid >= 0 && pid < index){
    return processTable[pid];
  } else {
    System.out.println("Error: invalid process ID.");
    return null;
  }
  }

  public int size(){
    return index;
  }
  public void printTable() {
    for (int i = 0; i < index; i++) {
      System.out.println("Process ID: " + i + " | " + processTable[i].toString());
    }
  }


}
