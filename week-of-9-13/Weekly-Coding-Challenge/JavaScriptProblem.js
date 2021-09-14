function longestNonRepeatingSubString(s) {
    let sarr = s.split("");
    let current = 0;
    let str = [sarr[0]];
    for (let i = 1; i < sarr.length; i++) {
        if (str[current].includes(sarr[i])) {
            str.push(sarr[i]);
            current++;
        } else {
            str[current] = str[current] + sarr[i];
        }
    }
    let longest = 0;
    for (let i = 0; i < str.length; i++) {
        if (str[i].length > str[longest].length) {
            longest = i;
        }
    }
    return str[longest];
}

console.log(longestNonRepeatingSubString("abcabcbb"));
console.log(longestNonRepeatingSubString("aaaaaa"));
console.log(longestNonRepeatingSubString("abcde"));
console.log(longestNonRepeatingSubString("abcda"));