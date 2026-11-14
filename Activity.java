import java.util.ArrayList;

public class Activity{
    private String id;
    private String title;
    private boolean completed;

    public Activity(String id, String title, boolean completed){
        setId(id);
        setTitle(title);
        setCompleted(completed);
        }

    //Setters
    private void setId(String id){
        this.id = idValidate(id);
    }

    private void setTitle(String title){
        this.title = titleValidate(title);
    }

    private void setCompleted(boolean completed){
            this.completed = completed;
    }

    //Getters
    public String getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public boolean isCompleted(){
        return this.completed;
    }
    public String getStatus(){
        return isCompleted()? "Completed" : "Incomplete";
    }
    //idValidate
    private static String idValidate(String id) throws IllegalArgumentException{
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be empty");
        }
        if(!id.matches("[0-9]+")){
            throw new IllegalArgumentException("ID must be a number, not '" + id + "'");
        }
        if(id.length() > 6){
            throw new IllegalArgumentException("ID must not exceed 6 digits. [" + id + "]");
        }
        if (Integer.parseInt(id) <= 0) {
            throw new IllegalArgumentException("ID must be greater than zero");
        }
        return id;
    }

    //titleValidate
private static String titleValidate(String title) throws IllegalArgumentException {
    if(title == null || title.trim().isBlank()){
         throw new IllegalArgumentException("Title cannot be empty.");
    }
    if(!title.matches(".*\\p{L}.*")){
        throw new IllegalArgumentException("Title must contain at least one letter, not '" + title + "'");
    }
    return title.trim();
}

    //mark as completed
    public void markAsCompleted() {
        setCompleted(true);
    }
    public void markAsIncomplete() {
        setCompleted(false);
    }

    //display activity
    public void displayActivity(){
        System.out.println("ID: " + getId() + " | " + "Title: " + getTitle() + " | " + "Status: " + getStatus());
    }

    //<=========MAIN==============>
    public static void main(String[] args) {
        //ArrayList
        ArrayList<Activity> activities = new ArrayList<>();

        try {
            activities.add(new Activity(" ", "Push up", false));
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        try {
            activities.add(new Activity("9999", "Run 2km", false));
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        try {
            activities.add(new Activity("1001", "Pull up", true));
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=====Activities======");
        for(Activity activity : activities){
                activity.displayActivity();
        }

        //Retrieve the second activity using get()
        System.out.println("\n<----Retrieve the second activity ---->");
        activities.get(1).displayActivity();

        //Mark the first activity as Completed
        activities.get(0).markAsCompleted();

        //remove the third activity
        //activity.remove(2);

        //display the final collections and displaying the collection size.
        System.out.println("\n" + activities.size() + " Final activities left");
        for(int i = 0; i<activities.size(); i++){
            activities.get(i).displayActivity();
        }

    }
}


