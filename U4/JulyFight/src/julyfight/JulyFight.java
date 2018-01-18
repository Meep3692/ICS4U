/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public JulyFight(String title) {
        super(title);
        gameState = new Stack<>();
    }
    
    private void pushState(GameState state, GameContainer gc){
        state.init(gc);
        gameState.push(state);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        pushState(new Game(new Trudeau(), null), container);
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
            JulyFight game = new JulyFight("Awoo");
            AppGameContainer gc = new AppGameContainer(game);
            gc.setDisplayMode(800, 600, false);
            gc.start();
        } catch (SlickException ex) {
            Logger.getLogger(JulyFight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
