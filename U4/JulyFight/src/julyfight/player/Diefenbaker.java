/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.gamestate.Game;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class Diefenbaker extends Player {

    private static final int IDLE = 0;
    private static final int WALK = 1;
    private static final int PUNCH = 2;
    private static final int CROUCH = 3;
    
    private int state;
    
    private Animation[] animations;

    @Override
    public void init(GameContainer gc, Game game, int playerNum) {
        super.init(gc, game, playerNum);
        animations = new Animation[4];
        try {
            Image idleImage = new Image("julyfight/assets/diefenbaker/idle.png");
            animations[IDLE] = new Animation();
            animations[IDLE].addFrame(idleImage, 1);
            
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
        if(playerNum == 1)
            animations[state].draw((float)position.getX() - 128, (float)position.getY() - 256);
        else
            animations[state].draw((float)position.getX() + 128, (float)position.getY() - 256, -256, 256);
        double top = collider.getTop();
        double left = collider.getLeft();
        double bottom = collider.getBottom();
        double right = collider.getRight();
        g.drawLine((int)left, (int)top, (int)left, (int)bottom);
        g.drawLine((int)left, (int)bottom, (int)right, (int)bottom);
        g.drawLine((int)right, (int)bottom, (int)right, (int)top);
        g.drawLine((int)right, (int)top, (int)left, (int)top);
        
    }
    
}
