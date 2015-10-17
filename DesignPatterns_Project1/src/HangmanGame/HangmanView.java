
package HangmanGame;
import java.util.*;

/**
 *
 * @author Dineshkasu
 * View module Responsibilities:
•	View module displays the results of module
•	It draws the hangman states
•	It displays the guessed letters, remaining choices and , game results-win or lose.
•	This module consists of the following classes.

HangmanView.java	HangmanImage.java	HangmanimageState5.java
	                HangmanimageState0.java	HangmanimageState6.java
GameResult.java  	HangmanimageState1.java	HangmanImageFactory.java
GameWin.java	        HangmanimageState2.java	
GameLose.java	        HangmanimageState3.java	
GameResultFactory.java	HangmanimageState4.java	

 */
public class HangmanView 
{
      
 /*Singleton :-
In order to make a class Singleton,  we have to follow the below rules:
•	It should have only single instance
•	This instance should be available through a global access
Steps to make class as a singleton.
1.	Create a class which you want to make singleton.
2.	Create a private default constructor of the class.
3.	Create a private static variable of the class created in step1 and this variable should be private and static and
         it should refer to the instance of class created in step1.
4.	Create a accessor method which could always return us back with a instance of class created in step3.
5.	There should not be any method or constructor which can create instance of this class.
Singleton Design pattern is applied to HangmanView.java class, as it can have only 1 single instance in the game.*/
    
     private int badGuesses;
     
  //Default constructor for singleton class   
     private HangmanView()
     {
         
     }
     
    //create an instance for singleton class
    private static HangmanView HangmanViewSingleton = new HangmanView();
   
    //Singleton Instance accessor method
    public static HangmanView getInstance()
    {
        return HangmanViewSingleton;
    }   
    
    //This method is called to display the guessed letters,word and remaining choices
     public void drawState(HangmanModel hangmanModel)
     {
         
        badGuesses = hangmanModel.getbadGuesses();
 
        if(badGuesses < 6 && !hangmanModel.complete())
        {
            System.out.println("\nYou have guessed:" + hangmanModel.getguesses());
      
 /*Factory method This pattern is to display the hangman state images based on the bad guesses.
 I  have created a Hangmanimage interface and concrete classes(hangmanimagestates) implementing
the Hangmanimage interface. A factory class HangmanImageFactory is defined as a next step.
HangmanView, our view module will use HangmanImageFactory to get a Hangmanimage object.
It will pass information (states indicator) to HangmanImageFactory to get the type of object it needs.
 */                
            Hangmanimage image = HangmanImageFactory.getImage(badGuesses);
 //Used the Factory to get object of concrete class by passing an information such as type            
            image.drawimage();
           
            System.out.println("Word:" + hangmanModel.getwordStatus());
        }
     }
     
     //This method is used to take the user input from the screen
     public char getChar()
     {   
         String input;
         Scanner scanner = new Scanner(System.in);
         input = scanner.next();
         return input.charAt(0);
     }
  
     //This method is used to end the hangman game and display the results
      public void endGame(String x,HangmanModel hangmanModel)
     {      
          badGuesses = hangmanModel.getbadGuesses();
          System.out.println("\nYou have guessed:" + hangmanModel.getguesses());
   
 /*Factory method This pattern is to display the hangman state images based on the bad guesses.
 I  have created a Hangmanimage interface and concrete classes(hangmanimagestates) implementing
the Hangmanimage interface. A factory class HangmanImageFactory is defined as a next step.
HangmanView, our view module will use HangmanImageFactory to get a Hangmanimage object.
It will pass information (states indicator) to HangmanImageFactory to get the type of object it needs.
 */        
          Hangmanimage image = HangmanImageFactory.getImage(badGuesses);
   //Used the Factory to get object of concrete class by passing an information such as type        
          image.drawimage();
          
/*Factory method   :This pattern is used to find the Hangman game result :Won or Lose.
I  have created a GameResult interface and concrete classes-GameWin & GameLoss implementing the GameResult interface.
A factory class GameResultFactory is defined as a next step. HangmanView, our driver class will use GameResultFactory 
to get a GameResult object. HangmanController will pass information(Won/Lose) to the HangmanView. 
Then HangmanView will send the same information to GameResultFactory to get the type of object it needs.
 */      
          
          GameResult gameresult = GameResultFactory.getResult(x);
   //Used the Factory to get object of concrete class by passing an information such as type 
          gameresult.DisplayGameResult(hangmanModel);  
     }
    
}
