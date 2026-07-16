class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
           int n = asteroids.length;
           Arrays.sort(asteroids);
           long currMass = mass;
          for(int i=0;i<n;i++){
            if(currMass>=asteroids[i]){
                currMass+=asteroids[i];
            }
            else if(currMass<asteroids[i]){
                return false;
            }
          }
          return true;
    }     
}