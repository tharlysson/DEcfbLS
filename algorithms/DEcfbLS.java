package algorithms;

import org.jetbrains.annotations.NotNull;
import util.Solution;
import util.Function;
import algorithms.LocalSearch;

import java.util.ArrayList;

public class DEcfbLS extends Function {
    private int iterations, popSize, tWeakSize;
    private double min, max;
    private double[] o;
    private String problem;

    public DEcfbLS(String problem, int iterations, int tWeakSize, double min, double max, double[] o, int popSize) {
        this.problem = problem;
        this.iterations = iterations;
        this.o = o;
        this.popSize = popSize;
        this.min = min;
        this.max = max;
        this.tWeakSize = tWeakSize;
    }

    public void execute() {
        double P = 0.4;
        ArrayList<Solution> np = new ArrayList<>();
        ArrayList<Solution> npTemp = new ArrayList<>();

        // cria a população inicial e calcula o fitness
        for (int i = 0; i < this.popSize; i++) {
            Solution temp = new Solution(this.tWeakSize, this.min, this.max);
            fitness(this.problem, temp, this.o);
            np.add(temp);
        }

        // aplicar LS em 4 interações
        for (Solution pi : np) {
            LocalSearch temp = new LocalSearch(this.problem, pi, 4, this.o, P);
            npTemp.add(temp.execute());
        }

        np = npTemp;

        // laço principal
        for (int i = 0; i < this.iterations; i++) {
            for (Solution pi : np) {

            }
        }
    }

    public double fitness(String problem, Solution solution, double[] o) {
        switch (problem) {
            case "sphere":
                return this.sphere(solution, o);
        }

        return this.sphere(solution, o);
    }
}