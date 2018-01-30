/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.trudeau;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.GameObject;
import julyfight.gamestate.Game;
import julyfight.physics.RectangleCollider;
import julyfight.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class CAF extends GameObject {

    private Player player;
    private Game game;
    private int x;
    
    private Image image;
    private float timeAlive;
    private float timeFromShot;
    
    public CAF(int x, Player player, Game game){
        this.x = x;
        this.player = player;
        this.game = game;
    }
    
    @Override
    public void init(GameContainer gc) {
        try {
            image = new Image("julyfight/assets/trudeau/CAF.png");
            timeAlive = 0;
            timeFromShot = 0;
        } catch (SlickException ex) {
            Logger.getLogger(CAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, int delta) {
        timeAlive += (float)delta / 1000;
        timeFromShot += (float)delta / 1000;
        if(timeFromShot > 1){
            RectangleCollider hitbox = new RectangleCollider(x, game.getBottom() - 196, 800, 1);
            game.hit(hitbox, player.getPlayerNumber(), 5, 0.2);
            timeFromShot = 0;
        }
        if(timeAlive > 3.1){
            game.removeGameObject(this);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        image.draw(x - 128, game.getBottom() - 256);
    }
    
}
