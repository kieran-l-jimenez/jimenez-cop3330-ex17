import java.util.Scanner;


/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
 *BAC = (A × 5.14 / W × r) − .015 × H
 *           "Blood Alcohol Calculator" output
 *Your BAC is 0.08
 *It is not legal for you to drive.
 */
public class App
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();
        double weight, gender, TAC, hours;

        System.out.print("What is your weight (lbs)? ");
        weight = myApp.validation();

        System.out.print("What is your gender (1 = Female, 2 = Male)? ");
        gender = myApp.validation();

        System.out.print("What is your total alcohol consumed (oz)? ");
        TAC = myApp.validation();

        System.out.print("How many hours has it been since your last drink? ");
        hours = myApp.validation();

        double BAC = myApp.calculateBAC(TAC, weight, gender, hours);

        System.out.printf("Your BAC is %.2f\n", BAC);

        if(BAC >= 0.08)
            System.out.println("It is not legal for you to drive.");
        else
            System.out.println("It is legal for you to drive.");
    }

    private double calculateBAC(double A, double W, double gender, double H)
    {
        double r = gender == 1 ? 0.66 : 0.73;
        return (((A * 5.14)/(W * r)) - (0.015 * H));
    }

    private double validation()
    {
        double result = -1;
        if(in.hasNextDouble())
            result = in.nextDouble();
        else
        {
            int numberFlag = 0;
            while(numberFlag == 0)
            {
                System.out.print("Please enter a numeric value ");
                in.next();
                if(in.hasNextDouble())
                {
                    result = in.nextDouble();
                    numberFlag = 1;
                }
            }
        }

        return result;
    }
}