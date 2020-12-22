package spyra.lukasz.comparison.homework;

import java.util.Comparator;

record PreAcademyStudent(String name, int quizPoints, int taskPoints, int activityPoints) implements Comparable<PreAcademyStudent> {

    public int totalPoints(){
        return quizPoints + taskPoints + activityPoints;
    }

    @Override
    public int compareTo(final PreAcademyStudent o) {
        int totalThisPoints = totalPoints();
        int totalOtherPoints = o.totalPoints();
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

class ActivityAscComparator implements Comparator<PreAcademyStudent> {
    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o1.activityPoints(), o2.activityPoints());
    }
}

class ActivityDescComparator implements Comparator<PreAcademyStudent> {
    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o2.activityPoints(), o1.activityPoints());
    }
}

class QuizAscComparator implements Comparator<PreAcademyStudent> {

    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o1.quizPoints(), o2.quizPoints());
    }
}

class QuizDescComparator implements Comparator<PreAcademyStudent> {

    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o2.quizPoints(), o1.quizPoints());
    }
}

class TaskAscComparator implements Comparator<PreAcademyStudent> {

    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o1.taskPoints(), o2.taskPoints());
    }
}

class TaskDescComparator implements Comparator<PreAcademyStudent> {

    @Override
    public int compare(final PreAcademyStudent o1, final PreAcademyStudent o2) {
        return Integer.compare(o2.taskPoints(), o1.taskPoints());
    }
}