//////////////////////////////////////////////////////////////////////////
// Filename: sportsanalytics.cpp                                        //
// Date: Februrary 19, 2020                                             //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program asks the guest to enter which hotel room they      //
//      wish to stay in, then the program ask the guest which meal      // 
//      combos they would like                                          //
//////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <fstream>
using namespace std;

int getNumberOfTwoPointsMade(string &fileName, ifstream &file)
{
    string stat;
    int num;
    int ThPM = 0;
    int FGM = 0;

    file.open(fileName);
    while(file >> stat >> num)
    {
        if (stat == "FGM") {FGM = num;}
        else if (stat == "3PM") {ThPM = num;}
    }
    if (ThPM == 0 || FGM == 0) {return 0;}
    else return FGM - ThPM;
}

int getNumberOfThreePointsMade(string &fileName, ifstream &file)
{

}

int getTotalNumberOfShotsAttempted(string &fileName, ifstream &file)
{

}

double getPercentageOfTwoPointsMade(string &fileName, ifstream &file)
{

}

double getPercentageOfThreePointsMade(string &fileName, ifstream &file)
{

}

bool IsBetterThanChance(string &fileName, ifstream &file)
{

}

int main()
{
    string fileName;
    ifstream file;
    
    cout << "Welcome to the LeBron James Museum, please enter the file you wish to analyze: ";
    cin >> fileName;
    
    cout << getNumberOfTwoPointsMade(fileName, file);
    getNumberOfThreePointsMade(fileName, file);
    getTotalNumberOfShotsAttempted(fileName, file);
    getPercentageOfTwoPointsMade(fileName, file);
    getPercentageOfThreePointsMade(fileName, file);
    IsBetterThanChance(fileName, file);

    cin >> fileName;
}