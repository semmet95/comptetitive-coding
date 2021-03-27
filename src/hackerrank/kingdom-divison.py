class Node:
    def __init__(self, id):
        self.id = id
        self.children = []
        self.taken = False

    def add_child(self, child):
        self.children.append(child)

    def get_children(self):
        return self.children

n = int(input())
nodes = []

for i in range(n+1):
    nodes.append(Node(i))
    
for _ in range(n-1):
    u, v = map(int, input().split())

    nodes[u].add_child(nodes[v])
    nodes[v].add_child(nodes[u])

component_ctr = 0
extra_ways = 0

for node in nodes:
    print(node.id)

    if node.taken or len(node.get_children()) <= 1:
        continue

    component_ctr += 1
    node.taken = True

    all_child_subtree = True

    for child in node.children:
        if len(child.get_children()) == 1:
            child.taken = True
            all_child_subtree = False

    if all_child_subtree:
        extra_ways += 1

print((2 ** component_ctr - 2 * extra_ways) % (10 ** 9 + 7))