import math

def flip(c):
    if c.isalpha() is False:
        return c
    start_point = ord('A') if c.isupper() else ord('a')
    c_as_num = ord(c[0]) - start_point
    return chr(start_point + (25 - c_as_num))

def atbash(s):
    mirror = ""
    for character in s:
        mirror += flip(character)
    return mirror

print("apple --> " + atbash('apple'))
print("Hello world --> " + atbash('Hello world!'))
print("Christmas is the 25th of December --> " + atbash('Christmas is the 25th of December'))