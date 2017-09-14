/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetings;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author awoo
 */
public class GreetingsFrame extends JFrame {
    
    private String text = "My name is Darian, I go to North Dundas. I listen to a lot of 80s music. Recently, I found a show called \"Squirrel and Hedgehog\" which is a North Korean animated tv series that, although mostly being North Korean military propeganda, is a prety good show. My favorite colour is an agressive shade of mauve because mauve is normally such a peaceful and innocent colour.";
    
    public GreetingsFrame(){
        super("About Me");
        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("<html>" + text + "</html>");
        //Leaving it as default layout because it works for this situation
        add(label);
        setVisible(true);
    }
}
