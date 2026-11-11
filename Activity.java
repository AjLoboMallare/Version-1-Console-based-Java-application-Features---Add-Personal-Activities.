

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
    public void setId(String id){
        this.id = idValidate(id);
    }

    public void setTitle(String title){
        this.title = titleValidate(title);
    }

    public void setCompleted(boolean completed){
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
            throw new IllegalArgumentException(" ID cannot be empty");
        }
        if(!id.matches("[0-9]+")){
            throw new IllegalArgumentException(" ID must be a number, not '" + id + "'");
        }
        if(id.length() > 6){
            throw new IllegalArgumentException("ID must not exceed 6 digits. [" + id + "]");
        }
        if (Integer.parseInt(id) <= 0) {
            throw new IllegalArgumentException(" ID must be greater than zero");
        }
        return id;
    }

    //titleValidate
private static String titleValidate(String title) throws IllegalArgumentException {
    if(title == null || title.isBlank()){
         throw new IllegalArgumentException("Title cannot be empty.");
    }
    if(!title.matches(".*\\p{L}.*")){
        throw new IllegalArgumentException("Title must contain at least one letter, not '" + title + "'");
    }
    return title;
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
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Status: " + getStatus());
        System.out.println();
    }

    //<=========MAIN==============>
    public static void main(String[] args) {

        Activity[] act = new Activity[2];
        try {
            act[0] = new Activity("002", "", true);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        try {
            act[1] = new Activity("9999", "Run 2km", false);
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=====Acitivities======");
        for(int i = 0; i < act.length; i++) { // checking for the Id length note: real app needs auto generate id's
            if (act[i] == null) {
                System.out.println("Notice: something wrong by your input. activity[" + i + "] skipped");
                continue;
            }else {
                act[i].displayActivity();
            }
        }
    }
}


