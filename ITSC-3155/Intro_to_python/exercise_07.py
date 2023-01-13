numList = list()

while 1 == 1:
    strIn = input("Enter a number or QUIT to quit: ")
    if strIn == "QUIT":
        break
    numList.append(int(strIn))

print("All Nums:", numList)

evenList = list()

for x in numList:
    if (x % 2) == 0:
        evenList.append(x)

print("Even Nums:", evenList)