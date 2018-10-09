package exerciseapp;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler {

    Connection con;
    Statement stmt;

    public boolean createDB() {
        try {
            System.out.println("Creating Database...");
            DatabaseBuilder.create(Database.FileFormat.V2003, DataHandler.DATABASE_FILE);
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://" + DataHandler.DATABASE_FILE.getAbsolutePath());
            c.setAutoCommit(false);
            Statement s = c.createStatement();
            System.out.println("Creating Tables...");
            s.executeUpdate("CREATE TABLE Exercise ("
                    + "ID AUTOINCREMENT PRIMARY KEY, "
                    + "Description VARCHAR(50), "
                    + "Sets VARCHAR(10), "
                    + "RepsPerSetDistance VARCHAR(10), "
                    + "DayNumber VARCHAR(10), "
                    + "DayOfWeek VARCHAR(10), "
                    + "EDate VARCHAR(10));");
            s.executeUpdate("CREATE TABLE Food ("
                    + "ID AUTOINCREMENT PRIMARY KEY, "
                    + "Description VARCHAR(50), "
                    + "Portions VARCHAR(10), "
                    + "Calories VARCHAR(10), "
                    + "DayNumber VARCHAR(10), "
                    + "DayOfWeek VARCHAR(10), "
                    + "EDate VARCHAR(10));");
            s.executeUpdate("CREATE TABLE Weight ("
                    + "ID AUTOINCREMENT PRIMARY KEY, "
                    + "DayNumber VARCHAR(10), "
                    + "DayOfWeek VARCHAR(10),"
                    + "EDate VARCHAR(10), "
                    + "Weight VARCHAR(10));");
            s.executeUpdate("CREATE TABLE Water ("
                    + "ID AUTOINCREMENT PRIMARY KEY, "
                    + "Intake VARCHAR(10), "
                    + "DayNumber VARCHAR(10), "
                    + "DayOfWeek VARCHAR(10), "
                    + "EDate VARCHAR(10));");
            c.commit();
            System.out.println("Successfully created tables.");

            System.out.println("Successfully created database.");
            return true;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }

    public boolean connectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + DataHandler.DATABASE_FILE.getAbsolutePath());
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database connect> " + ex);
            return false;
        }
    }

    public String getProfileData() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(DataHandler.PROFILE_FILE));
            String data = bf.readLine();
            if (data == null) {
                return "noprofile";
            } else {
                String SQL = "SELECT Weight FROM Weight";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(SQL);
                if(rs.next()){
                    rs.last();                   
                    return data + "#" + rs.getString("Weight");
                }else{
                    return data;
                }
            }
        } catch (FileNotFoundException ex) {
            return "noprofile";
        } catch (IOException | SQLException ex) {
            return "noprofile";
        }
    }

    public boolean setProfileData(String profileData) {
        try {
            FileWriter wr = new FileWriter(DataHandler.PROFILE_FILE);
            wr.write(profileData);
            wr.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean addWater(String intake, String dayNumber, String dayOfWeek, String eDate) {
        try {
            String SQL = "SELECT * FROM Water WHERE dayNumber = '" + dayNumber + "';";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                int daysintake = Integer.parseInt(rs.getString("Intake"));
                daysintake = daysintake + Integer.parseInt(intake);
                SQL = "UPDATE Water SET Intake = '" + daysintake + "' WHERE dayNumber = '" + dayNumber + "';";
                stmt = con.createStatement();
                stmt.execute(SQL);
                return true;
            } else {
                SQL = "INSERT INTO Water VALUES (null, '" + intake + "','" + dayNumber + "','" + dayOfWeek + "','" + eDate + "');";
                stmt = con.createStatement();
                stmt.execute(SQL);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String[] getDates() {
        String[] dates = new String[3];
        try {
            Calendar date = Calendar.getInstance();
            String SToday = date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

            BufferedReader bf = new BufferedReader(new FileReader(DataHandler.PROFILE_FILE));
            Date SDate = df.parse(bf.readLine().split("#")[6]);
            Date Today = df.parse(SToday);
            dates[0] = SToday;

            switch (date.get(Calendar.DAY_OF_WEEK)) {
                case 2:
                    dates[1] = "Monday";
                    break;
                case 3:
                    dates[1] = "Tuesday";
                    break;
                case 4:
                    dates[1] = "Wednesday";
                    break;
                case 5:
                    dates[1] = "Thursday";
                    break;
                case 6:
                    dates[1] = "Friday";
                    break;
                case 7:
                    dates[1] = "Saturday";
                    break;
                case 1:
                    dates[1] = "Sunday";
                    break;
            }
            long diff = Today.getTime() - SDate.getTime();
            dates[2] = Integer.toString((int) (diff / (60000))+1);
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return dates;
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    }

    public String getMinWater() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(DataHandler.PROFILE_FILE));
            return bf.readLine().split("#")[5];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }

    public String getCurWater(String dayNumber) {
        try {
            String SQL = "SELECT Intake FROM Water WHERE DayNumber = '" + dayNumber + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                return rs.getString("Intake");
            } else {
                return "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }

    public String getMaxCalories() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(DataHandler.PROFILE_FILE));
            return bf.readLine().split("#")[6];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }

    public String getCurCal(String dayNumber) {
        try {
            String SQL = "SELECT Calories FROM Food WHERE DayNumber = '" + dayNumber + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            int total = 0;
            if (rs.next()) {
                total = total + Integer.parseInt(rs.getString("Calories"));
                while (rs.next()) {
                    total = total + Integer.parseInt(rs.getString("Calories"));
                }
                return Integer.toString(total);
            } else {
                return "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public boolean addExercise(String Desc, String Sets, String Reps, String DayNumber, String DayOfWeek, String EDate) {
        try {
            String SQL = "INSERT INTO Exercise VALUES (null,'" + Desc + "','" + Sets + "','" + Reps + "','" + DayNumber + "','" + DayOfWeek + "','" + EDate + "');";
            stmt = con.createStatement();
            stmt.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addFood(String Desc, String Portions, String Calories, String DayNumber, String DayOfWeek, String EDate) {
        try {
            String SQL = "INSERT INTO Food VALUES (null,'" + Desc + "','" + Portions + "','" + Calories + "','" + DayNumber + "','" + DayOfWeek + "','" + EDate + "');";
            stmt = con.createStatement();
            stmt.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getTotalWater() {
        try {
            String SQL = "SELECT Intake FROM Water;";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            int total = 0;
            if (rs.next()) {
                total = total + Integer.parseInt(rs.getString("Intake"));
                while (rs.next()) {
                    total = total + Integer.parseInt(rs.getString("Intake"));
                }
                return total;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getTotalCal() {
        try {
            String SQL = "SELECT Portions, Calories FROM Food;";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            int total = 0;
            if (rs.next()) {
                total = total + (Integer.parseInt(rs.getString("Calories")) * Integer.parseInt(rs.getString("Portions")));
                while (rs.next()) {
                    total = total + (Integer.parseInt(rs.getString("Calories")) * Integer.parseInt(rs.getString("Portions")));
                }
                return total;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getAwayFromGoal() {
        try {
            String SQL = "SELECT Weight FROM Weight";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                rs.last();
                int cur = Integer.parseInt(rs.getString("Weight"));
                BufferedReader bf = new BufferedReader(new FileReader(DataHandler.PROFILE_FILE));
                String x = bf.readLine();
                return cur - Integer.parseInt(x.split("#")[3]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getWeightLost() {
        try {
            String SQL = "SELECT Weight FROM Weight";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                rs.last();
                int cur = Integer.parseInt(rs.getString("Weight"));
                BufferedReader bf = new BufferedReader(new FileReader(DataHandler.PROFILE_FILE));
                int start = Integer.parseInt(bf.readLine().split("#")[7]);
                return start - cur;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean addNewWeight(String weight, String dayNumber, String dayOfWeek, String eDate) {
        try {
            String SQL = "INSERT INTO Weight VALUES (null,'" + dayNumber + "','" + dayOfWeek + "','" + eDate + "','" + weight + "');";
            stmt = con.createStatement();
            stmt.execute(SQL);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet getDaysFoodTableInfo(String dayNumber){
        try {
            String SQL = "SELECT * FROM Food WHERE DayNumber = '" + dayNumber + "'";
            stmt = con.createStatement();
            return stmt.executeQuery(SQL);           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getDaysExerciseTableInfo(String dayNumber){
        try {
            String SQL = "SELECT * FROM Exercise WHERE DayNumber = '" + dayNumber + "'";
            stmt = con.createStatement();
            return stmt.executeQuery(SQL);           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getTotalFoodTableInfo(){
        try {
            String SQL = "SELECT * FROM Food;";
            stmt = con.createStatement();
            return stmt.executeQuery(SQL);           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getTotalExerciseTableInfo(){
        try {
            String SQL = "SELECT * FROM Exercise;";
            stmt = con.createStatement();
            return stmt.executeQuery(SQL);           
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
