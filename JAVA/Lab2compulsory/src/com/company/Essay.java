/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Essay extends Project{
    Topic topic;
    Essay(String name, LocalDate deadline, Topic topic)
    {
        this.name=name;
        this.deadline=deadline;
        this.topic=topic;
    }

    @Override
    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the topic of a essay
     * @return a Topic
     */
    public Topic getTopic() {
        return topic;
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
     * set the topic of a essay
      * @param topic a Topic
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * This method help us to get data about a essay
     * @return a String
     */
    @Override
    public String toString() {
        return "(name=" + name  +
                ", topic=" + topic +
                ", deadline=" + deadline +")" ;

    }

    /**
     * This method help us to check if two Essays are the same
     * @param o a Object
     * @return a boolean1
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Essay essay = (Essay) o;
        return getTopic() == essay.getTopic()&&getName()==essay.getName()&&getDeadline().equals(essay.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopic());
    }
}
