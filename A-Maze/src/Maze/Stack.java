package Maze;

public interface Stack<T> {//ջ�ӿڣ�����ջ�����������ͣ�T��ʾ����Ԫ�ص���������
	public abstract boolean isEmpty();//�ж�ջ�Ƿ�Ϊ��
	public abstract void push(T x);//Ԫ��x��ջ
	public abstract T peek();//����ջ��Ԫ�أ�δ��ջ��
	public abstract T pop();//��ջ������ջ��Ԫ��
}