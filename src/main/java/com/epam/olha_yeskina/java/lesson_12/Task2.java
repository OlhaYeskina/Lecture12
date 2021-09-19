package com.epam.olha_yeskina.java.lesson_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Task2 {

    Map<String, Order> mapKeyOrder = new HashMap<>();

    public Task2(Order obj) {
       // orderKey = str;
        mapKeyOrder.put(obj.getOrderKey(), obj);
    }

    public void inputKeyOrder(Order obj) {
       // orderKey = str;
        mapKeyOrder.put(obj.getOrderKey(), obj);
    }



    public void outputKeyOrder() {
        Iterator<String> it = mapKeyOrder.keySet().iterator();

        while(it.hasNext())
        {
            String key=it.next();
            System.out.println("Order key: "+key+"  Order name: "+ mapKeyOrder.get(key).getOrderName());
        }
        System.out.println("\n");
       // System.out.println(mapKeyOrder);
    }


//    (использовать два разных метода генерации: в качестве хеш-кода
//    использовать длину строки и сумму первых четырех символов


    public int getHashCode(Order obj)   {

   //     mapKeyOrder.keySet().hashCode();
        for (Map.Entry<String, Order> entry : mapKeyOrder.entrySet()) {
            if (Objects.equals(obj, entry.getValue())) {
                return entry.getKey().hashCode();
            }
        }
        return 0;
    }
//    @Override
//    public int hashCode() {
//        int sumFirstFourDigits = 0;
//        char[] chars = this.mapKeyOrder.get(obj).toCharArray();
//        for (int i = 0; i<4; i++) {
//            System.out.println(chars[i]);
//            sumFirstFourDigits += chars[i];
//        }
//        System.out.println(sumFirstFourDigits);
//        System.out.println(this.orderKey.length());
//        return sumFirstFourDigits * this.orderKey.length();
//    }

//    @Override
//    public int hashCode() {
//        int sumFirstFourDigits = 0;
//        int result = 1;
//        result = prime * result + varA;
//        result = prime * result + varB;
//        return result;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        BlackBox other = (BlackBox) obj;
//        if (varA != other.varA)
//            return false;
//        if (varB != other.varB)
//            return false;
//        return true;
//    }


    public static void main(String[] args) {


        Order order1 = new Order("Car", 150);
        Order order2 = new Order("Helicopter", 2000);
        Order order3 = new Order("Bear", 500);
        Task2 keyOrder1 = new Task2(order1);

        keyOrder1.inputKeyOrder(order2);
        keyOrder1.inputKeyOrder(order3);
        keyOrder1.outputKeyOrder();

        System.out.println(keyOrder1.getHashCode(order1));
        System.out.println(keyOrder1.getHashCode(order2));
        System.out.println(keyOrder1.getHashCode(order3));
       // System.out.println(keyOrder1.hashCode());
//        System.out.println(keyOrder1.getHashCode(order1));
//        System.out.println(keyOrder1.getHashCode(order2));
//        System.out.println(keyOrder1.getHashCode(order3));
    }


}
