package util;

public abstract class Function {

    /**
     * F1: Sphere Function
     */
    public double sphere(final Solution solution, final double[] o) {
        double result = 0;

        for (int i = 0; i < solution.getSolution().length; i++) {
            final double z = solution.getSolution()[i] - o[i];
            result += Math.pow(z, 2);
        }

        solution.setResult(result);

        return result;
    }

    /**
     * F6: Rosenbrock’s Function
     */
    public double rosenbroks(final Solution solution, final double[] o) {

        double result = 0.0;

        for (int i = 0; i < solution.getSolution().length - 1; i++) {
            double temp1 = (solution.getSolution()[i] * solution.getSolution()[i]) - solution.getSolution()[i + 1];
            double temp2 = solution.getSolution()[i] - 1.0;
            result += (100 * temp1 * temp1) + (temp2 * temp2);
        }

        solution.setResult(result);

        return result;
    }

    /**
     * F7: Schaffers F7 Function
     */
    public double schaffersF7(final Solution solution, final double[] o) {
        double result = 0.0;
        double length = solution.getSolution().length - 1;

        for (int i = 0; i < length; i++) {
            double si = Math.pow(Math.pow(solution.getSolution()[i], 2) + Math.pow(solution.getSolution()[i + 1], 2), 0.5);
            result += Math.pow((1 / length) * Math.pow(si, 0.5) * (Math.sin(50.0 * Math.pow(si, 0.2)) + 1), 2);
        }

        solution.setResult(result);

        return result;
    }

    /**
     * F8: Ackley’s Function
     */
    public double ackleys(final Solution solution, final double[] o) {
        double result = 0.0, a = 20, b = 0.2, c = 2 * Math.PI, sum1 = 0.0, sum2 = 0.0;
        double length = solution.getSolution().length;

        for (int i = 0; i < length; i++) {
            sum1 += Math.pow(solution.getSolution()[i], 2);
            sum2 += Math.cos(c * solution.getSolution()[i]);
        }

        result = -a * Math.exp(-b * Math.pow((1 / length) * sum1, 0.5)) - Math.exp((1 / length) * sum2) + a + Math.exp(1);

        solution.setResult(result);

        return result;
    }

    /* F17: Lunacek bi-Rastrigin Function */
    /* F19: Rotated Expanded Griewank’s plus Rosenbrock’s Function*/

    public double fitness(String problem, Solution solution, double[] o) {
        switch (problem) {
            case "sphere":
                return this.sphere(solution, o);
            case "rosenbroks":
                return this.rosenbroks(solution, o);
            case "schaffersF7":
                return this.schaffersF7(solution, o);
            case "ackleys":
                return this.ackleys(solution, o);
        }

        return this.sphere(solution, o);
    }
}