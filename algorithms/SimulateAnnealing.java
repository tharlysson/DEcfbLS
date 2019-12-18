package algorithms;

import util.Solution;
import util.Function;

public class SimulateAnnealing extends Function {

    private Solution solution;
    private int iterations;
    private double[] o;
    private String problem;

    public SimulateAnnealing(String problem, int iterations, int tWeakSize, double min, double max, double[] o){
        this.problem = problem;
        this.solution = new Solution(tWeakSize, min, max);
        this.iterations = iterations;
        this.o = o;
    }

    public Solution execute() {
        int t = 50000;
        Solution s = this.solution.clone();
        Solution best = s.clone();

        for(int i = 0; i < this.iterations; i++){
            Solution r = Solution.tWeak(s.clone());

            if (this.fitness(this.problem, r, this.o) < this.fitness(this.problem, s, this.o) || Math.random() > Math.exp((r.getResult() - s.getResult()) / t)) {
                s = r.clone();
            }
            t--;
            if (this.fitness(this.problem, s, this.o) < this.fitness(this.problem, best, this.o)) {
                best = s.clone();
            }

            if (t == 0) {
                t = 1;
            }
        }

        return best;
    }

}
