public class FirstExercise implements EkkelExercise {	
		/*
		Exercise 1: (2) Implement a Runnable. Inside run( ), print a message, 
		and then call yield( ). Repeat this three times, and then return from
		run( ). Put a startup message in the constructor and a shutdown 
		message when the task terminates. Create a number of these tasks 
		and drive them using threads.
		*/
		class PrintTask implements Runnable {
			public PrintTask() {
				System.out.println("Runnable created.");
			}
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("This is first print.");
					Thread.yield();
				}
				System.out.println("Task done.");
			}	
		}

		public void runExercise() {
			Thread thread1 = new Thread(new PrintTask());
			Thread thread2 = new Thread(new PrintTask());		
			Thread thread3 = new Thread(new PrintTask());
			thread1.start();
			thread2.start();
			thread3.start();
	}	
}