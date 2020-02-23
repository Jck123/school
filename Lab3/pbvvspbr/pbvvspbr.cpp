//////////////////////////////////////////////////////////////////////////
// Filename: pbvvspbr.cpp                                               //
// Date: Februrary 22, 2020                                             //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program takes a file of Lebron's basketball statistics     //
//      and does calculations using functions                           //
//////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <string>

using namespace std;

string passByValue()
{
    int randNum = rand() % 100 + 1;
    if (randNum <= 20) {return "Sorry! You're not close enough!";}
    else if (randNum > 20 && randNum <= 60) {return "Oh, you're almost there?";}
    else if (randNum > 60 && randNum <= 85) {return "Aw cmon, you can do better than that!";}
    else if (randNum > 85) {return "You’re up big. Getting closer to breaking your old record";}
    
}

int passByReference(string &output)
{
    int randNum = rand() % 100 + 1;
    if (randNum <= 20) {output = "Sorry! You're not close enough!";}
    else if (randNum > 20 && randNum <= 60) {output = "Oh, you're almost there?";}
    else if (randNum > 60 && randNum <= 85) {output = "Aw cmon, you can do better than that!";}
    else if (randNum > 85) {output = "You’re up big. Getting closer to breaking your old record";}
}

int main()
{
    int num;
    string input;
    string output;
    srand(time(0));

    while(true)
    {
        cout << "Which function would you like to pass? Enter '-1' to close the program" << endl;
        cout << "1: passByValue()" << endl << "2: passByReference()" << endl;
        cin >> input;
        try
        {
            num = stoi(input);
            if (num == 1) {cout << passByValue() << endl;}
            else if (num == 2) {passByReference(output); cout << output << endl;}
            else if (num == -1) {break;}
        } catch (exception) {cout << "Sorry, that is not a valid input" << endl;}
    }
}