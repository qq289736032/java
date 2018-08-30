package 面试题5_从头到尾打印链表;

import java.util.LinkedList;

/**
 * Created by jisen on 2018/6/6.
 */
public class ListNode<E> {
    //定义一个节点
    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;


        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> last;
    Node<E> first;
    int size=0;

    //普通的插入,即插到尾部
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        //modCount++;
    }

    //从中间一个位置插入一个节点
    void linkBefore(int index,E element){
        //第一步先找到那个位置,再在这个位置的前一个位置插入
        Node<E> currentNode;
        if (index < (size >> 1)) {//右移一位,取中间,如果在左半边则把第一个元素赋值给当前临时节点
            currentNode = first;
            for (int i = 0; i < index; i++)//循环取出该位置节点
                currentNode = currentNode.next;
        } else {
            currentNode = last;
            for (int i = size - 1; i > index; i--)//从后面开始遍历从size-1开始,
                currentNode = currentNode.prev;
        }
        //插入动作,先断开(临时节点容器),后链接
        Node<E> pred = currentNode.prev;//temp节点
        Node<E> newNode = new Node<>(pred, element, currentNode);//新节点
        currentNode.prev = newNode;//新节点放到当前
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        //modCount++;
    }

    void linkFirst(E e){
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        //modCount++;
    }

    //从第一个移除

    public static void main(String[] args) {
        new LinkedList().add(1);
        new LinkedList().add(1,1);
        new LinkedList().addFirst(1);
        new LinkedList().remove();

    }

}
