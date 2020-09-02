import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;
import javax.swing.*;

import model.Driver;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Nov 07 22:27:05 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class homePage extends JPanel {
    public static ArrayList<Driver> drivers_list = new ArrayList<>();
    homePage homePage;
    public homePage() {

        System.out.println("In homePage");
        homePage = this;
        DatabaseController databaseController = new DatabaseController();
        databaseController.initialiseDatabase();
        initComponents();
        frame1.setVisible(true);
        drivers_list = databaseController.getDrivers();
        databaseController.closeDatabaseConnection();
    }


    private void loginMouseClicked(MouseEvent e) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        frame1.dispose();
    }

    private void signupMouseClicked(MouseEvent e) {
        Sign_inPage sign_inPage = new Sign_inPage();
        sign_inPage.setVisible(true);
        frame1.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        frame1 = new JFrame();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();

        //======== frame1 ========
        {
            frame1.setTitle("Welcome to HOPP");
            Container frame1ContentPane = frame1.getContentPane();

            //---- button1 ----
            button1.setText("LOGIN");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loginMouseClicked(e);
                }
            });

            //---- button2 ----
            button2.setText("SIGN UP");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    signupMouseClicked(e);
                }
            });

            //---- label1 ----
            label1.setText("     HOPP!!!");
            label1.setForeground(new Color(0, 153, 153));
            label1.setFont(new Font("Chalkduster", Font.BOLD, 24));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(130, 130, 130))
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(123, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JFrame frame1;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
