package task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil implements ExcelUtility {

        public  List readExcelFile(String filePath){
            try {
                FileInputStream excelFile = new FileInputStream(new File(filePath));
                XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

                XSSFSheet sheet = workbook.getSheet("Student_record");
                Iterator rows = sheet.iterator();

                List lstStudent = new ArrayList();

                int rowNumber = 0;
                while (rows.hasNext()) {
                    XSSFRow row = (XSSFRow) rows.next();

                    // skip header
                    if(rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }

                    Iterator cellsInRow = row.iterator();

                    Student student = new Student();

                    int cellIndex = 0;
                    while (cellsInRow.hasNext()) {
                        XSSFCell cell  = (XSSFCell) cellsInRow.next();

                        if(cellIndex==0) { // ID
                            student.setName(String.valueOf(cell.getStringCellValue()));
                        } else if(cellIndex==1) { // Name
                            student.setAge((int)cell.getNumericCellValue());
                        } else if(cellIndex==2) { // Address
                            student.setMark((int)cell.getNumericCellValue());
                        }

                        cellIndex++;
                    }
                    System.out.println(student.toString());
                    lstStudent.add(student);
                }

                // Close WorkBook
                workbook.close();

                return lstStudent;
            } catch (IOException e) {
                throw new RuntimeException("FAIL! -> message = " + e.getMessage());
            }
        }

        public  void writeObjects2JsonFile(List students, String pathFile) {
            ObjectMapper mapper = new ObjectMapper();

            File file = new File(pathFile);
            try {
                // Serialize Java object info JSON file.
                mapper.writeValue(file, students);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



