package Project2;

/*
 * Jason Salazar 
 * Data Structures and Algorithms
 * 9/12/2021
 * Assignment 2
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGame { 

   public static void main(String[] args) {
 
	   ArrayBag<Integer> bag= new ArrayBag<Integer>();
 
      //Scanner for inputs, random class, bag class

       Scanner scan = new Scanner(System.in);
     
       int rng = 0;

       //Getting the max value of the numbers being generated. Getting the amount of random numbers being chosen.
       System.out.print("Please select the number range of random numbers from 1 to :");
       int rangeMax = scan.nextInt();
     
       System.out.print("Please enter the amount of random numbers that will be generated by the program :");
       int numberOfRandoms = scan.nextInt();
     
       //Generating arrays from the amount of numbers specified in the range
    
       int userEntry[] = new int[numberOfRandoms];
     
       //The range will generate random numbers
       for(int index=1; index<=numberOfRandoms; index++ ) {
    	   
			rng = (int)( 1+(Math.random()*(rangeMax-1+1)));
			bag.add(rng);
			
		}
       
       Object[] array = bag.toArray();
       
       //Converting object array into the Integer array
       
       Integer[] bagArray = new Integer[numberOfRandoms];
       System.arraycopy(array, 0, bagArray, 0, numberOfRandoms);
       
       //Getting the random numbers entered by the user.
       
       System.out.print("Enter " + numberOfRandoms + " numbers :");
       for (int y = 0; y < numberOfRandoms; y++) {
           userEntry[y] = scan.nextInt();
       }
     
       int points = 0, c = 0;
     
       //Checking how many numbers user guessed are correct.
       
       while (c < numberOfRandoms) {
           int l = 0;
           while (l < numberOfRandoms) {

               if (userEntry[c] == bagArray[l]) {
                   points++;
                   l++;
                   break;
               } else
                   l++;

           }
           c++;
           if (c == 5)
               break;
       }
     
       //If all inputs are correct the if block content will display. Or else block will display.
  
       if (points == 5)
           System.out.println("You guessed all 4 correct! Winner!");
       else {
           System.out.println(points + " of your Guess are correct. Guess Again");
         
           //Displaying the random numbers chosen by computer
           
           System.out.print("The Random Numbers Choosen by compter are :");
           for (int i = 0; i < numberOfRandoms; i++) {
               System.out.print(bagArray[i] + " ");
           }
       }

   }

}

