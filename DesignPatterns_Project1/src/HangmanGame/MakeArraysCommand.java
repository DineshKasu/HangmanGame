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
//Class implementing the StartGameCommand Interface
public class MakeArraysCommand implements StartGameCommand {

    private SetupGameCommand setupgame;
    private HangmanModel hangmanmodel;

    public MakeArraysCommand(SetupGameCommand setupgame, HangmanModel hangmanmodel) {
        this.setupgame = setupgame;
        this.hangmanmodel = hangmanmodel;
    }

    @Override
    public void execute() {
        setupgame.makeLettersArrays(hangmanmodel);
    }

}
