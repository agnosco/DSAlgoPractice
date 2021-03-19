package practice;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

@Component
@Scope ()
public class FindFile {
    public static void main(String[] args) {
        System.out.println(findFileBFS("C:\\Users\\Sajana\\", "ImageManipulationUtility.class"));
    }

    static String findFileBFS(String dir, String file){

        Queue<File> fileQueue = new LinkedList<>();

        fileQueue.add(new File(dir));

        while (!fileQueue.isEmpty()){
            File current = fileQueue.poll();
            if(current.listFiles() != null){
                for (File fileInside: current.listFiles()){
                    if(fileInside.isDirectory()){
                        fileQueue.add(fileInside);
                    }else if(fileInside.getName().equals(file)){
                        return fileInside.getAbsolutePath();
                    }
                }
            }
        }
        return "not found";
    }
}
