package spyra.lukasz.comparison.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DataReader {

    private final Path path;

    DataReader(final Path path) {
        this.path = path;
    }

    public List<String> readFromFile() throws IOException {
        Stream<String> lines = Files.lines(path);
        List<String> data = lines.collect(Collectors.toList());
        lines.close();
        return data;
    }

}

class StudentMapper {

    public List<PreAcademyStudent> mapCSVDataToPreAcademyStudents(List<String> listOfLines) {
        listOfLines.remove(0);
        return listOfLines.stream()
                .map(e -> e.split(","))
                .map(e -> new PreAcademyStudent(e[0], Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3])))
                .collect(Collectors.toList());
    }

    public List<String> mapPreAcademyStudentsToCSV(List<PreAcademyStudent> preAcademyStudents) {

        List<String> collect = preAcademyStudents.stream()
                .map(e -> new StringBuilder()
                        .append(e.name())
                        .append(",")
                        .append(e.quizPoints())
                        .append(",")
                        .append(e.taskPoints())
                        .append(",")
                        .append(e.activityPoints())
                        .append(",")
                        .append(e.totalPoints())
                        .append("\n")
                        .toString())
                .collect(Collectors.toList());

        return collect;
    }
}

class DataWriter {

    private final String firstRow;
    private final File file;

    DataWriter(final String firstRow, final File file) {
        this.firstRow = firstRow;
        this.file = file;
    }

    public List<String> writeToFile(List<String> listOfLines) {

        try (java.io.FileWriter fileWriter = new java.io.FileWriter(file)) {
            fileWriter.append(firstRow);


            listOfLines.forEach(e -> {
                try {
                    fileWriter.append(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } catch (IOException ioException) {
            System.err.println("Failed to save data to file");
        }

        return listOfLines;
    }


}
