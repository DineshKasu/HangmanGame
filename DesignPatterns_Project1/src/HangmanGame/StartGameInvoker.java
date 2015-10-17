/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HangmanGame;
import java.util.*;
/**
 *
 * @author Dineshkasu
 */
//Command Invoker Class
public class StartGameInvoker
{
  private List<StartGameCommand> StartGame = new ArrayList<StartGameCommand>();
  
  public void takeSteps(StartGameCommand startgame)
  {
      StartGame.add(startgame);
  }
  
  public void processSteps()
  {
      for(StartGameCommand startgame : StartGame)
      {
          startgame.execute();
      }
  }
  
}
