/*
 * I certify that the Java code I am submitting is all my own work.
 * None of the code is copied from any source or any person.
 * I did not use AI to generate the code for my program. (Only used for bug fixing)
 * Signed: Tasnema Mustafa
 * Date: 11/18/2026
 */
/**
 * @author Tasnema Mustafa
 * Date: 11/18/2026
 * Class: CSS405
 * Assignment 4: Trees
 * File Name: Main.java
 * Description:

 * References: CSS 405: Data Structures and Algorithms (Zybooks)
 * https://www.geeksforgeeks.org/java/java-try-catch-block/
 * https://www.w3schools.com/java/java_files_read.asp
 */

// imports
import java.io.FileNotFoundException;
import java.util.Scanner;

// class Main
public class Main {

    public static void main(String[] args) {
        // insert scanner to get the user's file name
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String fileName = keyboard.nextLine();

        WordFrequencyAnalyzer analyzer =
                new WordFrequencyAnalyzer();

        // try-catch block to check the file
        try {
            analyzer.processFile(fileName);

            AVLTree tree = analyzer.getTree();

            if (tree.isEmpty()) {
                System.out.println(
                        "The file contains no valid words to analyze."
                );
                return;
            }

            System.out.println(
                    "\n===== WORD FREQUENCIES (IN-ORDER) ====="
            );
            tree.printInOrder();

            System.out.println(
                    "\n===== TREE STRUCTURE (PRE-ORDER) ====="
            );
            tree.printPreOrder();

        }
        catch (FileNotFoundException e) {

            System.out.println(
                    "File not found: " + fileName
            );
        }
        keyboard.close();
    }
}
