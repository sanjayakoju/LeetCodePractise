package assessment.scaleai.hireart.HashMapPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListPractice {
    public static void main(String[] args) {
        List<String> stringList= new ArrayList<>();
        stringList.add("Karna");
        stringList.add("Anita");
        stringList.add("Kamal");
        stringList.add("Pooja");

        stringList.sort(Comparator.naturalOrder());
        System.out.println(stringList);

        stringList.sort(Comparator.reverseOrder());
        System.out.println(stringList);

        String [] arr= new String[stringList.size()];
        stringList.toArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
