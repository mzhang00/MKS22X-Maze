import java.io.FileNotFoundException;

public class Driver{
    public static void main(String[]args){
      String filename = "data2.dat";
      //String filename = "Maze1.txt";
      try{
        Maze f;
        f = new Maze(filename);
        /*
        f.setAnimate(true);
        f.solve();
        */
        
        f.setAnimate(true);
        System.out.println(f.solve());
        
        System.out.println("-------------------------------");
        System.out.println(f);
                
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }
    }
}
