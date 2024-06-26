package com.example.thionline.service.logic.excel;

import com.example.thionline.model.Exam;
import com.example.thionline.model.Result;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExamUpload {

    public static boolean isValidExcelFile(MultipartFile file){

        String content = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

        return Objects.equals(file.getContentType(), content);
    }

    public static List<Exam> getFromExcel(InputStream inputStream){

        List<Exam> exams = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("exam");
            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex ==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Exam exam = new Exam();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 : {
                            if (cell.getCellType() == CellType.STRING) {
                                exam.setName(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        case 1 : {
                            if (cell.getCellType() == CellType.STRING) {
                                exam.setDescription(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        default :{
                            break;
                        }
                    }
                    cellIndex++;
                }
                exams.add(exam);
            }
        } catch (IOException e) {

            System.out.println("Error upload service!!!");

            e.getStackTrace();
        }
        return exams;
    }
}
