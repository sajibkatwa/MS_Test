package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
	private Long accountNumber;
	private Bank bank;
	private Account account;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
		this.account = bank.getAccount(accountNumber);
		if(!account.validatePin(attemptedPin))
			throw new Exception();
	}

	public double getBalance() {
		// complete the function
        return this.account.getBalance();
	}

	public void credit(double amount) {
		// complete the function
		this.account.setBalance(this.account.getBalance()+amount);
	}

	public boolean debit(double amount) {
		// complete the function
		if(this.account.getBalance()>=amount) {
			this.account.setBalance(this.account.getBalance() - amount);
			return true;
		} else
        return false;
	}
}
