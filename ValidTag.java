public class ValidTag {

    static class tag_return_type{
        String tagName;
        boolean answer;
        tag_return_type(String tagName,boolean answer){
            this.tagName = tagName;
            this.answer = answer;
        }
    }

    static tag_return_type isTagValid(String code,int si,int end){
        String tag_name = "";
        for (int i=si+1;i<end && code.charAt(i)!='>';i++){
            tag_name+=code.charAt(i);
        }
        // checking tag validity
        if (tag_name.length()>9){
            // return false;
            return new tag_return_type(tag_name, false);

        }
        for (int i=0;i<tag_name.length();i++){
            Character ch = tag_name.charAt(i);
            if (!Character.isUpperCase(ch)){
                // return false;
                return new tag_return_type(tag_name, false);
            }
        }

        // check closed tag
        int len = 3+tag_name.length();
        // for (int i=code.length()-1;i>=len;i--)
        int ei = end-len;
        if (code.charAt(ei)!='<' || code.charAt(ei+1)!='/' || code.charAt(end-1)!='>'){
            // return false;
            return new tag_return_type(tag_name, false);
        }
        for (int i=ei+2,j=0;i<end-1;i++,j++){
            if (code.charAt(i)!=tag_name.charAt(j)){
                // return false;
                return new tag_return_type(tag_name, false);
            }
        }
        // return true;
        return new tag_return_type(tag_name, true);
    }
    static boolean isValid(String code){
        tag_return_type obj = isTagValid(code, 0,code.length());
        if (!isTagValid(code, 0,code.length()).answer){
            return false;
        }
        // System.out.println(tag_name);
        String tag_name = obj.tagName;
        int ei = code.length()-3+tag_name.length();
        String tag_content = "";
        int si = 2+tag_name.length();
        for (int i=si;i<ei;i++){
            tag_content+=code.charAt(i);
        }
        for (int i=0;i<tag_content.length();i++){
            if (tag_content.charAt(i)=='<'){
                tag_return_type validity = isTagValid(code, i, tag_content.length());
            }
        }
        System.out.println(tag_content);
        return false;
    }
    public static void main(String[] args) {
        String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        // String code = "<A> <B>  </A> </B>";
        System.out.println(isValid(code));
    }
}
