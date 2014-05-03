/*******************************************************************/
/** ACH2001 - Introducao a Programacao                            **/
/** EACH-USP - Primeiro Semestre de 2013                          **/
/** T.NN - Norton Trevisan Roman                                  **/
/**                                                               **/
/** Segundo Exercicio-Programa                                    **/
/**                                                               **/
/** Joao Pedro Nardari dos Santos  8623865                        **/
/**                                                               **/
/** 12/05/2013                                                    **/
/*******************************************************************/

class Integral {
	/**
		Retorna a área sob a curva definida pela função f, entre os pontos
		a e b, pela regra dos trapézios, aproximando-a a n trapézios.
		
		O método retorna -1 caso n não seja maior ou igual a 1.
	*/
	static double resolve(Funcao f, double a, double b, int n) {
		//metodo para realizar o calculo da area conforme a regra do trapezio
		double h = (b-a)/n; //largura do trapezio 
		double areaS = (h/2) * (f.valor(a) + f.valor(b) + (2* somatoria(f,a,b,h,n))); //formula regra do trapezio passada
		return areaS;
	}
	
	static double somatoria(Funcao f,double a, double b, double h, int n) {
		//metodo para realizar o calculo da somatoria
		double xselecionado = a + h; // x1 iniciado
		double somatoria = 0; // variavel para receber o valor total da somatoria
		for (int i = 1; i<n; i++) { //laço da somatoria 1 até n-1
			somatoria += f.valor(xselecionado); // incrementando a somatoria com o resultado da funcao para determinado x selecionado
			xselecionado += h; // incremento para selecionar o proximo x
		}
		
		return somatoria;
	}
}
