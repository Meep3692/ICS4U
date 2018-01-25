/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

import julyfight.GameObject;
import julyfight.gamestate.Game;
import julyfight.player.Player;
import org.newdawn.slick.Animation;

/**
 *
 * @author Darian
 */
public abstract class Move extends GameObject {
    public double duration;
    public Animation animation;
    
    protected final Game game;
    protected final Player player;
    
    public Move(Game game, Player player){
        this.game = game;
        this.player = player;
    }
    
    public abstract void execute();
}
