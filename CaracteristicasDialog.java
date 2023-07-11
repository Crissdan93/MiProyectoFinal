package ProyectoFinal;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

public class CaracteristicasDialog extends JDialog {

    private static final String[] AUTOS = {
        "Nissan Versa",
        "Kia Rio Sedán",
        "Chevrolet Aveo",
        "Nissan March",
        "Chevrolet Onix",
        "MG 5",
        "Nissan Sentra",
        "Suzuki Swift",
        "KIA Rio Hatchback"
    };

    private static final String[] IMAGENES = {
        "Nissan Versa.png",
        "Kia Rio Sedán.png",
        "Chevrolet Aveo.png",
        "Nissan March.png",
        "Chevrolet Onix.png",
        "MG 5.png",
        "Nissan Sentra.png",
        "Suzuki Swift.png",
        "KIA Rio Hatchback.png"
    };

    private static final String[][] CARACTERISTICAS = {
        {"Precio en MXN $105800", "Color Rojo", "4 puertas"},
        {"Precio en MXN $205600", "Color Blanco", "4 puertas"},
        {"Precio en MXN $208900", "Color Azul", "4 puertas"},
        {"Precio en MXN $250900", "Color Rojo", "4 puertas"},
        {"Precio en MXN $180900", "Color Rojo", "4 puertas"},
        {"Precio en MXN $200550", "Color Gris", "4 puertas"},
        {"Precio en MXN $300600", "Color Blanco", "4 puertas"},
        {"Precio en MXN $270400", "Color Rojo", "2 puertas"},
        {"Precio en MXN $125800", "Color Azul", "4 puertas"}
    };

    private ImageIcon[] imagenesAutos;
    private String[] caracteristicas;

    public CaracteristicasDialog(String nombreAuto) {
        setTitle("Características de " + nombreAuto);
        setModal(true);
        setBounds(150, 150, 600, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        int indiceAuto = obtenerIndiceAuto(nombreAuto);

        if (indiceAuto >= 0) {
            caracteristicas = CARACTERISTICAS[indiceAuto];

            JLabel labelImagen = new JLabel();
            cargarImagen(nombreAuto, labelImagen);

            JList<String> listaCaracteristicas = new JList<>(caracteristicas);
            listaCaracteristicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, labelImagen, listaCaracteristicas);
            splitPane.setResizeWeight(0.3);

            panel.add(splitPane, BorderLayout.CENTER);
        } else {
            JLabel etiquetaNoEncontrado = new JLabel("No se encontraron características para " + nombreAuto);
            panel.add(etiquetaNoEncontrado, BorderLayout.CENTER);
        }

        setContentPane(panel);
    }

    private void cargarImagen(String nombreAuto, JLabel labelImagen) {
        int indiceAuto = obtenerIndiceAuto(nombreAuto);
        if (indiceAuto >= 0) {
            String rutaImagen = "/Imagenes/" + IMAGENES[indiceAuto];
            ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
            labelImagen.setIcon(imagen);
        }
    }

    private int obtenerIndiceAuto(String nombreAuto) {
        for (int i = 0; i < AUTOS.length; i++) {
            if (AUTOS[i].equals(nombreAuto)) {
                return i;
            }
        }
        return -1;
    }
}