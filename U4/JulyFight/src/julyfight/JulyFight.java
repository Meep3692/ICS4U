/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

import julyfight.gamestate.GameState;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.gamestate.MainMenu;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class JulyFight extends BasicGame {

    private Stack<GameState> gameState;//Stack of game states
    private GameContainer gc;//Game container
    
    public JulyFight(String title) {
        super(title);
        gameState = new Stack<>();//Initiralise stack
    }
    
    public void pushState(GameState state){
        if(!gameState.empty())//Skip this if this is the first state
            gameState.peek().setActive(false);//Disable previous state
        state.setActive(true);//Enable current state
        state.init(gc);//Initialise current state
        gameState.push(state);//Push current state to stack
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        gc = container;//Set game container
        Config.loadConfig();//Load configuration
        pushState(new MainMenu(this));//Push the main menu
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        gameState.peek().update(container, delta);//Update current game state
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        gameState.peek().render(container, g);//Render current gamestate
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            JulyFight game = new JulyFight("July Fight");//New game instance
            AppGameContainer gc = new AppGameContainer(game);//New game container
            gc.setDisplayMode(800, 600, false);//Set window to 800 x 600
            gc.setVSync(true);//Enable vsync
            gc.start();//Start game
        } catch (SlickException ex) {
            Logger.getLogger(JulyFight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
