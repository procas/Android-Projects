package wixsiteprocas.mailtoproma.com.letschat;

/**
 * Created by HP on 9/19/2017.
 */
public class ListItem
{
    private String user_name;


    public ListItem(String name)
    {
        this.user_name  = name;
    }
    public String getUser_name()
    {
        return user_name;
    }
    public void setUser_name(String name)
    {
        user_name = name;
    }


}
