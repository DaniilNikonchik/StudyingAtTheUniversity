import sys
import math


class Node:
    def __init__(self, node_id):
        self.id = node_id
        self.adjacent = {}
        self.cost = []
        self.visited = False
        self.parent = None

    def add_neighbor(self, neighbor, weight=0):
        self.adjacent[neighbor] = weight

    def get_connections(self):
        return self.adjacent.keys()

    def get_parent(self):
        return self.parent

    def get_cost(self):
        return self.cost

    def get_connections_all(self):
        return self.adjacent

    def get_id(self):
        return self.id

    def get_weight(self, neighbor):
        return self.adjacent[neighbor]

    def self_visited(self):
        self.visited = True


class Graph:
    def __init__(self):
        self.node_dict = {}
        self.num_nodes = 0
        self.sizes = []

    def __iter__(self):
        return iter(self.node_dict.values())

    def get_node(self, n):
        if n in self.node_dict:
            return self.node_dict[n]
        else:
            return None

    def add_node(self, node):
        self.num_nodes = self.num_nodes + 1
        new_node = Node(node)
        self.node_dict[node] = new_node
        return new_node

    def add_edge(self, frm, to, cost):
        if frm not in self.node_dict:
            self.add_node(frm)
        # if to not in self.node_dict:
        #   self.add_node(to)

        self.node_dict[frm].add_neighbor(self.node_dict[to], cost)
        # self.node_dict[to].add_neighbor(self.node_dict[frm], cost)

        if self.sizes.count(cost) == 0:
            self.sizes.append(cost)

    def get_nodes(self):
        return self.node_dict.keys()


queue = []


def shortest_path(graph, beg, dest):
    way = []
    min_dist = 0
    max_sh = 0
    dist = 0
    while queue:

        dist = dist + 1
        src = queue.pop(0)

        for v in src.get_connections():
            queue.append(v)
            v.parent = src

        if dest.get_parent() != None:
            min_dist = dist
            break

    curr = dest
    while curr.get_parent() != None:
        way.append(curr)
        curr = curr.get_parent()
    way.append(beg)

    max_sh = g.sizes.pop(0)

    for size in g.sizes:

        dist = 0
        queue.clear()
        queue.append(beg)
        while queue:

            dist = dist + 1
            src = queue.pop(0)

            for v in src.get_connections():
                if src.get_weight(v) >= size:
                    queue.append(v)
                    v.parent = src

            if dest.get_parent() != None:
                break

        if dest.get_parent() == None:
            break

        if dist > min_dist:
            break

        max_sh = size
        way.clear()
        curr = dest
        while curr.get_parent() != None:
            way.append(curr)
            curr = curr.get_parent()
        way.append(beg)
        dest.parent = None

    way.reverse()
    s = 0
    print("Shortest path: ")
    while s < len(way) - 1:
        print(way[s].get_id() + " -> " + way[s + 1].get_id())
        s = s + 1
    print("Its weight: " + str(max_sh))


def widest_path(graph, dest):
    while queue:

        src = queue.pop(0)

        for v in src.get_connections():
            queue.append(v)
            dist = max(v.cost, min(src.get_weight(v), src.cost))
            if dist > v.cost:
                v.cost = dist
                v.parent = src
                # print(str(src.get_id())+" "+str(v.get_id())+" "+str(v.cost)+" "+str(src.get_id()))


def path(src, current):
    print("Widest Cost : " + str(current.get_cost()))
    list = []
    while src.get_id() != current.get_id():
        print()
        list.append(str(current.get_parent().get_id() + " -> " + str(current.get_id())))
        current = current.get_parent()
    for i in reversed(list):
        print(i)


if __name__ == '__main__':

    g = Graph()

    g.add_node('1')
    g.add_node('2')
    g.add_node('3')
    g.add_node('4')
    g.add_node('5')
    g.add_node('6')
    g.add_node('7')

    g.add_edge('1', '7', 15)
    g.add_edge('6', '4', 15)
    g.add_edge('6', '7', 12)
    g.add_edge('7', '2', 12)
    g.add_edge('6', '2', 10)
    g.add_edge('6', '3', 10)
    g.add_edge('3', '2', 10)
    g.add_edge('3', '7', 5)
    g.add_edge('3', '5', 5)
    g.add_edge('6', '1', 5)
    g.add_edge('4', '5', 2)
    g.add_edge('5', '1', 2)

    g.sizes.sort()
    g.get_node('6').cost = math.inf
    for node in g:
        for n in node.get_connections():
            n.cost = -math.inf
    queue.append(g.get_node('6'))

    dest = g.get_node('2')
    src = g.get_node('6')
    shortest_path(g, src, dest)
