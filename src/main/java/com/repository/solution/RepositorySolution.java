package com.repository.solution;

import java.io.File;
import java.util.Scanner;

public class RepositorySolution {

	public static void main(String[] args) {

		//Input from User for project repository path
		System.out.println("Please provide Main Project - 'URL':");
		Scanner scan = new Scanner(System.in);
		String Path = scan.nextLine();
		documentRepositorySolution(Path);
		scan.close();

	}

	public static boolean documentRepositorySolution(String Path) {

		boolean flag = false;

		File inFilePath = new File(Path);

		if (inFilePath.isDirectory()) {

			//Check whether there are files to iterate or not
			//check whether the directory is null
			File[] fileList = inFilePath.listFiles();
			if (fileList != null) {
				flag = true;
			}else {
				System.out.println("Directory is empty!!");
			}

			StringBuffer DocumentRepos = ProjectInternalDataDisplay(inFilePath);
			// get all the files from a directory
			System.out.println(DocumentRepos.toString());


			// iterate through the list of files in the given path using
			// enhanced for loop
			for (File file : fileList) {
				if (file.isFile()) {
					FileInternalDataDisplay(file);
				} else if (file.isDirectory()) {
					ProjectInternalDataDisplay(file);

					StringBuffer subDirPath= new StringBuffer().append(file.getAbsolutePath());

					displayInternalRepository(subDirPath);

				} else {
					System.out.println("Please provide a valid path! ");
				}
			}
		}
		// end if(inputpath.isDirectory())
		else if (inFilePath.isFile()) {
			FileInternalDataDisplay(inFilePath);
		} // end if(inputpath.isFile())
		else {

			System.out.println("Not a valid directory");
		} // end of else

		return flag;

	}


	private static void FileInternalDataDisplay(File file) {

		
		String path = file.getName();
		String filename = path.substring(0, path.indexOf("."));
		String fileExtension = path.substring(filename.length());
		System.out.print("         ");
//assigning new internal file to path
		StringBuffer formatPath = new StringBuffer().append("- Document: ").append(filename).append(" - ")
				.append("Extension: ").append(fileExtension).append(" - URL: ").append(file.getAbsolutePath());

		System.out.println(formatPath.toString());
	}


	private static StringBuffer ProjectInternalDataDisplay(File inputpath) {

		StringBuffer formatPath = null;

		//Iterating inside the directory
		formatPath= new StringBuffer().append("- Project : ").append(inputpath.getName()).append(" - ")
				.append(" - URL: ").append(inputpath.getAbsolutePath());

		//Check if path is empty 
		if (formatPath.toString()==null) {
			System.out.println("Empty input Path again");
		}

		//Recycle Bin is alloted to each Drive
		//if recycle bin is empty can create a null pointer error.
		else if (formatPath.toString().endsWith("$RECYCLE.BIN")){
			formatPath= new StringBuffer().append("- Project : ").append(inputpath.getName()).append(" - ")
					.append(" - URL: ");
			System.out.println("Recycle Bin skipped");
		}	
		return formatPath;
	}

	private static void displayInternalRepository(StringBuffer subDirPath) {
		String InternalRepoPath = subDirPath.toString();

		documentRepositorySolution(InternalRepoPath);

	}

}