using System;
using System.Collections.Generic;

// Create a function that takes a positive integer and returns 
// a string expressing how the number can be made by multiplying 
// powers of its prime factors. 

class CProblem {
    static void Main(string[] args) {
        CProblem c = new CProblem();
        c.PrintFactors(2);
        c.PrintFactors(4);
        c.PrintFactors(10);
        c.PrintFactors(60);
        c.PrintFactors(110);
        c.PrintFactors(13);
    }

    public Dictionary<int, int> ExpressFactors(int n) {
        // Key: factor, Value: number of instances
        Dictionary<int, int> factors = new Dictionary<int, int>();
        int curr = n;
        while (curr != 1) {
            if (curr % 2 == 0) {
                if (!factors.TryAdd(2, 1)) {
                    factors[2] = factors[2] + 1;
                }
                curr = curr / 2;
                continue;
            }
            for (int i = 3; i <= curr; i += 2) {
                if (curr % i == 0) {
                    if (!factors.TryAdd(i, 1)) {
                        factors[i] = factors[i] + 1;
                    }
                    curr = curr / i;
                    break;
                }
            }
        }
        return factors;
    }

    public void PrintFactors(int num) {
        Dictionary<int, int> factors = ExpressFactors(num);
        string output = "";
        foreach (KeyValuePair<int, int> kv in factors) {
            if (kv.Value > 1) {
                output += kv.Key + "^" + kv.Value;
            } else {
                output += kv.Key;
            }
            output += " x ";
        }
        output = output.Remove(output.Length - 3);
        Console.WriteLine("Factors of " + num + ": " +output);
    }
}