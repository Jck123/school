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
    int indexOld = 0;
    int index;
    int groupSize = 0;
    int largestGroupIndex;
    int largestGroup = 0;
    int smallestGroupIndex;
    int smallestGroup = 9999999;
    int evenNum = 0;
    int evenNumSum = 0;
    int oddNum = 0;
    int oddNumSum = 0;
    int NumSum = 0;
    int largestSum = 0;
    string largestSumStr;
    string fileName;
    ifstream file;

    cout << "Type in the name of the file you wish to analyze: ";
    cin >> fileName;
    file.open(fileName);

    while(true)
    {
        file >> index >> groupSize;

        if (indexOld == index) { break; }

        if (groupSize > largestGroup)
        {
            largestGroup = groupSize;
            largestGroupIndex = index;
        }
        if (groupSize < smallestGroup)
        {
            smallestGroup = groupSize;
            smallestGroupIndex = index;
        }
        if (groupSize % 2 == 0)
        {
            evenNum++;
            evenNumSum = evenNumSum + groupSize;
        } else {
            oddNum++;
            oddNumSum = oddNumSum + groupSize;
        }

        NumSum = NumSum + groupSize;
        indexOld = index;
    }
    largestSumStr = to_string(largestGroup);
    for (int i = 0; i < largestSumStr.length(); i++)
    {
        largestSum = largestSum + largestSumStr[i] - '0';
    }
    

    cout << "The number of groups in the file is " << indexOld << endl;
    cout << "There are " << oddNum << " odd student count and " << evenNum << " even student count" << endl;
    cout << "The sum of the odd student count is " << oddNumSum << endl;
    cout << "The sum of the even student count is " << evenNumSum << endl;
    cout << "The sum of all the student count is " << NumSum << endl;
    cout << "The group number of the largest student count is " << largestGroupIndex << endl;
    cout << "The group number of the smallest student count is " << smallestGroupIndex << endl;
    cout << "The average of " << largestGroup << " and " << smallestGroup << " is " << ((double)largestGroup + (double)smallestGroup) / 2 << endl; 
    cout << "The sum of all the digits in the largest student count is " << largestSum;
    cin >> fileName;
}