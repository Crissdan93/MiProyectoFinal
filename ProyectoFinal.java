package ProyectoFinal;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProyectoFinal extends JFrame {

    public ProyectoFinal() {
        setTitle("Lista de autos");
        setBounds(50, 120, 500, 1000);
        componentes();
    }

    private void componentes() {
        FondoPanel fondoPanel = new FondoPanel();
        setContentPane(fondoPanel);

        fondoPanel.setLayout(null);

        JButton boton1 = new JButton();
        boton1.setText("ABRIR LISTA");
        boton1.setBounds(150, 470,150,30 );
       
        fondoPanel.add(boton1);

        ListaDesplegada listaDesplegada = new ListaDesplegada();

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listaDesplegada.setVisible(true);
            }
        });

        listaDesplegada.agregarListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String nombreAutoSeleccionado = listaDesplegada.getAutoSeleccionado();
                    CaracteristicasDialog dialogo = new CaracteristicasDialog(nombreAutoSeleccionado);
                    dialogo.setVisible(true);
                }
            }
        });
    }

    class FondoPanel extends JPanel {
        private Image imagen;

        public FondoPanel() {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/autos.png")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
        
      
            }
        
        
				
			
		
		
	


	