/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.player.move;

import java.util.List;
import julyfight.GameObject;
import julyfight.gamestate.Game;
import julyfight.player.Input;
import julyfight.player.Player;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author Darian
 */
public abstract class Move {    
    protected final Game game;
    protected final Player player;
    protected Input[] inputs;
    
    public boolean continuous;
    
    public Move(Game game, Player player){
        this.game = game;
        this.player = player;
        continuous = false;
    }
    
    public Input getInput(int progress){
        return inputs[progress];
    }
    
    public int getLength(){
        return inputs.length;
    }
    
    public abstract void execute();
    
    /**
     * If a continuous move, will be run every frame it is held
     */
    public abstract void hold();
    
    public abstract void init(GameContainer gc);
}
