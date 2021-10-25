package task2;

import java.io.IOException;

public interface FileUtility {
    void compareTextFiles(String filePath1,String filePath2) throws IOException;
    void writeIntoJson(String jsonFilePath, int countlinenum) throws IOException;




}
