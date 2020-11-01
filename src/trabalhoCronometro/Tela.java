package trabalhoCronometro;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Tela extends JFrame {

	Milessimo milessimo;
	Segundo segundo;
	Minuto minuto;
	Hora hora;
	
	Thread tHora,tMinuto,tSegundo,tMilessimo;
	
	private JPanel Painel;
	public static JTextField txtHora;
	public static JTextField txtMinuto;
	public static JTextField txtSegundo;
	public static JTextField txtMiliSegundo;
	private JButton btnRetomar;

	
	
	
	/**
	 * 
	 */
	public Tela() {
		
		// Instancia uma classe do tipo Hora;
		hora = new Hora();
		// Cria uma instancia do tipo Thread passando a classe hora como paramentro e atribui a Thora;
		tHora = new Thread(hora);
		
		minuto = new Minuto();
		tMinuto= new Thread(minuto);
		
		segundo = new Segundo();
		tSegundo = new Thread(segundo);
		
		milessimo = new Milessimo();
		tMilessimo = new Thread(milessimo);
		
		//metodo que encerra o JFrame quando clicarmos em fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Seta as dimensoes do JFrame
		setBounds(100, 100, 725, 333);
		
		//Instancia  um Jpanel
		Painel = new JPanel();
		//Muda a cor de background
		Painel.setBackground(Color.WHITE);
		//Seta as conguraçoes de bordas e de layout do painel
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Painel);
		Painel.setLayout(null);
		
		//Cria um JTexfield representando a hora do cronometro com informacoes do layout inicializando seu conteudo com 0;
		txtHora = new JTextField();
		txtHora.setText("0");
		txtHora.setBounds(44, 109, 80, 19);
		Painel.add(txtHora);
		txtHora.setColumns(10);
		
		//Cria um JTexfield representando o minuto do cronometro com informacoes do layout inicializando seu conteudo com 0;
		txtMinuto = new JTextField();
		txtMinuto.setText("0");
		txtMinuto.setBounds(163, 109, 80, 19);
		Painel.add(txtMinuto);
		txtMinuto.setColumns(10);
		
		//Cria um JTexfield representando o segundo do cronometro com informacoes do layout inicializando seu conteudo com 0;
		txtSegundo = new JTextField();
		txtSegundo.setText("0");
		txtSegundo.setBounds(286, 109, 80, 19);
		Painel.add(txtSegundo);
		txtSegundo.setColumns(10);
		
		//Cria um JTexfield representando o milissegundo do cronometro com informacoes do layout inicializando seu conteudo com 0;
		txtMiliSegundo = new JTextField();
		txtMiliSegundo.setText("0");
		txtMiliSegundo.setBounds(412, 109, 80, 19);
		Painel.add(txtMiliSegundo);
		txtSegundo.setColumns(10);
		
		//Cria um JLabel Hora;
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(44, 65, 70, 15);
		Painel.add(lblHora);
		
		//Cria um JLabel Hora
		JLabel lblMinuto = new JLabel("Minuto");
		lblMinuto.setBounds(163, 65, 70, 15);
		Painel.add(lblMinuto);
		
		//Cria um JLabel segundo
		JLabel lblSegundo = new JLabel("Segundo");
		lblSegundo.setBounds(286, 65, 70, 15);
		Painel.add(lblSegundo);
		
		//Cria um JLabel minuto
		JLabel lblMil = new JLabel("Milissegundo");
		lblMil.setBounds(412, 65, 103, 15);
		Painel.add(lblMil);
		
		//Cria um JLabel com a imagem do incone da Lasalle
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tela.class.getResource("/trabalhoCronometro/UnilasalleLogo.jpg")));
		lblNewLabel.setBounds(44, 172, 301, 90);
		Painel.add(lblNewLabel);
		
		
		
		//Cria um JButton "Iniciar"
		JButton btnIniciar = new JButton("Iniciar");
		//Adiciona o metodo que vai ser executado quando o botão for clicado no caso vai disparar as Threads
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tMilessimo.isAlive())
					tMilessimo.start();
				if(!tSegundo.isAlive())
					tSegundo.start();
				if(!tMinuto.isAlive())
					tMinuto.start();
				if(!tHora.isAlive())
					tHora.start();
				
				
			}
		});
		//Seta configuracoes de layout do botão/
		btnIniciar.setBackground(new Color(154, 205, 50));
		btnIniciar.setBounds(562, 60, 117, 25);
		//Adiciona o botão ao painel criado;
		Painel.add(btnIniciar);
		
		
		
		//Cria um JButton "Parar"
		JButton btnParar = new JButton("Parar");
		//Adiciona o metodo que vai ser executado quando o botão for clicado no caso vai suspender as Threads
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tMilessimo.isAlive())
					tMilessimo.suspend();
				if(tSegundo.isAlive())
					tSegundo.suspend();
				if(tMinuto.isAlive())
					tMinuto.suspend();
				if(tHora.isAlive())
					tHora.suspend();
				
			}
		});
		//Seta configuracoes de layout do botão/
		btnParar.setBackground(new Color(255, 0, 0));
		btnParar.setBounds(562, 116, 117, 25);
		//Adiciona o botão ao painel criado;
		Painel.add(btnParar);
		
		
		
		//Cria um JButton "Retomar"
		btnRetomar = new JButton("Retomar");
		btnRetomar.setBackground(new Color(255, 215, 0));
		//Adiciona o metodo que vai ser executado quando o botão for clicado no caso vai Retomar as Threads
		btnRetomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tMilessimo.isAlive())
					tMilessimo.resume();
				if(tSegundo.isAlive())
					tSegundo.resume();
				if(tMinuto.isAlive())
					tMinuto.resume();
				if(tHora.isAlive())
					tHora.resume();
				

			}
		});
		//Seta configuracoes de layout do botão/
		btnRetomar.setBounds(562, 172, 117, 25);
		//Adiciona o botão ao painel criado;
		Painel.add(btnRetomar);
		
		
		
		//Cria um JButton "Zerar"
		JButton btnNewButton = new JButton("Zerar");
		btnNewButton.setBackground(new Color(255, 127, 80));
		//Adiciona o metodo que vai ser executado quando o botão for clicado no caso vai parar as Threads,
		// em seguida ele instancias novas threads para cada classe ,
		// e por final seta o valor do JTextfield referente a hora,minuto,segundo e milissegundo com o valor 0;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
						tMilessimo.stop();
						tSegundo.stop();
						tMinuto.stop();
						tHora.stop();
						
						tHora = new Thread(hora);
						tMinuto= new Thread(minuto);
						tSegundo = new Thread(segundo);
						tMilessimo = new Thread(milessimo);
						
						Tela.txtMiliSegundo.setText("0");
						Tela.txtSegundo.setText("0");
						Tela.txtMinuto.setText("0");
						Tela.txtHora.setText("0");
			
				
				
			
		}});
		//Seta configuracoes de layout do botão/
		btnNewButton.setBounds(562, 230, 117, 25);
		//Adiciona o botão ao painel criado;
		Painel.add(btnNewButton);
		
	}

}
