import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Servidor aguardando 2 clientes...");


        // Conectar Cliente A
        Socket clienteA = servidor.accept();
        System.out.println("Cliente A conectado!");
        BufferedReader inA = new BufferedReader(new InputStreamReader(clienteA.getInputStream()));
        PrintWriter outA = new PrintWriter(clienteA.getOutputStream(), true);


        // Conectar Cliente B
        Socket clienteB = servidor.accept();
        System.out.println("Cliente B conectado!");
        BufferedReader inB = new BufferedReader(new InputStreamReader(clienteB.getInputStream()));
        PrintWriter outB = new PrintWriter(clienteB.getOutputStream(), true);


        String cliente1, cliente2;

        cliente1 = inA.readLine(); //recebendo o dado do jogador A
        cliente2 = inB.readLine(); //recebendo o dado do jogador B


        // Comparar pedra papel tesoura


        if(cliente1.equals("Tesoura")&& cliente2.equals("Pedra")){
            outA.println("Infelizmente você perdeu!"); //enviar para o cliente
            outB.println("Parabéns, você ganhou!"); //enviar para o cliente
        }

        else if (cliente1.equals("Tesoura")&& cliente2.equals("Papel")){
            outA.println("Parabéns, você ganhou!");
            outB.println("Infelizmente você perdeu!");

        }
        else if (cliente1.equals("Tesoura")&& cliente2.equals("Tesoura")){
            outA.println("Deu empate");
            outB.println("Deu empate");
        }

        else if (cliente1.equals("Pedra")&& cliente2.equals("Tesoura")){
            outA.println("Parabéns, você ganhou!");
            outB.println("Infelizmente você perdeu!");
        }

        else if (cliente1.equals("Pedra")&& cliente2.equals("Papel")){
            outA.println("Infelizmente você perdeu!");
            outB.println("Parabéns, você ganhou!");
        }

        else if (cliente1.equals("Pedra")&& cliente2.equals("Pedra")){
            outA.println("Deu empate");
            outB.println("Deu empate");
        }

        else if (cliente1.equals("Papel")&& cliente2.equals("Pedra")){
            outA.println("Parabéns, você ganhou!");
            outB.println("Infelizmente você perdeu!");
        }

        else if (cliente1.equals("Papel")&& cliente2.equals("Tesoura")){
            outA.println("Infelizmente você perdeu!");
            outB.println("Parabéns, você ganhou!");
        }

        else if (cliente1.equals("Papel")&& cliente2.equals("Papel")){
            outA.println("Deu empate");
            outB.println("Deu empate");
        }

        // Fechar conexões
        clienteA.close();
        clienteB.close();
        servidor.close();
    }
}

