package banking;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
		if(accounts == null){
			accounts = new LinkedHashMap<>();
		}
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		Account lastAccount =getLast();
		Long accountNumber = lastAccount == null ? 1l : lastAccount.getAccountNumber()+1;
		CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Account lastAccount =getLast();
		Long accountNumber = lastAccount == null ? 1l : lastAccount.getAccountNumber()+1;
		ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
        return accountNumber;
	}

	private Account getLast()
	{
		int count = 1;

		for (Map.Entry<Long, Account> it :
				accounts.entrySet()) {

			if (count == accounts.size()) {
				return it.getValue();
			}
			count++;
		}
        return null;
    }

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
        return true;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
		account.setBalance(account.getBalance()+amount);
		accounts.put(accountNumber, account);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
		if(account.getBalance()>=amount){
			account.setBalance(account.getBalance()-amount);
			accounts.put(accountNumber, account);
			return true;
		}
        else
			return false;
	}
}
