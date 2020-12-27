package model;

public class Graduate {
    private String last_name;
    private String first_name;
    private  int group_id;

    public Graduate(String last_name, String first_name, int group_id){
        this.last_name = last_name;
        this.first_name = first_name;
        this.group_id = group_id;
    }

    public  String getLastName(){
        return last_name;
    }

    public String getFirstName(){
        return first_name;
    }

    public int getGroup_id(){ return group_id; }
}
