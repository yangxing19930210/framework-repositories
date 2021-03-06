package t5750.tcctransactionboot.sample.dubbo.capital.domain.entity;

import java.math.BigDecimal;

import t5750.tcctransactionboot.sample.exception.InsufficientBalanceException;

/**
 */
public class CapitalAccount {
	private long id;
	private long userId;
	private BigDecimal balanceAmount;
	private BigDecimal transferAmount = BigDecimal.ZERO;

	public long getUserId() {
		return userId;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void transferFrom(BigDecimal amount) {
		this.balanceAmount = this.balanceAmount.subtract(amount);
		if (BigDecimal.ZERO.compareTo(this.balanceAmount) > 0) {
			throw new InsufficientBalanceException();
		}
		transferAmount = transferAmount.add(amount.negate());
	}

	public void transferTo(BigDecimal amount) {
		this.balanceAmount = this.balanceAmount.add(amount);
		transferAmount = transferAmount.add(amount);
	}

	public void cancelTransfer(BigDecimal amount) {
		transferTo(amount);
	}
}
