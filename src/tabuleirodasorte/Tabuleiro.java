
package tabuleirodasorte;

import java.util.Random;

public class Tabuleiro {

    //Atributos
    private int matrizTabuleiro[][] = new int[10][10];
    private int palpites[] = new int[2];
    private final int bonus = 1000;
    
    //Construtores
    public Tabuleiro(){
        //Regra..
        //this.matrizTabuleiro = matrizTabuleiro;
        //this.palpites = palpites;
        int i;
        int j;
        
        //Preset do tabuleiro
        for(i =0;i<10;i++){
            for(j=0;j<10;j++){
                matrizTabuleiro[i][j] = 0;
                System.out.println("Matriz Tabuleiro["+i+"]["+j+"]="+matrizTabuleiro[i][j]);
            }
        }
        System.out.println("");
        //Preset dos Palpites
        for(i=0;i<2;i++){
            palpites[i] = 0;
            System.out.println("palpites["+i+"]="+palpites[i]);
        } 
        System.out.println("");
    }
    //Getters and Setters dos atributos
    
    //A matriz tabuleiro só precisa aparecer, não será alterada pelo usuário
    public int[][] getMatrizTabuleiro() {
        return matrizTabuleiro;
    }

    //O vetor palpites vai aparecer na tela, então usamos get para retornar os valores
    public int[] getPalpites() {
        return palpites;
    }

    //O vetor palpites vai receber os palpites do usuário, então set serve para alterar o vetor de palpites
    public void setPalpites(int[] palpites) {
        this.palpites = palpites;
    }

    //Bonus é um valor preset da programação, uma regra estabelecida no problema, então usamos somente get e só pegaremos esse valor para uso sem alterá-lo.
    public int getBonus() {
        return bonus;
    }
    
    //Métodos de funcionalidade da classe
    
    //O método sortear vai sortear um número aleatório para cada posição do tabuleiro
    void sortear(){
        int i;
        int j;
        for(i=0;i<10;i++){
            for(j=0;j<10;j++){
                Random r = new Random();                    //Para isso, invocamos o objeto random
                matrizTabuleiro[i][j] = r.nextInt(100)+1;   //Cada posição recebe seu número sorteado por r.next int
            }
        }
    }
    
    //O método listar varre o tabuleiro e exibe os números sorteados em cada posição
    void listar(){
        int i;
        int j;
        for(i=0;i<10;i++){
            for(j=0;j<10;j++){
                System.out.println("Matriz Tabuleiro ["+i+"]["+j+"] = "+getMatrizTabuleiro()[i][j]);
            }
        }
    }
    
    //O método verificar prêmio varre o tabuleiro e retorna os resultados do sorteio
    void verificarPremio(int palpites[]){
        int i;                  //Iterador para palpites[]
        int j;                  //Iteradores J e K para varrer o tabuleiro
        int k;
        //Esse método precisa contabilizar os palpites separadamente....
        
        int saldo1 = 0;         //Saldo para primeiro palpite
        int nvezes1 = 0;        //Número de vezes que o primeiro palpite foi encontrado no tabuleiro
        int saldo2 = 0;         //Saldo para primeiro palpite
        int nvezes2 = 0;        //Número de vezes que o segundo palpite foi encontrado no tabuleiro
        
        //Variáveis usadas para relatório final...
        
        int num1=0;             //Recebe o primeiro palpite, caso esteja no tabuleiro - usado no relatório final
        int num2=0;             //Recebe o segundo palpite, caso esteja no tabuleiro - usado no relatório final
        int TotalGeral = 0;     // Soma das duas contabilidades - saldo 1 e saldo 2 - para relatório final
        
        //Para cada palpite o tabuleiro é varrido
        for(i=0;i<2;i++){
            for(j=0;j<10;j++){
                for(k=0;k<10;k++){
                    //Caso palpite encontrado...
                    if (getMatrizTabuleiro()[j][k] == palpites[i]){
                        //Caso seja o primeiro, atualiza a contabilidade do primeiro palpite
                        if(i == 0){
                            num1 = palpites[i];
                            saldo1 += getBonus();
                            nvezes1 += 1;
                            System.out.println("Numero1: " + palpites[i]);
                            System.out.println("bonus1: "+ saldo1);
                            System.out.println("quantas vezes?1 "+ nvezes1);
                        }
                        //Caso seja o segundo, atualiza a contabilidade do segundo palpite
                        else if(i == 1){
                            num2 = palpites[i];
                            saldo2 += getBonus();
                            nvezes2 += 1;
                            System.out.println("Numero2: " + palpites[i]);
                            System.out.println("bonus2: "+ saldo2);
                            System.out.println("quantas vezes?2 "+ nvezes2);
                        }
                    }
                }
            }
        }
        //Total geral
        TotalGeral = saldo1 + saldo2;
        //Síntese de resultados
        System.out.println("-------------------------");
        System.out.println("Resultados: ");
        System.out.println("                         ");
        System.out.println("Numero1: "+num1);
        System.out.println("Quantas vezes sorteado: "+nvezes1);
        System.out.println("Total de bônus: "+saldo1);
        System.out.println("                         ");
        System.out.println("Numero2: "+num2);
        System.out.println("Quantas vezes sorteado: "+nvezes2);
        System.out.println("Total de bônus: "+saldo2);
        System.out.println("-------------------------");
        System.out.println("Total Geral: "+TotalGeral);
        System.out.println("                                          ");
        System.out.println("Prêmio Total a ser recebido: R$"+TotalGeral+",00");
    }
}
