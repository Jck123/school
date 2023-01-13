#James Kelly

wordList = list()

for i in range(5):
    wordList.append(input("Enter a word: "))

print("Words:", wordList)

print("One String: ", end = "")
for s in wordList:
    print(s, end = " ")
print()