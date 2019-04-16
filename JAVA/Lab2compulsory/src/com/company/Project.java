/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

import java.time.LocalDate;

public abstract class Project {
    String name;
    LocalDate deadline;

    /**
     * That method get the deadline of a Project
     * @return a LocalDate
     */
    public abstract LocalDate getDeadline();

    /**
     * That method get the Project name
     * @return a String
     */
    public abstract String getName() ;

    /**
     * That method set the deadline of a project
     * @param deadline a LocalDate
     */
    public abstract void setDeadline(LocalDate deadline);

    /**
     * This method set the Project name
     * @param name a String
     */
    public abstract void setName(String name);


}
