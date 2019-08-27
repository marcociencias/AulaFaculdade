
package clientetcpsimples;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTcpSimples {

    public static void main(String[] args) throws IOException {
      
        System.out.println("Informe mensagem: ");
        Scanner teclado = new Scanner(System.in);
        Socket socket = new Socket("10.180.202.195",12345);
        PrintStream saida = new PrintStream(socket.getOutputStream());
        String texto = null;
        boolean sair = false;
        while(!sair && teclado.hasNextLine())
        {
            texto = teclado.nextLine();
            if(texto.equalsIgnoreCase("sair"))
            {
                sair = true;
            }
            saida.println(texto);
        }
        
        saida.close();
        teclado.close();
        socket.close();
    }
    
}
