
public class TestRatinMaze {

  public static void main(String[] args) {

    int maze[][] =
            {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                    {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                    {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                    {1, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                    {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

    Maze m = new Maze(maze);
    m.findPath();

    System.out.println("=======================\n");

    int maze2[][] =
            {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}};
    Maze m2 = new Maze(maze2);
    m2.findPath();

  }
}
