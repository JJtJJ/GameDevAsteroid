package game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlayState extends BasicGameState {
    
    int stateID = -1;
    Image sprite;
    double x;
    double y;
    double velx;
    double vely;
    final double ACCEL = 0.5;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    
    
    GamePlayState( int stateID ) {
       this.stateID = stateID;
       try {
		sprite = new Image("assets/spaceship.png");
	} catch (SlickException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        // TODO Set default variable values, and load assets here.
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        // TODO Draw sprites to the screen here!
    	sprite.draw((int)x, (int)y);
        for (Bullet b : bullets) {
        	b.render();
        }
    }
    
    private double step(double current, double target, double speed) {
    	if (current > target) {
    		current -= speed;
    		if (current < target) {
    			current = target;
    		}
    	} else if (current < target) {
    		current += speed;
    		if (current > target) {
    			current = target;
    		}
    	}
    	return current;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int arg)
            throws SlickException {
        // TODO Update all game objects, and get user input here.
    	Input in = gc.getInput();
        if (in.isKeyDown(Input.KEY_W)) {
        	vely -= ACCEL;
        } else if (in.isKeyDown(Input.KEY_S)) {
    		vely += ACCEL;
    	} else {
    		vely = step(vely, 0, ACCEL*2);
    	}
    	if (in.isKeyDown(Input.KEY_A)) {
    		velx -= ACCEL;
    	} else if (in.isKeyDown(Input.KEY_D)) {
    		velx += ACCEL;
    	} else {
    		velx = step(velx, 0, ACCEL*2);
    	}
    	if (in.isKeyDown(Input.KEY_Q)) {
    		sprite.rotate(-5);
    	}
    	if (in.isKeyDown(Input.KEY_E)) {
    		sprite.rotate(5);
    	}
    	y += vely;
    	x += velx;
    	if (in.isKeyPressed(Input.KEY_SPACE)) {
    		double radRotation = sprite.getRotation() * (Math.PI / 180);
    		double xdir = Math.sin(radRotation);
    		double ydir = -1 * Math.cos(radRotation);
    		bullets.add(new Bullet(x, y, xdir, ydir));
    	}
    	for (Bullet b : bullets) {
    		b.update();
    	}
    }

    @Override
    public int getID() {
        return stateID;
    }

}
