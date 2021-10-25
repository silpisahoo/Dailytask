package task2;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil implements FileUtility {
    @Override
    public void compareTextFiles(String filePath1,String filePath2) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        int countlinenum=1;
        int countWords=0;
        while (line1!=null || line2!=null){
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if (! line1.equals(line2)){
                areEqual = false;
                break;
            }
            countWords=countWords+line1.split(" ").length;
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            countlinenum++;
        }
        if(areEqual)
        {
            System.out.println("Two files have same content.");
            System.out.println("Count of words = "+countWords);
            writeIntoJson("C:\\task2\\output.json",countWords);
        }
        else
        {
            System.out.println("Two files have different content. They differ at line "+countlinenum);

            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+countlinenum);
        }

        reader1.close();

        reader2.close();


    }
    @Override
    public void writeIntoJson(String jsonFilePath, int countlinenum) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("Number of words", countlinenum);
        FileWriter file = new FileWriter(jsonFilePath);
        file.write(obj.toJSONString());
        file.flush();
        file.close();
    }


}
