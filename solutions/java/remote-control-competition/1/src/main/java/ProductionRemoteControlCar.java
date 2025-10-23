class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distance = 0;
    private int numberOfVictories;

    
    @Override
    public void drive() {
       distance +=  10;
    }
    @Override
    public int getDistanceTravelled() {
       return distance;
    }

    public int getNumberOfVictories() {
       return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

     @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(other.numberOfVictories, this.numberOfVictories);
    }

    @Override
    public String toString() {
        return "ProductionCar{" + "victories=" + numberOfVictories + ", distance=" + distance + '}';
    }
}
