

public class Player {
	public static String name ="";
	public static double score = 0;
	public static String difficulty ="";
	public static String gameMode ="";
	
	Player(){
		
	}
	Player(String currentName){
		name=currentName;
	}
	/*Player(String tempName, String tempDifficulty, double tempScore){
		name=tempName;
		difficulty = tempDifficulty;
		score = tempScore;
		
	}*/
	public static void setName(String currentName){
		name = currentName;
	}
	public static void setScore(double currentScore){
		score = currentScore;
	}
	public static void setDifficulty(String currentDifficulty){
		difficulty = currentDifficulty;
	}
	public static void setGameMode(String currentGameMode){
		gameMode = currentGameMode;
	}
	
	public static String getName(){
		return name;
	}
	public static double getScore(){
		return score;
	}
	public static String getDifficulty(){
		return difficulty;
	}
	public static String getGameMode(){
		return gameMode;
	}
	public static String getString(){
		return "Player name; " + name + " difficulty " + difficulty + " score " + score + "\n";
	}

}
