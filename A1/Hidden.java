/*
Name: Chaiyanun Sakulsaowapakkul
ID: 6681299
 */


package A1;

public class Hidden {
    public static void main(String[] args) {
        System.out.println(isHidden("welcometothehotelcalifornia","melon"));
        System.out.println(isHidden("welcometothehotelcalifornia","space"));
        System.out.println(isHidden("TQ89MnQU3IC7t6","MUIC"));
        System.out.println(isHidden("VhHTdipc07","htc"));
        System.out.println(isHidden("VhHTdipc07","hTc"));
    }

    public static boolean isHidden(String s, String t) {
        int index = 0;
        int j = 0;

        while (index < s.length() && j < t.length()) {
            if (s.charAt(index) == t.charAt(j)) {
                j++;   // move to the next 'j' to continue checking
            }
            index++;       // keep moving 'index' even if it's true or not
        }
        return j == t.length();    // if int j matches String t's length then it will be true
    }
}
