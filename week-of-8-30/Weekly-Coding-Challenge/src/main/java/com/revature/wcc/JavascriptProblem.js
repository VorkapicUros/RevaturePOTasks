// Don't forget to npm install the node_modules

javascriptProblem([1679583, 123456, 6, 77, 4]);

function javascriptProblem(values) {
    for (let n of values) {
        console.log("Additive Persistence of " + n + ": " + additivePersistence(n));
    }
    for (let n of values) {
        console.log("Multiplicative Persistence of " + n + ": " + multiplicativePersistence(n));
    }
}

function additivePersistence(n) {
    let count = 0;
    while (n.toString().length > 1) {
        n = n.toString().split("").reduce((a,b) => parseInt(a) + parseInt(b));
        count++;
    }
    return count;
}

function multiplicativePersistence(n) {
    let count = 0;
    while (n.toString().length > 1) {
        n = n.toString().split("").reduce((a,b) => parseInt(a) * parseInt(b));
        count++;
    }
    return count;
}