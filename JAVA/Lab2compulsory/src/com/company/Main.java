/**
 *@author  Turcu Ana-Maria
 * @author Vararu Cristian
 * @version 1.0
 * @since   03.06.2019
 */
package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Student s1 = new Student("S1", 2);
        Student s2 = new Student("S2", 2);
        Student s3 = new Student("S3", 3);
        Student s4 = new Student("S4", 1);
        Student s5 = new Student("S5", 3);
        Student s6 = new Student("S6", 3);
        Student s7 = new Student("S7", 3);
        Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        Application a2 = new Application("A2", LocalDate.of(2019, Month.MARCH,2), Language.JAVA);
        Application a3 = new Application("A3", LocalDate.of(2019, Month.MARCH,15), Language.PYTHON);
        Application a4 = new Application("A3", LocalDate.of(2019, Month.MARCH,15), Language.PYTHON);
        Essay e1 = new Essay("E1", LocalDate.parse("2019-06-01"), Topic.ALGORITHMS);
        Essay e2 = new Essay("E2", LocalDate.parse("2019-07-01"), Topic.WEB);
        s1.setPreferences(a1, a2, a3);
        s2.setPreferences(a1, e1);
        s3.setPreferences(a2, a3, e1 );
        s4.setPreferences(a3, e2);
        s6.setPreferences(e1);
        s7.setPreferences(e1);
        Problem problem=new Problem();
        problem.setStudents(s1,s2,s3,s4,s6);
        System.out.println(problem);
        System.out.println(a4.equals(a1));
        List<Project> projects=new ArrayList<Project>();
        projects=problem.getProjects();
        for ( Project project : projects)
            System.out.println(project);
        List<Allocation> allocations=  new ArrayList<Allocation>();
        allocations=problem.solveProblem();
        for( Allocation rep: allocations)
            System.out.println(rep);
        System.out.println("");
        allocations=problem.maximumSolveProblem();
        for( Allocation rep: allocations)
            System.out.println(rep);
        Problem problem2=new Problem();
        problem2.setStudents(s1,s2,s3,s4,s6,s7);
        System.out.println(problem2.hallsTheorem());
    }
}
