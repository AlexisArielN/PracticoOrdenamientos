import javax.swing.*;
import java.awt.*;

public class principal extends JFrame{

    private JButton botonIniciarArreglo = new JButton("INICIAR ARREGLO");
    private JButton botonOrdenarArreglo = new JButton("ORDENAR EL ARREGLO");
    private JButton botonArregloOrdenado = new JButton("ARREGLO ORDENADO");

    private int numeroUsuario;
    private Ordenamientos obj;

    public principal(){
        setTitle("Ventana");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        iniciarComponentes();

        setVisible(true);
    }

    public void iniciarComponentes(){
        botonIniciarArreglo.setBounds(10,10,100,30);
        botonIniciarArreglo.setMargin(new Insets(0,0,0,0));
        botonOrdenarArreglo.setBounds(10,80,100,30);
        botonOrdenarArreglo.setMargin(new Insets(0,0,0,0));
        botonArregloOrdenado.setBounds(10,130,100,30);
        botonArregloOrdenado.setMargin(new Insets(0,0,0,0));
        this.add(botonIniciarArreglo);
        this.add(botonOrdenarArreglo);
        this.add(botonArregloOrdenado);


        botonIniciarArreglo.addActionListener(e ->{
            boolean preguntaUsuario = false;
            while(preguntaUsuario == false) {
                numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("INGRESA EL TAMAÑO DEL ARREGLO ENTRE 10.000 y 1.000.000"));
                if (numeroUsuario >= 10000 && numeroUsuario <= 1000000) {
                    preguntaUsuario = true;
                } else {
                    JOptionPane.showMessageDialog(null, "INGRESA UN NUMERO ENTRE 10.000 y 1.000.000");
                }
            }
            obj = new Ordenamientos(numeroUsuario);//10000
        });
        botonOrdenarArreglo.addActionListener(e ->{
            try{
                obj.ordemientoArreglo();
                obj.mostrarArreglo1();
                obj.mostrarArreglo2();
                obj.mostrarArreglo3();
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "DEBES PRIMERO AGREGAR UN ARREGLO");
            }
        });
        botonArregloOrdenado.addActionListener(e -> {
            try {
                obj.arreglosOrdenados();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "DEBES PRIMERO AGREGAR UN ARREGLO");
            }
        });
    }

    public static void main(String[] args) {
        principal ventana = new principal();
    }
}
