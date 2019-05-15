

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleRight
{
	private  int obstacleRightX;
	private  int obstacleRightY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	CharacterS2 character = new CharacterS2();
	Random random = new Random();
	
	private ArrayList<ObstacleRight> obstaclesRight = new ArrayList<>();
	
	public ObstacleRight()
	{
		obstacleRightX = 1450;
		obstacleRightY = random.nextInt(901);
		visible = true;
	}
	
	public void update()
	{
		obstacleRightX = obstacleRightX - speed;
		
		if(obstacleRightX < 0)
		{
			visible = false;
		}
		
		if(CharacterS2.getCharacter1x() < (obstacleRightX+40) && (CharacterS2.getCharacter1x() + 75) > obstacleRightX && CharacterS2.getCharacter1y() < (obstacleRightY+40) && (CharacterS2.getCharacter1y() + 60) > obstacleRightY)
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
			ObstacleRight obstacleRight = new ObstacleRight();
			obstaclesRight.add(obstacleRight);
		}
	}

	public  int getObstacleRightX() {
		return obstacleRightX;
	}

	public  int getObstacleRightY() {
		return obstacleRightY;
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

	public List<ObstacleRight> getObstaclesRight() {
		return obstaclesRight;
	}
}
