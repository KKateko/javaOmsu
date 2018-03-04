package imit.student.classes;

import static java.lang.String.valueOf;

public class StringProcessor {
    public  static String copyOfString(String s,int N)throws IllegalArgumentException{
        String ans="";
        if(N<0)throw new IllegalArgumentException();
        if(N>0){
            for(int i=0;i<N;i++)
            {
                ans+=s;
            }
        }
        return ans;
    }
    public static  int countOfEntries(String one,String two){
        int count=0;
        int index=0;
        if(one!="" && two=="")return 0;
        while(index<=one.length()-two.length()){
            index=one.indexOf(two,index);
            System.out.println(index);
            if(index>=0){
            index+=1;
            count++;
            }
            else break;
        }
        return count;
    }
    public static String newStringFromOld(String old){
        String newStr=old;
        newStr=newStr.replaceAll("1","один");
        newStr=newStr.replaceAll("2","два");
        newStr= newStr.replaceAll("3","три");
        return newStr;
    }
    public static void modificationStr(StringBuilder str){
        int index=1;
            while(index<=str.length()-1){
                str.deleteCharAt(index);
                index+=1;
            }

    }
    public static void swapStr(StringBuilder str) {
        String buf1, buf2;
        int indexOfBeginOne = 0, indexOfEndOne,
                indexOfBeginTwo, indexOfEndTwo;
        if(str.length()!=0) {
            while (str.charAt(indexOfBeginOne) == ' ') {
                indexOfBeginOne++;
            }
            indexOfEndOne = indexOfBeginOne;
            while (str.charAt(indexOfEndOne) != ' ') {
                indexOfEndOne++;
            }
            indexOfEndTwo = str.length() - 1;
            while (str.charAt(indexOfEndTwo) == ' ') {
                indexOfEndTwo--;
            }
            indexOfBeginTwo = indexOfEndTwo;
            while (str.charAt(indexOfBeginTwo) != ' ') {
                indexOfBeginTwo--;
            }
            indexOfBeginTwo++;
            indexOfEndTwo++;
            System.out.println(indexOfBeginTwo);
            buf1 = str.substring(indexOfBeginOne, indexOfEndOne);
            buf2 = str.substring(indexOfBeginTwo, indexOfEndTwo);
            str.replace(indexOfBeginOne,indexOfEndOne,buf2);
            indexOfBeginTwo+=(buf2.length()-buf1.length());
            str.replace(indexOfBeginTwo,indexOfBeginTwo+buf2.length(),buf1);
        }
    }
    public static StringBuilder hexToDec(StringBuilder str){
        int index,dec;
        StringBuilder answer=new StringBuilder(str);
        index=str.indexOf("0x");
        if(index!=-1){
        StringBuilder buf=new StringBuilder(str.substring(index+2,index+10));
        dec=Integer.parseInt(buf.toString(),16);
        answer=answer.delete(index,index+10);
        answer=answer.insert(index,valueOf(dec));
        }
        return answer;
    }
}

