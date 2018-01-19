/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight.gamestate;

import java.util.logging.Level;
import java.util.logging.Logger;
import julyfight.Config;
import julyfight.Control;
import julyfight.JulyFight;
import julyfight.player.Diefenbaker;
import julyfight.player.Trudeau;
import julyfight.ui.Button;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Darian
 */
public class MainMenu extends GameState {

    private int selection;
    private static final int MAX_SELECTION = 0;
    
    private Button play;
    
    private Image background;

    public MainMenu(JulyFight julyFight) {
        super(julyFight);
    }
    
    @Override
    public void init(GameContainer gc) {
        
        gc.getInput().addListener(this);
        
        selection = 0;
        play = new Button(0, 100, 200, 100, "julyfight/assets/ui/play.png");
        try {
            background = new Image("julyfight/assets/ui/menubg.png");
        } catch (SlickException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, int delta) {
        
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        background.draw();
        play.render(gc, g);
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
        if(Config.controls[key] == Control.P1UP || Config.controls[key] == Control.P2UP){
            selection--;
            if(selection < 0)
                selection = MAX_SELECTION;
        }else if(Config.controls[key] == Control.P1UP || Config.controls[key] == Control.P2UP){
            selection++;
            if(selection > MAX_SELECTION)
                selection = 0;
        }else if(Config.controls[key] != Control.NONE){
            switch(selection){
                case 0:
                    julyFight.pushState(new Game(new Trudeau(), new Diefenbaker(), julyFight));
            }
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        
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
