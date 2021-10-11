package gof;

import java.util.Random;
import java.util.Scanner;

public class Random_Number {
    public static void main(String[] args){
        //using the factory method-

        ObjectFactory objFactory=new ObjectFactory();
        //Builder DP
        objFactory.getUtil().guessRandomNumber();

    }


}
