

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleTop
{
	private  int obstacleTopX;
	private  int obstacleTopY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	CharacterS2 character = new CharacterS2();
	Random random = new Random();
	
	ArrayList<ObstacleTop> obstaclesTop = new ArrayList<>();
	
	public ObstacleTop()
	{
		obstacleTopX = random.nextInt(1400);
		obstacleTopY = -100;
		visible = true;
	}
	
	public void update()
	{
		obstacleTopY = obstacleTopY + speed;
		
		if(obstacleTopY > 725)
		{
			visible = false;
		}
		
		if(CharacterS2.getCharacter1x() < (obstacleTopX+40) && (CharacterS2.getCharacter1x() + 60) > obstacleTopX && CharacterS2.getCharacter1y() < (obstacleTopY+40) && (CharacterS2.getCharacter1y() + 60) > obstacleTopY)
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
			ObstacleTop obstacleTop = new ObstacleTop();
			obstaclesTop.add(obstacleTop);
		}
	}

	public  int getObstacleTopX() {
		return obstacleTopX;
	}

	public  int getObstacleTopY() {
		return obstacleTopY;
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

	public List<ObstacleTop> getObstaclesTop() {
		return obstaclesTop;
	}
}
