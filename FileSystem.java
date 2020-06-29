/*
 * Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.
 */
 import java.util.*;
class FileSystem {
    private File root;
    
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        
        String[] splits = path.split("/");
        File ptr = findFile(splits);
        
        if (ptr.content != null) { // File
            res.add(splits[splits.length - 1]);
        } else { // Directory
            res.addAll(ptr.nameToFile.keySet());
        }
        
        return res;
    }
    
    public void mkdir(String path) {
        String[] splits = path.split("/");
        File ptr = root;
        for (String split : splits) {
            if (!split.isEmpty()) {
                if (!ptr.nameToFile.containsKey(split))
                    ptr.nameToFile.put(split, new File());
                ptr = ptr.nameToFile.get(split);
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        File ptr = findFile(filePath.split("/"));
        ptr.content = (ptr.content == null ? "" : ptr.content) + content;
    }
    
    public String readContentFromFile(String filePath) {
        return findFile(filePath.split("/")).content;
    }
        
    private File findFile(String[] splits) {
        File ptr = root;
        for (String split : splits) {
            if (!split.isEmpty()) {
                ptr = ptr.nameToFile.get(split);
            }
        } 
        return ptr;
    }
    
    class File {
        String content; // Null if dir, not null if file
        TreeMap<String, File> nameToFile;
        public File() {
            content = null;
            nameToFile = new TreeMap<>();
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */