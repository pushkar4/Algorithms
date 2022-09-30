
public class Maze {

  int m, n;
  int[][] maze;

  int[] rowPat = {-1, 0, 1, 0};
  int[] colPat = {0, 1, 0, -1};

  public Maze(int[][] maze) {
    m = maze.length;
    n = maze[0].length;
    this.maze = maze;
  }

  public void findPath() {

    int[][] path = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++)
        path[i][j] = maze[i][j];
    }

    path[0][0] = 8;
    probe(0, 0, path);
  }

  private boolean probe(int x, int y, int[][] path) {

    if (x == m - 1 && y == n - 1) {
      path[x][y] = 8;
      printPath(path);
      return false;
    }

    for (int i = 0; i < 4; i++) {

      int xnew = x + rowPat[i];
      int ynew = y + colPat[i];

      if (isSafe(xnew, ynew, path)) {

        path[xnew][ynew] = 8;

        if (probe(xnew, ynew, path))
          return true;

        path[xnew][ynew] = 1;
      }
    }

    return false;
  }

  private boolean isSafe(int xnew, int ynew, int[][] path) {

    if (xnew < 0 || xnew >= m || ynew < 0 || ynew >= n)
      return false;

    if (maze[xnew][ynew] == 0)
      return false;

    if (path[xnew][ynew] == 8)
      return false;

    return true;
  }

  private void printPath(int[][] path) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        switch (path[i][j]) {
          case 8:
            System.out.print(path[i][j] + " ");
            break;
          case 1:
            System.out.print(". ");
            break;
          case 0:
            System.out.print("_ ");
            break;
        }

      }
      System.out.println();
    }
    System.out.println();
  }
}
