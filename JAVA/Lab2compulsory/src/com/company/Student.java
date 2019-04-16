/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

import java.util.*;

public class Student {
    String name;
    int yearOfStudy;
    public Project[] preferences;
    Student(String name,int yearOfStudy)
    {
        this.name=name;
        this.preferences=new Project[5];
        if(yearOfStudy>0 && yearOfStudy<4)
            this.yearOfStudy=yearOfStudy;
        else
            System.err.println("An invalid!");

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setPreferences(Project... args) {
        for(int i=0; i<args.length; i++)
        {
            for(int j=0;j<i;j++)
                if(args[i].equals(args[j]))
                { System.err.println("Project "+args[i].name+ " is already in the list!");
                    System.exit(0);
                }
            preferences[i]=args[i];
        }

    }

    public String getName()  /** @return student name */ {

        return name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        int dimension=0;
        while(preferences[dimension]!=null)
            dimension++;
        Project[] preferencesCopy=new Project[dimension];
        preferencesCopy=Arrays.copyOf(preferences,dimension);
        return "name=" + name +
                ", yearOfStudy=" + yearOfStudy +
                ", preferences=" + Arrays.toString(preferencesCopy) +
                '\n';
    }

    public Project[] getPreferences() {
        return preferences;
    }

    public List<Project> getListOfPreferences() {
        List<Project> projects=new ArrayList<Project>();
        for(Project project:preferences)
            if(project!=null)
                projects.add(project);
        return projects;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfStudy == student.yearOfStudy &&
                Objects.equals(name, student.name) &&
                Arrays.equals(preferences, student.preferences);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, yearOfStudy);
        result = 31 * result + Arrays.hashCode(preferences);
        return result;
    }
}
