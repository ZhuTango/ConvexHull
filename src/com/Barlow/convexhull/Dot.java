package com.Barlow.convexhull;


import java.util.ArrayList;

public class Dot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dot d0 = new Dot(44, 409);
		Dot d1 = new Dot(297, 93);
		Dot d2 = new Dot(333, 270);
		Dot d3 = new Dot(541, 339);
		Dot d4 = new Dot(1, 1);
		Dot d5 = new Dot(0, 0);
		
		
		System.out.println(IsInside(d0, d1, d2, d3));
		System.out.println(IsInside(d0, d2, d1, d3));
		System.out.println(IsInside(d1, d0, d2, d3));
		System.out.println(IsInside(d1, d2, d0, d3));
		System.out.println(IsInside(d2, d0, d1, d3));
		System.out.println(IsInside(d2, d1, d0, d3));
		System.out.println(IsInside(d3, d2, d0, d1));
		System.out.println(Inside(d2, d3, d1, d0));
	}

	private int x;
	private int y;
	private boolean flag;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.flag = false;
	}
	
	/***************************************************************
	 * 
	 * d2d0这条线是否在d1d0这条线逆时针上方，在上方则返回true
	 * 
	 ***************************************************************/
	public static boolean IsUp(Dot d0, Dot d1, Dot d2) {
		int x0 = d0.getX();
		int y0 = d0.getY();
		int x1 = d1.getX();
		int y1 = d1.getY();
		int x2 = d2.getX();
		int y2 = d2.getY();
		boolean isUp;
		if ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0) {
			isUp = true;
		} else {
			isUp = false;
		}
		return isUp;
	}
	
	/***************************************************************
	 * 
	 * 随机产生n个点。
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> GenerateDots(int n) {
		ArrayList<Dot> list = new ArrayList<Dot>();
		for (int i = 0; i < n; i++) {
			Dot a = new Dot((int) (Math.random() * 1040),
					(int) (Math.random() * 1350));
			list.add(a);
		}

		return list;
	}
	/***************************************************************
	 * 
	 * 是否为同一个点。
	 * 
	 ***************************************************************/
	
	public static boolean IsSameDot(Dot a, Dot b){
		if(a.getX()==b.getX()&&a.getY()==b.getY()){
			return true;
		}else{
			return false;
		}
	}

	/***************************************************************
	 * 
	 * d1d0和d2d0是否共线，共线则返回true
	 * 
	 ***************************************************************/
	public static boolean IsColineation(Dot d0, Dot d1, Dot d2) {
		int x0 = d0.getX();
		int y0 = d0.getY();
		int x1 = d1.getX();
		int y1 = d1.getY();
		int x2 = d2.getX();
		int y2 = d2.getY();
		boolean isColineation;
		if ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0) {

			isColineation = true;// 斜线共线

		} else {

			isColineation = false;// 斜线不共线

		}
		return isColineation;
	}
	/***************************************************************
	 * 
	 * 返回三点的中点。
	 * 
	 ***************************************************************/
	public static int GetMiddleDot(Dot d1, Dot d2, Dot d3) {
		int i = 0;
		if (((d2.getX() - d1.getX()) == 0) && ((d3.getX() - d1.getX()) == 0)) {
			if ((d1.getY() < d2.getY() && d1.getY() > d3.getY())
					|| (d1.getY() > d2.getY() && d1.getY() < d3.getY())) {
				i = 1;
			} else if ((d2.getY() < d1.getY() && d2.getY() > d3.getY())
					|| (d2.getY() > d1.getY() && d2.getY() < d3.getY())) {
				i = 2;
			} else if ((d3.getY() < d2.getY() && d3.getY() > d1.getY())
					|| (d3.getY() > d2.getY() && d3.getY() < d1.getY())) {
				i = 3;
			}
		} else {
			if ((d1.getX() < d2.getX() && d1.getX() > d3.getX())
					|| (d1.getX() > d2.getX() && d1.getX() < d3.getX())) {
				i = 1;
			} else if ((d2.getX() < d1.getX() && d2.getX() > d3.getX())
					|| (d2.getX() > d1.getX() && d2.getX() < d3.getX())) {
				i = 2;
			} else if ((d3.getX() < d2.getX() && d3.getX() > d1.getX())
					|| (d3.getX() > d2.getX() && d3.getX() < d1.getX())) {
				i = 3;
			}
		}
		return i;
	}
	
	/***************************************************************
	 * 
	 * 判断四个点是否有一个点在其他三个点构成的三角形之内，如果有，返回true，没有返回false。
	 * 
	 ***************************************************************/
	public static boolean IsInside(Dot d1, Dot d2, Dot d3, Dot d4) {
		boolean inside = false;

		if (IsUp(d1, d2, d4) && IsUp(d2, d3, d4) && IsUp(d3, d1, d4)) {
			inside = true;// 如果d4都在d1、d2、d3组成的三条线的逆时针上方，则d4在三角形内
		} else if (!IsUp(d1, d2, d4) && !IsUp(d2, d3, d4) && !IsUp(d3, d1, d4)) {
			inside = true;
		}
		

		return inside;
	}
	
	/***************************************************************
	 * 
	 * 判断四个点是否有一个点在其他三个点构成的三角形之内，如果没有，返回0，如果有则返回相应的序号。
	 * 
	 ***************************************************************/
	public static int Inside(Dot d1, Dot d2, Dot d3, Dot d4) {
		int i = 0;

		if (IsInside(d1, d2, d3, d4)) {
			i = 4;
		} else if (IsInside(d1, d2, d4, d3)) {
			i = 3;
		} else if (IsInside(d1, d4, d3, d2)) {
			i = 2;
		} else if (IsInside(d4, d2, d3, d1)) {
			i = 1;
		}

		return i;
	}
	
	
	/***************************************************************
	 * 
	 * 对凸包点进行排序。
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> OrderFinalDots(ArrayList<Dot> list) {
		ArrayList<Dot> listUp = new ArrayList<Dot>();
		ArrayList<Dot> listDown = new ArrayList<Dot>();

		int maxX = FindMaxX(list);
		int minX = FindMinX(list);
		
		Dot maxDot = list.get(maxX);
		Dot minDot = list.get(minX);
		list.remove(minDot);
		list.remove(minDot);
		// 判断除最大最小点外的点在其连线上方还是下方，分别存入listUp和listDown中。
		for (int i = 0; i < list.size(); i++) {
			if (IsUp(minDot, maxDot, list.get(i))) {
				listUp.add(list.get(i));
			} else {
				listDown.add(list.get(i));
			}

		}
		// 对listUp和listDown排序，listUp从大到小，listDown从小到大。
		listUp = QuickSort(listUp, 0, listUp.size() - 1);
		listUp = SortY(listUp);
		listUp = InvertOrder(listUp);
		
		for (int i = 0; i < listUp.size(); i++) {
			Dot a = listUp.get(i);
			System.out.println("第" + i + "个点(up)：" + a.getX() + " " + a.getY());
		}
		System.out.println("--------------------------------");
		listDown = QuickSort(listDown, 0, listDown.size() - 1);
		listDown = SortY(listDown);
		for (int i = 0; i < listDown.size(); i++) {
			Dot a = listDown.get(i);
			System.out.println("第" + i + "个点：(down)" + a.getX() + " "
					+ a.getY());
		}
		System.out.println("--------------------------------");

		// 合并listUp和listDown到list
		list.clear();

		list.add(minDot);
		for (int i = 0; i < listDown.size(); i++) {
			list.add(listDown.get(i));
		}
		list.add(maxDot);
		for (int i = 0; i < listUp.size(); i++) {
			list.add(listUp.get(i));
		}
		return list;
	}

	/***************************************************************
	 * 
	 * 找到最大X在list中的序号。
	 * 
	 ***************************************************************/
	public static int FindMaxX(ArrayList<Dot> list) {
		int max = list.get(0).getX();
		int maxDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getX() > max) {
				max = list.get(i).getX();
				maxDot = i;
			}
		}
		return maxDot;
	}

	/***************************************************************
	 * 
	 * 找到最小X在list中的序号。
	 * 
	 ***************************************************************/
	public static int FindMinX(ArrayList<Dot> list) {
		int min = list.get(0).getX();
		int minDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getX() < min) {
				min = list.get(i).getX();
				minDot = i;
			}
		}
		return minDot;
	}


	/***************************************************************
	 * 
	 * 找到最大Y在list中的序号。
	 * 
	 ***************************************************************/
	public static int FindMaxY(ArrayList<Dot> list) {
		int max = list.get(0).getY();
		int maxDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getY() > max) {
				max = list.get(i).getY();
				maxDot = i;
			}
		}
		return maxDot;
	}

	
	/***************************************************************
	 * 
	 * 得到Y最大最小左侧。
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> GetYLeft(ArrayList<Dot> list) {
		ArrayList<Dot> listUp = new ArrayList<Dot>();
		ArrayList<Dot> listDown = new ArrayList<Dot>();

		int maxY = FindMaxY(list);
		int minY = FindMinY(list);
		
		Dot maxDot = list.get(maxY);
		Dot minDot = list.get(minY);
		list.remove(minDot);
		list.remove(minDot);
		// 判断除最大最小点外的点在其连线上方还是下方，分别存入listUp和listDown中。
		for (int i = 0; i < list.size(); i++) {
			if (IsUp(minDot, maxDot, list.get(i))) {
				listUp.add(list.get(i));
			} else {
				listDown.add(list.get(i));
			}

		}
		// 对listUp和listDown排序，listUp从大到小，listDown从小到大。
		listUp = QuickSort(listUp, 0, listUp.size() - 1);
		listUp = SortX(listUp);
		listUp = InvertOrder(listUp);
		

		// 合并listUp和listDown到list
		list.clear();

		return listUp;
	}
	
	
	/***************************************************************
	 * 
	 * 得到Y最大最小右侧。
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> GetYRight(ArrayList<Dot> list) {
		ArrayList<Dot> listUp = new ArrayList<Dot>();
		ArrayList<Dot> listDown = new ArrayList<Dot>();

		int maxY = FindMaxY(list);
		int minY = FindMinY(list);
		
		Dot maxDot = list.get(maxY);
		Dot minDot = list.get(minY);
		list.remove(minDot);
		list.remove(minDot);
		// 判断除最大最小点外的点在其连线上方还是下方，分别存入listUp和listDown中。
		for (int i = 0; i < list.size(); i++) {
			if (IsUp(minDot, maxDot, list.get(i))) {
				listUp.add(list.get(i));
			} else {
				listDown.add(list.get(i));
			}

		}
		// 对listUp和listDown排序，listUp从大到小，listDown从小到大。
//		listUp = QuickSort(listUp, 0, listUp.size() - 1);
//		listUp = SortX(listUp);
//		listUp = InvertOrder(listUp);
		
		
		listDown = QuickSort(listDown, 0, listDown.size() - 1);
		listDown = SortX(listDown);
	

		// 合并listUp和listDown到list
		list.clear();

		list.add(minDot);
		for (int i = 0; i < listDown.size(); i++) {
			list.add(listDown.get(i));
		}
		list.add(maxDot);
//		for (int i = 0; i < listUp.size(); i++) {
//			list.add(listUp.get(i));
//		}
		return listDown;
	}
	/***************************************************************
	 * 
	 * 找到最小Y在list中的序号。
	 * 
	 ***************************************************************/
	public static int FindMinY(ArrayList<Dot> list) {
		int min = list.get(0).getY();
		int minDot = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getY() < min) {
				min = list.get(i).getY();
				minDot = i;
			}
		}
		return minDot;
	}
	
	/***************************************************************
	 * 
	 * 对list中的成员进行Y分量的从小到大的快速排序。
	 * 
	 ***************************************************************/

	public static ArrayList<Dot> QuickSortY(ArrayList<Dot> list, int start,
			int end) {
		int i, j;
		i = start;
		j = end;
		if ((list == null) || (list.size() == 0))
			return list;
		while (i < j) {
			while (i < j && list.get(i).getY() <= list.get(j).getY()) { // 以数组start下标的数据为key，右侧扫描
				j--;
			}
			if (i < j) { // 右侧扫描，找出第一个比key小的，交换位置
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			while (i < j && list.get(i).getY() < list.get(j).getY()) { // 左侧扫描（此时a[j]中存储着key值）
				i++;
			}
			if (i < j) { // 找出第一个比key大的，交换位置
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		if (i - start > 1) {
			// 递归调用，把key前面的完成排序
			QuickSort(list, start, i - 1);
		}
		if (end - j > 1) {
			QuickSort(list, j + 1, end); // 递归调用，把key后面的完成排序
		}
		return list;
	}
	
	
	
	/***************************************************************
	 * 
	 * 对list中的成员进行x分量的从小到大的快速排序。
	 * 
	 ***************************************************************/

	public static ArrayList<Dot> QuickSort(ArrayList<Dot> list, int start,
			int end) {
		int i, j;
		i = start;
		j = end;
		if ((list == null) || (list.size() == 0))
			return list;
		while (i < j) {
			while (i < j && list.get(i).getX() <= list.get(j).getX()) { // 以数组start下标的数据为key，右侧扫描
				j--;
			}
			if (i < j) { // 右侧扫描，找出第一个比key小的，交换位置
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			while (i < j && list.get(i).getX() < list.get(j).getX()) { // 左侧扫描（此时a[j]中存储着key值）
				i++;
			}
			if (i < j) { // 找出第一个比key大的，交换位置
				Dot temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		if (i - start > 1) {
			// 递归调用，把key前面的完成排序
			QuickSort(list, start, i - 1);
		}
		if (end - j > 1) {
			QuickSort(list, j + 1, end); // 递归调用，把key后面的完成排序
		}
		return list;
	}

	/***************************************************************
	 * 
	 * 对快排后list的y进行排序。
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> SortY(ArrayList<Dot> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getX() == list.get(i + 1).getX()) {
				if (list.get(i).getY() > list.get(i + 1).getY()) {
					Dot temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
		}
		return list;

	}

	/***************************************************************
	 * 
	 * 对快排后list的x进行排序。
	 * 
	 ***************************************************************/
	public static ArrayList<Dot> SortX(ArrayList<Dot> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getY() == list.get(i + 1).getY()) {
				if (list.get(i).getX() > list.get(i + 1).getX()) {
					Dot temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
		}
		return list;

	}
	/***************************************************************
	 * 
	 * 对list中的成员进行逆序。
	 * 
	 ***************************************************************/

	public static ArrayList<Dot> InvertOrder(ArrayList<Dot> list) {
		ArrayList<Dot> list1 = new ArrayList<Dot>();
		for (int i = list.size() - 1; i >= 0; i--) {
			list1.add(list.get(i));
		}
		return list1;
	}
	
}

