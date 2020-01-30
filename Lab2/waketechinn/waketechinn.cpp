//////////////////////////////////////////////////////////////////////////
// Filename: waketechinn.cpp                                            //
// Date: January 29, 2020                                               //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program asks the guest to enter which hotel room they      //
//      wish to stay in, then the program ask the guest which meal      // 
//      combos they would like                                          //
//////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

char restaurant()
{
    
}

int main()
{
    srand(time(NULL));
    int roomNum;

    cout << "Welcome to the Wake Tech Inn! May I take your coat?\nWelcome to the Wake Tech Inn! And while you slumber, you will feel as if you're gently rocking on a boat.\nWhich room would you like during your stay?" << endl;
    cout << "1      1 Queen Size Bed, Accessible\n2      1 Queen Size Bed, Sofa\n3      1 King Size Bed, Accessible\n4      1 Kind Size Bed, Sofa" << endl;
    cin >> roomNum;
    switch (roomNum)
    {
    case 1:
        cout << "You have selected the 1 queen size bed with accessible amenities\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    case 2:
        cout << "You have selected the 1 queen size bed with sofa\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    case 3:
        cout << "You have selected the 1 king size bed with accessible amenities\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    case 4:
        cout << "You have selected the 1 queen size bed with sofa\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    default:
        cout << "I'm sorry, that is not a valid option, please try again" << endl << endl;
        main();
        break;
    }
    cin >> roomNum;
}