package model;

public class Group {
    private String title;
    private String direction;
    public Group(String title, String direction){
        this.title = title;
        this.direction = direction;
    }

    public  String getTitle(){
        return title;
    }

    public String getDirection(){ return direction; }

}