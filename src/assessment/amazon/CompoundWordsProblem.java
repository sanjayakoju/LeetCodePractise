package assessment.amazon;

import java.util.*;

public class CompoundWordsProblem {

        public static void main(String[] args) {
            List<String> words = Arrays.asList("cloudwatch", "cloud", "watch", "rockstar", "rock", "star");

            Map<String, List<String>> compoundWords = findCompoundWords(words);

            for (Map.Entry<String, List<String>> entry : compoundWords.entrySet()) {
                String word = entry.getKey();
                List<String> components = entry.getValue();
                System.out.println(word + " -> " + String.join(", ", components));
            }
        }

        public static Map<String, List<String>> findCompoundWords(List<String> words) {
            Set<String> wordSet = new HashSet<>(words);
            Map<String, List<String>> compoundWords = new HashMap<>();

            for (String word : words) {
                for (int i = 1; i < word.length(); i++) {
                    String firstPart = word.substring(0, i);
                    String secondPart = word.substring(i);

                    if (wordSet.contains(firstPart) && wordSet.contains(secondPart)) {
                        if (!compoundWords.containsKey(word)) {
                            compoundWords.put(word, new ArrayList<>());
                        }
                        compoundWords.get(word).add(firstPart);
                        compoundWords.get(word).add(secondPart);
                        break;
                    }
                }
            }

            return compoundWords;
        }
    }
