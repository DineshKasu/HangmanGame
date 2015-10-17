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
public class GuessesCorrect implements Guesses
{
   private String gameWord, wordStatus;
   private char[] wordStat;
   
    @Override
    public void addGuesses(char Guess,HangmanModel hangmanmodel) 
    {
       
        gameWord   = hangmanmodel.getgameWord();
        wordStatus = hangmanmodel.getwordStatus();
        wordStat   = hangmanmodel.getwordStat();
        
        for (int i = 0; i < gameWord.length(); i++)
        {
            if (gameWord.charAt(i) == Guess)
            {
                wordStat[i] = Guess;	// replace a '_' with the char guess
            }
        }
        String tmp = new String(wordStat);		// make a string from the char array
        wordStatus = hangmanmodel.doubleSpaced(tmp);   // update wordStatus by double-spacing the string
        
        hangmanmodel.setwordStat(wordStat);
        hangmanmodel.setwordStatus(wordStatus);
    }
    
}
