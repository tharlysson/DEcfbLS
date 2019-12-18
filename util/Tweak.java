package util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Tweak {

	public static Solution tWeak(Solution solution){
		
		int randomPosition = (int) (Math.random() * solution.getSolution().length);
		double randomValue = ThreadLocalRandom.current().nextDouble(Solution.min, Solution.max + 1);
		double[] copySolution = Arrays.copyOf(solution.getSolution(), solution.getSolution().length); 
		
		copySolution[randomPosition] = randomValue;
		
		Solution solution2 = new Solution(solution.getSolution().length, Solution.min, Solution.max);
		solution2.setSolution(copySolution);
		
		return solution2;
    }

	public static Solution tWeak2(Solution solution){

		double val = 0.1 * (Math.random() > 0.5 ? 1 : -1);

		int randomPosition = (int) (Math.random() * solution.getSolution().length);
		double[] copySolution = Arrays.copyOf(solution.getSolution(), solution.getSolution().length);

		if(copySolution[randomPosition] + val <= Solution.max && copySolution[randomPosition] + val >= Solution.min)
			copySolution[randomPosition] += val;

		Solution solution2 = new Solution(solution.getSolution().length, Solution.min, Solution.max);
		solution2.setSolution(copySolution);

		solution2.setChangedPosition(randomPosition);
		solution2.setChangedValue(val);

		return solution2;
	}
}