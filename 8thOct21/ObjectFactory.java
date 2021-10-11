package gof;

public class ObjectFactory {
    Utility util;

    //singleton pattern
    public Utility getUtil(){
        if(util==null){
            util=new Utility();
        }
        return util;

    }
}
