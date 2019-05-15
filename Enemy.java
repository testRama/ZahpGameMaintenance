
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy
{
	private int enemyX;
	private int enemyY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	Projectile1 projectile = new Projectile1();
	CharacterS1 character = new CharacterS1();
	Random random = new Random();
	
	ArrayList<Enemy> enemies = new ArrayList<>();
	
	public Enemy()
	{
		enemyX = random.nextInt(1400);
		enemyY = -100;
		visible = true;
	}
	public static void setSpeed(int velocity){
		speed = velocity;
	}
	
	public boolean update()
	{
		boolean gameOver = false;
		enemyY = enemyY + speed;
		
		if(enemyY >= 570)
		{
			String name = Player.getName();
			String difficulty = Player.getDifficulty();
			int theScore = Score.getScore();
			Score.writeToFileS1(name, difficulty, theScore);
			//score.fileHighScoreS1(name,difficulty,theScore);
			Body.state = Body.STATE.GAMEOVERS1;
		}
		
		if(Projectile1.getX() < (enemyX+40) && (Projectile1.getX() + 10) > enemyX && Projectile1.getY() < (enemyY+40) && (Projectile1.getY() + 20) > enemyY)
		{
			visible = false;
			Score.score = Score.score + 5;
		}
		return gameOver;
	}

	public void army()
	{
		
		for(int i = 0; i < 100; i++)
		{
			Enemy enemy = new Enemy();
			enemies.add(enemy);
		}
	}

	public int getEnemyX() {
		return enemyX;
	}

	public int getEnemyY() {
		return enemyY;
	}

	public boolean isVisible() {
		return visible;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}
}
