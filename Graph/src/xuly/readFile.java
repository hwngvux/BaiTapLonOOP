package xuly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class readFile extends ChuanHoa{

    public static String a;

    public String ReadFileLine (File file) {
        String str = "";
        String strLine = "";
        FileInputStream fstream;
        try {
            fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            while ((strLine = br.readLine()) != null) {
                strLine = strLine.replaceAll("\".+?\"", "");
                strLine = strLine.replaceAll("\\s+"," ");
                strLine = strLine.replaceAll("\\( +"," ");
                //strLine = strLine.replaceAll("\'.+?\'", "");
                if (strLine.contains("import")) strLine = "";
                else if (strLine.contains("package")) strLine = "";
                if (strLine.contains("abstract") && strLine.contains(";"))
                    strLine = strLine.replace(";" , "{}");
//                if (strLine.contains("class") && strLine.endsWith("{"))
//                    strLine = strLine.replace("{","");
                str = str +replaceComments (strLine) + "\n";


            }
            br.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }
    public  String replaceComments(String strLine) {
        strLine = strLine.trim();
        if (strLine.startsWith("//")) {
            return "";
        } else if (strLine.contains("//")) {
            if (strLine.contains("\"")) {
                int lastIndex = strLine.lastIndexOf("\"");
                int lastIndexComment = strLine.lastIndexOf("//");
                if (lastIndexComment > lastIndex) { // ( "" // )
                    strLine = strLine.substring(0, lastIndexComment);
                }
            } else {
                int index = strLine.lastIndexOf("//");
                strLine = strLine.substring(0, index);
            }
        }

        return strLine;
    }

    public String ReadFile (String path) {
        File file = new File (path);
        String strFile = ReadFileLine(file);
        strFile = strFile.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)", "");
        a += strFile;
        return strFile;
    }
    public String ReadOnlyFile(String path){
        File file = new File (path);
        String strFile = HandleLine(file);
        //System.out.println(strFile);
        return strFile;
    }
    public String HandleLine(File file){
        String str = "";
        String strLine = "";
        FileInputStream fstream;
        try {
            fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            while ((strLine = br.readLine()) != null) {
                str = str +replaceComments (strLine);
            }
            br.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }
}