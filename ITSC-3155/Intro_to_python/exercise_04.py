#James Kelly

listNum = int(input("Enter a number: "))

numList = list()

for i in range(listNum):
    numList.append(float(input("Enter number " + str(i + 1) + ":")))

print("List: " + str(numList))
print("Average: ", round(sum(numList) / len(numList), 3))