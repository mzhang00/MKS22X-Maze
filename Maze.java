import java.util.*;
import java.io.*;

public class Maze{
  private char[][] maze;
  private boolean animate;
  private int[] xmoves = {0, 1, 0, -1};
  private int[] ymoves = {-1, 0, 1, 0};

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
    }catch (InterruptedException e){
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
    int Sx = 0;
    int Sy = 0;
    for (int i = 0; i < maze.length; i++){
      for (int c = 0; c < maze[0].length; c++){
        if (maze[i][c] == 'S'){
          Sx = i;
          Sy = c;
          c = maze[0].length;
          i = maze.length;
        }
      }
    }
    maze[Sx][Sy] = '@';
    try{
      solve(Sx, Sy);
    }catch(IndexOutOfBoundsException e){
    }
    int result = -1;
    for (int r = 0; r < maze.length; r++){
      for (int c = 0; c < maze[0].length; c++){
        if (maze[r][c] == '@'){
          result++;
        }
      }
    }
    if (result < 0){
      result--;
      for (int r = 0; r < maze.length; r++){
        for (int c = 0; c < maze[0].length; c++){
          if (maze[r][c] != '#' && maze[r][c] != 'E'){
            maze[r][c] = ' ';
          }
        }
      }
      maze[Sx][Sy] = 'S';
    }
    return result + 1;
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
  
  private int solve(int row, int col){
    /*if(animate){
      clearTerminal();
      char save = maze[row][col];
      maze[row][col] = '\u2588';
      System.out.println(this);
      maze[row][col] = save;
      wait(100);
    }*/
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(100);
    }
    for (int i = 0; i <= 3; i++){
      if (maze[row + xmoves[i]][col + ymoves[i]] == 'E'){
        throw new IndexOutOfBoundsException();
      }
      if (goTo(row + xmoves[i], col + ymoves[i])){
        solve(row + xmoves[i], col + ymoves[i]);
      }
      if (i == 3){
        maze[row][col] = '.';
      }
    }
    return 0;
  }

  //row and col are the NEW row and NEW col  
  private boolean goTo(int row, int col){
    if (maze[row][col] == '#' || maze[row][col] == '@' || maze[row][col] == '.'){
      return false;
    }else{
      maze[row][col] = '@';
      return true;
    }
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