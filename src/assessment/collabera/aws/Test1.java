package assessment.collabera.aws;

import java.util.List;

/**
 * Note:
 * If multiple nodes have the same absolute difference with respect to K, select the smallest node value.
 * Input
 * In this problem, the method can take one of the following signatures, based on tie programming language chosen for solving the problem:
 * 1. C/Python - findMAD(root node, k)
 * 2. C++/Java - findMAD(k), where the root node is present as a member of the method's class
 * A tree node has been defined and has the following:
 * 1. A "data" part
 * 2. A reference to the left child
 * 3. A reference to the right child
 * Output
 * The output will be the value of the node with the minimum absolute difference with regard to K.  Note:
 * If multiple nodes have the same absolute difference with respect to K, select the smallest node value.
 * Input
 * In this problem, the method can take one of the following signatures, based on the programming language chosen for solving the problem:
 * 1. C/Python - findMAD(root node, k)
 * 2. C++/Java - findMAD(k), where the root node is present as a member of the method's class
 * A tree node has been defined and has the following:
 * 1. A "data" part
 * 2. A reference to the left child
 * 3. A reference to the right child
 * Output
 * The output will be the value of the node with the minimum absolute difference with regard to K.
 * Constraints
 * 1 ＜=N <= 200
 * Example #1
 * Input
 * Minimize ---give solution in java
 */
public class Test1 {

    //     Function to find the node with the minimum absolute difference with regard to K
    private static int findMAD(List<Integer> ar, int k) {
        // Initialize variables to store the minimum difference and the result node value
        int[] result = {Integer.MAX_VALUE, -1};

        // Iterate through the list and update the result
        for (int value : ar) {
            int currentDiff = Math.abs(value - k);
            if (currentDiff < result[0] || (currentDiff == result[0] && value < result[1])) {
                result[0] = currentDiff;
                result[1] = value;
            }
        }

        return result[1];
    }


    public static void main(String args[]) {

//    BufferedReader bufferedReader;
//    BufferedWriter bufferedWriter = new BufferedReader(new InputStreamReader(System.in));
//
//    bufferedWriter write("\n");
//
//    BufferedWriter(new FileWriter(System.getProperty"OUTPUT_FILE_PATH"))
//    bufferedWriter.close;
//    bufferedWriter =new
//
//    BufferedWriter(new FileWriter(System.getProperty"OUTPUT_FILE_PATH"), true));
//    int arCount = Int & ger.parseInt(bufferedReader.readLine(.trim);
//    List<Integer>
//            ar = new ArrayListsO;
//    String artempItems = bufferedReader.readLine(.replaceAll |\s+$", ""). split"");
//            for(
//    int i
//            = 0;
//    i<arCount;i++)
//
//    {
//        int arItem
//        ar.add(ar Item);
//=Integer parseInt (artempItems[11);
//    }
//
//    int K = Integer.parseInt(bufferedReader.readLine().trim);
//    int outcome = Outcome, solve(ar,K);
//
//    bufferedWriter write(outcome +
//            バ”）；
//            bufferedWriter, newline);
//
//    bufferedReader,close);
    }
}
