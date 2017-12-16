package xuly;

import java.util.Stack;
import java.util.StringTokenizer;

public class standard {

    public String standard(String str) {
        Stack st = new Stack();
        int count = 0;
        String strNoiDung = "";
        String strChuanHoa = "";
        //str = str.trim();
        //str = str.replaceAll("\\s+", " ");
        StringTokenizer string = new StringTokenizer(str, " ");
        while (string.hasMoreTokens()) {
            String tachToken;
            // System.out.println();
            tachToken = string.nextToken();
            //System.out.println("day la  "+tachToken);
            StringTokenizer st1 = new StringTokenizer(tachToken, "{}();,", true);
            while (st1.hasMoreTokens()) {

                strNoiDung += st1.nextToken() + " ";

            }
        }

        String[] words = strNoiDung.split("\\s++");

        for (int i = 0; i<words.length ;i++) {

            if ("{".equals(words[i])) {
                count ++;
            }

            if (count >= 2 && words[i].equals("{")) {

                st.push("{");

            }
            if ("}".equals(words[i]) ) {
                if (!st.isEmpty())
                    st.pop();

            }
            if (st.isEmpty()) {

                strChuanHoa += words[i] + " ";
            }
        }
        return strChuanHoa;
    }
}
