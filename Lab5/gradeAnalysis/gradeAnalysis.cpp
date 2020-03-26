//////////////////////////////////////////////////////////////////////////
// Filename: gradeAnalysis.cpp                                          //
// Date: March 25, 2020                                                 //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program takes a file and outputs a file that has the       //
//      same information as well as a final letter grade that is        //
//      calculated and found based off the average of the four          //
//      test scores                                                     //
//////////////////////////////////////////////////////////////////////////
#include <string>
#include <iostream>
#include <fstream>
using namespace std;

int arrStorage()
{

}

int main()
{
    string fileName;
    ifstream stuFile;
    cout << "Welcome to the Student Grade Analysis program, please enter the name of the file you wish to analyze." << endl;
    cin >> fileName;
    stuFile.open(fileName);
}