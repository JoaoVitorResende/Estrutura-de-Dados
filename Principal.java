package listaencadiada;

public class Principal {

	public static void main(String[] args) {
		Lista l = new Lista();
		l.adiciona(1);
		l.adiciona(2);
		l.adiciona(3);
		l.MostraProximo(); 
		l.MostraAnterior();
	}
}
