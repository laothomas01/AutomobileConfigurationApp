package Synchronization;

public class UnSynchronizedAccountTesting implements Runnable {
	private Account acct = new Account();

	public static void main(String[] args) {
		//one instance
		UnSynchronizedAccountTesting r = new UnSynchronizedAccountTesting();
		//two threads
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		//set thread names
		one.setName("Ranjeet");
		two.setName("Reema");
		//thread start
		one.start();
		two.start();
	}

	@Override
	public void run() {
		//make 5 withdrawals
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}

	private void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
		} else {
			System.out.println(
					"Not enough in account for " +
			                   Thread.currentThread().getName() +
			                   " to withdraw " + acct.getBalance());
		}
	}

	class Account {
		private int balance = 50;

		public int getBalance() {
			return balance;
		}

		public void withdraw(int amount) {
			balance = balance - amount;
		}
	}
}
