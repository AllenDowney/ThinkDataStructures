import java.util.Map;
import java.util.HashMap;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        // TODO
        return 0;
    }

    private static int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
