package StepsDefinitions;

public class UserBody {

    private String Name;
    private String Job;

    public UserBody(String name, String job){
        this.Name=name;
        this.Job=job;
    }

    public String getName(){
        return Name;
    }
    public void setName(String name){
        this.Name=name;
    }
    public String getJob(){
        return Job;
    }
    public void setJob(String job){
        this.Job=job;
    }
    @Override
    public String toString(){
        return  "UserBody [name="+this.Name+" , job= "+this.Job+"]";
    }


}
