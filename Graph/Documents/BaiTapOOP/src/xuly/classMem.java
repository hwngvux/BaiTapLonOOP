package xuly;
import java.util.ArrayList;

public class classMem {
    public ArrayList<String> className = new ArrayList<>();
    public ArrayList<String> superClassName = new ArrayList<>();
    //ArrayList <String> Fields = new ArrayList<> ();
    public ArrayList<String> Methods = new ArrayList<> ();
    public ArrayList<String> Attribute = new ArrayList<>();

    public void setNameClass (String nameClass) {
        className.add(nameClass);
    }

    public ArrayList<String> getNameClass () {
        return className;
    }

    public int getSizeClass () {return className.size() ;}

    public void setNameSuperClass(String nameSuperClass) {
        this.superClassName.add(nameSuperClass);
    }

    public ArrayList<String> getNameSuperClass() {
        return superClassName;
    }

    public void setAttribute (ArrayList <String> Attribute) {
        this.Attribute = Attribute;
    }
    public ArrayList<String> getAttribute () {
        return Attribute;
    }
    public int getSizeAttribute () {
        return Attribute.size();
    }
    public void addAttribute(String newAttribute) { Attribute.add(newAttribute);}

    public void setMethods(ArrayList<String> Methods) {
        this.Methods = Methods;
    }
    public ArrayList<String> getMethods () {
        return Methods;
    }
    public int getSizeMethods() {
        return Methods.size();
    }
    public void addMethods(String newMethod) {
        Methods.add(newMethod);
    }
    //public void getLength() (int l) {return }



    public void toStr () {
        System.out.println("Class " + className);
        if(superClassName != null){
            System.out.println("Extend " + superClassName);
        }
        //else System.out.println("Class cha   : " + superClassName);
        System.out.println("Method : ");
        for (String s: Methods) {
            System.out.println(s);
        }
        System.out.println(" ");
        System.out.println("Attribute : ");
        for (String s: Attribute) {
            System.out.println(s);
        }
    }
    public String toString(){
        String s = "";
        s += "Class " + className;
        if (superClassName != null){
            s += "\r\n";
            s += "  Extend " + superClassName;
        }
        s+= "\r\n" + "\r\n";
        s+= "    Methods : ";
        for (String a: Methods){
            s += "\r\n";
            s += "     " + a;
        }
        s += "\r\n";
        s += "\r\n";
        s += "   Attribute : ";
        for (String a : Attribute){
            s+="\r\n";
            s += "   " + a;
        }
        s+= "\r\n" + "\r\n";
        return s;
    }
}