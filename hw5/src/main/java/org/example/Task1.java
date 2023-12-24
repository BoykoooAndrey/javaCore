package org.example;


import java.io.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Task1
{
    public static void main(String[] args)
    {
        File folder = new File("./src/main/java/org/example");
        String backUpFolderPath = "./backup/";
        ArrayList<String[]> allFileData = readFiles(folder);
        writeFiles(allFileData, backUpFolderPath);
    }

    private static ArrayList<String[]> readFiles(File folder)
    {
        ArrayList<String[]> allFileData = new ArrayList<String[]>();
        for(File file : folder.listFiles())
        {
            if(file.isFile())
            {
                try(BufferedReader bufferReader = new BufferedReader(new FileReader(file.getPath())))
                {
                    ArrayList<String> lines = new ArrayList<String>();
                    String line;
                    lines.add(file.getName());
                    while((line = bufferReader.readLine()) != null)
                    {
                        lines.add(line);
                    }
                    String[] fileData = lines.toArray(new String[]{});
                    allFileData.add(fileData);
                }
                catch (FileNotFoundException e)
                {
                    throw new RuntimeException(e);
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        return allFileData;

    }

    private static void writeFiles(ArrayList<String[]> allFileData, String backUpFolderPath )
    {
        createFolder(backUpFolderPath);
        for(String[] dataArr : allFileData)
        {
                try
                {
                    System.out.println(backUpFolderPath  + dataArr[0]);
                    FileWriter fileWriter = new FileWriter(new File(backUpFolderPath  + dataArr[0]));
                    for (int i = 1; i < dataArr.length; i++)
                    {
                        fileWriter.write(dataArr[i] + '\n');
                        fileWriter.flush();
                    }
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
        }
    }

    private  static File createFolder(String backUpFolderPath)
    {
        File backUpFolder = new File(backUpFolderPath);
        if (!backUpFolder.exists())
        {
            backUpFolder.mkdir();
        }
        return  backUpFolder;
    }




}