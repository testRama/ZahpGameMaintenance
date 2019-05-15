

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Menu{	
	private static boolean exit;
	private static boolean space;
	private static boolean g;
	private static boolean e;
	private static boolean h;
	private static boolean l;
	private static boolean back;
	private static boolean a;
	private static boolean s;
	private static boolean d;
	private static boolean t;
	private static boolean i;
	private static boolean w;
	private static boolean f;
	Theme aTheme;
	static BufferedImage image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
	private String backText = "Press backspace to return";
	private String arial = "arial";

	public static BufferedImage getTheme(){
		return image;
	}

	public boolean getA()
	{
		return a;
	}

	public void setA(boolean status)
	{
		a = status;
	}
	public boolean getG()
	{
		return g;
	}
	public void setG(boolean status)
	{
		g = status;
	}
	public boolean getL()
	{
		return l;
	}
	public void setL(boolean status)
	{
		l = status;
	}
	public boolean getS()
	{
		return s;
	}

	public void setS(boolean status)
	{
		s = status;
	}
	public boolean getD()
	{
		return d;
	}

	public void setD(boolean status)
	{
		d = status;
	}

	public boolean getT()
	{
		return t;
	}

	public void setT(boolean status)
	{
		t = status;
	}
	public boolean getI()
	{
		return i;
	}

	public void setI(boolean status)
	{
		i = status;
	}

	public boolean getBack()
	{
		return back;
	}

	public void setBack(boolean status)
	{
		back = status;
	}

	public boolean getH()
	{
		return h;
	}

	public void setH(boolean status)
	{
		h = status;
	}

	public boolean getE()
	{
		return e;
	}

	public void setE(boolean status)
	{
		e = status;
	}
	public boolean getF()
	{
		return f;
	}

	public void setF(boolean status)
	{
		f = status;
	}
	public boolean getW()
	{
		return w;
	}

	public void setW(boolean status)
	{
		w = status;
	}

	public boolean getSpace()
	{
		return space;
	}

	public void setSpace(boolean status)
	{
		space = status;
	}

	public boolean getExit()
	{
		return exit;
	}
	public void setExit(boolean status)
	{
		exit = status;
	}

	private Rectangle playM1Button = new Rectangle(450, 200, 500, 60);
	private Rectangle playS1Button = new Rectangle(450, 300, 500, 60);
	private Rectangle playS2Button = new Rectangle(450, 400, 500, 60);
	private Rectangle exitButton = new Rectangle(250, 550, 400, 60);
	private Rectangle themeButton = new Rectangle(750, 550, 400, 60);
	private Rectangle highScoreButton = new Rectangle(250, 700, 400, 60);
	private Rectangle infoButton = new Rectangle(750, 700 ,400, 60);

	private Rectangle easyButton = new Rectangle(520, 250, 400, 60);
	private Rectangle hardButton = new Rectangle(520, 400, 400, 60);
	private Rectangle returnButton = new Rectangle(450, 750, 550, 60);

	private Rectangle earthButton = new Rectangle(250, 300, 370, 60);
	private Rectangle fireButton = new Rectangle(750, 300, 370, 60);
	private Rectangle waterButton = new Rectangle(250, 600, 370, 60);
	private Rectangle airButton = new Rectangle(750, 600, 370, 60);

	public void setBackgroundImage(BufferedImage img){
		image = img;
	}

	public void render(Graphics graphics)
	{
		image =Theme.getTheme();
		graphics.drawImage(image, 0,0, null);

		Graphics2D g2d = (Graphics2D) graphics;

		Font fnt0 = new Font(arial, Font.BOLD, 60);
		Font fnt1 = new Font(arial, Font.BOLD, 40);

		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("ZAHP GAME", 520, 100);

		graphics.setFont(fnt1);
		graphics.drawString("MultiPlayer M1: Press A", playM1Button.x+10 , playM1Button.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("SinglePlayer S1: Press S", playS1Button.x +10, playS1Button.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("SinglePlayer S2: Press D", playS2Button.x + 10, playS2Button.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("Exit: Press escape", exitButton.x + 25, exitButton.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("Theme: Press T", themeButton.x + 25, themeButton.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("HighScore: Press G", highScoreButton.x + 15, highScoreButton.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("Info: Press I", infoButton.x + 30, infoButton.y + 40);

		g2d.draw(playM1Button);
		g2d.draw(playS1Button);
		g2d.draw(playS2Button);
		g2d.draw(exitButton);
		g2d.draw(themeButton);
		g2d.draw(highScoreButton);
		g2d.draw(infoButton);

	}

	public void optionViewer(Graphics graphics)
	{


		graphics.drawImage(image, 0,0, null);
		Graphics2D g1d = (Graphics2D) graphics;

		Font fnt0 = new Font(arial, Font.BOLD, 60);
		Font fnt1 = new Font(arial, Font.BOLD, 40);

		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Difficulty level", 520, 100);

		graphics.setFont(fnt1);
		graphics.drawString("Press E for easy", easyButton.x + 50, easyButton.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString("Press H for hard", hardButton.x + 50, hardButton.y + 40);

		graphics.setFont(fnt1);
		graphics.drawString(backText, returnButton.x + 30, returnButton.y + 40);

		g1d.draw(easyButton);
		g1d.draw(hardButton);
		g1d.draw(returnButton);
	}

	public void themeViewer(Graphics graphics){

		graphics.drawImage(image, 0,0, null);

		Graphics2D g1d = (Graphics2D) graphics;

		Font fnt1 = new Font(arial, Font.BOLD, 40);

		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Earth: Press E", earthButton.x + 50, earthButton.y + 40);

		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Fire: Press F", fireButton.x + 50, fireButton.y + 40);

		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Water: Press W", waterButton.x + 50, waterButton.y + 40);

		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Air: Press L", airButton.x + 50, airButton.y + 40);

		g1d.draw(earthButton);
		g1d.draw(fireButton);
		g1d.draw(waterButton);
		g1d.draw(airButton);
	}

	public void infoViewer(Graphics graphics) {
		graphics.drawImage(image, 0,0, null);
		Graphics2D g1d = (Graphics2D) graphics;

		Font fnt0 = new Font(arial, Font.BOLD, 60);
		Font fnt1 = new Font(arial, Font.BOLD, 30);
		Font fnt2 = new Font(arial, Font.BOLD, 20);
		Font fnt3 = new Font(arial, Font.BOLD, 50);

		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Information", 520, 100);

		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("MultiPlayer M1",50, 270);
		graphics.drawString("SinglePlayer S1",50, 350);
		graphics.drawString("SinglePlayer S2 ",50, 430);

		graphics.setFont(fnt3);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Keys" ,50, 520);

		graphics.setFont(fnt2);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Two players will try to defeat each other with projectiles, but be careful, there will be incoming objects in your way. Last man standing wins!", 50, 300);
		graphics.drawString("One player will try to shoot down incoming obstacles. Dont let them past the line! Collect points by destroying the obstacles with your projectiles ", 50, 380);
		graphics.drawString("One player will try to avoid the obstacles comming from all sides. Stay alive as long as you can!", 50, 460);

		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Move up: Up arrow / W   Move Down: Down arrow / S  ", 70, 570);
		graphics.drawString("Move to the sides: Right and left arrow / A and D", 70, 620);
		graphics.drawString("Shoot projectiles: . / G", 70,670);

		graphics.setFont(fnt1);
		graphics.drawString(backText, returnButton.x + 60, returnButton.y + 40);
		g1d.draw(returnButton);

	}
	public void gameOver(Graphics graphics, int j) {
		Graphics2D g1d = (Graphics2D) graphics;
		graphics.drawImage(image, 0,0, null);

		Font fnt0 = new Font(arial, Font.BOLD, 60);
		Font fnt1 = new Font(arial, Font.BOLD, 30);

		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("GAME OVER", 520, 100);

		if(j==0){ //M1 character 1
			graphics.drawString(Player.getName() + " wins!", 490, 300); // player1
		}
		if(j==1){//M1 character 2
			graphics.drawString(Player.getName() + " wins!", 490, 300); // player2
		}
		if(j==2){ //S1
			graphics.drawString(Player.getName() + "  You got: " + Score.getScore() + " points", 450, 300); //player
		}
		if(j==3){ // S2
			graphics.drawString("You got: " + Score.getTime() + " seconds", 450, 300);
		}
		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString(backText, returnButton.x + 60, returnButton.y + 40);
		g1d.draw(returnButton);
	}

	public void highSoreViewer(Graphics graphics) {
		Graphics2D g1d = (Graphics2D) graphics;
		Font fnt0 = new Font(arial, Font.BOLD, 50);
		Font fnt1 = new Font(arial, Font.BOLD, 30);
		graphics.drawImage(image, 0,0, null);
		String [][]highScoreS1= Score.getFromFileS1();
		String[][]highScoreS2=Score.getFromFileS2();

		int xS1 = 50;
		int yS1 = 200;
		int xS2 = 800;
		int yS2 = 200;
		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("S1",200,70);
		graphics.drawString("S2",800,70);

		graphics.setFont(fnt1);
		graphics.drawString("Name     Difficulty     Score",90,150);
		graphics.drawString("Name     Difficulty     Score",800,150);
		graphics.setFont(fnt1);
		for(int i=0; i<highScoreS1.length;i++){
			graphics.drawString(i+1 + ": ", xS1,yS1);
			for(int j=0; j<highScoreS1[i].length;j++){
				graphics.drawString( highScoreS1[i][j], (xS1+50), yS1);
				xS1+=140;
			}
			yS1+=50;
			xS1=50;
		}

		for(int i=0; i<highScoreS2.length;i++){
			graphics.drawString(i+1 + ": ", xS2,yS2);
			for(int j=0; j<highScoreS2[i].length;j++){
				graphics.drawString( highScoreS2[i][j], (xS2+50), yS2);
				xS2+=140;
			}
			yS2+=50;
			xS2=800;
		}


		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString(backText, returnButton.x + 60, returnButton.y + 40);
		g1d.draw(returnButton);

	}

	public Menu redirectGame()
	{
		if(a)
		{
			setPlayersNames();
			Body.state = Body.STATE.GAMEM1;
		}

		else if(s)
		{
			Body.state = Body.STATE.OPTIONSS1;
		}

		else if(d)
		{
			Body.state = Body.STATE.OPTIONSS2;
		}
		else if(t){

			Body.state = Body.STATE.THEME;

		}
		else if(g){
			Body.state = Body.STATE.HIGHSCORE;

		}
		else if(i){
			Body.state = Body.STATE.INFO;
		}

		else if(exit)	
		{
			Body.state = Body.STATE.EXITGAME;
			System.exit(0);
		}

		return null;
	}

	public Menu redirectOptionsS1()
	{
		if(e)
		{
			Enemy.setSpeed(3);
			setPlayerName("S1","Easy");
			Body.state = Body.STATE.GAMES1;
		}
		if(h)
		{
			Enemy.setSpeed(5);
			setPlayerName("S1","Hard");
			Body.state = Body.STATE.GAMES1;
		}
		if(back)
		{
			Body.state = Body.STATE.MENU;
		}
		return null;
	}
	public Menu redirectOptionsS2()
	{
		long startTime;

		if(e)
		{
			ObstacleBottom.setSpeed(5);
			ObstacleLeft.setSpeed(5);
			ObstacleRight.setSpeed(5);
			ObstacleTop.setSpeed(5);
			setPlayerName("S2","Easy");
			startTime = System.currentTimeMillis();
			Score.setStartTime(startTime);
			Body.state = Body.STATE.GAMES2;
		}
		if(h)
		{
			ObstacleBottom.setSpeed(15);
			ObstacleLeft.setSpeed(15);
			ObstacleRight.setSpeed(15);
			ObstacleTop.setSpeed(15);
			setPlayerName("S2","Hard");
			startTime = System.currentTimeMillis();
			Score.setStartTime(startTime);
			Body.state = Body.STATE.GAMES2;
		}
		if(back)
		{
			Body.state = Body.STATE.MENU;
		}
		return null;
	}
	public Menu redirectOptionsPlayerNameM1()
	{
		Body.state = Body.STATE.GAMEM1;
		return null;
	}

	public void setPlayersNames()
	{
		String player1Name = "";
		String player2Name = "";
		player1Name= JOptionPane.showInputDialog("Name Player 1: ");
		player2Name= JOptionPane.showInputDialog("Name Player 2: ");
		Player.setName(player1Name);
		Player.setName(player2Name);

		Player.setGameMode("M1");
		Player.setGameMode("M1");

	}

	public void setPlayerName(String gameMode, String difficulty){
		String player1Name= JOptionPane.showInputDialog("Name Player 1: ");
		Player.setName(player1Name);
		Player.setDifficulty(difficulty);
		Player.setGameMode(gameMode);

	}

	public Menu redirectOptionschangeTheme()
	{	
		if(e)
		{
			try {
				Theme.setTheme("Earth");
			} catch (IOException e) {

				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			Body.state = Body.STATE.MENU;
		}
		if(f)
		{	
			try {
				Theme.setTheme("Fire");
			} catch (IOException e) {

				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			Body.state =  Body.STATE.MENU;
		}
		if(w)
		{
			try {
				Theme.setTheme("Water");
			} catch (IOException e) {

				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			Body.state =  Body.STATE.MENU;
		}
		if(l)
		{	
			try {
				Theme.setTheme("Air");
			} catch (IOException e) {

				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			Body.state = Body.STATE.MENU;
		}
		return null;
	}

	public void redirectInfo()
	{	
		if(back)
		{
			Body.state = Body.STATE.MENU;
		}
	}

	public void redirectBack() {
		if(back){
			Body.state=Body.STATE.MENU;
		}
	}

}