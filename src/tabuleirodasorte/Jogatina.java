
package tabuleirodasorte;

import java.util.Arrays;    //Arquivo importado para prover o controle sobre matrizes e vetores
import java.util.Scanner;   //Arquivo importado para implementar a captação de ações do usuário no teclado.

//Classe principal do programa de aplicação
public class Jogatina {
   
    //Método de entrada do programa de aplicação
    public static void main(String[] args) {
        // TODO code application logic here
        int i;                                              //Iterador para captação do teclado
        int palp[] = new int[2];                            //Vetor independente para receber a captação do teclado
        Tabuleiro tab1 = new Tabuleiro();                   //Instância da classe tabuleiro - Objeto criado
        Scanner scan = new Scanner(System.in);              //Objeto Scanner que capta o teclado
        for(i=0;i<2;i++){                                   //Loop de captação dos palpites
            System.out.println("Digite o palpite: ");
            palp[i]= Integer.parseInt(scan.nextLine());
        }
        //Obs***
        //Testes iniciais indicavam que o vetor independente não passava os valores automaticamente para o vetor 
        //"Palpites" da classe tabuleiro - palp[] = 1,5 e palpites[] = 0,0 no println().
        //Abaixo, instrução de passagem de vetor para vetor...
        
        
        tab1.setPalpites(palp);                                     //Passagem de palpites para vetor "palpites" da classe tabuleiro
        
        //Teste de comparação...
        System.out.println("TESTE DE COMPARAÇÃO: ");
        System.out.println("Vetor palp independente: "+Arrays.toString(palp));                  //Exibição do vetor palp "independente" 
        System.out.println("            VS");
        System.out.println("Vetor Palpites da Classe: "+Arrays.toString(tab1.getPalpites()));    //Exibição do vetor "palpites" da classe - Solução: converter de array para string
        System.out.println("******************************");
        tab1.sortear();                                           //chamada ao método sortear da classe "Tabuleiro" 
        tab1.listar();                                            //chamada ao método listar da classe "Tabuleiro"
        System.out.println("                              ");
        tab1.verificarPremio(tab1.getPalpites());               //chamada ao método verificarPremio da classe "Tabuleiro"  
        //Fim
    }
    
}
