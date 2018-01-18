/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import julyfight.Constants;
import julyfight.Game;
import julyfight.physics.Vector2;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author Awoo
 */
public abstract class Player {
    
    //REMEMBER: Y POINTS DOWN, X POINTS RIGHT
    
    protected Vector2 position;
    protected Vector2 velocity;
    
    private Game game;
    
    public void init(GameContainer gc, Game game){
        this.game = game;
    }
    
    public void update(GameContainer gc, int delta){
        velocity.setY(velocity.getY() + Constants.GRAVITY);
        position.add(Vector2.multiply(velocity, (float)delta / 1000f));//Move according to velocity
        if(position.getY() > game.getBottom()){
            position.setY(game.getBottom());
            if(velocity.getY() > 0)
                velocity.setY(0);
        }
    }
    
    public abstract void render(GameContainer gc, Graphics g);
    
    public Vector2 getPosition(){
        return position.clone();
    }
    
}
