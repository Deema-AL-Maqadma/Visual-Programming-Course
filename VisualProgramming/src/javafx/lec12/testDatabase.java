package javafx.lec12;

import java.sql.*;

public class testDatabase {

    static private Connection con;//هنعمل منه اختصار
    static private Statement stat;
    static private ResultSet res;
    static String className = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://127.0.0.1:3306/first?user=root&password=";

    public static void main(String[] args) {
        try {
            Class.forName(className);
            con = DriverManager.getConnection(url);
            stat = con.createStatement();
            String SQL = "SELECT * FROM student";
            //==========================================
            int result1 = stat.executeUpdate("INSERT INTO student(stuFn,stuLn,stuMobile)" // ترجع 1 اذا ناجحة واذا فشلت ترجع صفر
                    + "VALUES('Ahmed','Ali','05947355')");
            System.out.println("result = " + result1);
            //==========================================
            int result2 = stat.executeUpdate("UPDATE student SET stuFn='Omar' WHERE stuId =2");
            System.out.println("result = " + result2);
            //==========================================
            int result3 = stat.executeUpdate("DELETE FROM student  WHERE stuId =3");
            System.out.println("result = " + result3);

            //==========================================
            res = stat.executeQuery(SQL);//لانها هترجع بيانات لازم استقبلهم في متغير لو ما كنت عارفة النوع يلي هيرجع بستخدم متغير من نوع var
            while (res.next()) {// المؤشر بيكون برا وعشان اخليه ياشر على اول حقل بحطله نكست طول ما في بيانات هترجع ترو وهيكمل قراءة
                System.out.print(res.getInt(1) + " ");
                System.out.print(res.getString(2) + " ");
                System.out.print(res.getString(3) + " ");
                System.out.println(res.getString(4));
                System.out.println("======================================");
                System.out.print(res.getInt("stuId") + " ");
                System.out.print(res.getString("stuFn") + " ");
                System.out.print(res.getString("stuLn") + " ");
                System.out.println(res.getString("stuMobile"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
