package com.epam.olha_yeskina.java.lesson_12;

import java.util.HashMap;
import java.util.Map;

public class Order {


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
        return count + "55553333";
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
    public int hashCode() {
        int sumFirstFourDigits = 0;
        char[] chars = this.orderKey.toCharArray();
        for (int i = 0; i<4; i++) {
            System.out.println(chars[i]);
            sumFirstFourDigits += chars[i];
        }
        System.out.println(sumFirstFourDigits);
        System.out.println(getOrderKey().length());
        return sumFirstFourDigits * this.orderKey.length();
    }
}
