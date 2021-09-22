using System;
using System.Collections.Generic;

public class Smoothie {
    private static Dictionary<string, double> _ingredients = new Dictionary<string, double>();
    public static Dictionary<string, double> Ingredients {
        get {
            return _ingredients;
        }
    }
    private string[] _flavors;
    public string[] Flavors {
        get {
            return _flavors;
        }
        set {
            _flavors = value;
        }
    }

    static Smoothie() {
        _ingredients.Add("strawberries", 1.50);
        _ingredients.Add("banana", 0.50);
        _ingredients.Add("mango", 2.50);
        _ingredients.Add("blueberries", 1.00);
        _ingredients.Add("raspberries", 1.00);
        _ingredients.Add("apple", 1.75);
        _ingredients.Add("pineapple", 3.50); 
    }

    public Smoothie(string[] flavors) {
        ValidateFlavors(flavors);
        this.Flavors = flavors;
    }

    public double GetCost() {
        double cost = 0.00;
        foreach(string flavor in Flavors) {
            cost += Ingredients[flavor.ToLower()];
        }
        return Math.Round(cost, 2);
    }

    public double GetPrice() {
        double cost = GetCost();
        return Math.Round(1.5*cost + cost, 2);
    }

    public string GetName() {
        if (Flavors.Length == 1) {
            return Berryfy(Flavors[0]) + " Smoothie";
        } else {
            string[] sortedFlavs = Flavors;
            Array.Sort(sortedFlavs);
            string name = "";
            foreach(string flavor in sortedFlavs) {
                name += Berryfy(flavor) + " ";
            }
            return name + "Fusion";
        }
    }

    private void ValidateFlavors(string[] flavors) {
        foreach(string flavor in flavors) {
            if (!_ingredients.ContainsKey(flavor.ToLower())) {
                throw new ArgumentException(flavor + " is not a valid flavor");
            }
        }
    }

    private string Berryfy(string word) {
        if (word.Contains("berries")) {
            return word.Replace("berries", "berry");
        }
        return word;
    }
}

class CProblem {
    static void Main(string[] args) {
        Smoothie s1 = new Smoothie(new string[] {"Banana"});
        Console.WriteLine("Cost: " + s1.GetCost());
        Console.WriteLine("Price: " + s1.GetPrice());
        Console.WriteLine("Name: " + s1.GetName());

        Console.WriteLine();

        Smoothie s2 = new Smoothie(new string[] {"Raspberries", "Strawberries", "Blueberries"});
        Console.WriteLine("Cost: " + s2.GetCost());
        Console.WriteLine("Price: " + s2.GetPrice());
        Console.WriteLine("Name: " + s2.GetName());
    }
}