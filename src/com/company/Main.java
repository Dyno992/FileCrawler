package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            // Creting map and files

            File startingFolder = new File("FileCrawler");
            File f1 = new File("FileCrawler/test1.txt");
            File f2 = new File("FileCrawler/test2.txt");
            File f3 = new File("FileCrawler/test3.txt");
            File f4 = new File("FileCrawler/test4.txt");

            startingFolder.mkdir();
            for (File file : Arrays.asList(f1, f2, f3, f4)) {
                file.createNewFile();
            }

            // Writing into files

            FileWriter fw1 = new FileWriter(f1);
            fw1.write("Hello");
            fw1.flush();
            fw1.close();

            FileWriter fw2 = new FileWriter(f2);
            fw2.write("How");
            fw2.flush();
            fw2.close();

            FileWriter fw3 = new FileWriter(f3);
            fw3.write("Are");
            fw3.flush();
            fw3.close();

            FileWriter fw4 = new FileWriter(f4);
            fw4.write("You?");
            fw4.flush();
            fw4.close();

            System.out.println("\n\nThe folder has been created in " + startingFolder.getCanonicalPath());
            System.out.println("Contains: " + Arrays.toString(startingFolder.list()));
            System.out.println("Folder name: " + startingFolder.getName());
            System.out.println("Directory?: " + startingFolder.isDirectory());
            System.out.println("Readable: " + startingFolder.canRead());
            System.out.println("Writable: " + startingFolder.canWrite());
            System.out.println("Executable: " + startingFolder.canExecute());
            System.out.println("-------");
            System.out.println();

            printInfo(startingFolder);
        } catch (Exception e) {
            System.out.println("Error during creation!");
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
            }
        }
    }
}
