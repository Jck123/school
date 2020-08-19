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
#include <iomanip>
#include <fstream>
using namespace std;

int printResults(string stuNames[], double stuGrades[][5], double stuGAvg[], char stuGLetter[], double testAvg[], int stuCount)
{
    int A = 0;
    int B = 0;
    int C = 0;
    int D = 0;
    int F = 0;
    for (int i = 0; i < stuCount - 1; i++)      //Counts number of letter grades seperated by letter
    {
        switch (stuGLetter[i])
        {
            case 'A':
                A++;
                break;
            case 'B':
                B++;
                break;
            case 'C':
                C++;
                break;
            case 'D':
                D++;
                break;
            case 'F':
                F++;
                break;
        }
    }
    cout << "----------------------------------------------Student Stats----------------------------------------------------" << endl;      //Formatting
    cout << "   Student        Test 1      Test 2      Test 3      Test 4      Test 5      Final Grade     Letter Grade" << endl;
    for (int i = 0; i < stuCount - 1; i++)      //Prints all the students, their grades, averages, and final letter grade
    {
        cout << setw(10) << stuNames[i] << setw(12) << stuGrades[i][0] << setw(12) << stuGrades[i][1] << setw(12) << stuGrades[i][2] << setw(12) << stuGrades[i][3] << setw(12) << stuGrades[i][4] << setw(16) << stuGAvg[i] << setw(15) << stuGLetter[i] << endl; 
    }
    cout << "Letter Grade Distribution: A: " << A << "      B: " << B << "      C: " << C << "      D: " << D << "      F: " << F << endl;
    cout << "----------------------------------------------Test Averages-----------------------------------------------------" << endl;     //Formatting
    cout << "Test 1     Test 2      Test 3      Test 4      Test 5" << endl;
    cout << ' ' << testAvg[0] << setw(11) << testAvg[1] << setw(12) << testAvg[2] << setw(12) << testAvg[3] << setw(11) << testAvg[4] << endl;  //Prints average score of each test
    cin >> A;
}

int arrSort(string stuNames[], double stuGrades[][5], double stuGAvg[], char stuGLetter[], double testAvg[], int stuCount)  //Sorts all arrays simultaneously
{
    int i = 0;
    while (i < stuCount - 1)        //Basic bubble sort to keep all the students and their data together
    {
        if (stuNames[i] >= stuNames[i+1])
        {
            string s = stuNames[i];         //Place holder
            stuNames[i] = stuNames[i+1];
            stuNames[i+1] = s;

            for (int j = 0; j <= 4; j++)    //Moves all test scores together
            {
                int x = stuGrades[i][j];
                stuGrades[i][j] = stuGrades[i+1][j];
                stuGrades[i+1][j] = x;
            }

            int j = stuGAvg[i];
            stuGAvg[i] = stuGAvg[i+1];
            stuGAvg[i+1] = j;

            char c = stuGLetter[i];
            stuGLetter[i] = stuGLetter[i+1];
            stuGLetter[i+1] = c;

            i = 0;                          //Resets search if current value is not smaller than next value
        }
        else {i++;}                         //If next value is larger than current value, sort may go to next pair
    }

    printResults(stuNames, stuGrades, stuGAvg, stuGLetter, testAvg, stuCount);      //Passes information to next function
}

int testAverage(double stuGrades[][5], string stuNames[], double stuGAvg[], char stuGLetter[], int stuCount)
{
    double testAvg[5];
    double test1 = 0.0;         //Collects total points of each test to later be divided into the average
    double test2 = 0.0;
    double test3 = 0.0;
    double test4 = 0.0;
    double test5 = 0.0;

    for (int i = 0; i <= stuCount - 1; i++)
    {
        test1 = test1 + stuGrades[i][0];
        test2 = test2 + stuGrades[i][1];
        test3 = test3 + stuGrades[i][2];
        test4 = test4 + stuGrades[i][3];
        test5 = test5 + stuGrades[i][4];
    }
    testAvg[0] = test1 / stuCount;      //Getting average of each test
    testAvg[1] = test2 / stuCount;
    testAvg[2] = test3 / stuCount;
    testAvg[3] = test4 / stuCount;
    testAvg[4] = test5 / stuCount;

    arrSort(stuNames, stuGrades, stuGAvg, stuGLetter, testAvg, stuCount);   //Passes information on to next function
}

int arrAverage(double stuGrades[][5], string stuNames[], int stuCount)      //Gets final grade of each student and assigns letter grades
{
    double stuGAvg[stuCount];
    char stuGLetter[stuCount];
    for (int i = 0; i <= stuCount; i++)
    {
        stuGAvg[i] = (stuGrades[i][0] + stuGrades[i][1] + stuGrades[i][2] + stuGrades[i][3] + stuGrades[i][4]) / 5.0;
        if (stuGAvg[i] >= 90) {stuGLetter[i] = 'A';}
        else if (stuGAvg[i] >= 80 && stuGAvg[i] < 90) {stuGLetter[i] = 'B';}
        else if (stuGAvg[i] >= 70 && stuGAvg[i] < 80) {stuGLetter[i] = 'C';}
        else if (stuGAvg[i] >= 60 && stuGAvg[i] < 70) {stuGLetter[i] = 'D';}
        else if (stuGAvg[i] < 60) {stuGLetter[i] = 'F';} 
    }

    testAverage(stuGrades, stuNames, stuGAvg, stuGLetter, stuCount);        //Passes information on to next function
}

int arrPull(string &fileName)           //Pulls all avalible information from file to go to arrays
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

    string stuNames[stuCount];
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

    arrAverage(stuGrades, stuNames, stuCount);      //Passes information on to next function
    stuFile.close();
}



int main()
{
    string fileName;
    cout << "Welcome to the Student Grade Analysis program, please enter the name of the file you wish to analyze." << endl;
    cin >> fileName;
    arrPull(fileName);  //Starts everything off
}