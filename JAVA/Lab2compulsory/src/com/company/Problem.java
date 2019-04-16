/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.Preferences;

public class Problem {
    public Student[] students;

    /**
     * this is class's constructor
     */
    Problem() {
        this.students = new Student[50];
    }

    /**
     * This method set the students that are part of a problem
     *
     * @param args is a list of students
     */
    public void setStudents(Student... args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < i; j++)
                if (args[i].equals(args[j])) {
                    System.err.println("Student " + args[i].name + " is already in the list!");
                    System.exit(0);
                }
            students[i] = args[i];
        }
    }

    /**
     * this method help us to get data about all the students that are involved in problem
     *
     * @return a string that contains data about our problem
     */
    @Override
    public String toString() {
        int dimension = 0;
        while (students[dimension] != null)
            dimension++;
        Student[] studentsCopy = new Student[dimension];
        studentsCopy = Arrays.copyOf(students, dimension);
        return "Students Preferences \n" +
                Arrays.toString(studentsCopy);
    }

    /**
     * This method get the students that are part of a problem
     *
     * @return a vector of students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * this method get all the projects that are  part of our problem
     *
     * @return a list of projects
     */
    public List<Project> getProjects() {
        int ok = 1;
        List<Project> projects = new ArrayList<Project>();
        Project[] proiecte = new Project[5];
        for (Student student : students) {
            if (student == null)
                break;
            proiecte = student.getPreferences();
            for (Project project : proiecte) {
                ok = 1;
                if (project != null) {
                    for (Project project2 : projects)
                        if (project.equals(project2))
                            ok = 0;
                    if (ok == 1)
                        projects.add(project);
                }
            }
        }
        return projects;
    }

    /**
     * this method is a algorithm that, using the students's data, generates a solution for the problem
     *
     * @return a list of allocations for the students
     */

    public List<Allocation> solveProblem() {
        int ok;
        List<Allocation> allocations = new ArrayList<Allocation>();
        List<Project> projects = new ArrayList<Project>();
        projects = getProjects();
        for (Student student : students) {
            if (student == null)
                break;
            ok = 1;
            for (Project preference : student.getPreferences()) {
                if (preference == null)
                    break;
                for (Project project : projects)
                    if (project.equals(preference)) {
                        Allocation allocation = new Allocation();
                        allocation.setName(student.name);
                        allocation.setYearOfStudy(student.yearOfStudy);
                        allocation.setProject(project);
                        allocations.add(allocation);
                        projects.remove(project);
                        ok = 0;
                        break;
                    }
                if (ok == 0)
                    break;
            }
        }

        return allocations;
    }

    public List<Allocation> maximumSolveProblem() {
        List<Allocation> allocations = new ArrayList<Allocation>();
        List<Project> projects = new ArrayList<Project>();
        projects = getProjects();
        int projectNrOfPreferences[] = new int[projects.size()];
        for (Student student : students) {
            if (student == null)
                break;
            for (Project project : student.getPreferences()) {
                if (project == null)
                    break;
                projectNrOfPreferences[projects.indexOf(project)]++;
            }
        }
        int length;
        List<Student> unsolvedStudents=new ArrayList<Student>();
        for (Student student : students) {
            if (student == null)
                break;
            unsolvedStudents.add(student);
        }
        int min;
        int ok=1;
        while(ok==1)
        {   ok=0;
            length=5;
            min=250;
            for(Student student:unsolvedStudents)
                if(student.getListOfPreferences().size()<length)
                    length=student.getListOfPreferences().size();

            for(Student student:unsolvedStudents)
                if(student.getListOfPreferences().size()==length)
                {
                    for(Project project:student.getListOfPreferences())
                        if (projectNrOfPreferences[projects.indexOf(project)]<min && projectNrOfPreferences[projects.indexOf(project)]!=0)
                            min=projectNrOfPreferences[projects.indexOf(project)];
                    for(Project project:student.getListOfPreferences())
                        if (projectNrOfPreferences[projects.indexOf(project)]==min)
                        {   ok=1;
                            Allocation allocation = new Allocation();
                            allocation.setName(student.name);
                            allocation.setYearOfStudy(student.yearOfStudy);
                            allocation.setProject(project);
                            allocations.add(allocation);
                            projectNrOfPreferences[projects.indexOf(project)]=0;
                            break;
                        }
                unsolvedStudents.remove(student);
                break;
                }

                }

        return allocations;
        }

    public String hallsTheorem() {
        int ok = 1;
        int okay = 1;
        int k = 1;
        int contor = 0;
        int pref1, pref2;
        List<Student> studentList = new ArrayList<Student>();
        for (Student student1 : students) {
            if (student1 == null)
                break;
            pref1 = 0;
            studentList.add(student1);
            for (Project p1 : student1.preferences)
                if (p1 != null)
                    pref1++;
            for (Student student2 : students) {
                if(!student1.equals(student2))
                {
                    contor = 0;
                    if (student2 == null)
                        break;
                    studentList.add(student2);
                    pref2 = 0;
                    for (Project p2 : student2.preferences)
                        if (p2 != null)
                            pref2++;

                    if (pref1 == pref2 && pref2 < studentList.size()) {
                        for (Project proj : student1.preferences) {
                            if (proj == null)
                                break;
                            k = 0;
                            for (Project proj2 : student2.preferences)
                                if (proj == null)
                                    break;
                                else if (proj.equals(proj2))
                                    k = 1;
                            if (k == 1)
                                contor++;
                        }

                        if (contor == pref1) {
                            ok = 0;
                            break;
                        }
                    }
                    studentList.remove(student2);
                }}
            studentList.remove(student1);}
        if (ok == 0)
            return "It is not possible to allocate a project to every student.";
        else
            return "It is possible to allocate a project to every student.";
    }
}


