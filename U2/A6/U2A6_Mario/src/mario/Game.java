/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darian
 */
public class Game {
    
    //Gravity: 9.8m/s^2
    public static Vector2 GRAVITY = new Vector2(0, 9.8);
    
    private static List<GameObject> gameObjects;
    
    //Debug keys pressed because no actual input
    private static boolean spacePressed = false;
    private static boolean leftPressed = false;
    private static boolean rightPressed = false;
    
    /**
     * Check if a key is pressed
     * @param key Name of key to check
     * @return True if key is pressed, false if it is not
     */
    public static boolean getKey(String key){
        if("Left".equals(key) && leftPressed){
            return true;
        }else if("Right".equals(key) && rightPressed){
            return true;
        }
        //Normally this would have code for checking keyboard input but for now it just returns false
        return false;
    }
    
    /**
     * Check if a key has been pressed since it was last checked
     * @param key Name of key to check
     * @return True if key was pressed, false if it was not
     */
    public static boolean getKeyDown(String key){
        //This would have code to check if a key was pressed since we last checked
        //Again, this just returns false because this isn't really a game
        
        if(spacePressed){
            spacePressed = false;
            return true;
        }
        return false;
    }
    
    //The start time of the last loop execution
    private static long lastTime = System.currentTimeMillis();
    
    //Bool for running and stopping the loop
    private static boolean running;
    
    private static void gameLoop(){
        //Get the current time
        long currentTime = System.currentTimeMillis();
        //Get delta time from last update in seconds
        double deltaTime = (currentTime - lastTime) / 1000.0;
        //Set last time
        lastTime = currentTime;
        //Run update on every game object
        gameObjects.forEach((go) -> {
            go.physicsUpdate(deltaTime);
        });
        //Sleep for 1 millisecond to prevent a deltatime of 0 breaking things
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            //This probably won't happen
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Main entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) throws IOException{
        //Initialise gameObjects list
        gameObjects = new ArrayList<GameObject>();
        //Create player object
        Mario player = new Mario();
        //Add to gameobjects list
        gameObjects.add(player);
        //Run gameloop until stopped
        new Thread(() -> {
            running = true;
            while(running){
                gameLoop();
            }
        }).start();
        //Read line on console to keep main thread open
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = reader.readLine();
            switch(input){
                //Mostly fake key presses
                case "jump":
                    spacePressed = true;
                    break;
                case "+left":
                    leftPressed = true;
                    break;
                case "+right":
                    rightPressed = true;
                    break;
                case "-left":
                    leftPressed = false;
                    break;
                case "-right":
                    rightPressed = false;
                    break;
                case "exit":
                    //End program
                    running = false;
                    return;
            }
        }
    }
    
}
