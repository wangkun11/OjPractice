package hust.OjPractice.main;

import java.io.UnsupportedEncodingException;

public class ReverseString {
	//递归实现字符串反转
	public static String reverse(String string) {
		if (string==null||string.length()==1) {
			return string;
		}else {
			return reverse(string.substring(1))+string.charAt(0);
		}
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string="abcdefghij";
		System.out.println(reverse(string));
		String s1=new String("你好");
		System.out.println(new String(s1.getBytes("GB2312"),"ISO-8859-1"));
	}
}
