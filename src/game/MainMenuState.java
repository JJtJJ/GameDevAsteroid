package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

    int stateID = -1;
    
    MainMenuState(int stateID) {
       this.stateID = stateID;
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int a)
            throws SlickException {
        // TODO Auto-generated method stub
        sbg.enterState(1);
    }

    @Override
    public int getID() {
        return stateID;
    }

}
