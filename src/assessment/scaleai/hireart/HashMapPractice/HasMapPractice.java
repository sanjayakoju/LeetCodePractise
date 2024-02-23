package assessment.scaleai.hireart.HashMapPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HasMapPractice {



    public static void main(String[] args) {

        TreeMap<Integer,String> newHashMap= new TreeMap<>();
        newHashMap.put(101,"Karna");
        newHashMap.put(102,"Anita");
        newHashMap.put(106,"Swasti");
        newHashMap.put(103,"Kamal");
        newHashMap.put(104,"Pooja");
        newHashMap.put(105,"Pawan");



        for(Map.Entry entry: newHashMap.entrySet()){

            if(entry.getKey().equals(101)){
                newHashMap.replace(101,"Akarnanita");

            }
                System.out.println(entry.getKey()+" "+ entry.getValue());
        }


        System.out.println(newHashMap.keySet());


    }
}
