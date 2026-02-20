
public class PCB {
    int ppid;
    char processState;
    String processName;
    int processPriority;
    int arrivalTime;
    int burstTime;
    int nextPCB;
    RegisterSet registerSet;

    public PCB(int ppid, String processName, int processPriority, int arrivalTime, int burstTime, char processState, int nextPCB, RegisterSet registerSet) {
        this.ppid = ppid;
        this.processState = processState;
        this.processName = processName;
        this.processPriority = processPriority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.nextPCB = nextPCB;
        this.registerSet = registerSet;
    }

    public void setPPID(int ppid) {
        this.ppid = ppid;
    }

    public int getPPID() {
        return this.ppid;
    }

    public void setProcessState(char processState) {
        this.processState = processState;
    }

    public char getProcessState() {
        return this.processState;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setProcessPriority(int processPriority) {
        this.processPriority = processPriority;
    }

    public int getProcessPriority() {
        return this.processPriority;
    }

    public void setProcessArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getProcessArrivalTime() {
        return this.arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getBurstTime() {
        return this.burstTime;
    }

    public void setNextPCB(int nextPCB){
        this.nextPCB = nextPCB;
    }

    public int getNextPCB(){
        return nextPCB;
    }
    public String toString() {
        int ppid = this.ppid;
        return "PCB {ppid=" + ppid + ", processState=" + this.processState + ", processName='" + this.processName + "', processPriority=" + this.processPriority + ", processArrivalTime=" + this.arrivalTime + ", burstTime=" + this.burstTime + ", nextPCB=" + this.nextPCB + ", RegisterSet: " + this.registerSet.toString() + "}";
    }
}
