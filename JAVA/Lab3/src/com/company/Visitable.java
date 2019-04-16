package com.company;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public interface Visitable {
    public LocalTime getOpeningHour() ;

    public void setOpeningHour(LocalTime openingHour) ;

    public LocalTime getClosingHour() ;

    public void setClosingHour(LocalTime closingHour);
    default void setProgram(){
        LocalTime localTime = LocalTime.of(9, 30);
        this.setOpeningHour(localTime);
        localTime = LocalTime.of(20, 0);
        this.setClosingHour(localTime);
    }
    static Duration getVisitingDuration(Node node){
        if(!(node instanceof Visitable))
            return null;
        int nrOfHours;
        int nrOfMinutes;
        nrOfHours=((Visitable)node).getClosingHour().getHour()-((Visitable)node).getOpeningHour().getHour();
        nrOfMinutes=((Visitable)node).getClosingHour().getMinute()-((Visitable)node).getOpeningHour().getMinute();
        if(nrOfMinutes<0)
        {nrOfMinutes=60+nrOfMinutes;
        nrOfHours--;
        }
        Duration duration=new Duration(nrOfHours,nrOfMinutes);
        return duration;
    }

}

