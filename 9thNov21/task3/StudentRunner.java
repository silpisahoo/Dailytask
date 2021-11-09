package task3;

import task3.ObjectFactory;

import java.io.IOException;
import java.util.List;

public class StudentRunner {
    public static void main(String[] args) throws IOException{
        ObjectFactory obj = new ObjectFactory();
        ExcelUtil excelUtil=obj.getExcelUtil();
        List<Student> studentList=excelUtil.readExcelFile("C:\\Users\\silpi.sahoo\\IdeaProjects\\TestProject\\data\\Student data.xlsx");
        excelUtil.writeObjects2JsonFile(studentList,"C:\\Users\\silpi.sahoo\\IdeaProjects\\TestProject\\data\\output.json");
    }

}
