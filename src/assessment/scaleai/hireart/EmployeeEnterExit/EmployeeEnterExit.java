package assessment.scaleai.hireart.EmployeeEnterExit;

import java.util.*;

public class EmployeeEnterExit {

    public static List<List<String>> listOfEmployees(String[][] records) {
        List<List<String>> result = new ArrayList<>();
        List<String> exitRecords = new ArrayList<>();
        List<String> entryRecords = new ArrayList<>();
        Set<String> recordChecker = new HashSet<>();
        for (String s[] : records) {
            String name = s[0];
            String status = s[1];

            if (status.equals("enter")) {
                if (recordChecker.contains(name)) {
                    entryRecords.add(name);
                    exitRecords.remove(name);
                }
                else {
                    entryRecords.add(name);
                    recordChecker.add(name);
                }
            } else if (status.equals("exit")) {
                if(recordChecker.contains(name)){
                    entryRecords.remove(name);
                    recordChecker.remove(name);
                }
                else{
                    exitRecords.add(name);
                }

            }
        }
        result.add(removeDuplicates(entryRecords));
        result.add(removeDuplicates(exitRecords));
        return result;
    }

    public static List<String> removeDuplicates(List<String> duplicateStrings){
        List<String> nonDuplicateString= new ArrayList<>();
        for(String s: duplicateStrings){
            if(!nonDuplicateString.contains(s)){
                nonDuplicateString.add(s);
            }
        }
        return nonDuplicateString;
    }

    public static void main(String[] args) {
        String[][] records = {


                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"}

        };
String[][] records1={
        {"Paul", "enter"},
        {"Paul", "exit"}
};

String[][] records2={
        {"Paul", "enter"},
        {"Paul", "enter"},
        {"Paul", "exit"},
        {"Paul", "exit"}
};

        String[][] records3={
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj","enter"}
        };



        System.out.println(listOfEmployees(records));
         System.out.println(listOfEmployees(records1));
       System.out.println(listOfEmployees(records2));
      System.out.println(listOfEmployees(records3));
    }
}
