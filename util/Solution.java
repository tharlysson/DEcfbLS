package util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Solution extends Tweak{
    private double[] solution;
    public static double min, max;
    private int lastPosition;
	private int changedPosition;
	private double changedValue;
    private double result;

    public Solution(int size, double min, double max) {
        this.solution = new double[size];
		Solution.min = min;
        Solution.max = max;
        
        for(int i = 0; i < size; i++){
			double value = ThreadLocalRandom.current().nextDouble(min, max + 1);
			this.solution[i] = value;
		}
    }

    public Solution clone(){						
		Solution clone = new Solution(this.solution.length, Solution.min, Solution.max);
		clone.setSolution(this.solution);
		clone.setLastPosition(this.lastPosition);
		clone.setResult(this.result);
		clone.setChangedPosition(this.changedPosition);
		clone.setChangedValue(this.changedValue);
		
		return clone;
	}

    public double[] getSolution(){
		return this.solution;
    }
    
    public void setSolution(double[] solution){
		this.solution = Arrays.copyOf(solution, solution.length);
	}
	
	public void setResult(double result){
		this.result = result;
	}
	
	public double getResult(){
		return this.result;
	}

	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public int getChangedPosition() {
		return changedPosition;
	}

	public void setChangedPosition(int changedPosition) {
		this.changedPosition = changedPosition;
	}

	public double getChangedValue() {
		return changedValue;
	}

	public void setChangedValue(double changedValue) {
		this.changedValue = changedValue;
	}
	
}