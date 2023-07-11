package ProyectoFinal;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.event.ListSelectionListener;

public class ListaDesplegada extends JFrame {

    private JPanel contentPane;
    private JList<String> listaAutos;

    public ListaDesplegada() {
        setTitle("Lista de autos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 300);

        // Crear el contenido de la lista
        String[] autos = {"Nissan Versa", "Kia Rio Sedán", "Chevrolet Aveo","Nissan March","Chevrolet Onix","MG 5","Nissan Sentra","Suzuki Swift","KIA Rio Hatchback"};
        listaAutos = new JList<>(autos);
        JScrollPane scrollPane = new JScrollPane(listaAutos);

        // Configurar el panel de contenido
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(scrollPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }

    public void agregarListener(ListSelectionListener listener) {
        listaAutos.addListSelectionListener(listener);
    }

    public String getAutoSeleccionado() {
        return listaAutos.getSelectedValue();
    }
}