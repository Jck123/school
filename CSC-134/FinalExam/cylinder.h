#include <string>
using namespace std;
class Cylinder
{
public:
    Cylinder(double initial_radius, double initial_height, string initial_color);
    double get_radius() const;
    double get_height() const;
    string get_color() const;
    double get_volume() const; 
private:
    double radius;
    double height;
    string color;
};