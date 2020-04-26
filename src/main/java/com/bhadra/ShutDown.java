package com.bhadra;

public class ShutDown
{
	public static void main(String[] arg) throws Exception
	{
		Runtime localRuntime = Runtime.getRuntime();
		localRuntime.exec("shutdown -s -t 0");
		System.exit(0);
	}
}