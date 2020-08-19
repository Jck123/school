#include <iostream>
using namespace std;

void calcTemplate(int num1, int num2, int &sum, int &diff)
{
    sum = num1 + num2;
    diff = num1 - num2;
}

int main()
{
    int sum = 0, diff = 0;
    int num1 = 10;
    int num2 = 3;
    calcTemplate(num1, num2, sum, diff);
    cout << sum << endl;
    cout << diff << endl;
}