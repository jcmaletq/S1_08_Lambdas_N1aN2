package S1_08_Lambdas_N2;
import javax.swing.JOptionPane;
import S1_08_Lambdas_N2.matriz;
public class Entrega_main  {
	/*
	 * Feu una matriu  que contingui algunes cadenes de  text  y numeros. Ordeneu-lo per:  
			longitud ( de més curta a més llarga) 
			longitud inversa (de  més llarga a  més curta) 
			alfabèticament pel primer caràcter ( Nota: charAt (0) retorna el  codi numèric del primer  caràcter) 
		Les cadenes que contenen "e" primer, tota la resta en segon lloc. De moment , poseu el codi directament a la lambda.  
		Modifica tots els elements de la  matriu per canviar els caracters  “a” a “4”  
		Mostra només els elements que siguin 100% numerics . (tot i que  estigui guardats com strings)   
	Crea una Functional Interface que continga un mètode abstracte operacio (), que retorne un valor float;
	 injecta a la interfície creada mitjançant una lambda el cos del mètode,
	  de manera que pugis transformar la operació a una suma, resta, multiplicació i divisio. 
	 */
	public static void main(String[] args) {
	
      String[] vect= matriz.vector;
      String columna = "";
      String ask= "";
      String letra1,letra="";
      int vect_j = vect.length;
      int vect_i =Integer.parseInt( JOptionPane.showInputDialog("introudce el numero de lineas a introducir ","4"));
      //int vect_i = 3;
      matriz mat1 = new matriz(vect_i,vect_j);    // creo la matriz
      mat1.add_row( "nombre","apellido","6.01","clase","nif");  // uso metodo añadir columna
      mat1.add_row( "nombre1","apellido1","numero_de_curso1","clase1","nif1");  // uso metodo añadir columna
      System.out.println(mat1);
      ask = matriz.str_vect();
      columna = JOptionPane.showInputDialog("introudce una columna a ordenar "+"\n"+ask,"apellido");
      mat1.ord_by_alf(columna);
      mat1.ord_by_alf_char0(columna);
      mat1.ord_by_len(columna);
      mat1.ord_by_len_inv(columna);
      letra = JOptionPane.showInputDialog("introudce una letra a ordenar ","e");
      mat1.ord_by_alf_cont_char(columna,letra);  
      letra = JOptionPane.showInputDialog("introudce una letra a reemplazar ","a");
      letra1 = JOptionPane.showInputDialog("introudce una letra reemplazante ","4");
      mat1.repla_char_by_char(letra, letra1);
      mat1.filter_numer();
	  mat1.operaciones();
	}
}
