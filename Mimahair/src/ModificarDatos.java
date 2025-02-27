import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ModificarDatos {

    public static void menuModificarDatos(Connection conn) {
        boolean isRunning=true;

        while (isRunning) {
            Scanner opcionDatos = new Scanner(System.in);
            System.out.println("Que datos quieres modificar?");
            System.out.println("1. Email");
            System.out.println("2. Telefono");
            System.out.println("3. Contraseña");
            System.out.println("4. Salir");

            int seleccion = opcionDatos.nextInt();
            opcionDatos.nextLine();
            switch (seleccion) {
                case 1 -> {
                    modificarEmail(conn);
                }
                case 2 -> {
                    modificarTlf(conn);
                }
                case 3 -> {
                    modificarContrasena(conn);
                }
                case 4 -> {
                    isRunning=false;
                }
            }


        }
    }

    public static void modificarContrasena(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña actual: ");
        int contrasena = scanner.nextInt();
        // Limpiar el buffer
        System.out.print("Ingrese nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        PreparedStatement pstmt = null;
        try {
            // Preparar la sentencia SQL para actualizar el nombre del empleado
            String sql = "UPDATE clientes SET contrasena = ? WHERE contrasena = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nuevaContrasena);
            pstmt.setInt(2, contrasena);
            // Ejecutar el UPDATE
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Contraseña modificada!");
            } else {
                System.out.println("Contraseña incorrecta!");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar contraseña: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void modificarEmail(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña actual: ");
        String contrasena = scanner.nextLine();
        //scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese nuevo email: ");
        String nuevoEmail = scanner.nextLine();
        PreparedStatement pstmt = null;
        try {
            // Preparar la sentencia SQL para actualizar el nombre del empleado
            String sql = "UPDATE clientes SET email = ? WHERE contrasena = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nuevoEmail);
            pstmt.setString(2, contrasena);
            // Ejecutar el UPDATE
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Email modificado!");
            } else {
                System.out.println("Contraseña incorrecta!");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el email: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void modificarTlf(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la contraseña actual: ");
        String contrasena = scanner.nextLine();
        //scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese nuevo telefono: ");
        String nuevoTlf = scanner.nextLine();
        PreparedStatement pstmt = null;
        try {
            // Preparar la sentencia SQL para actualizar el nombre del empleado
            String sql = "UPDATE clientes SET tlf = ? WHERE contrasena = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nuevoTlf);
            pstmt.setString(2, contrasena);
            // Ejecutar el UPDATE
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Telefono modificado!");
            } else {
                System.out.println("Contraseña incorrecta!");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar telefono: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}