goal = [0,4]


def get_state(state,m):
    temp = state.copy()
    if m == "p35":
        rem_cap = 5-temp[1]
        if (temp[0]>rem_cap):
            temp[0]-=rem_cap
            temp[1] = 5
        else:
            temp[1]+=temp[0]
            temp[0] = 0
    if m == "p53":
        rem_cap = 3-temp[0]
        if temp[1] > rem_cap:
            temp[1]-=rem_cap
            temp[0] = 3
        else:
            temp[0]+=temp[1]
            temp[1] = 0
    if m == "f3":
        temp[0] = 3
    if m == "f5":
        temp[1] = 5
    if m == "e3":
        temp[0] = 0
    if m == "e5":
        temp[1] = 0
    
    return temp

def get_next_states(cur_state,visited):
    # Moves:
    # 1. pour from 3 to 5 (p35)
    # 2. pour from 5 to 3 (p53)
    # 3. fill/empty 5 (f5/e)
    # 4. fill/empty 3 (f3)
    move_lst = []

    if cur_state[0] + cur_state[1] > 0 and cur_state[1] < 5:
        move_lst.append("p35")

    if cur_state[1] + cur_state[0] > 0 and cur_state[0] < 3:
        move_lst.append("p53")
    if cur_state[0] < 3:
        move_lst.append("f3")

    if cur_state[1] < 5:
        move_lst.append("f5")

    if cur_state[0] > 0:
        move_lst.append("e3")

    if cur_state[1] > 0:
        move_lst.append("e5")

    moves = []
    for move in move_lst:
        moves.append(get_state(cur_state,move))

    return [m for m in moves if m not in visited]


def bfs(initial_state):
    queue = []
    queue.append(initial_state)
    visited = []
    count = 0

    while (len(queue)>0):
        cur_state = queue.pop(0)
        count+=1
        if (cur_state==goal):
            print(count)
            print("Success")
            break
        else:
            next_states = get_next_states(cur_state,visited)
            for state in next_states:
                queue.append(state)
if __name__ == "__main__":
    # index 0: Water of 3L jug
    # index 1: Water of 5L jug
    initial_state = [0,0]
    bfs(initial_state)