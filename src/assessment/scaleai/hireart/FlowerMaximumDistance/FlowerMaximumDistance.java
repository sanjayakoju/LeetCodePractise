package assessment.scaleai.hireart.FlowerMaximumDistance;

import java.util.HashMap;
import java.util.Map;

public class FlowerMaximumDistance {
    public static int maxDistance(String [] garden){

        Map<String,Integer> mapofGarden = new HashMap<>();
        int i=0;
        int maxDistance=-1;

        for(String flower: garden){

            if(mapofGarden.containsKey(flower)){
                int difference= i - mapofGarden.get(flower);
                if(maxDistance<difference)
                    maxDistance=difference;
                i++;
                continue;
            }
            mapofGarden.put(flower,i);
            i++;
        }

        System.out.println(mapofGarden);
        return maxDistance;
    }


    public static void main(String[] args) {
        String[] garden1={"Ivy", "Rue" , "Ivy" ,"Yen"  ,"Rue","Dock", "Iras", "Rue" , "Lay"};
        String[] garden2={"Rose"};
        System.out.println(maxDistance(garden1));
        System.out.println(maxDistance(garden2));
    }
}
