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

Matrix::Matrix()
{
    //cnt++;
    srand(time(0));

    row_size = maxRowSize;
    col_size = maxColSize;
    matrix[row_size][col_size];
    for (int i = 0; i <= row_size - 1; i++)
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            matrix[i][j] = rand() % 10 + 1;
        }
    }
}

Matrix::Matrix(int row, int column)
{
    if (row <= maxRowSize && column <= maxColSize)
    {
        //cnt++;
        srand(time(0));

        row_size = row;
        col_size = column;
        matrix[row_size][col_size];
        for (int i = 0; i <= row_size - 1; i++)
        {
            for (int j = 0; j <= col_size - 1; j++)
            {
                matrix[i][j] = rand() % 10 + 1;
            }
        }
    } else { std::cout << "Sorry, matrix can only be as large as 5x5" << std::endl; }
}

void Matrix::setRowSize(int x)
{
    double matrix1[x - 1][col_size];     //Placeholder for old matrix, deleted once new matrix made and function is complete
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
            if (matrix1[i][j] < 0.01 && matrix1[i][j] > -0.01) { matrix[i][j] = 0; }
            else { matrix[i][j] = matrix1[i][j]; }
        }
    }
    row_size = x;
}

void Matrix::setColumnSize(int x)
{
    double matrix1[row_size][x - 1];                //Placeholder for old matrix, deleted once new matrix made and function is complete
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
            if (matrix1[i][j] < 0.01 && matrix1[i][j] > -0.01) { matrix[i][j] = 0; }
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
                matrix[i][j] = x;
                break; break;
            }
        }
    }
}

int Matrix::getCnt()
{
    //return cnt;
}

int Matrix::getRowSize()
{
    return row_size;
}

int Matrix::getColumnSize()
{
    return col_size;
}

void Matrix::displayMatrix()
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

double Matrix::getValue(int row, int col)
{
    return matrix[row][col];
}

Matrix Matrix::add(Matrix &other)
{
    if (other.row_size == row_size && other.col_size == col_size)
    {
        Matrix result(row_size, col_size);
        for (int i = 0; i <= row_size - 1; i++)
        {
            for (int j = 0; j <= col_size - 1; j++)
            {
                result.matrix[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        displayMatrix();
        std::cout << "+" << std::endl;
        other.displayMatrix();
        std::cout << "=" << std::endl;
        result.displayMatrix();
    } else { std::cout << "Sorry, that's not possible" << std::endl; }
}

Matrix Matrix::subtract(Matrix &other)
{
    if (other.row_size == row_size && other.col_size == col_size)
    {
        Matrix result(row_size, col_size);
        for (int i = 0; i <= row_size - 1; i++)
        {
            for (int j = 0; j <= col_size - 1; j++)
            {
                result.matrix[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }
        displayMatrix();
        std::cout << "-" << std::endl;
        other.displayMatrix();
        std::cout << "=" << std::endl;
        result.displayMatrix();
    } else { std::cout << "Sorry, that's not possible" << std::endl; }
}

Matrix Matrix::product(Matrix &other)
{
    if (col_size == other.row_size)
    {
        Matrix result(row_size, other.col_size);
        for (int i = 0; i <= result.row_size - 1; i++)
        {
            for (int j = 0; j <= result.col_size - 1; j++)
            {
                result.matrix[i][j] = 0;
                for (int k = 0; k <= col_size - 1; k++)
                {
                    result.matrix[i][j] = result.matrix[i][j] + (matrix[i][k] * other.matrix[k][j]);
                }
            }
        }
        displayMatrix();
        std::cout << "*" << std::endl;
        other.displayMatrix();
        std::cout << "=" << std::endl;
        result.displayMatrix();
    } else { std::cout << "Sorry, that's not possible" << std::endl; }
}

Matrix Matrix::product(double scalar)
{
    Matrix result(row_size, col_size);
    for (int i = 0; i <= row_size - 1; i++)
    {
        for (int j = 0; j <= col_size - 1; j++)
        {
            result.matrix[i][j] = matrix[i][j] * scalar;
        }
    }
    displayMatrix();
    std::cout << "*" << std::endl;
    std::cout << scalar << std::endl;
    std::cout << "=" << std::endl;
    result.displayMatrix();
}