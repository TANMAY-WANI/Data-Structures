import networkx as nx
import matplotlib.pyplot as plt
def aStar(G,start,end):
    closedSet = set()
    openSet = set(G.nodes())
    neighbours= G.neighbors(start)
    costs={}
    current = start
    for node in neighbours:
        print(G.nodes[node])
        costs[node] = G.edges[current,node]['weight']+G.nodes[node]['heuristic']
    openSet.remove(start)
    closedSet.add(start)
    while openSet:
        minNode = min(costs, key=costs.get)
        neighbours = G.neighbors(minNode)
        for node in neighbours:
            if node in closedSet:
                continue
            costs[node] = G.edges[minNode,node]['weight']+G.nodes[node]['heuristic']
        openSet.remove(minNode)
        closedSet.add(minNode)
        if minNode == end:
            break
    return closedSet
G = nx.Graph()
G.add_node(0,heuristic=10)
G.add_node(1,heuristic=8)
G.add_node(2,heuristic=7)
G.add_node(3,heuristic=3)
G.add_node(4,heuristic=6)

G.add_edge(0,1,weight=1) 
G.add_edge(0,2,weight=2)
G.add_edge(1,3,weight=3)
G.add_edge(1,4,weight=4)
G.add_edge(2,3,weight=5)
G.add_edge(2,4,weight=6)
G.add_edge(3,4,weight=7)

print("The graph is: ")
print(G.nodes())
print("Weights")
print(G.edges(data=True))
# Draw the graph with hueristic and weights
pos = nx.spring_layout(G)
nx.draw(G,pos,with_labels=True)
labels = nx.get_edge_attributes(G,'weight')
heuristic = nx.get_node_attributes(G, 'heuristic')
nx.draw_networkx_edge_labels(G, pos, edge_labels=labels)
heuristicPos = {k:[v[0]-0.1,v[1]] for k,v in pos.items()}
nx.draw_networkx_labels(G, heuristicPos, font_color='g' , labels=heuristic)

# show the path
path = aStar(G,0,3)
print(f"The path is: {path}")
# nx.draw_networkx_edges(G,pos,edgelist=[(path[i],path[i+1]) for i in range(len(path)-1)],width=5,edge_color='r')
plt.show()

