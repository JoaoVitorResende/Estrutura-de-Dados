package listaencadiada;

import javax.swing.JOptionPane;

public class Lista {
	No inicio, atual, fim;
	int tamanho = 0;

	public void adiciona(int v) {
		No novo = new No(v);
		tamanho++;
		if (inicio == null) {
			System.out.println("teste");
			inicio = novo;
			fim = novo;
			atual = inicio;
		} else {
			System.out.println("teste 2");
			fim.proximo = novo;
			novo.anterior = fim;
			fim = novo;
		}
	}

	public void IncerePrimeiro(int v) {
		No novo = new No(v);
		novo.proximo = inicio;
		inicio.anterior = novo;
		inicio = novo;
		tamanho++;
	}

	public void RetiraPrimeiro() {
		tamanho--;
		inicio = inicio.proximo;
		inicio.anterior = null;
	}

	public void RetiraUltimo() {
		tamanho--;
		fim = fim.anterior;
		fim.proximo = null;
	}

	public void Retira() {
		tamanho--;
		atual = inicio;
		String ok = "n";
		do {
			ok = JOptionPane.showInputDialog("esse é o valor que quer retirar ? " + atual.valor + "s/n");
			if (ok.equalsIgnoreCase("s")) {
				atual = atual.proximo.anterior = atual.anterior;
				atual.anterior.proximo = atual.proximo;
				atual = atual.proximo;
			} else {
				atual = atual.proximo;
			}
		} while (ok.equalsIgnoreCase("s"));
	}

	public void AdicioQualQuerLugar(int v) {
		tamanho++;
		No novo = new No(v);
		atual = inicio;
		String ok = "n";
		do {
			if (ok.equalsIgnoreCase("s")) {
				atual.proximo.anterior = novo;
				novo.anterior = atual;
				novo.proximo = atual.proximo;
				atual.proximo = novo;
			} else {
				atual = atual.proximo;
			}
		} while (ok.equalsIgnoreCase("s"));
	}

	public void MostraProximo() {
		System.out.println("proximo");
		boolean ok = false;
		atual = inicio;
		do {
			System.out.println(atual.valor);
			if (atual.proximo == null) {
				ok = true;
			} else {
				atual = atual.proximo;
			}
		} while (!ok);
	}

	public void MostraAnterior() {
		System.out.println("Anteriror");
		atual = fim;
		boolean ok = false;
		do {
			System.out.println(atual.valor);
			if (atual.anterior == null) {
				ok = true;
			} else {
				atual = atual.anterior;
			}
		} while (!ok);
	}
}
