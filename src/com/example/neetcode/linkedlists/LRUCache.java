package com.example.neetcode.linkedlists;

/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the
 key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.*/


/*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
*/

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer,LRUListNode> cache;
    LRUListNode head;
    LRUListNode tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        cache = new HashMap<>(capacity);
    }
    public void put(int key, int value){
        if(cache.containsKey(key)){
            //Get the node from cache.get(key)
            LRUListNode found =  cache.get(key);
            // if the node is the tail node
            if(found==tail){
                found.value=value;
                return;
            }
            removeFromtheExisitingPosition(found);
            // Move this node to the MRU end of the list (remove from its current place, then add to MRU)
            addAtTheTail(found);
            // Update node.value
            tail.value=value;
        }else{
            LRUListNode lruListNode = new LRUListNode(key,value);
            if(head==null) {
                head = lruListNode;
                head.prev=null;
                head.next=null;
                tail=head;
            }else
                addAtTheTail(lruListNode);
            cache.put(key,lruListNode);
            if(cache.size()>capacity){
                cache.remove(head.key);
                head = head.next;
                if(head!=null)
                    head.prev=null;
                else
                    tail=null;
            }
        }
    }

    private void removeFromtheExisitingPosition(LRUListNode node) {
        // if the node is the first node
        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    private void addAtTheTail(LRUListNode found) {
        tail.next = found;
        found.next = null;
        found.prev=tail;
        tail= found;
    }


    public int get(int key){
        if(cache.containsKey(key)){
            LRUListNode lruListNode =  cache.get(key);
            if(lruListNode==tail){
                return tail.value;
            }
            removeFromtheExisitingPosition(lruListNode);
            addAtTheTail(lruListNode);
            return tail.value;
        }
        return -1;
    }
}
class LRUListNode{
    int key;
    int value;
    LRUListNode next;
    LRUListNode prev;

    public LRUListNode() {
    }

    public LRUListNode(int key , int value){
        this.key=key;
        this.value=value;
    }
}