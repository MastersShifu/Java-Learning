package org.example;

import org.example.controller.WriteFields;
import org.example.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean end = false;
        VetClinic clinic = new VetClinic();

        System.out.println("Hello in program! Choose what you want: ");
        while (!end) {
            System.out.println("1. Go to clinic\n2. Show visits\n3. Exit");
            String choose = new Scanner(System.in).nextLine();

            switch (choose) {
                case "1" -> {
                    System.out.println("Write animal info: ");

                    Animal animal = WriteFields.newAnimal();

                    System.out.println("Now Client data: ");
                    Client client = WriteFields.newClient(animal);

                    clinic.newVisitor(client, animal);
                }

                case "2" -> {
                    if (!clinic.getVisits().isEmpty()) {
                        for (String visit : clinic.getVisits()) {
                            System.out.println(visit);
                        }

                    } else {
                        System.out.println("No one visits clinic!");
                    }
                }

                case "3" -> end = true;

                default -> System.out.println("Invalid input!");
            }

        }
    }
}