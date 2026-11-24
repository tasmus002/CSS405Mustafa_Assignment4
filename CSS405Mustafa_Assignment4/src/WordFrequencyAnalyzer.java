/**
 * Method Name: WordFrequencyAnalyzer.java
 * Description:
**/
// NOTE: for some reason pressing tab won't indent it properly and only indents slightly
// its only this file and I'm not sure how to fix it

// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// make WordFrequencyAnalyzer class
public class WordFrequencyAnalyzer {
 private AVLTree tree;

 // create the tree
 public WordFrequencyAnalyzer() {
  tree = new AVLTree();
 }

 // process the file
 public void processFile(String fileName)
         throws FileNotFoundException {

  Scanner input = new Scanner(new File(fileName));

  while (input.hasNext()) {

   String word = input.next(); // get each word from the file

   word = normalize(word);

   if (!word.isEmpty()) {
    tree.insert(word);
   }
  }

  input.close();
 }

 // checking each word to ignore any differences (like Hello and hello)
 private String normalize(String word) {
  word = word.toLowerCase();
  word = word.replaceAll(
          "[^a-z0-9]",
          ""
  );

  return word;
 }

 public AVLTree getTree() {
  return tree;
 }
}
