/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlist;

import java.util.Scanner;

/**
 *
 * @author timberlinecs
 */
public class PlayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
    
        //user input for Song 1
        System.out.println("Enter title: ");
        String title1 = in.nextLine();
        System.out.println("Enter artist: ");
        String artist1 = in.nextLine();
        System.out.println("Enter play time (MM:SS): ");
        String playTime1 = in.nextLine();
            int markIndex1 = playTime1.indexOf(":");
            int min1 = Integer.parseInt(playTime1.substring(0, markIndex1));
            int sec1 = Integer.parseInt(playTime1.substring(markIndex1 + 1));
            int totalPlayTime1 = (sec1 + (min1 * 60)); //calculates total play time in seconds for Song 1
        System.out.println("Enter file name: ");
        String filePath1 = in.nextLine();
        Song song1 = new Song(title1, artist1, totalPlayTime1, filePath1); //saves user input 
        double time1 = song1.getPlayTime(); //this calls and names the play time of the first entry
        
        //user input for Song 2
        System.out.println("Enter title: ");
        String title2 = in.nextLine();
        System.out.println("Enter artist: ");
        String artist2 = in.nextLine();
        System.out.println("Enter play time (MM:SS): ");
        String playTime2 = in.nextLine();
            int markIndex2 = playTime2.indexOf(":");
            int min2 = Integer.parseInt(playTime2.substring(0, markIndex2));
            int sec2 = Integer.parseInt(playTime2.substring(markIndex2 + 1));
            int totalPlayTime2 = (sec2 + (min2 * 60)); //calculates total play time in seconds for Song 1
        System.out.println("Enter file name: ");
        String filePath2 = in.nextLine();
        Song song2 = new Song(title2, artist2, totalPlayTime2, filePath2); //saves user input 
        double time2 = song2.getPlayTime(); //this calls and names the play time of the first entry
        
        //user input for Song 1
        System.out.println("Enter title: ");
        String title3 = in.nextLine();
        System.out.println("Enter artist: ");
        String artist3 = in.nextLine();
        System.out.println("Enter play time (MM:SS): ");
        String playTime3 = in.nextLine();
            int markIndex3 = playTime3.indexOf(":");
            int min3 = Integer.parseInt(playTime3.substring(0, markIndex3));
            int sec3 = Integer.parseInt(playTime3.substring(markIndex3 + 1));
            int totalPlayTime3 = (sec3 + (min3 * 60)); //calculates total play time in seconds for Song 1
        System.out.println("Enter file name: ");
        String filePath3 = in.nextLine();
        Song song3 = new Song(title3, artist3, totalPlayTime3, filePath3); //saves user input 
        double time3 = song3.getPlayTime(); //this calls and names the play time of the first entry
        
          
        double totalTime = (time1 + time2 + time3);
        double average = (totalTime/3);
        double timeAv = (average * 100);
        double roundAverage = Math.round(timeAv);
        double timeAverage = (roundAverage/100); //calculates the average play time of the three songs
        
        System.out.println("Average play time: " + timeAverage); //prints the average time

        int s1 = Math.abs(240-totalPlayTime1);
        int s2 = Math.abs(240-totalPlayTime2);
        int s3 = Math.abs(240-totalPlayTime3); //calculates each song1's time distance from 240 seconds

            if(s1 < s2 && s1 < s3)
            {
                System.out.println("Song with play time closest to 240 secs is: " + title1);
            }
            if(s2 < s3 && s2 < s1)
            {
                System.out.println("Song with play time closest to 240 secs is: " + title2);
            }
            if(s3 < s2 && s3 < s1)
            {
                System.out.println("Song with play time closest to 240 secs is: " + title3);
            } //prints the song1 closest to 240 seconds

String table = String.format("%-20s %-20s %-25s %-10s", "Title", "Artist", "File Name", "Play Time");
System.out.println("==========================================================================================================================");
System.out.println(table); //labels what is about to be printed
System.out.println("==========================================================================================================================");

if(totalPlayTime1 < totalPlayTime2 && totalPlayTime1 < totalPlayTime3)
{

    if(totalPlayTime2 < totalPlayTime3)
    {
        System.out.println(song1.toString()); 
        System.out.println(song2.toString()); 
        System.out.println(song3.toString()); 
        song1.playSong();
        song2.playSong();    
        song3.playSong(); 
    }
    if(totalPlayTime2 > totalPlayTime3)
    {
        System.out.println(song1.toString()); 
        System.out.println(song3.toString()); 
        System.out.println(song2.toString()); 
        song1.playSong();
        song3.playSong();    
        song2.playSong(); 
    }
}

if(totalPlayTime2 < totalPlayTime1 && totalPlayTime2 < totalPlayTime3)
{
    if(totalPlayTime1 < totalPlayTime3)
    {
        System.out.println(song2.toString()); 
        System.out.println(song1.toString()); 
        System.out.println(song3.toString()); 
        song2.playSong();
        song1.playSong();    
        song3.playSong();      
    }
    if(totalPlayTime1 > totalPlayTime3)
    {
        System.out.println(song2.toString()); 
        System.out.println(song3.toString()); 
        System.out.println(song1.toString()); 
        song2.playSong();
        song3.playSong();    
        song1.playSong(); 
    }
}

if(totalPlayTime3 < totalPlayTime2 && totalPlayTime3 < totalPlayTime1)
{
    if(totalPlayTime2 < totalPlayTime1)
    {
        System.out.println(song3.toString()); 
        System.out.println(song2.toString()); 
        System.out.println(song1.toString()); 
        song3.playSong();
        song2.playSong();    
        song1.playSong();      
    }
    if(totalPlayTime2 > totalPlayTime1)
    {
        System.out.println(song3.toString()); 
        System.out.println(song1.toString()); 
        System.out.println(song2.toString()); 
        song3.playSong();
        song1.playSong();    
        song2.playSong(); 
    }
} //plays the songs in order of shortest time to longest time and prints title, artist, file name, and play time in the same order
    System.out.println("==========================================================================================================================");

    }
}
