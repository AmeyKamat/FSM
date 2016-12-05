package fsm.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import fsm.exception.FloorSpaceManagementException;

public class FileUploadHelper {

	public static File storeFile(MultipartFile multipartFile, String fileName, String fileDirectory) {
		
		File file = new File(fileDirectory + File.separator + fileName);
		writeToFile(file, readFromMultipartFile(multipartFile));
		return file;
	}
	
	private static void writeToFile(File file, byte[] bytes){
		try{
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			bufferedOutputStream.write(bytes);
			bufferedOutputStream.close();
			fileOutputStream.close();
		}
		catch(FileNotFoundException fne){
			throw new FloorSpaceManagementException(fne);
		}
		catch (IOException ioe) {
			throw new FloorSpaceManagementException(ioe);
		}
	}
	
	private static byte[] readFromMultipartFile(MultipartFile multipartFile){
		byte[] content;
		try{
			content = multipartFile.getBytes();
		}
		catch(IOException ioe){
			throw new FloorSpaceManagementException(ioe);
		}
		
		return content;
	}
}