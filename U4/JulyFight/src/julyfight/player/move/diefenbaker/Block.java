/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.diefenbaker;

import julyfight.player.move.trudeau.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.gamestate.Game;
import julyfight.player.Input;
import julyfight.player.Player;
import julyfight.player.move.Move;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class Block extends Move {

    public Block(Game game, Player player) {
        super(game, player);
        inputs = new Input[]{Input.BACK};
        continuous = true;
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void init(GameContainer gc) {
        try {
            Image punch = new Image("julyfight/assets/diefenbaker/block.png");//Load image for animation
            Animation animation = new Animation();//Initialise animation
            animation.addFrame(punch, 1);//Add frame
            player.renderer.addAnimation("Block", animation);//Add to renderer
        } catch (SlickException ex) {
            Logger.getLogger(LightPunch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hold() {
        player.renderer.setAnimation("Block", 0.1);
        player.defenseMod = 0.5;
        player.speedMod = 0.3;
    }
    
}
