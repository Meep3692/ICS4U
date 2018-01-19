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
 * @author Awoo
 */
public class Config {
    public static Control[] controls;
    
    public static void loadConfig(){
        controls = new Control[250];
        for(int i = 0; i < 250; i++){
            controls[i] = Control.NONE;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.cfg"));
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(" ");
                int keyCode = Integer.parseInt(parts[0]);
                Control control = Control.valueOf(parts[1]);
                controls[keyCode] = control;
            }
            br.close();
        } catch (FileNotFoundException ex) {
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
            saveConfig();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void saveConfig(){
        try {
            FileWriter fr = new FileWriter("config.cfg", false);
            for(int i = 0; i < controls.length; i++){
                if(controls[i] != Control.NONE){
                    fr.write(String.format("%d %s\n", i, controls[i]));
                }
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
