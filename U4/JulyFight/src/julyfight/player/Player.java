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

/**
 *
 * @author Darian
 */
public abstract class Player {
    
    //REMEMBER: Y POINTS DOWN, X POINTS RIGHT
    
    protected Vector2 position;
    protected Vector2 velocity;
    protected RectangleCollider collider;
    protected int health;
    
    protected PlayerRenderer renderer;
    
    private Vector2 colliderOffset = new Vector2(-37, -200);
    
    public int state;
    
    protected static final int IDLE = 0;
    protected static final int WALK = 1;
    protected static final int CROUCH = 2;
    protected static final int JUMP = 3;
    
    private boolean lockMove;
    
    protected Game game;
    
    protected boolean onFloor;
    protected int facing;
    
    protected int playerNum;
    
    public void init(GameContainer gc, Game game, int playerNum){
        this.game = game;//Set game
        this.playerNum = playerNum;//Set player number
        
        position = new Vector2(0, 0);//Initialise position and direction
        velocity = new Vector2(0, 0);
        
        collider = new RectangleCollider(-27, -200, 74, 200);//Initialise collider
        
        if(playerNum == 2){//Move to correct side
            position.setX(800);
        }
        
        health = 100;//Initialise health
        lockMove = false;
        
        state = IDLE;
        
        renderer = new PlayerRenderer(this, game);
    }
    
    public void update(GameContainer gc, int delta){
        
        renderer.update(gc, delta);
        
        //Physics
        velocity.addY(Constants.GRAVITY * ((float)delta / 1000));//Acceleration due to gravity
        position.add(Vector2.multiply(velocity, (float)delta / 1000f));//Move according to velocity
        if(position.getY() > game.getBottom()){//If going through floor
            position.setY(game.getBottom());//Put on floor
            if(velocity.getY() > 0)//If moving into floor
                velocity.setY(0);//Not moving vertically
            onFloor = true;//It is on floor
        }else{
            onFloor = false;//Must not be on floor
            state = JUMP;
        }
        
        //Check facing dir
        if(playerNum == 1)
            facing = (int)Math.signum(position.getX() - game.player2.getPosition().getX());
        else
            facing = (int)Math.signum(position.getX() - game.player1.getPosition().getX());
        
        //Move collider
        collider.moveTo(Vector2.add(position, colliderOffset));
        
        state = IDLE;
        //Controls
        if(onFloor && !lockMove){
            double newXVel = 0;//New x velocity to be set
            if(
                    (
                        (game.getControl(Control.P1LEFT) && playerNum == 1) || //If player 1 and player 1 left is pressed
                        (game.getControl(Control.P2LEFT) && playerNum == 2)//Or if player 2 and player 2 left is pressed
                    )){
                if(onFloor){//On floor
                    //velocity.addX(-Constants.PLAYER_ACC * ((double)delta / 1000));//Floor acc
                    newXVel += -Constants.PLAYER_ACC * ((double)delta / 1000);//Make x velocity left
                    state = WALK;
                }
            }
            if(
                    (
                        (game.getControl(Control.P1RIGHT) && playerNum == 1) || //If player 1 and player 1 right is pressed
                        (game.getControl(Control.P2RIGHT) && playerNum == 2)//Or if player 2 and player 2 right is pressed
                    )){
                if(onFloor){//On floor
                    newXVel += Constants.PLAYER_ACC * ((double)delta / 1000);//Make x velocity right or nullify walking left
                    state = WALK;
                }
            }
            if(
                    (
                        (game.getControlDown(Control.P1UP) && playerNum == 1) || //If player 1 and player 1 up is pressed
                        (game.getControlDown(Control.P2UP) && playerNum == 2)//Or if player 2 and player 2 up is pressed
                    ) && onFloor){//And if we can jump
                velocity.setY(Constants.JUMP_SPEED);
            }
            velocity.setX(newXVel);//Set x velocity
        }
        
        if(position.getX() < 37)
            position.setX(37);
        if(position.getX() > game.getRight() - 37)
            position.setX(game.getRight() - 37);
        
        
        
    }
    
    public void render(GameContainer gc, Graphics g){
        renderer.render(gc ,g);
    }
    
    public final void hit(int amount, double stunTime){
        health -= amount;
        velocity.setX(facing * Constants.KB_MULT * amount);
        velocity.setY(facing * Constants.KB_MULT * amount);
    }
    
    /**
     * Get position of player
     * @return Player position in screen space
     */
    public final Vector2 getPosition(){
        return position.clone();
    }
    
    /**
     * Get player health
     * @return Player health [0, 100]
     */
    public final int getHealth(){
        return health;
    }
    
    public final boolean checkCollision(RectangleCollider other){
        return collider.intersects(other);
    }
    
    public final int getPlayerNumber(){
        return playerNum;
    }
    
}
