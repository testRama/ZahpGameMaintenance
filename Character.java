
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Character
{
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean w;
	private boolean a;
	private boolean s;
	private boolean d;

	private static int character1x = 680;
	private static int character1y = 680;
	private static int character2x = 680;
	private static int character2y = 10;
	private static int characterSpeed = 10;
	
	Rectangle character1 = new Rectangle(character1x, character1y, 75, 75);	
	Rectangle character2 = new Rectangle(character2x, character2y, 75, 75);
	
	Image image;
	
	private ArrayList<Projectile1> projectiles1 = new ArrayList<>();
	private ArrayList<Projectile2> projectiles2 = new ArrayList<>();
	
	
	public static int getCharacter1x() {
		return character1x;
	}

	public static void setCharacter1x(int character1x) {
		Character.character1x = character1x;
	}

	public static int getCharacter1y() {
		return character1y;
	}

	public static void setCharacter1y(int character1y) {
		Character.character1y = character1y;
	}

	public static int getCharacter2x() {
		return character2x;
	}

	public static void setCharacter2x(int character2x) {
		Character.character2x = character2x;
	}

	public static int getCharacter2y() {
		return character2y;
	}

	public static void setCharacter2y(int character2y) {
		Character.character2y = character2y;
	}

	public void drawCharacter(Graphics graphics) //throws IOException
	{
		
		graphics.setColor(Color.black);
		graphics.fillRect(character1x, character1y, 75, 75);
		graphics.setColor(Color.BLUE);
		graphics.fillRect(character2x, character2y, 75, 75);
	}

	public boolean getLeft()
	{
		return left;
	}
	
	public void setLeft(boolean status)
	{
		left = status;
	}

	public boolean getRight()
	{
		return right;
	}

	public void setRight(boolean status)
	{
		right = status;
	}
	
	public boolean getUp()
	{
		return up;
	}
	
	public void setUp(boolean status)
	{
		up = status;
	}
	
	public boolean getDown()
	{
		return down;
	}
	
	public void setDown(boolean status)
	{
		down = status;
	}
	
	public boolean getW()
	{
		return w;
	}
	
	public void setW(boolean status)
	{
		w = status;
	}

	public boolean getD()
	{
		return d;
	}

	public void setD(boolean status)
	{
		d = status;
	}
	
	public boolean getA()
	{
		return a;
	}
	
	public void setA(boolean status)
	{
		a = status;
	}
	
	public boolean getS()
	{
		return s;
	}
	
	public void setS(boolean status)
	{
		s = status;
	}
	
	public List<Projectile1> getProjectiles1()
	{
		return projectiles1;
	}
	
	public List<Projectile2> getProjectiles2()
	{
		return projectiles2;
	}
	
	public void moveCharacter()
	{
		if(right && character1x < 1375)
		{
				character1x = character1x + characterSpeed;		
		}
		
		if(d && character2x < 1375)
		{
				character2x = character2x + characterSpeed;
		}
		
		if(left && character1x > 0)
		{
				character1x = character1x - characterSpeed;
		}
		
		if(a && character2x > 0)
		{
				character2x = character2x - characterSpeed;
		}
		
		if(up && character1y > 410)
		{
				character1y = character1y - characterSpeed;
		}
		
		if(w && character2y > 0)
		{
				character2y = character2y - characterSpeed;
		}
		
		if(down && character1y < 725)
		{
				character1y = character1y + characterSpeed;
		}
		
		if(s && character2y < 333)
		{
				character2y = character2y + characterSpeed;
		}
	}
	
	public void shoot1()
	{
		Projectile1 bullet1 = new Projectile1(character1x + 32, character1y);
		projectiles1.add(bullet1);
	}
	
	public void shoot2()
	{
	
		Projectile2 bullet2 = new Projectile2(character2x + 32, character2y);
		projectiles2.add(bullet2);
	}
}