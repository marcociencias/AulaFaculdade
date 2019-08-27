package servidortcpsimples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTcpSimples {

    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(10001);
        System.out.println("Porta 10001 aberta.");
        
        while(true)
        {
        System.out.println("Aguardando cliente.......");
        Socket cliente = servidor.accept();
        Scanner s = new Scanner(cliente.getInputStream());
        while(s.hasNextLine())
        {
        System.out.println(s.nextLine());
        }
        s.close();
        cliente.close();
        }     
    }
    
}
