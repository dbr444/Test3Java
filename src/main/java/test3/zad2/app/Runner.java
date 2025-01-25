package test3.zad2.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        //MONDAY=61
        //TUESDAY=46
        //WEDNESDAY=20
        //THURSDAY=39
        //FRIDAY=79
        //SATURDAY=88
        //SUNDAY=10 tak to wyglada:)
        List<File> myJavaFiles = new ArrayList<>();

        findJavaFiles(new File("C:\\Users\\Dawid\\IdeaProjects"), myJavaFiles);

            myJavaFiles.stream()
                    .collect(Collectors.groupingBy(x -> getDayOfWeekFromFile(x), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(System.out::println);

    }
    static void findJavaFiles(File directory, List<File> javaFilesList) {
        if (!directory.isDirectory()) {
            throw new RuntimeException();
        }
        File[] filesArray = directory.listFiles();
        for (File f : filesArray) {
            if (f.isDirectory()) {
                findJavaFiles(f, javaFilesList);
            } else if (f.getName().endsWith(".java")) {
                javaFilesList.add(f);
            }
        }
    }

    private static DayOfWeek getDayOfWeekFromFile(File file) {
        DayOfWeek dayOfWeek = null;

        Path filePath = Paths.get(file.getAbsolutePath());
        try {
            BasicFileAttributes fileAttrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(fileAttrs.creationTime().toInstant(), ZoneId.systemDefault());
            dayOfWeek = localDateTime.getDayOfWeek();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dayOfWeek;
    }
}

