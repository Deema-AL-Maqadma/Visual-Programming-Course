//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package Models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();

            // تحويل البايتات إلى سلسلة Hex
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Hash Error: " + e.getMessage());
            return null;
        }
    }
}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
