


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleBottom
{
	private  int obstacleBottomX;
	private  int obstacleBottomY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	CharacterS2 character = new CharacterS2();
	Random random = new Random();
	
	ArrayList<ObstacleBottom> obstaclesBottom = new ArrayList<>();
	
	public ObstacleBottom()
	{
		obstacleBottomX = random.nextInt(1400);
		obstacleBottomY = 900;
		visible = true;
	}
	
	public void update()
	{
		obstacleBottomY = obstacleBottomY - speed;
		
		if(obstacleBottomY < 0)
		{
			visible = false;
		}
		
		if(CharacterS2.getCharacter1x() < (obstacleBottomX+40) && (CharacterS2.getCharacter1x() + 60) > obstacleBottomX && CharacterS2.getCharacter1y() < (obstacleBottomY+40) && (CharacterS2.getCharacter1y() + 75) > obstacleBottomY)
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
			ObstacleBottom obstacleBottom = new ObstacleBottom();
			obstaclesBottom.add(obstacleBottom);
		}
	}
	
	public  int getObstacleBottomX() {
		return obstacleBottomX;
	}

	public  int getObstacleBottomY() {
		return obstacleBottomY;
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

	public List<ObstacleBottom> getObstaclesBottom() {
		return obstaclesBottom;
	}
}

