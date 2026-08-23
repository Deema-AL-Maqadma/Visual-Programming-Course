//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package Models;

public class User {

    String fullname, username, password;
//===========================================================================================================

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String fullname, String username, String password) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

//===========================================================================================================
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
