 public class classMem { public ArrayList<String> className = new ArrayList<> ( ) ; public ArrayList<String> superClassName = new ArrayList<> ( ) ; public ArrayList<String> Methods = new ArrayList<> ( ) ; public ArrayList<String> Attribute = new ArrayList<> ( ) ; public void setNameClass ( String nameClass ) } public ArrayList<String> getNameClass ( ) } public int getSizeClass ( ) } public void setNameSuperClass ( String nameSuperClass ) } public ArrayList<String> getNameSuperClass ( ) } public void setAttribute ( ArrayList <String> Attribute ) } public ArrayList<String> getAttribute ( ) } public int getSizeAttribute ( ) } public void addAttribute ( String newAttribute ) } public void setMethods ( ArrayList<String> Methods ) } public ArrayList<String> getMethods ( ) } public int getSizeMethods ( ) } public void addMethods ( String newMethod ) } public void toStr ( ) } public String toString ( ) } }  END  public class standard { public String standard ( String str ) } }  END  public class analysis extends classMem { String str = "" ; classMem[] tpClass ; public analysis ( String str , classMem[] tpClass ) } public void FuckJava ( ) throws ArrayIndexOutOfBoundsException } }  END  public class Files { private ArrayList<String> listFile = new ArrayList<> ( ) ; public void setListFile ( ArrayList<String> listFile ) } public ArrayList<String> getListFile ( ) } public void addPathtoListFile ( String path ) } public int getSizeOfListFile ( ) } public void printListFile ( ) } public void readProject ( String pathFolder ) } }  END  public class readFile extends standard { public static String a ; public String ReadFileLine ( File file ) } public String replaceComments ( String strLine ) } public String ReadFile ( String path ) } public String ReadOnlyFile ( String path ) } public String HandleLine ( File file ) } }  END  public class Main { private static final String RESULT = ; private static final String FILENAME = ; private static final String one = ; public static void main ( String[] args ) throws Exception , IndexOutOfBoundsException , ArrayIndexOutOfBoundsException , IOException } public static String removeCharAt ( String s , int pos ) } public static String StringOutput ( classMem[] tp , Files file ) } public static void FileExport ( String a , String fileName , File file ) throws FileNotFoundException } }  END  public class Diagram { int m = 12 , areaSize = 100 ; int buttonWidth = 100 , buttonHeight = 50 ; Border border1 = BorderFactory.createLineBorder ( Color.GREEN ) ; String classname = ; JFrame f = new JFrame ( ) ; JPanel panel1 = new JPanel ( ) ; JTextArea[] area = new JTextArea[100] ; Component temp = new JTextArea ( ) ; JButton zoomIn = new JButton ) ; JButton zoomOut = new JButton ( ) ; Diagram ( ) } static public void main ( String[] arg ) } class CustomMouseListener implements MouseListener  END 
