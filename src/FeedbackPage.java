import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Tue Nov 12 18:39:31 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class FeedbackPage extends JFrame {
    String username;
    String drivername;
    public FeedbackPage(String username,String drivername) {
        this.username = username;
        this.drivername = drivername;
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        Double givenRating = Double.parseDouble(textField1.getText());
        DatabaseController databaseController = new DatabaseController();
        databaseController.initialiseDatabase();
        String rating = databaseController.getDriverRating(drivername);
        if(Double.parseDouble(rating)>5.0)
        {
            JOptionPane.showMessageDialog(null,"Please Enter Valid Rating");
        }
        else
        {
            int numRating = databaseController.getNoOfRatings(drivername);
            Double updatedRating = (Double.parseDouble(rating)*numRating+givenRating)/(numRating+1);
            databaseController.setDriverRating(drivername,String.valueOf(updatedRating));
            databaseController.setNoOfRatings(drivername,numRating+1);
            databaseController.closeDatabaseConnection();
            MainPage mainPage = new MainPage(username);
            mainPage.setVisible(true);
            this.dispose();
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        MainPage mainPage = new MainPage(username);
        mainPage.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        textField1 = new JTextField();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Please Rate Your Driver");

        //---- button1 ----
        button1.setText("Submit Rating");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("No Thanks!");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                    .addContainerGap(80, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                    .addGap(159, 159, 159))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addGap(18, 18, 18)
                    .addComponent(button2)
                    .addContainerGap(69, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JTextField textField1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
