#include <string>
namespace stdGrade
{
    enum letter_grade {A, A_PLUS, A_MINUS, B, B_PLUS, B_MINUS, C, C_PLUS, C_MINUS, D, D_PLUS, D_MINUS, F};
    letter_grade deriveGrade(double average);
    std::string convertToText(letter_grade grade);
}