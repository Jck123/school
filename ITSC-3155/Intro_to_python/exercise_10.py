#James Kelly

strIn = input("Enter a string: ")

bigList = list()
smallList = list()

for s in strIn:
    smallList.append(s)
    if len(smallList) == 3:
        bigList.append(smallList.copy())
        smallList.clear()
else:
    if len(smallList) > 0:
        bigList.append(smallList.copy())

print(bigList)