import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

public class PeakFindingTest {

    private void isValidOneDSolution(int[] arr, int sol) {
        assertTrue(
                (sol==0 || arr[sol] >= arr[sol-1]) &&
                        (sol==arr.length-1 || arr[sol] >= arr[sol+1])
        );
    }

    private void isValidTwoDSolution(int[][] arr, int[] sol) {
        boolean valid = true;
        int value = arr[sol[0]][sol[1]];
        if (sol[0] != 0 && value < arr[sol[0]-1][sol[1]])
            valid = false;
        if (sol[0] != arr.length-1 && value < arr[sol[0]+1][sol[1]])
            valid = false;
        if (sol[1] != 0 && value < arr[sol[0]][sol[1]-1])
            valid = false;
        if (sol[1] != arr[0].length-1 && value < arr[sol[0]][sol[1]+1])
            valid = false;
        assertTrue(valid);
    }

    @Test
    public void OneDTest1() {
        int[] nums = new int[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = i;
        }
        isValidOneDSolution(nums,PeakFinding.findOneDPeak(nums));
    }

    @Test
    public void OneDTest2() {
        int[] nums = new int[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = 1;
        }
        isValidOneDSolution(nums,PeakFinding.findOneDPeak(nums));
    }

    @Test
    public void OneDTest3() {
        int[] nums = new int[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = -1 * Math.abs(i - 50) + 50;
        }
        isValidOneDSolution(nums,PeakFinding.findOneDPeak(nums));
    }

    @Test
    public void OneDTest4() {
        Random gen = new Random(2);
        int[] nums = new int[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = gen.nextInt();
        }
        isValidOneDSolution(nums,PeakFinding.findOneDPeak(nums));
    }

    @Test
    public void TwoDTest1() {
        int[][] nums = new int[100][100];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = i + j;
            }
        }
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest2() {
        int[][] nums = new int[100][100];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = 0;
            }
        }
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest3() {
        int[][] nums = new int[100][100];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = -1 * Math.abs(i - 50) - Math.abs(j - 50) + 100;
            }
        }
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest4() {
        int[][] nums = new int[100][100];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = Math.abs(i - 50) + Math.abs(j - 50);
            }
        }
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest5() {
        int[][] nums = {
                {0, 0, 9, 8, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest6() {
        Random gen = new Random(1);
        int[][] nums = new int[90][110];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = gen.nextInt() % 1000;
            }
        }
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest7() {
        int[][] nums = {
                {1, 2, 6, 5, 3, 6, 7},
                {1, 2, 5, 4, 3, 6, 7},
                {1, 2, 5, 4, 3, 6, 7},
                {1, 2, 3, 4, 3, 6, 7},
                {1, 2, 5, 4, 3, 6, 7},
                {1, 2, 5, 4, 3, 6, 7},
                {1, 2, 5, 4, 3, 6, 7},
        };
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }

    @Test
    public void TwoDTest8() {
        int[][] nums = new int[100][100];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = i + j;
            }
        }
        for (int i = 0; i < 50; i++) {
            int y = ThreadLocalRandom.current().nextInt(100);
            int x = ThreadLocalRandom.current().nextInt(100);
            nums[y][x] = ThreadLocalRandom.current().nextInt(201);
        }
        isValidTwoDSolution(nums, PeakFinding.findTwoDPeak(nums));
    }
}
