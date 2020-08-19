#include "cylinderDriver.h"
#include <iostream>
using namespace std;

int main()
{
    Cylinder cyl(3, 4, "blue");
    cout << cyl.get_height() << endl;
    cout << cyl.get_radius() << endl;
    cout << cyl.get_color() << endl;
    cout << cyl.get_volume() << endl;
}