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

int getNumberOfTwoPointsMade(int &ThPM, int &FGM)
{
    return FGM - ThPM;                  //Subtracts 3 pointers made from total shots made to get 2 pointers made
}

int getNumberOfThreePointsMade(int &ThPM)
{
    return ThPM;                        //Returns three pointers made
}

int getTotalNumberOfShotsAttempted(int &FGM)
{
    return FGM;                         //Returns all attempts for the basket
}

double getPercentageOfTwoPointsMade(double TPM, double ThPA, double FGA)
{
    return (TPM / (FGA - ThPA)) * 100;  //Subtracts three pointer attempts from all attempts and divides two pointers made by that
}

double getPercentageOfThreePointsMade(double ThPM, double ThPA)
{
    return (ThPM / ThPA) * 100;         //Returns percentage of three pointers made
}

bool IsBetterThanChance(double FGM, double FGA)
{
    if (FGM/FGA >= 0.5) {return true;}  //Returns bool value if total shots are 50% or over
    else {return false;}
}

int main()
{
    string fileName;
    ifstream file;
    string stat;
    int num;
    int FGM;            //Field Goals Made
    int FGA;            //Field Goals Attempted
    int ThPM;           //Three Points Made
    int ThPA;           //Three Points Attempted
    
    cout << "Welcome to the LeBron James Museum, please enter the file you wish to analyze: ";
    cin >> fileName;
    file.open(fileName);
    while (file >> stat >> num)
    {
        if (stat == "FGM") {FGM = num;}         //Gets needed values from file and sets them to internal variables
        else if (stat == "FGA") {FGA = num;}
        else if (stat == "3PM") {ThPM = num;}
        else if (stat == "3PA") {ThPA = num;}
    }


    cout << "Two-pointers made: " << getNumberOfTwoPointsMade(ThPM, FGM) << endl;       //Prints results
    cout << "Three-pointers made: " << getNumberOfThreePointsMade(ThPM) << endl;
    cout << "Total number of attempts: " << getTotalNumberOfShotsAttempted(FGA) << endl;
    cout << "Percent of Two-pointers made: " << getPercentageOfTwoPointsMade(getNumberOfTwoPointsMade(ThPM, FGM), ThPA, FGA) << "%" << endl;
    cout << "Percent of Three-pointers made: " << getPercentageOfThreePointsMade(ThPM, ThPA) << "%" << endl;
    if (IsBetterThanChance(FGM, FGA)) {cout << "Lebron has a good chance of scoring" << endl;}
    else {cout << "Lebron does not have a good chance of scoring" << endl;}

    file.close();
    cin >> fileName;
}