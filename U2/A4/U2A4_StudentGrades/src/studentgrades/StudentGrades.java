/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgrades;

import java.awt.Dialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Darian
 */
public class StudentGrades extends javax.swing.JFrame {
    //Array to store student info
    //For each row, 0 is first name, 1 is last name, 2-5 is test scores
    private Object[][] studentInfo;
    
    //Stores index at which to add new student
    //(initially 0, after adding student at index 0, will be one)
    //Also represents how many students have been added
    private int studentsAdded;
    
    /**
     * Creates new form StudentGrades
     */
    public StudentGrades() {
        initComponents();
        //Initialise array to have room for 15 students and 6 pieces of info for each student (first and last names, 4 test scores)
        studentInfo = new Object[15][6];
        //No students added yet, next index to add students at is 0
        studentsAdded = 0;
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

        controlsPanel = new javax.swing.JPanel();
        namePanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        testsPanel = new javax.swing.JPanel();
        test1Label = new javax.swing.JLabel();
        test1Field = new javax.swing.JTextField();
        test2Label = new javax.swing.JLabel();
        test2Field = new javax.swing.JTextField();
        test3Label = new javax.swing.JLabel();
        test3Field = new javax.swing.JTextField();
        test4Label = new javax.swing.JLabel();
        test4Field = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        listButton = new javax.swing.JButton();
        studentAvgButton = new javax.swing.JButton();
        courseAvgButton = new javax.swing.JButton();
        outputScrollPane = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlsPanel.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 100};
        namePanel.setLayout(jPanel1Layout);

        nameLabel.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        namePanel.add(nameLabel, gridBagConstraints);

