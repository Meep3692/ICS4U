/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class Effect {
    private float duration;
    private float time;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    
    private boolean dead;
    
    public Effect(Image image, int x, int y, int width, int height, float duration){
        this.image = image;//Set image
        this.x = x;//Set values
        this.y = y;
        this.duration = duration;
        this.time = 0;
        this.image.setCenterOfRotation((float)width / 2, (float)height / 2);//Set centre of rotation to centre
        this.image.setRotation((float) (Math.random() - 0.5));//Set random rotation

        dead = false;//Alive
    }
    
    public void update(GameContainer gc, int delta){
        time += (float)delta / 1000;
        if(time > duration)
            dead = true;
    }
    
    public void render(GameContainer gc, Graphics g){
        image.draw(x, y, width, height, new Color(1, 1, 1, (duration - time) / duration));//Render with transparency
    }
    
    public boolean isDead(){
        return dead;
    }
}
