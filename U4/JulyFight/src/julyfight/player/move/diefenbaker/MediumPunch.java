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
import julyfight.physics.RectangleCollider;
import julyfight.player.Input;
import julyfight.player.Player;
import julyfight.player.move.Move;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class MediumPunch extends Move {
    
    public MediumPunch(Game game, Player player) {
        super(game, player);
        inputs = new Input[]{Input.MP};
    }

    @Override
    public void execute() {
        RectangleCollider hitBox = new RectangleCollider(player.getPosition().getX(), player.getPosition().getY() - 154, -84 * player.facing, 23);//Generate hitbox
        game.hit(hitBox, player.getPlayerNumber(), 2.5f, 0.2);//Hit
        player.renderer.setAnimation("MediumPunch", 0.2);//Set animation
    }
    
    @Override
    public void init(GameContainer gc) {
        try {
            Image punch = new Image("julyfight/assets/diefenbaker/punch2.png");//Load image for animation
            Animation animation = new Animation();//Initialise animation
            animation.addFrame(punch, 1);//Add frame
            player.renderer.addAnimation("MediumPunch", animation);//Add to renderer
        } catch (SlickException ex) {
            Logger.getLogger(LightPunch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void hold() {}//Not used
}