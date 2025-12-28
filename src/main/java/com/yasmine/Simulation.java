package com.yasmine;

import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {

        CapteurTemperature capteurTemperature = new CapteurTemperature();
        CapteurPression capteurPression = new CapteurPression();
        ConcreteControlleur controlleur = new ConcreteControlleur();

        double temperatureActuelle;
        double pressionActuelle;

        //Attaching Observer (the controller) to subjects (CapteurTemperature & CapteurPression) ...
        capteurTemperature.attach(controlleur);
        capteurPression.attach(controlleur);

        //Scanner created to manage users Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n...Bienvenue dans la console \n         Press [x] to Quit \n         Press [Enter] to Continue");

        while(scanner.nextLine().compareToIgnoreCase("x") != 0){

            //NEW TEMPERATURE INPUT
            System.out.println("\nEntrez une nouvelle temperature : ");
            temperatureActuelle = scanner.nextDouble();
            capteurTemperature.setDataActuelle(temperatureActuelle);

            //NEW PRESSION INPUT
            System.out.println("\nEntrez une nouvelle concentration de CO2 : ");
            pressionActuelle = scanner.nextDouble();
            capteurPression.setDataActuelle(pressionActuelle);

        }
        System.out.println("Au revoir... ");
    }
}