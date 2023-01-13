#James Kelly

grade = int(input("Please enter your number grade: "))

if not(grade >= 0 and grade <= 100):
    print("Invalid number! Please try again...")
    exit()

if grade >= 90: letGrade = 'A'
elif grade >= 80: letGrade = 'B'
elif grade >= 70: letGrade = 'C'
elif grade >= 60: letGrade = 'D'
else: letGrade = 'F'

print("Your grade is " + letGrade)