import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Veiculo []veiculo = new Veiculo[20];

        double odometro = 0;
        int cont = 0 , quant = 0 ;
        boolean continuar = true , mais = true;
        do {
            System.out.printf("[ C ] cadastrar\n");
            System.out.printf("[ L ] listar\n");
            System.out.printf("[ S ] sair\n");
            System.out.printf("[ A ] alugar\n");
            System.out.printf("[ D ] devolver\n");
            System.out.printf("Opção: ");
            char op = ler.next().toUpperCase().charAt(0);

            switch (op){
                case 'C':
                    veiculo[cont] = new Veiculo();

                    System.out.printf("Digite a placa do veículo: ");
                    veiculo[cont].placa = ler.next();

                    System.out.printf("Digite o modelo do veículo: ");
                    veiculo[cont].modelo = ler.next();

                    System.out.printf("Digite a montadora do veículo:" );
                    veiculo[cont].montadora = ler.next();

                    System.out.printf("Digite a cor do veículo: ");
                    veiculo[cont].cor = ler.next();

                    veiculo[cont].km = 0;
                    veiculo[cont].status = true;
                    cont++;

                    break;
                case 'L':
                    if(cont > 0){
                        for (int j = 0; j < cont; j++) {
                            System.out.printf("Veiculo %d{\n",j+1);
                            System.out.printf("\tplaca: %s,\n",veiculo[j].getPlaca());
                            System.out.printf("\tmodelo: %s,\n",veiculo[j].getModelo());
                            System.out.printf("\tmonatadora: %s,\n",veiculo[j].getMontadora());
                            System.out.printf("\tcor: %s,\n",veiculo[j].getCor());
                            System.out.printf("\tkm: %.3fkm\n",veiculo[j].getKm());
                            if(veiculo[j].status){
                                System.out.printf("\tStatus: livre};\n");
                            }else  System.out.printf("\tStatus: em uso;\n");
                        }
                    }else System.out.printf("Não há cadastros de veículos!\n");
                    break;
                case 'S':
                    System.out.printf("Saindo [ .. ]\n");
                    continuar = false;
                    break;
                case 'A':
                    for (int i = 0; i < cont; i++) {
                        System.out.printf("Veiculo %d\n",i);
                        if(veiculo[i].isStatus()){
                            System.out.printf("status: livre\n");
                        }else System.out.printf("status: em uso\n");
                    }
                    System.out.printf("Digite a numeração do veiculo: ");
                    quant = ler.nextInt();

                    for (int i = 0; i < cont; i++) {
                       if(quant == i){
                           if(veiculo[quant].isStatus() == true){
                               System.out.printf("Veiculo retirado com sucesso!\n");
                               veiculo[quant].setStatus(false);
                           }else System.out.printf("Veículo em uso!\n");
                       }else System.out.printf("Veículo não encontrado!\n");
                    }
                    break;

                case 'D':
                    for (int i = 0; i < cont; i++) {
                        System.out.printf("Veiculo %d\n",i);
                        if(veiculo[i].isStatus() == true){
                            System.out.printf("status: livre\n");
                        }else System.out.printf("status: em uso\n");
                    }
                    System.out.printf("Digite a numeração do veiculo: ");
                    quant = ler.nextInt();


                    for (int i = 0; i < cont; i++) {
                        if(quant == i){
                            if(veiculo[quant].isStatus() == false){
                                System.out.printf("Veiculo devolvido com sucesso!\n");
                                veiculo[quant].status = true;

                                while(mais){
                                    try{
                                        System.out.printf("Digite o valor em km percorrido pelo veiculo: ");
                                        odometro = ler.nextDouble();

                                        if(odometro > 0){
                                            veiculo[i].km += odometro;
                                            mais = false;
                                        }
                                    }catch (Exception e){
                                        System.out.printf("Valor inválido!");
                                    }
                                }

                            }
                        }else System.out.printf("Veículo não encontrado!\n");
                    }
                    break;
                default: System.out.printf("Opção inválida!\n\n");
            }
        } while (continuar);
    }
}