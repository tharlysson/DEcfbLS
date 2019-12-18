package algorithms;

import util.Solution;
import util.Function;

public class HillClimbing extends Function {
    
    private Solution solution;
	private int iterations;
	private double[] o;
	private String problem;
	
	public HillClimbing(String problem, int iterations, int tWeakSize, double min, double max, double[] o){
		this.problem = problem;
		this.solution = new Solution(tWeakSize, min, max);
		this.iterations = iterations;
		this.o = o;
    }
    
    public Solution execute() {
		fitness(this.problem, this.solution, this.o);
		for(int i = 0; i < this.iterations; i++){
			Solution newSolution = Solution.tWeak(this.solution);
			
			if(fitness(this.problem, newSolution, this.o) < this.solution.getResult()){
				this.solution.setSolution(newSolution.getSolution()); 
				this.solution.setResult(newSolution.getResult());
				this.solution.setLastPosition(i);
			}
		}
		
		return this.solution;
	}
}