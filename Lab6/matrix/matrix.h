//////////////////////////////////////////////////////////////////////////
// Filename: matrix.h                                                   //
// Date: May 1, 2020                                                    //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This file creates the matrix class and all its operations       //
//////////////////////////////////////////////////////////////////////////
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