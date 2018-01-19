/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.gamestate;

import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.Config;
import julyfight.Control;
import julyfight.JulyFight;
import julyfight.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Awoo
 */
public class Game extends GameState {

    Player player1;//Player 1
    Player player2;//PLayer 2
    
    //Sets of buttons that were pressed held or unpressed this frame
    private EnumSet<Control> buttonsDown;
    private EnumSet<Control> buttons;
    private EnumSet<Control> buttonsUp;
    
    private Image background;
    
    public Game(Player player1, Player player2, JulyFight julyFight){
        super(julyFight);
        this.player1 = player1;//Set players
        this.player2 = player2;
        buttonsDown = EnumSet.noneOf(Control.class);//Initialise control sets
        buttons = EnumSet.noneOf(Control.class);
        buttonsUp = EnumSet.noneOf(Control.class);
    }
    
    @Override
    public void init(GameContainer gc) {
        player1.init(gc, this, 1);//Init player 1
        player2.init(gc, this, 2);//Init player 1
        
        //Add this as input listener
        gc.getInput().addListener(this);
        
        try {
            background = new Image("julyfight/assets/hillNight.png");
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, int delta) {
        player1.update(gc, delta);
        player2.update(gc, delta);
        buttonsDown = EnumSet.noneOf(Control.class);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        background.draw();
        player1.render(gc, g);
        player2.render(gc, g);
    }
    
    public boolean getControlDown(Control control){
        return buttonsDown.contains(control);
    }
    
    public boolean getControl(Control control){
        return buttons.contains(control);
    }
    
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
