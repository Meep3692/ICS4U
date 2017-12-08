/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksearch;

/**
 * GUI and main entry point
 * @author Darian
 */
public class BookSearch extends javax.swing.JFrame {

    BookCollection collection;
    SearchMethod linear;
    SearchMethod binary;
    
    /**
     * Creates new form BookSearch
     */
    public BookSearch() {
        //Load book collection
        collection = BookCollection.loadFile("booklist.txt");
        //Simple linear search
        linear = (Book[] books, int refNumber) -> {
            for(Book book : books){//Iterate through books
                if(book.getRefNumber() == refNumber){//Found book
                    return book.getTitle();//Return title
                }
            }
            return "Not found";//Iterated through all, didn't find it
        };
        //This is an anonymous class instead of a lamba expression bc it needs 2 methods
        binary = new SearchMethod(){
            
            //Modified version of binary search example in content
            private String binarySearch(Book[] books, int refNumber, int left, int right){
                int middle;
                if(left > right) return "Not found";//The range is negative so it's run until it's not found it
                middle = (left + right) / 2;//Calculate middle of range
                if(books[middle].getRefNumber() == refNumber){//If this is equal, we've found it
                    return books[middle].getTitle();//Return title
                }else if(books[middle].getRefNumber() > refNumber){//It is left of the middle
                    return binarySearch(books, refNumber, left, middle - 1);//Search that half of the range
                }else{//It is right of the centre
                    return binarySearch(books, refNumber, middle + 1, right);//Search that half of the range
                }
            }
            
            @Override
            public String search(Book[] books, int refNumber) {
                return binarySearch(books, refNumber, 0, books.length - 1);//Use the recursive binary search method
            }
            
        };
        initComponents();
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

        refNumberLabel = new javax.swing.JLabel();
        refNumberField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        linearLabel = new javax.swing.JLabel();
        linearField = new javax.swing.JTextField();
        binaryLabel = new javax.swing.JLabel();
        binaryField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        linearTimeLabel = new javax.swing.JLabel();
        linearTimeField = new javax.swing.JTextField();
        binaryTimeLabel = new javax.swing.JLabel();
        binaryTimeField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 100, 0};
        getContentPane().setLayout(layout);

        refNumberLabel.setText("Library Reference Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(refNumberLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(refNumberField, gridBagConstraints);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(searchButton, gridBagConstraints);

        linearLabel.setText("Linear Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(linearLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(linearField, gridBagConstraints);

        binaryLabel.setText("Binary Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        getContentPane().add(binaryLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(binaryField, gridBagConstraints);

        jLabel1.setText("Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(jLabel1, gridBagConstraints);

        linearTimeLabel.setText("Linear Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        getContentPane().add(linearTimeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(linearTimeField, gridBagConstraints);

        binaryTimeLabel.setText("Binary Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        getContentPane().add(binaryTimeLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(binaryTimeField, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        int refNumber = Integer.parseInt(refNumberField.getText());//Parse input number
        
        SearchResult linearResults = collection.search(linear, refNumber);//Run linear search
        linearField.setText(linearResults.title);//Set title output
        linearTimeField.setText(Long.toString(linearResults.timeNanos));//Set time output
        
        SearchResult binaryResults = collection.search(binary, refNumber);//Run binary search
        binaryField.setText(binaryResults.title);//Set title output
        binaryTimeField.setText(Long.toString(binaryResults.timeNanos));//Set time output
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField binaryField;
    private javax.swing.JLabel binaryLabel;
    private javax.swing.JTextField binaryTimeField;
    private javax.swing.JLabel binaryTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField linearField;
    private javax.swing.JLabel linearLabel;
    private javax.swing.JTextField linearTimeField;
    private javax.swing.JLabel linearTimeLabel;
    private javax.swing.JTextField refNumberField;
    private javax.swing.JLabel refNumberLabel;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
