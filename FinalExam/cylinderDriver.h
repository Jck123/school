#include "cylinder.h"

Cylinder::Cylinder(double initial_radius, double initial_height, string initial_color)
{
    radius = initial_radius;
    height = initial_height;
    color = initial_color;
}

double Cylinder::get_radius() const
{
    return radius;
}

double Cylinder::get_height() const
{
    return height;
}

string Cylinder::get_color() const
{
    return color;
}

double Cylinder::get_volume() const
{
    return 3.1415 * get_radius() * get_radius() * get_height();
}