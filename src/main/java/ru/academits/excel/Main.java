package ru.academits.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        List<Person> persons = Arrays.asList(
                new Person(20, "Ivan", "Petrov", "89131111111"),
                new Person(20, "Pavel", "Durov", "8913333333"),
                new Person(20, "Alex", "Vasin", "89137777777"),
                new Person(20, "Robin", "Good", "89138888888"));

        try (Workbook wb = new XSSFWorkbook()) {
            wb.getCreationHelper();
            Sheet sheet = wb.createSheet("Persons");

            CellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);

            style.setBorderBottom(BorderStyle.THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

            style.setBorderTop(BorderStyle.THIN);
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());

            style.setBorderRight(BorderStyle.THIN);
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());

            style.setBorderLeft(BorderStyle.THIN);
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

            Row headerRow = sheet.createRow(0);

            headerRow.createCell(0).setCellStyle(style);
            headerRow.getCell(0).setCellValue("Age");

            headerRow.createCell(1).setCellStyle(style);
            headerRow.getCell(1).setCellValue("Name");

            headerRow.createCell(2).setCellStyle(style);
            headerRow.getCell(2).setCellValue("Surname");

            headerRow.createCell(3).setCellStyle(style);
            headerRow.getCell(3).setCellValue("PhoneNumber");

            int currentRowNumber = 1;

            for (Person person : persons) {
                Row row = sheet.createRow(currentRowNumber);

                row.createCell(0).setCellStyle(style);
                row.getCell(0).setCellValue(person.getAge());
                row.createCell(1).setCellStyle(style);
                row.getCell(1).setCellValue(person.getName());
                row.createCell(2).setCellStyle(style);
                row.getCell(2).setCellValue(person.getSurname());
                row.createCell(3).setCellStyle(style);
                row.getCell(3).setCellValue(person.getPhoneNumber());

                currentRowNumber++;
            }

            final int COLUMN_COUNT = 4;

            for (int i = 0; i < COLUMN_COUNT; i++) {
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000);
            }

            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("Excel.xlsx"))) {
                wb.write(outputStream);
                System.out.println("Файл успешно сохранен");
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении файла");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом Excel");
        }
    }
}