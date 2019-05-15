


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleLeft
{
	private  int obstacleLeftX;
	private  int obstacleLeftY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	CharacterS2 character = new CharacterS2();
	Random random = new Random();
	
	ArrayList<ObstacleLeft> obstaclesLeft = new ArrayList<>();
	
	public ObstacleLeft()
	{
		obstacleLeftX = -100;
		obstacleLeftY = random.nextInt(901);
		visible = true;
	}
	
	public void update()
	{
		obstacleLeftX = obstacleLeftX + speed;
		
		if(obstacleLeftX > 1440)
		{
			visible = false;
		}
		
		if(CharacterS2.getCharacter1x() < (obstacleLeftX+40) && (CharacterS2.getCharacter1x() + 60) > obstacleLeftX && CharacterS2.getCharacter1y() < (obstacleLeftY+40) && (CharacterS2.getCharacter1y() + 60) > obstacleLeftY)
		{
			long stopTime = System.currentTimeMillis();
			Score.setStopTime(stopTime);

			String name = Player.getName();
			String difficulty = Player.getDifficulty();
			String theScore = Score.getTime();
			Score.writeToFileS2(name, difficulty, theScore);
			
			Body.state =Body.STATE.GAMEOVERS2;
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleLeft obstacleLeft = new ObstacleLeft();
			obstaclesLeft.add(obstacleLeft);
		}
	}

	public  int getObstacleLeftX() {
		return obstacleLeftX;
	}

	public  int getObstacleLeftY() {
		return obstacleLeftY;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public static void setSpeed(int s){
		speed = s;
	}


	public List<ObstacleLeft> getObstaclesLeft() {
		return obstaclesLeft;
	}
}

