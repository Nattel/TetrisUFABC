import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

// Tudo está sendo feito encima do jogo de FlappyBird. inclusive as imagens. Posteriormente desenharei uma especifica para o jogo
// Os blocos e sua queda estão criados. Os próximos passos são:
// 1. Hitbox  3. Perder quando chegar ao topo 4. Fazer a identidade 5.Fazer o Placar   

public class Tetris implements Jogo{
	public Pedaco pedaco;
	public static ArrayList<Bloco> blocos = new ArrayList<Bloco>();
	int i;
	static int pontos = 0;
	public Grade grade;
	
	//o novo pedaço é criado aleatóriamente a partir de uma lista pré-setada de "disciplinas"
	private void novoPedaco() {
		i = new Random().nextInt(2);
		grade = new Grade(i);
		pedaco = (new Pedaco(
				grade.comprimento, 
				grade.altura,
				grade.a0 , grade.a1, grade.a2, grade.a3, grade.a4, grade.a5,
				grade.b0 ,grade.b1, grade.b2, grade.b3, grade.b4, grade.b5,
				grade.c0, grade.c1, grade.c2, grade.c3, grade.c4, grade.c5 
		)
		);
	}
	
	static void novoBloco(int x, int y) {
		blocos.add(new Bloco(x, y));
	}
	
	static void dropLine(int index) {
		for(int i = index; i>=0; i--) {
			for(Bloco block: blocos) {
				if(block.y < i)
					block.goDown();
			}
		}
	}
	
	static void eraseLine() {
		int k;
		for(int i = 17; i>=0; i--) { 		//altura
			k = 0;
			for(int j = 9; j>=0; j--) {		//largura
				for(Bloco block: blocos) {
					if(block.y == i && block.x == j) {
						k++;
					}
				}
			}
			
			if(k >= 10) {
				for(int j = 9; j>=0; j--) {
					for(int l = 0; l < blocos.size(); l++) {
						if(blocos.get(l).y == i && blocos.get(l).x == j) {
							blocos.remove(l);
							l--;
						}
					}
				}
				pontos+=25;
				dropLine(i);
				eraseLine();
				return;
			}
			
		}
	}
	
	static boolean verticalColide(int x, int y) {
		for(Bloco block: blocos)
			if(x == block.x && y ==block.y)
				return true;
		return false;
	}
	
	public Tetris() {
		novoPedaco();
		pedaco.create();
	}
	
	@Override
	public String getTitulo() {
		return "Matrículaaaaaa";
	}

	@Override
	public int getLargura() {
		return 520;
	}

	@Override
	public int getAltura() {
		return 468;
	}

	@Override
	public void tique(Set<String> teclas, double dt) {
		// TODO Auto-generated method stub
		
		//cria um novo pedaco se há colisaovertical
		if(!pedaco.atualiza(dt)) {
			novoPedaco();
			pedaco.create();
		}
		
	}

	@Override
	public void tecla(String tecla) {
		// TODO Auto-generated method stub
		pedaco.tecla(tecla);		
	}
	
	void desenharNum(Tela tela) {
		
	}
	
	void score(Tela tela) {
		int pts = pontos, div = 10, resto = pts%div, yPos;
		for(int i = 3; i > 0; i--) {
			yPos = 400 + i*16;
			switch(resto*10/div) {
				case 0:
					tela.imagem("assets/flappy.png", 576, 200, 14, 20, 0, yPos, 49);
					break;
				case 1:
					tela.imagem("assets/flappy.png", 578, 236, 14, 20, 0, yPos, 49);
					break;
				case 2:
					tela.imagem("assets/flappy.png", 578, 268, 14, 20, 0, yPos, 49);
					break;
				case 3:
					tela.imagem("assets/flappy.png", 578, 300, 14, 20, 0, yPos, 49);
					break;
				case 4:
					tela.imagem("assets/flappy.png", 574, 346, 14, 20, 0, yPos, 49);
					break;
				case 5:
					tela.imagem("assets/flappy.png", 574, 370, 14, 20, 0, yPos, 49);
					break;
				case 6:
					tela.imagem("assets/flappy.png", 330, 490, 14, 20, 0, yPos, 49);
					break;
				case 7:
					tela.imagem("assets/flappy.png", 350, 490, 14, 20, 0, yPos, 49);
					break;
				case 8:
					tela.imagem("assets/flappy.png", 370, 490, 14, 20, 0, yPos, 49);
					break;
				case 9:
					tela.imagem("assets/flappy.png", 390, 490, 14, 20, 0, yPos, 49);
					break;
			}

			pts-=resto;
			div*=10;
			resto = (pts)%div;
		}
	}

	@Override
	public void desenhar(Tela tela) {
		// TODO Auto-generated method stub
		
		//background
		tela.imagem("assets/flappy.png", 0, 0, 288, 512, 0, 0, 0);
		tela.imagem("assets/flappy.png", 0, 0, 72, 512, 0, 288, 0);
		tela.imagem("assets/flappy.png", 0, 450, 288, 28, 0, 0, 512);
		tela.imagem("assets/flappy.png", 0, 450, 72, 28, 0, 288, 512);
		
		//lateral direita
			//score
			tela.imagem("assets/flappy.png", 288, 2, 163, 110, 0, 356, 0);
			score(tela);
			
			
			
			//coisas abaixo que eu ainda não tenho certeza do que serão
			tela.imagem("assets/flappy.png", 288, 2, 163, 110, 0, 356, 110);
			tela.imagem("assets/flappy.png", 288, 14, 163, 98, 0, 356, 220);
			tela.imagem("assets/flappy.png", 288, 14, 163, 98, 0, 356, 318);
			tela.imagem("assets/flappy.png", 288, 14, 163, 52, 0, 356, 416);
			
		//não é desenhado o pedaco de uma vez, o pedaco deve desenhar bloco por bloco.		
		for(Bloco block: blocos) {
			if(block.y < 0) {
				System.out.println("GAME OVER");
				gameOver(tela);
				return;
			}
			block.desenhar(tela);
		}
		pedaco.desenhar(tela);
	}
	
	public static void main(String[] Args) {
		roda();
	}
	
	public static void roda() {
		new Motor(new Tetris());
	}

	public static void gameOver(Tela tela) {
		for(int i = 0; i<blocos.size(); i++)
			blocos.remove(0);
		//background
		tela.imagem("assets/flappy.png", 0, 0, 288, 512, 0, 0, 0);
		tela.imagem("assets/flappy.png", 0, 0, 72, 512, 0, 288, 0);
		tela.imagem("assets/flappy.png", 0, 450, 288, 28, 0, 0, 512);
		tela.imagem("assets/flappy.png", 0, 450, 72, 28, 0, 288, 512);
		
		
		tela.imagem("assets/flappy.png", 400, 250, 250, 68, 0, 20, 256);
		
	}

}
