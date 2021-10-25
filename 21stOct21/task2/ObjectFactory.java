package task2;

public class ObjectFactory {
    private FileUtil fileUtil;
    public FileUtil getFileUtil(){
        if(fileUtil==null){
            fileUtil=new FileUtil();
        }
        return fileUtil;

    }
}
