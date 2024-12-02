package Modelo;

public class Session {
    private static int usuarioId;

    public static int getUsuarioId() {
        return usuarioId;
    }

    public static void setUsuarioId(int id) {
        usuarioId = id;
    }
}
