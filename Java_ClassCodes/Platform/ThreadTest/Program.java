class Program {

	private static ThreadLocal<String> client = new ThreadLocal<>();

	private static void handleJob(int jid) {
		System.out.printf("Thread<%x> has accepted job<%d> for client<%s>%n", Thread.currentThread().hashCode(), jid, client.get());
		Worker.doWork(jid);
		System.out.printf("Thread<%x> has finished job<%d> for client<%s>%n", Thread.currentThread().hashCode(), jid, client.get());
	}

	public static void main(String[] args) throws Exception {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 5;
		Thread child = new Thread(() -> {
			client.set("Jack");
			handleJob(n);
		});
		//turning child into a daemon(background) thread if n > 20
		//JVM does not wait for a daemon thread to exit
		child.setDaemon(n > 20); 
		child.start();
		client.set("Jill");
		handleJob(8);
	}
}

