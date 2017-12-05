package com.jisen.test;

public class BuyChicken {

	/**
	 * 百钱买百鸡问题（100块钱�?00只鸡，其中公�?块一只，母鸡3块一只，小鸡1块买3只）
	 * @param args
	 */
	public static void main(String[] args) {
	
		for(int i=0;i<20;i++){
			for(int j=0;j<33;j++){
				for(int k=0;k<100;k++){
					if((i+j+k==100)&(5*i+3*j+k/3.0==100)){
						System.out.println("公鸡为："+i+"母鸡为："+j+"小鸡�?"+k);
					}
				}
			}
		}	

	}

}
