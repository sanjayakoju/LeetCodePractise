package assessment.ford;

public class AddingTwoNumber {

    public static int addNumber(float a , float b) {
        float sum = a + b;
        return (int) Math.floor(sum);
    }

    public static void main(String[] args) {
        int result = AddingTwoNumber.addNumber(2.3f, 1.9f);
        System.out.println(result);
    }
}
