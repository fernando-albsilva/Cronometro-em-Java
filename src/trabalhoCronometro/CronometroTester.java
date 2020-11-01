package trabalhoCronometro;

import java.awt.EventQueue;

public class CronometroTester {


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Tela frame = new Tela();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	

}
