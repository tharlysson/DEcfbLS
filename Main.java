import algorithms.*;
import util.Solution;

public class Main {
    public static void main(String[] args) {
        int executions = 1;
        int interations = 100000;
        int tWeakSize = 30;
        double min = -100;
        double max = 100;
        String problem = "sphere";

        double[] o = new double[tWeakSize];

        for (int i = 0; i < executions; i++) {
            HillClimbing meta = new HillClimbing(problem, interations, tWeakSize, min, max, o);
            // DEcfbLS meta = new DEcfbLS(interations, tWeakSize, min, max, o);

            // meta.execute();
            Solution result = meta.execute();
                
            System.out.println(result.getResult());
        }
    }
}