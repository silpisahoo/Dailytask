package task4;



public class ObjectFactory {
    private ExcelUtil excelUtil;

    public ExcelUtil getExcelUtil(){
        if(excelUtil==null){
            excelUtil = new ExcelUtil();
        }
        return excelUtil;
    }
}
