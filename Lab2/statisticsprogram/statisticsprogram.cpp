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
using namespace std;

int main()
{
    string fileName;
    ifstream file;

    cout << "Type in the name of the file you wish to analyze: ";
    cin >> fileName;
    cout << fileName;
    file.open(fileName);
    cin >> fileName;
}