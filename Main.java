import algorithms.HillClimbing;
import util.Solution;

public class Main {
    public static void main(String[] args) {
        int executions = 20;
        int interations = 100000;
        int tWeakSize = 50;
        double min = -100;
        double max = 100;

        double[] o = new double[tWeakSize];

        for (int i = 0; i < executions; i++) {
            HillClimbing meta = new HillClimbing(interations, tWeakSize, min, max, o);

            Solution result = meta.execute();
			
			System.out.println(result.getResult());
        }
    }
}