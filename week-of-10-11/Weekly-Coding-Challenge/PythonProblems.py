import math

## Identity Matrix

def id_mtrx(size):
    if type(size) != int:
        return "Error"

    next_index = 0
    incrementor = 1
    if size < 0:
        size = 0 - size
        next_index = size - 1
        incrementor = -1
    
    matrix = [[0 for columns in range(size)] for rows in range(size)]
    for m in matrix:
        m[next_index] = 1
        next_index += incrementor
    
    return matrix

print(*id_mtrx(2), sep='\n')
print()
print(*id_mtrx(-2), sep='\n')
print()
print(id_mtrx(0))
print()
print(id_mtrx("L"))
print()
print(*id_mtrx(-25), sep='\n')
print()

## atBash Cipher coder/decoder

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

print("atbash('apple') --> " + atbash('apple'))
print("atbash('Hello world!') --> " + atbash('Hello world!'))
print("atbash('Christmas is the 25th of December') --> " + atbash('Christmas is the 25th of December'))