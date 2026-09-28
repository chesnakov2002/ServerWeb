package ru.academits.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>(Arrays.asList(
                new Person(20, "Ivan", "Petrov", "89131111111"),
                new Person(20, "Pavel", "Durov", "8913333333"),
                new Person(20, "Alex", "Vasin", "89137777777"),
                new Person(20, "Robin", "Good", "89138888888")));

        System.out.println(list);

        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellStyle(style);
        row0.getCell(0).setCellValue("Age");
        row0.createCell(1).setCellStyle(style);
        row0.getCell(1).setCellValue("Name");
        row0.createCell(2).setCellStyle(style);
        row0.getCell(2).setCellValue("Surname");
        row0.createCell(3).setCellStyle(style);
        row0.getCell(3).setCellValue("PhoneNumber");

        int currentRow = 1;

        for (Person person : list) {
            Row row = sheet.createRow(currentRow);
            Cell cell;

            row.createCell(0).setCellStyle(style);
            row.getCell(0).setCellValue(person.getAge());
            row.createCell(1).setCellStyle(style);
            row.getCell(1).setCellValue(person.getName());
            row.createCell(2).setCellStyle(style);
            row.getCell(2).setCellValue(person.getSurname());
            row.createCell(3).setCellStyle(style);
            row.getCell(3).setCellValue(person.getPhoneNumber());

            currentRow++;
        }

        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000);
        }

        try (OutputStream fileOut = new FileOutputStream("Excel.xlsx")) {
            wb.write(fileOut);
            System.out.println("Файл успешно сохранен");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
