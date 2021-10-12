using System;
using System.Collections.Generic;

public class CProblem {
    static void Main(string[] args) {
        CProblem cp = new CProblem();
        Console.WriteLine("UniqueFract(9) --> " + cp.UniqueFract(9));
        Console.WriteLine("UniqueFract(10) --> " + cp.UniqueFract(10));
    }

    public double UniqueFract(int denominator) {
        HashSet<double> hs = new HashSet<double>();
        double sum = 0;

        for (int i = 2; i <= denominator; i++) {
            for (int j = 1; j < i; j++) {
                if (hs.Add((double) Math.Round((double) j/i, 5))) {
                    sum += Math.Round((double) j/i, 5);
                }
            }
        }
        return (double) Math.Round(sum, 4);
    }
}