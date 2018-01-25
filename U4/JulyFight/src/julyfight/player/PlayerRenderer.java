/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import java.util.HashMap;
import java.util.Map;
import julyfight.gamestate.Game;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Darian
 */
public class PlayerRenderer {
    
    private Player player;
    private Game game;
    
    private double animDuration;
    private double animTime;//Amount of time current move has been going
    
    private String animCurrent;
    private Map<String, Animation> animations;
    
    public PlayerRenderer(Player player, Game game){
        this.player = player;
        this.game = game;
        animDuration = 0;
        animTime = 0;
        animCurrent = "none";
        animations = new HashMap<>();
    }
    
    public void update(GameContainer gc, int delta){
        if(animCurrent != "none"){
            animTime += ((double)delta / 1000.0);
            if(animTime > animDuration){
                animTime = 0;
                animCurrent = "none";
            }
        }
    }
    
    public void render(GameContainer gc, Graphics g){
        
        String animActual;
        
        if("none".equals(animCurrent)){
            switch(player.state){
                case 1:
                    animActual = "walk";
                    break;
                case 2:
                    animActual = "crouch";
                    break;
                case 3:
                    animActual = "jump";
                    break;
                default:
                    animActual = "idle";
            }
        }else
            animActual = animCurrent;
        
        
        
        if(animations.get(animActual) != null){//If there is an animation for this state
            if(player.facing < 0)
                animations.get(animActual).draw((float)player.position.getX() - 128, (float)player.position.getY() - 256);
            else
                animations.get(animActual).draw((float)player.position.getX() + 128, (float)player.position.getY() - 256, -256, 256);
        }
    }
    
    public void addAnimation(String name, Animation animation){
        animations.put(name, animation);
    }
    
    public void setAnimation(String animation, double duration){
        animCurrent = animation;
        animTime = 0;
        animDuration = duration;
    }
    
}
