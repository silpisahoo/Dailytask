package task1;

import java.io.IOException;

public class UniqueStringRunner {
    public static void main(String[] args) throws IOException {
        ObjectFactory obj = new ObjectFactory();
        RandomGenerator randomGenerator=obj.getRandomGenerator();
        randomGenerator.generateUniqueStrings(229,"C:\\task1\\output.txt");
    }

}
