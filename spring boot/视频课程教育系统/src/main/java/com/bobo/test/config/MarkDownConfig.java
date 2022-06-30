package com.bobo.test.config;

public class MarkDownConfig {

    public String translateToHtmlInline(String line) {
        for (int i = 0; i < line.length(); i++) {
            // 图片
            if (i < line.length() - 4 && line.charAt(i) == '!' && line.charAt(i + 1) == '[') {
                int index1 = line.indexOf(']', i + 1);
                if (index1 != -1 && line.charAt(index1 + 1) == '(' && line.indexOf(')', index1 + 2) != -1) {
                    int index2 = line.indexOf(')', index1 + 2);
                    String picName = line.substring(i + 2, index1);
                    String picPath = line.substring(index1 + 2, index2);
                    line = line.replace(line.substring(i, index2 + 1), "<img alt='" + picName + "' src='" + picPath + "' />");
                }
            }

            //代码块
            if (i < line.length() - 6 && line.indexOf("```", i) == i) {
                int count =1;
                int index = line.indexOf("\n", i);
                int index1 = line.indexOf("```", index);
                String language = line.substring(i + 3, index);
                String codes="";
                for (int h=index+1;h<index1;) {
                    int index2 = line.indexOf("\n", h);
                    String code=line.substring(h,index2);
                    h=index2+1;
                    count ++;
                    code=CodeHighlight(code);
                    if (index2<index1 ){
                        if (count%2==1) {
                            codes = codes + "<li class='one'><code>" + code + "</code></li>";
                        }else {
                            codes = codes + "<li class='two'><code>" + code + "</code></li>";
                        }
                    }
                }
                line = line.replace(line.substring(i, index1 + 3), "</p><ol id='" + language + "' class='code'>" + codes + "</ol><p>");
                index1 = line.indexOf("</ol><p>", index1);
                i =  index1 + 8;
            }

            // 链接
            if (i < line.length() - 3 && ((i > 0 && line.charAt(i) == '[' && line.charAt(i - 1) != '!') || (line.charAt(0) == '['))) {
                int index1 = line.indexOf(']', i + 1);
                if (index1 != -1 && line.charAt(index1 + 1) == '(' && line.indexOf(')', index1 + 2) != -1) {
                    int index2 = line.indexOf(')', index1 + 2);
                    String linkName = line.substring(i + 1, index1);
                    String linkPath = line.substring(index1 + 2, index2);

                    line = line.replace(line.substring(i, index2 + 1), "<a href='" + linkPath + "'>" + linkName + "</a>");
                }
            }

            // 行内引用
            if (i < line.length() - 1 && line.charAt(i) == '`' && line.charAt(i + 1) != '`') {
                int index = line.indexOf('`', i + 1);
                if (index != -1) {
                    String quoteName = line.substring(i + 1, index);
                    line = line.replace(line.substring(i, index + 1), "<code class='line'>" + quoteName + "</code>");
                    line.indexOf("</code>", i + 1);
                    i = line.indexOf("</code>", i + 1)+7;
                }
            }

            // 粗体
            if (i < line.length() - 2 && line.charAt(i) == '*' && line.charAt(i + 1) == '*') {
                int index = line.indexOf("**", i + 1);
                if (index != -1) {
                    String quoteName = line.substring(i + 2, index);
                    line = line.replace(line.substring(i, index + 2), "<strong>" + quoteName + "</strong>");
                }
            }
            // 斜体
            if (i < line.length() - 2 && line.charAt(i) == '*' && line.charAt(i + 1) != '*') {
                int index = line.indexOf('*', i + 1);
                if (index != -1) {
                    String quoteName = line.substring(i + 1, index);
                    line = line.replace(line.substring(i, index+1), "<i>" + quoteName + "</i>");
                }
            }
            // h1标题
            if (i < line.length() - 1 && line.charAt(i) == '#' && line.charAt(i + 1) != '#') {
                line = btMethod(i,line,1);
            }
            // h2标题
            if (i < line.length() - 2 && line.indexOf("##", i) == i && line.charAt(i + 2) != '#') {
                line = btMethod(i,line,2);
            }
            // h3标题
            if (i < line.length() - 3 && line.indexOf("###", i) == i && line.charAt(i + 3) != '#') {
                line = btMethod(i,line,3);
            }
            // h4标题
            if (i < line.length() - 4 && line.indexOf("####", i) == i && line.charAt(i + 4) != '#') {
                line = btMethod(i,line,4);
            }
            // h5标题
            if (i < line.length() - 5 && line.indexOf("#####", i) == i && line.charAt(i + 5) != '#') {
                line = btMethod(i,line,5);
            }

            // h6标题
            if (i < line.length() - 6 && line.indexOf("######", i) == i && line.charAt(i + 6) != '#') {
                line = btMethod(i,line,6);
            }
        }
        return line;
    }

