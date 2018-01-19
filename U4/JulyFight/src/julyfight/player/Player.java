/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player;

import julyfight.Constants;
import julyfight.Control;
import julyfight.gamestate.Game;
import julyfight.physics.RectangleCollider;
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
    protected RectangleCollider collider;
    private Vector2 colliderOffset = new Vector2(-37, -200);
    
    protected Game game;
    
    protected boolean onFloor;
    
    protected int playerNum;
    
    public void init(GameContainer gc, Game game, int playerNum){
        this.game = game;
        this.playerNum = playerNum;
        
        position = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
        
        collider = new RectangleCollider(-27, -200, 74, 200);
        
        if(playerNum == 2){
            position.setX(800);
        }
    }
    
    public void update(GameContainer gc, int delta){
        velocity.addY(Constants.GRAVITY);//Acceleration due to gravity
        position.add(Vector2.multiply(velocity, (float)delta / 1000f));//Move according to velocity
        if(position.getY() > game.getBottom()){//If going through floor
            position.setY(game.getBottom());//Put on floor
            if(velocity.getY() > 0)//If moving into floor
                velocity.setY(0);//Not moving vertically
            onFloor = true;//It is on floor
        }else{
            onFloor = false;//Must not be on floor
        }
        //Calculate drag
        Vector2 drag = Vector2.multiply(velocity, -velocity.getMagnitude());//Velocity squared (also make opposite direction)
        drag.multiply(Constants.DRAG);//Times drag coeffecient
        velocity.add(drag);//Add onto velocity
        
        //Friction if applicible
        if(onFloor){
            double friction = -velocity.getX() * Constants.FRICTION;//Velocity times friction coeffecient (also opposite direction)
            velocity.addX(friction);//Add to x velocity
        }
        
        //Move collider
        collider.moveTo(Vector2.add(position, colliderOffset));
        
        //Controls
        if(
                (
                    (game.getControl(Control.P1LEFT) && playerNum == 1) || //If player 1 and player 1 left is pressed
                    (game.getControl(Control.P2LEFT) && playerNum == 2)//Or if player 2 and player 2 left is pressed
                ) && velocity.getX() > -Constants.MAX_SPEED){//And if we can accelerate in that direction
            if(onFloor)//On floor
                velocity.addX(-Constants.PLAYER_ACC * ((double)delta / 1000));//Floor acc
            else//In air
                velocity.addX(-Constants.AIR_ACC * ((double)delta / 1000));//Air acc
        }
        if(
                (
                    (game.getControl(Control.P1RIGHT) && playerNum == 1) || //If player 1 and player 1 right is pressed
                    (game.getControl(Control.P2RIGHT) && playerNum == 2)//Or if player 2 and player 2 right is pressed
                ) && velocity.getX() < Constants.MAX_SPEED){//And if we can accelerate in that direction
            if(onFloor)//On floor
                velocity.addX(Constants.PLAYER_ACC * ((double)delta / 1000));//Accelerate normally
            else//In air
                velocity.addX(Constants.AIR_ACC * ((double)delta / 1000));//Use air acc
        }
        if(
                (
                    (game.getControlDown(Control.P1UP) && playerNum == 1) || //If player 1 and player 1 up is pressed
                    (game.getControlDown(Control.P2UP) && playerNum == 2)//Or if player 2 and player 2 up is pressed
                ) && onFloor){//And if we can jump
            velocity.setY(Constants.JUMP_SPEED);
        }
    }
    
    public abstract void render(GameContainer gc, Graphics g);
    
    /**
     * Get position of player
     * @return Player position in screen space
     */
    public final Vector2 getPosition(){
        return position.clone();
    }
    
}
