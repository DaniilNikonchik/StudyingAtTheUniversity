#pragma once

class money {
private:
	bool minus;
	double pennyValue;
	long long pound;
	long long shilling;
	double penny;
	money(double pennyValue);
	void setPennyValue(double);
	double getPennyValue() const;

public:
	money();
	money(long long pound, long long shilling, double penny);

	friend bool operator== (const money& p, const money& p1);
	friend bool operator!= (const money& p, const money& p1);
	friend bool operator> (const money& p, const money& p1);
	friend bool operator< (const money& p, const money& p1);
	friend bool operator>= (const money& p, const money& p1);
	friend bool operator<= (const money& p, const money& p1);

	void Print();
	double ConverToPenny(long long pound, long long shilling, double penny);
	void PennyConvert(double& pennyValue);

	money operator - () const;
	money operator + (const money& p) const;
	money operator - (const money& p) const;
	money& operator += (const money& p);
	money& operator -= (const money& p);
};

bool operator== (const money& p, const money& p1);
bool operator!= (const money& p, const money& p1);
bool operator> (const money& p, const money& p1);
bool operator< (const money& p, const money& p1);
bool operator>= (const money& p, const money& p1);
bool operator<= (const money& p, const money& p1);