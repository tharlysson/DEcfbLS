import algorithms.*;
import util.Solution;

public class Main {
    public static void main(String[] args) {
        int executions = 1;
        int iterations = 100000;
        int tWeakSize = 5;
        double min = -100;
        double max = 100;
        String problem = "sphere";
        int popSize = 2;

        double[] o = new double[tWeakSize];

        for (int i = 0; i < executions; i++) {

            DEcfbLS meta = new DEcfbLS(problem, iterations, tWeakSize, min, max, o, popSize);
            meta.execute();

//            HillClimbing meta = new HillClimbing(problem, iterations, tWeakSize, min, max, o);
//
//            Solution result = meta.execute();
//            System.out.println(result.getResult());
        }
    }
}