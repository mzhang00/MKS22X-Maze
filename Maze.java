import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException{
      animate = false;
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      int rows = 0;
      int cols = 0;
      ArrayList<String> columns = new ArrayList<>();
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        cols = line.length();
        columns.add(line);
        rows++;
      }
      maze = new char[rows][cols];
      for (int r = 0; r < rows; r++){
        for (int c = 0; c < cols; c++){
          maze[r][c] = columns.get(r).charAt(c);
        }
      }
      int Scount = 0;
      int Ecount = 0;
      for (int a = 0; a < maze.length; a++){
        for (int b = 0; b < maze[0].length; b++){
          if (maze[a][b] == 'S'){
            Scount++;
          }
          if (maze[a][b] == 'E'){
            Ecount++;
          }
        }
      }
      if (Scount != 1 || Ecount != 1){
        throw new IllegalStateException();
      }
    }

    private void wait(int millis){
      try {
        Thread.sleep(millis);
      }
      catch (InterruptedException e) {
      }
     }


    public void setAnimate(boolean b){
      animate = b;
    }


    public void clearTerminal(){
      System.out.println("\033[2J\033[1;1H");
    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S.


            //erase the S


            //and start solving at the location of the s.

            return solve(0,0);

    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }

    public String toString(){
      String finalstr = "";
      for (int i = 0; i < maze.length; i++){
        for (int c = 0; c < maze[i].length; c++){
          finalstr = finalstr + maze[i][c];
            if (c != maze[i].length - 1){
              finalstr += " ";
            }
          }
          if (i != maze.length - 1){
            finalstr += "\n";
          }
      }
      return finalstr;
    }
}
