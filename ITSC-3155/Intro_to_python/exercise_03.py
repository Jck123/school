num = int(input("Enter a number greater than 1: "))

if not (num > 1):
    print("Invalid number! Please try again...")
    exit()

for i in range(num + 1):
    print("The cube of " + str(i) + " is " + str(i ** 3))