package com.jisen;

public class CommandLineArgument {

	/**
	 * 当一个程序通过在控制台用Java指令运行时，用户可以提供零个或多个命令参数。这些命令行参数都是字符串，这些字符串可以是独立的记号如hello，也可以是引号之间多个符号如“hello world”
	 * C:\Users\Administrator\workspace\08_01_用户交互之命令行参数传递\bin>java com.jisen.CommandLineArgument 112 wee 234 sfa
	 * 
	 */
	
	public static void main(String[] args) {
		//当在控制台输入java com.jisen.CommandLineArgument 112 wee 234 sfa时
		//会将字符串数组分别传递进String[] args={"112","wee","234","sfa"};
		//即args[0]="112",args[1]="wee",args[2]="234",args[3]="sfa"
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
		
		if(args.length<2){
			System.out.println("java 主类名 IP地址port端口");
			System.exit(0);
		}
		//java com.jisen.CommandLineArgument 192.168.0.188 8888
		System.out.println("主机信息如下：(IP地址："+args[0]+",端口号："+Integer.parseInt(args[1]));
//		String ip=args[0];
//		int port =Integer.parseInt(args[1]);
//		System.out.println("主机信息如下：(IP地址："+ip+",端口号："+port+")");
	}

}
