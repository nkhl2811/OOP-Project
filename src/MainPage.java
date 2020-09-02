import model.Driver;
import model.User;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import static java.lang.StrictMath.abs;
/*
 * Created by JFormDesigner on Sat Nov 09 01:28:48 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class MainPage extends JFrame {
    String userName;
    public MainPage(String userName) {
        this.userName = userName;
        initComponents();
        label1.setText("Hey,"+userName+"!");
        String[] locations = {"A","B","C","D","E","F","G","H","I"};
        DefaultComboBoxModel model1 = new DefaultComboBoxModel( locations );
        DefaultComboBoxModel model2 = new DefaultComboBoxModel( locations );
        comboBox1.setModel( model1 );
        comboBox2.setModel(model2);

    }

    private void bookActionPerformed(ActionEvent e) {
        if(comboBox1.getSelectedIndex()==comboBox2.getSelectedIndex())
        {
            JOptionPane.showMessageDialog(null,"Please Enter Valid Details");
        }
        else
        {
            //Matching driver
            String pickUp = comboBox1.getSelectedItem().toString();
            String drop = comboBox2.getSelectedItem().toString();
            Driver driver = getNearByDrivers(pickUp);
            if(driver==null)
            {
                JOptionPane.showMessageDialog(null,"Request Timed Out");
                JOptionPane.showMessageDialog(null,"Request Timed Out");
            }
            else
            {
                DatabaseController databaseController = new DatabaseController();
                databaseController.initialiseDatabase();
                databaseController.setDriverStatus(driver.getDriver_name(),"NO");
                databaseController.setStatus(userName,"Busy");
                String walletBalance = databaseController.getUserDetails(userName).getWalletBalance();
                if(Integer.parseInt(walletBalance)>300)
                {
                    char x = pickUp.charAt(0);
                    char y = drop.charAt(0);
                    databaseController.setBalance(userName,String.valueOf(Integer.parseInt(walletBalance)-abs(x-y)*50));
                    databaseController.addRide(userName,driver.getDriver_name(),pickUp,drop);
                    User user = databaseController.getUserDetails(userName);
                    databaseController.closeDatabaseConnection();
                    DriverDetails driverDetails = new DriverDetails(user,driver,pickUp,drop);
                    driverDetails.setVisible(true);
                    this.dispose();
                }
                else
                {
                    databaseController.closeDatabaseConnection();
                    JOptionPane.showMessageDialog(null,"Please Add Sufficient Balance");
                }
            }


        }
    }

    private Driver getNearByDrivers(String pickUp) {
        ArrayList<Driver> drivers = new ArrayList<>();
        for(int i=0;i< homePage.drivers_list.size();i++)
        {
            if(homePage.drivers_list.get(i).getAvailability().equals("YES"))
            {
                String pos = homePage.drivers_list.get(i).getPosition();
                char x = pickUp.charAt(0);
                char y = pos.charAt(0);
                if(abs(x-y)<=1)
                {
                    drivers.add(homePage.drivers_list.get(i));
                }
            }
        }
        Driver driver=null;
        Double rating =0.0;
        for (int i=0;i<drivers.size();i++)
        {
            if(Double.parseDouble(drivers.get(i).getRating())>rating)
            {
                rating = Double.parseDouble(drivers.get(i).getRating());
                driver = drivers.get(i);
            }
        }
        return driver;
    }

    private void button2ActionPerformed(ActionEvent e) {
        Addbalance addbalance = new Addbalance(userName);
        addbalance.setVisible(true);
    }

    private void button3ActionPerformed(ActionEvent e) {
        homePage homePage = new homePage();
        homePage.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Hey Ajith");

        //---- label2 ----
        label2.setText("Pickup Point");

        //---- label3 ----
        label3.setText("Drop Point");

        //---- button1 ----
        button1.setText("BOOK NOW");
        button1.addActionListener(e -> bookActionPerformed(e));

        //---- button2 ----
        button2.setText("Add Balance");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("Logout");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addContainerGap(168, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(65, 65, 65))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(43, 43, 43)
                    .addComponent(button1)
                    .addGap(26, 26, 26)
                    .addComponent(button2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                    .addComponent(button3)
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
