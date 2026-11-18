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
            throw new IllegalArgumentException(" ID must be a positive/number, not '" + id + "'");
        }
        if(id.length() > 8 ){
            throw new IllegalArgumentException("ID must not exceed 8 digits. [" + id + "]");
        }
        if (id.matches("0+")) {
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



}


