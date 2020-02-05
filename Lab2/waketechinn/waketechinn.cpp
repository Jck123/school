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

#include <iostream>     //For cin and cout
#include <cstdlib>      //For rand()
#include <ctime>        //For srand(time(NULL))
#include <iomanip>      //For setprecision()
using namespace std;

char restaurant(double &orderPrice, int &orderTotal)
{
    char comboChar;
    cout << "Enter the letter of the combo you would like to order, or type \'T\' to calculate the total: ";
    cin >> comboChar;

    switch (toupper(comboChar))             //Recorded char values are converted to uppercase for consistency
    {
    case 'A':                               //Combo A
        orderPrice = orderPrice + 10.25;
        orderTotal++;
        restaurant(orderPrice, orderTotal); //Reiteration
        break;
    case 'B':                               //Combo B
        orderPrice = orderPrice + 15.75;
        orderTotal++;
        restaurant(orderPrice, orderTotal);
        break;
    case 'C':                               //Combo C
        orderPrice = orderPrice + 13.25;
        orderTotal++;
        restaurant(orderPrice, orderTotal);
        break;
    case 'D':                               //Combo D
        orderPrice = orderPrice + 9.75;
        orderTotal++;
        restaurant(orderPrice, orderTotal);
        break;
    case 'T':                               //Calculates total with 6% sales tax
        cout << "You have ordered " << orderTotal << " items and your total is: $" << setprecision(4) << orderPrice * 1.06 << endl;
        break;
    default:                                //Input error
        cout << "I'm sorry, that is not a valid combo, please try again" << endl;
        restaurant(orderPrice, orderTotal);
        break;
    }
}

int main()
{
    double orderPrice = 0.00;
    int orderTotal = 0;
    int roomNum;

    srand(time(NULL));  //Makes the room number ACTUALLY random

    cout << "Welcome to the Wake Tech Inn! May I take your coat?\nWelcome to the Wake Tech Inn! And while you slumber, you will feel as if you're gently rocking on a boat.\nWhich room would you like during your stay?" << endl;
    cout << "1      1 Queen Size Bed, Accessible\n2      1 Queen Size Bed, Sofa\n3      1 King Size Bed, Accessible\n4      1 Kind Size Bed, Sofa" << endl;
    cin >> roomNum;
    switch (roomNum)
    {
    case 1:     //1 Queen Size Bed, Accessible
        cout << "You have selected the 1 queen size bed with accessible amenities\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;  //Calculates a random number between 100 and 599
    case 2:     //1 Queen Size Bed, Sofa
        cout << "You have selected the 1 queen size bed with sofa\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    case 3:     //1 King Size Bed, Accessible
        cout << "You have selected the 1 king size bed with accessible amenities\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    case 4:     //1 King Size Bed, Sofa
        cout << "You have selected the 1 queen size bed with sofa\nYour room number is " << rand() % 500 + 100 << endl << endl;
        break;
    default:    //Input error
        cout << "I'm sorry, that is not a valid option, please try again" << endl << endl;
        main();
        break;
    }
    cout << "Welcome to the Wake Tech Inn Restaurant! On today's menu, we have\nCombo      Description                                 Price\nCombo A    Curry Chicken with Cabbage and a Drink      $10.25\nCombo B    Tower Special Samosa with a Drink           $15.75\nCombo C    Enpanadas Cubanas w/Shrimp and a Drink      $13.25\nCombo D    Cheeseburgers with Fries and a Drink        $9.75" << endl;
    restaurant(orderPrice, orderTotal);   //Activates the restaurant part of the program
    cin >> roomNum; //Allows user to read output of program before program closes
}