package xuly;

import java.io.File;
import java.util.ArrayList;

public class Files {

    private ArrayList<String> listFile = new ArrayList<>();


    public void  setListFile (ArrayList<String> listFile) {
        this.listFile = listFile;
    }
    public ArrayList<String> getListFile () {
        return listFile;
    }

    public void addPathtoListFile (String path) {
        listFile.add(path);
    }

    public int getSizeOfListFile () {
        //System.out.println(listFile.size());
        return listFile.size();
    }

    public void printListFile () {
        for (String str : listFile ) {
            System.out.println(str);
        }
    }
    // save path file to listFile
    public void readProject(String pathFolder) {
        File file = new File(pathFolder);
        if (file.exists()) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    listFile.add(file.getAbsolutePath());
                }
            }
            File[] lfile = file.listFiles();
            if (lfile != null) {
                for (File l : lfile) {
                    readProject(l.getAbsolutePath());
                }
            }
        }

    }
}

