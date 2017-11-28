package com.jisen;

import java.io.*;

public class Test2 {

	/**
	 * @param args━ ━ ━ ━┃┃┃┃┃
	 */
	public static void main(String[] args) {
		File f=new File("c:\\TestFile");
		File[] fi=f.listFiles();
		for(int i=0;i<fi.length;i++){
			if(fi[i].isDirectory()==true){
				System.out.println("━━"+fi[i].getName());
				File[] fii=fi[i].listFiles();
				for(int j=0;j<fii.length;j++){
					if(fii[j].isDirectory()==true){
						System.out.println("\t┃");
						System.out.println("━━"+fii[j].getName());
					}else{
						System.out.println("\t┃");
						System.out.println("━━"+fii[j].getName());
					}
				}
				
			}else{
//				System.out.println("━━"+fi[i].getName());
			}
		}		
			
		
	}

}