        firstNameLabel.setText("First:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        namePanel.add(firstNameLabel, gridBagConstraints);

        lastNameLabel.setText("Last:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        namePanel.add(lastNameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        namePanel.add(firstNameField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        namePanel.add(lastNameField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlsPanel.add(namePanel, gridBagConstraints);

        java.awt.GridBagLayout testsPanelLayout = new java.awt.GridBagLayout();
        testsPanelLayout.columnWidths = new int[] {0, 60, 0, 60, 0, 60, 0, 60};
        testsPanel.setLayout(testsPanelLayout);

        test1Label.setText("Test 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        testsPanel.add(test1Label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        testsPanel.add(test1Field, gridBagConstraints);

        test2Label.setText("Test 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        testsPanel.add(test2Label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        testsPanel.add(test2Field, gridBagConstraints);

        test3Label.setText("Test 3:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        testsPanel.add(test3Label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        testsPanel.add(test3Field, gridBagConstraints);

        test4Label.setText("Test 4:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        testsPanel.add(test4Label, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        testsPanel.add(test4Field, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        controlsPanel.add(testsPanel, gridBagConstraints);

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonsPanel.add(addButton, gridBagConstraints);

        listButton.setText("List");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonsPanel.add(listButton, gridBagConstraints);

        studentAvgButton.setText("Student Average");
        studentAvgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentAvgButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonsPanel.add(studentAvgButton, gridBagConstraints);

        courseAvgButton.setText("Course Average");
        courseAvgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseAvgButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonsPanel.add(courseAvgButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlsPanel.add(buttonsPanel, gridBagConstraints);

        getContentPane().add(controlsPanel, java.awt.BorderLayout.PAGE_START);

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputTextArea.setTabSize(4);
        outputScrollPane.setViewportView(outputTextArea);

        getContentPane().add(outputScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //Add a student to the array based on the data given
        
        //Make sure we have less than 15 students
        if(studentsAdded >= 15){
            //15 students have already been added
            
            //Show an error message to tell the user that they cannot add any more students
            JOptionPane.showMessageDialog(this, "15 students have already been added!", "Max Students Reached", JOptionPane.ERROR_MESSAGE);
            //Return to prevent the rest of the method from running
            return;
        }
        
        //Strings to hold fist and last name
        String firstName, lastName;
        
        //Doubles to hold test scores
        Double test1, test2, test3, test4;
        
        //Get names from name fields
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        
        //Try to parse test scores from input fields
        try{
            test1 = Double.parseDouble(test1Field.getText());
            test2 = Double.parseDouble(test2Field.getText());
            test3 = Double.parseDouble(test3Field.getText());
            test4 = Double.parseDouble(test4Field.getText());
        }catch(NumberFormatException e){
            //If one of the test scores is formated wrong
            outputTextArea.setText(e.getLocalizedMessage());
            return;
        }
        //Add info to table as described above table declaration
        studentInfo[studentsAdded][0] = firstName;
        studentInfo[studentsAdded][1] = lastName;
        studentInfo[studentsAdded][2] = test1;
        studentInfo[studentsAdded][3] = test2;
        studentInfo[studentsAdded][4] = test3;
        studentInfo[studentsAdded][5] = test4;
        
        //Increment studentsAdded counter to be next avaliable index
        studentsAdded++;
    }//GEN-LAST:event_addButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        //String to store the ouput we will display
        //Initialised to be empty as it will be appended
        String output = "";
        
        //Iterate for all the students in the list
        //Limit i to be less than students added as students added is an index with no student yet
        for(int i = 0; i < studentsAdded; i++){
            //Formats student info on 5 lines
            //First line is thier name as First Last
            //2nd to 5th lines are test scores, tab indented by 1
            String info = String.format(
                    "%s %s:\n"//Name: First, Last
                        + "\tTest 1: %s\n"//Test X: (score)
                        + "\tTest 2: %s\n"
                        + "\tTest 3: %s\n"
                        + "\tTest 4: %s\n", 
                    studentInfo[i][0],//First name
                    studentInfo[i][1],//Last name
                    studentInfo[i][2],//Test 1
                    studentInfo[i][3],//Test 2
                    studentInfo[i][4],//Test 3
                    studentInfo[i][5]);//Test 4
            //Add this student's info to the output string to be displayed
            output += info;
        }
        //Set the text of the text area to the final output string with all the student info
        outputTextArea.setText(output);
    }//GEN-LAST:event_listButtonActionPerformed

    private void studentAvgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentAvgButtonActionPerformed
        //Find the average of the specified student

        //Variable to store index of the student we're averaging
        //Set to -1 so we can check if we can't find the student (it will only be -1 if we can't find the student)
        int studentIndex = -1;
        
        //Store the first and last name of the student we are looking for
        String first, last;
        
        //Get name values from fields
        first = firstNameField.getText();
        last = lastNameField.getText();
        
        //Iterate through the students until we find the one we want
        for(int i = 0; i < studentsAdded; i++){
            //Check if the first and last name are equal to the ones of the student at this index
            if(first.equals(studentInfo[i][0]) && last.equals(studentInfo[i][1])){
                //Set index variable to current index
                studentIndex = i;
                //Exit the loop now that we have the index
                break;
            }
        }
        
        //If studentIndex is -1 then we couldn't find the student
        if(studentIndex == -1){
            //Output to the area that the student could not be found
            outputTextArea.setText(String.format("Student not found: %s %s", first, last));
            //Return to prevent trying to find the average on a non-exsistant student
            return;
        }
        
        //Get test values from the array and cast them to Doubles
        //They need this cast as they are stored as Objects in the array
        double test1 = (Double)studentInfo[studentIndex][2];
        double test2 = (Double)studentInfo[studentIndex][3];
        double test3 = (Double)studentInfo[studentIndex][4];
        double test4 = (Double)studentInfo[studentIndex][5];
        
        //Calculate the average
        double average = (test1 + test2 + test3 + test4) / 4;
        
        //Create formated string for output with full name and average
        String output = String.format("%s %s's average is %s", first, last, average);
        
        //Set text area the show output string
        outputTextArea.setText(output);
    }//GEN-LAST:event_studentAvgButtonActionPerformed

    private void courseAvgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseAvgButtonActionPerformed
        //Variables to store test averages
        double avg1, avg2, avg3, avg4;
        //Set them to 0 so they can be added to
        avg1 = avg2 = avg3 = avg4 = 0;
        
        //Iterate through students to add thier test scores to the average
        for(int i = 0; i < studentsAdded; i++){
            //Add student's scores to average vars
            avg1 += (Double)studentInfo[i][2];
            avg2 += (Double)studentInfo[i][3];
            avg3 += (Double)studentInfo[i][4];
            avg4 += (Double)studentInfo[i][5];
        }
        //Divide the vars by the number of students added to get the final average
        avg1 /= studentsAdded;
        avg2 /= studentsAdded;
        avg3 /= studentsAdded;
        avg4 /= studentsAdded;
        
        String output = String.format(
                "Test 1: %s\n"//Output string puts test number to title average all on new lines
                + "Test 2: %s\n"
                + "Test 3: %s\n"
                + "Test 4: %s\n",
                avg1, avg2, avg3, avg4);
        //Set ouput text area to show output text
        outputTextArea.setText(output);
    }//GEN-LAST:event_courseAvgButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentGrades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JButton courseAvgButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton listButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel namePanel;
    private javax.swing.JScrollPane outputScrollPane;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JButton studentAvgButton;
    private javax.swing.JTextField test1Field;
    private javax.swing.JLabel test1Label;
    private javax.swing.JTextField test2Field;
    private javax.swing.JLabel test2Label;
    private javax.swing.JTextField test3Field;
    private javax.swing.JLabel test3Label;
    private javax.swing.JTextField test4Field;
    private javax.swing.JLabel test4Label;
    private javax.swing.JPanel testsPanel;
    // End of variables declaration//GEN-END:variables
}
