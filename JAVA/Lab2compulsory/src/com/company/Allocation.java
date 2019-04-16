/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

public class Allocation {
    String name;
    int yearOfStudy;
    public Project project;

    /**
     * This is class's constructor
     */
    public Allocation() {
        this.name=null;
        this.yearOfStudy=0;
        this.project=null;
    }

    /**
     * This method get the name of a Student
     * @return a string
     */
    public String getName() {
        return name;
    }

    /**
     * This method get the year of study of student
     * @return a string
     */
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * This method get the proje of the student
     * @return a Project
     */
    public Project getProject() {
        return project;
    }

    /**
     * This method set the name of the student
     * @param name a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method set de year of study of a student
     * @param yearOfStudy a int
     */
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * This method set de project for a student
     * @param project a Project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * This method help us to get the data about a student and the project that was allocated to him
     * @return a String
     */
    @Override
    public String toString() {
        return "Student " + name +
                " from yearOfStudy " + yearOfStudy +
                " was allocated at project " + project +
                '.';
    }
}
