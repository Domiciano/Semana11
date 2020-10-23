package model;

public class Division {

    private String uid;
    private int dividendo;
    private int divisor;

    public Division(String uid, int dividendo, int divisor) {
        this.uid = uid;
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

    public Division() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getDividendo() {
        return dividendo;
    }

    public void setDividendo(int dividendo) {
        this.dividendo = dividendo;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
}
