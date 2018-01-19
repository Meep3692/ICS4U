/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

import julyfight.gamestate.Game;
import julyfight.gamestate.GameState;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.gamestate.MainMenu;
import julyfight.player.Diefenbaker;
import julyfight.player.Trudeau;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class JulyFight extends BasicGame {

    private Stack<GameState> gameState;
    private GameContainer gc;
    
    public JulyFight(String title) {
        super(title);
        gameState = new Stack<>();
    }
    
    public void pushState(GameState state){
        if(!gameState.empty())
            gameState.peek().setActive(false);
        state.setActive(true);
        state.init(gc);
        gameState.push(state);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        gc = container;
        Config.loadConfig();
        pushState(new MainMenu(this));
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        gameState.peek().update(container, delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        gameState.peek().render(container, g);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            JulyFight game = new JulyFight("July Fight");
            AppGameContainer gc = new AppGameContainer(game);
            gc.setDisplayMode(800, 600, false);
            gc.start();
        } catch (SlickException ex) {
            Logger.getLogger(JulyFight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
