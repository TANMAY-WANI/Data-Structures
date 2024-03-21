public class wildcardMatch {
    static boolean isMatch(String s,String p){
        if (!s.contains("*")  &&  !p.contains("*")  && s.length() != p.length()){
            System.out.println("False at 4");
            return false;
        }
        if (!s.contains("*") && !p.contains("*")){
            for (int i=0;i<s.length();i++){
                if (s.charAt(i)!=p.charAt(i) && (s.charAt(i)!='?' && p.charAt(i)!='?')){
                    System.out.println("hi");
                    System.out.println("False at 10");
                    return false;
                }
            }
            return true;
        }
        // System.out.println(s.indexOf("f"));
        for (int i=0,j=0;i<s.length() && j<p.length();i++,j++){
            // s.indexOf("*")
            if (s.charAt(i)=='*'){
                if (i==s.length()-1){
                    // last for String s. all further chars of p would be accepted
                    return true;
                }
                Character next = s.charAt(i+1);
                for (int k=j;k<p.length();k++){
                    if (p.charAt(k)==next){
                        j=k-1;
                        break;
                    }else{
                        j=-10;
                    }
                }
                if(j==-10){
                    System.out.println("False at 33");
                    return false;
                }
            }
            else if (p.charAt(j)=='*'){
                if (j==p.length()-1){
                    // last for String s. all further chars of p would be accepted
                    return true;
                }
                Character next = p.charAt(j+1);
                // System.out.println(i);
                for (int k=i;k<s.length();k++){
                    if (s.charAt(k)==next){
                    i=k-1;
                        break;
                    }else{
                        i=-10;
                    }
                }
                if(i==-10){
                    System.out.println("False at 52");
                    return false;
                }
            }
            else{
                if(s.charAt(i)!=p.charAt(j) && s.charAt(i)!='?' && p.charAt(j)!='?'){
                    System.out.println("False at 57");
                    System.out.println(s.charAt(i));
                    System.out.println(p.charAt(j));

                    return false;
                }
            }

        }

        return true;
    }
    public static void main(String[] args) {
        String s = "abcabczzzde";
        String p = "*abc???de*";
        System.out.println(isMatch(s, p));
    }
}
