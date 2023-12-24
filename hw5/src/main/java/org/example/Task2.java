package org.example;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Random;

public class Task2
{
    public static void main(String[] args)
    {
        final String DIRPATH = "./tic_tac_toe_data";
        final String FILENAME = "/data.txt";
        createFolder(DIRPATH);
        int fileSize = (int) new File(DIRPATH + FILENAME).length();

        int[][] gameField = new int[3][3];

        wrirteData(DIRPATH + FILENAME, gameField);
        readData(DIRPATH + FILENAME, fileSize);



    }

    private static void wrirteData(String filePath, int[][] gameField)
    {
        Random r = new Random();
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField[i].length; j++) {
                    gameField[i][j] = r.nextInt(0, 4);
                    System.out.print( gameField[i][j] + " ");
                    fileWriter.write( gameField[i][j]);

                }
                System.out.println();
                fileWriter.write('\n');
                fileWriter.flush();
            }
            System.out.println("-----");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private  static void readData(String filePath, int size)
    {
        try (FileReader fileReader = new FileReader(filePath)){
            CharBuffer charBuffer;
            char[] buffer = new char[size];

            fileReader.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                if ((int) buffer[i] == 10)
                {
                    System.out.print(buffer[i]);
                }
                else
                {
                    //•(empty) - for 0, X - for 1, O - for 2, R(reserved) - for 3;
                    if ((int) buffer[i] == 0)
                    {
                        System.out.print("• ");
                    }
                    else if ((int) buffer[i] == 1)
                    {
                        System.out.print("X ");
                    }
                    else if ((int) buffer[i] == 2)
                    {
                        System.out.print("O ");
                    }
                    else if ((int) buffer[i] == 3)
                    {
                        System.out.print("R ");
                    }
                    else
                    {
                        System.out.print((int) buffer[i] + " ");
                    }
                }
            }
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


    private  static File createFolder(String folderPath)
    {
        File backUpFolder = new File(folderPath);
        if (!backUpFolder.exists())
        {
            backUpFolder.mkdir();
        }
        return  backUpFolder;
    }

}



