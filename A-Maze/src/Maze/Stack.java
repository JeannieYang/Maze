package Maze;

public interface Stack<T> {//栈接口，描述栈抽象数据类型，T表示数据元素的数据类型
	public abstract boolean isEmpty();//判断栈是否为空
	public abstract void push(T x);//元素x入栈
	public abstract T peek();//返回栈顶元素（未出栈）
	public abstract T pop();//出栈，返回栈顶元素
}
