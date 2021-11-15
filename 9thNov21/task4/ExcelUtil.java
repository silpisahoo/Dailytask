package task4;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExcelUtil implements ExcelUtility {

    public List<Student> readJsonFile2Objects(String pathFile) throws IOException {
        String str= new String(Files.readAllBytes(Paths.get(pathFile)));
        System.out.println(str.replaceAll(",","\n"));
        List<Student> students = null;

        try {
            students = new ObjectMapper().readValue(str, new TypeReference<List<Student>>(){});
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void writeObjects2ExcelFile(List<Student> students, String filePath) throws IOException {
        String[] COLUMNs = {"Name", "Age", "Marks"};

        XSSFWorkbook workbook = new XSSFWorkbook();

        CreationHelper createHelper = workbook.getCreationHelper();

        XSSFSheet sheet = workbook.createSheet("new_student_records");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Row for Header
        XSSFRow headerRow = sheet.createRow(0);

        // Header
        for (int col = 0; col < COLUMNs.length; col++) {
            XSSFCell cell = headerRow.createCell(col);
            cell.setCellValue(COLUMNs[col]);
            cell.setCellStyle(headerCellStyle);
        }

        // CellStyle for Age
        CellStyle ageCellStyle = workbook.createCellStyle();
        ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

        int rowIdx = 1;
        for (Student student : students) {
            XSSFRow row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getAge());
            row.createCell(2).setCellValue(student.getMark());

        }

        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}

