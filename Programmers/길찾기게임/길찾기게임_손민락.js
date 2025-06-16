class Node {
    constructor(index, x, y) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    constructor(root) {
        this.root = root;
    }
    
    insert(index, x, y) {
        const newNode = new Node(index, x, y);
        let curNode = this.root;
        
        while (true) {
            if (x < curNode.x) {
                if (curNode.left === null) {
                    curNode.left = newNode;
                    break;
                } else {
                    curNode = curNode.left;
                }
            } else {
                if (curNode.right === null) {
                    curNode.right = newNode;
                    break;
                } else {
                    curNode = curNode.right;
                }
            }
        }
    }
}

function preorder(node, path) {
    path.push(node.index);
    if (node.left) {
        preorder(node.left, path);
    }
    if (node.right) {
        preorder(node.right, path);
    }
}

function postorder(node, path) {
    if (node.left) {
        postorder(node.left, path);
    }
    if (node.right) {
        postorder(node.right, path);
    }
    path.push(node.index);
}

function solution(nodeinfo) {
    var answer = [[], []];
    
    const nodesWithIndex = nodeinfo.map((pos, idx) => ({
        index: idx + 1,
        x: pos[0],
        y: pos[1]
    }));
    
    nodesWithIndex.sort((a, b) => b.y - a.y);
    
    const root = nodesWithIndex[0];
    const binaryTree = new BinaryTree(new Node(root.index, root.x, root.y));
    
    for (let i = 1; i < nodesWithIndex.length; i++) {
        const node = nodesWithIndex[i];
        binaryTree.insert(node.index, node.x, node.y);
    }
    
    preorder(binaryTree.root, answer[0]);
    postorder(binaryTree.root, answer[1]);
    
    return answer;
}