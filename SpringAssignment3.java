Banking 

ActBank.java

package com.java.bank;

public class ActBank {

	public int accountId;
	public String accountHolderName;
	public String accountType;
	public long accountBalance;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	  public void showBankAccountDetails(){
	        System.out.println("Account Id : " + accountId);
	        System.out.println("Account Holder Name : " + accountHolderName);
	        System.out.println("AccountType : " + accountType);
	        System.out.println("AccountBalance : " + accountBalance);

	    }	
}
-------------------------------------------------------------------------------------
ActBankR.java
package com.java.bank;

public interface ActBankR{

	public double getBalance(long accountId);
	public double updateBalance(long accountId, double newBalance);	
}
----------------------------------------------------------------------------------------
BankActRImpl.java

package com.java.bank;
public abstract class BankActRImpl implements ActBankR {
	
	private void BankAccRepositoryImpl(){
	  ActBank bankaccount = new ActBank();
	  bankaccount.setAccountHolderName("Mounika");
	  bankaccount.setAccountId(65);
	  bankaccount.setAccountType("Savings");
	  bankaccount.setAccountBalance((long) 20345.5);


	}
}

-----------------------------------------------------------------------------------------
BankAccService.java

package com.java.bank;

public interface BankAccService {
public double withdraw(long accountId, double balance);
public double deposit(long accountId, double balance);
public double getBalance(long accountId);
public boolean fundTransfer(long fromAccount, long toAccount, double account);

}
-------------------------------------------------------------------------------------------
BankAccServiceImpl.java

package com.java.bank;

public abstract class BankAccServiceImpl implements BankAccService{
	long accountId;
	double balance;
	long fromAccount;
	long toAccount;
	double account;
	
	public void withdraw() {
		System.out.println("AccounntId" +accountId);
		System.out.println("Balance" +balance);
	}
	
	public void balance() {
		System.out.println("AccounntId" +accountId);
		System.out.println("Balance" +balance);
	}
	
	public void deposit() {
		System.out.println("AccounntId" +accountId);
		System.out.println("Balance" +balance);
	}
	
	public void fundTransfer() {
		System.out.println("AccounntId" +accountId);
		System.out.println("Balance" +balance);
	}
	
	
}
---------------------------------------------------------------------
ActBankC.java

package com.java.bank;

public class ActBankC{

	
	BankAccServiceImpl bankaccountS = new BankAccServiceImpl() {
		
		public double withdraw(long accountId, double balance) {
			
			return withdraw(15000,1500);
		}
		
		public double getBalance(long accountId) {
			
			return getBalance(150);
		}
		
		public boolean fundTransfer(long fromAccount, long toAccount, double aount) {
			
			return false;
		}
		
		public double deposit(long accountId, double balance) {
		
			return deposit(15000, 1500);
		}
	};

	public void withdraw() {
		
		return;
	}
	
	
}
-----------------------------------------------------------------------------------------------------------
one.java

package com.java.bank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;  


public class one
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationcontext=new ClassPathXmlApplicationContext("applicationC.xml");  
        ActBankC obj=(ActBankC)applicationcontext.getBean("obj");  
        obj.withdraw();     
        }
}
-----------------------------------------------------------------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>

<beans  
    
xmlns="http://www.springframework.org/schema/beans"  
    
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    
xmlns:p="http://www.springframework.org/schema/p"  
    
xsi:schemaLocation="http://www.springframework.org/schema/beans   

http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">  
 
 
<!-- <bean id="b" class="com.Auowire.Auowire.BankAccountController"></bean>   
-->
<bean id="obj" class="com.java.bank.BankAccountController" autowire="byName">
</bean>  
  

</beans>  