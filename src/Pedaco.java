import java.util.ArrayList;

public class Pedaco {
	
	public ArrayList<Bloco> bloco = new ArrayList<Bloco>();
	int comprimento, altura;
	public Timer dropTimer;
	float timeLoop = 1;
	
	//Matriz que indica se há ou não um bloco na posição, chamarei de "matriz binária de existência"
	boolean a0, a1, a2, a3, a4, a5;
	boolean b0, b1, b2, b3, b4, b5;
	boolean c0, c1, c2, c3, c4, c5;
	
	public Pedaco(
			int comprimento, int altura,
			boolean a0, boolean a1, boolean a2, boolean a3, boolean a4, boolean a5, 
			boolean b0, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, 
			boolean c0, boolean c1, boolean c2, boolean c3, boolean c4, boolean c5
	){
		this.comprimento = comprimento;
		this.altura = altura;
		this.a0 = a0; this.a1 = a1; this.a2 = a2; this.a3 = a3; this.a4 = a4; this.a5 = a5;
		this.b0 = b0; this.b1 = b1; this.b2 = b2; this.b3 = b3; this.b4 = b4; this.b5 = b5;
		this.c0 = c0; this.c1 = c1; this.c2 = c2; this.c3 = c3; this.c4 = c4; this.c5 = c5;
	}
	
	//puxa o bloco para baixo, se possível
	public Acao goDown() {
		return new Acao() {
			public void executa() {
				if(!isColidingVertically()) {
					for(Bloco block: bloco) {
						block.goDown();
					}
				}
			}
		};
		
	}
	
	public void create() {
		
		//cria os blocos segundo a matriz binária de existência
		int comp;
		if(comprimento%2 == 1)
			comp = comprimento+1;
		else
			comp = comprimento;
		
		for(int i = 0; i < altura; i++) {
			for(int j = 0; j < comprimento; j++) {
				if(coordenadas(i, j) == true) {
					bloco.add(new Bloco((5-comp/2)+j, i));
				}
			}
		}
		
		dropTimer = new Timer(0.1, true, goDown());
	}
	
	//gambiarrrrraaaaaa.
	public boolean coordenadas(int i, int j) {
		if(i == 0) {
			switch(j) {
			case 0:
				return a0;
			case 1:
				return a1;
			case 2:
				return a2;
			case 3:
				return a3;
			case 4:
				return a4;
			case 5:
				return a5;
			}
			
		}else if(i == 1) {
			switch(j) {
			case 0:
				return b0;
			case 1:
				return b1;
			case 2:
				return b2;
			case 3:
				return b3;
			case 4:
				return b4;
			case 5:
				return b5;
			}
		}else {
			switch(j) {
			case 0:
				return c0;
			case 1:
				return c1;
			case 2:
				return c2;
			case 3:
				return c3;
			case 4:
				return c4;
			case 5:
				return c5;
			}
		}
		return c5;
	}
	
	public boolean isColidingVertically() {
		for(Bloco block: bloco) {			
			if(block.y==18 || Tetris.verticalColide(block.x, block.y)) {
				//transforma o pedaco em blocos separados
				for(Bloco blocos: bloco)
					Tetris.novoBloco(blocos.x, blocos.y - 1);
				
				Tetris.eraseLine();
				return true;
			}
		}
		return false;
	}
	
	public boolean isColidingHorizontally(String tecla) {
		int direcao;
		if(tecla.equals("a")) direcao = -1;
		else if(tecla.equals("d")) direcao =  1;
		else direcao = 0;
		
		for(Bloco block: bloco) {
			if(!(block.x + direcao >= 0 && (block.x+ direcao) <= 9) || Tetris.verticalColide(block.x + direcao, block.y)) return true;
		}
		return false;
	}
	
	public boolean atualiza(double dt) {
		
		//se há uma colisão, a velocidade é é criado um novo pedaco. Senão então apenas atualize
		if(isColidingVertically()) {
			return false;
			//cria-se um novo pedaco em Tetris.java
		}else {
			for(Bloco block: bloco) {
				block.atualiza(dt);
			}
		}
		
		dropTimer.tique(dt * timeLoop);
		
		return true;
	}	
	
	public void desenhar(Tela tela) {
		for(Bloco block: bloco) {
			block.desenhar(tela);
		}
	}
	
	public void tecla(String tecla) {

		if(!isColidingHorizontally(tecla)) {
			//move os blocos lateralmente (os blocos estão armazenados em um vetor representado por k, 
			//porém a matriz binária de existência também deve ser verificada
			int k = 0;
			for(int i = 0; i < this.altura; i++) {
				for(int j = 0; j < this.comprimento; j++) {
					if(this.coordenadas(i, j) == true) {
						if(tecla.equals("d")) bloco.get(k).sideways(1);
						if(tecla.equals("a")) bloco.get(k).sideways(-1);

						k++;
					}
				}
			}
		}
	}
}
