// Problem 1: Track a Robots movements through a grid based on arguments in order 
// (N, E, S, W) repeating

function trackRobot() {
    let horiz = 0;
    let verti = 0;
    for (let i = 0; i < arguments.length; i++) {
        switch (i % 4) {
            case 0:
                verti += arguments[i];
                break;
            case 1:
                horiz += arguments[i];
                break;
            case 2:
                verti -= arguments[i];
                break;
            case 3:
                horiz -= arguments[i];
                break;
        }
    }
    return [horiz, verti];
}

console.log(trackRobot(20, 30, 10, 40));
console.log(trackRobot());
console.log(trackRobot(-10, 20, 10));
console.log(trackRobot(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));

// Problem 2: Does triangle A fit inside triangle B. Returns false if triangle is invalid.

function doesTriangleFit(a, b) {
    a.sort();
    b.sort();
    if (a.length != 3 || a[0] + a[1] < a[2]) return false;
    if (b.length != 3 || b[0] + b[1] < b[2]) return false;
    if (a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2]) return true;
    return false;
}

console.log(doesTriangleFit([1,1,1], [1,1,1]));
console.log(doesTriangleFit([1,1,1], [2,2,2]));
console.log(doesTriangleFit([1,2,3], [1,2,2]));
console.log(doesTriangleFit([1,2,4], [1,2,6]));
