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

int arrStorage(string &fileName)
{
    double test1;
    double test2;
    double test3;
    double test4;
    double test5;
    string stuName;
    ifstream stuFile;
    stuFile.open(fileName);
    while (stuFile >> stuName >> test1 >> test2 >> test3 >> test4 >> test5)
    {
        
    }
}

int main()
{
    string fileName;
    string Names[1];
    int Grades[1][1];
    cout << "Welcome to the Student Grade Analysis program, please enter the name of the file you wish to analyze." << endl;
    cin >> fileName;
}