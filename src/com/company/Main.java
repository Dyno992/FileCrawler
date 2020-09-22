package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            File f1 = new File("src/com/company/FileCrawlerMap");

            Scanner input = new Scanner(System.in);
            System.out.print("\n\nPlease enter a word or a number: ");
            String word = input.next();

            printInfo(word, f1);

        } catch (Exception e) {
            System.out.println("Error during creation!");
            e.printStackTrace();
        }
    }

    public static void printInfo(String word, File file) {

        if (file.isFile()) {

            printPathIfWordIsInFile(word, file);

        } else if (file.isDirectory()) {
            try {

                File[] folderContents = file.listFiles();
                for (int i = 0; i < folderContents.length; i++) {
                    File f = folderContents[i];
                    printInfo(word, f);
                }

            } catch (Exception e) {
                System.out.println("Oops");
                e.printStackTrace();
            }
        }
    }

    public static void printPathIfWordIsInFile(String word, File file) {

        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {

                if (word.equals (sc.next())) {
                    System.out.println("Your word is inside this file: " + file.getCanonicalPath());
                }
            }
        } catch (Exception e) {
            System.out.print("Error! Your word isn't in this file!");
            e.printStackTrace();
        }
    }
}
