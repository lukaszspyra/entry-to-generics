package spyra.lukasz.comparison.homework;


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