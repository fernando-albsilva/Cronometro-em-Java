package trabalhoCronometro;

//Classe implementa a interface Runnable para trabalhar com Threads
public class Segundo implements Runnable{

	
	//Usa o polimorfismo para implementar o metodo run
	@Override
	public void run() {
		
		//Cria um contador que recebe o valor que esta no campo da Segundo no painel transformando esse valor em inteiro;
		int cont = Integer.parseInt(Tela.txtSegundo.getText());
		
		//Cria um loop infinito 
		for (;;) {
			
			//coloca no JTextfield Segundo o valor de cont que esta valendo 0;
			Tela.txtSegundo.setText(cont+"");
			//cont é incrementado
			cont++;
			//se  cont chegar a 59 ele retorna ao valor 0 por que 59 segundos é equivalente a 1 minuto;
			if(cont==59) {
				cont=0;
			}
			
			try {
				Thread.sleep(1000); // cada vez que ele incrementa a interaçao dorme por 1000 milessimos que equivalem a um segundo;
			} catch (Exception e)
			{
				System.out.println("nao foi possivel entrar em sleep");
			}
			
			
		}
		
	}

}
