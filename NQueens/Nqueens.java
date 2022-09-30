
public class Nqueens {

  private int N;
  private Integer[][] board;
  private int solutions = 0;

  public Nqueens(int n) {
    N = n;
    board = new Integer[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        board[i][j] = 0;
    }
  }

  public void findSolutions() {

    solve(0);
    System.out.println(solutions + " solutions");
  }

  private boolean solve(int row) {

    if (row == N) {
      printBoard();
      return false;
    }

    for (int i = 0; i < N; i++) {
      if (isSafe(row, i)) {
        board[row][i] = 1;

        boolean safeToProceed = solve(row + 1);

        if (safeToProceed)
          return true;
        else
          board[row][i] = 0;
      }
    }
    return false;
  }

  private boolean isSafe(int a, int b) {

    for (int i = 0; i < a; i++) {
      if (board[i][b] == 1)
        return false;
    }

    int x = a, y = b;
    while (--x >= 0 && --y >= 0) {
      if (board[x][y] == 1)
        return false;
    }

    x = a;
    y = b;
    while (--x >= 0 && ++y < N) {
      if (board[x][y] == 1)
        return false;
    }

    return true;
  }

  private void printBoard() {
    solutions++;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1)
          System.out.print("Q ");
        else
          System.out.print("_ ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
