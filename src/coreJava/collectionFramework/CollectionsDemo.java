package coreJava.collectionFramework;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsDemo {

    public static void main(String[] args) {

        Integer arr[] = {1,2,3};
        List<Integer> li = new ArrayList<>(Arrays.asList(arr));
        Integer a[] = li.toArray(new Integer[0]);
        Collections.reverse(li);

        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,"Hello");
        concurrentHashMap.put(2,"Hello");

        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            concurrentHashMap.remove(1); // Does not throw exception (Fail Safe)
            it.remove();
            it.next();
        }
        System.out.println(concurrentHashMap);

        Stack<String> stack = new Stack<>();
        stack.push("Sanjaya");
        stack.push("Susan");
        stack.push("Dina");
        stack.search("Sanjaya");

        Map<Integer,String> map = new HashMap<>();
        map.keySet();

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1, "Hello");
        hashtable.put(2,"Hell");
        Iterator iterator = hashtable.entrySet().iterator();
        while (iterator.hasNext()) {
//            hashtable.remove(1); // java.util.ConcurrentModificationException (fail fast)
            hashtable.put(3, "D");
            iterator.next();
        }
        System.out.println(hashtable);

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("Bye");
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            list.remove("hello"); // java.util.ConcurrentModificationException
            itr.next();
        }
        System.out.println(list.toString());

        Map<Student, Integer> st = new HashMap<>();
    }
}
