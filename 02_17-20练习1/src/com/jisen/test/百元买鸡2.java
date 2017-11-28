package com.jisen.test;

public class 百元买鸡2 {

	/**
	 * 百钱买百鸡问题（100块钱买100只鸡，其中公鸡5块一只，母鸡3块一只，小鸡1块买3只）
	 * 5i+3j+K/3=100;15i+9j+k=300
	 * i+j+k=100;
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("公鸡为	母鸡为	小鸡为");
		for(int i=0;i<=20;i++){
			int j=(100-7*i)/4;
			int k=(300+3*i)/4;
			if((5*i+3*j+k/3.0==100)&(i+j+k==100)&(j>0)&(k>0)){
				
				System.out.println(i+"\t"+j+"\t" +k);
			}
		}
	}

}
