import math

# finds the diameter of a tube of foil at its thickest
def foil(tube_diam, foil_thickness, foil_length):
    diam = tube_diam
    perim = diam * math.pi
    remaining_length = foil_length
    
    while remaining_length > 0:
        remaining_length -= perim
        diam += 2*foil_thickness # assumes complete circle around tube
        perim = diam * math.pi
    
    # Removes one foil_thickness if there wasn't enough foil left to 
    # make another half circle around the perimeter of the tube
    if remaining_length < perim / 2 - perim:
        diam -= foil_thickness
    
    return round(diam, 4)

print(foil(4.0, 0.0025, 0))
print(foil(4.0, 0.0025, 50))
print(foil(4.0, 0.0025, 4321))
print(foil(4.0, 0.0025, 10000))