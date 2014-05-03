/**
	Classe usada para seus testes
*/
class TestaIntegral {

	/*
		Para seus testes
	*/
	public static void main(String[] args) {
		/*
			Como a equação é y = raiz(1-x^2), sua integral, de 0 a 1 dará a área
			de 1/4 do círculo = (1/4)Pi (pois o raio é 1). Isso foi escolhido assim
			para que você possa testar o resultado contra Pi/4. Se quiser, use outras
			funções em "valor" dentro de "Funcao" para testar, pois essa classe não
			será entregue.
		*/
		Funcao f = new Funcao();
		// veja como a aproximação funciona
		for (int i=1; i<100; i++)
			System.out.println("Valor apr.: "+Integral.resolve(f,0,1,i));
		System.out.println("Valor real: "+(Math.PI/4));
	}

}
