package algorithms;

import util.Solution;
import util.Function;

public class HillClimbing extends Function {
    
    private Solution solution;
	private int numAvaliation;
	private double[] o;
	
	public HillClimbing(int numAvaliation, int tWeakSize, double min, double max, double[] o){
		this.solution = new Solution(tWeakSize, min, max);
		this.numAvaliation = numAvaliation;
		this.o = o;
    }
    
    public Solution execute() {
        quality(this.solution, this.o); 
		for(int i = 0; i < this.numAvaliation; i++){
			Solution newSolution = Solution.tWeak(this.solution);
			
			if(quality(newSolution, this.o) < this.solution.getResult()){
				this.solution.setSolution(newSolution.getSolution()); 
				this.solution.setResult(newSolution.getResult());
				this.solution.setLastPosition(i);
			}
		}
		
		return this.solution;
	}
	
	public double quality(Solution solution, double[] o) {
		return this.sphere(solution, o);
	}
}