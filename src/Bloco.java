
public class Bloco {
	public int x, y;
	public int altura = 26, largura = 36;
 
	
	public Bloco(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void goDown() {
		y += 1;
	}
	
	//não está fazendo nada
	public void atualiza(double dt) {
		//verificação deve ser feita em pedaco.
		//y += vy*dt;
		//box.mover(0, vy*dt);
	}
	
	public void sideways(int direcao) {
		//verificação deve ser feita em pedaco.
		x += direcao;
	}
	
	public void desenhar(Tela tela) {
		tela.imagem("assets/flappy.png", 528, 128, 34, 24, 0, x*largura, y*altura);
	}
}
