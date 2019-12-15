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
}