package task3;

import java.io.IOException;
import java.util.List;

public interface ExcelUtility {
    public List readExcelFile(String filePath);
    public  void writeObjects2JsonFile(List students, String pathFile);

}
