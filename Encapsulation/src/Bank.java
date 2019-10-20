
public class Bank {
	private String accountNo;
	private String name;
	private String password;

	public Bank() {
		this("");
				
	}

	public Bank(String accounNo) {
		this(accounNo,"");
	}

	public Bank(String accounNo, String name) {
		this(accounNo,name,"");
	}

	public Bank(String accounNo, String name,String password) {
		if(isValidAccountNo(accounNo)) {
		this.accountNo=accounNo;
		this.password=password;
		this.name=name;
		}else {
			System.out.println("Invalid account no");
		}
	}

	private boolean isValidAccountNo(String accountNo) {
		boolean isValid= accountNo.length()==13 ? true:false;
		return isValid;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		if(isValidAccountNo(accountNo)) {
		this.accountNo = accountNo;
		}else {
			System.out.println("Invalid account no");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bank [accountNo=");
		builder.append(accountNo);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
