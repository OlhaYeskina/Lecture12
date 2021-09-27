package com.epam.olha_yeskina.java.lesson_12;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {


    String orderKey;
    static int count = 1000;
    String orderName;
    int orderPrice;


    public Order(String orderName, int orderWeight) {
        this.orderName = orderName;
        this.orderPrice = orderWeight;
        this.orderKey = createOrderKey();
    }
 private String  createOrderKey(){
        count++;
        return count + "5";
 }
     public String getOrderKey(){
        return orderKey;
     }
    public String getOrderName() {
        return orderName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    @Override
    public String toString(){
        return "Order [ name: " +getOrderName()+"; price: "+getOrderPrice()+"; + key: "+getOrderKey()+" ]";
    }

    @Override
    public int hashCode() {
        int sumFirstFourDigits = 0;
        char[] chars = this.orderKey.toCharArray();
        for (int i = 0; i<4; i++) {
           // System.out.println(chars[i]);
            sumFirstFourDigits += Character.getNumericValue(chars[i]);
        }
    //    System.out.println(sumFirstFourDigits);
      //  System.out.println(getOrderKey().length());
        return sumFirstFourDigits + this.orderKey.length();
    }
}
