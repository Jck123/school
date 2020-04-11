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
    int index = 0;
    int stuCount = 0;
    double test1;
    double test2;
    double test3;
    double test4;
    double test5;
    string stuName;
    ifstream stuFile;
    stuFile.open(fileName);

    while (!stuFile.eof())
    {
        getline(stuFile, stuName);
        stuCount++;
    }
    stuFile.close();
    stuFile.open(fileName);

    string *stuNames[stuCount];
    double stuGrades[stuCount][5];
    while (stuFile >> stuName >> test1 >> test2 >> test3 >> test4 >> test5)
    {
        stuNames[index] = stuName;
        stuGrades[index][0] = test1;
        stuGrades[index][1] = test2;
        stuGrades[index][2] = test3;
        stuGrades[index][3] = test4;
        stuGrades[index][4] = test5;
        index++;
    }
    string stuN = &stuNames;
    int stuG = &stuGrades;
    arrAverage(stuN, stuG);
}

int arrAverage(string stuN, int stuG)
{
    string stuNames[] = stuN;
}

int main()
{
    string fileName = "student_grades.txt";
    //string Names[1];
    //int Grades[1][1];
    //cout << "Welcome to the Student Grade Analysis program, please enter the name of the file you wish to analyze." << endl;
    //cin >> fileName;
    arrStorage(fileName);
}

/*int main()
{
    ifstream stuFile;
    string stuName;
    int x = 0;
    stuFile.open("student_grades.txt");
    while (!stuFile.eof())
    {
        getline(stuFile, stuName);
        x++;
    }
    cout << x;
}*/