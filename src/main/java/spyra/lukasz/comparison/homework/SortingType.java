package spyra.lukasz.comparison.homework;


import java.util.Comparator;

public enum SortingType {

    TOTAL_DESC(null),
    TOTAL_ASC(null),
    QUIZZES_ASC(new QuizAscComparator()),
    QUIZZES_DESC(new QuizDescComparator()),
    TASKS_ASC(new TaskAscComparator()),
    TASKS_DESC(new TaskDescComparator()),
    ACTIVITIES_ASC(new ActivityAscComparator()),
    ACTIVITIES_DESC(new ActivityDescComparator()),
    ;

    private final Comparator<PreAcademyStudent> comparator;

    SortingType(final Comparator<PreAcademyStudent> comparator) {
        this.comparator = comparator;
    }

    Comparator<PreAcademyStudent> comparator(){
        return comparator;
    }
}
