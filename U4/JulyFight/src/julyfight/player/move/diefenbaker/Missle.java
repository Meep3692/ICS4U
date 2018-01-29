/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.diefenbaker;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.GameObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class Missle extends GameObject {

    Image image;
    private int x;
    private int y;
    
    public Missle(int x){
        this.x = x;
        this.y = 600;
    }
    
    @Override
    public void init(GameContainer gc) {
        try {
            image = new Image("julyfight/assets/diefenbaker/honestJohn.png");
        } catch (SlickException ex) {
            Logger.getLogger(Missle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, int delta) {
        y += delta / 2;
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        image.draw(x - 128, y - 256);
    }
    
}
