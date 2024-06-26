package com.example.thionline.service.logic.excel;

import com.example.thionline.model.CategoryQuestion;
import com.example.thionline.model.Question;
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

public class QuestionUpload {


    public static boolean isValidExcelFile(MultipartFile file){

        String content = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

        return Objects.equals(file.getContentType(), content);
    }

    public static List<Question> getFromExcel(InputStream inputStream){

        List<Question> questions = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("question");
            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex ==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Question question = new Question();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 : {
                            if (cell.getCellType() == CellType.STRING) {
                                question.setContent(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        case 1 : {
                            if (cell.getCellType() == CellType.STRING) {
                                question.setAnswer1(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        case 2 : {
                            if (cell.getCellType() == CellType.STRING) {
                                question.setAnswer2(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        case 3 : {
                            if (cell.getCellType() == CellType.STRING) {
                                question.setAnswer3(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        case 4 : {
                            if (cell.getCellType() == CellType.STRING) {
                                question.setAnswer4(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        case 5: {
                            if (cell.getCellType() == CellType.STRING) {
                                question.setNote(cell.getStringCellValue());
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
                questions.add(question);
            }
        } catch (IOException e) {

            System.out.println("Error upload service!!!");

            e.getStackTrace();
        }
        return questions;
    }
}
