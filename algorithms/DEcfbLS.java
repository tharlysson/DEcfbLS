package algorithms;

import util.Solution;
import util.Function;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.Arrays;

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

    public Solution execute() {
        double P = 0.4;
        double F = 0.7;

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
            int index = 0;
            for (Solution pi : np) {
                Solution mutant = mutant(np, F);
                Solution Xoff = exponentialCrossover(pi, mutant);

                if (Xoff.getResult() <= pi.getResult()) {
                    np.set(index, Xoff.clone());
                }
                index++;
            }

//            index = 0;
//            double avgPop = populationFitnessAverage(np);
//            for (Solution pi : np) {
//                if (pi.getResult() < avgPop) {
//                    LocalSearch temp = new LocalSearch(this.problem, pi, 40, this.o, P);
//                    np.set(index, temp.execute());
//                }
//                index++;
//            }
        }

        Solution best = np.get(0);
        for (Solution pi : np) {
            if (pi.getResult() <= best.getResult()) {
                best = pi.clone();
            }
        }

        return best;
    }

    private double populationFitnessAverage(ArrayList<Solution> population) {
        double total = 0.0;

        for (Solution pop : population) {
            total += pop.getResult();
        }

        return total / population.size();
    }

    private Solution exponentialCrossover(Solution current, Solution mutant) {
        Solution Xoff = current.clone();
        int n = this.tWeakSize;
        double Cr = 1 / Math.pow(2, 1.0 / ((n * 0.5) * 0.5));
        int j = (int) Math.round(n * Math.random());
        if (j == n) {
            j = n - 1;
        }

        double[] editXoff = Arrays.copyOf(Xoff.getSolution(), Xoff.getSolution().length);

        editXoff[j] = mutant.getSolution()[j];
        int k = 1;
        while (Math.random() <= Cr && k < n) {
            editXoff[j] = mutant.getSolution()[j];
            j = j + 1;
            if (j == n) {
                j = 1;
            }

            k = k + 1;
        }

        Xoff.setSolution(editXoff);
        ;
        fitness(this.problem, Xoff, this.o);

        return Xoff;
    }

    private Solution mutant(ArrayList<Solution> solutions, double F) {
        Solution r = solutions.get((int) (Math.random() * solutions.size()));
        Solution s = solutions.get((int) (Math.random() * solutions.size()));
        Solution t = solutions.get((int) (Math.random() * solutions.size()));

        Solution aux = r.clone();

        double[] editO = new double[this.tWeakSize];

        for (int i = 0; i < editO.length; i++) {
            editO[i] = t.getSolution()[i] + F * (r.getSolution()[i] - s.getSolution()[i]);
        }

        aux.setSolution(editO);
        fitness(this.problem, aux, this.o);

        return aux;
    }

    public double fitness(String problem, Solution solution, double[] o) {
        switch (problem) {
            case "sphere":
                return this.sphere(solution, o);
            case "rosenbroks":
                return this.rosenbroks(solution, o);
        }

        return this.sphere(solution, o);
    }
}