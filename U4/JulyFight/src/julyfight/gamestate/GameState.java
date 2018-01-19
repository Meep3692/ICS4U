/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.gamestate;

import julyfight.JulyFight;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;

/**
 *
 * @author Darian
 */
public abstract class GameState implements InputListener {
    
    protected JulyFight julyFight;
    
    public GameState(JulyFight julyFight){
        this.julyFight = julyFight;
    }
    
    public abstract void init(GameContainer gc);
    public abstract void update(GameContainer gc, int delta);
    public abstract void render(GameContainer gc, Graphics g);

    private boolean isActive = false;
    
    public final void setActive(boolean active){
        isActive = active;
    }
    
    @Override
    public final boolean isAcceptingInput(){
        return isActive;
    }
    
    
}
