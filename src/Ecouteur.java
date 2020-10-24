
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ecouteur implements ActionListener,ItemListener {

	Calculatrice c;
	Object ob;
	String n,erreur,nb,op,base;
	boolean nd;
	int x,y,res;
	double result;
	
	public Ecouteur(Calculatrice c) {
		this.c = c;
		n = "";
		nb = "";
		op = "";
		base = "dec";
		nd = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ob = e.getSource();
	
		// Saisie des nombres
		if(ob == c.b1)
			n+="1";
		if(ob == c.b2)
			n+="2";
		if(ob == c.b3)
			n+="3";
		if(ob == c.b4)
			n+="4";
		if(ob == c.b5)
			n+="5";
		if(ob == c.b6)
			n+="6";
		if(ob == c.b7)
			n+="7";
		if(ob == c.b8)
			n+="8";
		if(ob == c.b9)
			n+="9";
		if(ob == c.b0)
			n+="0";
		if(ob == c.ba)
			n+="A";
		if(ob == c.bb)
			n+="B";
		if(ob == c.bc)
			n+="C";
		if(ob == c.bd)
			n+="D";
		if(ob == c.be)
			n+="E";
		if(ob == c.bf)
			n+="F";
		if(n.equals("") || n.equals("E"))
			n="0";
		if(ob == c.b16) {
			if(n.indexOf(".")==-1)
				n+=".";
		}
		if(ob == c.b30)
			n = val(Math.PI);
		if(ob == c.b17) {
			if(n.indexOf("-")==-1)
				n = "-"+n;
			else
				n = new StringBuilder(n).deleteCharAt(0).toString();
		}
		if(ob == c.bnd){
			if(!nd)
				nd = true;
			else
				nd = false;
		}
		
		// Opérations simples
		if(ob == c.b21)
			if(!nd)
				n = val(val(n)/100);
		if(ob == c.b33){
			if(nd){
				n = val(Math.toDegrees(Math.acos(val(n))));
				nd = false;
			}else
				n = val(Math.cos(Math.toRadians(val(n))));
		}
		if(ob == c.b34){
			if(nd){
				n = val(Math.toDegrees(Math.asin(val(n))));
				nd = false;
			}else
				n = val(Math.sin(Math.toRadians(val(n))));
		}
		if(ob == c.b35){
			if(nd){
				n = val(Math.toDegrees(Math.atan(val(n))));
				nd = false;
			}else
				n = val(Math.tan(Math.toRadians(val(n))));
		}
		if(ob == c.b26){
			if(nd){
				n = val(Math.log10(val(n)));
				nd = false;
			}else
				n = val(Math.log(val(n)));
		}
		if(ob == c.b28)
			n = val(Math.pow(10,val(n)));
		if(ob == c.b23)
			n = val(Math.pow(val(n),2));
		if(ob == c.b27)
			n = val(Math.exp(val(n)));
		if(ob == c.b22)
			n = val(Math.sqrt(val(n)));
		if(ob == c.b25)
			n = val(1/val(n));
		if(ob == c.b29) {
			double r=1;
			for(int i=1; i<=(int)val(n); i++)
				r *= i;
			n = val(r);
		}
		
		// Opérations des calculs et des résultats
		if(ob == c.b10){
			nb = n;
			n = "0";
			op = "+";
		}
		if(ob == c.b11){
			nb = n;
			n = "0";
			op = "-";
		}
		if(ob == c.b12){
			nb = n;
			n = "0";
			op = "*";
		}
		if(ob == c.b13){
			nb = n;
			n = "0";
			op = "/";
		}
		if(ob == c.b24){
			nb = n;
			n = "0";
			op = "puiss";
		}
		if(ob == c.b32){
			nb = n;
			n = "0";
			op = "rn";
		}
		if(ob == c.b31){
			nb = n;
			n = "0";
			op = "mod";
		}
		if(ob == c.b14) {
			if(!nb.equals(""))
				n = val(calcul(val(nb),val(n)));
			nb = "";
			op = "";
			erreur = "";
			nd = false;
		}
		
		// Effacer les entrées
		if(ob == c.b18) {
			if(n.length()>1)
				n = new StringBuilder(n).deleteCharAt(n.length()-1).toString();
			else
				n="";
		}
		if(ob == c.b19) {
			n = "";
			erreur = "";
		}
		if(ob == c.b20) {
			n = "";
			nb = "";
			op = "";
			erreur = "";
			nd = false;
		}
		
		// Affichage d'écran
		if(n.equalsIgnoreCase("Infinity") || n.equalsIgnoreCase("-Infinity") || n.equalsIgnoreCase("NaN")) {
			n="0";
			erreur = "Erreur!";
		}
		
		// Conversion en binaire
		if(ob == c.bin) {
			c.b2.setEnabled(false);
			c.b3.setEnabled(false);
			c.b4.setEnabled(false);
			c.b5.setEnabled(false);
			c.b6.setEnabled(false);
			c.b7.setEnabled(false);
			c.b8.setEnabled(false);
			c.b9.setEnabled(false);
			c.b10.setEnabled(false);
			c.b11.setEnabled(false);
			c.b12.setEnabled(false);
			c.b13.setEnabled(false);
			c.b14.setEnabled(false);
			c.b16.setEnabled(false);
			c.b21.setEnabled(false);
			c.b22.setEnabled(false);
			c.b23.setEnabled(false);
			c.b24.setEnabled(false);
			c.b25.setEnabled(false);
			c.b26.setEnabled(false);
			c.b27.setEnabled(false);
			c.b28.setEnabled(false);
			c.b29.setEnabled(false);
			c.b30.setEnabled(false);
			c.b31.setEnabled(false);
			c.b32.setEnabled(false);
			c.b33.setEnabled(false);
			c.b34.setEnabled(false);
			c.b35.setEnabled(false);
			c.ba.setEnabled(false);
			c.bb.setEnabled(false);
			c.bc.setEnabled(false);
			c.bd.setEnabled(false);
			c.be.setEnabled(false);
			c.bf.setEnabled(false);
			if(base.equals("dec"))
				n = Integer.toBinaryString((int)val(n));
			else if(base.equals("oct"))
				n = Integer.toBinaryString(Integer.parseInt(n,8));
			else if(base.equals("hex"))
				n = Integer.toBinaryString(Integer.parseInt(n,16));
			base = "bin";
		}
		
		// Conversion en octat
		if(ob == c.oct) {
			c.b2.setEnabled(true);
			c.b3.setEnabled(true);
			c.b4.setEnabled(true);
			c.b5.setEnabled(true);
			c.b6.setEnabled(true);
			c.b7.setEnabled(true);
			c.b8.setEnabled(false);
			c.b9.setEnabled(false);
			c.b10.setEnabled(false);
			c.b11.setEnabled(false);
			c.b12.setEnabled(false);
			c.b13.setEnabled(false);
			c.b14.setEnabled(false);
			c.b16.setEnabled(false);
			c.b21.setEnabled(false);
			c.b22.setEnabled(false);
			c.b23.setEnabled(false);
			c.b24.setEnabled(false);
			c.b25.setEnabled(false);
			c.b26.setEnabled(false);
			c.b27.setEnabled(false);
			c.b28.setEnabled(false);
			c.b29.setEnabled(false);
			c.b30.setEnabled(false);
			c.b31.setEnabled(false);
			c.b32.setEnabled(false);
			c.b33.setEnabled(false);
			c.b34.setEnabled(false);
			c.b35.setEnabled(false);
			c.ba.setEnabled(false);
			c.bb.setEnabled(false);
			c.bc.setEnabled(false);
			c.bd.setEnabled(false);
			c.be.setEnabled(false);
			c.bf.setEnabled(false);
			if(base.equals("dec"))
				n = Integer.toOctalString((int)val(n));
			else if(base.equals("bin"))
				n = Integer.toOctalString(Integer.parseInt(n,2));
			else if(base.equals("hex"))
				n = Integer.toOctalString(Integer.parseInt(n,16));
			base = "oct";
		}
		if(ob == c.dec) {
			c.b2.setEnabled(true);
			c.b3.setEnabled(true);
			c.b4.setEnabled(true);
			c.b5.setEnabled(true);
			c.b6.setEnabled(true);
			c.b7.setEnabled(true);
			c.b8.setEnabled(true);
			c.b9.setEnabled(true);
			c.b10.setEnabled(true);
			c.b11.setEnabled(true);
			c.b12.setEnabled(true);
			c.b13.setEnabled(true);
			c.b14.setEnabled(true);
			c.b16.setEnabled(true);
			c.b21.setEnabled(false);
			c.b22.setEnabled(false);
			c.b23.setEnabled(false);
			c.b24.setEnabled(false);
			c.b25.setEnabled(false);
			c.b26.setEnabled(false);
			c.b27.setEnabled(false);
			c.b28.setEnabled(false);
			c.b29.setEnabled(false);
			c.b30.setEnabled(false);
			c.b31.setEnabled(false);
			c.b32.setEnabled(false);
			c.b33.setEnabled(false);
			c.b34.setEnabled(false);
			c.b35.setEnabled(false);
			c.ba.setEnabled(false);
			c.bb.setEnabled(false);
			c.bc.setEnabled(false);
			c.bd.setEnabled(false);
			c.be.setEnabled(false);
			c.bf.setEnabled(false);
			if(base.equals("bin"))
				n = val(Integer.parseInt(n,2));
			else if(base.equals("oct"))
				n = val(Integer.parseInt(n,8));
			else if(base.equals("hex"))
				n = val(Integer.parseInt(n,16));
			base = "dec";
		}
		if(ob == c.hex) {
			c.b2.setEnabled(true);
			c.b3.setEnabled(true);
			c.b4.setEnabled(true);
			c.b5.setEnabled(true);
			c.b6.setEnabled(true);
			c.b7.setEnabled(true);
			c.b8.setEnabled(true);
			c.b9.setEnabled(true);
			c.ba.setEnabled(true);
			c.bb.setEnabled(true);
			c.bc.setEnabled(true);
			c.bd.setEnabled(true);
			c.be.setEnabled(true);
			c.bf.setEnabled(true);
			c.b10.setEnabled(false);
			c.b11.setEnabled(false);
			c.b12.setEnabled(false);
			c.b13.setEnabled(false);
			c.b14.setEnabled(false);
			c.b16.setEnabled(false);
			c.b21.setEnabled(false);
			c.b22.setEnabled(false);
			c.b23.setEnabled(false);
			c.b24.setEnabled(false);
			c.b25.setEnabled(false);
			c.b26.setEnabled(false);
			c.b27.setEnabled(false);
			c.b28.setEnabled(false);
			c.b29.setEnabled(false);
			c.b30.setEnabled(false);
			c.b31.setEnabled(false);
			c.b32.setEnabled(false);
			c.b33.setEnabled(false);
			c.b34.setEnabled(false);
			c.b35.setEnabled(false);
			if(base.equals("dec"))
				n = Integer.toHexString((int)val(n));
			else if(base.equals("bin"))
				n = Integer.toHexString(Integer.parseInt(n,2));
			else if(base.equals("oct"))
				n = Integer.toHexString(Integer.parseInt(n,8));
			base = "hex";
		}

		if(nd) {
			c.b26.setText("log");
			c.b33.setText("acos");
			c.b34.setText("asin");
			c.b35.setText("atan");
		}else {
			c.b26.setText("ln");
			c.b33.setText("cos");
			c.b34.setText("sin");
			c.b35.setText("tan");
		}
		
		c.ecran.setText(format(n.toUpperCase()));
		
		if(nd)
			c.err.setText("2ndeF");
		else
			c.err.setText(erreur);
		c.nombre.setText(nb+" "+op);
	}
	
	public double val(String tex) {
		return Double.parseDouble(tex);
	}
	
	public String val(double tex) {
		return Double.toString(tex);
	}
	
	public double calcul(double a,double b) {
		if(base.equals("dec")) {
			if(op.equals("+"))
				return a+b;
			else if(op.equals("-"))
				return a-b;
			else if(op.equals("*"))
				return a*b;
			else if(op.equals("/"))
				return a/b;
			else if(op.equals("puiss"))
				return Math.pow(a,b);
			else if(op.equals("rn"))
				return Math.pow(a,1/b);
			else if(op.equals("mod"))
				return a%b;
			else
				return 0;
		}else if(base.equals("bin")) {
			String x = val(Integer.parseInt(val(a),2));
			String y = val(Integer.parseInt(val(b),2));
			if(op.equals("+")){
				return val(Integer.toBinaryString(Integer.parseInt(x,2)+Integer.parseInt(y,2)));
			}else if(op.equals("-")){
				return val(Integer.toBinaryString(Integer.parseInt(val(a),2)-Integer.parseInt(val(b),2)));
			}else if(op.equals("*")){
				return val(Integer.toBinaryString(Integer.parseInt(val(a),2)*Integer.parseInt(val(b),2)));
			}else if(op.equals("/")){
				return val(Integer.toBinaryString(Integer.parseInt(val(a),2)/Integer.parseInt(val(b),2)));
			}else return 0;
		}else if(base.equals("oct")) {
			double x = (double) Integer.parseInt(val(a),8);
			double y = (double) Integer.parseInt(val(b),8);
			if(op.equals("+"))
				return val(Integer.toOctalString((int)(x+y)));
			else if(op.equals("-"))
				return val(Integer.toOctalString((int)(x-y)));
			else if(op.equals("*"))
				return val(Integer.toOctalString((int)(x*y)));
			else if(op.equals("/"))
				return val(Integer.toOctalString((int)(x/y)));
			else return 0;
		}else if(base.equals("hex")) {
			a = (double) Integer.parseInt(val(a),16);
			b = (double) Integer.parseInt(val(b),16);
			if(op.equals("+"))
				return val(Integer.toHexString((int)(a+b)));
			else if(op.equals("-"))
				return val(Integer.toHexString((int)(a-b)));
			else if(op.equals("*"))
				return val(Integer.toHexString((int)(a*b)));
			else if(op.equals("/"))
				return val(Integer.toHexString((int)(a/b)));
			else return 0;
		}
		
		else return 0;
	}
	
	public String format(String ns) {
		
		return ns;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String item = (String)e.getItem();
		if(item.equalsIgnoreCase("Standard")) {
			c.b16.setEnabled(true);
			c.b21.setEnabled(false);
			c.b22.setEnabled(false);
			c.b23.setEnabled(false);
			c.b24.setEnabled(false);
			c.b25.setEnabled(false);
			c.b26.setEnabled(false);
			c.b27.setEnabled(false);
			c.b28.setEnabled(false);
			c.b29.setEnabled(false);
			c.b30.setEnabled(false);
			c.b31.setEnabled(false);
			c.b32.setEnabled(false);
			c.b33.setEnabled(false);
			c.b34.setEnabled(false);
			c.b35.setEnabled(false);
		}
		if(item.equalsIgnoreCase("Scientifique")) {
			c.b16.setEnabled(true);
			c.b21.setEnabled(true);
			c.b22.setEnabled(true);
			c.b23.setEnabled(true);
			c.b24.setEnabled(true);
			c.b25.setEnabled(true);
			c.b26.setEnabled(true);
			c.b27.setEnabled(true);
			c.b28.setEnabled(true);
			c.b29.setEnabled(true);
			c.b30.setEnabled(true);
			c.b31.setEnabled(true);
			c.b32.setEnabled(true);
			c.b33.setEnabled(true);
			c.b34.setEnabled(true);
			c.b35.setEnabled(true);
		}	
	}

}