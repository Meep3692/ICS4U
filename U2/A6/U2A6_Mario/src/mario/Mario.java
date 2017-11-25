/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/**
 *
 * @author Darian
 */
public class Mario extends GameObject {
    
    private double jumpSpeed;
    private double moveSpeed;
    
    public Mario(){
        super();
        jumpSpeed = 2;
        moveSpeed = 1;
    }
    
    @Override
    public void physicsUpdate(double deltaTime){
        //Do basic gameobject physics
        super.physicsUpdate(deltaTime);
        
        //Controls
        if(Game.getKeyDown("Space")){//Set y velocity on jump
            velocity.sety(jumpSpeed);
        }
        if(Game.getKey("Left")){//Set x velocity based on the player pressing left or right
            velocity.setx(-moveSpeed);
        } else if(Game.getKey("Right")){
            velocity.setx(moveSpeed);
        } else{
            velocity.setx(0);
        }
        //Print position and velocity for debug purposes
        System.out.println(String.format("Position: %s\nVelocity: %s", position.toString(), velocity.toString()));
    }
    
}
