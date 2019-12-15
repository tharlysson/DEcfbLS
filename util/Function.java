package util;

public abstract class Function {

    public double sphere(final Solution solution, final double[] o) {
        double result = 0;

        for (int i = 0; i < solution.getSolution().length; i++) {
            final double z = solution.getSolution()[i] - o[i];
			result += Math.pow(z, 2);
		}
		
		solution.setResult(result);
		
		return result;
    }
}