package spyra.lukasz.comparison.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static spyra.lukasz.comparison.homework.SortingType.*;

class Main {

    private static final Path READ_PATH = Paths.get("src/main/resources/CSVInput.csv");
    private static final String WRITE_PATH = "src/main/resources/saved/";
    private static final String FIRST_LINE = "studentName,quizzes,tasks,activity,total\n";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh-mm";
    private static final SortingType SORTING_TYPE = ACTIVITIES_DESC;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        DataReader dataReader = new DataReader(READ_PATH);
        StudentMapper studentMapper = new StudentMapper();

        List<PreAcademyStudent> preAcademyStudentsUnsorted = studentMapper.mapCSVDataToPreAcademyStudents(dataReader.readFromFile());
        List<PreAcademyStudent> preAcademyStudentsSorted = new ArrayList<>(main.sortListOfStudents(SORTING_TYPE, preAcademyStudentsUnsorted));

        DataWriter dataWriter = new DataWriter(FIRST_LINE, new File(createFileName()));
        dataWriter.writeToFile(studentMapper.mapPreAcademyStudentsToCSV(preAcademyStudentsSorted));
    }


    private static String createFileName() {
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
        return WRITE_PATH + localDateTime + " " + SORTING_TYPE + ".csv";
    }


    List<PreAcademyStudent> sortListOfStudents(SortingType sortingType, List<PreAcademyStudent> preAcademyStudents) {
        List<PreAcademyStudent> sorted = new ArrayList<>(preAcademyStudents);
        sorted.sort(sortingType.comparator());

        if (sortingType == TOTAL_DESC) {
            Collections.reverse(sorted);
        }
        return sorted;
    }


}
