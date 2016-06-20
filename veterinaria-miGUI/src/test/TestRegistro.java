package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import paneles.JPanelRegistro;
import veterinaria.HistoriaClinica;

public class TestRegistro extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private static void createAndShowGUI() {

        JFrame frame = new JFrame("Registro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        HistoriaClinica hc = new HistoriaClinica("pepe", "ASDF56ASD");
        
        JPanelRegistro newContentPane = new JPanelRegistro(hc, frame);
        
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
