package com.gec.generic;

/*
* 定义一个手机泛型类
* */
class Phone<T>{

    private String phoneNo;
    private double price;
    private float weight;

    private T commit;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public T getCommit() {
        return commit;
    }

    public void setCommit(T commit) {
        this.commit = commit;
    }
}

public class PhoneMainTest {

    public static void main(String[] args) {

        Phone<Character> phoneObj=new Phone<>();
        phoneObj.setPhoneNo("iphone13");
        phoneObj.setPrice(13000.00);
        phoneObj.setCommit('A');

        Phone<Double> phoneObj2=new Phone<>();
        phoneObj2.setCommit(80.0);

        Phone<String> phoneObj3=new Phone<>();
        phoneObj3.setCommit("good");

    }
}
