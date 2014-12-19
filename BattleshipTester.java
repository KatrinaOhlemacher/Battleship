package SimpleDotComGame;
class BattleshipTester{
	public static void main (String[] args){
		int numUserGuesses = 0;
		SimpleDotCom dotty = new SimpleDotCom();
		GameHelper helper = new GameHelper();
		int randomNum = (int)(Math.random()*5);
		int hits = 0;
		
		int[] locations = new int[3];
		
		for (int i = 0; i <= 2; i++){
			randomNum = randomNum + 1;
			locations[i] = randomNum;
			//System.out.println(randomNum);
		}
		
		dotty.setLocations();

		boolean isAlive = true;
		
		while (isAlive == true){
			String guess = helper.getUserInput("Enter your guess");
			int guessIn = Integer.parseInt(guess);
			System.out.println("Your guess was: " + guessIn);
			numUserGuesses++;
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
	}
}