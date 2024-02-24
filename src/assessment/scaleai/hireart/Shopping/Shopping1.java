package assessment.scaleai.hireart.Shopping;

import java.util.*;

public class Shopping1 {
    public static int shopping(String[][] products, String[] shoppingList) {

        Map<String,String> productMap= new HashMap<>();
        for(String [] product: products){
            String item= product[0] ;
            String department=product[1];
            productMap.put(item,department);
        }

        int needTovisit=0;

        Set<String> visitedDepartment= new HashSet<>();
        String lastvisitedDepartment=null;

        for(String itemToPurchase: shoppingList) {
            if(productMap.containsKey(itemToPurchase)){
                visitedDepartment.add(productMap.get(itemToPurchase));
            }

            if(!productMap.get(itemToPurchase).equals(lastvisitedDepartment)){
                needTovisit++;
            }
            lastvisitedDepartment = productMap.get(itemToPurchase);
        }
        return needTovisit - visitedDepartment.size() ;

    }


    public static void main(String[] args) {
        String[][] products = {
                {"Cheese", "Dairy"},
                {"Carrots", "Produce"},
                {"Potatoes", "Produce"},
                {"Canned Tuna", "Pantry"},
                {"Romaine Lettuce", "Produce"},
                {"Chocolate Milk", "Dairy"},
                {"Flour", "Pantry"},
                {"Iceberg Lettuce", "Produce"},
                {"Coffee", "Pantry"},
                {"Pasta", "Pantry"},
                {"Milk", "Dairy"},
                {"Blueberries", "Produce"},
                {"Pasta Sauce", "Pantry"}
        };

        String[] list1 = {"Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"};
        String[] list2 = {"Blueberries", "Carrots", "Coffee", "Milk", "Flour", "Cheese"};
        String[] list3 = {"Blueberries", "Carrots", "Romaine Lettuce", "Iceberg Lettuce"};
        String[] list4 = {"Milk", "Flour", "Chocolate Milk", "Pasta Sauce"};
        String[] list5 = {"Cheese", "Potatoes", "Blueberries", "Canned Tuna"};

        System.out.println(shopping(products,list1));
        System.out.println(shopping(products,list2));
        System.out.println(shopping(products,list3));
        System.out.println(shopping(products,list4));
        System.out.println(shopping(products,list5));
    }
}
