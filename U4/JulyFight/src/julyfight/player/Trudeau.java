/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.Game;
import julyfight.physics.Vector2;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class Trudeau extends Player {

    Animation idle;
    
    @Override
    public void init(GameContainer gc, Game game) {
        super.init(gc, game);
        try {
            Image idleImage = new Image("julyfight/assets/trudeau/idle.png");
            idle = new Animation();
            idle.addFrame(idleImage, 1);
        } catch (SlickException ex) {
            Logger.getLogger(Trudeau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        position = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
        System.out.println("Init");
    }

    @Override
    public void update(GameContainer gc, int delta) {
        System.out.println("Update");
        super.update(gc, delta);
    }    

    @Override
    public void render(GameContainer gc, Graphics g) {
        idle.draw((float)position.getX() - 64, (float)position.getY() - 256);
    }
    
}
