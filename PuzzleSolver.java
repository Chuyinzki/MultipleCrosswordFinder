import java.util.Arrays;

/**
 * @author Jesus Villegas
 * A solver for 2D char arrays against a preset Dictionary.
 * Will work with even and uneven 2D blocks of chars.
 * 
 */
public class PuzzleSolver {
	
	//Dictionary words will be checked against
	public static String[] DICTIONARY = {"OX","CAT","TOY","AT","DOG","CATAPULT","T"};

	//Checking to see if inputed string is a word in the dictionary
    static boolean IsWord(String testWord){
        return Arrays.asList(DICTIONARY).contains(testWord);
    }
    
    /**
     * Simple test to make sure IsWord is working against the Dictionary
     */
    public static void simpleTest(){
    	String[] testDictionary = {"DRIBBLE","OX","CAT","TOY","AT","DOG","CATAPULT","T","DONKEY","PEANUT","JUMBALIA","TOYS","TO"};
		
		for(int i = 0; i < testDictionary.length; i++)
			if(IsWord(testDictionary[i]))
				System.out.println(testDictionary[i] + " is part of original DICTIONARY.");
			else
				System.out.println(testDictionary[i] + " is NOT part of original DICTIONARY.");
    }
    
    /**
     * @param puzzle 
     * Allows user to print puzzle. Good for debugging and print statements.
     */
    public static void printPuzzle(char[][] puzzle){
    	int iterX = 0;
    	int iterY = 0;
    	String wordToPrint = "";
    	
    	while(iterY < puzzle.length){
    		wordToPrint = "";
    		while(iterX < puzzle[iterY].length){
    			wordToPrint += puzzle[iterY][iterX];
    			iterX++;
    		}
    		System.out.println(wordToPrint);
    		iterY++;
    		iterX = 0;
    	}
    }
    
    /**
     * Finds word matches for the 2D char array in all directions 
     * and can print out results as the words are found and again at 
     * the end showing how many words were found as well as the puzzle.
     * 
     * Works by checking every word as an anchor point and working
     * in all directions of that anchor to search for words. Moves
     * on to next anchor point and repeats until the last char
     * (anchor point) is checked.
     * 
     * To enable debug print statements set 'debugStatements' to true.
     * 
     * Number of words found is returned.
     * 
     * @param puzzle
     * @return number of matched words
     */
    public static int FindWords(char[][] puzzle){
		int wordsMatched = 0;
		int anchorX = 0;
		int anchorY = 0;
		int iterX = 0;
		int iterY = 0;
		boolean debugStatements = false;
		String currentWord = "";
		char anchorChar;
		
		do{
			//set and check Anchor
			anchorChar = puzzle[anchorY][anchorX];
			currentWord = Character.toString(anchorChar);
			if(IsWord(currentWord)){
				wordsMatched++;
				if(debugStatements)
					System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
				}
			
			//checkUp	
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterY--;
			while(iterY >= 0 && iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterY--;
			}
			
			//checkUpRight	
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterY--;
			iterX++;
			while(iterY >= 0 && iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterY--;
				iterX++;
			}
			
			//checkRight
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterX++;
			while(iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterX++;
			}
			
			//checkBottomRight
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterX++;
			iterY++;
			while(iterY < puzzle.length && iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterX++;
				iterY++;
			}
			
			//checkBottom
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterY++;
			while(iterY < puzzle.length && iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterY++;
			}
			
			//checkBottomLeft
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterY++;
			iterX--;
			while(iterY < puzzle.length && iterX >= 0 && iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterY++;
				iterX--;
			}
			
			//checkLeft
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterX--;
			while(iterX >= 0){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterX--;
			}
			
			//checkUpLeft
			currentWord = Character.toString(anchorChar);
			iterX = anchorX;
			iterY = anchorY;
			
			iterX--;
			iterY--;
			while(iterY >= 0 && iterX >= 0  && iterX < puzzle[iterY].length){
				currentWord = currentWord + puzzle[iterY][iterX];
				if(IsWord(currentWord)){
					wordsMatched++;
					if(debugStatements)
						System.out.println("Word #" + wordsMatched +" Found: " + currentWord);
					}
				iterX--;
				iterY--;
			}
			
			//Move Anchor Point
			anchorX++;
			if(anchorX >= puzzle[anchorY].length){anchorX = 0; anchorY++;}
		}
		
		while(anchorY < puzzle.length);
		
		System.out.println(wordsMatched + " words have been found for puzzle:");
		printPuzzle(puzzle);
		
		return wordsMatched;
    }
	
    
    /**
     * exampleOne and exampleTwo are the original puzzles given to
     * test. To use, simply call:
     * 'FindWords(exampleOne);'
     * If you would like to see the puzzle, simply call:
     * 'printPuzzle(exampleTwo);'
     * 
     * @param args
     */
    public static void main(String[] args) {
		//simpleTest();
		char[][] exampleOne = {{'C','A','T'},{'X','Z','T'},{'Y','O','T'}};
		char[][] exampleTwo = {{'C','A','T','A','P','U','L','T'},
								{'X','Z','T','T','O','Y','O','O'},
								{'Y','O','T','O','X','T','X','X'}};
		char[][] exampleUpUneven = {{'C','A','T','A'},
									{'X','Z','T','T','O','Y','O','O'},
									{'Y','O','T','O','X','T','X','X'}};
		char[][] exampleDownUneven = {{'C','A','T','A','P','U','L','T'},
										{'X','Z','T','T','O','Y','O','O'},
										{'Y','O','T','O'}};
		char[][] exampleMiddleUneven = {{'C','A','T','A','P','U','L','T'},
										{'X','Z','T'},
										{'Y','O','T','O','X','T','X','X'}};
		char[][] exampleAllUneven = {{' ',' ',' ','T'},{'X','Z','T'},{'Y','O','T','O','X','T','X','X'}};
		
		//printPuzzle(exampleOne);
		FindWords(exampleOne);
		FindWords(exampleTwo);
		//FindWords(exampleUpUneven);
		//FindWords(exampleDownUneven);
		//FindWords(exampleAllUneven);
		
	}

}
