package assessment.scaleai.hireart.PasswordChecker;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {


//    Write code in JAVA with comments in each line. Also give
//    Time and Space Complexity of the solutionYou are working on en authentication systen and
//    there is a set of rules the users have to tollon then packing a nex password
//    : 
//    1. It has to be at least 16 characters long.
//    2.The password cannot contain the word "password".This rule is not case-sensitive.
//    3. The same character cannot be used more than 4 times. This role is case-sensitive, "n" and "N" are different characters.
//    4. The password has to contain at least one uppercase and one lowarcase Litter.
//    5. The password has to contain at least one of the follering special characters*
//
//10 Write a function that takes in a password and returns a collection of any rule natters that are not met.
//    password_1 = "Strongpwd9999sabe"
//    password 2 • *Less105"	* ||
//    password.3 • "Passworde"
//    password_4 = *#Passiord011111112222223x	** [1,2]|
//    password_5 = password#1111111	• (2,3)
//    password_6 * "asaapasswordSS"	1> (2,3,4)
//    password_7 • "LESS105*	=> [1,2,3,4,5]
//            => [1,4)
//    password.8 • "SsSSSt#passMord"	=> [1,2)
//    password.9 • "SaSStfpasslordpassword"	=> (2,3]


    public  static List<Integer> notMatchedRules(String password){

        List<Integer> notMatchedrules= new ArrayList<>();

        //Rule1
        if(password.length()<16)
            notMatchedrules.add(1);
        //Rule2
        if(password.toLowerCase().contains("password"))
            notMatchedrules.add(2);
        //Rule3
        if(samecharacterUsedMorethan4Times(password))
            notMatchedrules.add(3);

        //Rule 4
        if(!upperCaseUsed(password) && !lowerCaseUsed(password)){
            notMatchedrules.add(4);
        }

        //Rule 5
        if(isSpecialCharacterUsed(password)){
            notMatchedrules.add(5);
        }


        return notMatchedrules;
    }

    public static void main(String[] args) {

        String password="Strongpwd9999sabe";
        String password1="#Passiord011111112222223x";
        String password2="asaapasswordss";
        System.out.println(notMatchedRules(password));
        System.out.println(notMatchedRules(password1));
        System.out.println(notMatchedRules(password2));
    }

    public static boolean samecharacterUsedMorethan4Times(String password){
        int count=0;
        for(int i=0;i<password.length()-1;i++)
        {
            if(password.charAt(i)==password.charAt(i+1))
            {
                count++;
            }
        }

        if(count>=4){
            return true;
        }
        return false;
    }

    public static boolean upperCaseUsed(String password){
        for(int i=0;i<password.length();i++)
        {
            if(Character.isUpperCase(password.charAt(i)))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean lowerCaseUsed(String password){
        for(int i=0;i<password.length();i++)
        {
            if(Character.isLowerCase(password.charAt(i)))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isSpecialCharacterUsed(String password){
        for(int i=0;i<password.length();i++)
        {
            if(password.charAt(i)== '*' || password.charAt(i)=='%'){
                return true;
            }

        }
        return false;
    }
}
