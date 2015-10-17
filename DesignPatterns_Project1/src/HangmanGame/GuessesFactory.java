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
//GuessesFactory to generate object of concrete class based on given information.
public class GuessesFactory
{
      public static Guesses matchGuesses(boolean match)
   {  
        if(match)
        {
            return new GuessesWrong();
        }
        else
        {
            return new GuessesCorrect();
        }
   }  
}
