class SecondExercise implements EkkelExercise {
	/*
	Exercise 2: (2) Following the form of generics/Fibonacci.java, 
	create a task that produces a sequence of n Fibonacci numbers,
	where n is provided to the constructor of the task. Create a 
	number of these tasks and drive them using threads.
	*/
	class Fibonacci implements Runnable {
		private int count = 0;
		private int n = 0;
		public Fibonacci(int n) {
			this.n = n;
		}

		public void run() {
			System.out.println("Fibonacci sequence until " + this.n + ":");
			while (count < n) {
				System.out.println(this.next());
			}
		}	


		public Integer next() { 
			return fib(count++); 
		}

		private int fib(int n) {
			if(n < 2) return 1;
			return fib(n-2) + fib(n-1);
		}		
	}

	public void runExercise() {		
		Thread thread1 = new Thread(new Fibonacci(5));
		Thread thread2 = new Thread(new Fibonacci(7));
		Thread thread3 = new Thread(new Fibonacci(4));
		thread1.start();
		thread2.start();
		thread3.start();
	}	
}