package trabalhoCronometro;

//Classe implementa a interface Runnable para trabalhar com Threads
public class Milessimo implements Runnable{

	//Usa o polimorfismo para implementar o metodo run
	@Override
	public void run() {
		
		//Cria um contador que recebe o valor que esta no campo da Milissegundo no painel transformando esse valor em inteiro;
		int cont = Integer.parseInt(Tela.txtMiliSegundo.getText());
		
		//Cria um loop infinito 
		for (;;) {
			
			//coloca no JTextfield Hora o valor de cont que esta valendo 0;
			Tela.txtMiliSegundo.setText(cont+"");
			//cont é incrementado
			cont++;
			//se  cont chegar a 1000 ele retorna ao valor 0 por que 1000 Milissegundos é equivalente a 1 segundo;
			if(cont==1000) {
				cont=0;
			}
			
			try {
				Thread.sleep(1); // domre por 1 milesimo equivalente a 1/1000 segundo;
			} catch (Exception e)
			{
				System.out.println("nao foi possivel entrar em sleep");
			}
			
			
		}
		
	}

}
