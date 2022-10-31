package MultiThreading.TestPrograms;

public class BankAccount {
	/**
	 * Demonstrate wait and notify methods
	 */

	private int balance = 0;
	//flag for opening bank
	private boolean isOpen = true;

	/**
	 * The method withdraws an amount from the account
	 * If funds are insufficient, it will wait until funds available or the account is closed.
	 *
	 * @param amnt The amount to be withdraw from account
	 * @return true if the withdrawal successful, false otherwise
	 * @throws InterruptedException if another thread calls the <b>interrupt</b> method
	 */

	public synchronized boolean withdraw(int amnt) throws InterruptedException {
		//use a flag to lock a thread
		while (amnt > balance && isOpen()) {
			System.out.println("Waiting for" + "some money ...");
			wait();
		}
		boolean result = false;
		if (isOpen()) {
			balance -= amnt;
			result = true;
		}
		return result;
	}

	/**
	 * The method to deposit an amount into the account, provided the account is open.
	 * When the deposit is successful, it will notify all waiting operations that there is now more money in the account
	 *
	 * @param amount The amount to be deposited into the account
	 * @return true if the deposit is successful, false otherwise
	 */

	public synchronized boolean deposit(int amount) {
		if (isOpen()) {
			balance += amount;
			notifyAll();
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Check to see if the account is open
	 *
	 * @return true if it is open, other wise return false;
	 */

	public synchronized boolean isOpen() {
		return isOpen;
	}

	/**
	 * Close the bank account
	 */
	public synchronized void close() {
		isOpen = false;
		notifyAll();
	}



}
