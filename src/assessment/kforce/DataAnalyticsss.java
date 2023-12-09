package assessment.kforce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataAnalyticsss {

    public static void main(String[] args) {
        int totalCustomers = 0;
        boolean skipHead = true;
        Map<String, Integer> customerByCity = new HashMap<>();
        Map<String, Integer> customerByCountry = new HashMap<>();
        Map<String, Integer> contryontract = new HashMap<>();
        Set<String> uNcities = new HashSet<>();
        String line = "";
        String splitBY = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\abenitrust\\Documents\\JavaPlayGround\\Exams\\src\\main\\java\\Kforce\\data2.csv"));
            while ((line = br.readLine()) != null) {
                String data[] = line.split(splitBY);
                System.out.println(data[0]);
                if (skipHead) {
                    skipHead = false;
                }
//                continue;
                totalCustomers++;
                customerByCity.put(data[2], customerByCity.getOrDefault(data[2], 0) + 1);
                customerByCountry.put(data[3], customerByCountry.getOrDefault(data[3], 0) + 1);
                contryontract.put(data[3], contryontract.getOrDefault(data[3], 0) + Integer.parseInt((data[6]).trim()));
                uNcities.add(data[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total customers:\n" + totalCustomers);
        List<String> cities = new ArrayList<>(customerByCity.keySet());
        Collections.sort(cities);
        System.out.println("Customers by city:");
        for (String city : cities) {
            System.out.println(city + ": " + customerByCity.get(city));
        }

        List<String> countries = new ArrayList<>(customerByCountry.keySet());
        Collections.sort(countries);
        System.out.println("Customers by country:");
        for (String country : countries) {
            System.out.println(country + ": " + customerByCountry.get(country));
        }

        int large = Integer.MIN_VALUE;
        String country = "";
        System.out.println("Country with the largest number of customers' contracts:");
        for (String c : contryontract.keySet()) {
            if (contryontract.get(c) > large) {
                country = c;
                large = contryontract.get(c);
            }
        }

        System.out.println(country + " (" + large + " contracts)");
        System.out.println("Unique cities with at least one customer:");
        System.out.println(uNcities.size());
    }

}







