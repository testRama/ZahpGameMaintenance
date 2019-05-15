
public class Projectile1 
{
	private static int x;
	private static int y;
	private static int speed;
	private boolean visible;
	Character character = new Character();
	Layout layout = new Layout();

	public Projectile1(int startX, int startY)
	{
		x = startX;
		y = startY;
		speed = 10;
		visible = true;
	}
	
	public Projectile1()
	{
		
	}

	public void update()
	{
		y = y - speed;

		if(y < 0)
		{
			visible = false;
		}
		
		if(Body.state == Body.STATE.GAMEM1)
		{
		if(character.character2.x < (x+10) && (character.character2.x + 75) > x && character.character2.y < (y+20) && (character.character2.y + 61) > y)
		{
			Body.state=Body.STATE.GAMEOVERC2;
		}
		}
	}

	public static int getX() {
		return x;
	}

	public void setX(int x) {
		Projectile1.x = x;
	}

	public static int getY() {
		return y;
	}

	public void setY(int y) {
		Projectile1.y = y;
	}

	public static int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		Projectile1.speed = speed;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}