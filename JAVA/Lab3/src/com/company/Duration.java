package com.company;

public class Duration {
    int hours;
    int minutes;

    public Duration(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.hours);
        sb.append(":");
        sb.append(this.minutes);
        String strI = sb.toString();
        return strI;
    }

}
