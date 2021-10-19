using System;
using System.Text;

public class CProblem {
    public static void Main(string[] args) {
        CProblem cp = new CProblem();
        cp.DisplayGrid(cp.PrintGrid(3, 6));
        cp.DisplayGrid(cp.PrintGrid(5, 3));
        cp.DisplayGrid(cp.PrintGrid(4, 1));
    }

    public int[,] PrintGrid(int x, int y) {
        int[,] grid = new int[x,y];
        int counter = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                grid[j,i] = counter++;
            }
        }
        return grid;
    }

    public void DisplayGrid(int[,] grid) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < grid.GetLength(0); x++) {
            sb.Append("[");
            for (int y = 0; y < grid.GetLength(1); y++) {
                sb.Append(grid[x,y]).Append(", ");
            }
            sb.Remove(sb.Length - 2, 2);
            sb.Append("]\n");
        }
        sb.Remove(sb.Length - 1, 1);
        Console.WriteLine(sb.ToString());
    }
}