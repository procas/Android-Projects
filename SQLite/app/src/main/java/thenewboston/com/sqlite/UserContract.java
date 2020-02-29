package thenewboston.com.sqlite;

/**
 * Created by HP on 30-01-2017.
 */
public class UserContract {

    public static abstract class NewUserInfo
    {

        public static final String TABLE_NAME = "files";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "filename";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_CONTENT="filecontent";
        public static final boolean COLUMN_ENCRYTED = false;
        public static final String COLUMN_KEY = "key";
    }
}
