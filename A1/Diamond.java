/* Name: Chaiyanun Sakulsaowapakkul
   ID: 6681299
   Collaborators: Pannathron Kitisiri, Waranyu Chunhachatcharchai
*/

package A1;

public class Diamond {
    public static void main(String[] args) {
        printDiamond(3);
    }

    public static void printDiamond(int k) {
        for (int i = 1; i <= k; i++) {
            int upperStar = (2*i)-1;
            System.out.println("#".repeat(k - i + 1) + "*".repeat(upperStar) + "#".repeat(k - i + 1));
            }

        for (int i = 1; i < k; i++) {
            int lowerStar = (2*(k-1))-(2*i)+1;
            System.out.println("#".repeat(i + 1) + "*".repeat(lowerStar) + "#".repeat(i + 1));
        }
    }
}

