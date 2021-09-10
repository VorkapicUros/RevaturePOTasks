def doesBrickFit(a, b, c, w, h):
    if any(n <= 0 for n in [a, b, c, w, h]):
        return "Invalid"
    abc = [a, b, c]
    abc.remove(max(abc))
    wh = [w, h]
    return max(wh) >= max(abc) and min(wh) >= min(abc)

print(doesBrickFit(1, 1, 1, 1, 1)) # Should equate to True
print(doesBrickFit(1, 2, 1, 1, 1)) # Should equate to True
print(doesBrickFit(1, 2, 2, 1, 1)) # Should equate to False
print(doesBrickFit(2, 6, 8, 4, 4)) # Should equate to False
print(doesBrickFit(4, 3, 2, 3, 2)) # Should equate to True
print(doesBrickFit(-1, 0, 2, -1, 2)) # Should equate to False (technically "invalid")