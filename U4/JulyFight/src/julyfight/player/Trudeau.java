/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.Constants;
import julyfight.gamestate.Game;
import julyfight.physics.Vector2;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class Trudeau extends Player {
    
    
    
    
    
    @Override
    public void init(GameContainer gc, Game game, int playerNum) {
        super.init(gc, game, playerNum);
        try {
            Image idleImage = new Image("julyfight/assets/trudeau/idle.png");
            Image walkImage = new Image("julyfight/assets/trudeau/walk.png");
            Image punchImage = new Image("julyfight/assets/trudeau/punch.png");
            
            Animation idle = new Animation();
            idle.addFrame(idleImage, 1);
            
            Animation walk = new Animation();
            walk.addFrame(idleImage, 100);
            walk.addFrame(walkImage, 100);
            
            Animation punch = new Animation();
            punch.addFrame(punchImage, 1);
            
            renderer.addAnimation("idle", idle);
            renderer.addAnimation("walk", walk);
            renderer.addAnimation("punch", punch);
            
            state = IDLE;
        } catch (SlickException ex) {
            Logger.getLogger(Trudeau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void update(GameContainer gc, int delta) {
        super.update(gc, delta);
    }    

    @Override
    public void render(GameContainer gc, Graphics g) {
        super.render(gc, g);
    }
    
}
