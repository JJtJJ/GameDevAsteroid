package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet {

	private double x;
	private double y;
	private double xdir;
	private double ydir;
	private final int SPEED = 5;
	Image sprite;
	
	public Bullet(double x, double y, double xdir, double ydir) {
		this.x = x;
		this.y = y;
		this.xdir = xdir;
		this.ydir = ydir;
		try {
			sprite = new Image("assets/bullet1.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void render() {
		sprite.draw((int)x, (int)y);
	}
	
	public void update() {
		x += xdir;
		y += ydir;
	}
	
}
