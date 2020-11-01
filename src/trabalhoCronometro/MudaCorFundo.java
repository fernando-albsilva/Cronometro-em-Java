package trabalhoCronometro;

import java.awt.Color;

//Classe implementa a interface Runnable para trabalhar com Threads
public class MudaCorFundo implements Runnable{

	//Usa o polimorfismo para implementar o metodo run
	@Override
	public void run() {

		
		//Cria um loop infinito 
		int cont = Integer.parseInt(Tela.txtMinuto.getText());
		for (;;) {
			
			// se o minuto for par ele seta o backgroundColor em branco se for impar ele seta na cor Cyan;		
			if(cont != 0 && cont%2 == 0)
			{
				Tela.Painel.setBackground(Color.WHITE);
				
			}
			if(cont != 0 && cont%2 != 0) 
			{
				Tela.Painel.setBackground(Color.cyan);
				
			}
	
			try {
				
				Thread.sleep(60000); // cada vez que  muda a cor de fundo a Thread dorme por 60000 milessimos que equivalem a um minuto;
			} catch (Exception e)
			{
				System.out.println("nao foi possivel entrar em sleep");
			}
			cont ++;
			
		}
		
	}

}