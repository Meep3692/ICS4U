/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.Constants;
import julyfight.Control;
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
        animations = new Animation[4];
        try {
            Image idleImage = new Image("julyfight/assets/trudeau/idle.png");
            Image walkImage = new Image("julyfight/assets/trudeau/walk.png");
            Image punchImage = new Image("julyfight/assets/trudeau/punch.png");
            
            animations[IDLE] = new Animation();
            animations[IDLE].addFrame(idleImage, 1);
            
            animations[WALK] = new Animation();
            animations[WALK].addFrame(idleImage, 100);
            animations[WALK].addFrame(walkImage, 100);
            
            animations[PUNCH] = new Animation();
            animations[PUNCH].addFrame(punchImage, 1);
            
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
