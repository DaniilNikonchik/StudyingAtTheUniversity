#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#pragma warning(disable:4996)

using namespace std;


struct Edge {
	long long end;
	long long weight;
	Edge(int _end, int _weight)
	{
		end = _end;
		weight = _weight;
	}
	Edge()
	{
		end = 0;
		weight = 0;
	}
};

struct QueueElement {
	long long w;
	long long vertex;
	long long pred;
	QueueElement()
	{
		w = 0;
		vertex = 0;
		pred = -1;
	}
	QueueElement(long long _vertex, long long _w, long long _pred)
	{
		vertex = _vertex;
		w = _w;
		pred = _pred;
	}
};

class Comparator {
public:
	bool operator()(QueueElement& a, QueueElement& b) {
		return a.w > b.w;
	};
};

int main()
{
	freopen("input.in", "r", stdin);
	freopen("output.out", "w", stdout);
	//long long n, m;
	//cin >> n >> m;
	long long begin, end;
	cin >> begin >> end;
	vector<Edge>* edges = new vector<Edge>[begin];//список смежности
	long long u, v, w;
	Comparator comp;
	for (long long i = 0; i < end; i++)
	{
		cin >> u >> v >> w;
		edges[u - 1].push_back(Edge(v - 1, w));
		edges[v - 1].push_back(Edge(u - 1, w));
	}
	long long* isVisited = new long long[begin];
	long long* distances = new long long[begin];
	for (int i = 0; i < begin; i++)
	{
		isVisited[i] = -1;
		distances[i] = LLONG_MAX;
	}
	priority_queue<QueueElement, vector<QueueElement>, Comparator> s(comp);
	s.push(QueueElement(begin - 1, 0, -2));
	QueueElement top;
	while (!s.empty())
	{
		top = s.top();
		s.pop();
		if (isVisited[top.vertex] != -1)
			continue;
		isVisited[top.vertex] = top.pred;
		distances[top.vertex] = top.w;
		/*if (top.vertex == end - 1)
			break;*/
		for (int i = 0; i < edges[top.vertex].size(); i++)
		{
			if (isVisited[edges[top.vertex][i].end] == -1 && top.w + edges[top.vertex][i].weight + edges[edges[top.vertex][i].end].size() < distances[edges[top.vertex][i].end])
				s.push(QueueElement(edges[top.vertex][i].end, top.w + edges[top.vertex][i].weight + edges[edges[top.vertex][i].end].size(), top.vertex));
		}
	}
	cout << distances[end - 1] - edges[end - 1].size() << endl;
	vector<long long> path;
	long long vertex = end - 1;
	while (vertex != -2)
	{
		path.push_back(vertex);
		vertex = isVisited[vertex];
	}
	for (int i = path.size() - 1; i >= 0; i--)
		cout << path[i] + 1 << " ";
}