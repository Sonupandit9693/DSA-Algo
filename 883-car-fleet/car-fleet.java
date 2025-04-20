class Solution {
    class Car{
        int position;
        double time;
        Car(int p, double t){
            this.position = p;
            this.time = t;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car cars [] = new Car[n];

        for(int i=0; i<n; i++){
            cars[i] = new Car(position[i], (double) (target - position[i]) / (speed[i]));
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(a.position, b.position)); // in Assending Order

        int car_fleet = 0;
        int t = n-1;

        while( t > 0){
            if(cars[t].time < cars[t-1].time){
                car_fleet ++;
            }else{
                cars[t-1] = cars[t];
            }

            t--;
        }

        return car_fleet + (t == 0 ? 1: 0);
    }
}