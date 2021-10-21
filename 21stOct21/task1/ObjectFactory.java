package task1;

public class ObjectFactory {
    private RandomGenerator randomGenerator;
    public RandomGenerator getRandomGenerator(){
        if(randomGenerator==null){
            randomGenerator = new RandomGenerator();
        }
        return randomGenerator;
    }
}
