package view;

import javax.swing.JFrame;

public class Formulario extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void Form() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Formulário Cadastro");
		jFrame.setSize(700, 300);
		jFrame.setLocation(500, 300);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.setVisible(true);
		
		
		
	}
}
