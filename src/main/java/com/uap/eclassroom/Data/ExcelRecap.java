package com.uap.eclassroom.Data;

import com.uap.eclassroom.Data.DataManage;
import com.uap.eclassroom.Data.Mahasiswa;
import com.uap.eclassroom.Data.Presence;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRecap {

    public static void exportPresenceToExcel(String filePath) {
        Workbook workbook = new XSSFWorkbook();

        for (Presence presence : DataManage.presence) {
            String meeting = presence.getMeeting();
            String date = presence.getDate();

            Sheet sheet = workbook.createSheet("Meeting " + meeting);

            Row headerRow = sheet.createRow(0);
            String[] headers = {"Name", "NIM", "Presence", "Permission Letter"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            int rowIndex = 1;
            for (Mahasiswa mahasiswa : DataManage.mahasiswa) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(mahasiswa.getName());
                row.createCell(1).setCellValue(mahasiswa.getNIM());

                String presenceStatus = mahasiswa.getPresence().size() > Integer.parseInt(meeting) - 1
                        ? mahasiswa.getPresence().get(Integer.parseInt(meeting) - 1)
                        : "No Data";
                row.createCell(2).setCellValue(presenceStatus);

                String permissionLetter = mahasiswa.getPermissionLetter().size() > Integer.parseInt(meeting) - 1
                        && mahasiswa.getPermissionLetter().get(Integer.parseInt(meeting) - 1) != null
                        ? "Uploaded"
                        : "Not Uploaded";
                row.createCell(3).setCellValue(permissionLetter);
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
            System.out.println("Exported successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void exportGradesToExcel(String filePath) {
        Workbook workbook = new XSSFWorkbook();

        for (Classwork classwork : DataManage.classwork) {
            String title = classwork.getTitle();
            String description = classwork.getDescription();
            String deadline = classwork.getDeadline();

            String sanitizedTitle = title.replaceAll("[\\\\/:*?\"<>|]", "_");
            Sheet sheet = workbook.createSheet(sanitizedTitle);

            Row headerRow = sheet.createRow(0);
            String[] headers = {"Name", "NIM", "Grade", "Status"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            int rowIndex = 1;
            for (Mahasiswa mahasiswa : DataManage.mahasiswa) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(mahasiswa.getName());
                row.createCell(1).setCellValue(mahasiswa.getNIM());

                int index = DataManage.classwork.indexOf(classwork);
                String status = "Not Submitted";
                double grade = 0.0;

                if (mahasiswa.getGrade().size() > index && mahasiswa.getGrade().get(index) != null && mahasiswa.getGrade().get(index) > 0) {
                    grade = mahasiswa.getGrade().get(index);
                    status = "Submitted";
                }

                row.createCell(2).setCellValue(grade);
                row.createCell(3).setCellValue(status);
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
            System.out.println("Exported successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "presence_data.xlsx";
        exportPresenceToExcel(filePath);
    }
}
