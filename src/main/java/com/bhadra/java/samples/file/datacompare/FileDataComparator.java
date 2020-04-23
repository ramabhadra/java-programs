package com.bhadra.java.samples.file.datacompare;

import java.io.File;
import java.util.Comparator;

public class FileDataComparator implements Comparator<File> {

	public int compare(File file1Arg, File file2Arg) {
		long file1Length = file1Arg.length();
		long file2Length = file2Arg.length();
		if (file1Length < file2Length)
			return -1;
		else if (file1Length > file2Length)
			return 1;
		else
			return 0;
	}
}