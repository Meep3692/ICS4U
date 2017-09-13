/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetings;

import javax.swing.*;

/**
 *
 * @author awoo
 */
public class GreetingsFrame extends JFrame {
    public GreetingsFrame(){
        super("Hello!");
        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JLabel label = new JLabel("Hello!");
        
    }
}
