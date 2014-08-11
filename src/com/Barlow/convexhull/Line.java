package com.Barlow.convexhull;


import java.util.ArrayList;

public class Line {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dot d1 = new Dot(2, 5);
		Dot d2 = new Dot(600, 300);
		Dot d3 = new Dot(0, 0);
		Line line = new Line(d1, d2);
		System.out.println(line.tan);
		
	}

	private Dot a;
	private Dot b;
	private double tan;
	private double length;
	public Line(Dot a, Dot b) {
		super();
		this.a = a;
		this.b = b;
		double y = (double)(b.getY() - a.getY());
		double x = (double)(b.getX() - a.getX());
		if (x!= 0) {
			tan = (y/ x);
		}else if(y>0){ 
			tan = 999999999;
		}else if(y<0){ 
			tan = -999999999;
		}
		length = Math.sqrt((b.getY() - a.getY())*(b.getY() - a.getY()) + 
				           (b.getX() - a.getX())*(b.getX() - a.getX()));
	}
	
	
	public Dot getA() {
		return a;
	}


	public void setA(Dot a) {
		this.a = a;
	}


	public Dot getB() {
		return b;
	}


	public void setB(Dot b) {
		this.b = b;
	}


	public double getTan() {
		return tan;
	}




	public double getLength() {
		return length;
	}





	/***************************************************************
	 * 
	 * ��list�еĳ�Ա����tanֵ�Ĵ�С����Ŀ�������
	 * 
	 ***************************************************************/

	public static ArrayList<Line> QuickSort(ArrayList<Line> list, int start,
			int end) {
		int i, j;
		i = start;
		j = end;
		if ((list == null) || (list.size() == 0))
			return list;
		while (i < j) {
			while (i < j && list.get(i).getTan() <= list.get(j).getTan()) { // ������start�±������Ϊkey���Ҳ�ɨ��
				j--;
			}
			if (i < j) { // �Ҳ�ɨ�裬�ҳ���һ����keyС�ģ�����λ��
				Line temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			while (i < j && list.get(i).getTan() < list.get(j).getTan()) { // ���ɨ�裨��ʱa[j]�д洢��keyֵ��
				i++;
			}
			if (i < j) { // �ҳ���һ����key��ģ�����λ��
				Line temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		if (i - start > 1) {
			// �ݹ���ã���keyǰ����������
			QuickSort(list, start, i - 1);
		}
		if (end - j > 1) {
			QuickSort(list, j + 1, end); // �ݹ���ã���key������������
		}
		return list;
	}
	
	
	/***************************************************************
	 * 
	 *ɾ��tanֵһ���ĵ㡣
	 * 
	 ***************************************************************/

	public static ArrayList<Line> DeleteSameTanLines(ArrayList<Line> listLine) {
		for(int i=0; i<listLine.size()-1;i++){
			if(listLine.get(i+1).getTan()==listLine.get(i).getTan()){
				if(listLine.get(i+1).getLength()<=listLine.get(i).getLength()){
					listLine.remove(i+1);
					i--;
				}else{
					listLine.remove(i);
					i--;
				}
			}
		}
		
		
		return listLine;
	}

}
