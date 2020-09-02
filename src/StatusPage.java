import model.Driver;
import model.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Nov 10 02:05:20 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class StatusPage extends JFrame {
    User user;
    public StatusPage(User user) {
        this.user = user;
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        DatabaseController databaseController = new DatabaseController();
        databaseController.initialiseDatabase();
        databaseController.setStatus(user.getUserName(),"Free");
        String driver_name = databaseController.getRideDriver(user.getUserName());
        String drop=databaseController.getDrop(user.getUserName());
        for(int i = 0; i< homePage.drivers_list.size(); i++)
        {
            if(homePage.drivers_list.get(i).getDriver_name().equals(driver_name))
            {
                //homePage.drivers_list.get(i).setAvailability("YES");
                databaseController.setDriverStatus(homePage.drivers_list.get(i).getDriver_name(),"YES");
                databaseController.setDriverPosition(homePage.drivers_list.get(i).getDriver_name(),drop);
                //homePage.drivers_list.get(i).setPosition(drop);
            }
        }
        databaseController.deleteRide(user.getUserName());
        databaseController.closeDatabaseConnection();
        FeedbackPage feedbackPage = new FeedbackPage(user.getUserName(),driver_name);
        feedbackPage.setVisible(true);
//        MainPage mainPage = new MainPage(user.getUserName());
//        mainPage.setVisible(true);
        this.dispose();
    }

    private void button2ActionPerformed(ActionEvent e) {
        DatabaseController databaseController = new DatabaseController();
        databaseController.initialiseDatabase();
        String driver_name = databaseController.getRideDriver(user.getUserName());
        String drop=databaseController.getDrop(user.getUserName());
        String pickup = databaseController.getPickup(user.getUserName());
        databaseController.closeDatabaseConnection();
        Driver driver=null;
        for (int i = 0; i< homePage.drivers_list.size(); i++)
        {
            if(homePage.drivers_list.get(i).getDriver_name().equals(driver_name))
            {
                driver = homePage.drivers_list.get(i);
            }
        }
        DriverDetails driverDetails = new DriverDetails(user,driver,pickup,drop);
        driverDetails.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Seems your in a middle of ride!!");

        //---- label2 ----
        label2.setText("If Done please select the FINISH button");

        //---- button1 ----
        button1.setText("FINISH RIDE!!");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("View Driver Details");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(70, 70, 70))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addGap(37, 37, 37)
                    .addComponent(button2)
                    .addGap(26, 26, 26)
                    .addComponent(button1)
                    .addContainerGap(83, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
