/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.diefenbaker;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.gamestate.Game;
import julyfight.player.Input;
import julyfight.player.Player;
import julyfight.player.move.Move;
import julyfight.ui.Effect;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class Bunker extends Move {

    Image effect;
    public Bunker(Game game, Player player) {
        super(game, player);
        continuous = true;
        inputs = new Input[]{Input.DOWN, Input.BACK};
    }

    @Override
    public void execute() {
        Effect bunkerEffect = new Effect(effect, (int)player.getPosition().getX(), (int)player.getPosition().getY() + 30, 150, 80, 1);
        game.addEffect(bunkerEffect);
    }

    @Override
    public void hold() {
        player.renderer.setAnimation("Bunker", 0.2);//Display bunker
        player.defenseMod = 0;//Make player invuln
        player.speedMod = 0;//Stop player moving
    }

    @Override
    public void init(GameContainer gc) {
        try {
            Image bunker = new Image("julyfight/assets/diefenbaker/bunker.png");//Load image for animation
            Animation animation = new Animation();//Initialise animation
            animation.addFrame(bunker, 1);//Add frame
            player.renderer.addAnimation("Bunker", animation);//Add to renderer
            
            effect = new Image("julyfight/assets/diefenbaker/bunkerEffect.png");
        } catch (SlickException ex) {
            Logger.getLogger(LightPunch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
