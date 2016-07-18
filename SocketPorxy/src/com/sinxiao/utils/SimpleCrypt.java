package com.sinxiao.utils;

public class SimpleCrypt {
//	private final static String TYPE ="AES";
	private final static String CODE = "7,~3*&se2x@#5.1.i9im*3*0+";
	
	public static byte[] encrypt(byte[] input)
	{
		return AES.encrypt(input, CODE);
	}
	public static byte[] decrypt(byte[] content)
	{
		return AES.decrypt(content, CODE);
	}
	public static byte[] encrypt(byte[] input,int length)
	{
		byte[] data = new byte[length];
		System.arraycopy(input, 0, data, 0, length);
		return AES.encrypt(data, CODE);
	}
	public static byte[] decrypt(byte[] content,int length)
	{
		byte[] data = new byte[length];
		System.arraycopy(content, 0, data, 0, length);
		return AES.decrypt(data, CODE);
	}
}
