
public class RegisterSet {
    int XAR, XDI, XDO, PC, IR, EMIT, RR, PSW, R0, R1, R2, R3, R4, R5, R6, R7;

    public RegisterSet(){}
    public RegisterSet (int XAR, int XDI, int XDO, int PC, int IR, int EMIT, int RR, int PSW,
                        int R0, int R1, int R2, int R3, int R4, int R5, int R6, int R7) {
        this.XAR = XAR;
        this.XDI = XDI;
        this.XDO = XDO;
        this.PC = PC;
        this.IR = IR;
        this.EMIT = EMIT;
        this.RR = RR;
        this.PSW = PSW;
        this.R0 = R0;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.R4 = R4;
        this.R5 = R5;
        this.R6 = R6;
        this.R7 = R7;
    }



    public int getXAR() {
        return XAR;
    }

    public void setXAR(int XAR) {
        this.XAR = XAR;
    }

    public int getXDI() {
        return XDI;
    }

    public void setXDI(int XDI) {
        this.XDI = XDI;
    }

    public int getXDO() {
        return XDO;
    }

    public void setXDO(int XDO) {
        this.XDO = XDO;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getIR() {
        return IR;
    }

    public void setIR(int IR) {
        this.IR = IR;
    }

    public int getEMIT() {
        return EMIT;
    }

    public void setEMIT(int EMIT) {
        this.EMIT = EMIT;
    }

    public int getRR() {
        return RR;
    }

    public void setRR(int RR) {
        this.RR = RR;
    }

    public int getPSW() {
        return PSW;
    }

    public void setPSW(int PSW) {
        this.PSW = PSW;
    }

    public int getR0() {
        return R0;
    }

    public void setR0(int R0) {
        this.R0 = R0;
    }

    public int getR1() {
        return R1;
    }

    public void setR1(int R1) {
        this.R1 = R1;
    }

    public int getR2() {
        return R2;
    }

    public void setR2(int R2) {
        this.R2 = R2;
    }

    public int getR3() {
        return R3;
    }

    public void setR3(int R3) {
        this.R3 = R3;
    }

    public int getR4() {
        return R4;
    }

    public void setR4(int R4) {
        this.R4 = R4;
    }

    public int getR5() {
        return R5;
    }

    public void setR5(int R5) {
        this.R5 = R5;
    }

    public int getR6() {
        return R6;
    }

    public void setR6(int R6) {
        this.R6 = R6;
    }

    public int getR7() {
        return R7;
    }

    public void setR7(int R7) {
        this.R7 = R7;
    }

    public String toString() {
        return "XAR=0x" + Integer.toHexString(XAR) +
                ", XDI=0x" + Integer.toHexString(XDI) +
                ", XDO=0x" + Integer.toHexString(XDO) +
                ", PC=0x" + Integer.toHexString(PC) +
                ", IR=0x" + Integer.toHexString(IR) +
                ", EMIT=0x" + Integer.toHexString(EMIT) +
                ", RR=0x" + Integer.toHexString(RR) +
                ", PSW=0x" + Integer.toHexString(PSW) +
                ", R0=0x" + Integer.toHexString(R0) +
                ", R1=0x" + Integer.toHexString(R1) +
                ", R2=0x" + Integer.toHexString(R2) +
                ", R3=0x" + Integer.toHexString(R3) +
                ", R4=0x" + Integer.toHexString(R4) +
                ", R5=0x" + Integer.toHexString(R5) +
                ", R6=0x" + Integer.toHexString(R6) +
                ", R7=0x" + Integer.toHexString(R7) +
                '}';
    }

}
