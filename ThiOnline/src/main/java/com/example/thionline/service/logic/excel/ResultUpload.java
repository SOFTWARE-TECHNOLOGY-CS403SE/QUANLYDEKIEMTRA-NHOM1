package com.example.thionline.service.logic.excel;

import com.example.thionline.model.Question;
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

public class ResultUpload {


    public static boolean isValidExcelFile(MultipartFile file){

        String content = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

        return Objects.equals(file.getContentType(), content);
    }

    public static List<Result> getFromExcel(InputStream inputStream){

        List<Result> results = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("result");
            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex ==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Result result = new Result();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 : {
                            if (cell.getCellType() == CellType.STRING) {
                                result.setCorrect_answer(cell.getStringCellValue());
                            } else {
                                System.out.println("Not string");
                            }
                        }
                        break;
                        case 1 : {
                            if (cell.getCellType() == CellType.STRING) {
                                result.setNote(cell.getStringCellValue());
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
                results.add(result);
            }
        } catch (IOException e) {

            System.out.println("Error upload service!!!");

            e.getStackTrace();
        }
        return results;
    }
}
