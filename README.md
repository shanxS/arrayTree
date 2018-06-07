# arrayTree

Problem statement: Efficient search/insertion/deletion in ordered data.
BST: Need to be balanced for best time compexity and CPU lookahead/branch prediction is not used well.
Sorted array/arrayList: Insertion/deletion is time consuming although CPU lookahead/branch prediction helps in faster searches.

Suggested solution:

ArrayTree, its a hybrid form of ArrayList. Idea is to have linked list of arrays of fixed size. Each node in array will contain
... well it will be the Node class. Having items in array will help in utilisation of CPU cache.

insertion
    worst case  O(n), CPU cache useless
    average case O(logn)

deletion
    worst case  O(n), CPU cache useless
    average case O(logn)

search
    worst case  O(n), CPU cache useless
    average case O(logn)

Pausing / giving up for now because impl is getting too complicated, increasing surface area for bugs. Will come back to it
sometime in future.