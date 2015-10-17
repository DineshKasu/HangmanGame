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
//GameResultFactory to generate object of concrete class based on given information.
public class GameResultFactory 
{
     public static GameResult getResult(String ResultState)
   {
         switch (ResultState) {
             case "Loss":
                 return new GameLoss();
             case "Win":
                 return new GameWin();
         }
       return null;
   }
}
