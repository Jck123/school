list1 = list()
list2 = list()

for i in range(5):
    list1.append(int(input("Enter a number for the first list: ")))

for i in range(5):
    list2.append(int(input("Enter a number for the second list: ")))

print("First list:", list1)
print("Second list:", list2)
print("Common List:", list(set(list1) & set(list2)))