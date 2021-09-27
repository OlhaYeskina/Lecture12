package com.epam.olha_yeskina.java.lesson_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjects {
    public static void main(String[] args) {
        System.out.println("Reading objects... ");

        try (FileInputStream fi = new FileInputStream("order.bin")){

            ObjectInputStream os = new ObjectInputStream(fi);

            Order car = (Order) os.readObject();
            Order helicopter = (Order) os.readObject();

            os.close();

            System.out.println(car);
            System.out.println(helicopter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
