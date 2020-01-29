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
using namespace std;

int main()
{
    int roomNum;

    cout << "Welcome to the Wake Tech Inn! May I take your coat?\nWelcome to the Wake Tech Inn! And while you slumber, you will feel as if you're gently rocking on a boat.\nWhich room would you like during your stay?" << endl;
    cout << "1      1 Queen Size Bed, Accessible\n2      1 Queen Size Bed, Sofa\n3      1 King Size Bed, Accessible\n4      1 Kind Size Bed, Sofa" << endl;
    cin >> roomNum;
    //cout << roomNum;
    //cin >> roomNum;
}