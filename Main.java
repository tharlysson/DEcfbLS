import algorithms.*;
import util.Solution;

public class Main {
    public static void main(String[] args) {
       /*
       * Se for lunacekBiRastrigin min = -5.12 e max = 5.12
       * */
        int executions = 20;
        int iterations = 100000;
        int tWeakSize = 30;
        double min = -100;
        double max = 100;
        String problem = "lunacekBiRastrigin"; // [sphere, rosenbroks, schaffersF7, ackleys, lunacekBiRastrigin]
        int popSize = 30;

        double[] o = new double[tWeakSize];

        for (int i = 0; i < executions; i++) {

//            DEcfbLS meta = new DEcfbLS(problem, iterations, tWeakSize, min, max, o, popSize);
//            HillClimbing meta = new HillClimbing(problem, iterations, tWeakSize, min, max, o);
            SimulateAnnealing meta = new SimulateAnnealing(problem, iterations, tWeakSize, min, max, o);

            Solution result = meta.execute();
            System.out.println(result.getResult());
        }
    }
}