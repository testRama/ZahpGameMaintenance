import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Body implements Runnable, KeyListener 
{	
	private Layout layout;
	private String title;
	private int height;
	private int width;
	private Thread thread;
	Character character = new Character();
	CharacterS1 characterS1 = new CharacterS1();
	Obstacle obstacle = new Obstacle();
	private Menu aMenu;
	Enemy enemy = new Enemy();
	boolean gameOver = false;
	CharacterS2 characterS2 = new CharacterS2();
	ObstacleTop obstacleTop = new ObstacleTop();
	ObstacleBottom obstacleBottom = new ObstacleBottom();
	ObstacleRight obstacleRight = new ObstacleRight();
	ObstacleLeft obstacleLeft = new ObstacleLeft();
	Theme aTheme = new Theme();
	BufferedImage image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
	Player player1;
	Player player2;
	boolean playing = true;


	public Body(String title, int height, int width)
	{
		this.title = title;
		this.height = height;
		this.width = width;
	}

	public enum STATE 
	{
		MENU, GAMEM1, GAMES1, GAMES2, OPTIONSS1, OPTIONSS2, THEME, INFO,GAMEOVERC1, GAMEOVERC2, GAMEOVER, HIGHSCORE, GAMEOVERS1, GAMEOVERS2, EXITGAME
	}

	static STATE state = STATE.MENU;

	public void init()
	{
		layout = new Layout(title, height, width);
		layout.getFrame().addKeyListener(this);
		obstacle.multiply(); 
		obstacleTop.army();
		obstacleBottom.army();
		obstacleRight.army();
		obstacleLeft.army();

		enemy.army();

		try {
			Theme.setTheme("Earth");
			image = Theme.getTheme();	
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}


		character = new Character(); 	
		aMenu = new Menu();
		aMenu.setBackgroundImage(image);
	}

	public void draw()  { //throws IOException

		Graphics graphics;
		BufferStrategy buffer;
		buffer = layout.getCanvas().getBufferStrategy();

		if (buffer == null) 
		{
			layout.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = buffer.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);


		if (state == STATE.GAMEM1) {

			graphics.fillRect(0, 410, 1440, 5);


			new Character().drawCharacter(graphics);

			ArrayList<?> projectiles1 = (ArrayList<?>) character.getProjectiles1(); //raw type nu

			for(int i = 0; i < projectiles1.size(); i++)
			{
				graphics.setColor(Color.YELLOW);
				graphics.fillRect(Projectile1.getX(), Projectile1.getY(), 10, 20);
			}

			ArrayList<?> projectiles2 = (ArrayList<?>) character.getProjectiles2(); //raw type nu

			for(int i = 0; i < projectiles2.size(); i++)
			{
				Projectile2 bullet2 = (Projectile2) projectiles2.get(i);
				graphics.setColor(Color.GREEN);
				graphics.fillRect(bullet2.getX(), bullet2.getY(), 10, 20);
			}

			ArrayList<Obstacle> obstacles = (ArrayList<Obstacle>) obstacle.getObstacles(); //raw type nu

			for(int i = 0; i < obstacles.size(); i++)
			{
				Obstacle obstacleTemp = obstacles.get(i);
				graphics.setColor(Color.white);
				graphics.fillOval(obstacleTemp.getObstacleX(), obstacleTemp.getObstacleY(), 40, 40);
			}

		}
		else if(state == STATE.GAMES1){
			graphics.fillRect(0, 600, 1440, 5);
			new Score().drawScore(graphics);
			new CharacterS1().drawCharacter(graphics);

			ArrayList<?> projectiles = (ArrayList<?>) characterS1.getProjectiles(); //raw type nu

			for(int i = 0; i < projectiles.size(); i++)
			{
				graphics.setColor(Color.YELLOW);
				graphics.fillRect(Projectile1.getX(), Projectile1.getY(), 10, 20);
			}

			ArrayList<Enemy> enemies = (ArrayList<Enemy>) enemy.getEnemies(); //raw type nu

			for(int i = 0; i < enemies.size(); i++)
			{
				Enemy enemyTemp = enemies.get(i);
				graphics.setColor(Color.white);
				graphics.fillOval(enemyTemp.getEnemyX(), enemyTemp.getEnemyY(), 40, 40);
			}
		}
		else if(state==STATE.GAMES2){
			new CharacterS2().drawCharacter(graphics);
			new Score().drawTime(graphics);

			ArrayList<ObstacleTop> obstaclesTop = (ArrayList<ObstacleTop>) obstacleTop.getObstaclesTop(); //raw type nu

			for(int i = 0; i < obstaclesTop.size(); i++)
			{
				ObstacleTop obstacleTopTemp = obstaclesTop.get(i);
				graphics.setColor(Color.YELLOW);
				graphics.fillOval(obstacleTopTemp.getObstacleTopX(), obstacleTopTemp.getObstacleTopY(), 40, 40);
			}

			ArrayList<ObstacleBottom> obstaclesBottom = (ArrayList<ObstacleBottom>) obstacleBottom.getObstaclesBottom(); //raw type nu

			for(int i = 0; i < obstaclesBottom.size(); i++)
			{
				ObstacleBottom obstacleBottomTemp = obstaclesBottom.get(i);
				graphics.setColor(Color.WHITE);
				graphics.fillOval(obstacleBottomTemp.getObstacleBottomX(), obstacleBottomTemp.getObstacleBottomY(), 40, 40);
			}


			ArrayList<ObstacleRight> obstaclesRight = (ArrayList<ObstacleRight>) obstacleRight.getObstaclesRight(); //raw type nu

			for(int i = 0; i < obstaclesRight.size(); i++)
			{
				ObstacleRight obstacleRightTemp = obstaclesRight.get(i);
				graphics.setColor(Color.GREEN);
				graphics.fillOval(obstacleRightTemp.getObstacleRightX(), obstacleRightTemp.getObstacleRightY(), 40, 40);
			}

			ArrayList<ObstacleLeft> obstaclesLeft = (ArrayList<ObstacleLeft>) obstacleLeft.getObstaclesLeft(); //raw type nu

			for(int i = 0; i < obstaclesLeft.size(); i++)
			{
				ObstacleLeft obstacleLeftTemp = obstaclesLeft.get(i);
				graphics.setColor(Color.MAGENTA);
				graphics.fillOval(obstacleLeftTemp.getObstacleLeftX(), obstacleLeftTemp.getObstacleLeftY(), 40, 40);
			}
		}

		else if (state == STATE.MENU) 
		{
			aMenu.render(graphics);
		}
		else if (state == STATE.OPTIONSS1) 
		{
			aMenu.optionViewer(graphics);
		}
		else if (state == STATE.OPTIONSS2) 
		{
			aMenu.optionViewer(graphics);
		}
		else if (state == STATE.HIGHSCORE) 
		{
			aMenu.highSoreViewer(graphics);
		}
		else if(state==STATE.THEME){
			aMenu.themeViewer(graphics);
		}
		else if(state==STATE.INFO){
			aMenu.infoViewer(graphics);
		}
		else if(state==STATE.GAMEOVERC1){ // M1 character1 died
			aMenu.gameOver(graphics,0);
		}
		else if(state==STATE.GAMEOVERC2){ // M1 character2 died 
			aMenu.gameOver(graphics,1);
		}
		else if(state==STATE.GAMEOVERS1){
			aMenu.gameOver(graphics,2);
		}
		else if(state==STATE.GAMEOVERS2){ 
			aMenu.gameOver(graphics,3);
		}

		graphics.dispose();
		buffer.show();	
	}

	public void run() 
	{
		init();

		while(playing) 
		{
			Thread.currentThread();

			try
			{
				Thread.sleep(10);
			} 

			catch (InterruptedException e)
			{
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			if (state == STATE.GAMEM1)
			{
				character.moveCharacter();

				ArrayList<?> projectiles1 = (ArrayList<?>) character.getProjectiles1(); //raw type nu

				for(int i = 0; i < projectiles1.size(); i++)
				{
					Projectile1 bullet1 = (Projectile1) projectiles1.get(i);

					if(bullet1.isVisible())
					{
						bullet1.update();
					}

					else
					{
						projectiles1.remove(i);
					}
				}

				ArrayList<?> projectiles2 = (ArrayList<?>) character.getProjectiles2(); //raw type nu

				for(int i = 0; i < projectiles2.size(); i++)
				{
					Projectile2 bullet2 = (Projectile2) projectiles2.get(i);

					if(bullet2.isVisible())
					{
						bullet2.update();
					}

					else
					{
						projectiles2.remove(i);
					}
				}

				ArrayList<Obstacle> obstacles = (ArrayList<Obstacle>) obstacle.getObstacles();

				for(int i = 0; i % 2 == 0; i++)
				{
					Obstacle obstacleTemp2 = obstacles.get(i);

					if(obstacleTemp2.isVisible())
					{
						obstacleTemp2.update();
					}

					else
					{
						obstacles.remove(i);
					}
				}
			}

			if(state == STATE.GAMES1)
			{
				characterS1.moveCharacter();

				ArrayList<?> projectiles = (ArrayList<?>) characterS1.getProjectiles(); //raw type nu

				for(int i = 0; i < projectiles.size(); i++)
				{
					Projectile1 bullet = (Projectile1) projectiles.get(i);

					if(bullet.isVisible())
					{
						bullet.update();
					}

					else
					{
						projectiles.remove(i);
					}
				}

				ArrayList<Enemy> enemies = (ArrayList<Enemy>) enemy.getEnemies(); // raw type nu
				for(int i = 0; i % 2 == 0; i++)

				{
					Enemy enemyTemp2 = enemies.get(i);

					if(enemyTemp2.isVisible())
					{
						gameOver = enemyTemp2.update();
					}

					else
					{
						enemies.remove(i);
					}
				}
			}

			if(state == STATE.GAMES2)
			{
				characterS2.moveCharacter();

				ArrayList<ObstacleTop> obstaclesTop = (ArrayList<ObstacleTop>) obstacleTop.getObstaclesTop();  //raw type nu

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleTop obstacleTopTemp2 = obstaclesTop.get(i);

					if(obstacleTopTemp2.isVisible())
					{
						obstacleTopTemp2.update();
					}
					else
					{
						obstaclesTop.remove(i);
					}

				}

				ArrayList<ObstacleBottom> obstaclesBottom = (ArrayList<ObstacleBottom>) obstacleBottom.getObstaclesBottom(); //raw type nu

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleBottom obstacleBottomTemp2 = obstaclesBottom.get(i);

					if(obstacleBottomTemp2.isVisible())
					{
						obstacleBottomTemp2.update();
					}
					else
					{
						obstaclesBottom.remove(i);
					}
				}

				ArrayList<ObstacleRight> obstaclesRight = (ArrayList<ObstacleRight>) obstacleRight.getObstaclesRight(); //raw type nu

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleRight obstacleRightTemp2 = obstaclesRight.get(i);

					if(obstacleRightTemp2.isVisible())
					{
						obstacleRightTemp2.update();
					}
					else
					{
						obstaclesRight.remove(i);
					}
				}

				ArrayList<ObstacleLeft> obstaclesLeft = (ArrayList<ObstacleLeft>) obstacleLeft.getObstaclesLeft(); //raw type nu

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleLeft obstacleLeftTemp2 = obstaclesLeft.get(i);

					if(obstacleLeftTemp2.isVisible())
					{
						obstacleLeftTemp2.update();
					}
					else
					{
						obstaclesLeft.remove(i);
					}
				}

			}

			if (state == STATE.MENU) 
			{
				new Menu().redirectGame();
			}
			if (state == STATE.OPTIONSS1) 
			{
				new Menu().redirectOptionsS1();
			}
			if (state == STATE.OPTIONSS2) 
			{
				new Menu().redirectOptionsS2();
			}
			if(state==STATE.GAMEOVERC1||state==STATE.GAMEOVERC2 ||state==STATE.GAMEOVERS1||state==STATE.GAMEOVERS2){

				new Menu().redirectBack();
			}
			if(state==STATE.THEME){
				new Menu().redirectOptionschangeTheme();
			}
			if(state==STATE.INFO){
				new Menu().redirectInfo();
			}
			if(state==STATE.HIGHSCORE){
				new Menu().redirectBack();
			}
			if(state == STATE.EXITGAME)
			{
				playing = false;
			}

			draw();

		}
	}

	public synchronized void start() 
	{
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop()
	{
		try 
		{
			thread.join();
		}

		catch (InterruptedException e) 
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		// fångar error
	}

	public void keyPressed(KeyEvent e) 
	{
		int source = e.getKeyCode();

		if(state==STATE.MENU){
			aMenu.setBack(false);
		}

		if(state==STATE.OPTIONSS1){
			aMenu.setS(false);
			if (source == KeyEvent.VK_E) {
				aMenu.setE(true);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(true);
			}
			if(source == KeyEvent.VK_BACK_SPACE){
				aMenu.setBack(true);
			}
		}
		if(state==STATE.OPTIONSS2){
			aMenu.setD(false);
			if (source == KeyEvent.VK_E) {
				aMenu.setE(true);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(true);
			}
			if(source == KeyEvent.VK_BACK_SPACE){
				aMenu.setBack(true);

			}
		}
		if(state == STATE.GAMEM1){
			if(source == KeyEvent.VK_RIGHT)
			{
				character.setRight(true);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				character.setLeft(true);
			}

			if(source == KeyEvent.VK_UP)
			{
				character.setUp(true);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				character.setDown(true);
			}

			if(source == KeyEvent.VK_D)
			{
				character.setD(true);
			}

			if (source == KeyEvent.VK_A)
			{
				character.setA(true);
			}

			if(source == KeyEvent.VK_W)
			{
				character.setW(true);
			}

			if(source == KeyEvent.VK_S)
			{
				character.setS(true);
			}

			if(source == KeyEvent.VK_PERIOD)
			{
				character.shoot1();
			}

			if(source == KeyEvent.VK_G)
			{
				character.shoot2();
			}

		}
		if(state == STATE.GAMES1){
			if(source == KeyEvent.VK_RIGHT)
			{
				characterS1.setRight(true);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS1.setLeft(true);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS1.setUp(true);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS1.setDown(true);
			}
		}
		if(state == STATE.GAMES2){
			if(source == KeyEvent.VK_RIGHT)
			{
				characterS2.setRight(true);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS2.setLeft(true);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS2.setUp(true);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS2.setDown(true);
			}
		}

		if(state==STATE.HIGHSCORE){
			aMenu.setG(false);
			if (source == KeyEvent.VK_BACK_SPACE) {
				aMenu.setBack(true);
			}
		}
		if(state == STATE.THEME){
			aMenu.setT(false);
			if (source == KeyEvent.VK_E) {
				aMenu.setE(true);
			}
			if (source == KeyEvent.VK_F) {
				aMenu.setF(true);
			}
			if (source == KeyEvent.VK_W) {
				aMenu.setW(true);
			}
			if (source == KeyEvent.VK_L) {
				aMenu.setL(true);
			}
		}
		if(state == STATE.INFO){
			aMenu.setI(false);
			if (source == KeyEvent.VK_BACK_SPACE) {
				aMenu.setBack(true);
			}
		}
		if(state == STATE.GAMEOVERC1 ||state == STATE.GAMEOVERC2){
			aMenu.setA(false);
			if (source == KeyEvent.VK_BACK_SPACE) {
				aMenu.setBack(true);
				setNewObstacles();
				setNewCharacter();
			}
		}
		if(state == STATE.GAMEOVERS1){ 
			aMenu.setS(false);
			aMenu.setH(false);
			aMenu.setE(false);
			if (source == KeyEvent.VK_BACK_SPACE) {
				aMenu.setBack(true);
				setNewObstaclesS1();
				setNewCharacterS1();
			}
		}
		if(state == STATE.GAMEOVERS2){ //
			aMenu.setD(false);
			aMenu.setH(false);
			aMenu.setE(false);
			if (source == KeyEvent.VK_BACK_SPACE) {
				aMenu.setBack(true);
				setNewObstaclesS2();
				setNewCharacterS2();
			}
		}
	}

	private void setNewCharacterS2() {
		this.characterS2=new CharacterS2();
		CharacterS2.setCharacter1x(680);
		CharacterS2.setCharacter1y(350);


	}

	private void setNewCharacterS1() {
		this.characterS1=new CharacterS1();
		CharacterS1.setCharacter1x(680);
		CharacterS1.setCharacter1y(680);

	}

	private void setNewCharacter() 
	{
		this.character=new Character();
		Character.setCharacter1x(680);
		Character.setCharacter1y(680);
		Character.setCharacter2x(680);
		Character.setCharacter2y(10);
	}

	private void setNewObstaclesS2() {
		this.obstacleTop = new ObstacleTop();
		this.obstacleBottom = new ObstacleBottom();
		this.obstacleRight = new ObstacleRight();
		this.obstacleLeft = new ObstacleLeft();

		this.obstacleTop.army();
		this.obstacleBottom.army();
		this.obstacleRight.army();
		this.obstacleLeft.army();

	}

	private void setNewObstaclesS1() {
		this.enemy = new Enemy();
		enemy.army();

	}

	private void setNewObstacles() {
		this.obstacle = new Obstacle();
		obstacle.multiply();
	}

	public void keyReleased(KeyEvent e)
	{

		int source = e.getKeyCode();

		if(state==STATE.MENU){
			if (source == KeyEvent.VK_A) {
				aMenu.setA(true);
			}
			if (source == KeyEvent.VK_S) {
				aMenu.setS(true);
			}
			if (source == KeyEvent.VK_D) {
				aMenu.setD(true);
			}
			if (source == KeyEvent.VK_T) {
				aMenu.setT(true);
			}
			if (source == KeyEvent.VK_I) {
				aMenu.setI(true);
			}
			if (source == KeyEvent.VK_G) {
				aMenu.setG(true);
			}
			if (source == KeyEvent.VK_ESCAPE) {
				aMenu.setExit(true);
			}
		}

		if(state==STATE.OPTIONSS1){
			if (source == KeyEvent.VK_S) {
				aMenu.setS(false);
			}
			if (source == KeyEvent.VK_E) {
				aMenu.setE(false);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(false);
			}
			if(source == KeyEvent.VK_BACK_SPACE){
				aMenu.setBack(false);
			}
		}

		if(state==STATE.OPTIONSS2){
			if (source == KeyEvent.VK_S) {
				aMenu.setS(false);
			}
			if (source == KeyEvent.VK_E) {
				aMenu.setE(false);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(false);
			}
			if(source == KeyEvent.VK_BACK_SPACE){
				aMenu.setBack(false);
			}
		}

		if(state == STATE.GAMEM1){
			if (source == KeyEvent.VK_RIGHT) 
			{
				character.setRight(false);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				character.setLeft(false);
			}

			if(source == KeyEvent.VK_UP)
			{
				character.setUp(false);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				character.setDown(false);
			}

			if(source == KeyEvent.VK_D)
			{
				character.setD(false);
			}

			if(source == KeyEvent.VK_A)
			{
				character.setA(false);
			}

			if(source == KeyEvent.VK_W)
			{
				character.setW(false);
			}

			if(source == KeyEvent.VK_S)
			{
				character.setS(false);
			}
		}
		if(state ==STATE.GAMES1){
			if (source == KeyEvent.VK_RIGHT) 
			{
				characterS1.setRight(false);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS1.setLeft(false);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS1.setUp(false);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS1.setDown(false);
			}

			if(source == KeyEvent.VK_SPACE)
			{
				characterS1.shoot();
			}
		}
		if(state==STATE.GAMES2){
			if (source == KeyEvent.VK_RIGHT) 
			{
				characterS2.setRight(false);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS2.setLeft(false);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS2.setUp(false);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS2.setDown(false);
			}
		}
		if(state == STATE.THEME){ 

			if (source == KeyEvent.VK_T) {
				aMenu.setT(false);
			}
			if (source == KeyEvent.VK_E) {
				aMenu.setE(false);
			}
			if (source == KeyEvent.VK_F) {
				aMenu.setF(false);
			}
			if (source == KeyEvent.VK_W) {
				aMenu.setW(false);
			}
			if (source == KeyEvent.VK_L) {
				aMenu.setL(false);
			}
		}
		if(state == STATE.HIGHSCORE && source == KeyEvent.VK_BACK_SPACE){

			aMenu.setG(false);
		}
		if(state == STATE.GAMEOVERC1 && source == KeyEvent.VK_BACK_SPACE){
			aMenu.setBack(false);
		}
		if(state == STATE.GAMEOVERC2 && source == KeyEvent.VK_BACK_SPACE){

			aMenu.setBack(false);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// this is empty

	}

}