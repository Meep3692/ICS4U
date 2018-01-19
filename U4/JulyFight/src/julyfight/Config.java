/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package julyfight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Input;

/**
 *
 * @author Darian
 */
public class Config {
    public static Control[] controls;
    
    /**
     * Load configuration file
     */
    public static void loadConfig(){
        controls = new Control[250];//Initialise controls array
        for(int i = 0; i < 250; i++){//Set all keys to none
            controls[i] = Control.NONE;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.cfg"));//Open reader for config file
            String line;
            while((line = br.readLine()) != null){//Read each line
                String[] parts = line.split(" ");//Split line at space
                int keyCode = Integer.parseInt(parts[0]);//Parse key code from first part of line
                Control control = Control.valueOf(parts[1]);//Parse control from second part of line
                controls[keyCode] = control;//Set assignment in controls array
            }
            br.close();//Close config file
        } catch (FileNotFoundException ex) {//If there is no config file, set default controls and write config
            //Set player 1 controls
            controls[Input.KEY_W] = Control.P1UP;
            controls[Input.KEY_A] = Control.P1LEFT;
            controls[Input.KEY_S] = Control.P1DOWN;
            controls[Input.KEY_D] = Control.P1RIGHT;
            
            controls[Input.KEY_T] = Control.P1LP;
            controls[Input.KEY_Y] = Control.P1MP;
            controls[Input.KEY_U] = Control.P1HP;
            controls[Input.KEY_I] = Control.P1B1;
            
            controls[Input.KEY_G] = Control.P1LK;
            controls[Input.KEY_H] = Control.P1MK;
            controls[Input.KEY_J] = Control.P1HK;
            controls[Input.KEY_K] = Control.P1B2;
            
            //Set player 2 controls
            controls[Input.KEY_UP] = Control.P2UP;
            controls[Input.KEY_LEFT] = Control.P2LEFT;
            controls[Input.KEY_DOWN] = Control.P2DOWN;
            controls[Input.KEY_RIGHT] = Control.P2RIGHT;
            
            controls[Input.KEY_NUMPAD4] = Control.P2LP;
            controls[Input.KEY_NUMPAD5] = Control.P2MP;
            controls[Input.KEY_NUMPAD6] = Control.P2HP;
            controls[Input.KEY_ADD] = Control.P2B1;
            
            controls[Input.KEY_NUMPAD1] = Control.P2LK;
            controls[Input.KEY_NUMPAD2] = Control.P2MK;
            controls[Input.KEY_NUMPAD1] = Control.P2HK;
            controls[Input.KEY_NUMPADENTER] = Control.P2B2;
            
            //Write new config file
            saveConfig();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveConfig(){
        try {
            FileWriter fr = new FileWriter("config.cfg", false);//Open config file
            for(int i = 0; i < controls.length; i++){//For each control assaignment
                if(controls[i] != Control.NONE){//If it is set to a control
                    fr.write(String.format("%d %s\n", i, controls[i]));//Write the assaignment to the config file
                }
            }
            fr.close();//Close config file
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
