/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.gamestate.Game;
import julyfight.player.move.Move;
import julyfight.player.move.trudeau.*;
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
            
            //Moves
            //Light punch
            Move lp = new LightPunch(game, this);
            lp.init(gc);
            moveHandler.addMove(lp);
            //Medium punch
            Move mp = new MediumPunch(game, this);
            mp.init(gc);
            moveHandler.addMove(mp);
            //Heavy punch
            Move hp = new HeavyPunch(game, this);
            hp.init(gc);
            moveHandler.addMove(hp);
            
            //Light kick
            Move lk = new LightKick(game, this);
            lk.init(gc);
            moveHandler.addMove(lk);
            //Medium kick
            Move mk = new MediumKick(game, this);
            mk.init(gc);
            moveHandler.addMove(mk);
            //Heavy kick
            Move hk = new HeavyKick(game, this);
            hk.init(gc);
            moveHandler.addMove(hk);
            
            //Block
            Move block = new Block(game, this);
            block.init(gc);
            moveHandler.addMove(block);
            
            //National Defense
            Move nd = new NationalDefense(game, this);
            nd.init(gc);
            moveHandler.addMove(nd);
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
