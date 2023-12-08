package gb.boyko;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterr {
    public static void WriteInFile(String s)
    {
    try(FileWriter writer = new FileWriter("notes.txt", true)){
        writer.write(s);
        writer.flush();
    }
    catch(IOException ex){
        System.out.println(ex.getMessage());
    }
    
    }
}
