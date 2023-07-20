#include <bits/stdc++.h>
#include "spline.h"

std::vector<std::pair<double, double>> points = 
{
    { -3.80556, -3.55556 }, { -3.91667,  3.11111 }, { -3.55556,  4.00000 },
    { -3.13889,  3.19444 }, { -2.80556,  4.02778 }, { -2.36111,  3.22222 },
    {  3.08333,  3.36111 }, {  3.80556,  2.69444 }, {  3.11111,  2.38889 },
    {  3.88889,  2.11111 }, {  3.16667,  1.55556 }, {  2.88889, -3.11111 }
};

const int MaxPoints = 100;

void
printSpline(const Spline &spline)
{
    for (int i = 0; i <= MaxPoints; ++i) {
        auto point = spline((double)i / MaxPoints);
        std::cout << "(" << point.first << ", " << point.second << ")\n";
    }
}

int
main()
{
    Spline firstSpline(Spline::NodeMode::EquiDistant, points);
    Spline secondSpline(Spline::NodeMode::Natural, points);
    std::cout << "EquiDistant points spline:\n"; 
    printSpline(firstSpline);
    std::cout << "Natural points spline:\n";
    printSpline(secondSpline);
}
