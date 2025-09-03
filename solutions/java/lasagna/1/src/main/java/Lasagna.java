public class Lasagna {

    private static final int EXPECTED_OVEN_TIME = 40;
    private static final int PREP_TIME_PER_LAYER = 2;
    
    public int expectedMinutesInOven() {
        return EXPECTED_OVEN_TIME;
    }
   
    public int remainingMinutesInOven(int mintsInOven) {
        return expectedMinutesInOven() - mintsInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers*PREP_TIME_PER_LAYER; 
    }
    
    public int totalTimeInMinutes(int numberOfLayers, int mintsInOven) {                   return preparationTimeInMinutes(numberOfLayers) + mintsInOven;
    }
}
