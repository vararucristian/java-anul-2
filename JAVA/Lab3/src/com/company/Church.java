package com.company;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.SimpleTimeZone;

public class Church extends Node implements Visitable {
    LocalTime openingHour;
    LocalTime closingHour;

    public Church(String name) {
        super(name);
    }

    public int compareHourTo(Object other){
        if (other == null )
            throw new NullPointerException();
        if (!( other instanceof Church ))
            throw new ClassCastException ("Uncomparable objects!");
        return this.compareTo(((Church) other).openingHour);

    }

    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }

    @Override
    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

}
