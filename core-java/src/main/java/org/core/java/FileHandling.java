package org.core.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FileHandling {
    //patterns

    public static void main(String[] args) {
        new FileHandling().createNewFile();
    }

    private void createNewFile() {
        String content = readFile();

        //itearate over month
        int year = 2024; // Example year
        Month startingMonth = Month.APRIL; // Example month

        // Starting date
        LocalDate startDate = LocalDate.of(year, startingMonth, 1);

        // Iterate over the next 12 months
        for (int i = 0; i < 12; i++) {
            LocalDate currentDate = startDate.plusMonths(i);
            System.out.println(currentDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
            String output = updateContent(content, currentDate);
            System.out.println(output);
            writeToFile(output, currentDate);
        }

    }

    private static String readFile() {
        //read file
        String content = "";
        Path filePath = Paths.get("src/main/resources/input.html");
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            // Convert bytes to String (using UTF-8 encoding)
            content = new String(bytes, "UTF-8");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private void writeToFile(String htmlContent, LocalDate currentDate) {
        String name = currentDate.getMonth().name()+"_"+currentDate.getYear();
        Path filePath = Paths.get("target/"+name+".html");
        try {
            Files.write(filePath, htmlContent.getBytes());
            System.out.println("HTML file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String updateContent(String content, LocalDate currentDate) {
        String result = content;
        //

        return result;
    }


}



