package com.jxust.svsh.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static boolean textIsEmpty(String value) {
		if (value == null) {
			return true;
		}
		if (value.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static String SHA1(String value) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
			digest.update(value.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

	public static String getNowDateStr() {
		return sdf.format(Calendar.getInstance().getTime());
	}

	public static Date getNowDate() {
		return Calendar.getInstance().getTime();
	}

	public static String formatDateStr(Date date) {
		return sdf.format(date);
	}

	public static Date formatToData(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
