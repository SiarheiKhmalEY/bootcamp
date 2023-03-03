import java.util.Arrays;
import java.util.Scanner;

public class DecileStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[1000];
        int count = 0;

        while (scanner.hasNextInt() && count < 1000) {
            int num = scanner.nextInt();
            if (num < 1 || num > 1000) {
                System.out.println("Invalid input: number must be between 1 and 1000");
                continue;
            }
            nums[count] = num;
            count++;
        }

        Arrays.sort(nums, 0, count);
        int decile3 = nums[count * 3 / 10];
        int decile6 = nums[count * 6 / 10];

        int count3 = 0;
        int count6 = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] <= decile3) {
                count3++;
            }
            if (nums[i] <= decile6) {
                count6++;
            }
        }

        System.out.println("3rd decile: " + decile3);
        System.out.println("Number of values at or below 3rd decile: " + count3);
        System.out.println("6th decile: " + decile6);
        System.out.println("Number of values at or below 6th decile: " + count6);
    }
}