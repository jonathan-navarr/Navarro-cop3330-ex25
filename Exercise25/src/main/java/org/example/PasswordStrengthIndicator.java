package org.example;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 first_name last_name
 */

public class PasswordStrengthIndicator {
    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);
        int strength;
        String password;

        System.out.print("Please enter a password: ");
        password = scnr.nextLine();

        strength = passwordValidator(password);
        if(strength == 0)
        {
            System.out.println("The password '" + password + "' is a very weak password");
        }
        else if(strength == 1)
        {
            System.out.println("The password '" + password + "' is a weak password");
        }
        else if(strength == 2)
        {
            System.out.println("The password '" + password + "' is a strong password");
        }
        else if(strength == 3)
        {
            System.out.println("The password '" + password + "' is a very strong password");
        }
        else if(strength == 4)
        {
            System.out.println("Error the password doesn't meet the criteria");
        }
    }

        public static int passwordValidator(String password){
        int i;
        int numCounter = 0, lCounter = 0;
        if(password.length() < 8)
        {
            for(i = 0; i < password.length(); i++)
            {
                char j = password.charAt(i);

                if(Character.isDigit(j))
                {
                    numCounter++;
                }
                else if(Character.isLetter(j))
                {
                    lCounter++;
                }

            }
            if (numCounter == password.length())
            {
                return 0;
            }
            else if(lCounter == password.length()) {
                return 1;
            }
        }
        if (password.length() >= 8)
        {
            numCounter = 0;
            lCounter = 0;

            for(i = 0; i < password.length(); i++)
            {
                char k = password.charAt(i);
                if(Character.isDigit(k))
                {
                    numCounter++;
                }
                else if(Character.isLetter(k))
                {
                    lCounter++;
                }

                if (((numCounter > 0) && (lCounter > 0))&& (numCounter+ lCounter == password.length()))
                {
                    return 2;
                }
                else if(((numCounter >= 1) && (lCounter >=1)) && (numCounter + lCounter != password.length()))
                {
                    return 3;
                }
            }
        }
            return 4;
        }
}
