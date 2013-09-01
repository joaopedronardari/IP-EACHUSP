class ListaCircular{
	Pessoa ultimo;

	void inicializa(){ 
		ultimo = null;
	}
	
	void insere(String nome) {
		/* insere no fim da lista */
		Pessoa novo = new Pessoa();
		novo.nome = nome;
		if(ultimo == null){
			/* se a lista esta vazia, o novo aponta para si mesmo */
			novo.proximo = novo;
			/* nesse caso ele eh o ultimo */
			ultimo = novo;
		}
		else {
			Pessoa primeiro = ultimo.proximo; 
			/* o novo eh inserido no fim */
			/* portanto ele deve apontar para o primeiro */
			novo.proximo = primeiro;
			/* e o ultimo deve apontar para ele */
			ultimo.proximo = novo;
			/* agora o novo passa a ser o ultimo */
			ultimo = novo;
		}
	}

	String sorteia(int n) {
		Pessoa selecionado = ultimo.proximo; // eh selecionada a crianca que esta definida como primeira 
		//laço para apontar o selecionado conforme o numero de dedos
		for (int i = 1; i <= n; i++) { 
			//atualiza a posicao do ultimo
			ultimo = selecionado;
			//o selecionado (apontado) vira o proximo em relacao ao atual selecionado
			selecionado = selecionado.proximo;
		}

		/*apos ser encontrado o selecionado eh atualizado o proximo em relacao ao ultimo 
			assim o selecionado sera eliminado da lista		*/
		ultimo.proximo = selecionado.proximo;

		return selecionado.nome;
	}
}
