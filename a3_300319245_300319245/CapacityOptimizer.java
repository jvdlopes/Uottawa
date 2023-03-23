public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
		double lowest = 1000;
		int low = 0;
		double avg = 0;
		int cap = 1;
		
		while(true){
			System.out.println("==== Setting lot capacity to: "+cap+"====");
			for(int j = 1; j <= NUM_RUNS; j++){
				Simulator sim = new Simulator(new ParkingLot(cap),hourlyRate);
				long startTime = System.currentTimeMillis();
				sim.simulate();
				long timer = System.currentTimeMillis() - startTime;
				System.out.println("Simulation run "+ j +" ("+ timer+"ms); Queue length at the end of simulation run: "+sim.getIncomingQueueSize()+"");
				avg += (double)sim.getIncomingQueueSize();
			}
			avg = avg/10;
			if(avg< lowest){
				low = cap;
				lowest = avg;
			}
			if(avg <= 5){
				break;
			}
			avg = 0;
			cap++;
		}
		return low;
	
	}

	public static void main(String args[]) {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}