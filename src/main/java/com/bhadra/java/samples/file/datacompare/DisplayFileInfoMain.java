package com.bhadra.java.samples.file.datacompare;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class DisplayFileInfoMain
{
	List<File> list = new Vector<File>();

	public static void main(String args[])
	{
		DisplayFileInfoMain fileInfo = new DisplayFileInfoMain();
		fileInfo.getListOfFiles(new File(args[0]));
		fileInfo.sortingFilesBySize();
		fileInfo.displayFilesInfo();
	}

	public List<File> getListOfFiles(File pathArg)
	{
		File localFiles[];
		localFiles = pathArg.listFiles();

		for (int i = 0, noOfFiles = localFiles.length; i < noOfFiles; i++)
		{
			if (localFiles[i].isDirectory())
			{
				getListOfFiles(localFiles[i]);
			}
			else
			{
				list.add(localFiles[i]);
			}
		}
		return list;
	}

	public void sortingFilesBySize()
	{
		Collections.sort(list, new FileDataComparator());
	}

	public void displayFilesInfo()
	{
		String fileAbsolutePath = "";
		System.out.println("File Path\t\t\tFile Name\t\t\tFile Size");
		System.out.println("==================================================================================================");
		for (Iterator iterator = list.iterator(); iterator.hasNext();)
		{
			File localFile = (File) iterator.next();
			fileAbsolutePath = localFile.getAbsolutePath();
			System.out.println(fileAbsolutePath.substring(0,
					fileAbsolutePath.lastIndexOf(File.separator))
					+ "\t\t"
					+ localFile.getName()
					+ "\t\t"
					+ localFile.length());
		}
		System.out.println("==================================================================================================");
	}

}