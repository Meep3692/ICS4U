/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

import julyfight.gamestate.Game;
import julyfight.physics.RectangleCollider;
import julyfight.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Darian
 */
public class LightPunch extends Move {

    public LightPunch(Game game, Player player) {
        super(game, player);
    }

    @Override
    public void execute() {
        RectangleCollider hitBox = new RectangleCollider(player.getPosition().getX(), player.getPosition().getY() - 154, 84, 23);
        game.hit(hitBox, player.getPlayerNumber(), 1, 0.2);
    }

    @Override
    public void init(GameContainer gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(GameContainer gc, int delta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
