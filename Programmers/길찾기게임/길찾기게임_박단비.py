import sys

sys.setrecursionlimit(10 ** 9)

# 트리 구성하기
# key : 노드의 인덱스
# value : [(node의x 좌표, node의 y좌표), 왼쪽 자식 인덱스, 오른쪽 자식 인덱스]

L, R = 1, 2


def insert(tree, node, parent_idx):
    idx, x, y = node
    (p_x, p_y), left, right = tree[parent_idx]

    if p_x < x:  # 현재 노드 기준 오른쪽으로 삽입되어야하는 노드의 경우
        if right != 0:
            insert(tree, node, right)
        else:
            tree[parent_idx][R] = idx
            tree[idx] = [(x, y), 0, 0]

    else:  # 현재 노드 기준으로 왼쪽으로 삽입되어야하는 노드의 경우
        if left != 0:
            insert(tree, node, left)
        else:
            tree[parent_idx][L] = idx
            tree[idx] = [(x, y), 0, 0]


# 전위순회
def pre_order(tree, node_idx):
    path = []
    if node_idx == 0:
        return path

    path.append(node_idx)
    path += pre_order(tree, tree[node_idx][L])
    path += pre_order(tree, tree[node_idx][R])

    return path


# 후위순회
def post_order(tree, node_idx):
    path = []

    if node_idx == 0:
        return path

    path += post_order(tree, tree[node_idx][L])
    path += post_order(tree, tree[node_idx][R])
    path.append(node_idx)

    return path


def solution(nodeinfo):
    answer = []
    sorted_node_info = []
    for idx, [x, y] in enumerate(nodeinfo, 1):
        sorted_node_info.append([idx, x, y])

    sorted_node_info.sort(key=lambda x: x[2])  # y값 기준으로 정렬

    tree = dict()
    root_idx, root_x, root_y = sorted_node_info.pop()
    tree[root_idx] = [(root_x, root_y), 0, 0]

    while sorted_node_info:
        node = sorted_node_info.pop()
        insert(tree, node, root_idx)
    answer = [pre_order(tree, root_idx), post_order(tree, root_idx)]
    return answer