public class Main {
    public static void main(String[] args) {
        try {
            MenusGestionBaseDatos.menuPrincipal();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}