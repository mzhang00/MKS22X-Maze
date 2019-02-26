import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]){
    try{
      File text = new File("Maze1.txt");
      Scanner inf = new Scanner(text);
      int rows = 0;
      int cols = 0;
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        cols = line.length();
        rows++;
      }
      String[][] maze = new String[rows][cols];
    }catch(FileNotFoundException e){
      System.out.println("File does not exist. Try again with a valid file.");
    }
  }
}
