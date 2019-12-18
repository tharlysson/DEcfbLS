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
        quality(this.problem, this.solution, this.o); 
		for(int i = 0; i < this.iterations; i++){
			Solution newSolution = Solution.tWeak(this.solution);
			
			if(quality(this.problem, newSolution, this.o) < this.solution.getResult()){
				this.solution.setSolution(newSolution.getSolution()); 
				this.solution.setResult(newSolution.getResult());
				this.solution.setLastPosition(i);
			}
		}
		
		return this.solution;
	}
	
	public double quality(String problem, Solution solution, double[] o) {
		switch (problem) {
			case "sphere":
				return this.sphere(solution, o);
			case "rosenbroks":
				return this.rosenbroks(solution, o);
			case "schaffersF7":
				return this.schaffersF7(solution, o);
		}

		return this.sphere(solution, o);
	}
}