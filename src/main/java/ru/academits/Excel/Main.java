package ru.academits.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>(Arrays.asList(
                new Person(20, "Ivan", "Petrov", "89131111111"),
                new Person(20, "Ivan", "Petrov", "89131111111"),
                new Person(20, "Ivan", "Petrov", "89131111111"),
                new Person(20, "Ivan", "Petrov", "89131111111")));

        System.out.println(list);

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("Age");
        row0.createCell(1).setCellValue("Name");
        row0.createCell(2).setCellValue("Surname");
        row0.createCell(3).setCellValue("Phone number");

        int currentRow = 1;
        Row row = sheet.createRow(currentRow);
        int currentPerson = 0;
        Person person = list.get(currentPerson);

        for (Person e : list) {
            row.createCell(0).setCellValue(person.getAge());
            row.createCell(1).setCellValue(person.getName());
            row.createCell(2).setCellValue(person.getSurname());
            row.createCell(3).setCellValue(person.getPhoneNumber());
            row = sheet.createRow(currentRow++);
            person = list.get(currentPerson++);
        }


    }
}
