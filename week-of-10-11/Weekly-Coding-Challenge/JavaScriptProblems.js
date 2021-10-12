function ingExtractor(s) {
    s = s.split(/\W+/)
         .filter(a => {return a.toLowerCase().endsWith("ing") && a.length > 4})
         .filter(a => {return a.toLowerCase().slice(0, a.length - 3).match(/a|e|i|o|u|y/)});
    return s;
}

console.log("ingExtractor:");
console.log(ingExtractor("coming bringing Letting sing apple spying ying yoinking"));
console.log(ingExtractor("going Ping, king sHrink dOing testIng"));
console.log(ingExtractor("zing went ring, ding wing SINk"));

function vendingMachine(money, productNumber) {
    let products = [ { product: "Cakes", cost: 200},
                 { product: "Cookies", cost: 200},
                 { product: "Chocolate Bar", cost: 200},
                 { product: "Candied Peanuts", cost: 300},
                 { product: "Coconut Candy", cost: 200},
                 { product: "Chewing Gum", cost: 100},
                 { product: "Crackers", cost: 120 }];
    let denominations = [500, 200, 100, 50, 20, 10];

    let item = products[productNumber -1];
    let change = [];
    if (item) {
        if (item.cost <= money) {
            let remainder = money - item.cost;
            let denomIndex = 0;
            while (remainder > 0 && denomIndex < denominations.length) {
                if (remainder - denominations[denomIndex] < 0) {
                    denomIndex++;
                } else {
                    change.push(denominations[denomIndex]);
                    remainder = remainder - denominations[denomIndex];
                }
            }
        } else {
            return "Not enough money for this product"
        }
    } else {
        return "Enter a valid product number";
    }
    return { product: products[productNumber-1].product, change: change };
}

console.log("vendingMachine:");
console.log(vendingMachine(200, 7));
console.log(vendingMachine(500, 0));
console.log(vendingMachine(90, 1));