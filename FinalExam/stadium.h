#include <seat.h>
using namespace std;

class Stadium
{
    Seat seatArr[1000];
    string stadiumName;
    int occSeats;

    public:

    Stadium(string stadiumName);
    void assignSeat(double seatNumber, string customerName);
    void unAssignedSeat(int seatNumber);
    int getNumberOfAssignedSeats();
    double getCostOfSeat(double seatNumber);
};