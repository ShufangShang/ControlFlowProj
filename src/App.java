import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import AsciiChars.AsciiChars;

public class App {
    static String petName = "";
    static int petAge = 0;
    static int luckyNum = 0;
    static int jerzeyNum = -1;
    static int modelYear = 0;
    static String actorName = "";
    static int randomNum = 0;

    static int randNum1 = 0;
    static int randNum2 = 0;
    static int randNum3 = 0;

    static int MAX_BALL_NUM = 75;
    static int MAX_LOTTORY_NUM = 65;

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        
        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();

        //Get the name of the user first and greeting the user
        Scanner input = new Scanner(System.in);
        System.out.println("\nWhat is your name?");
        String name = input.nextLine();
        System.out.printf("\nHello %s!", name);
        
        //Ask the user whether he/she would like to participate a brief survey
        //String answer1 = input.nextLine();
        System.out.println("\nWould you like to participate in a brief survey? (Enter y or yes to continue)");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes") ){

           //Starting the survey
           boolean quit = false;
           do{
                //Get user's inputs
                performSurvey(input);
                generateTheMagicNumbers();

                System.out.println("\nWould you like to answer questions to generate another set of numbers? (Enter y or yes to continue)");
                input.nextLine();
                String response = input.nextLine();
                if(response.equalsIgnoreCase("Y")||response.equalsIgnoreCase("Yes")){
                    quit = false;
                }
                else
                {
                    System.out.println("Thank you for participating in the survey!\n");
                    quit = true;
                }               

           }while (quit != true);
        }
        else
        {
            //quit the program with a message to come back to complete the survey later 
            System.out.println("Please return later to complete the survey.");
        }

        input.close();
    }// End of main

    public static void performSurvey(Scanner in) {
        /*
         * ArrayList<String> questions = new ArrayList<String>();
         * questions.add("What is the name of your favorite pet?");
         * questions.add("What is the age of your favorite pet?");
         * questions.add("What is your lucky number?");
         * questions.add("Do you have a favorite quaterback? (Yes, No)");
         * questions.add("What is two-digit model year of your car?");
         * questions.add("What is the first name of your favorite actor or actress?");
         * questions.add("Please enter a whole number between 1 and 50:");
         * 
         */

        // Get the name of the user's faverite pet
        System.out.println("What is the name of your favorite pet?");
        petName = in.nextLine();

        // Get the age of the user's faverite pet
        System.out.println("What is the age of your favorite pet?");
        petAge = in.nextInt();

        // Get the age of the user's lucky number
        System.out.println("What is your lucky number?");
        luckyNum = in.nextInt();

        // Get the favorite quarterback's Jerzey number
        System.out.println("Do you have a favorite quaterback? (Yes, No)");
        in.nextLine();
        String answer = in.nextLine();
        if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("Yes")) {
            System.out.println("What is the jerzey number of your favorite quarterback?");
            jerzeyNum = in.nextInt();
        }

        // Get the two-digit model year of the user's car
        System.out.println("What is two-digit model year of your car?");
        modelYear = in.nextInt();

        // Get the first name of the user's favorite actor or actress
        System.out.println("What is the first name of your favorite actor or actress?");
        in.nextLine();
        actorName = in.nextLine();

        // Get a random number from 1 to 50
        System.out.println("Please enter a whole number between 1 and 50:");
        randomNum = in.nextInt();
    }

    // This function will return a random number between 0 and the number specified
    // by the input parameter "range"
    public static int getRandomNum(int range) {
        // create instance of Random class
        Random rand = new Random();
        int randNum = rand.nextInt(range);
        return randNum;
    }

    // This function will generate magic ball number by using the user's favorite
    // quarterback's jerzey number
    // or the lucky number and return the magic ball number
    public static int generateMagicBallNum() {
        // Generate a random number
        int rnd = getRandomNum(5) + 1;
        int ballNum = 1;
        if (jerzeyNum > -1) {
            ballNum = jerzeyNum * rnd;
        } else {
            ballNum = luckyNum * rnd;
        }

        // Check to see if the ballNum is greater than 75
        if (ballNum > MAX_BALL_NUM) {
            ballNum -= MAX_BALL_NUM;
        }

        if (ballNum <=0) ballNum += 16;

        return ballNum;
    }

    // This function will generate a number by using the 3rd letter of the pet name
    // and return a number between 1 and 65
    public static int getANumberUsingPetName() {
        char thirdChar = petName.charAt(2); // Get the 3rd char of the pet name

        // Converting the Character to it's int value
        // using getNumericValue() method of Character Class
        // int num = Character.getNumericValue(thirdChar);
        // int num = Integer.parseInt(String.valueOf(thirdChar));
        int num = thirdChar - '0';

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }

        if (num <=0) num += 9;

        return num;

    }

    // This function will generate a number by using the user's car's model year and
    // the lucky number
    public static int getANumberUsingModelYearAndLuckyNumber() {
        int num = modelYear + luckyNum;

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }

        if (num <=0) num += 7;

        return num;

    }

    // This function will generate a number by using the random number entered by
    // the user
    // a random number generated
    public static int getANumberUsingRandomNumbers() {
        int rnd = getRandomNum(5) + 1;
        int num = randomNum - rnd;

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }

        if (num <=0) num += 10;

        return num;
    }

    // This function will generate a number by using the first letter of the
    // Actor or Actress and return a number between 1 and 65
    public static int getANumberUsingFirstCharOfActorName() {
        char firstChar = actorName.charAt(0); // Get the first char of the actor

        // Converting the Character to it's int value
        // using getNumericValue() method of Character Class
        // int num = Character.getNumericValue(thirdChar);
        int num = Integer.parseInt(String.valueOf(firstChar));
        // int num = firstChar - '0';

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }

        if (num <=0) num += 8;

        return num;
    }

    // This function will generate a number by using the last letter of the
    // Actor or Actress and return a number between 1 and 65
    public static int getANumberUsingLastCharOfActorName() {
        int len = actorName.length();
        char lastChar = actorName.charAt(len - 1); // Get the first char of the actor

        // Converting the Character to it's int value
        // using getNumericValue() method of Character Class
        int num = Character.getNumericValue(lastChar);
        // int num = Integer.parseInt(String.valueOf(lastChar));
        // int num = lastChar - '0';

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }

        if (num <=0) num += 6;

        return num;
    }

    // This function will generate a number by using the random number entered by
    // the user
    // a random number generated by the app
    public static int getANumberUsingPetAgeAndModelYear() {
        int num = petAge + modelYear;

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }

        if (num <=0) num += 5;

        return num;
    }

    // This function will generate a number by using the random number entered by
    // the user
    // a random number generated by the app
    public static int getANumberUsingJerzeyNumPetAgeAndLuckyNum() {
        int num = jerzeyNum + petAge + luckyNum;

        if (num > MAX_LOTTORY_NUM) {
            num -= MAX_LOTTORY_NUM;
        }
        
        if (num <=0) num += 42; 

        return num;
    }

    public static void generateTheMagicNumbers() {
        // Generate the Magic Ball number
        int ball = generateMagicBallNum();

        // Get the first lottory number
        int firstNum = getANumberUsingPetName();

        // Get the second lottory number
        int secondNum = getANumberUsingModelYearAndLuckyNumber();

        // Get the third lottory number
        int thirdNum = getANumberUsingRandomNumbers();

        // Get the fourth lottory number
        int fourthNum = getANumberUsingPetAgeAndModelYear();

        // Get the fifth lottory number
        int fifthNum = getANumberUsingJerzeyNumPetAgeAndLuckyNum();

       /*  System.out.printf("\nlottery numbers: %d, %d, %d, %d, %d Magic Ball: %d\n", firstNum, secondNum, thirdNum,
                fourthNum, fifthNum, ball); */

       //
       ArrayList<Integer> lottery = new ArrayList<Integer>();
       lottery.add(firstNum);

       //Check the rest of the numbers to make sure there is no duplicate added to the lollery ArrayList
       if(secondNum != firstNum)
          lottery.add(secondNum);
       else
       {
            do{
                secondNum = getANumberUsingRandomNumbers();
            }while(secondNum == firstNum);

            lottery.add(secondNum);
      }
       
      if((thirdNum != secondNum) && (thirdNum != firstNum))
        lottery.add(thirdNum);
      else
      {
        do{
            thirdNum = getANumberUsingRandomNumbers();
        }while((thirdNum == firstNum) || (thirdNum == secondNum));

        lottery.add(thirdNum);
      }

    if((fourthNum != firstNum) && (fourthNum != secondNum) && (fourthNum != thirdNum) )
      lottery.add(fourthNum);
    else
    {
      do{
          fourthNum = getANumberUsingRandomNumbers();
      }while((fourthNum == firstNum) || (fourthNum == secondNum)||(fourthNum == thirdNum));

      lottery.add(fourthNum);
    }

    if((fifthNum != firstNum) && (fifthNum != secondNum) && (fifthNum != thirdNum) && (fifthNum != fourthNum))
        lottery.add(fifthNum);
    else
    {
        do{
            fifthNum = getANumberUsingRandomNumbers();
        }while((fifthNum == firstNum) || (fifthNum == secondNum)||(fifthNum == thirdNum) ||(fifthNum == fourthNum));

        lottery.add(fifthNum);
    }

    //Sort the lottory numbers
    Collections.sort(lottery); 
    
    // For Each Loop for iterating ArrayList
    System.out.print("\nLottery numbers: ");
    /* for (Integer i : lottery){
 
        // Printing the elements of ArrayList
        System.out.print(i + ", ");

    } */

    for (int i = 0; i < lottery.size(); i++)
    {
        if(i != (lottery.size()-1))
            System.out.print(lottery.get(i) + ", ");
        else
            System.out.print(lottery.get(i) + "  ");
    }

    System.out.printf(" Magic Ball: %d\n", ball);

    }     
}
