#ifndef _LAB3_SPLINE_H_
#define _LAB3_SPLINE_H_

#include <bits/stdc++.h>

class Spline 
{
public:
    enum class NodeMode { EquiDistant, Natural };
private:
    std::vector<double> alphaX, betaX, gammaX, deltaX;
    std::vector<double> alphaY, betaY, gammaY, deltaY;
    std::vector<double> paramNodes;
    double computeX(double t) const;
    double computeY(double t) const;
public:
    Spline(NodeMode mode, const std::vector<std::pair<double, double>> &points);
    std::pair<double, double> operator()(double t) const;
};

#endif
