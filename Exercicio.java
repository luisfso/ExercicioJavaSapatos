import java.util.ArrayList;
import java.net.SocketPermission;
import java.util.*;  
class Sapato{ 
        int numero;
        String marca;
        Sapato(int n, String marc){
            this.numero = n;
            this.marca = marc;
        }
        public int getnumero(){
            return this.numero;
        }
        public void setnumero(int num){
                this.numero = num;
        }
        public void setmarca(String m){
                this.marca = m;
        }
        public String getmarca(){
            return this.marca;
        }
}
public class Exercicio{
        public static void main(String[] args) {
                Sapato a1 = new Sapato(25,"adidas");
		Sapato a2 = new Sapato(29,"nike");
                Sapato a3 = new Sapato(32,"mizuno");
                Sapato a4 = new Sapato(34,"olimpicus");
                Sapato a5 = new Sapato(42,"adidas");
                Sapato a6 = new Sapato(45,"newMarcaSensasional");
                Sapato a7 = new Sapato(43,"adidas");
                Sapato a8 = new Sapato(41,"nike");
                Sapato a9 = new Sapato(50,"mizunoa");
                Sapato a10 = new Sapato(36,"nike");
                Sapato a11 = new Sapato(32,"adidas");
                Sapato a12 = new Sapato(30,"olimpicus");
                Sapato a13 = new Sapato(33,"asicsss");
                Sapato a14 = new Sapato(41,"asicsss");
                Sapato a15 = new Sapato(40,"adidas");
                Sapato a16 = new Sapato(33,"olimpicus");
		ArrayList<Sapato> estoque = new ArrayList<Sapato>();
                estoque.add(a1);
                estoque.add(a2);
                estoque.add(a3);
                estoque.add(a4);
                estoque.add(a5);
                estoque.add(a6);
                estoque.add(a7);
                estoque.add(a8);
                estoque.add(a9);
                estoque.add(a10);
                estoque.add(a11);
                estoque.add(a12);
                estoque.add(a13);
                estoque.add(a14);
                estoque.add(a15);
                estoque.add(a16);
                /*for(int b=0;b<100000;b++){
                        Sapato b1 = new Sapato(b,"base"+String.valueOf(b));
                        estoque.add(b1);
                }*/
            	int n = estoque.size();
		int i;
		System.out.println("Tamanho: - marca: (ainda não ordenado)");
		for (i = 0;i<n;i++){
                        System.out.println(String.valueOf(estoque.get(i).getnumero())+" - "+estoque.get(i).getmarca());
                }
                estoque = insertionSort(estoque);
                System.out.println("Tamanho: - marca: (após a ordenação usando o algoritmo Insert Sort)");
                for (i = 0;i<n;i++){
                        System.out.println(String.valueOf(estoque.get(i).getnumero())+" - "+estoque.get(i).getmarca());
                }
                /* Agora iniciaremos a segunda questão usando a lista já ordenada da primeira questão, para iniciar
                uma busca binaria no elemento desejado.
                Nessa questão solicitaremos do usuário qual elemento ele deseja buscar

                */
                int tbusc = 1;
                while(tbusc != 0){
                        System.out.println();
                        System.out.println("Por favor, qual o numero de sapato você deseja encontrar?");
                        System.out.println("Digite um valor e aperte enter, para prosseguir, digite \"0\" para sair e 99 para demonstração de velocidade no melhor e pior caso!");
                        Scanner sc = new Scanner(System.in);
                        tbusc = sc.nextInt();
                        if(tbusc == 99){
                                long tempoInicial1 = System.nanoTime();
                                int id1 = busca(estoque, 1);//pior caso, quando não ah elemento no array
                                System.out.println("O Busca binaria para o pior caso foi executada em " + (System.nanoTime() - tempoInicial1) + " Milisegundos");
                        
                                long tempoInicial2 = System.nanoTime();
                                int id2 = busca(estoque, estoque.get(0).getnumero());//melhor caso quando o elemento é o primerito
                                System.out.println("O Busca binaria para melhor caso foi executada em " + (System.nanoTime() - tempoInicial2) + " Milisegundos");

                        
                        }else{
                        int id = busca(estoque, tbusc);

                        if(id >= 0 ){
                                System.out.println("Nós temos sapatos do numero solicitado da seguinte marca:");
                                System.out.println();
                                while(id < estoque.size() && estoque.get(id).getnumero() == tbusc){
                                        /*
                                        Essa função se fez necessaria devido ao fato de podermos ter mais de uma marca com o mesmo numero
                                        por exemplo o numero 32
                                        */
                                        System.out.println(estoque.get(id).getmarca());
                                        id++;
                                };                                                
                                
                        }else{                System.out.println("Infelizmente não temos sapatoos do numero selecionado!");
                                };
                };
        };
}       
	public static ArrayList<Sapato> insertionSort(ArrayList<Sapato> estoque2){
		int n = estoque2.size();
                
                for (int i = 1; i < n; i++) {
                        Sapato chave = new Sapato(0, "");
                        chave.setnumero(estoque2.get(i).getnumero());
                        chave.setmarca(estoque2.get(i).getmarca());
                        int j = i ;
                        while ((j > 0) && (estoque2.get(j-1).getnumero() > chave.getnumero())){                                        
                                estoque2.set(j,estoque2.get(j - 1));
                                j--;
                        }
                        estoque2.set(j,chave);
                }
		System.out.println(n);
                return estoque2;
		};


        private static int busca(ArrayList<Sapato> array, int chave) {
                return buscaBinariaRecursiva(array, 0, array.size() - 1, chave);
        }
        private static int buscaBinariaRecursiva(ArrayList<Sapato> array, int menor, int maior, int chave) {
                int media = (maior + menor) / 2;
                Sapato valorMeio = array.get(media);
                if (menor > maior)
                        return -1;
                else if(valorMeio.getnumero() == chave) 
                        return media;
                else if (valorMeio.getnumero() < chave)
                        return buscaBinariaRecursiva(array, media+1, maior, chave);
                else
                        return buscaBinariaRecursiva(array, menor, media-1, chave);
        }
}
