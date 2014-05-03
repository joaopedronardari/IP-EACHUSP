class Adedanhas{
	public static void main(String[] args){
		ListaCircular lc = new ListaCircular();
		lc.inicializa();
		/* insere 5 pessoas na lista circular */
		lc.insere("Linnea");
		lc.insere("Roosevelt");
		lc.insere("Adolf");
		lc.insere("Katheryne");
		lc.insere("Dave");

		/* esses serao os valores sorteados */
		int[] sorteados = {16, 23, 19, 7};

		/* para cada valor sorteado imprima o nome do sorteado */
		for(int i = 0; i < sorteados.length; i++)
			System.out.println(lc.sorteia(sorteados[i]));
		/* imprime quem sobrou na lista */
		System.out.println(lc.ultimo.nome);
	}
}
