import model.Driver;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {

    private String databaseUrl="jdbc:sqlite:UserDetails.db";
    private String TABLE_CREATOR="CREATE TABLE IF NOT EXISTS ";

    private String userTableNAME ="userDatabase";
    private String userTableCOLUMNS ="(UserName TEXT NOT NULL PRIMARY KEY,Password TEXT,Email TEXT,Phone TEXT,WalletBalance TEXT,Status TEXT)";
    private String userInsertParameters =" (UserName,Password,Email,Phone,WalletBalance,Status)";
    private String rideTableName = "rideDatabase";
    private String rideTableCOLUMNS = "(UserName TEXT NOT NULL PRIMARY KEY,Driver TEXT,PickUp TEXT,Drop_point TEXT)";
    private String rideInsertParameters = "(UserName,Driver,PickUp,Drop_point)";
    private String driverTableName = "driverDatabase";
    private String driverTableColumns = "(UserName TEXT NOT NULL PRIMARY KEY,Phone TEXT,Rating TEXT,Position TEXT,Status TEXT,NumberOfRatings INTEGER)";
    private String driverTableParameters = "(UserName,Phone,Rating,Position,Status,NumberOfRatings)";
    private Connection conn=null;
    private Statement statement=null;
    public void initialiseDatabase() {
        try {
            conn= DriverManager.getConnection(databaseUrl);
            statement=conn.createStatement();
            statement.execute(TABLE_CREATOR+userTableNAME+userTableCOLUMNS);
            statement.execute(TABLE_CREATOR+rideTableName+rideTableCOLUMNS);
            statement.execute(TABLE_CREATOR+driverTableName+driverTableColumns);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addUser (String userName,String password,String email,String phone,String walletBalance,String status) throws SQLException{
        statement.execute("INSERT INTO "+ userTableNAME + userInsertParameters +" VALUES('"+userName+"','"
                +password+"','"+email+"','"+phone+"','"+walletBalance+"','"+status+"')");
    }
    public void addRide(String userName,String driver,String pickup,String drop)
    {
        try {
            statement.execute("INSERT INTO "+rideTableName+rideInsertParameters+" VALUES('"+userName+"','"+driver+"','"+pickup+"','"+drop+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteRide(String username)
    {
        try {
            statement.execute("DELETE FROM "+rideTableName+" WHERE UserName = '"+username+ "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getRideDriver(String userName)
    {
        String driver_name = null;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Driver FROM " + rideTableName + " WHERE UserName = '" + userName + "'");
                driver_name = resultSet.getString("Driver");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver_name;
    }
    public ArrayList<Driver> getDrivers()
    {
        ArrayList<Driver> drivers = new ArrayList<>();
        try {
            if(!conn.isClosed())
            {

                ResultSet resultSet = statement.executeQuery("SELECT * FROM "+driverTableName);
                int i=1;
                while (resultSet.next())
                {
                    String driver_name = resultSet.getString("UserName");
                    String phone = resultSet.getString("Phone");
                    String rating = resultSet.getString("Rating");
                    String position = resultSet.getString("Position");
                    String status = resultSet.getString("Status");
                    int numRating = resultSet.getInt("NumberOfRatings");
                    Driver driver = new Driver(i,driver_name,phone,rating,position,status,numRating);
                    drivers.add(driver);
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
    public void setDriverStatus(String userName,String status)
    {
        try {
            statement.execute("UPDATE "+driverTableName+ " SET Status= '"+status+"' WHERE UserName='"+userName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setDriverPosition(String userName,String position)
    {
        try {
            statement.execute("UPDATE "+driverTableName+ " SET Position = '"+position+"' WHERE UserName='"+userName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getNoOfRatings(String userName)
    {
        int numRatings = 0;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT NumberOfRatings FROM " + driverTableName + " WHERE UserName = '" + userName + "'");
            numRatings = resultSet.getInt("NumberOfRatings");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  numRatings;
    }
    public String getDriverRating(String userName)
    {
        String rating = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT Rating FROM " + driverTableName + " WHERE UserName = '" + userName + "'");
            rating = resultSet.getString("Rating");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rating;
    }
    public void setNoOfRatings(String userName,int numRatings)
    {
        try {
            statement.execute("UPDATE "+driverTableName+ " SET NumberOfRatings= '"+numRatings+"' WHERE UserName='"+userName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setDriverRating(String userName,String rating)
    {
        try {
            statement.execute("UPDATE "+driverTableName+ " SET Rating= '"+rating+"' WHERE UserName='"+userName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getDrop(String userName)
    {
        String drop = null;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Drop_point FROM " + rideTableName + " WHERE UserName = '" + userName + "'");
                drop = resultSet.getString("Drop_point");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drop;
    }
    public String getPickup(String userName)
    {
        String pickup = null;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT PickUp FROM " + rideTableName + " WHERE UserName = '" + userName + "'");
                pickup = resultSet.getString("PickUp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pickup;
    }
    public String Verify(String username) {

        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Password FROM " + userTableNAME + " WHERE UserName = '" +username+ "'" );
                if(resultSet.next()) {
                    return resultSet.getString("Password");
                }else {
                    return "null";
                }

            } else {
                return "Connection is Closed";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Exception";
        }
    }
    public void setStatus(String userName,String status)
    {
        try {
            statement.execute("UPDATE "+userTableNAME+ " SET Status= '"+status+"' WHERE UserName='"+userName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setBalance(String userName,String walletBalance)
    {
        try {
            statement.execute("UPDATE "+userTableNAME+ " SET WalletBalance= '"+walletBalance+"' WHERE UserName='"+userName+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  User getUserDetails(String userName)
    {
        User user = null;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + userTableNAME + " WHERE UserName = '" +userName+ "'" );
                if(resultSet.next()) {
                    String password = resultSet.getString("Password");
                    String phnnumber = resultSet.getString("Phone");
                    String walletBalance = resultSet.getString("WalletBalance");
                    String email = resultSet.getString("Email");
                    String status = resultSet.getString("Status");
                  user = new User(userName,password,walletBalance,phnnumber,email,status);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return  user;
    }
    public String checkUser(String username){
        int x =0;
        try {
            if (!conn.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT UserName FROM userDataBase" );
                while (resultSet.next())
                {
                    String u = resultSet.getString("UserName");
                    if(u.equals(username))

                    {
                        //  JOptionPane.showMessageDialog(null,"UserName Already Exists");
                        x=1;
                    }
                }
                if (x==1)
                {
                    return "s";
                }
                else return "f";

            } else {
                return "f";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return "f";
    }
    public void closeDatabaseConnection() {
        try {
            if (!conn.isClosed()) {
                statement.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
