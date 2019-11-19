import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] nums = new int[5];

        ArrayDeque queue = new ArrayDeque();



        for (int i = 0; i < nums.length; i++) {
             nums[i] = i+1;
             queue.push(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {

            System.out.print(queue.pop()+" ");
        }



//        for (int i = 0; i < nums.length/2; i++) {
//           vr = nums[i];
//            nums[i] = nums[nums.length-i-1];
//            nums[nums.length-i-1]=vr;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]+" ");
//
//        }
    }
}
