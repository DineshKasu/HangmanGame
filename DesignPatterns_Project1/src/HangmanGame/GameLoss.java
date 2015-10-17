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
//concrete class implementing the GameResult interface.
public class GameLoss implements GameResult
{
    @Override
    public void DisplayGameResult(HangmanModel hangmanmodel)         
    {   
        System.out.println("\nYou Lose! \nWord:" + hangmanmodel.doubleSpaced(hangmanmodel.getgameWord()));
    }
}
