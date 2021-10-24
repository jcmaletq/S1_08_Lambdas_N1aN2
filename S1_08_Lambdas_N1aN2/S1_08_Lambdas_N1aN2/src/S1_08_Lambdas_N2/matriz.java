package S1_08_Lambdas_N2;

import java.util.Arrays;
import java.util.stream.Collectors;
public class matriz implements Operacio{
	private int rows;
	private int columns;
	private String matriz[][];
	static String [] vector = {"Id_entero","nombre","apellido","numero de curso","clase","nif"};
	private static int COUNTER_ROW = 0;
// constructor	
	public matriz () {	
	}
	public matriz (int rows, int columns) {    // en el constructor agrego datos para tener un juego de pruebas
		this.columns = columns;
		this.rows = rows;
		matriz = new String [rows][columns];
		if (rows > 0) {
			COUNTER_ROW++;
			matriz[0][0]= (String) "1";
			matriz[0][1]= (String) "name";
			matriz[0][2]= (String) "surname";
			matriz[0][3]= (String)  "2";
			matriz[0][4]= (String)  "B";
			matriz[0][5]= (String)  "y123456Z";
		}
		if (rows > 1) {
		COUNTER_ROW++;
		matriz[1][0]= (String)  "2";
		matriz[1][1]= (String)  "name2";
		matriz[1][2]= (String)  "surname2";
		matriz[1][3]= (String)  "22";
		matriz[1][4]= (String)  "B2";
		matriz[1][5]= (String)  "x12345622Z";
		}
	}
// metodos

	
	public void add_row( String nombre, String apellido, String numero_de_curso, String clase, String nif ){

		int row = COUNTER_ROW;
		if (row<this.rows) {
		matriz[row][0]= (String) Integer.toString(COUNTER_ROW+1);
		matriz[row][1]= (String) nombre;
		matriz[row][2]=(String)  apellido;
		matriz[row][3]=(String)  numero_de_curso;
		matriz[row][4]= (String) clase;
		matriz[row][5]= (String) nif;
		COUNTER_ROW++;
		}
		else {System.out.println("no insertada linea "+ apellido +" "+ nombre +
				" por exceder declaracion inicial de " +this.rows);}
}
public void ord_by_len(String text) {  //longitud ( de més curta a més llarga) 
	int pos = pos_vect(text);
	 System.out.println("order by length :" +text);
    Arrays
      .stream(matriz)
      .sorted((a1, a2) -> a1[pos].length() - a2[pos].length())
      .forEach(a -> System.out.println(Arrays.toString(a)));	
}
public void ord_by_len_inv(String text) { //longitud inversa (de  més llarga a  més curta) 
	int pos = pos_vect(text);
	 System.out.println("order by length inver :" +text);
    Arrays
      .stream(matriz)
      .sorted((a1, a2) -> a2[pos].length() - a1[pos].length())
      .forEach(a -> System.out.println(Arrays.toString(a)));	
}
public void ord_by_alf(String text) { //alfabèticament
	int pos = pos_vect(text);
	System.out.println("order by alf : " +text);
    Arrays
      .stream(matriz)
      .sorted((a1, a2) -> a1[pos].compareTo(a2[pos]))
      .forEach(a -> System.out.println(Arrays.toString(a)));
}
public void ord_by_alf_char0(String text) {  //alfabèticament pel primer caràcter
	int pos = pos_vect(text);
	System.out.println("order by alf 1 char: " +text);
    Arrays
      .stream(matriz)
      .sorted((a1, a2) -> a1[pos].charAt (0) - a2[pos].charAt (0))
      .forEach(a -> System.out.println(Arrays.toString(a)));
}

public void ord_by_alf_cont_char(String text, String ch) {  //cadenes que contenen "e" primer, tota la resta en segon lloc. 
	int pos = pos_vect(text);                               //De moment , poseu el codi directament a la lambda.
	System.out.println("order " +text+" by cont char: " + ch);
    Arrays
      .stream(matriz)
      .sorted((a1, a2) -> {if(a1[pos].contains(ch) && a2[pos].contains(ch)) {return 0;}
                             else if(a1[pos].contains(ch)) {return -1;}
                                 else {return 1;}
                         })
      .forEach(a -> System.out.println(Arrays.toString(a)));
}

public void repla_char_by_char( String ch, String by) {     // no lo se hacer con lambda
	//Modifica tots els elements de la  matriu per canviar els caracters  “a” a “4”                              
	System.out.println("replace " +ch+" by char: " + by);
	for (int r=0;r < COUNTER_ROW; r++) {
		 for (int c=0;c < vector.length; c++) {
			matriz[r][c]= (matriz[r][c]).replaceAll(ch,by); 
		 }
	}
    Arrays
    .stream(matriz)    
      .forEach(a -> System.out.println(Arrays.toString(a)));
}
public void filter_numer () {
	//Mostra només els elements que siguin 100% numerics .
	//(tot i que  estigui guardats com strings)
	System.out.println("Filtra no numericos" );
	System.out.println(str_vect());
	Arrays 
            .stream(matriz)
               .forEach ( a -> {isnumeric(a); 
                                System.out.println("");
                                })  
              ;
}
// imprime solo los numericos
public void isnumeric(String [] text) {
	Arrays
	   .stream(text)
	     .forEach (b -> {
				try {Double.parseDouble(b);
				              System.out.print(b+" , ");
						} catch (NumberFormatException excepcion) {
							System.out.print(" , ");
				}
	});
}
// interna def columna
public int pos_vect(String text) {
	int ret =0;
	for (int i = 0; i < vector.length; i++) {
		  if(vector[i].equals(text)){ret = i;}
		  }
	return ret;
}
// retorna las cabeceras
public static String str_vect() {
	String ret="";
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < vector.length; i++) {
		sb.append(vector[i]+" , ");}
	ret = sb.toString();
	return ret;
}	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret="";
		for (int r=0;r < COUNTER_ROW; r++) {
			 for (int c=0;c < vector.length; c++) {
				ret+=matriz[r][c]+", "; 
			 }
			 ret+="\n";
		}
		return ret;
	}
public void operaciones(){  // usa la interfase estandar y lambda
    System.out.print ("metodo tradicional interfase x+y 10,10 = ");
    matriz opera = new matriz();
    float val = opera.operacion(10,10);
    System.out.println(val);
    System.out.print ("metodo lambda incrustada x*y 10,10 = ");
    Operacio opera_l = (float x, float y) -> (x*y);
    val = opera_l.operacion(10,10);
    System.out.println(val);  
    System.out.print ("metodo lambda incrustada x/y 10,10 = ");
    Operacio opera_l2 = (float x, float y) -> (x/y);
    val = opera_l2.operacion(10,10);
    System.out.println(val);  
    System.out.print ("metodo lambda incrustada x-y 10,10 = ");
    Operacio opera_l3 = (float x, float y) -> (x-y);
    val = opera_l3.operacion(10,10);
    System.out.println(val);  
}
// para demostrar el estandar
	@Override
	public float operacion(float x, float y) {
		return x+y;
	}
	
}
