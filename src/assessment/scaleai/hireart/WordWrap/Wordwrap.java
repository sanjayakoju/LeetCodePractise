package assessment.scaleai.hireart.WordWrap;

import java.util.ArrayList;
import java.util.List;

public class Wordwrap {

    public static List<String> wrapLines(String [] words, int wrapLength) {
        List<String> wrappedLines= new ArrayList<>();
        List<String> tempList= new ArrayList<>();
        int currentLength=0;
       for(String word:words) {
           if (currentLength+word.length() <= wrapLength) {
               tempList.add(word);

               currentLength = currentLength + word.length() + 1;
           }
       else{
                wrappedLines.add(String.join("-",tempList));
                tempList=new ArrayList<>();
                tempList.add(word);
                currentLength=word.length()+1;
           }
       }

       if(!tempList.isEmpty()){
           wrappedLines.add(String.join("-",tempList)); 
       }
       return wrappedLines;
    }
    public static void main(String[] args) {
        String[] words1 = {"The","day","began","as","still","as","the","night","abruptly","lighted","with","brilliant","flame"};
        String[] words2 = {"Hello"};
        String[] words3 = {"Hello", "Hello"};
        String[] words4 = {"Well", "Hello", "world"};
        String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
        String[] words6 = {"a", "b", "c", "d"};

        System.out.println(wrapLines(words1,13));
    }
}
