/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.gamestate;

import java.util.EnumSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.Config;
import julyfight.Control;
import julyfight.JulyFight;
import julyfight.player.Player;
import julyfight.ui.Bar;
import julyfight.ui.Effect;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Main game state
 * @author Darian
 */
public class Game extends GameState {

    public Player player1;//Player 1
    public Player player2;//PLayer 2
    
    //Sets of buttons that were pressed held or unpressed this frame
    private EnumSet<Control> buttonsDown;
    private EnumSet<Control> buttons;
    private EnumSet<Control> buttonsUp;
    
    private List<Effect> effects;//Effects
    private Bar healthBars;
    private Image background;//Background image
    
    public Game(Player player1, Player player2, JulyFight julyFight){
        super(julyFight);
        
        this.player1 = player1;//Set players
        this.player2 = player2;
        
        buttonsDown = EnumSet.noneOf(Control.class);//Initialise control sets
        buttons = EnumSet.noneOf(Control.class);
        buttonsUp = EnumSet.noneOf(Control.class);
        
        effects = new ArrayList<>();
    }
    
    @Override
    public void init(GameContainer gc) {
        player1.init(gc, this, 1);//Init player 1
        player2.init(gc, this, 2);//Init player 1
        
        //Add this as input listener
        gc.getInput().addListener(this);
        
        try {
            background = new Image("julyfight/assets/hillNight.png");
            Image barsbg = new Image("julyfight/assets/ui/bars/barsbg.png");
            Image bar = new Image("julyfight/assets/ui/bars/bar.png");
            healthBars = new Bar(bar, barsbg, player1, player2);
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, int delta) {
        player1.update(gc, delta);//Update players
        player2.update(gc, delta);
        for(Effect effect : effects){//Update effects
            effect.update(gc, delta);//Run update
            if(effect.isDead()){//Remove when dead
                effects.remove(effect);
            }
        }
        buttonsDown = EnumSet.noneOf(Control.class);
        buttonsUp = EnumSet.noneOf(Control.class);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        background.draw();//Render background
        player1.render(gc, g);//Render players
        player2.render(gc, g);
        for(Effect effect : effects){//Render effects
            effect.render(gc, g);
        }
        healthBars.render(gc, g);
    }
    
    /**
     * Check if a control has been pressed since the last update
     * @param control Control to check
     * @return True if the rising edge of a button press has occurred since the end of the last update
     */
    public boolean getControlDown(Control control){
        return buttonsDown.contains(control);
    }
    
    /**
     * Check if a control is currently being held
     * @param control Control to check
     * @return True if the control is held down, otherwise false
     */
    public boolean getControl(Control control){
        return buttons.contains(control);
    }
    
    /**
     * Check if a control has been released since the end of the last frame
     * @param control Control to check
     * @return True if the falling edge of a button press has occurred since the end of the last update
     */
    public boolean getControlUp(Control control){
        return buttonsUp.contains(control);
    }
    
    public int getBottom(){
        return 600;
    }

    @Override
    public void mouseWheelMoved(int change) {
        
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        
    }

    @Override
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        
    }

    @Override
    public void setInput(Input input) {
        
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
        
    }

    @Override
    public void keyPressed(int key, char c) {
        Control control = Config.controls[key];//Key control from button mapping config
        if(control != Control.NONE){//If this key is mapped
            buttonsDown.add(control);//Add to buttons down this frame
            buttons.add(control);//Add to buttons currently being pressed
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        Control control = Config.controls[key];
        if(control != null){
            buttons.remove(control);
            buttonsUp.add(control);
        }
    }

    @Override
    public void controllerLeftPressed(int controller) {
        
    }

    @Override
    public void controllerLeftReleased(int controller) {
        
    }

    @Override
    public void controllerRightPressed(int controller) {
        
    }

    @Override
    public void controllerRightReleased(int controller) {
        
    }

    @Override
    public void controllerUpPressed(int controller) {
        
    }

    @Override
    public void controllerUpReleased(int controller) {
        
    }

    @Override
    public void controllerDownPressed(int controller) {
        
    }

    @Override
    public void controllerDownReleased(int controller) {
        
    }

    @Override
    public void controllerButtonPressed(int controller, int button) {
        
    }

    @Override
    public void controllerButtonReleased(int controller, int button) {
        
    }
    
}
