/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HangmanGame;

/**
 *
 * @author Dineshkasu
 */
//concrete class implementing the Guesses interface.
public class GuessesWrong implements Guesses
{
     private String  incorrectGuesses;

    @Override
    public void addGuesses(char Guess, HangmanModel hangmanmodel)
    {
        incorrectGuesses = hangmanmodel.getincorrectGuesses();
        
         if (incorrectGuesses.equals(""))
        {
        /* special case to make sure commas are inserted correctly */
            incorrectGuesses += Guess;
        }
        else
        {
            incorrectGuesses += (" ," + Guess);
        }
        
         hangmanmodel.setincorrectGuesses(incorrectGuesses);
         hangmanmodel.setbadGuesses(1);
    }
    
}
