class NeedForSpeed {

    public int speed, batteryDrain;
    public int distance = 0 ;
    public int battery = 100;
        
    NeedForSpeed(int speed, int batteryDrain) {
       this.speed = speed;
       this.batteryDrain = batteryDrain;
    
    }

    public boolean batteryDrained() {
      return battery < batteryDrain ;
    }

    public int distanceDriven() {
         return distance;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.distance += this.speed;
            this.battery -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    
    private int distance;
    
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        
        int maxDrives = car.battery / car.batteryDrain;
        int maxDistance = maxDrives * car.speed;
        
        return maxDistance >= this.distance;
    }
}
