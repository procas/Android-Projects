import java.io.*
public class File {

    public static save(String value) throws IOException
    {
        byte b[]=value.getBytes();
        FileOutputStream fOut= new FileOutputStream("ABC.txt");
        fOut.write();fOut.close();
    }
    public static open()
    {
        FileInputStream fIn= new FileInputStream("ABC.txt");
        int i=0;
        while(i=fIn.read()!=-1)
            large.setText((char)i);

    }
}
