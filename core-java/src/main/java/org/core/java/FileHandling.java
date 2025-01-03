package org.core.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Random;

public class FileHandling {
    //patterns

    public static void main(String[] args) {
        new FileHandling().createNewFile();
    }

    private void createNewFile() {
        String content = readFile();

        //itearate over month
        int year = 2024; // Example year
        Month startingMonth = Month.OCTOBER; // Example month

        // Starting date
        LocalDate startDate = LocalDate.of(year, startingMonth, 1);

        // Iterate over the next 12 months
        for (int i = 0; i < 3; i++) {
            LocalDate currentDate = startDate.plusMonths(i);
            String output = updateContent(content, currentDate);
            writeToFile(output, currentDate);
            System.out.println(currentDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
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
        //Invoice No. : TG-B1-55655509
        Random random = new Random();
        int randomNumber = 10000000 + random.nextInt(90000000);
        result = result.replace("TG-B1-55655509", "TG-B1-"+randomNumber);
        //Billing period: <text>Sep, </text>2021
        String month = currentDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int year = currentDate.getYear();
        result = result.replace("<text>Sep, </text>2021", "<text>"+month+", </text>"+year);
        //invoice date: 01/09/2021
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String startOfMonth = currentDate.withDayOfMonth(1).format(formatter);
        result = result.replaceAll("01/09/2021", startOfMonth);
        //due date : 10/09/2021
        String tenthDay = currentDate.withDayOfMonth(10).format(formatter);
        result = result.replaceAll("10/09/2021", tenthDay);
        // invoice todate: 30/09/2021
        String lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth()).format(formatter);
        result = result.replaceAll("30/09/2021", lastDayOfMonth);
        //days : >30<text> days</text>
        int days = currentDate.lengthOfMonth();
        result = result.replace(">30<text> days</text>", ">"+days+"<text> days</text>");
        //ref number: P1-33845719
        int randRef = 10000000 + random.nextInt(90000000);
        result = result.replace("P1-33845719", "P1-"+ randRef);
        // txn date: 17/08/2021
        String lastMonthTenth = currentDate.minusMonths(1).withDayOfMonth(10).format(formatter);
        result = result.replaceAll("17/08/2021", lastMonthTenth);
        return result;
    }


}



