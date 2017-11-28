package com.jisen;

import java.util.Scanner;

//模板：每个场景类都必须拥有readMap和loadSpider，但是必须采用固定的顺序
//abstract class Map{
//	//图
//}
//class MountainMap extends Map{
//	//...
//}
//abstract class Spider{
//	private String spiderName;//怪物名
//	private int blood;//血量
//	private int aggressivity;//攻击力
//	private int defense;//防御能力
//	//抽象方法
//	public abstract void attack();
//}
//class SnowSpider extends Spider{
//	//
//	public void attack(){
//		System.out.println("冰箭");
//	}
//}
abstract class Sence{
	public abstract void readMap();
	public abstract void loadSpider();
	public void loop(){
		readMap();
		loadSpider();
	}
}
class MountainSence extends Sence{

	@Override
	public void readMap() {
		System.out.println("读取山地地图");
		
	}

	@Override
	public void loadSpider() {
		System.out.println("加载山地怪物");
	}
	
}
class SnowSence extends Sence{

	@Override
	public void readMap() {
		System.out.println("读取雪地地图");
	}

	@Override
	public void loadSpider() {
		System.out.println("加载雪地怪物");
	}
	
}
class Game{
	public void loadSence(Sence sence){
		sence.loop();
	}
	public void startGame(){
		System.out.println("============");
		System.out.println("1.山地场景");
		System.out.println("2.雪地场景");
		System.out.println("============");
		System.out.println("请输入您要加载的场景");
		int n=new Scanner(System.in).nextInt();
		switch (n) {
		case 1:
			loadSence(new MountainSence());
			break;
		case 2:
			loadSence(new SnowSence());
		}
		System.out.println("开始刷怪");
	}
}
public class WorldWarGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Game().startGame();
	}

}
