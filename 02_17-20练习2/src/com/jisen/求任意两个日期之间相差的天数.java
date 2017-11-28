package com.jisen;

import java.util.Scanner;

public class 求任意两个日期之间相差的天数 {

	
	/**
	 * 求任意两个日期之间相差的天数
	 */
	public static int[] day_of_month={0,31,28,31,30,31,30,31,31,30,31,30,31};//因为多个函数要用到这个数组
	public static void leapYear(int year){
		if(year%400==0||year%4==0&&year%100!=0){
			day_of_month[2]=29;
			}else{
				day_of_month[2]=28;
			}
	} 
	public static boolean correctdate(int year,int month,int day){
		leapYear(year);
		if(year<0||year>4000) return false;
		if(month<1||month>12) return false;
		if(day<1||day>day_of_month[month]) return false;
		return true;
	}
	public static int days(int year1,int month1,int day1,int year2,int month2,int day2){
		int days=0;
		//保证第二个日期比第一个日期大
		if(year1>year2){
			year1=(year1+year2)-(year2=year1);
			month1=(month1+month2)-(month2=month1);
			day1=(day1+day2)-(day2=day1);
		}else if(year1==year2){
			if(month1>month2){
				month1=(month1+month2)-(month2=month1);
				day1=(day1+day2)-(day2=day1);
			}else if(month1==month2){
				if(day1>day2){
					day1=(day1+day2)-(day2=day1);
				}
			}
		}
		//求年差值*365
		for(int i=year1;i<year2-year1;i++){
			if((year1+i)%400==0||(year1+i)%4==0&&(year1+i)%100!=0)
				days+=i*366;
			days+=i*365;
		}
		for(int i=month1;i>0;i--){
			leapYear(year1);
				days-=day_of_month[i];
		}
		for(int i=month2;i>0;i--){
			leapYear(year2);
				days+=day_of_month[i];
		}
		days=days+day2-day1;	
		return days;
	}
	public static void main(String[] args) {
		Scanner scan1=new Scanner(System.in);
		System.out.println("请输入第一个年月日：");
		int year1=scan1.nextInt();
		int month1=scan1.nextInt();
		int day1=scan1.nextInt();
		if(correctdate(year1,month1,day1)==false){
			System.out.println("您输入的日期有误");
			return;
		}
		System.out.println("请输入第二个年月日：");
		int year2=scan1.nextInt();
		int month2=scan1.nextInt();
		int day2=scan1.nextInt();
		if(correctdate(year2,month2,day2)==false){
			System.out.println("您输入的日期有误");
			return;
		}
		int day=days(year1,month1,day1,year2,month2,day2);
		System.out.println("两个日期相差的天数为"+day);
	}

}
