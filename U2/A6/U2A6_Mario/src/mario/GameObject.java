/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.util.List;

/**
 * An object in the game
 * @author Darian
 */
public class GameObject {
    
    //Vectors for storing position for physics
    Vector2 position;
    //Vectors for storing velocity for physics
    Vector2 velocity;
    
    public GameObject(){
        position = velocity = new Vector2();//Set all vectors to 0
    }
    
    public void physicsUpdate(double deltaTime){
        //Acceleration due to gravity
        velocity = Vector2.add(velocity, Vector2.mul(Game.GRAVITY, deltaTime));
        
        //Change in position based on current velocity
        position = Vector2.add(position, Vector2.mul(velocity, deltaTime));
        
        //Stop us from falling through the floor
        if(position.gety() > 10){
            position.sety(10);
            velocity.sety(0);
        }
    }
    
}
