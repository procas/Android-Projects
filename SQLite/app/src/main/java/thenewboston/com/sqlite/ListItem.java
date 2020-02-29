package thenewboston.com.sqlite;

/**
 * Created by HP on 29-01-2017.
 */
public class ListItem {

    String _date;
    String _filename;
    String _filecontents;
    boolean _isLocked;
    int _id;

    public ListItem(String date, String filename, String filecontents)
    {
        _date=date;
        _filename = filename;
        _filecontents = filecontents;

    }

    public int get_id() {
        return _id;
    }

    public boolean get_locked(){return _isLocked; }


    public String get_date() {
        return _date;
    }


    public String get_filename() {
        return _filename;
    }


    public String get_filecontents() {
        return _filecontents;
    }

}
