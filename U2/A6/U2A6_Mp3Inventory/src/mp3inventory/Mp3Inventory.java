/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3inventory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Main entry point and gui
 * @author Darian
 */
public class Mp3Inventory extends javax.swing.JFrame {

    private Mp3TableModel tableModel;//Model for song list table
    private Mp3TableModel searchTableModel;//Model for search list table
    
    /**
     * Creates new form Mp3Inventory
     */
    public Mp3Inventory() {
        //Initialise table models
        tableModel = new Mp3TableModel();
        searchTableModel = new Mp3TableModel();
        
        initComponents();
        
        //Handle mouse clicks on header for sorting
        songListTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = songListTable.columnAtPoint(e.getPoint());//Get column from mouse position
                col++;//Add 1 bc sorting columns are 1 more for inverse sorting (no -0)
                if(tableModel.getSortingMethod() == col)
                    col *= -1;//Invert for inverse sorting if we're sorting by that column
                tableModel.sortBy(col);//Sort by this column
                
                songListTable.invalidate();//Stuff for repainting
                songListTable.validate();
                songListTable.repaint();//Repaint table so new entry shows
            }
            
        });
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

        tabbedPane = new javax.swing.JTabbedPane();
        songsListPanel = new javax.swing.JPanel();
        songsListControlsPanel = new javax.swing.JPanel();
        removeSongButton = new javax.swing.JButton();
        songListScrollPane = new javax.swing.JScrollPane();
        songListTable = new javax.swing.JTable();
        addSongPanel = new javax.swing.JPanel();
        addSongInputsPanel = new javax.swing.JPanel();
        addSongTitleLabel = new javax.swing.JLabel();
        addSongTitleField = new javax.swing.JTextField();
        addSongArtistLabel = new javax.swing.JLabel();
        addSongArtistField = new javax.swing.JTextField();
        addSongAlbumLabel = new javax.swing.JLabel();
        addSongAlbumField = new javax.swing.JTextField();
        addSongLengthLabel = new javax.swing.JLabel();
        addSongLengthField = new javax.swing.JTextField();
        addSongYearLabel = new javax.swing.JLabel();
        addSongYearField = new javax.swing.JTextField();
        addSongButtonsPanel = new javax.swing.JPanel();
        addSongAddButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchControlsPanel = new javax.swing.JPanel();
        searchTypeComboBox = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchTableScrollPane = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mp3 Inventory");

        songsListPanel.setLayout(new java.awt.BorderLayout());

        songsListControlsPanel.setLayout(new java.awt.GridBagLayout());

        removeSongButton.setText("Remove");
        removeSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSongButtonActionPerformed(evt);
            }
        });
        songsListControlsPanel.add(removeSongButton, new java.awt.GridBagConstraints());

        songsListPanel.add(songsListControlsPanel, java.awt.BorderLayout.PAGE_START);

        songListTable.setModel(tableModel);
        songListScrollPane.setViewportView(songListTable);

        songsListPanel.add(songListScrollPane, java.awt.BorderLayout.CENTER);

        tabbedPane.addTab("Songs", songsListPanel);

        addSongPanel.setLayout(new java.awt.BorderLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 100};
        addSongInputsPanel.setLayout(jPanel1Layout);

        addSongTitleLabel.setText("Title: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        addSongInputsPanel.add(addSongTitleLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addSongInputsPanel.add(addSongTitleField, gridBagConstraints);

        addSongArtistLabel.setText("Artist:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        addSongInputsPanel.add(addSongArtistLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addSongInputsPanel.add(addSongArtistField, gridBagConstraints);

        addSongAlbumLabel.setText("Album:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        addSongInputsPanel.add(addSongAlbumLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addSongInputsPanel.add(addSongAlbumField, gridBagConstraints);

        addSongLengthLabel.setText("Length:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        addSongInputsPanel.add(addSongLengthLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addSongInputsPanel.add(addSongLengthField, gridBagConstraints);

        addSongYearLabel.setText("Year:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        addSongInputsPanel.add(addSongYearLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        addSongInputsPanel.add(addSongYearField, gridBagConstraints);

        addSongPanel.add(addSongInputsPanel, java.awt.BorderLayout.CENTER);

        addSongButtonsPanel.setLayout(new java.awt.GridBagLayout());

        addSongAddButton.setText("Add");
        addSongAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongAddButtonActionPerformed(evt);
            }
        });
        addSongButtonsPanel.add(addSongAddButton, new java.awt.GridBagConstraints());

        addSongPanel.add(addSongButtonsPanel, java.awt.BorderLayout.PAGE_END);

        tabbedPane.addTab("Add Song", addSongPanel);

        searchPanel.setLayout(new java.awt.BorderLayout());

        searchControlsPanel.setLayout(new java.awt.BorderLayout());

        searchTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Artist", "Album", "Year", "Length" }));
        searchControlsPanel.add(searchTypeComboBox, java.awt.BorderLayout.LINE_START);
        searchControlsPanel.add(searchField, java.awt.BorderLayout.CENTER);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchControlsPanel.add(searchButton, java.awt.BorderLayout.LINE_END);

        searchPanel.add(searchControlsPanel, java.awt.BorderLayout.PAGE_START);

        searchTable.setModel(searchTableModel);
        searchTableScrollPane.setViewportView(searchTable);

        searchPanel.add(searchTableScrollPane, java.awt.BorderLayout.CENTER);

        tabbedPane.addTab("Search", searchPanel);

        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSongAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongAddButtonActionPerformed
        String title, artist, album;//Vars to store mp3 info
        int length, year;
        //Get title artist and album from fields
        title = addSongTitleField.getText();
        artist = addSongArtistField.getText();
        album = addSongAlbumField.getText();
        //Try to parse the length or default to -1
        try{
            length = Integer.parseInt(addSongLengthField.getText());
        }catch(NumberFormatException e){
            //Length field isn't a number, -1
            length = -1;
        }
        //Try to parse the year field or default to -1
        try{
            year = Integer.parseInt(addSongYearField.getText());
        }catch(NumberFormatException e){
            //Year field isn't a number, -1
            year = -1;
        }
        //Create the mp3
        Mp3 mp3 = new Mp3(title, artist, album, length, year);
        //Add to the table model
        tableModel.addSong(mp3);
        
        songListTable.invalidate();//Stuff for repainting
        songListTable.validate();
        songListTable.repaint();//Repaint table so new entry shows
        
        //Clear inputs
        addSongTitleField.setText("");
        addSongArtistField.setText("");
        addSongAlbumField.setText("");
        addSongLengthField.setText("");
        addSongYearField.setText("");
    }//GEN-LAST:event_addSongAddButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //searchTableModel = new Mp3TableModel();//Reset search table
        searchTableModel.clearSongs();
        List<Mp3> allMp3s = tableModel.getList();//Get mp3s from main model
        String searchText = searchField.getText();//Get search query
        for (Mp3 mp3 : allMp3s) {
            //It would be more efficient to put loops in each case but this looks neater
            switch (searchTypeComboBox.getSelectedIndex()) {
                case 0:
                    //Title
                    if (mp3.getTitle().contains(searchText)) {//Use .contains to be more fuzzy
                        searchTableModel.addSong(mp3);//Add to search results table
                    }
                    break;
                case 1:
                    //Artist
                    if (mp3.getArtist().contains(searchText)) {
                        searchTableModel.addSong(mp3);
                    }
                    break;
                case 2:
                    //Album
                    if (mp3.getAlbum().contains(searchText)) {
                        searchTableModel.addSong(mp3);
                    }
                    break;
                case 3:
                    //Length
                    if (mp3.getLength() == Integer.parseInt(searchText)) {
                        searchTableModel.addSong(mp3);
                    }
                    break;
                case 4:
                    //Length
                    if (mp3.getYear() == Integer.parseInt(searchText)) {
                        searchTableModel.addSong(mp3);
                    }
                    break;
            }
        }
        //This should work but it doesn't for no reason and there's nothing I can do about it
        searchTable.invalidate();//Stuff for repainting
        searchTable.validate();
        searchTable.repaint();//Repaint table so new entry shows
    }//GEN-LAST:event_searchButtonActionPerformed

    private void removeSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSongButtonActionPerformed
        int index = songListTable.getSelectedRow();//Get selected row
        tableModel.removeSong(tableModel.getSongAtIndex(index));//Remove song at selected row
        
        songListTable.invalidate();//Stuff for repainting
        songListTable.validate();
        songListTable.repaint();//Repaint table so new entry shows
    }//GEN-LAST:event_removeSongButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Mp3Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mp3Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mp3Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mp3Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mp3Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSongAddButton;
    private javax.swing.JTextField addSongAlbumField;
    private javax.swing.JLabel addSongAlbumLabel;
    private javax.swing.JTextField addSongArtistField;
    private javax.swing.JLabel addSongArtistLabel;
    private javax.swing.JPanel addSongButtonsPanel;
    private javax.swing.JPanel addSongInputsPanel;
    private javax.swing.JTextField addSongLengthField;
    private javax.swing.JLabel addSongLengthLabel;
    private javax.swing.JPanel addSongPanel;
    private javax.swing.JTextField addSongTitleField;
    private javax.swing.JLabel addSongTitleLabel;
    private javax.swing.JTextField addSongYearField;
    private javax.swing.JLabel addSongYearLabel;
    private javax.swing.JButton removeSongButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchControlsPanel;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable searchTable;
    private javax.swing.JScrollPane searchTableScrollPane;
    private javax.swing.JComboBox<String> searchTypeComboBox;
    private javax.swing.JScrollPane songListScrollPane;
    private javax.swing.JTable songListTable;
    private javax.swing.JPanel songsListControlsPanel;
    private javax.swing.JPanel songsListPanel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
