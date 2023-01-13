numList = list()

for x in range(10):
    numList.append(int(input("Enter number " + str(x + 1) + ": ")))

print("Original List:", numList)

uniqueList = list()

for x in numList:
    if(numList.count(x) == 1):
        uniqueList.append(x)

print("Nums that appear once:", uniqueList)