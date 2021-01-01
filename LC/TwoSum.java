import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private Map<Integer,Integer> map = new HashMap<>();
    
    public ArrayList<Integer> compute(int [] inputArray, int target, int startIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=startIndex;i<inputArray.length; i++) {
            if (map.containsKey(inputArray[i])) {
                result.add(map.get(inputArray[i]));
                result.add(i);
                return result;
            }

            map.put(target - inputArray[i], i);
        }
        return result;
    }

    private int[] pointerCompute(int [] inputArray, int target) {
        Arrays.sort(inputArray);
        int start = 0;
        int end = inputArray.length - 1;

        while (start < end) {
            if (inputArray[start] + inputArray[end] < target) {
                start++;
            } else if (inputArray[start] + inputArray[end] > target) {
                end--;
            } else {
                return new int[]{start, end};
            }
        }
        return new int[]{-1,-1};
        
    }

    public static void main(String args[]) {
        TwoSum obj = new TwoSum();
        ArrayList<Integer> res = obj.compute(new int[]{-30, 20, 10, -40, 50, 25, 15, -25}, 0 ,0);
        System.out.println(res.get(0) + " " + res.get(1));
        int[] output = obj.pointerCompute(new int[]{-30, 20, 10, -40, 50, 25, 15, -25}, 0); //how to maintain the original index?
        System.out.println(output[0] + " " + output[1]);
    }

}
