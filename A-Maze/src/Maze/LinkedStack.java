package Maze;

import SinglyList.SinglyList;

public final class LinkedStack<T> implements Stack<T> {
	private SinglyList<T> list;//使用单链表存储栈元素
	
	public LinkedStack(){//构造空栈
		this.list = new SinglyList<T>();//构造空单链表
	}
	
	public boolean isEmpty(){//判断栈是否为空，若空返回true
		return this.list.isEmpty();
	}
	
	public void push(T x){//元素x入栈，空对象不能入栈
		this.list.insert(0,x);//单链表头插入元素x
	}
	
	public T peek(){//返回栈顶元素（未出栈），若栈为空返回null
		return this.list.get(0);
	}
	
	public T pop(){//若栈不为空，单链表头删除，返回删除元素
		return this.list.remove(0);
	}
}