    public String btMethod(int i,String line,int h){
        String h0= "#";
        for (int id=1;id<h;id++){
            h0 = h0 + "#";
        }
        if (i < line.length() - 1 && line.indexOf(h0, i) == i && line.charAt(i + h) != '#') {
            int index = line.indexOf("\n", i + h);
            if (index != -1) {
                String hName = line.substring(i + h, index);
                line = line.replace(line.substring(i, index), "</p><h"+h+">" + hName + "</h"+h+"><p>");
            }
        }
        return line;
    }

    public String CodeHighlight(String code) {

        return code;
    }

    public String UpdateTranslateToHtmlInline(String line) {
        int index1;
        int index2;
        for(int i=0; i<line.length();i++) {

            //图片
            int index = line.indexOf("<img alt='");
            if(index!=-1) {
                index1 = line.indexOf("' src='", index);
                index2 = line.indexOf("' />", index1);
                if (index < line.length() - 17 && index1 < line.length() - 11 && index1 != -1) {
                    String picName = line.substring(index + 10, index1);
                    String picPath = line.substring(index1 + 7, index2);
                    line = line.replace(line.substring(index, index2 + 4), "![" + picName + "](" + picPath + ")");
                }
            }

            //行内代码
            index = line.indexOf("<code class='line'>");
            if(index!=-1) {
                index1 = line.indexOf("</code>", index);
                if (index < line.length() - 26) {
                    String linkName = line.substring(index + 19, index1);
                    line = line.replace(line.substring(index, index1 + 7), "`" + linkName + "`");
                }
            }

            //代码块
            index = line.indexOf("<ol id='");
            if(index!=-1) {
                int count =1;
                index1 = line.indexOf("' class='code'>", index);
                index2 = line.indexOf("</ol>", index1);
                if (index < line.length() - 28 && index1 < line.length() - 20 && index1 != -1) {
                    String language = line.substring(index + 8, index1);
                    String codes = "";
                    String code = "";
                    for(int h=index1+15;h+1<index2;){
                        count ++;
                        int index3;
                        if (count%2==1) {
                            index3 = line.indexOf("<li class='one'><code>", h);
                        }else {
                            index3 = line.indexOf("<li class='two'><code>", h);
                        }
                        int index4 = line.indexOf("</code></li>", index3);
                        code =line.substring(index3 + 22, index4);
                        if (index4<index2){
                            codes = codes+code;
                            h=index4+12;
                        }
                    }
                    line = line.replace(line.substring(index-4, index2 + 8), "```" + language  + codes + "```");
                    //line = line.replace(line.substring(index-9, index2 + 14), "```" + language  + codes + "```");
                }
            }

            //链接
            index = line.indexOf("<a href='");
            if(index!=-1) {
                index1 = line.indexOf("'>", index);
                index2 = line.indexOf("</a>", index1);
                if (index < line.length() - 15 && index1 < line.length() - 6 && index1 != -1) {
                    String linkName = line.substring(index1 + 2, index2);
                    String linkPath = line.substring(index + 9, index1);
                    line = line.replace(line.substring(index, index2 + 4), "[" + linkName + "](" + linkPath + ")");
                }
            }

            // 粗体
            index = line.indexOf("<strong>");
            if(index!=-1) {
                index1 = line.indexOf("</strong>", index);
                if (index < line.length() - 17) {
                    String quoteName = line.substring(index + 8, index1);
                    line = line.replace(line.substring(index, index1 + 9), "**" + quoteName +"**" );
                }
            }

            // 斜体
            index = line.indexOf("<i>");
            if(index!=-1) {
                index1 = line.indexOf("</i>", index);
                if (index < line.length() - 7) {
                    String quoteName = line.substring(index + 3, index1);
                    line = line.replace(line.substring(index, index1 + 4), "*" + quoteName +"*" );
                }
            }

            // h1标签
            index = line.indexOf("<h1>");
            if(index!=-1) {
                line=updateBtMethod(index,line,1);
            }

            //h2标签
            index = line.indexOf("<h2>");
            if(index!=-1) {
                line=updateBtMethod(index,line,2);
            }

            //h3标签
            index = line.indexOf("<h3>");
            if(index!=-1) {
                line=updateBtMethod(index,line,3);
            }

            //h4标签
            index = line.indexOf("<h4>");
            if(index!=-1) {
                line=updateBtMethod(index,line,4);
            }

            //h5标签
            index = line.indexOf("<h5>");
            if(index!=-1) {
                line=updateBtMethod(index,line,5);
            }

            //h6
            index = line.indexOf("<h6>");
            if(index!=-1) {
                line=updateBtMethod(index,line,6);
            }
        }
        return line;
    }

    public String updateBtMethod(int index,String line,int h){
        String h0= "#";
        for (int id=1;id<h;id++){
            h0 = h0 + "#";
        }
        int index1;
        if(index!=-1) {
            index1 = line.indexOf("</h"+h+">", index);
            if (index < line.length() -9) {
                String quoteName = line.substring(index + 4, index1);
                line = line.replace(line.substring(index-4, index1+8 ), h0 + quoteName );
            }
        }
        return line;
    }
}
