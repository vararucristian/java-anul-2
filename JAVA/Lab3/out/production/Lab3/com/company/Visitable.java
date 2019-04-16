// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 3/10/2019 2:16:48 PM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Visitable.java

package com.company;

import java.sql.Time;

public interface Visitable
{

    public abstract Time getOpeningHour();

    public abstract void setOpeningHour(Time time);

    public abstract Time getClosingHour();

    public abstract void setClosingHour(Time time);
}