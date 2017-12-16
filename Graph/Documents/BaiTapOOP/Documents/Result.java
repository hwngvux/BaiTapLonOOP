Class [classMem]
  Extend []

    Methods : 
     + void setNameClass ( String ) 
     + ArrayList<String> getNameClass ( ) 
     + int getSizeClass ( ) 
     + void setNameSuperClass ( String ) 
     + ArrayList<String> getNameSuperClass ( ) 
     + void setAttribute ( ArrayList <String> ) 
     + ArrayList<String> getAttribute ( ) 
     + int getSizeAttribute ( ) 
     + void addAttribute ( String ) 
     + void setMethods ( ArrayList<String> ) 
     + ArrayList<String> getMethods ( ) 
     + int getSizeMethods ( ) 
     + void addMethods ( String ) 
     + void toStr ( ) 
     + String toString ( ) 

   Attribute : 
    + ArrayList<String> className 
    + ArrayList<String> superClassName 
    + ArrayList<String> Methods 
    + ArrayList<String> Attribute 

Class [standard]
  Extend []

    Methods : 
     + String standard ( String ) 

   Attribute : 

Class [analysis]
  Extend [classMem]

    Methods : 
     + analysis ( String, classMem[] ) 
     + void FuckJava ( ) 

   Attribute : 
    String str 
    classMem[] tpClass 

Class [Files]
  Extend []

    Methods : 
     + void setListFile ( ArrayList<String> ) 
     + ArrayList<String> getListFile ( ) 
     + void addPathtoListFile ( String ) 
     + int getSizeOfListFile ( ) 
     + void printListFile ( ) 
     + void readProject ( String ) 

   Attribute : 
    - ArrayList<String> listFile 

Class [readFile]
  Extend [standard]

    Methods : 
     + String ReadFileLine ( File ) 
     + String replaceComments ( String ) 
     + String ReadFile ( String ) 
     + String ReadOnlyFile ( String ) 
     + String HandleLine ( File ) 

   Attribute : 
    + static String a 

Class [Main]
  Extend []

    Methods : 
     + void main ( String[] ) 
     + String removeCharAt ( String, int ) 
     + String StringOutput ( classMem[], Files ) 
     + void FileExport ( String, String, File ) 

   Attribute : 
    - static final String RESULT 
    - static final String FILENAME 
    - static final String one 

Class [Diagram, CustomMouseListener]
  Extend []

    Methods : 
      Diagram ( ) 
     + void main ( String[] ) 
      class CustomMouseListener implements MouseListener 

   Attribute : 
    int m, areaSize 
    int buttonWidth, buttonHeight 
    Border border1 
    String classname 
    JFrame f 
    JPanel panel1 
    JTextArea[] area 
    Component temp 
    JButton zoomIn 
    JButton zoomOut 
    class CustomMouseListener implements MouseListener 


