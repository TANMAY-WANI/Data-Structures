goal_state =  [1,2,3,4,5,6,7,8,0]

def generate_state(state,m,b):
    temp = state.copy()                              
    
    if m=='d':
        temp[b+3],temp[b] = temp[b],temp[b+3]
    
    if m=='u':
        temp[b-3],temp[b] = temp[b],temp[b-3]
    
    if m=='l':
        temp[b-1],temp[b] = temp[b],temp[b-1]
    
    if m=='r':
        temp[b+1],temp[b] = temp[b],temp[b+1]
        
    return temp

def get_moves(state,visited):
    idx = state.index(0)
    possible_moves = []
    if idx not in [0,1,2]:
        possible_moves.append('u')
    if idx not in [0,3,6]:
        possible_moves.append('l')
    if idx not in [6,7,8]:
        possible_moves.append('d')
    if idx not in [2,5,8]:
        possible_moves.append('r')


    moves = []
    for move in possible_moves:
        moves.append(generate_state(state,move,idx))

    return [m for m in moves if m not in visited]


def bfs(initial_state):
    queue = []
    queue.append(initial_state)
    visited = []

    while (len(queue)>0):
        cur_state = queue.pop(0)
        visited.append(cur_state)
        print(cur_state)
        if cur_state== goal_state:
            print("Success")
            return 
        
        moves = get_moves(cur_state,visited)

        for move in moves:
            if move not in queue:
                queue.append(move)

def dfs(initial_state):
    stack = []
    stack.append(initial_state)
    visited = []

    while (len(stack)>0):
        cur_state = stack.pop(-1)
        visited.append(cur_state)
        print(cur_state)
        if cur_state== goal_state:
            print("Success")
            return 
        
        moves = get_moves(cur_state,visited)
        for move in moves:
            if move not in stack:
                stack.append(move)
if __name__ == "__main__":
    state = [1,2,3,8,0,4,7,5,6]
    bfs(state)
    # dfs(state)