
package servidorthreadtcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServidorThreadTCP implements Runnable{

    public Socket cliente;
    
    public ServidorThreadTCP(Socket cliente)
    {
        this.cliente = cliente;
    }
      
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta !");
        
        while(true)
        {
            Socket cliente = server.accept();
            ServidorThreadTCP tratamento = new ServidorThreadTCP(cliente);
            Thread t = new Thread(tratamento);
            t.start();
        }       
    }

    @Override
    public void run() {
        System.out.println("Nova conexão de " + this.cliente.getInetAddress());
        try {
            Scanner s = new Scanner(this.cliente.getInputStream());
            while(s.hasNextLine())
            {
                System.out.println(s.nextLine());
            }
        s.close();
        this.cliente.close();        
        } catch (IOException ex) {
            Logger.getLogger(ServidorThreadTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexao fechada" + this.cliente.getInetAddress());
    }    
}
