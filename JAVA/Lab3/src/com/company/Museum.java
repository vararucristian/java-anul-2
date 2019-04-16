package com.company;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Museum extends Node implements Visitable,Payable {
    LocalTime openingHour;
    LocalTime closingHour;
    float priceOfTicket;

    public Museum(String name) {
        super(name);
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

    @Override
    public float getPriceOfTicket() {
        return priceOfTicket;
    }

    @Override
    public void setPriceOfTicket(float priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }
}
