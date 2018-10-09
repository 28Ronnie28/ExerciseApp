package exerciseapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler {

    DatabaseHandler dbh;
    static final File LOCAL_CACHE_FOLDER = new File(System.getProperty("user.home") + "/Documents/ExerciseApp");
    static final File LOCAL_CACHE_BODY_PICTURES_FOLDER = new File(System.getProperty("user.home") + "/Documents/ExerciseApp/BodyPictures");
    static final File LOCAL_CACHE_EXERCISE_PICTURES_FOLDER = new File(System.getProperty("user.home") + "/Documents/ExerciseApp/ExercisePictures");
    static final File DATABASE_FILE = new File(System.getProperty("user.home") + "/Documents/ExerciseApp/ExerciseAppDB.accdb");
    static final File PROFILE_FILE = new File(System.getProperty("user.home") + "/Documents/ExerciseApp/Profile.txt");
    ExerciseAppFrame home;
    ProfileFrame profile;
    PicturesFrame pictures;
    BodyPicturesFrame bodyPictures;
    ExercisePicturesFrame exercisePictures;
    DaysPerformance today;
    TotalPerformanceFrame overall;
    AddFoodFrame addFood;
    AddExerciseFrame addExercise;
    AddPictureFrame addPic;

    public DataHandler() {
        checkFiles();
    }

    public boolean checkFiles() {
        dbh = new DatabaseHandler();
        if (!LOCAL_CACHE_FOLDER.exists()) {
            LOCAL_CACHE_FOLDER.mkdirs();
            System.out.println("Created New Local Cache Folder");
        }
        if (!LOCAL_CACHE_BODY_PICTURES_FOLDER.exists()) {
            LOCAL_CACHE_BODY_PICTURES_FOLDER.mkdirs();
            System.out.println("Created New Local Cache Body Pictures Folder");
        }
        if (!LOCAL_CACHE_EXERCISE_PICTURES_FOLDER.exists()) {
            LOCAL_CACHE_EXERCISE_PICTURES_FOLDER.mkdirs();
            System.out.println("Created New Local Cache Exercise Pictures Folder");
        }
        if (!DATABASE_FILE.exists()) {
            dbh.createDB();
            System.out.println("Created New Database");

        }

        dbh.connectDB();
        System.out.println("Connected to Database");

        home = new ExerciseAppFrame(this);
        profile = new ProfileFrame(this);
        pictures = new PicturesFrame(this);
        bodyPictures = new BodyPicturesFrame(this);
        exercisePictures = new ExercisePicturesFrame(this);
        today = new DaysPerformance(this);
        overall = new TotalPerformanceFrame(this);
        addFood = new AddFoodFrame(this);
        addExercise = new AddExerciseFrame(this);
        addPic = new AddPictureFrame(this);

        home.setVisible(true);
        return true;
    }

    public boolean setProfileData(String profileData) {
        return dbh.setProfileData(profileData);
    }

    public String getProfileData() {
        return dbh.getProfileData();
    }

    public List<String> getBodyPicturesForDay(String day) {
        File folder = new File(LOCAL_CACHE_FOLDER + "/BodyPictures/" + day);
        List<String> files = new ArrayList();
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                files.add(fileEntry.getAbsolutePath().replace("\\", "/"));
            }
        }
        return files;
    }

    public List<String> getBodyPicturesDays() {
        File folder = new File(LOCAL_CACHE_FOLDER + "/BodyPictures");
        List<String> files = new ArrayList();
        for (String fileEntry : folder.list()) {
            files.add(fileEntry);
        }
        return files;
    }

    public List<String> getExercisePicturesForDay(String day) {
        File folder = new File(LOCAL_CACHE_FOLDER + "/ExercisePictures/" + day);
        List<String> files = new ArrayList();
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                files.add(fileEntry.getAbsolutePath().replace("\\", "/"));
            }
        }
        return files;
    }

    public List<String> getExercisePicturesDays() {
        File folder = new File(LOCAL_CACHE_FOLDER + "/ExercisePictures");
        List<String> files = new ArrayList();
        for (String fileEntry : folder.list()) {
            files.add(fileEntry);

        }
        return files;
    }

    public boolean addWater(String intake, String dayNumber, String dayOfWeek, String eDate) {
        return dbh.addWater(intake, dayNumber, dayOfWeek, eDate);
    }

    public String[] getDates() {
        return dbh.getDates();
    }

    public String getMinWater() {
        return dbh.getMinWater();
    }

    public String getCurWater(String dayNumber) {
        return dbh.getCurWater(dayNumber);
    }

    public String getMaxCalories() {
        return dbh.getMaxCalories();
    }

    public String getCurCal(String dayNumber) {
        return dbh.getCurCal(dayNumber);
    }

    public boolean addExercise(String Desc, String Sets, String Reps, String DayNumber, String DayOfWeek, String EDate) {
        return dbh.addExercise(Desc, Sets, Reps, DayNumber, DayOfWeek, EDate);
    }

    public boolean addFood(String Desc, String Portions, String Calories, String DayNumber, String DayOfWeek, String EDate) {
        return dbh.addFood(Desc, Portions, Calories, DayNumber, DayOfWeek, EDate);
    }

    public int getTotalWater() {
        return dbh.getTotalWater();
    }

    public int getTotalCal() {
        return dbh.getTotalCal();
    }

    public int getAwayFromGoal() {
        return dbh.getAwayFromGoal();
    }

    public int getWeightLost() {
        return dbh.getWeightLost();
    }

    public boolean addNewWeight(String weight, String dayNumber, String dayOfWeek, String eDate) {
        return dbh.addNewWeight(weight, dayNumber, dayOfWeek, eDate);
    }

    public boolean addPicture(String file, String day, String to) {
        if (to.matches("Body Pictures")) {
            try {
                File dir = new File(LOCAL_CACHE_BODY_PICTURES_FOLDER.getAbsolutePath() + "/" + day);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File cFile = new File(file);
                dir = new File(LOCAL_CACHE_BODY_PICTURES_FOLDER.getAbsolutePath() + "/" + day + "/" + file.substring(file.lastIndexOf("\\")));
                Files.copy(cFile.toPath(), dir.toPath());
                return true;
            } catch (IOException ex) {
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                File dir = new File(LOCAL_CACHE_EXERCISE_PICTURES_FOLDER.getAbsolutePath() + "/" + day);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File cFile = new File(file);
                dir = new File(LOCAL_CACHE_BODY_PICTURES_FOLDER.getAbsolutePath() + "/" + day + "/" + file.substring(file.lastIndexOf("\\")));
                Files.copy(cFile.toPath(), dir.toPath());
                return true;
            } catch (IOException ex) {
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean clearSaves() {
        dbh.createDB();
        deleteFilesinFolder(LOCAL_CACHE_BODY_PICTURES_FOLDER);
        LOCAL_CACHE_BODY_PICTURES_FOLDER.delete();
        deleteFilesinFolder(LOCAL_CACHE_EXERCISE_PICTURES_FOLDER);
        LOCAL_CACHE_EXERCISE_PICTURES_FOLDER.delete();
        return true;
    }

    private void deleteFilesinFolder(File directory) {
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                deleteFilesinFolder(file);
                file.delete();
            }
        }
    }
    
    public ResultSet getDaysFoodTableInfo(String dayNumber){
        return dbh.getDaysFoodTableInfo(dayNumber);
    }

    public ResultSet getDaysExerciseTableInfo(String dayNumber){
        return dbh.getDaysExerciseTableInfo(dayNumber);
    }
    
    public ResultSet getTotalFoodTableInfo(){
        return dbh.getTotalFoodTableInfo();
    }
    
    public ResultSet getTotalExerciseTableInfo(){
        return dbh.getTotalExerciseTableInfo();
    }
}
