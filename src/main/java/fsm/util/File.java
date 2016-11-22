package fsm.util;

import fsm.domain.Floor;
import org.apache.commons.fileupload.FileItem;

import java.util.Iterator;
import java.util.List;

public class File {

    public static String store(List fileItems, String fileDirectory) {

        java.io.File file;
        Iterator iterator = fileItems.iterator();
        String fileName = null;

        while (iterator.hasNext()) {
            FileItem fi = (FileItem) iterator.next();
            if (!fi.isFormField()) {
                String fieldName = fi.getFieldName();
                fileName = fi.getName();
                boolean isInMemory = fi.isInMemory();
                long sizeInBytes = fi.getSize();
                if (fileName.lastIndexOf("\\") >= 0) {
                    file = new java.io.File(fileDirectory + fileName.substring(fileName.lastIndexOf("\\")));
                } else {
                    file = new java.io.File(fileDirectory + fileName.substring(fileName.lastIndexOf("\\") + 1));
                }

                try {
                    fi.write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (fileName.lastIndexOf("\\") != -1) {
                    fileName = fileName.substring(fileName.lastIndexOf("\\"));
                }
            }
        }
        String filePath = fileDirectory + fileName;
        return filePath;

    }
}
