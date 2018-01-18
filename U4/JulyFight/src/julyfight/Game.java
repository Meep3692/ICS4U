/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

import java.util.EnumSet;
import julyfight.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Awoo
 */
public class Game implements GameState {

    Player player1;
    Player player2;
    
    private EnumSet<Controls> buttonsDown;
    private EnumSet<Controls> buttons;
    private EnumSet<Controls> buttonsUp;
    
    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    
    @Override
    public void init(GameContainer gc) {
        player1.init(gc, this);
    }

    @Override
    public void update(GameContainer gc, int delta) {
        buttonsDown = EnumSet.noneOf(Controls.class);
        buttons.removeAll(buttonsUp);
        //TODO: input!
        player1.update(gc, delta);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        player1.render(gc, g);
    }
    
    public int getBottom(){
        return 600;
    }
    
}
