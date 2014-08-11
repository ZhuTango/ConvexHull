package com.Barlow.convexhull;


import java.util.ArrayList;

public class ConvexHull01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<Dot> GetConvexHullDots(ArrayList<Dot> list) {
		ArrayList<Dot> list1 = new ArrayList<Dot>();
		for(int i=0; i<list.size(); i++){
			list1.add(list.get(i));
		}
		for (int i = 0; i < list1.size()-3; i++) {
			for (int j = i + 1; j < list1.size()-2; j++) {
				for (int k = j + 1; k < list1.size()-1; k++) {
					for(int l = k + 1; l < list1.size(); l++){
						Dot a = list1.get(i);
						Dot b = list1.get(j);
						Dot c = list1.get(k);
						Dot d = list1.get(l);
						if(Dot.IsSameDot(a, b)&&Dot.IsSameDot(b, c)&&Dot.IsSameDot(c, d)){
							
							list1.get(j).setFlag(true);
							list1.get(k).setFlag(true);
							list1.get(l).setFlag(true);//如果四个点都相同则给后三个点标志重复
							
						}else if(Dot.IsSameDot(a, b)&&Dot.IsSameDot(b, c)){
							
							list1.get(j).setFlag(true);
							list1.get(k).setFlag(true);//如果三个点相同则给后两个点标志重复
							
						}else if(Dot.IsSameDot(a, b)&&Dot.IsSameDot(b, d)){
							
							list1.get(j).setFlag(true);
							list1.get(l).setFlag(true);//如果三个点相同则给后两个点标志重复
							
						}else if(Dot.IsSameDot(a, d)&&Dot.IsSameDot(d, c)){
							
							list1.get(l).setFlag(true);
							list1.get(k).setFlag(true);//如果三个点相同则给后两个点标志重复
							
						}else if(Dot.IsSameDot(d, b)&&Dot.IsSameDot(b, c)){
							
							list1.get(l).setFlag(true);
							list1.get(k).setFlag(true);//如果三个点相同则给后两个点标志重复
							
						}else if(Dot.IsSameDot(a, b)){
							
							list1.get(j).setFlag(true);//如果两个点相同则给后两个点标志重复
							if(Dot.IsColineation(a, c, d)){
								int p =Dot.GetMiddleDot(a, c, d);
								if(p==1){
									list1.get(i).setFlag(true);
								}else if(p==2){
									list1.get(k).setFlag(true);
								}else if(p==3){
									list1.get(l).setFlag(true);
								}
								
							}
							
						}else if(Dot.IsSameDot(a, c)){
							
							list1.get(k).setFlag(true);//如果两个点相同则给后两个点标志重复
							if(Dot.IsColineation(a, b, d)){
								int p =Dot.GetMiddleDot(a, b, d);
								if(p==1){
									list1.get(i).setFlag(true);
								}else if(p==2){
									list1.get(j).setFlag(true);
								}else if(p==3){
									list1.get(l).setFlag(true);
								}
								
							}
							
						}else if(Dot.IsSameDot(a, d)){
							
							list1.get(l).setFlag(true);//如果两个点相同则给后两个点标志重复
							if(Dot.IsColineation(a, b, c)){
								int p =Dot.GetMiddleDot(a, b, c);
								if(p==1){
									list1.get(i).setFlag(true);
								}else if(p==2){
									list1.get(j).setFlag(true);
								}else if(p==3){
									list1.get(k).setFlag(true);
								}
								
							}
							
						}else if(Dot.IsSameDot(b, c)){
							
							list1.get(k).setFlag(true);//如果两个点相同则给后两个点标志重复
							if(Dot.IsColineation(a, b, d)){
								int p =Dot.GetMiddleDot(a, b, d);
								if(p==1){
									list1.get(i).setFlag(true);
								}else if(p==2){
									list1.get(j).setFlag(true);
								}else if(p==3){
									list1.get(l).setFlag(true);
								}
								
							}
							
						}else if(Dot.IsSameDot(b, d)){
							
							list1.get(l).setFlag(true);//如果两个点相同则给后两个点标志重复
							if(Dot.IsColineation(a, b, c)){
								int p =Dot.GetMiddleDot(a, b, c);
								if(p==1){
									list1.get(i).setFlag(true);
								}else if(p==2){
									list1.get(j).setFlag(true);
								}else if(p==3){
									list1.get(k).setFlag(true);
								}
								
							}
							
						}else if(Dot.IsSameDot(c, d)){
							
							list1.get(l).setFlag(true);//如果两个点相同则给后两个点标志重复
							if(Dot.IsColineation(a, b, c)){
								int p =Dot.GetMiddleDot(a, b, c);
								if(p==1){
									list1.get(i).setFlag(true);
								}else if(p==2){
									list1.get(j).setFlag(true);
								}else if(p==3){
									list1.get(k).setFlag(true);
								}
								
							}
							
						}else if(Dot.IsColineation(a, b, c)&&Dot.IsColineation(a, b, d)){
							//四点共线取中间两点
							int p =Dot.GetMiddleDot(a, b, c);
							if(p==1){
								list1.get(i).setFlag(true);
							}else if(p==2){
								list1.get(j).setFlag(true);
							}else if(p==3){
								list1.get(k).setFlag(true);
							}
							
							p =Dot.GetMiddleDot(a, b, d);
							if(p==1){
								list1.get(i).setFlag(true);
							}else if(p==2){
								list1.get(j).setFlag(true);
							}else if(p==3){
								list1.get(l).setFlag(true);
							}
							
							p =Dot.GetMiddleDot(b, c, d);
							if(p==1){
								list1.get(j).setFlag(true);
							}else if(p==2){
								list1.get(k).setFlag(true);
							}else if(p==3){
								list1.get(l).setFlag(true);
							}
							
						}else if(Dot.IsColineation(a, b, c)){
							//三点共线取中点
							int p =Dot.GetMiddleDot(a, b, c);
							if(p==1){
								list1.get(i).setFlag(true);
							}else if(p==2){
								list1.get(j).setFlag(true);
							}else if(p==3){
								list1.get(k).setFlag(true);
							}
							
						}else if(Dot.IsColineation(a, b, d)){
							//三点共线取中点
							int p =Dot.GetMiddleDot(a, b, d);
							if(p==1){
								list1.get(i).setFlag(true);
							}else if(p==2){
								list1.get(j).setFlag(true);
							}else if(p==3){
								list1.get(l).setFlag(true);
							}
							
						}else if(Dot.IsColineation(b, c, d)){
							//三点共线取中点
							int p =Dot.GetMiddleDot(b, c, d);
							if(p==1){
								list1.get(j).setFlag(true);
							}else if(p==2){
								list1.get(k).setFlag(true);
							}else if(p==3){
								list1.get(l).setFlag(true);
							}
							
						}else {
							int p = Dot.Inside(a, b, c, d);
							if(p==1){
								list1.get(i).setFlag(true);
							}else if(p==2){
								list1.get(j).setFlag(true);
							}else if(p==3){
								list1.get(k).setFlag(true);
							}else if(p==4){
								list1.get(l).setFlag(true);
							}
								
							
						}
						
						
					}
				}
			}
		}
		
		for(int i = 0; i<list1.size(); i++){
			if(list1.get(i).isFlag()){
				System.out.println(i);
				list1.remove(i);
				i--;
			}
		}
		System.out.println(list1.size());
		for (int i = 0; i < list1.size(); i++) {
			Dot a = list1.get(i);
			System.out.println("第"+i+"个点："+a.getX() + " " + a.getY());
		}
		System.out.println("--------------------------------");
		list1=Dot.OrderFinalDots(list1);
		return list1;
	}




}

