package algorithms;

import util.Solution;
import util.Function;

import java.util.Arrays;

public class LocalSearch extends Function {
    private String problem;
    private Solution solution;
    private int iterations;
    private double P;
    private double[] o;


    public LocalSearch(String problem, Solution solution, int iterations, double[] o, double P) {
        this.problem = problem;
        this.solution = solution;
        this.iterations = iterations;
        this.P = P;
        this.o = o;
    }

    public Solution execute() {
        double P = this.P;
        Solution xe = this.solution.clone();

        for (int i = 0; i < this.iterations; i++) {
            Solution xt = xe.clone();
            Solution xs = xe.clone();

            double[] editXe = Arrays.copyOf(xe.getSolution(), xe.getSolution().length);
            double[] editXs;

            for (int j = 0; j < xe.getSolution().length; j++) {
                editXs = Arrays.copyOf(xs.getSolution(), xs.getSolution().length);
                editXs[j] = editXe[j] - P;

                xs.setSolution(editXs);

                if (fitness(this.problem, xs, this.o) <= fitness(this.problem, xt, this.o)) {
                    xt = xs.clone();
                } else {
                    editXs = Arrays.copyOf(xs.getSolution(), xs.getSolution().length);
                    editXs[j] = editXe[j] + (P / 2);

                    xs.setSolution(editXs);

                    if (fitness(this.problem, xs, this.o) <= fitness(this.problem, xt, this.o)) {
                        xt = xs.clone();
                    }
                }
            }

            if (fitness(this.problem, xt, this.o) <= fitness(this.problem, xe, this.o)) {
                xe = xt.clone();
            } else {
                P = P / 2;
            }
        }

        return xe;
    }

    public double fitness(String problem, Solution solution, double[] o) {
        switch (problem) {
            case "sphere":
                return this.sphere(solution, o);
        }

        return this.sphere(solution, o);
    }
}