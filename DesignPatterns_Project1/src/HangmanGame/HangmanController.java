package HangmanGame;
import java.util.Scanner;

/**
 *
 * @author Dineshkasu
 * Controller module Responsibilities:
•	This module is the main entry point for starting the game.
•	Creates the instance of new game (Model).
•	Tells the view when the game is over and exits the game.
•	Tells the view when another game is going to start.
•	This module consists of the following class.

         HangmanController.java
 */
public class HangmanController 
{
    public static void main(String[] arguments)
    {
        boolean isRunning,isPlaying;
        do
        {
           HangmanModel hangmanModel = new HangmanModel(); 
           
/*COMMAND PATTERN :This pattern is used to startup the hangman game in the model module. 
I have created an interface StartGameCommand which is acting as a command. 
I have created a SetupGameCommand class which acts as a request. 
I have concrete command classes  ProcessFileCommand,SelectRandomWord and MakeArraysCommand implementing StartGameCommand 
interface which will do actual command processing. A class StartGameInvoker is created which acts as a invoker object. 
It can take steps and process steps. StartGameInvoker object uses command pattern to identify which object will execute 
which command based on type of command. HangmanController, our driver class will use StartGameInvoker class to demonstrate command pattern.
*/           
           SetupGameCommand     setupgame = new SetupGameCommand();           
           ProcessFileCommand processfile = new ProcessFileCommand(setupgame,hangmanModel);
           SelectRandomWord    randomword = new SelectRandomWord  (setupgame,hangmanModel);
           MakeArraysCommand   makearrays = new MakeArraysCommand (setupgame,hangmanModel);
           StartGameInvoker   gameInvoker = new StartGameInvoker();
           gameInvoker.takeSteps(processfile);
           gameInvoker.takeSteps(randomword);
           gameInvoker.takeSteps(makearrays);
           gameInvoker.processSteps();
           
 //Singelton Instance for Hangmanview class is being called here           
           HangmanView hangmanView = HangmanView.getInstance();
           
            do
            {
               isPlaying = true;  
               hangmanView.drawState(hangmanModel);  
               System.out.println("\nYou have " + hangmanModel.getremainingGuesses()+ " guesses remaining");
               System.out.print("Guess a Letter: ");
               char guess = hangmanView.getChar();
               hangmanModel.checkChar(guess);
               
               boolean matchguess = hangmanModel.isWrong(guess);
               
/*Factory method:
  This pattern is used when the user input: guess is being matched with the letters present in the correct word, 
 and then we can decide whether the guess is to be added to correct guess list or incorrect guess list.
I  have created a Guesses interface and concrete classes-GuessesCorrect & GuessesWrong implementing the Guesses interface.
 A factory class GuessesFactory is defined as a next step. HangmanController, our driver class will use GuessesFactory to 
get a Guesses object. It will pass information (GuessesCorrect/ GuessesWrong) to GuessesFactory to get the type of object it needs.
  */               
               Guesses guesses = GuessesFactory.matchGuesses(matchguess);
 //Used the Factory to get object of concrete class by passing an information such as type              
               guesses.addGuesses(guess, hangmanModel);

              if(hangmanModel.complete())
                { 
                  hangmanView.endGame("Win",hangmanModel);
                  isPlaying = false;
                }
              else if(hangmanModel.lost())
                {       
                  hangmanView.endGame("Loss",hangmanModel);
                  isPlaying = false;
                } 
                  
            }while(isPlaying);
        
             System.out.println("Do you want to play again ? (Y/N)");
             Scanner scanner = new Scanner(System.in);
             String input = scanner.next();
             char Response = input.charAt(0); 
             isRunning = (Response == 'y') || (Response == 'Y');
             
        }while(isRunning);
    }  
}
