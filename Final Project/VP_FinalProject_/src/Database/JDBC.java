//===========================================================================================================
/** My Name : Deema Mohammed AL-Maqadma
 * ID : 2320230766
 * Final Project : Library Management System
 * Presented to : Eng. Mahmoud Ashour
 *   --->>> GO A HERO !!!
 */
//===========================================================================================================
package Database;

import Models.Book;
import Models.SecurityUtil;
import Models.User;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//===========================================================================================================

public class JDBC {

    private Connection con;
    private Statement stat;
    private ResultSet res;
    String className = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/library_finalproject?user=root&password=";
//===========================================================================================================

    public JDBC() {
        try {
            Class.forName(className);
            con = DriverManager.getConnection(url);
            stat = con.createStatement();
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
//===========================================================================================================

    public ObservableList<Book> getAllBooks() {
        ObservableList<Book> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM books";

        try {
            res = stat.executeQuery(query);
            while (res.next()) {
                Book book = new Book(
                        res.getInt("id"),
                        res.getString("title"),
                        res.getString("author"),
                        res.getString("genre")
                );
                list.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Fetch Error: " + e.getMessage());
        }

        return list;
    }
//===========================================================================================================

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }
//===========================================================================================================

    public void deleteBook(int id) {
        String query = "DELETE FROM books WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
//===========================================================================================================

    public Book searchBook(int id) {
        String query = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre")
                );
            }
        } catch (SQLException e) {
            System.out.println("Search Error: " + e.getMessage());
        }
        return null;
    }
//===========================================================================================================

    public void saveUser(User user) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            // تشفير كلمة المرور قبل التخزين
            String hashedPassword = SecurityUtil.hashPassword(user.getPassword());
            ps.setString(2, hashedPassword);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("User Save Error: " + e.getMessage());
        }
    }
//===========================================================================================================

    public void ListUsers(User user) {
        String query = "INSERT INTO list_users (fullname, username, password) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            // تشفير كلمة المرور قبل التخزين
            String hashedPassword = SecurityUtil.hashPassword(user.getPassword());
            ps.setString(3, hashedPassword);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("List User Error: " + e.getMessage());
        }
    }
    //===========================================================================================================

    public boolean isUsernameExists(String username) {
        String query = "SELECT username FROM list_users WHERE username = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Check Username Error in list_users: " + e.getMessage());
        }

        return false;
    }
//===========================================================================================================

    public String findUsernameByPassword(String hashedPassword) {
        String[] tables = {"list_users", "users"};

        for (String table : tables) {
            String query = "SELECT username FROM " + table + " WHERE password = ?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, hashedPassword);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getString("username");
                }
            } catch (SQLException e) {
                System.out.println("Search Error in " + table + ": " + e.getMessage());
            }
        }

        return null;
    }
//===========================================================================================================

    public boolean updatePasswordInTable(String tableName, String username, String newHashedPassword) {
        String query = "UPDATE " + tableName + " SET password = ? WHERE username = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, newHashedPassword);
            ps.setString(2, username);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Update Error in " + tableName + ": " + e.getMessage());
            return false;
        }
    }

//===========================================================================================================
    public boolean checkPassword(String username, String inputPassword) {
        String query = "SELECT password FROM list_users WHERE username = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashed = rs.getString("password");
                String inputHashed = SecurityUtil.hashPassword(inputPassword);

                return storedHashed.equals(inputHashed);
            }
        } catch (SQLException e) {
            System.out.println("Check Error: " + e.getMessage());
        }
        return false;
    }
//===========================================================================================================

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
//===========================================================================================================
    // لاختبارالاتصال بقاعدة البيانات

    public boolean testConnection() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
//===========================================================================================================
// My Name : Deema Mohammed AL-Maqadma
// ID : 2320230766
