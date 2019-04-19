
public class Grade {
	int comprimento, altura;
	boolean a0, a1, a2, a3, a4, a5;
	boolean b0, b1, b2, b3, b4, b5;
	boolean c0, c1, c2, c3, c4, c5;
	
	public Grade(int index) {
		
		switch(index) {
			//BCC 2 créditos
			case 0:
				bcc();
				break;
			
			//EDVT 3 créditos
			case 1:
				edvt();
				break;
			
			//BM 4 créditos e sua alma
			case 2:
				bm();
				break;
			
			//BCE 2 créditos
			case 3:
				bce();
				break;
			
			//EM 3 créditos
			case 4:
				em();
				break;
			
			//BECN 3 cŕeditos
			case 5:
				becn();
				break;
			
		}
		
	}
	
	public void bcc() {
		this.comprimento = 2;
		this.altura = 1;
		this.a0 = true; this.a1 = true; this.a2 = false; this.a3 = false; this.a4 = false; this.a5 = false;
		this.b0 = false; this.b1 = false; this.b2 = false; this.b3 = false; this.b4 = false; this.b5 = false;
		this.c0 = false; this.c1 = false; this.c2 = false; this.c3 = false; this.c4 = false; this.c5 = false;
	}
	
	public void edvt() {
		this.comprimento = 3;
		this.altura = 1;
		this.a0 = true; this.a1 = true; this.a2 = true; this.a3 = false; this.a4 = false; this.a5 = false;
		this.b0 = false; this.b1 = false; this.b2 = false; this.b3 = false; this.b4 = false; this.b5 = false;
		this.c0 = false; this.c1 = false; this.c2 = false; this.c3 = false; this.c4 = false; this.c5 = false;
	}
	
	public void bm() {
		this.comprimento = 2;
		this.altura = 3;
		this.a0 = true; this.a1 = true; this.a2 = false; this.a3 = false; this.a4 = false; this.a5 = false;
		this.b0 = false; this.b1 = true; this.b2 = false; this.b3 = false; this.b4 = false; this.b5 = false;
		this.c0 = false; this.c1 = true; this.c2 = false; this.c3 = false; this.c4 = false; this.c5 = false;
	}
	
	public void bce() {
		this.comprimento = 1;
		this.altura = 2;
		this.a0 = true; this.a1 = false; this.a2 = false; this.a3 = false; this.a4 = false; this.a5 = false;
		this.b0 = true; this.b1 = false; this.b2 = false; this.b3 = false; this.b4 = false; this.b5 = false;
		this.c0 = false; this.c1 = false; this.c2 = false; this.c3 = false; this.c4 = false; this.c5 = false;
	}
	
	public void em() {
		this.comprimento = 2;
		this.altura = 2;
		this.a0 = true; this.a1 = true; this.a2 = false; this.a3 = false; this.a4 = false; this.a5 = false;
		this.b0 = true; this.b1 = false; this.b2 = false; this.b3 = false; this.b4 = false; this.b5 = false;
		this.c0 = false; this.c1 = false; this.c2 = false; this.c3 = false; this.c4 = false; this.c5 = false;
	}
	
	public void becn() {
		this.comprimento = 2;
		this.altura = 3;
		this.a0 = true; this.a1 = true; this.a2 = false; this.a3 = false; this.a4 = false; this.a5 = false;
		this.b0 = true; this.b1 = false; this.b2 = false; this.b3 = false; this.b4 = false; this.b5 = false;
		this.c0 = true; this.c1 = false; this.c2 = false; this.c3 = false; this.c4 = false; this.c5 = false;
	}
	
}
