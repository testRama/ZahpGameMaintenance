


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class CharacterS1 
{
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private static int character1x = 680;
	private static int character1y = 680;
	private int characterSpeed = 15;

	
	Rectangle character1 = new Rectangle(character1x, character1y, 75, 100);	

	
	private ArrayList<Projectile1> projectiles1 = new ArrayList<>();


	public void drawCharacter(Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.fillRect(character1x, character1y, 75, 75);

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
	
	public List<Projectile1> getProjectiles()
	{
		return projectiles1;
	}

	public static int getCharacter1x() {
		return character1x;
	}

	public static void setCharacter1x(int character1x) {
		CharacterS1.character1x = character1x;
	}

	public static int getCharacter1y() {
		return character1y;
	}

	public static void setCharacter1y(int character1y) {
		CharacterS1.character1y = character1y;
	}

	public void moveCharacter()
	{
		if(right && character1x < 1375)
		{
				character1x = character1x + characterSpeed;
		}

		if(left && character1x > 0)
		{
				character1x = character1x - characterSpeed;
		}
		
		if(up && character1y > 605)
		{
				character1y = character1y - characterSpeed;
		}

		if(down && character1y < 725)
		{
				character1y = character1y + characterSpeed;
		}
	}
	
	public void shoot()
	{
		Projectile1 bullet = new Projectile1(character1x + 32, character1y);
		projectiles1.add(bullet);
	}
}
