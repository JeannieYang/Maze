package Maze;

public interface Queue<T> {//���нӿڣ��������г����������ͣ�T��ʾ����Ԫ�ص���������
	public abstract boolean isEmpty();//�ж϶����Ƿ�Ϊ��
	public abstract boolean add(T x);//Ԫ��x��ӣ�����ӳɹ��򷵻�true�����򷵻�false
	public abstract T peek();//���ض�ͷԪ�أ�û��ɾ����������Ϊ�գ��򷵻�null
	public abstract T poll();//���ӣ����ض�ͷԪ�ء�����ͷ�գ��򷵻�null
}
