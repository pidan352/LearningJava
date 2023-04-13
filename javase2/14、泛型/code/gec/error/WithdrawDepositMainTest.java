package com.gec.error;

class Account{

    //账号
    private String accountName;
    //余额
    private double balance;

    //缺省构造器
    public Account() {
    }

    //带参构造器
    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款方法（参数就是取款金额）
    public void withdraw(double withDrawAmount){

        if(withDrawAmount<0){
            //抛出异常
            throw new IllegalArgumentException("取款金额有误，不能为负数");
        }

        if(withDrawAmount>getBalance()){
            //抛出异常
            throw new UnsupportedOperationException("取款金额不足，不支持当前取款操作");
        }

        setBalance(getBalance()-withDrawAmount);

    }

    //存款方法（参数就是取款金额）
    public void deposit(double depositAmount){
        if(depositAmount<0){
            throw new IllegalArgumentException("存款金额有误，不能为负数");
        }

        setBalance(getBalance()+depositAmount);
    }

}
public class WithdrawDepositMainTest {

    public static void main(String[] args) {

        Account account=new Account("张三",10000.00);

        try {
            account.withdraw(20000.00);
            account.deposit(-10.0);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

    }
}
