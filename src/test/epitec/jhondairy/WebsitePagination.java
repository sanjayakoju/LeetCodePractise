package test.epitec.jhondairy;

import java.util.*;

public class WebsitePagination {

    public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, Integer> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {

        // Create a list of item names
        List<String> itemNames = new ArrayList<>(items.keySet());

        // Sort the item names based on the given sort parameter and sort order
        Comparator<String> comparator = (a, b) -> {
            int compareResult = items.get(a).compareTo(items.get(b));
            return sortOrder == 0 ? compareResult : -compareResult;
        };
        itemNames.sort(comparator);

        // Calculate the start and end index for the current page
        int startIndex = (pageNumber - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, numOfItems);

        // Return the items for the current page
        return itemNames.subList(startIndex, endIndex);
    }

    // ALL TEST CASE PASS
    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParamter, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        List<String> result = new ArrayList<>();
        if (items == null || items.isEmpty()) {
            return result;
        }
        Collections.sort(items, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (sortParameter == 0) {
                    return sortOrder == 0 ? o1.get(0).compareTo(o2.get(0)) : o2.get(0).compareTo(o1.get(0));
                } else if (sortParameter == 1) {
                    return sortOrder == 0 ? Integer.valueOf(o1.get(1)).compareTo(Integer.valueOf(o2.get(1))) :
                            Integer.valueOf(o2.get(1)).compareTo(Integer.valueOf(o1.get(1)));
                } else {
                    return sortOrder == 0 ? Integer.valueOf(o1.get(2)).compareTo(Integer.valueOf(o2.get(2))) :
                            Integer.valueOf(o2.get(2)).compareTo(Integer.valueOf(o1.get(2)));
                }
            }
        });
        int start = pageNumber * itemsPerPage;
        int end = Math.min(start + itemsPerPage, items.size());
        for (int i = start; i < end; i++) {
            result.add(items.get(i).get(0));
        }
        return result;
    }
}
