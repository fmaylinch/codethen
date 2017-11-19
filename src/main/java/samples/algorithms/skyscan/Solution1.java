package samples.algorithms.skyscan;

import java.util.*;

public class Solution1 {

	public static void main(String args[] ) throws Exception {
        
        Scanner sky = new Scanner("1\nSidney");
        int n = Integer.parseInt( sky.nextLine() );
        
        Map<String, Integer> counts = new HashMap<>();

        String maxDestination = null;
        int maxCount = 0;

		for (int i = 0; i < n; i++) {
			String destination = sky.nextLine();
			int count = counts.merge(destination, 1, (a, b) -> a + b);
			if (count > maxCount) {
				maxCount = count;
				maxDestination = destination;
			}
		}

		System.out.println(maxDestination);

	}
}