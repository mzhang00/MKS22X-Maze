import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadFile {
  public static void main(String args[]){
    try{
      File text = new File("Maze1.txt");
      Scanner inf = new Scanner(text);
      int rows = 0;
      int cols = 0;
      ArrayList<String> columns = new ArrayList<>();
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        cols = line.length();
        rows++;
      }
      String[][] maze = new String[rows][cols];
      for (int r = 0; r < rows; r++){
        for (int c = 0; c < cols; c++){
          //maze[r][c] =
          System.out.println(maze[r][c]);
        }
      }
    }catch(FileNotFoundException e){
      System.out.println("File does not exist. Try again with a valid file.");
    }
  }
}
