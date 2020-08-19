//////////////////////////////////////////////////////////////////////////
// Filename: matrixDriver.h                                             //
// Date: May 1, 2020                                                    //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This file contains all the operations of the matrix class       //
//////////////////////////////////////////////////////////////////////////
#include "matrix.h"
#include <iostream>
#include <time.h>
#include <stdlib.h>

int Matrix::cnt = 0;                                //Initializes the cnt value

Matrix::Matrix()                                    //Initializer of the Matrix class if user wishes to just make the maximum size matrix
{
    cnt++;
    srand(time(0) + cnt);                           //Generates random seed for random numbers by using the time and adding on the number of matrices

    row_size = maxRowSize;                          //Saves row and column size for later functions
    col_size = maxColSize;
    matrix[row_size][col_size];                     //Creates the matrix array
    for (int i = 0; i <= row_size - 1; i++)
    {
        for (int j = 0; j <= col_size - 1; j++)     //Randomizes the numbers
        {
            matrix[i][j] = rand() % 10 + 1;
        }
    }
}

Matrix::Matrix(int row, int column)                     //Initializer of the Matrix class if user wishes to choose their matrix size
{
    if (row <= maxRowSize && column <= maxColSize)      //Checks if custom row and column are too large
    {
        cnt++;
        srand(time(0) + cnt);                           //Generates random seed for random numbers by using the time and adding on the number of matrices

        row_size = row;                                 //Saves row and column size for later functions
        col_size = column;
        matrix[row_size][col_size];                     //Creates the matrix array
        for (int i = 0; i <= row_size - 1; i++)
        {
            for (int j = 0; j <= col_size - 1; j++)     //Randomizes the numbers
            {
                matrix[i][j] = rand() % 10 + 1;
            }
        }
    } else { std::cout << "Sorry, matrix can only be as large as " << maxRowSize << 'x' << maxColSize << std::endl; }   //Tells the user to go away if the matrix requested is too large
}

void Matrix::setRowSize(int x)
{
    double matrix1[x - 1][col_size];     //Placeholder for old matrix
    for (int i = 0; i <= row_size - 1; i++)
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            matrix1[i][j] = matrix[i][j];
        }
    }
    for (int i = 0; i <= x - 1; i++)    //Copies over old matrix to new one, leaving 0s in the extra spaces or ignoring values that won't fit in the new matrix
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            if (matrix1[i][j] < 0.01 && matrix1[i][j] > -0.01) { matrix[i][j] = 0; } //Numbers that are created when the matrix increases in size are typically random values that tend to be very small, this turns those values to 0
            else { matrix[i][j] = matrix1[i][j]; }
        }
    }
    row_size = x;
}

void Matrix::setColumnSize(int x)
{
    double matrix1[row_size][x - 1];                //Placeholder for old matrix
    for (int i = 0; i <= row_size - 1; i++)
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            matrix1[i][j] = matrix[i][j];
        }
    }
    for (int i = 0; i <= row_size - 1; i++)     //Copies over old matrix to new one, leaving 0s in the extra spaces or ignoring values that won't fit in the new matrix
    {
        for (int j = 0; j <= x - 1; j++)
        {
            if (matrix1[i][j] < 0.01 && matrix1[i][j] > -0.01) { matrix[i][j] = 0; }    //Numbers that are created when the matrix increases in size are typically random values that tend to be very small, this turns those values to 0
            else { matrix[i][j] = matrix1[i][j]; }
        }
    }
    col_size = x;
}

void Matrix::addValue(double x)
{
    for (int i = 0; i <= row_size - 1; i++)
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            if(matrix[i][j] == 0) 
            {
                matrix[i][j] = x;           //Finds the first 0 in the matrix and sets it to 0, if there are no 0s, then nothing happens
                break; break;
            }
        }
    }
}

int Matrix::getCnt()
{
    return cnt;             //Returns count of matrices created
}

