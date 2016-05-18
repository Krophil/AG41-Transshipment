import solver.Solver;


public class Main {

	public static void main(String[] args) {
		if (args.length == 2) {
			Solver solv = new Solver();
			solv.solve(args[0], Integer.valueOf(args[1]));
		} else {
			System.out.println("Missing arguments : file name and solving time (ms)");
		}
	}

}
