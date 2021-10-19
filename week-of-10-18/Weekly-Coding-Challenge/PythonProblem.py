def can_see_stage(seats):
    for i in range(1, len(seats)):
        for j in range(len(seats[i])):
            if seats[i][j] <= seats[i-1][j]:
                return False
    return True

p1 = can_see_stage([
    [1, 2, 3, 2, 1, 1],
    [2, 4, 4, 3, 2, 2],
    [5, 5, 5, 5, 4, 4],
    [6, 6, 7, 6, 5, 5]
])
p2 = can_see_stage([
    [1, 2, 3, 2, 1, 1],
    [2, 4, 4, 3, 2, 2],
    [5, 5, 5, 10, 4, 4],
    [6, 6, 7, 6, 5, 5]
])
p3 = can_see_stage([
    [1,2,3],
    [4,5,6],
    [7,8,9]
])
p4 = can_see_stage([
    [0,0,0],
    [1,1,1],
    [2,2,2]
])
p5 = can_see_stage([
    [2,0,0],
    [1,1,1],
    [2,2,2]
])
p6 = can_see_stage([
    [1,0,0],
    [1,1,1],
    [2,2,2]
])
print(p1)
print(p2)
print(p3)
print(p4)
print(p5)
print(p6)