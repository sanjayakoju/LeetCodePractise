package assessment.kforce;//package test.kforce;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.io.*;
//import java.util.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//
//public class GeographicalObjects {
//
//
//    // Main class should be named 'Solution'
//        public static void main(String[] args) {
//
//            try {
//                URL url = new URL("http://localhost/maxResponsePatchSize");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                connection.setRequestProperty("accept", "application/json");
//
//                InputStream responStream = connection.getInputStream();
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode node = mapper.readTree(responStream);
//                var maxResponsePatchSize = node.get("K");
//
//                url = new URL("http://localhost/borders");
//
//                connection = (HttpURLConnection) url.openConnection();
//
//                connection.setRequestProperty("accept", "application/json");
//
//                InputStream borderStream = connection.getInputStream();
//                JsonNode borderNode = mapper.readTree(borderStream);
//
//                var x_min = borderNode.get("x_min");
//                var x_max = borderNode.get("x_max");
//                var y_min = borderNode.get("y_min");
//                var y_max = borderNode.get("y_max");
//
//                String requestParam = "http://localhost/map?x_from=" + x_min + "&y_from=" + y_min + "&x_to=" + x_max + "&y_to=" + y_max;
//
//                url = new URL(requestParam);
//
//                connection = (HttpURLConnection) url.openConnection();
//
//                connection.setRequestProperty("accept", "application/json");
//
//                InputStream result = connection.getInputStream();
//                JsonNode resultNode = mapper.readTree(result);
//                int largeArea = 0;
//                var finalResult = "";
//
//                for (JsonNode n : resultNode) {
//                    int area = n.get("area") != null ? n.get("area").intValue() : 0;
//                    if (largeArea < area) {
//                        finalResult = n.get("name").toString();
//                        largeArea = area;
//                    }
//                }
//
//
//                System.out.println(finalResult.replace("\"", ""));
//
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        }
//
//}
