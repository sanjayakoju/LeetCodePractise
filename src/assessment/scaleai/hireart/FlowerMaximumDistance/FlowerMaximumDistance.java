package assessment.scaleai.hireart.FlowerMaximumDistance;

import java.util.HashMap;
import java.util.Map;

public class FlowerMaximumDistance {
    public static int maxDistance(String [] garden){
        Map<String,Integer> mapofGarden=new HashMap<>();
        int i=0;
        int maxDistance=-1;
        for(String s: garden){

            if(mapofGarden.containsKey(s)){
                int difference= i-mapofGarden.get(s);
                if(maxDistance<difference)
                    maxDistance=difference;
                i++;
                continue;
            }
            mapofGarden.put(s,i);
            i++;

        }
        return maxDistance;
    }


    public static void main(String[] args) {



        String[] garden1={"Ivy", "Rue" , "Ivy" ,"Yen"  ,"Rue","Dock", "Iras", "Rue" , "Lay"};
        String[] garden2={"Rose"};
        System.out.println(maxDistance(garden1));
        System.out.println(maxDistance(garden2));
    }
}
