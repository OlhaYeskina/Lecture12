package com.epam.olha_yeskina.java.lesson_12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {
    public static void main(String[] args) {
        System.out.println("Writing objects: ");
        Order car = new Order("Car", 150);
        Order helicopter = new Order("Helicopter", 2000);

        System.out.println(car);
        System.out.println(helicopter);

        try(FileOutputStream fs = new FileOutputStream("order.bin")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(car);
            os.writeObject(helicopter);

            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
