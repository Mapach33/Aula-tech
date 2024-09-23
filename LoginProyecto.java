
package Modelo_Project;
import java.util.Scanner;
        
/**
 *
 * @author MATHIAS
 */
public class LoginProyecto {
    private String userDNI = "12345678";
    private String passDNI = "12345678";
    
    public void Login(){
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        boolean ingreso = false;
        
        while(intentos < 3 && !ingreso){
            System.out.println("\tInicio de Sesion\n");
            System.out.print("Usuario:\t");
            String  usuario = scanner.next();
        
            System.out.print("Password:\t");
            String  password = scanner.next();
            
            if(usuario.equals(userDNI) && password.equals(passDNI)){
                ingreso = true;
                System.out.println("Ingreso al menu principal!");
            }else{
                System.out.println("El usuario o contraseña son incorrectos. Vuelva a intentarlo.");
                intentos++;
            }
        }
        if(intentos == 3){
            System.out.println("Usted no puede ingresar al sistema");
        }
    }
    public static void main(String[] args){
        
        LoginProyecto login = new LoginProyecto();
        
        login.Login();
        
    }
}
