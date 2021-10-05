def rgb_or_hex(a, b = None, c = None):
    if b != None and c != None:
        return dec_to_hex([a, b, c])
    elif b == None and c !=None or b != None and c == None:
        return "Invalid Prompt"
    else:
        return hex_to_dec(a[1:])

def dec_to_hex(decs):
    hex_num = ""
    for val in decs:
        hex_num += str(hex(val))[2:].zfill(2)
    return "#" + hex_num

def hex_to_dec(hex_num):
    decs = [None] * (round(len(hex_num)/2))
    for i in range(round(len(hex_num)/2)):
        decs[i] = str(int(hex_num[i*2:i*2+1], 16))
    return "(" + ", ".join(decs) + ")"
    
print(rgb_or_hex(150, 50, 76))
print(rgb_or_hex("#303749"))
print(rgb_or_hex(170, 14, 0))