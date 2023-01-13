rowNum = int(input("Enter a row num from 1 to 5: "))
colNum = int(input("Enter a col num from 1 to 5: "))

if not(rowNum > 0 and rowNum < 6 and colNum > 0 and colNum < 6):
    print("Invalid numbers! Please try again...")
    exit()

bigList = [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]

bigList[rowNum - 1][colNum - 1] = 1

for l in bigList:
    for x in l:
        print(x, end=" ")
    print()