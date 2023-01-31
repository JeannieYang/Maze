package Maze;

import SinglyList.SinglyList;

public final class LinkedStack<T> implements Stack<T> {
	private SinglyList<T> list;//ʹ�õ�����洢ջԪ��
	
	public LinkedStack(){//�����ջ
		this.list = new SinglyList<T>();//����յ�����
	}
	
	public boolean isEmpty(){//�ж�ջ�Ƿ�Ϊ�գ����շ���true
		return this.list.isEmpty();
	}
	
	public void push(T x){//Ԫ��x��ջ���ն�������ջ
		this.list.insert(0,x);//������ͷ����Ԫ��x
	}
	
	public T peek(){//����ջ��Ԫ�أ�δ��ջ������ջΪ�շ���null
		return this.list.get(0);
	}
	
	public T pop(){//��ջ��Ϊ�գ�������ͷɾ��������ɾ��Ԫ��
		return this.list.remove(0);
	}
}
