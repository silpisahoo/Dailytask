package task4;

import java.io.IOException;
import java.util.List;

public class StudentRunner {
        public static void main(String[] args) throws IOException {

            ObjectFactory obj = new ObjectFactory();

            ExcelUtil excelUtil=obj.getExcelUtil();
            // Step 1: Read JSON File to List Objects
            List<Student> students  = excelUtil.readJsonFile2Objects(System.getProperty("user.dir")+"\\data\\output.json");

            // Step 2: Convert Java List Objects to JSON File
            excelUtil.writeObjects2ExcelFile(students, System.getProperty("user.dir")+"\\data\\student1.xlsx");
       }
}
