/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 * An object in the game
 * @author Darian
 */
public class GameObject {
    
    //Vectors for storing position, velocity, and force for physics
    private Vector2 position, velocity;
    //Rectangle for the collision area
    private Rect hitbox;
    
    public GameObject(){
        position = velocity = new Vector2();//Set all vectors to 0
        hitbox = new Rect(-1, 1, -1, 1);
    }
    
    public void physicsUpdate(double deltaTime){
        
    }
    
}
