package spyra.lukasz.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreAcademyStudentLecture implements Comparable<PreAcademyStudentLecture>{

    int points;

    PreAcademyStudentLecture(final int points) {
        this.points = points;
    }

    PreAcademyStudentLecture() {
        this(0);
    }

    @Override
    public int compareTo(final PreAcademyStudentLecture o) {

        return -Integer.compare(points, o.points);
    }

    public static void main(String[] args) {
        PreAcademyStudentLecture s5 = new PreAcademyStudentLecture(5);
        PreAcademyStudentLecture s1 = new PreAcademyStudentLecture(1);
        PreAcademyStudentLecture s10 = new PreAcademyStudentLecture(10);

        int compare5to6 = s5.compareTo(s1); //+1
        int compare1to10 = s1.compareTo(s10); //-1
        int compare10to10 = s10.compareTo(s10); //0

        System.out.println(compare5to6);
        System.out.println(compare1to10);
        System.out.println(compare10to10);

        List<PreAcademyStudentLecture> students = new ArrayList<>();
        students.add(s5);
        students.add(s1);
        students.add(s10);

        System.out.println(students);

        //natural ordering due to Comparable interface
        Collections.sort(students);
        System.out.println(students);


        //reverse ordering with custom comparator
        students.sort(PreAcademyStudentLecture::compareTo);

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
