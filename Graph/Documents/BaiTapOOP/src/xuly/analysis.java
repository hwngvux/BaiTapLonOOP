package xuly;

public class analysis extends classMem{


    String str = "";
    classMem[] tpClass;
    public analysis (String str, classMem[] tpClass) {
        this.str = str;
        this.tpClass = tpClass;
    }

    public void FuckJava() throws ArrayIndexOutOfBoundsException {
        String[] kkk = str.split(" END ");
        // System.out.println(kkk[1]);
        for (int j = 0; j <kkk.length; j++){

            tpClass[j] = new classMem();
            String[] words = kkk[j].split("\\s");


            for (int i = 0 ; i < words.length; i++) {
                if ("class".equals(words[i])) {
                    tpClass[j].setNameClass(words[i + 1]);
                    //\\System.out.println("f:" + tpClass.getNameClass());
                }
                if ("extends".equals(words[i])) {
                    tpClass[j].setNameSuperClass(words[i + 1]);
                }
            }



            String[] methods = kkk[j].split("\\}");
            for (int i = 0; i < methods.length; i++) {
                if (!methods[i].contains("public" + " " + tpClass[j].getNameClass())) { // Loáº¡i contructors
                    methods[0] = methods[0].substring(methods[0].indexOf("{") + 1);

                    if (methods[i].contains(";")) {
                        while (methods[i].contains(";")) {
                            methods[i] = methods[i].substring(methods[i].indexOf(";") + 1);
                        }
                    }

                    methods[i] = methods[i].replaceAll("@[A-Za-z]+ ", "");

                    if (methods[i].contains(" static ")) {
                        methods[i] = methods[i].replace(" static ", " ");
                    }
                    if (methods[i].contains(" final ")) {
                        methods[i] = methods[i].replace(" final ", " ");
                    }
                    if (methods[i].contains(" abstract ")) {
                        methods[i] = methods[i].replace(" abstract ", " ");
                    }

                    if (methods[i].contains(" public ")) {
                        methods[i] = methods[i].replace(" public ", "+ ");
                    }

                    if (methods[i].contains(" private ")) {
                        methods[i] = methods[i].replace(" private ", "- ");
                    }

                    if (methods[i].contains(" protected ")) {
                        methods[i] = methods[i].replace(" protected ", "# ");
                    }

                    if (!methods[i].contains("( )")) {
                        methods[i] = methods[i].replaceAll("\\s([A-Za-z0-9]+)\\s\\,", ",");
                        methods[i] = methods[i].replaceAll("\\s([\\x21-\\x7E]+)\\s\\)", " )");
                    }
                    if (methods[i].contains("throws")) {
                        methods[i] = methods[i].substring(0, methods[i].indexOf("throws"));
                    }
                    if (!" ".equals(methods[i])) {
                        tpClass[j].addMethods(methods[i]);
                    }
                }
            }
            String[] att = kkk[j].split("\\;");


            for (int i = 0;i < att.length;i++ ) {

                if (!att[i].contains("public" + " " + tpClass[j].getNameClass())) { // Loáº¡i contructors
                    att[0] = att[0].substring(att[0].indexOf("{") + 1);

                    if (att[i].contains("}")) {
                        while (att[i].contains("}")) {
                            att[i] = att[i].substring(att[i].indexOf("}") + 1);
                        }
                    }

                    att[i] = att[i].replaceAll("@[A-Za-z]+ ", "");
                    if (att[i].contains("private")) {
                        //if (att[i].contains(" double ") || att[i + 1].contains(" boolean ") || att[i + 1].contains(" String ") || att[i + 1].contains(" int ")) {
                        att[i] = att[i].replace("private", "-");
                        //att[i + 1] = att[i+1].replace(" double ", )
                        //}
                    }
                    if (att[i].contains(" public ")) {
                        //if (att[i + 1].contains("double") || att[i + 1].contains("boolean") || att[i + 1].contains(" String ") || att[i + 1].contains(" int ")) {
                        att[i] = att[i].replace(" public ", " + ");
                        //att[i + 1] = att[i+1].replace(" double ", )
                        //}
                    }
                    if (att[i].contains("=")) {
                        // fields[i] = fields[i] + " ;";
                        att[i] = att[i].replaceAll("\\s\\=\\s\\,", ",");
                        att[i] = att[i].replaceAll("\\s\\=\\s([\\x21-\\x7E]+)\\s\\,", ",");
                        if (att[i].contains("=")) {
                            att[i] = att[i].substring(0, att[i].indexOf("="));
                        }

                    }

                    if (!att[i].contains("( )")) {
                        att[i] = att[i].replaceAll("\\s([A-Za-z0-9]+)\\s\\,", ",");
                        att[i] = att[i].replaceAll("\\s([\\x21-\\x7E]+)\\s\\)", " )");
                    }
                    if (!" ".equals(att[i])) {
                        tpClass[j].addAttribute(att[i]);
                    }
                }
            }
            //tpClass[j].toStr();
        }
    }
}