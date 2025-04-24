
public class PCB {
  int ppid;
  char processState;
  String processName;
  int processPriority;
  int processArrivalTime;
  int processBurst; // non-negative int
  int nextPCB;
  RegisterSet registerSet;

  public PCB(int ppid, char processState, String processName, int processPriority, int processArrivalTime, int processBurst, int nextPCB, RegisterSet registerSet) {
    this.ppid = ppid;
    this.processState = processState;
    this.processName = processName;
    this.processPriority = processPriority;
    this.processArrivalTime = processArrivalTime;
    this.processBurst = processBurst;
    this.nextPCB = nextPCB;
    this.registerSet = registerSet;
  }

  public int getPPID() {
    return ppid;
  }

  public void setPPID(int ppid) {
    this.ppid = ppid;
  }

  public char getProcessState() {
    return processState;
  }

  public void setProcessState(char processState) {
    this.processState = processState;
  }

  public int getProcessPriority() {
    return processPriority;
  }

  public void setProcessPriority(int processPriority) {
    this.processPriority = processPriority;
  }

  public int getProcessArrivalTime() {
    return processArrivalTime;
  }

  public void setProcessArrivalTime(int processArrivalTime) {
    this.processArrivalTime = processArrivalTime;
  }

  public int getProcessBurst() {
    return processBurst;
  }

  public void setProcessBurst(int processBurst) {
    this.processBurst = processBurst;
  }

  public void setNextPCB(int nextPCB) {
    this.nextPCB = nextPCB;
  }

  public int getNextPCB() {
    return nextPCB;
  }

  public String toString() {
    return "PCB {" + "ppid=" + ppid + ", processState=" + processState + ", processName='" + processName + '\'' + ", processPriority=" + processPriority + ", processArrivalTime=" + processArrivalTime + ", processBurst=" + processBurst + ", nextPCB=" + nextPCB + ", RegisterSet: " + registerSet.toString();
  }

}

