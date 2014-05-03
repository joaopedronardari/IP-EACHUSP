/*******************************************************************/
/** ACH2001 - Introducao a Programacao                            **/
/** EACH-USP - Primeiro Semestre de 2013                          **/
/** T.NN - Norton Roman Trevisan                                  **/
/**                                                               **/
/** Primeiros Exercicio-Programa                                  **/
/**                                                               **/
/** Joao Pedro Nardari dos Santos  8623865                        **/
/**                                                               **/
/** 04/05/2013                                                    **/
/*******************************************************************/

class Cacador {

	/*
		Exemplos para testes
	*/
	static char quadro1[][]= {
		{'B', 'O', 'I', 'K', 'L', 'S'},
		{'L', 'E', 'B', 'H', 'O', 'J'},
		{'E', 'T', 'G', 'Y', 'B', 'S'},
		{'A', 'G', 'A', 'T', 'O', 'R'},
		{'O', 'C', 'X', 'Q', 'R', 'W'},
		{'Y', 'Z', 'K', 'C', 'B', 'L'}
	};
	static char palavras1[][]= {
		{'L','E','A','O'}, //(1,0)
		{'G','A','T','O'}, //(3,1)
		{'B','O','I'},  //(0,0)
		{'L','O','B','O'}  //(0,4)
	};
	static int posicoes1[][]= {
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1}
	};

	static char quadro2[][]= {
		{'D', 'G', 'E', 'M', 'E', 'O', 'S', 'Q', 'E', 'O', 'V', 'F', 'A', 'K', 'W'},
		{'X', 'B', 'A', 'C', 'Z', 'O', 'S', 'T', 'S', 'S', 'I', 'T', 'P', 'N', 'H'},
		{'Y', 'I', 'F', 'N', 'Z', 'C', 'A', 'N', 'C', 'E', 'R', 'O', 'U', 'U', 'T'},
		{'P', 'Q', 'O', 'L', 'R', 'H', 'G', 'L', 'O', 'D', 'G', 'U', 'N', 'P', 'A'},
		{'E', 'P', 'P', 'I', 'T', 'J', 'I', 'R', 'R', 'L', 'E', 'R', 'W', 'W', 'R'},
		{'I', 'H', 'T', 'B', 'P', 'P', 'T', 'M', 'P', 'M', 'M', 'O', 'D', 'O', 'I'},
		{'X', 'D', 'J', 'R', 'N', 'N', 'A', 'O', 'I', 'V', 'P', 'I', 'A', 'F', 'E'},
		{'E', 'W', 'F', 'A', 'O', 'V', 'R', 'U', 'A', 'Q', 'B', 'N', 'W', 'G', 'S'},
		{'S', 'M', 'C', 'A', 'P', 'R', 'I', 'C', 'O', 'R', 'N', 'I', 'O', 'K', 'X'},
		{'K', 'D', 'G', 'N', 'V', 'I', 'O', 'V', 'C', 'L', 'E', 'A', 'O', 'Y', 'O'},
		{'P', 'J', 'J', 'I', 'S', 'W', 'A', 'Q', 'U', 'A', 'R', 'I', 'O', 'S', 'Y'}
	};
	static char palavras2[][]= {
		{'C','A','P','R','I','C','O','R','N','I','O'}, //(8,2)
		{'E','S','C','O','R','P','I','A','O'},   //(0,8)
		{'S','A','G','I','T','A','R','I','O'},   //(1,6)
		{'A','Q','U','A','R','I','O','S'},	//(10,6)
		{'A','R','I','E','S'},	   //(3,14)
		{'T','O','U','R','O'},	   //(1,11)
		{'G','E','M','E','O','S'},	  //(0,1)
		{'C','A','N','C','E','R'},	  //(2,5)
		{'V','I','R','G','E','M'},	  //(0,10)
		{'L','I','B','R','A'},	   //(3,3)
		{'L','E','A','O'},		//(9,9)
		{'P','E','I','X','E','S'}	   //(3,0)
	};
	static int posicoes2[][]= {
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1}
	};

	static char quadro3[][]= {
		{'B', 'L', 'A', 'D', 'E', 'E', 'T', 'C', 'B', 'O', 'N', 'E', 'S', 'N'},
		{'W', 'H', 'O', 'U', 'S', 'E', 'B', 'A', 'R', 'E', 'T', 'T', 'A', 'A'},
		{'F', 'G', 'G', 'H', 'K', 'P', 'L', 'L', 'E', 'T', 'Z', 'O', 'D', 'Q'},
		{'E', 'P', 'X', 'M', 'A', 'S', 'H', 'I', 'A', 'D', 'S', 'I', 'N', 'U'},
		{'L', 'O', 'C', 'I', 'X', 'J', 'T', 'F', 'I', 'A', 'L', 'Z', 'Q', 'A'},
		{'I', 'D', 'A', 'L', 'L', 'A', 'S', 'O', 'R', 'K', 'O', 'F', 'H', 'M'},
		{'C', 'Z', 'R', 'F', 'C', 'Q', 'K', 'R', 'W', 'T', 'S', 'S', 'E', 'A'},
		{'I', 'A', 'B', 'A', 'T', 'M', 'A', 'N', 'O', 'A', 'T', 'X', 'R', 'N'},
		{'T', 'L', 'M', 'M', 'S', 'T', 'T', 'I', 'L', 'R', 'G', 'G', 'O', 'T'},
		{'Y', 'F', 'V', 'E', 'R', 'H', 'E', 'C', 'F', 'I', 'V', 'R', 'E', 'D'},
		{'C', 'Y', 'B', 'E', 'R', 'C', 'H', 'A', 'S', 'E', 'I', 'E', 'S', 'T'},
		{'V', 'D', 'R', 'A', 'G', 'N', 'E', 'T', 'Y', 'K', 'N', 'E', 'X', 'G'},
		{'A', 'C', 'H', 'K', 'P', 'S', 'D', 'I', 'N', 'L', 'I', 'K', 'G', 'S'},
		{'U', 'A', 'N', 'G', 'E', 'L', 'Q', 'O', 'N', 'G', 'Q', 'J', 'C', 'P'},
		{'I', 'S', 'F', 'A', 'P', 'G', 'U', 'N', 'S', 'M', 'O', 'K', 'E', 'T'},
		{'E', 'N', 'H', 'S', 'U', 'F', 'U', 'T', 'U', 'R', 'A', 'M', 'A', 'Y'}
	};
	static char palavras3[][]= {
		{'C','A','L','I','F','O','R','N','I','C','A','T','I','O','N'}, //(0,7)
		{'C','Y','B','E','R','C','H','A','S','E'},	  //(10,0)
		{'F','E','L','I','C','I','T','Y'},		//(2,0)
		{'F','U','T','U','R','A','M','A'},		//(15,5)
		{'A','Q','U','A','M','A','N'},		 //(1,13)
		{'B','A','R','E','T','T','A'},		 //(1,6)
		{'A','I','R','W','O','L','F'},		 //(3,8)
		{'G','U','N','S','M','O','K','E'},		//(14,5)
		{'D','A','K','T','A','R','I'},		 //(3,9)
		{'D','R','A','G','N','E','T'},		 //(11,1)
		{'B','A','T','M','A','N'},		  //(7,2)
		{'D','A','L','L','A','S'},		  //(5,1)
		{'H','E','R','O','E','S'},		  //(5,12)
		{'G','R','E','E','K'},		   //(8,11)
		{'A','N','G','E','L'},		   //(13,1)
		{'B','L','A','D','E'},		   //(0,0)
		{'B','O','N','E','S'},		   //(0,8)
		{'L','O','S','T'},			//(4,10)
		{'H','O','U','S','E'},		   //(1,1)
		{'M','A','S','H'},			//(3,3)
		{'F','A','M','E'},			//(6,3)
		{'A','L','F'}			  //(7,1)
	};
	static int posicoes3[][]= {
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1}
	};

	static char quadro4[][]= {
		{'R', 'Q', 'B', 'H', 'F', 'I', 'L', 'E', 'P', 'U', 'T', 'V'},
		{'C', 'H', 'O', 'P', 'P', 'P', 'Z', 'U', 'N', 'H', 'O', 'R'},
		{'Q', 'O', 'S', 'M', 'E', 'A', 'O', 'K', 'Q', 'M', 'R', 'P'},
		{'J', 'P', 'E', 'T', 'I', 'S', 'C', 'O', 'U', 'F', 'R', 'X'},
		{'P', 'O', 'L', 'E', 'N', 'T', 'A', 'C', 'E', 'A', 'E', 'C'},
		{'Q', 'N', 'O', 'B', 'B', 'E', 'X', 'T', 'I', 'C', 'S', 'A'},
		{'X', 'J', 'P', 'A', 'O', 'L', 'H', 'I', 'J', 'A', 'M', 'M'},
		{'A', 'F', 'M', 'T', 'H', 'H', 'Z', 'Q', 'O', 'R', 'O', 'A'},
		{'V', 'F', 'M', 'A', 'N', 'D', 'I', 'O', 'C', 'A', 'E', 'R'},
		{'E', 'R', 'K', 'T', 'O', 'Y', 'H', 'W', 'I', 'J', 'H', 'A'},
		{'C', 'A', 'L', 'A', 'B', 'R', 'E', 'S', 'A', 'E', 'G', 'O'},
		{'O', 'N', 'J', 'E', 'C', 'E', 'R', 'V', 'E', 'J', 'A', 'E'},
		{'U', 'G', 'P', 'I', 'Z', 'Z', 'A', 'W', 'H', 'P', 'J', 'Z'},
		{'X', 'O', 'J', 'O', 'I', 'S', 'C', 'A', 'S', 'M', 'S', 'D'},
		{'C', 'C', 'A', 'L', 'D', 'I', 'N', 'H', 'O', 'H', 'I', 'M'}
	};
	static char palavras4[][]= {
		{'C','A','L','A','B','R','E','S','A'}, //(10,0)
		{'M','A','N','D','I','O','C','A'},  //(8,2)
		{'C','A','L','D','I','N','H','O'},  //(14,1)
		{'T','O','R','R','E','S','M','O'},  //(0,10)
		{'P','O','L','E','N','T','A'},   //(4,0)
		{'C','A','M','A','R','A','O'},   //(4,11)
		{'A','C','A','R','A','J','E'},   //(4,9)
		{'C','E','R','V','E','J','A'},   //(11,4)
		{'P','E','T','I','S','C','O'},   //(3,1)
		{'Q','U','E','I','J','O'},	//(2,8)
		{'B','A','T','A','T','A'},	//(5,3)
		{'X','A','V','E','C','O'},	//(6,0)
		{'F','R','A','N','G','O'},	//(8,1)
		{'P','A','S','T','E','L'},	//(1,5)
		{'I','S','C','A','S'},	 //(13,4)
		{'P','I','Z','Z','A'},	 //(12,2)
		{'C','H','O','P','P'},	 //(1,0)
		{'F','I','L','E'}	   //(0,4)
	};
	static int posicoes4[][]= {
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1}
	};

	static char quadro5[][]= {
		{'I', 'A', 'C', 'P', 'P', 'R', 'O', 'F', 'E', 'T', 'A', 'O', 'W', 'X', 'I', 'O', 'A', 'U', 'R'},
		{'U', 'Z', 'S', 'A', 'L', 'V', 'E', 'G', 'I', 'U', 'C', 'J', 'C', 'F', 'T', 'X', 'I', 'Y', 'V'},
		{'W', 'Z', 'V', 'S', 'H', 'V', 'E', 'S', 'T', 'A', 'M', 'P', 'A', 'A', 'B', 'L', 'J', 'R', 'M'},
		{'X', 'Q', 'R', 'S', 'B', 'R', 'I', 'L', 'H', 'A', 'N', 'T', 'E', 'V', 'M', 'G', 'R', 'O', 'B'},
		{'B', 'O', 'Y', 'I', 'I', 'N', 'S', 'E', 'N', 'S', 'A', 'T', 'O', 'O', 'O', 'T', 'T', 'S', 'E'},
		{'E', 'Z', 'I', 'O', 'C', 'A', 'F', 'W', 'A', 'W', 'W', 'I', 'P', 'R', 'R', 'F', 'B', 'Q', 'S'},
		{'L', 'U', 'H', 'N', 'L', 'V', 'G', 'H', 'K', 'Y', 'Y', 'E', 'K', 'I', 'E', 'E', 'A', 'L', 'P'},
		{'I', 'A', 'L', 'E', 'O', 'S', 'U', 'C', 'A', 'T', 'A', 'T', 'A', 'T', 'N', 'L', 'M', 'O', 'E'},
		{'S', 'U', 'I', 'I', 'N', 'X', 'D', 'H', 'X', 'Q', 'U', 'A', 'N', 'A', 'I', 'I', 'B', 'C', 'R'},
		{'S', 'P', 'N', 'N', 'E', 'S', 'A', 'D', 'V', 'L', 'J', 'R', 'C', 'C', 'N', 'C', 'O', 'O', 'A'},
		{'I', 'A', 'D', 'R', 'A', 'S', 'O', 'M', 'F', 'Q', 'R', 'E', 'X', 'E', 'H', 'I', 'L', 'M', 'N'},
		{'M', 'D', 'O', 'K', 'U', 'B', 'A', 'N', 'A', 'C', 'A', 'N', 'C', 'T', 'A', 'D', 'E', 'O', 'C'},
		{'A', 'R', 'M', 'P', 'O', 'I', 'C', 'B', 'W', 'Q', 'X', 'A', 'X', 'H', 'U', 'A', 'C', 'T', 'A'},
		{'D', 'O', 'A', 'F', 'E', 'A', 'L', 'Z', 'N', 'F', 'X', 'S', 'T', 'U', 'R', 'D', 'C', 'I', 'L'},
		{'S', 'E', 'D', 'A', 'M', 'E', 'R', 'I', 'C', 'A', 'F', 'C', 'W', 'O', 'H', 'E', 'X', 'V', 'W'},
		{'Y', 'I', 'A', 'H', 'V', 'F', 'Q', 'K', 'B', 'I', 'T', 'E', 'N', 'B', 'L', 'Q', 'Z', 'A', 'L'},
		{'F', 'R', 'U', 'A', 'B', 'U', 'C', 'E', 'L', 'E', 'B', 'R', 'I', 'D', 'A', 'D', 'E', 'S', 'C'},
		{'M', 'A', 'N', 'D', 'A', 'L', 'A', 'V', 'A', 'M', 'P', 'U', 'J', 'A', 'O', 'A', 'N', 'O', 'T'},
		{'K', 'L', 'H', 'G', 'U', 'L', 'C', 'A', 'R', 'I', 'N', 'H', 'O', 'S', 'O', 'W', 'O', 'Q', 'Z'},
		{'N', 'O', 'Q', 'C', 'F', 'F', 'Q', 'E', 'G', 'H', 'A', 'S', 'T', 'R', 'O', 'P', 'D', 'R', 'U'}
	};
	static char palavras5[][]= {
		{'C','E','L','E','B','R','I','D','A','D','E'}, //(16,6)
		{'L','O','C','O','M','O','T','I','V','A','S'}, //(6,17)
		{'F','E','L','I','C','I','D','A','D','E'},  //(5,15)
		{'I','N','S','E','N','S','A','T','O'},   //(4,4)
		{'B','E','L','I','S','S','I','M','A'},   //(4,0)
		{'E','S','P','E','R','A','N','C','A'},   //(4,18)
		{'B','R','I','L','H','A','N','T','E'},   //(3,4)
		{'K','U','B','A','N','A','C','A','N'},   //(11,3)
		{'M','O','R','E','N','I','N','H','A'},   //(3,14)
		{'C','A','R','I','N','H','O','S','O'},   //(18,6)
		{'P','A','D','R','O','E','I','R','A'},   //(9,1)
		{'F','A','V','O','R','I','T','A'},	//(1,13)
		{'I','N','D','O','M','A','D','A'},	//(8,2)
		{'R','E','N','A','S','C','E','R'},	//(9,11)
		{'P','A','S','S','I','O','N','E'},	//(0,3)
		{'M','A','N','D','A','L','A'},	 //(17,0)
		{'P','R','O','F','E','T','A'},	 //(0,4)
		{'B','A','M','B','O','L','E'},	 //(5,16)
		{'E','S','T','A','M','P','A'},	 //(2,6)
		{'A','M','E','R','I','C','A'},	 //(14,3)
		{'S','U','C','A','T','A'},	  //(7,5)
		{'S','A','L','V','E'},	   //(1,2)
		{'C','L','O','N','E'},	   //(5,4)
		{'T','I','E','T','A'},	   //(4,11)
		{'A','S','T','R','O'},	   //(19,10)
		{'V','A','M','P'}		 //(17,7)
	};
	static int posicoes5[][]= {
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1},
		{-1,-1}
	};

	/*
		Imprime o quadro do caça-palavras na tela.
		
		parametros:
			quadro - O quadro a ser impresso
	*/
	static void imprimeQuadro (char[][] quadro) {
		for (int i=0;i<quadro.length;i++) {
			for (int j=0;j<quadro[0].length;j++) {
				System.out.print (quadro[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/*
		Imprime na tela as coordenadas de todas as palavras. Aquelas que não foram
		encontradas têm coordenadas (-1,-1).
		
		parametros:
			palavras - Arranjo das palavras buscadas
			posicoes - As posições cartesianas de cada palavra
	*/
	static void imprimeResposta (char[][] palavras, int[][] posicoes) {
		for (int i=0;i<palavras.length;i++) {
			System.out.print(palavras[i]);
			System.out.println(": (" + 
				posicoes[i][0] + "," + 
				posicoes[i][1] + ")" );
		}
	}
	
	/*
		Caça as palavras desejadas no quadro. O resultado é armazenado em posicoes.
		
		Parametros:
			quadro - Quadro em que a busca será feita
			palavras - Arranjo das palavras buscadas
			posicoes - Arranjo que receberá o resultado da busca.
	*/
	static void  cacaPalavras(char[][] quadro, char[][] palavras, int[][] posicoes) {
		// Nao utilizei outros metodos pois alocaria mais memoria entao, a melhor opcao ao meu ver, foi deixar em um unico metodo
		// for para setar cada palavra
		for (int i = 0; i < palavras.length; i++) {
			//percorre o quadro atras da palavra selecionada
			for (int z = 0; z < quadro.length; z++) {
				for (int j = 0; j < quadro[z].length; j++) {
					//se encontra a primeira letra da palavra inicia a verificacao
					if (palavras[i][0] ==(quadro[z][j])) {
						int auxiliar_verificacao = 0;
						boolean palavraencontrada = false;
						//inicio da verificacao da palavra por coluna
						for (int x = 1; x< palavras[i].length; x++) {
							if ((j + x + 1) > quadro[z].length) {
								x = palavras[i].length;
							}
							else if (palavras[i][x] == quadro[z][j+x])
								auxiliar_verificacao++;
							else {
								x = palavras[i].length;
								}
						}
						//verifica se o numero de ocorrencias por coluna estao no tamanho da palavra
						if (auxiliar_verificacao + 1 == palavras[i].length) {
							posicoes[i][0] = z;
							posicoes[i][1] = j;
							j = quadro[z].length;
						}
						else { // senao esta no tamanho tenta ir por linha buscar a palavra
							auxiliar_verificacao = 0;
							//inicio da verificacao da palavra por linha
							for (int y = 1; y < palavras[i].length; y++) {
								if ((z + y + 1) > quadro.length) {
								y = palavras[i].length;
								}
							else if (palavras[i][y] == quadro[z+y][j])
								auxiliar_verificacao++;
							else {
								y = palavras[i].length;
								}
							}
							//verifica se o numero de ocorrencias por linha estao no tamanho da palavra
							if (auxiliar_verificacao + 1 == palavras[i].length) {
								posicoes[i][0] = z;
								posicoes[i][1] = j;
								j = quadro[z].length;
							}
						}
					}	
				}
			}
		}
		//fim da busca de palavras
	}

	/*
		Apenas para testes
	*/
	public static void main (String[] args) {
		imprimeQuadro (quadro1);
		cacaPalavras (quadro1, palavras1, posicoes1);
		imprimeResposta (palavras1, posicoes1);
	}
}

