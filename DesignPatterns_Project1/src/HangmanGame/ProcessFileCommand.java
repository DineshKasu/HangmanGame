/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HangmanGame;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dineshkasu
 */
//Class implementing the StartGameCommand Interface
public class ProcessFileCommand implements StartGameCommand {

    private SetupGameCommand setupgame;
    private HangmanModel hangmanmodel;

    public ProcessFileCommand(SetupGameCommand setupgame, HangmanModel hangmanmodel) {
        this.setupgame = setupgame;
        this.hangmanmodel = hangmanmodel;
    }

    @Override
    public void execute() {
        try {
            setupgame.ProcessWordsinFile(hangmanmodel);
        } catch (FileNotFoundException ex) {
            System.err.println("linux words File is not found");
        }
    }

}
