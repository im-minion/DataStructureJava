public class Q_242_ValidAnagram {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] a= new int[26];

        for(char c : s.toCharArray()){
            a[c-'a']++;
        }
        for(char c : t.toCharArray()){
            if(a[c-'a'] > 0)
                a[c-'a']--;
            else
                return false;
        }
        for(int x: a){
            if(x!=0) return false;
        }
        return true;

    }
}
