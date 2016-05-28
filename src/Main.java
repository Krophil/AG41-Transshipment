import solver.Solver;


public class Main {

	public static void main(String[] args) {
		if (args.length == 2) {
			Solver solv = new Solver();
			solv.solve(args[0], Integer.valueOf(args[1])*1000);
		} else if (args.length == 0){
			System.out.println("Missing argument : Problem file name.");
		} else if (args.length <= 1){
			System.out.println("Missing argument : Solving time (in millisecond).");
		} else {
			System.out.println("Too many arguments.\nExpected arguments : <problem file name> <solving time (in millisecond)>");
		}
	}

}
