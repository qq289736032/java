package com.jisen;

interface Usb{
	public void insert();
	public void delete();
}
class MoveDisk implements Usb{

	public void insert() {
		System.out.println("MP3插入");
	}

	public void delete() {
		System.out.println("MP3拔出");
	}
}
class Computer{
	public void usbUsb(Usb usb){
		usb.insert();
		//..
		usb.delete();
	}
}
public class UsbMode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Computer().usbUsb(new MoveDisk());
	}

}
