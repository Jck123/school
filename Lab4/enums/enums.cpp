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
#include "stdGrade.h"   //Header file containing custom namespace
#include <iostream>
#include <fstream>
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
    outFile << LastName << ' ' << FirstName << ' ' << SSN << ' ' << test1 << ' ' << test2 << ' ' << test3 << ' ' << test4 << ' ' << FinalLetterGrade;   //Prints all information into output folder
    outFile.close();
    cout << "Your results have been printed to 'student_final.txt'\nYou may now close the program" << endl;
    cin >> fileName;
}

using namespace stdGrade;

letter_grade deriveGrade (double average)       //Calculates average using if statements
{
    if (average >= 97.0) {return A_PLUS;}
    else if (average >= 93.0 && average < 97.0) {return A;}
    else if (average >= 90.0 && average < 93.0) {return A_MINUS;}
    else if (average >= 87.0 && average < 90.0) {return B_PLUS;}
    else if (average >= 83.0 && average < 87.0) {return B;}
    else if (average >= 80.0 && average < 83.0) {return B_MINUS;}
    else if (average >= 77.0 && average < 80.0) {return C_PLUS;}
    else if (average >= 73.0 && average < 77.0) {return C;}
    else if (average >= 70.0 && average < 73.0) {return C_MINUS;}
    else if (average >= 67.0 && average < 70.0) {return D_PLUS;}
    else if (average >= 63.0 && average < 67.0) {return D;}
    else if (average >= 60.0 && average < 63.0) {return D_MINUS;}
    else if (average < 60.0) {return F;}
}

string convertToText(letter_grade grade)        //Converts enum value to string value using switch statement
{
    switch(grade)
    {
        case A_PLUS:
            return "A+";
            break;
        case A:
            return "A";
            break;
        case A_MINUS:
            return "A-";
            break;
        case B_PLUS:
            return "B+";
            break;
        case B:
            return "B";
            break;
        case B_MINUS:
            return "B-";
            break;
        case C_PLUS:
            return "C+";
            break;
        case C:
            return "C";
            break;
        case C_MINUS:
            return "C-";
            break;
        case D_PLUS:
            return "D+";
            break;
        case D:
            return "D";
            break;
        case D_MINUS:
            return "D-";
            break;
        case F:
            return "F";
            break;
    }
}