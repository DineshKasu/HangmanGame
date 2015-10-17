package HangmanGame;

import java.io.*;
import java.util.*;

/**
 *
 * @author Dineshkasu * 
 * Model module Responsibilities: 
 * •	Model module contains the information about the word being processed.
 * •	It scans the given input file, load the words into array and selects the random word 
 * •	It tracks the incorrect guess and correct guesses
 * •	It modifies the positions of dashed word with a matching letter, when the same is guessed by user.
 * •	This module consists of the following classes.
 *
 * HangmanModel.java	StartGameCommand.java SetupGameCommand.java 
 * Guesses.java         ProcessFilecommand.java 
 * GuessesWrong.java	SelectRandomWord.java
 * GuessesCorrect.java	MakeArraysCommand.java 
 * GuessesFactory.java  StartGameInvoker.java
 *
 */
public class HangmanModel {

 //The below are Accessor methods fields.
    private int badGuesses, totalGuesses;
    private String gameWord, wordStatus, incorrectGuesses, guesses;
    private char[] correctGuesses, wordStat;

/*Accessors(getters) and Mutators(setters) are declared in below.
    An accessor method is used to return the value of a private field. 
    These methods always return the same data type as their corresponding private field 
    and then simply return the value of that private field
*/
    
    public HangmanModel() {
        incorrectGuesses = "";
        guesses = "";
        badGuesses = 0;
    }

    //Mutator for gamWord
    public void setgameWord(String gameWord) {
        if (!" ".equals(gameWord)) {
            this.gameWord = gameWord;
        } else {
            System.out.println("The random word selected from file is an empty string");
        }
    }

    //Mutator for wordStatus
    public void setwordStatus(String wordStatus) {
        this.wordStatus = wordStatus;
    }

    //Mutator for wordStat
    public void setwordStat(char[] wordStat) {
        this.wordStat = wordStat;
    }

    //Mutator for correctGuesses
    public void setcorrectGuesses(char[] correctGuesses) {

        this.correctGuesses = correctGuesses;
    }

    //Mutator for badGuesses
    public void setbadGuesses(int badGuesses) {
        this.badGuesses = this.badGuesses + badGuesses;
    }

    //Mutator for incorrectGuesses
    public void setincorrectGuesses(String incorrectGuesses) {

        this.incorrectGuesses = incorrectGuesses;
    }

    //Accessor for wordStat
    public char[] getwordStat() {
        return wordStat;
    }

    //Accessor for wordStatus
    public String getwordStatus() {

        return wordStatus;
    }

    //Accessor for badGuesses
    public int getbadGuesses() {

        return badGuesses;
    }

    //Accessor for gameWord
    public String getgameWord() {
        return gameWord;
    }

    //Accessor for guesses
    public String getguesses() {

        return guesses;
    }

    //Accessor for incorrectGuesses
    public String getincorrectGuesses() {

        return incorrectGuesses;
    }

    //Method to get the remaining guesses for user to input guess from the screen
    public int getremainingGuesses() {

        int count = 6 - totalGuesses;
        return count;
    }

   //Method to validate the user guess which is taken from the screen 
    public void checkChar(char letter) {

        letter = Character.toLowerCase(letter);

        if (!Character.isLetter(letter)) {
            System.out.println("Please enter a letter!");
        } else if (guesses.contains(Character.toString(letter))) {
            System.out.println("You've already guessed that letter. Please guess again.");
        } else {
            totalGuesses++;
            if (guesses.equals("")) {
                guesses += letter;
            } else {
                guesses += (" ," + letter);
            }
        }
    }

    //Check whether the guess is correct or wrong against original word.
    public boolean isWrong(char guess) {
        boolean wrong = true;
        for (char ch : correctGuesses) {
            if (guess == ch) {
                wrong = false;
            }
        }
        return wrong;
    }

   //check whether all the charcters are  guessed
    public boolean complete() {
        boolean complete = true;
        for (char ch : wordStat) {
            if ('_' == ch) {
                complete = false;
            }
        }
        return complete;
    }

    //check whether the chances of guessing letter are over or not.
    public boolean lost() {
        boolean lost = false;
        if (getremainingGuesses() == 0) {
            lost = true;
        }
        return lost;
    }

    
    //Method to put the spaces in between one letter to other in a game word
    public String doubleSpaced(String str) {
        String dbl_spaced_str = "";
        while (str.length() > 0) {
            dbl_spaced_str += (str.substring(0, 1) + " ");
            str = str.substring(1);
        }
        return dbl_spaced_str;
    }

}
