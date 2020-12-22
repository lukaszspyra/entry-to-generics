package spyra.lukasz.comparison.homework;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Test(groups = "SortingTests")
public class PreAcademyStudentTest {


    @Test(dataProvider = "unsortedLists")
    void shallSortPreAcademyStudentsByTotalPointsASC(List<PreAcademyStudent> students) {
        //given
        Object[] expectedSorting = new PreAcademyStudent[]{
                new PreAcademyStudent("Student5", 5, 6, 6),
                new PreAcademyStudent("Student4", 15, 7, 4),
                new PreAcademyStudent("Student2", 25, 4, 3),
                new PreAcademyStudent("Student3", 20, 9, 5),
                new PreAcademyStudent("Student1", 30, 10, 2),
        };

        //when
        Collections.sort(students);
        Object[] resultSorting = students.toArray();

        //then
        assertEquals(expectedSorting, resultSorting, "List shall be sorted by total points but it is not");
    }


    @Test(dataProvider = "unsortedLists")
    void shallSortPreAcademyStudentsByQuizPointsASC(List<PreAcademyStudent> students) {
        //given
        Object[] expectedSorting = new PreAcademyStudent[]{
                new PreAcademyStudent("Student5", 5, 6, 6),
                new PreAcademyStudent("Student4", 15, 7, 4),
                new PreAcademyStudent("Student3", 20, 9, 5),
                new PreAcademyStudent("Student2", 25, 4, 3),
                new PreAcademyStudent("Student1", 30, 10, 2),
        };
        Comparator<PreAcademyStudent> comparator = SortingType.QUIZZES_ASC.comparator();

        //when
        students.sort(comparator);
        Object[] resultSorting = students.toArray();

        //then
        assertEquals(expectedSorting, resultSorting, "List shall be sorted by quiz points but it is not");
    }


    @Test(dataProvider = "unsortedLists")
    void shallSortPreAcademyStudentsByTaskPointsASC(List<PreAcademyStudent> students) {
        //given
        Object[] expectedSorting = new PreAcademyStudent[]{
                new PreAcademyStudent("Student2", 25, 4, 3),
                new PreAcademyStudent("Student5", 5, 6, 6),
                new PreAcademyStudent("Student4", 15, 7, 4),
                new PreAcademyStudent("Student3", 20, 9, 5),
                new PreAcademyStudent("Student1", 30, 10, 2),
        };
        Comparator<PreAcademyStudent> comparator = SortingType.TASKS_ASC.comparator();

        //when
        students.sort(comparator);
        Object[] resultSorting = students.toArray();

        //then
        assertEquals(expectedSorting, resultSorting, "List shall be sorted by task points but it is not");
    }

    @Test(dataProvider = "unsortedLists")
    void shallSortPreAcademyStudentsByActivityPointsASC(List<PreAcademyStudent> students) {
        //given
        Object[] expectedSorting = new PreAcademyStudent[]{
                new PreAcademyStudent("Student1", 30, 10, 2),
                new PreAcademyStudent("Student2", 25, 4, 3),
                new PreAcademyStudent("Student4", 15, 7, 4),
                new PreAcademyStudent("Student3", 20, 9, 5),
                new PreAcademyStudent("Student5", 5, 6, 6),
        };
        Comparator<PreAcademyStudent> comparator = SortingType.ACTIVITIES_ASC.comparator();

        //when
        students.sort(comparator);
        Object[] resultSorting = students.toArray();

        //then
        assertEquals(expectedSorting, resultSorting, "List shall be sorted by activity points but it is not");
    }

    @DataProvider()
    public static Object[] unsortedLists() {
        PreAcademyStudent student1 = new PreAcademyStudent("Student1", 30, 10, 2);    //total 42
        PreAcademyStudent student2 = new PreAcademyStudent("Student2", 25, 4, 3);     //total 33
        PreAcademyStudent student3 = new PreAcademyStudent("Student3", 20, 9, 5);     //total 34
        PreAcademyStudent student4 = new PreAcademyStudent("Student4", 15, 7, 4);     //total 26
        PreAcademyStudent student5 = new PreAcademyStudent("Student5",5, 6, 6);      //total 17

        List<PreAcademyStudent> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student2);
        studentList1.add(student3);
        studentList1.add(student4);
        studentList1.add(student5);

        List<PreAcademyStudent> studentList2 = new ArrayList<>(studentList1);
        List<PreAcademyStudent> studentList3 = new ArrayList<>(studentList1);

        Collections.shuffle(studentList1);
        Collections.shuffle(studentList2);
        Collections.shuffle(studentList3);

        return new Object[]{studentList1, studentList2, studentList3};
    }
}