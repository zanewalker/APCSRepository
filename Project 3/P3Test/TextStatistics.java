/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package textstatistics;

/**
 *
 * @author Zane Walker
 */
    
import java.io.File;
import java.io.FileNotFoundException; import java.util.Scanner;
import java.util.StringTokenizer;
/**
* Java imports were used to help create this class, specific citations are provided below
* Other than import usage, the entire class was written individually */
public class TextStatistics implements TextStatisticsInterface {
    private File textFile;
    private Scanner fileScan;
    private int lineCount;
    private int wordCount;
    private int charCount;
    private final String delimeters = " ,.;:'\\\"&!?-_\n\t12345678910[]{}()@#$%^/*+-";
    private StringTokenizer tokenizer;
    private String line;
    private String results;
    private int[] wordLength;
    private int[] letterCount;
    private double avgWordLength;
    public TextStatistics(File file){ 
        textFile = file;
        wordLength = new int[24]; 
        letterCount = new int[26];
            try {
                fileScan = new Scanner(textFile); 
                
                while(fileScan.hasNextLine()) {
                    lineCount++;
                    line = fileScan.nextLine();
                    charCount += line.length() + 1;
                    tokenizer = new StringTokenizer(line, delimeters);
                    
                    for(int r = 0; r < line.length(); r++) {
                        line = line.toLowerCase();
                        char letter = line.charAt(r);
                        int letterValue = (int)(letter) - 97; 
                        
                        if(letterValue >= 0 && letterValue <= 25) {
                            letterCount[letterValue] += 1;
                        }
                    }
                
                    while(tokenizer.hasMoreTokens()) {
                        String word = tokenizer.nextToken();
                        wordCount++;
                        wordLength[word.length()] += 1;
                    
                        if(word.length() >= 23) {
                            wordLength[word.length()] = 24;
                        }
                    } 
                }
                
                for(int y = 0; y < 23; y++) { 
                    avgWordLength += wordLength[y] * y;
                }
                
                avgWordLength /= wordCount; 
            } 
            
            catch (FileNotFoundException ex) { 
                System.out.println("Error: File cannot be located\n\n");
            } 
    }
    
    public int getCharCount() { 
        return charCount;
    }
    
    public int getWordCount() { 
        return wordCount;
    }
    
    public int getLineCount() { 
        return lineCount;
    }
    
    public int[] getLetterCount() { 
        return letterCount;
    }
    
    public int[] getWordLengthCount() { 
            return wordLength;
    }
    
    public double getAverageWordLength() { 
        return avgWordLength;
    }
    
    public String wordTable() {
        int[] wordLength = getWordLengthCount();
        String results = ("Word Frequency Table: \n");
        results += ("--------- -------------\n");
        results += ("Length\t     Frequency");
        results += ("\n--------- -------------");
        
        for(int j = 0; j < 23; j++ ) {
            if(wordLength[j] != 0) { 
                if(j != 0){
                    results += "\n"; 
                }
                
                if(j < 10) {
                    results += (" " + j);
                }   
                
                else{
                    results += (" " + j);
                }
                results += "\t     " + wordLength[j];
            }
        }
        
        results += ("\n");
        return results; 
    }
    
    public String letterTable() {
        int[] letterAmount = getLetterCount();
        String results = ("\nLetter Frequency Table:\n"); 
        results += ("------------------------\n");
        
        for(int w = 0; w < 13; w++) {
            results += (char)(w+97) + " = " + letterAmount[w] + "\t\t" + (char)(w+110) + " = " + letterAmount[w+13] + "\n";
        }
        
        return results;
    }
    
    public String toString() {
        results = "The total lines: " + getLineCount() + "\n";
        results += "The total words: " + getWordCount() + "\n";
        results += "The average word length: " + getAverageWordLength() + "\n";
        results += "The total number of characters: " + getCharCount() + "\n"; 
        results += wordTable();
        results += letterTable();
        return results;
    }
}
    