int Matrix::getRowSize()
{
    return row_size;        //Returns row size of specified matrix
}

int Matrix::getColumnSize()
{
    return col_size;        //Returns column size of specified matrix
}

void Matrix::displayMatrix()        //Displays matrix by going one number at a time
{
    for (int i = 0; i <= row_size - 1; i++)
    {
        std::cout << "[   ";
        for (int j = 0; j <= col_size - 1; j++)
        {
            std::cout << matrix[i][j] << "   ";
        }
        std::cout << "]" << std::endl;
    }
    std::cout << std::endl;
}

double Matrix::getValue(int row, int col)       //Returns value of specific value in specified location of the matrix
{
    return matrix[row][col];
}

Matrix Matrix::add(Matrix &other)                                       //Adds two matrices together
{
    if (other.row_size == row_size && other.col_size == col_size)       //Verifies both matrices being added are the same size
    {
        Matrix result(row_size, col_size);                              //Here's where the adding begins
        for (int i = 0; i <= row_size - 1; i++)
        {
            for (int j = 0; j <= col_size - 1; j++)
            {
                result.matrix[i][j] = matrix[i][j] + other.matrix[i][j];    //Compiles results into new matrix here
            }
        }
        displayMatrix();                                                //Displays results
        std::cout << "+" << std::endl;
        other.displayMatrix();
        std::cout << "=" << std::endl;
        result.displayMatrix();
    } else { std::cout << "Sorry, that's not possible" << std::endl; }  //Tells user to go away if matrices are not the same size
}

Matrix Matrix::subtract(Matrix &other)                                  //Subtracts one matrix from another
{
    if (other.row_size == row_size && other.col_size == col_size)       //Verifies if two matrices are the same size
    {
        Matrix result(row_size, col_size);                              //Here's where the subtraction begins
        for (int i = 0; i <= row_size - 1; i++)
        {
            for (int j = 0; j <= col_size - 1; j++)
            {
                result.matrix[i][j] = matrix[i][j] - other.matrix[i][j];    //Compiles results into new matrix here
            }
        }
        displayMatrix();                                                //Displays results
        std::cout << "-" << std::endl;
        other.displayMatrix();
        std::cout << "=" << std::endl;
        result.displayMatrix();
    } else { std::cout << "Sorry, that's not possible" << std::endl; }      //Tells user to go away if matrices are not same size
}

Matrix Matrix::product(Matrix &other)                               //Multiplies two matrices together
{
    if (col_size == other.row_size)                                 //Verifies if two matrices are compatible
    {
        Matrix result(row_size, other.col_size);
        for (int i = 0; i <= result.row_size - 1; i++)              //Here's where the multiplication begins
        {
            for (int j = 0; j <= result.col_size - 1; j++)
            {
                result.matrix[i][j] = 0;                            //It took me over an hour to come up with this 'algorithm'
                for (int k = 0; k <= col_size - 1; k++)
                {
                    result.matrix[i][j] = result.matrix[i][j] + (matrix[i][k] * other.matrix[k][j]);    //Compiles results into new matrix here
                }
            }
        }
        displayMatrix();                                            //Displays results
        std::cout << "*" << std::endl;
        other.displayMatrix();
        std::cout << "=" << std::endl;
        result.displayMatrix();
    } else { std::cout << "Sorry, that's not possible" << std::endl; }  //Tells user to go away if two matrices are not compatible
}

Matrix Matrix::product(double scalar)                               //Multiplies matrix by single number
{
    Matrix result(row_size, col_size);
    for (int i = 0; i <= row_size - 1; i++)                         //Here's where the multiplication begins
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            result.matrix[i][j] = matrix[i][j] * scalar;            //Compiles results into new matrix here
        }
    }
    displayMatrix();                                                //Displays results
    std::cout << "*" << std::endl;
    std::cout << scalar << std::endl;
    std::cout << "=" << std::endl;
    result.displayMatrix();
}