/*package xuly;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Diagram {
    int m = 12,areaSize = 100;
    int buttonWidth = 100,buttonHeight = 50;
    Border border1 = BorderFactory.createLineBorder(Color.GREEN);
    String classname = "asdasd" ;
    JFrame f = new JFrame();
    JPanel panel1 = new JPanel();
    JTextArea[] area = new JTextArea[100];
    Component temp = new JTextArea();
    JButton zoomIn = new JButton("Bigger" );
    JButton zoomOut = new JButton("Smaller");
    Diagram(){
        panel1.setSize(1000,1000);
        panel1.setLocation(0,0);
        zoomIn.setBounds(200,800,buttonWidth,buttonHeight);
        zoomOut.setBounds(800,800,buttonWidth,buttonHeight);
        //f.setLayout(null);
        //f.setLocation(0,0);
        for(int i = 0;i<m;i++){
            area[i] = new JTextArea(10,10);
            area[i].setEditable(false);
            area[i].setText("Class " + classname );
            area[i].append("\n"+"Method" +"\n"+i);
            area[i].setBackground(Color.getHSBColor(120, 39, 93));
            area[i].setLocation(i*100 ,i*100);
            area[i].setSize(areaSize,areaSize);
            area[i].addMouseMotionListener(new DragDrop(i));
            area[i].setBorder(border1);
            panel1.add(area[i]);
        }
        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i<m;i++){
                    //area[i].setSize(areaSize * 2,areaSize*2);
                    area[i].setSize(area[i].getWidth()*2,area[i].getHeight()*2);
                }
            }
        });
        zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i<m;i++){
                    area[i].setSize(areaSize / 2,areaSize/2);
                }
            }
        });
        panel1.add(zoomIn);
        panel1.add(zoomOut);
        //panel1.setLayout(null);
        //panel1.addMouseListener(new CustomMouseListener());
        //panel1.addMouseMotionListener(new DragDrop());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000,1000);
        f.setLayout(new BorderLayout());
        f.add(panel1);
        f.setVisible(true);
    }
    static public void main(String[] arg){
        new Diagram();
    }
    class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            /*Component temp1 = new JTextArea();
            temp1 = panel1.getComponent(0);
            temp1.setLocation(panel1.getMousePosition());
            //panel1.add(panel1.getComponent(1));
            //panel1.add(panel1.getComponent(1));
            //panel1.getComponent(1);
            //panel1.remove(panel1.getComponent(1));
            panel1.add(temp1);
            panel1.validate();
            panel1.repaint();
            panel1.removeAll();
            panel1.validate();
            panel1.repaint();
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
    class DragDrop extends MouseAdapter {
        int x;
        int y;
        int i;
        DragDrop(int i){
            this.i = i;
        }
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            doMove(e);
        }
        private void doMove(MouseEvent e) {
            int dx = e.getX() - x;
            int dy = e.getY() - y;
            if(area[i].contains(x, y)) {
                area[i].setLocation(area[i].getX()+dx,area[i].getY()+dy);
                //panel1.add
                panel1.repaint();
            }
        }
    }
}
*/

package xuly;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Diagram extends JPanel {
    //private int x[] = {50,400,726,976,50,400,726};
    private int y[] = {50,50,50,50,510,510,510};
    private static final String one = "/Users/VuKimNgan/Downloads/BaiTapOOP" ;


    JFrame f = new JFrame();
    JPanel panel1 = new JPanel();
    JTextArea[] area = new JTextArea[100];
    Component temp = new JTextArea();
    JButton zoomIn = new JButton("Bigger" );
    JButton zoomOut = new JButton("Smaller");
    public void paint(Graphics g) throws  IndexOutOfBoundsException {
        //String one = "/Users/VuKimNgan/Downloads/BaiTapOOP" ;
        String b;
        Files files = new Files();
        files.readProject( one + "/src");
        readFile docFile = new readFile();
        ArrayList<String> str = files.getListFile();
        b = docFile.ReadOnlyFile( one + "/Documents/data.java");

        classMem[] tp = new classMem[files.getSizeOfListFile()];

        analysis xuly = new analysis(b, tp);

        xuly.FuckJava();


        setBackground(Color.BLACK);
        setBackground(Color.WHITE);


        g.setFont(new Font("Arial", Font.BOLD, 13));
        int n = 0;
        int i = 0;

        for (i = 0, n = 0; i < files.getSizeOfListFile(); i++, n++) {
            int max[] = new int[files.getSizeOfListFile()] ;
            int max1[] = new int[files.getSizeOfListFile()];

            int w[] = new int[files.getSizeOfListFile()];
            w[i] = 150+max[i]*4;
            int h_m[] = new int[files.getSizeOfListFile()];
            int h_a[] = new int[files.getSizeOfListFile()];
            //int x[] = new int[files.getSizeOfListFile()];
            //int y[] = new int[files.getSizeOfListFile()];
            for (int k = 0; k < tp[i].getSizeClass(); k++) {
                max1[i] = tp[i].getMethods().get(0).length();

                for (int j = 0; j < tp[i].getSizeMethods(); j++) {


                    if (tp[i].getMethods().get(j).length() > max1[i]) {
                        max[i] = tp[i].getMethods().get(j).length();

                    }
                }


                g.drawString(tp[i].getNameClass().get(k), 50+370*i, 79);
                //System.out.println(tp[i].getNameClass().get(k).length());

                for (int j = 0; j < tp[i].getSizeAttribute(); j++) {

                    g.drawString(tp[i].getAttribute().get(j), 50+370*i, 105 + 15 * j);

                }
                for (int j = 0; j < tp[i].getSizeMethods(); j++) {

                    g.drawString(tp[i].getMethods().get(j), 50+370*i, 108 + tp[i].getAttribute().size() * 16 + 15 * j);

                }
                w[i] = 150+max[i]*4;
                h_m[i] = tp[i].getSizeMethods() * 16;
                h_a[i] = tp[i].getAttribute().size() * 16;//

            }

            //x[i] += x[i] + 100 + 150+max[i]*4;
            g.drawRect(50+370*i, 50, w[i], 40);
            g.drawRect(50+370*i, 90, w[i], h_a[i]);
            g.drawRect(50+370*i, 90 + tp[i].getSizeAttribute() * 16, w[i], h_m[i]);

        }
        //System.out.println(x[i] + " " + w[i]);
        //}

    }



}
