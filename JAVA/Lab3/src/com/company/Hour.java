package com.company;

public class Hour {
    int hour;
    int minutes;

    public Hour(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public int compareTo(Object other){
        if (other == null )
            throw new NullPointerException();
        if (!( other instanceof Hour ))
            throw new ClassCastException ("Uncomparable objects!");
        if (this.hour<((Hour)other).hour)
            return 1;
        else
            if(this.hour==((Hour)other).hour && this.minutes<((Hour)other).minutes )
                return 1;
            else
                return 0;


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.hour);
        sb.append(":");
        sb.append(this.minutes);
        String strI = sb.toString();
        return strI;
    }
}
