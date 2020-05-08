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
    Matrix mat(2, 3);
    Matrix mat2(3, 2);
    mat.displayMatrix();
    mat2.displayMatrix();
    cout << mat.getCnt();
}