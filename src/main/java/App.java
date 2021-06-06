/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String usersChoice = myApp.readInput("Press C to convert from Fahrenheit to Celsius.\nPress F to convert from Celsius to Fahrenheit.\nYour choice: ");
        String tempInputString = myApp.getTemp(usersChoice);
        float tempInput = myApp.convertToFloat(tempInputString);
        float tempConverted = myApp.convertTemp(usersChoice, tempInput);
        String outputString =  myApp.generateOutputString(usersChoice, tempConverted);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(String usersChoice, float tempConverted) {
        String outputString = usersChoice.equalsIgnoreCase("c")
                ? String.format("The temperature in Celsius is %.2f.", tempConverted)
                : String.format("The temperature in Fahrenheit is %.2f.", tempConverted);
        return outputString;
    }

    private float convertTemp(String usersChoice, float tempInput) {
        if( usersChoice.equalsIgnoreCase("c")) {
            float temp = (float) (tempInput - 32) * 5 / 9;
            return temp;
        }
        float temp = (tempInput * 9 / 5) + 32;
        return temp;
    }

    private float convertToFloat(String tempInputString) {
        float tempInput = Float.parseFloat(tempInputString);
        return tempInput;
    }

    private String getTemp(String usersChoice) {
        if(usersChoice.equalsIgnoreCase("C")) {
            System.out.print("Please enter the temperature in Fahrenheit: ");
            String temp = in.nextLine();
            return temp;
        }
        System.out.print("Please enter the temperature in Celsius: ");
        String temp = in.nextLine();
        return temp;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

}