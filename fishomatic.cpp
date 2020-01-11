#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
using namespace std;

int main()
{
    ofstream outFile("Results.txt");
    string str;

    double x;
    double y;
    double z;

    cout << "Hello, and welcome to the Fish-O-Matic fish tank conditioner dispenser\nEnter the length of your fish tank you will be conditioning today\n";
    getline(cin, str);
    x = stoi(str);
    cout << "Now type in the width of the fish tank\n";
    getline(cin, str);
    y = stoi(str);
    cout << "Now type in the height of the fish tank\n";
    getline(cin, str);
    z = stoi(str);
    outFile << (x * y * z)/100;
    cout << "The amount of required conditioner has been saved in \"Results.txt\"\nPress enter to close this program\n";
    getline(cin, str);

    outFile.close();
}