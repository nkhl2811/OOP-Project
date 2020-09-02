import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sat Nov 09 00:31:35 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class Sign_inPage extends JPanel {
    public Sign_inPage() {
        initComponents();
        frame1.setVisible(true);
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException {
        String name = textField1.getText();
        String phonenumber = textField2.getText();
        String email = textField6.getText();
        String password = passwordField1.getText();
        String confirmpassword = passwordField2.getText();
        String walletBalance = textField3.getText();
        if(name==null)
        {
            if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid UserName");
            }
        }
        else if(phonenumber==null)
        {
            if(phonenumber.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid phonenumber");
            }
        }
        else if(email==null)
        {
            if(email.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid email");
            }
        }
        else if(password==null)
        {
            if(password.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid password");
            }
        }
        else if(confirmpassword==null)
        {
            if(confirmpassword.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid confirmpassword");
            }
        }
        else if(walletBalance==null)
        {
            if(walletBalance.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid walletBalance");
            }
        }
        else
        {
            DatabaseController databaseController = new DatabaseController();
            databaseController.initialiseDatabase();
           // databaseController.addUser("X","1234567890","fgjhghj","hhhh","1234");
            String checkUser = databaseController.checkUser(name);
            if(checkUser.equals("s"))
            {
                JOptionPane.showMessageDialog(null,"UserName Already Exists");
            }
            else
            {
                if(password.equals(confirmpassword))
                {
                    JOptionPane.showMessageDialog(null,"Account Created Successfully!");
                    databaseController.addUser(name,password,email,phonenumber,walletBalance,"Free");
                    LoginPage loginPage =new LoginPage();
                    loginPage.setVisible(true);
                    frame1.dispose();
                }
            }
            databaseController.closeDatabaseConnection();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        frame1 = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField3 = new JTextField();
        textField6 = new JTextField();
        button1 = new JButton();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();

        //======== frame1 ========
        {
            Container frame1ContentPane = frame1.getContentPane();

            //---- label1 ----
            label1.setText("Name");

            //---- label2 ----
            label2.setText("Phone Number");

            //---- label3 ----
            label3.setText("E-Mail");

            //---- label4 ----
            label4.setText("Password");

            //---- label5 ----
            label5.setText("Confirm Password");

            //---- label6 ----
            label6.setText("Wallet Balance");

            //---- button1 ----
            button1.setText("SIGN UP");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button1MouseClicked(e);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGroup(frame1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(44, 44, 44)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(textField6, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(193, Short.MAX_VALUE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(label2))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addGap(46, 46, 46)
                        .addComponent(button1)
                        .addContainerGap(48, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JFrame frame1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField3;
    private JTextField textField6;
    private JButton button1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
