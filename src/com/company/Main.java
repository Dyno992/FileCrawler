package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating map and files

            //File startingFolder = new File("FileCrawler");
            File f1 = new File("FileCrawler/test1.txt");



            Scanner input = new Scanner(System.in);
            System.out.print("Please enter a word or a number: ");
            String word = input.nextLine();

            printPathIfWordIsInFile(word, f1);

        } catch (Exception e) {
            System.out.println("Error during creation!");
            e.printStackTrace();
        }
    }

    public static void printInfo(File file) {
        // Om det är en vanlig fil: Skriv ut namnet på filen
        // Om det är en mapp: Skriv ut sökvägen på mappen, och gå in i mappen

        if (file.isFile()) {
            System.out.println("Fil: " + file.getName());
        } else if (file.isDirectory()) {
            try {
                System.out.println("Mapp: " + file.getCanonicalPath());

                File[] folderContents = file.listFiles();
                for (int i = 0; i < folderContents.length; i++) {
                    File f = folderContents[i];
                    printInfo(f);
                }

            } catch (Exception e) {
                System.out.println("Oops");
                e.printStackTrace();
            }
        }
    }

    public static void goThroughAllFoldersAndFiles(String word, File file) {



    }

    public static void printPathIfWordIsInFile(String word, File file) {
        try {

// print path if word = input from scanner and print message like "Successful"
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {

                if (word.equals (sc.next())) {
                    System.out.println("Your word is inside this file: " + file.getCanonicalPath());
                }
            }

        } catch (Exception e) {
            System.out.print("Error while searching through all files!");
            e.printStackTrace();
        }
    }
}
