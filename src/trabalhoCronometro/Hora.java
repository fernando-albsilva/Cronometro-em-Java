package trabalhoCronometro;

//Classe implementa a interface Runnable para trabalhar com Threads
public class Hora implements Runnable {

//Usa o polimorfismo para implementar o metodo run
	@Override
	public void run() {

		//Cria um contador que recebe o valor que esta no campo da hora no painel transformando esse valor em inteiro;
		int cont = Integer.parseInt(Tela.txtHora.getText());
		
		//Cria um loop infinito 
		for (;;) {
			
			//coloca no JTextfield Hora o valor de cont que esta valendo 0;
			Tela.txtHora.setText(cont+"");
			//cont é incrementado
			cont++;
			//se  cont chegar a 9999 ele retorna ao valor 0 por que o cronometro só no maximo até 9999 horas;
			if(cont==9999) {
				cont=0;
			}
			
			try {
				Thread.sleep(360000); //cada vez que ele incremente a interaçao dorme por 360000 milessimos que equivalem a uma hora;
			} catch (Exception e)
			{
				System.out.println("nao foi possivel entrar em sleep");
			}
			
			
		}
		
	}
	
	

}
