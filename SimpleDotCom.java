package SimpleDotComGame;

class SimpleDotCom{
	int numUserGuesses = 0;
	int randomNum = (int)(Math.random()*5);
	int hits = 0;
	int[] locations = new int[3];
	int[] alreadyGuessed = new int[500];
	
			
	public void setGrid(){
		int[] gameGrid = new int[7];
	}
	
	public void setLocations(){
		for (int i = 0; i <= 2; i++){
			randomNum = randomNum + 1;
			locations[i] = randomNum;
			System.out.println(randomNum);
			//System.out.println(locations);
		}//end loop
	}//end method
	
	public void  checkYourself(){
		GameHelper helper = new GameHelper();
		boolean isAlive = true;
		while (isAlive == true){
			String guess = helper.getUserInput("Enter your guess");
			int guessIn = Integer.parseInt(guess);
			System.out.println("Your guess was: " + guessIn);
			numUserGuesses++;
			
			duplicateGuess(guessIn);
			for (int x : alreadyGuessed){
				alreadyGuessed[x] = guessIn;
			}
			
			for (int i : locations){
				if (guessIn == i){
					System.out.println("HIT");
					hits++;
				}
			}//end loop	
		if (hits == 3){
			isAlive = false;
			System.out.println("SUNK");
			System.out.println("Your accuracy rate is: " + hits + " out of " + numUserGuesses);
				}
		}
	
	}//end method
	
	public boolean duplicateGuess(int guessIn){
		boolean result = false;
		
		for (int i : alreadyGuessed){
			if (guessIn == i){
				System.out.println("You've already guessed that!");
				numUserGuesses++;
				break;
			}
		}
		
		return result;
	}//end method
}//end class