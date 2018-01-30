/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move.diefenbaker;

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
 * @author Awoo
 */
public class Missle extends GameObject {

    Image image;
    private int x;
    private int y;
    
    private Game game;
    private Player player;
    
    public Missle(int x, Game game, Player player){
        this.x = x;
        this.y = 0;
        this.game = game;
        this.player = player;
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
        if(y > 600){
            RectangleCollider hitbox = new RectangleCollider(x - 200, 400, y - 200, 400);
            game.hit(hitbox, player.getPlayerNumber(), 15, 2);
            game.removeGameObject(this);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        image.draw(x - 128, y - 512);
    }
    
}
