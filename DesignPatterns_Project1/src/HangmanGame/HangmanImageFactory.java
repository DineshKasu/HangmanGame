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
//HangmanImageFactory to generate object of concrete class based on given information.
public class HangmanImageFactory
{
   public static Hangmanimage getImage(int ImageState)
   {
       if(ImageState == 0)
       {
           return new HangmanImageState0();
       }
       else if(ImageState == 1)
       {
           return new HangmanImageState1();
       }
       else if(ImageState == 2)
       {
           return new HangmanImageState2();
       }
       else if(ImageState == 3)
       {
           return new HangmanImageState3();
       }
       else if(ImageState == 4)
       {
           return new HangmanImageState4();
       }
       else if(ImageState == 5)
       {
           return new HangmanImageState5();
       }
       else if(ImageState == 6)
       {
           return new HangmanImageState6();
       }
       return null;
   }
     
}
