// package com.chuck.common.domain;

// import java.util.ArrayList;
// import java.util.List;

// /**
//  * @author Chuck
//  * @since 2/28/2021
//  * @version
//  *
//  *          基于无序链表的顺序查找
//  **/
// public class SequentialSearchTree<Key, Value> {
//     Node<Key, Value> first;

//     public Value get(Key key) {
//         for (Node<Key, Value> x = this.first; x != null; x = x.next) {
//             // TODO
//             // if (x.key.equals(key))
//             // return x.value;
//         }
//         return null;
//     }

//     public void put(Key key, Value value) {
//         for (Node<Key, Value> x = this.first; x != null; x = x.next) {
//             if (key.equals(x.key)) {
//                 x.value = value;
//                 return;
//             }
//         }
//         this.first = new Node<Key, Value>(key, value, this.first);
//     }

//     public int size() {
//         int i = 0;
//         for (Node<Key, Value> x = first; x != null; x = x.next) {
//             i++;
//         }
//         return i;
//     };

//     public List<Key> keys() {
//         List<Key> keys = new ArrayList<>();
//         for (Node x = first; x != null; x = x.next) {
//             // TODO
//             // keys.add(x.key);
//         }
//         return keys;
//     };

//     public void delete(Key key) {
//         if (key.equals(first.key)) {
//             this.first = first.next;
//             return;
//         }
//         Node pre = this.first;
//         for (Node x = first.next; x != null; x = x.next) {
//             if (x.key.equals(key)) {
//                 pre.next = x.next;
//                 return;
//             }
//             pre = x;
//         }
//     };
// }

// class Node<Key, Value> {
//     // Node<Key,Value> pre;//双向链表
//     Node<Key, Value> next;
//     Key key;
//     Value value;

//     public Node(Key key, Value value, Node<Key, Value> next) {
//         this.key = key;
//         this.value = value;
//         this.next = next;
//     }
// }