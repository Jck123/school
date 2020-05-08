//////////////////////////////////////////////////////////////////////////
// Filename: matrix.cpp                                                 //
// Date: May 1, 2020                                                    //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This file uses matrix.h and matrixDriver.h and displays         //
//      their functionality                                             //
//////////////////////////////////////////////////////////////////////////
#include "matrixDriver.h"
using namespace std;

int main()
{
    double scalar;
    Matrix mat(3, 3);
    Matrix mat2(3, 2);
    Matrix mat3(3, 3);
    mat.add(mat3);      //Same size addition
    mat.add(mat2);      //Different size addition
    mat.subtract(mat3); //Same size subtraction
    mat.product(mat3);  //Same size multiplication
    cout << "Enter a value to multiply the matrix by: ";
    cin >> scalar;      //User input of scalar multiplication here
    mat.product(scalar);
    cout << "Number of matrices created: " << mat.getCnt();
    cin >> scalar;
}