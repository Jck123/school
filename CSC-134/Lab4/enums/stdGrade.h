#include <string>
namespace stdGrade
{
    enum letter_grade {A, A_PLUS, A_MINUS, B, B_PLUS, B_MINUS, C, C_PLUS, C_MINUS, D, D_PLUS, D_MINUS, F};
    letter_grade deriveGrade(double average);
    std::string convertToText(letter_grade grade);
}

using namespace stdGrade;

letter_grade stdGrade::deriveGrade (double average)       //Calculates average using if statements
{
    if (average >= 97.0) {return A_PLUS;}
    else if (average >= 93.0 && average < 97.0) {return A;}
    else if (average >= 90.0 && average < 93.0) {return A_MINUS;}
    else if (average >= 87.0 && average < 90.0) {return B_PLUS;}
    else if (average >= 83.0 && average < 87.0) {return B;}
    else if (average >= 80.0 && average < 83.0) {return B_MINUS;}
    else if (average >= 77.0 && average < 80.0) {return C_PLUS;}
    else if (average >= 73.0 && average < 77.0) {return C;}
    else if (average >= 70.0 && average < 73.0) {return C_MINUS;}
    else if (average >= 67.0 && average < 70.0) {return D_PLUS;}
    else if (average >= 63.0 && average < 67.0) {return D;}
    else if (average >= 60.0 && average < 63.0) {return D_MINUS;}
    else if (average < 60.0) {return F;}
}

std::string stdGrade::convertToText(letter_grade grade)        //Converts enum value to string value using switch statement
{
    switch(grade)
    {
        case A_PLUS:
            return "A+";
            break;
        case A:
            return "A";
            break;
        case A_MINUS:
            return "A-";
            break;
        case B_PLUS:
            return "B+";
            break;
        case B:
            return "B";
            break;
        case B_MINUS:
            return "B-";
            break;
        case C_PLUS:
            return "C+";
            break;
        case C:
            return "C";
            break;
        case C_MINUS:
            return "C-";
            break;
        case D_PLUS:
            return "D+";
            break;
        case D:
            return "D";
            break;
        case D_MINUS:
            return "D-";
            break;
        case F:
            return "F";
            break;
    }
}