package MultiThreading;

import java.util.concurrent.TimeUnit;

public class ParkingCash {
	private static final int cost = 2;
	private long cash;

	public ParkingCash() {
		cash = 0;
	}

	public void vehiclePay() {
		cash += cost;
	}

	public void close() {
		System.out.printf("Closing accounting");
		long totalAmmount;
		totalAmmount = cash;
		cash = 0;
		System.out.printf("The total amount is : %d",
				totalAmmount);
	}
}

class ParkingStats {
	private long numberCars;
	private long numberMotorcycles;
	private ParkingCash cash;

	public ParkingStats(ParkingCash cash) {
		numberCars = 0;
		numberMotorcycles = 0;
		this.cash = cash;
	}

	public void carComeIn() {
		numberCars++;
	}

	public void carGoOut() {
		numberCars--;
		cash.vehiclePay();
	}

	public void motoComeIn() {
		numberMotorcycles++;
	}

	public void motoGoOut() {
		numberMotorcycles--;
		cash.vehiclePay();
	}
}

class Sensor implements Runnable {
	private ParkingStats stats;

	public Sensor(ParkingStats stats) {
		this.stats = stats;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			stats.carComeIn();
			stats.carComeIn();
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stats.motoComeIn();
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stats.motoGoOut();
			stats.carGoOut();
			stats.carGoOut();
		}
	}
}

class Main {
	public static void main(String[] args) {

		ParkingCash cash = new ParkingCash();
		ParkingStats stats = new ParkingStats(cash);

		System.out.printf("Parking Simulatorn");

		int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
		Thread threads[] = new Thread[numberSensors];
		for (int i = 0; i < numberSensors; i++) {
			Sensor sensor = new Sensor(stats);
			Thread thread = new Thread(sensor);
			thread.start();
			threads[i] = thread;
		}
	}
}

