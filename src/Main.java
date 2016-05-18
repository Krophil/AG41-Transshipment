import solver.Solver;


public class Main {

	public static void main(String[] args) {
		if (args.length == 1) {
			Solver solv = new Solver();
			solv.solve(args[0], 2000);
		} else {
			System.out.println("Missing argument : file name");
		}
	}

}
