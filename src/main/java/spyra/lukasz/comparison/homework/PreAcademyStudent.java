package spyra.lukasz.comparison.homework;

import java.util.Comparator;

record PreAcademyStudent(int quizPoints, int taskPoints, int activityPoints) implements Comparable<PreAcademyStudent> {

    @Override
    public int compareTo(final PreAcademyStudent o) {
        int totalThisPoints = quizPoints + taskPoints + activityPoints;
        int totalOtherPoints = o.quizPoints + o.taskPoints + o.activityPoints;
        return Integer.compare(totalThisPoints, totalOtherPoints);
    }

    @Override
    public String toString() {
        return "Student{" +
                "quizPoints=" + quizPoints +
                ", taskPoints=" + taskPoints +
                ", activityPoints=" + activityPoints +
                ", totalPoints=" + (quizPoints + taskPoints + activityPoints) +
                "}\n";
    }

}

class ActivityComparator implements Comparator<PreAcademyStudent> {
    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o1.activityPoints(), o2.activityPoints());
    }
}

class QuizComparator implements Comparator<PreAcademyStudent> {

    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o1.quizPoints(), o2.quizPoints());
    }
}

class TaskComparator implements Comparator<PreAcademyStudent> {

    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o1.taskPoints(), o2.taskPoints());
    }
}