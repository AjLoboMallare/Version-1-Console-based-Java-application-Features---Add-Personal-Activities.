import java.util.List;
import java.util.ArrayList;
public class ActivityManager {
    private List<Activity> activities = new ArrayList<>();

    //add activity
    public void addActivity(Activity activity){
        activities.add(activity);
    }

    //Display all activities
    public void displayAllActivities(){
        if (activities.isEmpty()) {
            System.out.println("No activities found.");
            return;
        }
        System.out.println("\n=====Activities======");
        for(Activity activity : activities){
            System.out.println("ID: " + activity.getId() + " | Title: " + activity.getTitle() + " | Status: " + activity.getStatus());
        }
    }

    //Removing activity
    public boolean removeActivity(int index){
        if(index >= 0 && index < activities.size()){
            activities.remove(index); //then removing the activity;
            return true;
        }
           return false;
    }

    //COUNT ACTIVITY
    public int getActivityCount(){
            return activities.size();
    }

// <====== main =========>
    public static void main(String[] args) {
        ActivityManager actManager = new ActivityManager();
        try {
            actManager.addActivity(new Activity("-5", "run 2km", false));
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        actManager.displayAllActivities();



        // REMOVING LIST
        int indexRemove = 5;
        boolean status = actManager.removeActivity(indexRemove);
        if(status){
            System.out.println("Activity removed successfuly.");
        }else{
            System.out.println("Remove failed. Index out of bounds.");
        }



        if(actManager.getActivityCount() == 0){
            System.out.println("No activities found yet.");
        }else{
            System.out.println("Total activities: " + actManager.getActivityCount());
        }
    }
    }

