//////////////////////////////////////////////////////////////////////////
// Filename: waketechinn.cpp                                            //
// Date: January 31, 2020                                               //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program takes a list of the user's descretion and counts   //
//      how many groups there are in the file, how many groups are      //
//      even or odd, the sum of the students in the even and odd        //
//      classes, the sum of all students, the group with the most       //
//      numbers, the group with the least students, the average of      //
//      the two, and the sum of the numbers of the largest group.       //
//////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    int index;                      //Group number
    int groupSize = 0;              //Size of group
    int largestGroupIndex;          //Group number of largest group
    int largestGroup = 0;           //Size of largest group
    int smallestGroupIndex;         //Group number of smallest group
    int smallestGroup = 9999999;    //Size of smallest group
    int evenNum = 0;                //Number of groups with an even number of students
    int evenNumSum = 0;             //Total of all even sized groups
    int oddNum = 0;                 //Number of groups with an odd number of students
    int oddNumSum = 0;              //Total of all odd sized groups
    int NumSum = 0;                 //Total of all students
    int largestSum = 0;             //Counter for largestSumStr
    string largestSumStr;           //Largest number is converted into a string
    string fileName;                //User input
    ifstream file;

    cout << "Type in the name of the file you wish to analyze: ";
    cin >> fileName;
    file.open(fileName);

    while(file >> index >> groupSize)   //Loops statements for each line in the file
    {

        if (groupSize > largestGroup)   //Checks each group if they're the largest
        {
            largestGroup = groupSize;
            largestGroupIndex = index;
        }
        if (groupSize < smallestGroup)  //Checks each group if they're the smallest
        {
            smallestGroup = groupSize;
            smallestGroupIndex = index;
        }
        if (groupSize % 2 == 0) //Checks of even...
        {
            evenNum++;
            evenNumSum = evenNumSum + groupSize;
        } else {                //...or odd
            oddNum++;
            oddNumSum = oddNumSum + groupSize;
        }

        NumSum = NumSum + groupSize;
    }
    largestSumStr = to_string(largestGroup);                //Converts integer into string
    for (int i = 0; i < largestSumStr.length(); i++)        //Splits string into it's chars
    {
        largestSum = largestSum + largestSumStr[i] - '0';   //Converts string into integer
    }
    

    cout << "The number of groups in the file is " << index << endl;    //Final results are compiled and displayed here
    cout << "There are " << oddNum << " odd student count and " << evenNum << " even student count" << endl;
    cout << "The sum of the odd student count is " << oddNumSum << endl;
    cout << "The sum of the even student count is " << evenNumSum << endl;
    cout << "The sum of all the student count is " << NumSum << endl;
    cout << "The group number of the largest student count is " << largestGroupIndex << endl;
    cout << "The group number of the smallest student count is " << smallestGroupIndex << endl;
    cout << "The average of " << largestGroup << " and " << smallestGroup << " is " << ((double)largestGroup + (double)smallestGroup) / 2 << endl; 
    cout << "The sum of all the digits in the largest student count is " << largestSum;

    file.close();

    cin >> fileName;
}