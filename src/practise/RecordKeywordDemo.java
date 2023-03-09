package practise;

import java.util.Arrays;

public class RecordKeywordDemo {

    private String name;
    private String mobile;

    public record RecordKeywordDemos(String name, String mobile) {
        public String skills(String... skills) {
            StringBuilder sb = new StringBuilder("My name is " + name + " and my skills include: ");
            Arrays.stream(skills).forEach(skill -> sb.append(skill).append(", "));
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
    }

    public RecordKeywordDemo(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String skills(String... skills) {
        StringBuilder sb = new StringBuilder("My name is " + name + " and my skills include: ");
        Arrays.stream(skills).forEach(skill -> sb.append(skill).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }



    public static void main(String[] args) {
        practise.RecordKeywordDemo me = new practise.RecordKeywordDemo("Merhatsidk", "6418192555");
        String mobile1 = me.mobile;
        System.out.println(me.skills("Java", "SpringBoot", "Kafka", "Jenkins", "AWS"));
        // Output: "My name is Merhatsidk and my skills include: Java, SpringBoot, Kafka, Jenkins, AWS"
    }

}
