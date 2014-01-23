package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameDev1 extends StateBasedGame {
    
    // int representations for the game states.
    public static final int MAINMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;
  
    public GameDev1() {
        super("GameDev1");
    }
  
    public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new GameDev1());
  
         app.setDisplayMode(640, 480, false); // window size, and fullscreen boolean
         app.setTargetFrameRate(60); // frames to render per second
         app.start(); // run the game!
    }
  
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MainMenuState(MAINMENUSTATE)); // ignore me for now
        this.addState(new GamePlayState(GAMEPLAYSTATE)); // edit me!
    }
}

