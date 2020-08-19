//////////////////////////////////////////////////////////////////////////
// Filename: enums.cpp                                                  //
// Date: March 12, 2020                                                 //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program takes a file and outputs a file that has the       //
//      same information as well as a final letter grade that is        //
//      calculated and found based off the average of the four          //
//      test scores                                                     //
//////////////////////////////////////////////////////////////////////////
#include <iostream>
#include <fstream>
#include "stdGrade.h"   //Header file containing custom namespace
using namespace std;

int main()
{
    ifstream inFile;
    ofstream outFile;
    string fileName;
    string LastName;
    string FirstName;
    string SSN;
    string FinalLetterGrade;    //Variables to hold each value from the original file
    double test1;
    double test2;
    double test3;
    double test4;

    cout << "Enter the name of the file you wish the analyze: ";
    cin >> fileName;
    inFile.open(fileName);              //Opens up requested folder
    outFile.open("student_final.txt");  //Sets up resulting folder
    inFile >> LastName >> FirstName >> SSN >> test1 >> test2 >> test3 >> test4; //Takes all data from requested file and splits it into different variables
    inFile.close();
    FinalLetterGrade = stdGrade::convertToText(stdGrade::deriveGrade((test1 + test2 + test3 + test4) / 4.0)); //Finds the final letter grade using the alternative namespace
    outFile << LastName << ' ' << FirstName << ' ' << SSN << ' ' << test1 << ' ' << test2 << ' ' << test3 << ' ' << test4 << ' ' << FinalLetterGrade << endl;   //Prints all information into output folder
    outFile.close();
    cout << "Your results have been printed to 'student_final.txt'\nYou may now close the program" << endl;
    cin >> fileName;
}