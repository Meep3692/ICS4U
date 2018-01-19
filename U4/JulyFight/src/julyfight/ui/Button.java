/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class Button {
    
    private Image image;
    
    private int posx;
    private int posy;
    private int sizex;
    private int sizey;
    
    /**
     * Create a new button
     * @param posx x position
     * @param posy y position
     * @param sizex width
     * @param sizey height
     * @param imagePath Path to image
     */
    public Button(int posx, int posy, int sizex, int sizey, String imagePath){
        this.posx = posx;
        this.posy = posy;
        this.sizex = sizex;
        this.sizey = sizey;
        try {
            this.image = new Image(imagePath);
        } catch (SlickException ex) {
            Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void render(GameContainer gc, Graphics g) {
        image.draw(posx, posy, sizex, sizey);
    }
    
}
