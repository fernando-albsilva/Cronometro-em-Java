package trabalhoCronometro;

//Classe implementa a interface Runnable para trabalhar com Threads
public class Minuto implements Runnable{

	//Usa o polimorfismo para implementar o metodo run
	@Override
	public void run() {

		//Cria um contador que recebe o valor que esta no campo do minuto no painel transformando esse valor em inteiro;
		int cont = Integer.parseInt(Tela.txtMinuto.getText());
		
		//Cria um loop infinito 
		for (;;) {
			
			//coloca no JTextfield Minuto o valor de cont que esta valendo 0;
			Tela.txtMinuto.setText(cont+"");
			//cont é incrementado
			cont++;
			//se  cont chegar a 59 ele retorna ao valor 0 por que 60 minutos equivalem a uma hora ai começa a recontagem;
			if(cont==60) {
				cont=0;
			}
			
			try {
				Thread.sleep(60000); // a Thread dorme por 60000 milesimos ou seja seja 60 segundos
			} catch (Exception e)
			{
				System.out.println("nao foi possivel entrar em sleep");
			}
			
			
		}
		
	}

}
