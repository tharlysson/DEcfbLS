package util;

public abstract class Function {

    /** F1: Sphere Function */
    public double sphere(final Solution solution, final double[] o) {
        double result = 0;

        for (int i = 0; i < solution.getSolution().length; i++) {
            final double z = solution.getSolution()[i] - o[i];
			result += Math.pow(z, 2);
		}
		
		solution.setResult(result);
		
		return result;
    }

    /* F6: Rotated Rosenbrock’s Function   */
    /* F7: Rotated Schaffers F7 Function  */
    /* F8: Rotated Ackley’s Function */
    /* F17: Lunacek bi-Rastrigin Function */
    /* F19: Rotated Expanded Griewank’s plus Rosenbrock’s Function*/
}