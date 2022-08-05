package util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    private static final String DATABASE_LOCATION = "C:\\Users\\santi\\Documents\\NetBeansProjects\\Informes\\src\\main\\java\\util\\ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + DATABASE_LOCATION;

        return DriverManager.getConnection(url);
    }

    public static boolean isDatabaseEmpty() {
        File file = new File(DATABASE_LOCATION);
        return file.length() == 0;
    }

}
