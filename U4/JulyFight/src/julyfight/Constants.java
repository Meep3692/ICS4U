/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

/**
 * Constant values for game features
 * @author Darian
 */
public class Constants {
    
    //REMEMBER: Y POINTS DOWN, X POINTS RIGHT
    
    /**
     * Amount added to velocity for gravity
     */
    public static final double GRAVITY = 3000;
    
    /**
     * Acceleration in pixels / second ^ 2
     */
    public static final double PLAYER_ACC = 500;
    
    /**
     * Air acceleration
     */
    public static final double AIR_ACC = 300;
    
    /**
     * Maximum speed for players in pixels / second
     */
    public static final double MAX_SPEED = 10000;
    
    /**
     * Jump speed
     */
    public static final double JUMP_SPEED = -1000;
    
    /**
     * Amount of drag on players
     */
    public static final double DRAG = 500;
    
    /**
     * Amount of friction experienced by the player
     */
    public static final double FRICTION = 10;
}
