import solver.Solver;


public class Main {

	public static void main(String[] args) {		
		if (args.length == 3) {
			Solver solv = new Solver();
			if (solv.solve(args[0], Integer.valueOf(args[2])*1000) >= 0) ;
				solv.saveSolution(args[1]);
		} else if (args.length != 3){
			System.out.println("Usage :\n laucher <file location> <solution location> <time in second>");
		}
	}

}
