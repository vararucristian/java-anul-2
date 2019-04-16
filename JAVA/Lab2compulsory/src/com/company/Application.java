/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Application extends Project {
    Language language;

    Application(String name, LocalDate deadline, Language language) {
        this.name = name;
        this.deadline = deadline;
        this.language = language;


    }

    /**
     * That method help us to get data about the programing language of a application
     * @return a Language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Tha method set the programing language of a application
     * @param language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setDeadline(LocalDate deadline) {
        this.deadline=deadline;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    /**
     * This method help us to check if two application are the same
     * @param o a Object
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return getLanguage() == that.getLanguage()&&getName()==that.getName()&&getDeadline().equals(that.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLanguage());
    }

    /**
     * This method help us to get data about a Applicaton
     * @return a String
     */
    @Override
    public String toString() {
        return "(name=" + name  +
                ", language=" + language +
                ", deadline=" + deadline +")";
    }
}