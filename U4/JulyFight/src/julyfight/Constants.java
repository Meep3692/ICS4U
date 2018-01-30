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
    public static final double PLAYER_ACC = 15000;
    
    /**
     * Jump speed
     */
    public static final double JUMP_SPEED = -1000;
    
    /**
     * Time to animate basic moves
     */
    public static final double BASIC_MOVE_TIME = 0.2;
    
    /**
     * Knockback multiplier
     */
    public static final double KB_MULT = 100;
}
