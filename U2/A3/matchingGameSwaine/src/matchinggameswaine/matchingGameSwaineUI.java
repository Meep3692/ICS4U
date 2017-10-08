/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchinggameswaine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
/**
 *
 * @author jonswaine
 */
public class matchingGameSwaineUI extends javax.swing.JFrame implements ActionListener {
    
    //Stores value of cards
    ArrayList<Integer> cards = new ArrayList();
    //Stores card set (two of ever type of card)
    ArrayList<Integer> set = new ArrayList();
    //Store buttons
    ArrayList<JButton> buttons = new ArrayList();
    //Current theme
    Theme theme;
    
    //Count: How many cards are flipped
    //c1, c2 first and second card flipped
    //cardCount is the number of cards
    int count, c1, c2, cardCount;
    //How many cards are left
    int cardsLeft;
    //Stores card states (0=flipped, 1=normal, 2=done)
    int[] change;
    
    /**
     * Creates new form matchingGameSwaineUI
     */
    public matchingGameSwaineUI() {
        initComponents();
        try {
            //Add icons
            theme = Theme.loadTheme("ReZeroTheme.zip");//Defaulting to this to make it more obvious
        } catch (IOException ex) {
            Logger.getLogger(matchingGameSwaineUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        setSize(800, 600);//Set size to not be the size of very small
    }
    
    private int[] makeSquarish(int count){
        int start = (int)Math.sqrt(count);//Find roughly the square root
        for(int i = start; i > 0; i--){
            if(count % i == 0){//If this is divisible, it will make a rectangle
                return new int[]{i, count / i};//Return values in array
            }
        }
        return new int[]{1, count};//This is technicaly unreachable but this makes java happy
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        victoryDialog = new javax.swing.JDialog();
        victoryButtonsPanel = new javax.swing.JPanel();
        victoryOkButton = new javax.swing.JButton();
        victoryText = new javax.swing.JLabel();
        fileChooser = new javax.swing.JFileChooser();
        titleLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        controlsPanel = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        cardCountField = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        themeMenuItem = new javax.swing.JMenuItem();

        victoryDialog.setTitle("Congratulations");

        victoryButtonsPanel.setLayout(new java.awt.GridBagLayout());

        victoryOkButton.setText("Ok");
        victoryOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        victoryButtonsPanel.add(victoryOkButton, new java.awt.GridBagConstraints());

        victoryDialog.getContentPane().add(victoryButtonsPanel, java.awt.BorderLayout.PAGE_END);

        victoryText.setText("Congratulations, you won!");
        victoryDialog.getContentPane().add(victoryText, java.awt.BorderLayout.CENTER);

        fileChooser.setDialogTitle("Open");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Match Game");

        titleLabel.setFont(new java.awt.Font("Big Caslon", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 51, 51));
        titleLabel.setText("Matching Game");
        getContentPane().add(titleLabel, java.awt.BorderLayout.NORTH);

        buttonsPanel.setLayout(new java.awt.GridLayout(4, 4));
        getContentPane().add(buttonsPanel, java.awt.BorderLayout.CENTER);

        controlsPanel.setLayout(new java.awt.GridBagLayout());

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        controlsPanel.add(btnPlay, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        controlsPanel.add(cardCountField, gridBagConstraints);

        btnExit.setText("Exit");
        btnExit.setActionCommand("");
        btnExit.setAutoscrolls(true);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        controlsPanel.add(btnExit, gridBagConstraints);

        jLabel1.setText("Cards:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        controlsPanel.add(jLabel1, gridBagConstraints);

        getContentPane().add(controlsPanel, java.awt.BorderLayout.SOUTH);

        fileMenu.setText("File");

        themeMenuItem.setText("Load Theme");
        themeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(themeMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);//Trust the OS to release resources when the process exits
    }//GEN-LAST:event_btnExitActionPerformed

    //Hit play button
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        victoryDialog.setVisible(false);
        buttonsPanel.removeAll();//Reset buttons
        buttons.clear();
        set.clear();//Clear card set
        cards.clear();//Clear cards
        try{//Parse card count or default to 16
            cardCount = Integer.parseInt(cardCountField.getText());
        }catch(NumberFormatException e){
            cardCount = 16;
        }
        cardsLeft = cardCount;
        
        change = new int[cardCount];//Reset state array size
        //Reset all cards to default state
        for (int z=0; z < cardCount; z++)
        {
            change[z] = 1;
        }
        
        int cardSetSize = theme.cardFaces.size();
        if(cardCount < cardSetSize * 2){
            cardSetSize = cardCount / 2;
        }
        System.out.println(cardSetSize);
        //Add every card type to arraylist twice for as many cards as we need
        while(set.size() < cardCount)
            for (int x=0; x < cardSetSize; x++)
            {
                set.add(x);
                set.add(x);
            }
        
        //Randomly assign card types from set to cards
        for (int x = 0; x < cardCount; x++)
        {
            double index = Math.floor(Math.random() *(cardCount-x));//Randomly choose index in card set
            int index1 = (int) index;//cast to int
            cards.add(set.get(index1));//set card
            set.remove(set.get(index1));//remove from avaliable cards
            change[x] = 1;//reset card state
            
            JButton button = new JButton();//New card button
            button.setIcon(theme.back);//Set icon to default
            button.setName("guessButton" + x);//Set name for later identification
            button.addActionListener(this);//Set action listener to this class
            buttonsPanel.add(button, x);//Add to panel
            buttons.add(button);//Add to list
        }
        GridLayout layout = (GridLayout)buttonsPanel.getLayout();//Get layout
        int[] dimensions = makeSquarish(cardCount);//Make roughly square
        layout.setRows(dimensions[0]);
        layout.setColumns(dimensions[1]);
        
        invalidate();//Stuff for repainting
        validate();
        repaint();//Repaint panel so buttons show
    }//GEN-LAST:event_btnPlayActionPerformed

    private void themeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeMenuItemActionPerformed
        int response = fileChooser.showOpenDialog(this);
        if(response == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                theme = Theme.loadTheme(file.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(matchingGameSwaineUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_themeMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(matchingGameSwaineUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(matchingGameSwaineUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(matchingGameSwaineUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(matchingGameSwaineUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new matchingGameSwaineUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JTextField cardCountField;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem themeMenuItem;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel victoryButtonsPanel;
    private javax.swing.JDialog victoryDialog;
    private javax.swing.JButton victoryOkButton;
    private javax.swing.JLabel victoryText;
    // End of variables declaration//GEN-END:variables

    //Button pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if(button.getName().startsWith("guessButton") && count < 2){//Are we a card and are there less than 2 cards flipped
            int buttonID = Integer.parseInt(button.getName().substring(11));//Parse id from name
            if(change[buttonID] == 1){//Are we flipped on our back
                int cardType = cards.get(buttonID);//Get type of current card
                button.setIcon(theme.cardFaces.get(cardType));//Set icon to our card
                change[buttonID] = 0;//Set state of card to flipped
                count++;//Add to cards flipped counter
                
                if(count == 1){//Set c1 or c2 depending on which card we are
                    c1 = cardType;
                }else if(count == 2){
                    c2 = cardType;
                    new Thread(() -> {
                        cardsFlipped();
                    }).start();
                }
            }
        }
    }
    
    private void cardsFlipped(){
        try {
            Thread.sleep(1000);//Wait for a second
            count = 0;//Reset count
            if (c1 == c2)//Check cards are the same
            {
                for(int i = 0; i < cardCount; i++){//Set cards to finished
                    if(change[i] == 0){//Card is flipped
                        buttons.get(i).setIcon(theme.done);
                        change[i] = 2;
                    }
                }
                cardsLeft -= 2;//Subtract from cards left
                if(cardsLeft < 1){
                    victoryDialog.setSize(200, 100);
                    victoryDialog.setVisible(true);
                }
            } 
            else 
            {
                for(int i = 0; i < cardCount; i++){//Reset cards
                    if(change[i] == 0){//Card is flipped
                        buttons.get(i).setIcon(theme.back);
                        change[i] = 1;
                    }
                }
            }
        } catch (InterruptedException ex) {
            //This should never happen
            Logger.getLogger(matchingGameSwaineUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
