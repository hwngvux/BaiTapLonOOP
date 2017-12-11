
package xuly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final String RESULT = "Result.java";
    private static final String FILENAME = "data.java";
    //private static final String one = "/Users/VuKimNgan/Downloads/Graph" ;
    public static void main(String[] args) throws Exception ,IndexOutOfBoundsException, ArrayIndexOutOfBoundsException, IOException {
        //String one = "/Users/VuKimNgan/Downloads/Graph" ;
        new File( "/Users/VuKimNgan/Downloads/Graph/Documents").mkdir();
        String b = "";
        Files files = new Files();
        files.readProject( "/Users/VuKimNgan/Downloads/Graph/src");
        Files fileResult = new Files();
        files.readProject(("/Users/VuKimNgan/Downloads/Graph/Documents"));
        ArrayList<String> str = files.getListFile();
        for (String s : str) {
            readFile docFile = new readFile();
            ChuanHoa chuanHoaXau = new ChuanHoa();
            classmember tp = new classmember();
            b += chuanHoaXau.ChuanHoa(docFile.ReadFile(s)) + " END ";
        }
        File file = new File("/Users/VuKimNgan/Downloads/Graph/Documents/data.java");
        file.createNewFile();
        FileExport(b, FILENAME, file);
        //System.out.println(b);
        classmember[] tp = new classmember[files.getSizeOfListFile()];
        ChuanHoa chuanHoa = new ChuanHoa();
        String c = "";
        System.out.println();
        xuly xuly = new xuly(b,tp);
        xuly.FuckJava();
        for (int i = 0; i < files.getSizeOfListFile(); i++){
            c+= tp[i].toString();
        }
       // System.out.println(c);
        File file0 = new File("/Users/VuKimNgan/Downloads/Graph/Documents/Result.java");
        file0.createNewFile();
        FileExport(c, RESULT, file0);

        JFrame frame = new JFrame("My First GUI");
        //JPanel panel1 = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Diagram m = new Diagram() ;
        m.setPreferredSize(new Dimension(2000,900));
        JScrollPane scrollPane = new JScrollPane(m);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JButton Image = new JButton("IMAGE");

        Image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension size = m.getSize();
                BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = image.createGraphics();
                m.paint(g2);
                try {
                    String to =  "/Users/VuKimNgan/Downloads/Graph/gui.png";
                    ImageIO.write(image, "png",new File(to) );
                    System.out.print("Fucking");

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        frame.add(Image,BorderLayout.NORTH);
        frame.add(scrollPane);
        frame.setSize(1500,800);
        //JPanel panel = new JPanel();
        //JLabel label = new JLabel("JFrame By Example");
        //panel.add(label);
        //frame.add(panel);
        //JButton button = new JButton("Press");
        //frame.getContentPane().add(button); // Adds Button to content pane of frame////

        frame.setVisible(true);

    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
    public static String StringOutput(classmember[] tp, Files file){
        String temp = "";
        if (tp == null){
            for (int i = 0; i < file.getSizeOfListFile(); i++){
                temp += tp[i].toString();
            }
            return temp;
        }
        else return "Wrong";
    }
    public static void FileExport(String a, String fileName, File file) throws FileNotFoundException{
        if (file.exists()){
            file.delete();
            PrintStream oldOutStream0 = System.out;
            PrintStream outFile0 = new PrintStream(
                    new FileOutputStream("/Users/VuKimNgan/Downloads/Graph/Documents/" + fileName, true));
            System.setOut(outFile0);
            System.out.println(a);
        }
        else return;
    }
}
