import java.util.Random;

public class Labyrinth {
  private static final int ROWS = 10;
  private static final int COLUMNS = 10;
  private static final char WALL = '#';
  private static final char PATH = ' ';
  
  private static char[][] maze = new char[ROWS][COLUMNS];
  private static Random rand = new Random();
  
  public static void main(String[] args) {
    // Initialisation du labyrinthe avec des murs
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        maze[i][j] = WALL;
      }
    }
    
    // Génération aléatoire du chemin
    int currentRow = rand.nextInt(ROWS);
    int currentColumn = rand.nextInt(COLUMNS);
    maze[currentRow][currentColumn] = PATH;
    
    while (notAllVisited()) {
      int direction = rand.nextInt(4);
      int newRow = currentRow;
      int newColumn = currentColumn;
      switch (direction) {
        case 0: // Haut
          newRow--;
          break;
        case 1: // Droite
          newColumn++;
          break;
        case 2: // Bas
          newRow++;
          break;
        case 3: // Gauche
          newColumn--;
          break;
      }
      if (isValidMove(newRow, newColumn)) {
        maze[newRow][newColumn] = PATH;
        currentRow = newRow;
        currentColumn = newColumn;
      }
    }
    
    // Affichage du labyrinthe généré
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        System.out.print(maze[i][j]);
      }
      System.out.println();
    }
  }
  
  private static boolean notAllVisited() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (maze[i][j] == WALL) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean isValidMove(int row, int column) {
    return row >= 0 && row < ROWS && column >= 0 && column < COLUMNS && maze[row][column] == WALL;
  }
}