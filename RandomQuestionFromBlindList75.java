/*
  75 question list from https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions 
  Original link categorized blind list 75 questions conceptwise.
  This program will provide link for a random question from that list without specifying topic name.
  It will always provide an unattempted question everytime along with remaining unattempted question from the list.
  So that we can keep record of our progress.
  Feel free to add more questions to it.
*/
package blindList;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class RandomQuestionFromBlindList75 {
    ArrayList<String> questionsLinks = new ArrayList<String>(
            Arrays.asList("https://leetcode.com/problems/two-sum/",
            		"https://leetcode.com/problems/best-time-to-buy-and-sell-stock/",
            		"https://leetcode.com/problems/contains-duplicate/",
            		"https://leetcode.com/problems/product-of-array-except-self/",
            		"https://leetcode.com/problems/maximum-subarray/",
            		"https://leetcode.com/problems/maximum-product-subarray/",
            		"https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/",
            		"https://leetcode.com/problems/search-in-rotated-sorted-array/",
            		"https://leetcode.com/problems/3sum/",
            		"https://leetcode.com/problems/container-with-most-water/",
            		"https://leetcode.com/problems/sum-of-two-integers/",
            		"https://leetcode.com/problems/number-of-1-bits/",
            		"https://leetcode.com/problems/counting-bits/",
            		"https://leetcode.com/problems/missing-number/",
            		"https://leetcode.com/problems/reverse-bits/",
            		"https://leetcode.com/problems/climbing-stairs/",
            		"https://leetcode.com/problems/coin-change/",
            		"https://leetcode.com/problems/longest-increasing-subsequence/",
            		"https://leetcode.com/problems/longest-common-subsequence/",
            		"https://leetcode.com/problems/word-break/",
            		"https://leetcode.com/problems/combination-sum-iv/",
            		"https://leetcode.com/problems/house-robber/",
            		"https://leetcode.com/problems/house-robber-ii/",
            		"https://leetcode.com/problems/decode-ways/",
            		"https://leetcode.com/problems/unique-paths/",
            		"https://leetcode.com/problems/jump-game/",
            		"https://leetcode.com/problems/clone-graph/",
            		"https://leetcode.com/problems/course-schedule/",
            		"https://leetcode.com/problems/pacific-atlantic-water-flow/",
            		"https://leetcode.com/problems/number-of-islands/",
            		"https://leetcode.com/problems/longest-consecutive-sequence/",
            		"https://leetcode.com/problems/alien-dictionary/",
            		"https://leetcode.com/problems/graph-valid-tree/",
            		"https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/",
            		"https://leetcode.com/problems/insert-interval/",
            		"https://leetcode.com/problems/merge-intervals/",
            		"https://leetcode.com/problems/non-overlapping-intervals/",
            		"https://leetcode.com/problems/meeting-rooms/",
            		"https://leetcode.com/problems/meeting-rooms-ii/",
            		"https://leetcode.com/problems/reverse-linked-list/",
            		"https://leetcode.com/problems/linked-list-cycle/",
            		"https://leetcode.com/problems/merge-two-sorted-lists/",
            		"https://leetcode.com/problems/merge-k-sorted-lists/",
            		"https://leetcode.com/problems/remove-nth-node-from-end-of-list/",
            		"https://leetcode.com/problems/reorder-list/",
            		"https://leetcode.com/problems/set-matrix-zeroes/",
            		"https://leetcode.com/problems/spiral-matrix/",
            		"https://leetcode.com/problems/rotate-image/",
            		"https://leetcode.com/problems/word-search/",
            		"https://leetcode.com/problems/longest-substring-without-repeating-characters/",
            		"https://leetcode.com/problems/longest-repeating-character-replacement/",
            		"https://leetcode.com/problems/minimum-window-substring/",
            		"https://leetcode.com/problems/valid-anagram/",
            		"https://leetcode.com/problems/group-anagrams/",
            		"https://leetcode.com/problems/valid-parentheses/",
            		"https://leetcode.com/problems/valid-palindrome/",
            		"https://leetcode.com/problems/longest-palindromic-substring/",
            		"https://leetcode.com/problems/palindromic-substrings/",
            		"https://leetcode.com/problems/encode-and-decode-strings/",
            		"https://leetcode.com/problems/maximum-depth-of-binary-tree/",
            		"https://leetcode.com/problems/same-tree/",
            		"https://leetcode.com/problems/invert-binary-tree/",
            		"https://leetcode.com/problems/binary-tree-maximum-path-sum/",
            		"https://leetcode.com/problems/binary-tree-level-order-traversal/",
            		"https://leetcode.com/problems/serialize-and-deserialize-binary-tree/",
            		"https://leetcode.com/problems/subtree-of-another-tree/",
            		"https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/",
            		"https://leetcode.com/problems/validate-binary-search-tree/",
            		"https://leetcode.com/problems/kth-smallest-element-in-a-bst/",
            		"https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/",
            		"https://leetcode.com/problems/implement-trie-prefix-tree/",
            		"https://leetcode.com/problems/add-and-search-word-data-structure-design/",
            		"https://leetcode.com/problems/word-search-ii/",
            		"https://leetcode.com/problems/merge-k-sorted-lists/",
            		"https://leetcode.com/problems/top-k-frequent-elements/",
            		"https://leetcode.com/problems/find-median-from-data-stream/"));
	
    ArrayList<String> unAttemptedQuestions = new ArrayList<String>();
    
    RandomQuestionFromBlindList75() {
    	InitializeSetup();
    }
    
    void InitializeSetup() { 
    	File unAttemptedFile = new File("unAttemptedFile.txt");
    	if (!unAttemptedFile.exists()){
    	    try {
    	    	unAttemptedFile.createNewFile();
    	       	FileWriter writer = new FileWriter("unAttemptedFile.txt"); 
    	    	for(String str: questionsLinks) {
    	    	  writer.write(str + System.lineSeparator());
    	    	}
    	    	writer.close();
    	    	unAttemptedQuestions = new ArrayList<String>(questionsLinks);
    	    } catch (IOException e) {
    	        System.out.println("An error occurred in initializing storage.");
    	        e.printStackTrace();
    	    }
    	} else {
    	    BufferedReader reader;
    	    try {
                reader = new BufferedReader(new FileReader("unAttemptedFile.txt"));
    		String line;
    		do {
    		    line = reader.readLine();
    		    if (line != null) unAttemptedQuestions.add(line);
    		} while(line!=null);
    		reader.close();
            } catch (IOException e) {
                e.printStackTrace();
    	    }
    	}
    }
    
    public void giveMeAQuestion() {
    	if (unAttemptedQuestions.size() < 1) {
    	    System.out.println("Congratulations!! You have attempted the whole list.");
    	}
    	int questionNumber = (int) (unAttemptedQuestions.size() * Math.random());
	String questionLink = questionsLinks.get(questionNumber);
	unAttemptedQuestions.remove(questionNumber);
		
	try {
	    File myFile = new File("unAttemptedFile.txt");
	    myFile.delete();
	    myFile.createNewFile();
	    FileWriter writer = new FileWriter("unAttemptedFile.txt"); 
	    for(String str: unAttemptedQuestions) {
	        writer.write(str + System.lineSeparator());
	    }
	    writer.close();
	} catch (IOException e) {
	    System.out.println("An error occurred in initializing storage.");
	    e.printStackTrace();
	}
	    
	System.out.println("Here is your Question : " + questionLink);
	System.out.println(unAttemptedQuestions.size() + " more to go :-)");
    }
    
    public static void main(String[] args) {
	RandomQuestionFromBlindList75 ob1 = new RandomQuestionFromBlindList75();
        System.out.println("Press Enter key to get a question from Blind List...");
        try{
            System.in.read();
            ob1.giveMeAQuestion();
        } catch(Exception e){}
    }
}
