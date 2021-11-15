package task4;

import java.io.IOException;
import java.util.List;

public interface ExcelUtility {
    void writeObjects2ExcelFile(List<Student> students, String filePath) throws IOException;
    List<Student> readJsonFile2Objects(String pathFile) throws IOException;
}
