package assessment.kforce;

import java.util.HashSet;
import java.util.Set;

public class VowelConsonant {
    public static int solution (String pattern, String source){
        int count = 0;
        int l = 0;
        int r = source.length();

        while(r-l>=pattern.length()){
            count+=match(pattern,source.substring(l,l+pattern.length()));
            l++;
        }
        return count;
    }

    public static int match(String pattern, String source){

        if(pattern.length()!=pattern.length()){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('y');

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < source.length(); i++){

            if(set.contains(source.charAt(i)) ){
                stringBuilder.append("0");
            }
            else {
                stringBuilder.append("1");
            }
        }
        return pattern.equals(stringBuilder.toString())?1:0;
    }

    public static void main(String[] args) {
        String pattern = "010";
        String source = "amazing";
        System.out.println(solution(pattern,source));
    }
}
