package S1_08_Lambdas_N1_f2;
//import java.lang.FunctionalInterface;

public class met_abst {
/*
 * Crea una Funcional Interfase que continga un metodo abstracte getPiValue (),
 * que retorn a un valor double; en una altra classe,
 * instancie la interficie i assigneu-li mitjançant una lambda el valor 3.1415.
 * Invoca el metode getPiValue dela instancia d'interficie i mprimeix el resultat.
 */
	public static void main(String[] args) {
		In_Const_Value_Double ref_pi;   // referencia a la interface
		ref_pi = () -> 3.1415;
		System.out.println("Valor de Pi referenciado = " + ref_pi.getPiValue());
/*		
		In_Const_Value_Double ref_g;   // referencia a la interface para otra constante doble
		ref_g = () -> 9.8;
		System.out.println("Valor de g referenciado = " + ref_g.getPiValue());	
*/	
	}
}
