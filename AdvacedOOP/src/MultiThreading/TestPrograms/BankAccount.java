package MultiThreading.TestPrograms;

public class BankAccount {
	private int balance = 0;
	private boolean isOpen = true;

	/**
	 * Method withdraws an amount from account
	 * If funds insufficient, it will wait until funds available or the account is closed.
	 *
	 * @param amount: the amount to be withdraw from the account
	 * @return true: if the withdrawal is successful. false: otherwise
	 * @throws InterruptedException If another thread calls the <b> interrupt </b> method
	 */
	public synchronized boolean withdraw(int amount) throws InterruptedException {
		//if entered amount larger than balance, wait for some funds are available or the account is closed.

		/**
		 * When is it appropriate to call wait() ?
		 * - when your synchronized function is waiting for
		 */
		while (amount > balance && isOpen()) {
			System.out.println("Waiting for " + "some money...");
			wait();
		}
		boolean result = false;
		if (isOpen()) {
			balance -= amount;
			result = true;
		}
		return result;
	}

	/**
	 * Method to deposit amount into the account provided that the account is open
	 * When deposit successful, it will notify all waiting operations that there is now more money in account
	 *
	 * @param amount The amount to be deposited into the account
	 * @return true if the deposit is successful
	 * false otherwise
	 */
	public synchronized boolean deposit(int amount) throws InterruptedException {
		//not considering improper deposit input
		if (isOpen()) {
			balance += amount;
			//awake all threads
			notifyAll();
			return true;
		} else {
			return false;
		}
	}

	public synchronized boolean isOpen() {
		return isOpen;
	}

	/* Close the bank account */
	public synchronized void close() {
		isOpen = false;
		notifyAll();
	}

}
