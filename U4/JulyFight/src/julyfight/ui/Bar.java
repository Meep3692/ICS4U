/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.player.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;

/**
 *
 * @author Darian
 */
public class Bar {
    private Image health;
    private Image barBG;
    private Font time;
    
    private Player player1;
    private Player player2;
    
    private int bar1Size;
    private int bar2Size;
    private int bar2Location;

    public Bar(Image health, Image barBG, Player player1, Player player2){
        this.health = health;
        this.barBG = barBG;
        this.player1 = player1;
        this.player2 = player2;
        try {
            time = new UnicodeFont("julyfight/assets/ui/bars/DOS.ttf", 30, false, false);
        } catch (SlickException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(GameContainer gc, int delta){
        bar1Size = (int) ((float)health.getWidth() * ((float)player1.getHealth() / 100f));
        bar2Size = (int) ((float)health.getWidth() * ((float)player2.getHealth() / 100f));
        bar2Location = (int) ((float)gc.getWidth() - ((float)health.getWidth() + 24f));
    }
    
    public void render(GameContainer gc, Graphics g){
        barBG.draw();//Draw this at 0 0
        //Draw health bars
        health.draw(24, 48, bar1Size, health.getHeight());
        health.draw(bar2Location, 48, bar2Size, health.getHeight());
        time.drawString((gc.getWidth() / 2) - (time.getWidth("00") / 2), 0, "00");
    }
}
