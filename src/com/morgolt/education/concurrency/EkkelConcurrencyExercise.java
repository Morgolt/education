public class EkkelConcurrencyExercise {
	public static void main(String[] args) {
		EkkelExercise ex;
		try {
			int exerciseNumber = Integer.parseInt(args[0]);
			switch (exerciseNumber) {
				case 1:
					ex = new FirstExercise();
					break;
				case 2:
					ex = new SecondExercise();
					break;
				case 3:
					ex = new ThirdExercise();
					break; 
				default:
					throw new RuntimeException("No such exercise");				
			}
			ex.runExercise();
		} catch (ClassCastException e) {
			throw e;
		}

	}
}


