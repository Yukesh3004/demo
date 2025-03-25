package Array;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Count_days_without_meetings { //leetcode no:3169

    public static int countDays(int days, int[][] meetings) {
        int today = 0;

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int i = meeting[0], j = meeting[1];

            if (j <= today) continue;
            else if (i > today) days -= j - i + 1;
            else days -= j - today;

            today = j;
        }

        return days;
    }

    public static void main(String[] args) {
        int result = countDays(10, new int[][]{{5,7},{1,3},{9,10}});
        System.out.println(result);
    }

}
