package spyra.lukasz.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PreAcademyStudent implements Comparable<PreAcademyStudent>{

    int points;

    PreAcademyStudent(final int points) {
        this.points = points;
    }

    PreAcademyStudent() {
        this(0);
    }

    @Override
    public int compareTo(final PreAcademyStudent o) {

        return -Integer.compare(points, o.points);
    }

    public static void main(String[] args) {
        PreAcademyStudent s5 = new PreAcademyStudent(5);
        PreAcademyStudent s1 = new PreAcademyStudent(1);
        PreAcademyStudent s10 = new PreAcademyStudent(10);

        int compare5to6 = s5.compareTo(s1); //+1
        int compare1to10 = s1.compareTo(s10); //-1
        int compare10to10 = s10.compareTo(s10); //0

        System.out.println(compare5to6);
        System.out.println(compare1to10);
        System.out.println(compare10to10);

        List<PreAcademyStudent> students = new ArrayList<>();
        students.add(s5);
        students.add(s1);
        students.add(s10);

        System.out.println(students);

        //natural ordering due to Comparable interface
        Collections.sort(students);
        System.out.println(students);


        //reverse ordering with custom comparator
        students.sort(PreAcademyStudent::compareTo);

        System.out.println(students);
    }



    @Override
    public String toString() {
        return "PreAcademyStudent{" +
                "points=" + points +
                '}';
    }


    public static <E extends Comparable> void sortAnything(List<E> list) {
        for (int i = 0; i < list.size(); ++i) {
            int smallest = i;
            for (int j = i; j < list.size(); ++j) {
                if (list.get(smallest).compareTo(list.get(j)) > 0) {
                    smallest = j;
                }
            }
            E temp = list.get(i);
            list.set(i, list.get(smallest)); // move smallest to first index
            list.set(smallest, temp);
        }
    }

}
