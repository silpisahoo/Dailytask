package task2;

import java.io.IOException;

public class CompareTextFileRunner {
    public static void main(String[] args) throws IOException {
        ObjectFactory obj = new ObjectFactory();
        FileUtil fileUtil = obj.getFileUtil();
        fileUtil.compareTextFiles("C:\\task2\\output1.txt","C:\\task2\\output2.txt");

    }
}
