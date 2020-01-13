//////////////////////////////////////////////////////////////////////////
// Filename: fishomatic.cpp                                             //
// Date: January 13, 2020                                               //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//    This program takes the length, width, and height of a fish        //
//    tank and calculates how much conditioner is needed and            //
//    stores the information in a file                                  //
//////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <typeinfo>
#include <fstream>
#include <sstream>
#include <string>
using namespace std;

int getNumber()
{
    string str;
    double num;

    getline(cin, str);
    try
    {
        num = stod(str);
        return num;
    }
    catch (exception)
    {
        cout << "Invalid input detected. Please only enter numbers" << endl;
        return getNumber();
    }
}

int main()
{
    ofstream outFile("Results.txt");
    
    double x;
    double y;
    double z;

    cout << "Hello, and welcome to the Fish-O-Matic fish tank conditioner dispenser\nEnter the length(in inches) of your fish tank you will be conditioning today" << endl;
    x = getNumber();
    cout << "Now type in the width(in inches) of the fish tank" << endl;
    y = getNumber();
    cout << "Now type in the height(in inches) of the fish tank" << endl;
    z = getNumber();
    outFile << "You need " << (x * y * z)/100 << " ml of conditioner for a tank with the dimensions of " << x << "in. x " << y << "in. x " << z << "in.";
    cout << "The amount of required conditioner has been saved in \"Results.txt\"\nPress enter to close this program" << endl;
    getNumber();

    outFile.close();
}