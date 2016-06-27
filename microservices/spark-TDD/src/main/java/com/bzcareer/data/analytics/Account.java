package com.bzcareer.data.analytics;

public class Account implements java.io.Serializable{
	int account_number;
	String fname;

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", fname=" + fname
				+ ", lname=" + lname + ", debt=" + debt + ", totalWealth="
				+ totalWealth + "]";
	}

	String lname;
	double debt;
	double totalWealth;

	private Account(int account_number, String fname, String lname,
			double debt, double totalWealth) {
		this.account_number = account_number;
		this.fname = fname;
		this.lname = lname;
		this.debt = debt;
		this.totalWealth = totalWealth;
	}

	public double netWorth() {
		return totalWealth - debt;
	}

	public static class Builder {
		private int account_number;
		private String fname;
		private String lname;
		private double debt;
		private double totalWealth;

		public Builder withAccountNum(int an) {
			this.account_number = an;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.fname = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lname = lastName;
			return this;
		}

		public Builder withDebt(double d) {
			this.debt = d;
			return this;
		}

		public Builder withTotalWealth(double w) {
			this.totalWealth = w;
			return this;
		}

		public Account build() {
			return new Account(this.account_number, this.fname, this.lname,
					this.debt, this.totalWealth);
		}

	}
}
