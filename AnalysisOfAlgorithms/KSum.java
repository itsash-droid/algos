import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

    public List<List<Integer>> ksum(int [] inputArray, int k, int target) {
        Arrays.sort(inputArray);
        return ksumrecursion(inputArray, k, target, 0);
    }
    
    
    private List<List<Integer>> ksumrecursion(int [] inputArray, int k, int target, int startIndex) {
        List<List<Integer>> klist = null;
        if (k == 2) {
            TwoSum obj = new TwoSum();
            List<List<Integer>> val = obj.twosum(inputArray, target, startIndex);
            //System.out.println(val);

            return val;
        } 
        klist = new ArrayList<>();
        for (int i=startIndex; i<inputArray.length - k + 1; i++) {
            //System.out.println(i);
            List<List<Integer>> result = ksumrecursion(inputArray, k - 1, target - inputArray[i], i+1);
            if (result.size() > 0) {
                for (List<Integer> list : result) {
                    list.add(0, inputArray[i]);
                }

                klist.addAll(result);
            }

            while(i < inputArray.length - k + 1 && inputArray[i] == inputArray[i+1]) {
                i++;
            }
        }
        
        return klist;
    }

    private class TwoSum {

        private List<List<Integer>> twosum(int[] inputArray, int target, int startIndex) {
            int start = startIndex;
            int end = inputArray.length - 1;
            List<List<Integer>> result = new ArrayList<List<Integer>>();
    
            //System.out.println(start + " " + end + " " + target);
            while (start < end) {
                if (inputArray[start] + inputArray[end] < target) {
                    start++;
                } else if (inputArray[start] + inputArray[end] > target) {
                    end--;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(inputArray[start]);
                    temp.add(inputArray[end]);
                    result.add(temp);

                    start++;
                    end--;

                    while (start < end && inputArray[start - 1] == inputArray[start]) {
                        start++;
                    }

                    while (start < end && inputArray[end + 1] == inputArray[end]) {
                        end--;
                    }

                }
            }

            return result;
        }
    }

    public static void main (String args[]) {
        KSum obj = new KSum();
        System.out.println(obj.ksum(new int[]{1,0,-1,0,2,-2}, 3, 0));
    }
}
