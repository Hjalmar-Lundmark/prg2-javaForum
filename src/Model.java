import java.sql.*;

public class Model {
    Connection conn = null;
    String user = dbData.user;
    String db = dbData.URL;
    String host = dbData.host;
    String pwd = dbData.pwd;
    Statement stmt;
    String SQLQuery;
    ResultSet result;
    boolean loggedIn = false;

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + db + ":3306/" + host + "? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPosts() {
        String output = "";
        try {
            stmt = conn.createStatement();
            SQLQuery = "SELECT * FROM hl21forum";
            result = stmt.executeQuery(SQLQuery);

            /*ResultSetMetaData metadata = result.getMetaData();
            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }*/

            /*
            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getInt("authorId");
                System.out.println(output);
            }
            */

            while (result.next()) {
                output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getInt("authorId") + "\n" + "\n";
                //System.out.println(output);
            }

            /*//INSERT command
            SQLQuery = "INSERT INTO hl21forum(title,content) VALUES ('"+"HEJ"+"', '"+"brödtext"+"')";
            stmt.executeUpdate(SQLQuery);
            */

            /*//UPDATE
            SQLQuery = "UPDATE hl21forum SET title='"+"Tjena"+"' WHERE id="+2+"";
            stmt.executeUpdate(SQLQuery);
            */

            /*//Full create post in my forum
            SQLQuery = "INSERT INTO hl21forum(title,content,authorId) VALUES ('"+"Java post 2"+"', '"+"Mer innehåll från java"+"', "+2+")";
            stmt.executeUpdate(SQLQuery);
            */

            stmt.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void login(String u, String pwd) {
        // check login creds, then loggedIn = true

    }
}
