import algorithms.*;
import util.Solution;

public class Main {
    public static void main(String[] args) {
        int executions = 20;
        int iterations = 100000;
        int tWeakSize = 30;
        double min = -100;
        double max = 100;
        String problem = "schaffersF7"; // [sphere, rosenbroks, schaffersF7]
        int popSize = 30;

        double[] o = new double[tWeakSize];

        for (int i = 0; i < executions; i++) {

//            DEcfbLS meta = new DEcfbLS(problem, iterations, tWeakSize, min, max, o, popSize);
            HillClimbing meta = new HillClimbing(problem, iterations, tWeakSize, min, max, o);

            Solution result = meta.execute();
            System.out.println(result.getResult());
        }
    }
}