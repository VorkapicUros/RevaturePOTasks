function getHashTags(s) {
    let top3 = s.split(" ").sort(byLength).slice(0,3).map(addHashtag);
    console.log('Hashtags of "' + s + '":');
    console.log(top3);
}

const byLength = function(a, b) {
    return b.length - a.length;
}

const addHashtag = function(a) {
    return "#" + a.toLowerCase();
}

getHashTags("How the Avocado Became the Fruit of the Global Trade");
getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year");
getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit");
getHashTags("Visualizing Science");