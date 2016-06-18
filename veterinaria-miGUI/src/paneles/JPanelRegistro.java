package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import veterinaria.HistoriaClinica;
import veterinaria.Registro;



public class JPanelRegistro extends JPanel 
								implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private final JButton nuevoRegistro;
	private LinkedList<Registro> registros = null;
	private final JTable tabla;
	private JDialog frame;
	
	public JPanelRegistro(HistoriaClinica historiaClinica, JFrame contenedor) {
		super();
		nuevoRegistro =  new JButton("Nuevo Registro");
		nuevoRegistro.setVerticalTextPosition(AbstractButton.CENTER);
		nuevoRegistro.setMnemonic(KeyEvent.VK_N);
		nuevoRegistro.addActionListener(this);
		
		this.registros = historiaClinica.getRegistro();
		
		this.tabla = new JTable(new TablaRegistro());
		tabla.setPreferredScrollableViewportSize(new Dimension(700, 70));
		JScrollPane scrollPane = new JScrollPane(tabla);
			
                this.add(scrollPane);
			
		this.add(nuevoRegistro);
	}
    
	
    class TablaRegistro implements TableModel {
    	
		@Override
		public void addTableModelListener(TableModelListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case 0:	return String.class;
			case 1:	return Double.class;
			case 2:	return Double.class;
			default: return null;
			}
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int arg) {
			switch (arg) {
			case 0: return "fecha";
			case 1:	return "peso";
			case 2:	return "medida";
			default:return null;
			}
		}

		@Override
		public int getRowCount() {
			return JPanelRegistro.this.registros.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			Registro registro = JPanelRegistro.this.registros.get(rowIndex);
			switch (columnIndex) {
				case 0: return registro.getFecha();
				case 1: return registro.getPeso();
				case 2: return registro.getMedida();
				default: return null;
			}
		}

		
		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

		@Override
		public void removeTableModelListener(TableModelListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setValueAt(Object arg0, int arg1, int arg2) {
			Registro registro = JPanelRegistro.this.registros.get(arg1);
			switch (arg2) {
			case 1:
				registro.setFecha((Date)arg0);
				break;
			case 2:
				registro.setPeso((Double)arg0);
				break;
			case 3:
				registro.setMedida((Double)arg0);
			}
		}
    	
    	
    }
    /* Creador de Jdialog al precionar crear nuevo registro */
	@Override
	public void actionPerformed(ActionEvent e) {

	    frame = new JDialog((JFrame)this.getParent().getParent().getParent(), "Nuevo Registro", true );
		frame.setContentPane(new JPanelCrearRegistro());
        frame.pack();
        frame.setVisible(true);
	}
	
	/* Panele para creacion de Registros */
	
	private class JPanelCrearRegistro extends JPanel implements ActionListener {
		
		JTextField fecha;
		Date fechatomada;
		JTextField peso;
		JTextField medida;
		JButton agregar;
		private static final long serialVersionUID = 1L;
		
		public JPanelCrearRegistro() {
			super();
			fecha = new JTextField(20);
			peso = new JTextField(4);
			medida = new JTextField(5);
			
			fechatomada = new Date();
			fecha.setText((new SimpleDateFormat("dd-mm-YYYY").format(fechatomada)).toString());
			fecha.setEditable(false);
			agregar = new JButton("Agregar");
			agregar.addActionListener(this);
			JLabel fechat = new JLabel("Fecha");
			add(fechat);
			add(fecha);
			JLabel pesot = new JLabel("Peso");
			add(pesot);
			add(peso);
			JLabel medidat = new JLabel("Medida");
			add(medidat);
			add(medida);
			add(agregar);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Registro nr = new Registro(fechatomada, Double.parseDouble(peso.getText()), Double.parseDouble(medida.getText()));
				JPanelRegistro.this.registros.add(nr);
				JPanelRegistro.this.frame.setVisible(false);
				
				/* recargo la tabla */
				JPanelRegistro.this.tabla.setVisible(false);
				JPanelRegistro.this.tabla.setVisible(true);
				
			} catch( java.lang.NumberFormatException e1){
				if(peso.getText().isEmpty() || medida.getText().isEmpty()){
					JOptionPane.showConfirmDialog(null, "Complete los campos", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showConfirmDialog(null, "Ingrese datos validos", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
   
}