import java.util.concurrent.*;

public class ThirdExercise implements EkkelExercise {
	/*
	Exercise 3: (1) Repeat Exercise 1 using the different 
	types of executors shown in this section.
	*/
	public void runExercise() {
		FirstExercise ex = new FirstExercise();
		FirstExercise.PrintTask task = ex.new PrintTask();
		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newFixedThreadPool(2);
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		exec1.submit(task);
		exec2.submit(task);
		exec3.submit(task);
		exec1.shutdown();
		exec2.shutdown();
		exec3.shutdown();
	}
	

}