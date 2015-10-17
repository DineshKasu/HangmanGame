/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HangmanGame;

import java.io.*;
import java.util.*;

/**
 *
 * @author Dineshkasu
 */
//Request Class for commands execution
public class SetupGameCommand {

    private final List<String> wordList = new ArrayList<>();
    private final Random randomGenerator = new Random();
    private String gameWord, wordStatus = "";
    private char[] wordStat, correctGuesses;
    
//Scan the file and process the words in file
    public void ProcessWordsinFile(HangmanModel hangmanmodel) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("./linuxwords"))) {
            while (in.hasNext()) {
                wordList.add(in.next());
            }
        }
    }
    
//Selects the randomword from the file list
    public void selectRandomWord(HangmanModel hangmanmodel) {
        int randomInt = randomGenerator.nextInt(wordList.size());
        gameWord = wordList.get(randomInt);
        //gameWord = "welcome";

      //  System.out.println("word is " + gameWord);
        wordStat = gameWord.toCharArray();
        hangmanmodel.setgameWord(gameWord);
        hangmanmodel.setwordStat(wordStat);
    }

    public void makeLettersArrays(HangmanModel hangmanmodel) {
        for (int i = 0; i < gameWord.length(); i++) {
            wordStat[i] = '_';
            wordStatus += (wordStat[i] + " ");
        }

        correctGuesses = gameWord.toCharArray();
//Calls the accessor methods        
        hangmanmodel.setwordStatus(wordStatus);
        hangmanmodel.setwordStat(wordStat);
        hangmanmodel.setcorrectGuesses(correctGuesses);

    }
}
