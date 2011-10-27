# DateMath.class

## Introdu��o

A classe DateMath.java fornece uma forma elegante e flexivel para incrementos e decrementos em datas, podemos adicionar ou remover
anos, meses, dias, horas, minutos e segundos.
A classe � contruida de uma forma que possamos fazer contru��es mais fluentes quando quizermos realizar tais opera��es sobre
datas.

## Onde Usar

Voc� pode usar essa clase em qualquer lugar em que achar v�lido tais manipula��es de datas, em especial quando estamos escrevendo
testes de unidade para nossos algoritmos que usam datas precisamos fazer muito tais manipula��es afim de escrever casos de testes v�lidos
, nesse aspecto essa classe faz um trabalho bom mantendo seus m�todos de testes mais limpos.

#Exemplos

	### Criando objetos DateMath a partir de String e Date
		
		public static void main(String[] args) throws InvalidMaskException {

		//Criando objetos a partir de Strings de datas

			Date minhaData = new DateMath().on("26/10/2011 09:02", "dd/MM/yyyy HH:mm").result();
			System.out.println(minhaData); // Wed Oct 26 09:02:00 BRST 2011

			String outraData = new DateMath().on("26/10/2011 09:02", "dd/MM/yyyy HH:mm").result(Results.pt_br());
			System.out.println(outraData); // 26/10/2011 09:02:00

			String maisUmaData = new DateMath().on("26/10/2011 09:02", "dd/MM/yyyy HH:mm").result(Results.en_us());
			System.out.println(maisUmaData); // 10/26/2011 9:02:00 AM


			maisUmaData = new DateMath().on(maisUmaData, "MM/dd/yyyy h:mm:ss a").increase(2).years().result(Results.en_us());
			System.out.print(maisUmaData); // 10/26/2013 9:02:00 AM


		//Criando um DateMath a partir de um Date
			Date now = new Date(); //Wed Oct 26 09:52:35 BRST 2011
			Date date = new DateMath().on(now).increase(2).minutes().result();
			System.out.println(date) //Wed Oct 26 09:54:35 BRST 2011

		}


	### Adicionando Dias a uma data - Exemplo 1
	
		public class Exemplo1 {
	
		public static void main(String[] args) {
			Date minhaData = new Date(); // 25/10/2011 14:01:37
			String novaData = new DateMath().on(minhaData).increase(2).days()
			.result(Results.pt_br());
			System.out.println(novaData); // 27/10/2011 14:01:37
		}
		
	}
	
	### Sobre o Exemplo 1
	
	No Exemplo criamos uma data(corrente) e adicionamos dois dias a ela, uma coisa a se notar � a chamada do Results que � como
	gostariamos que fosse o resultado, nesse casso usamos um dos formatos pre-definidos na classe Results, a classe Result guarda
	dois formatos, um � o formato brasileiro e outro � o americano.
	
	Voc� pode fazer um import est�tico para o Result:
	
		import static datemath.Results.*;
		
	e agora fazer a chamada da seguinte forma:
	
		String novaData = new DateMath().on(minhaData).increase(2).days()
		.result(pt_br());
	
	### Adicionando Dias e Meses a uma data - Exemplo 2
	
		public static void main(String[] args) {
			Date minhaData = new Date();
			String novaData = new DateMath().on(minhaData).increase(2).days().and().increase(2).months().result(pt_br());
			System.out.println(novaData);

			//Forma alternativa - Incrementa 2 dias e 2 meses chamando uma �nica vez o m�todo increase
			novaData = new DateMath().on(minhaData).increase(2).days().and().months().result(pt_br());
		}
		
	## Formatando o resultado.
	
		Tamb�m caso n�o quizermos usar o padr�o americano nem o brasileiro podemos fornecer uma m�scara personalizada 
		da seguinte forma:
		
		public static void main(String[] args) throws InvalidMaskException {
			Date minhaData = new Date();
			String novaData = new DateMath().on(minhaData).increase(2)
			.days().and().increase(10).seconds().result(Results.custom("dd-MM-yyyy"));
			System.out.println(novaData);
		}
	