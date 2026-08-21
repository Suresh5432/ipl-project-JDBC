package utils;

import java.util.ArrayList;
import java.util.List;

public final class SplitLine {
    private SplitLine(){}
    public static String[] splitLine(String line){
        List<String> split=new ArrayList<>();
        StringBuilder value=new StringBuilder();
        boolean checkQuote=false;
        for(int i=0;i<line.length();i++) {
            char ch=line.charAt(i);
            if (ch=='"') {
                checkQuote=!checkQuote;
            }
            else if(ch==','&&!checkQuote) {
                split.add(value.toString());
                value=new StringBuilder();
            }
            else{
                value.append(ch);
            }
        }
        return split.toArray(new String[18]);
    }
}
