#include <time.h>
#include <stdlib.h>

const int maxRowSize = 5;
const int maxColSize = 5;

class Matrix
{
    static int cnt;

    int row_size;
    int col_size;
    double matrix[maxRowSize][maxColSize];

    public:
    Matrix();
    Matrix(int row, int column);
    void setRowSize(int x);
    void setColumnSize(int x);
    void addValue(double x);
    static int getCnt();
    int getRowSize();
    int getColumnSize();
    void displayMatrix();
    double getValue(int row, int col);
    Matrix add(Matrix &other);
    Matrix subtract(Matrix &other);
    Matrix product(Matrix &other);
    Matrix product(double scalar);
};

Matrix::Matrix()
{
    cnt++;
    srand(time(NULL));

    row_size = 5;
    col_size = 5;
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
    cnt++;
    srand(time(NULL));

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
}

void Matrix::setRowSize(int x)
{
    double matrix1[x][col_size];     //Placeholder for old matrix, deleted once new matrix made and function is complete
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
            matrix[i][j] = matrix1[i][j];
        }
    }
    row_size = x;
}

void Matrix::setColumnSize(int x)
{
    double matrix1[row_size][x];                //Placeholder for old matrix, deleted once new matrix made and function is complete
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
            matrix[i][j] = matrix1[i][j];
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
    return cnt;
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

}

double Matrix::getValue(int row, int col)
{
    return matrix[row][col];
}

Matrix add(Matrix &other)
{

}

Matrix subtract(Matrix &other)
{

}

Matrix product(Matrix &other)
{

}

Matrix product(double scalar)
{

}