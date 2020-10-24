import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Calculatrice extends JFrame {

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,b10,
			b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,
			b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,
			b31,b32,b33,b34,b35,ba,bb,bc,bd,be,bf,boff,bnd;
	JRadioButton dec,bin,oct,hex;
	ButtonGroup bg;
	JPanel content,numeric,operat,operat1,operat2,operat3,ecrant,interfaceN,op,base,phex;
	JTextField ecran;
	JLabel label,err,nombre;
	JComboBox<String> option;
	Ecouteur e;
	Image image;
	
	public Calculatrice() {
		image = getToolkit().getImage("ic.png");
		content = new JPanel();
		numeric = new JPanel();
		operat = new JPanel();
		operat1 = new JPanel();
		operat2 = new JPanel();
		operat3 = new JPanel();
		ecrant = new JPanel();
		interfaceN = new JPanel();
		base = new JPanel();
		op = new JPanel();
		phex = new JPanel();
		bg = new ButtonGroup();
		
		ecran = new JTextField(25);
		ecran.setEnabled(false);
		ecran.setFont(new Font("Arial",Font.BOLD,25));
		ecran.setDisabledTextColor(Color.BLACK);
		ecran.setHorizontalAlignment(JTextField.RIGHT);
		
		err = new JLabel("");
		err.setFont(new Font("Arial",Font.ITALIC,15));
		nombre = new JLabel("");
		nombre.setFont(new Font("Arial",Font.ITALIC,15));
		nombre.setHorizontalAlignment(JLabel.RIGHT);
		
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		b10 = new JButton("+");
		b11 = new JButton("-");
		b12 = new JButton("x");
		b13 = new JButton("÷");
		b14 = new JButton("=");
		b15 = new JButton("C");
		b16 = new JButton(",");
		b17 = new JButton("±");
		b18 = new JButton("←");
		b19 = new JButton("CE");
		b20 = new JButton("C");
		b21 = new JButton("%");
		b22 = new JButton("Sqr");
		b23 = new JButton("x²");
		b24 = new JButton("x^y");
		b25 = new JButton("1/x");
		b26 = new JButton("ln");
		b27 = new JButton("e^x");
		b28 = new JButton("10^x");
		b29 = new JButton("n!");
		b30 = new JButton("π");
		b31 = new JButton("Mod");
		b32 = new JButton("yRx");
		b33 = new JButton("cos");
		b34 = new JButton("sin");
		b35 = new JButton("tan");
		ba = new JButton("A");
		bb = new JButton("B");
		bc = new JButton("C");
		bd = new JButton("D");
		be = new JButton("E");
		bf = new JButton("F");
		boff = new JButton("OFF");
		bnd = new JButton("2ndF");

		dec = new JRadioButton("Dec");
		dec.setSelected(true);
		bin = new JRadioButton("Bin");
		oct = new JRadioButton("Oct");
		hex = new JRadioButton("Hex");
		
		bg.add(dec);
		bg.add(bin);
		bg.add(oct);
		bg.add(hex);
		base.setLayout(new GridLayout(1,5));
		base.add(dec);
		base.add(bin);
		base.add(oct);
		base.add(hex);
		base.add(bnd);
		
		b21.setBackground(Color.WHITE);
		b22.setBackground(Color.WHITE);
		b23.setBackground(Color.WHITE);
		b24.setBackground(Color.WHITE);
		b25.setBackground(Color.WHITE);
		b26.setBackground(Color.WHITE);
		b27.setBackground(Color.WHITE);
		b28.setBackground(Color.WHITE);
		b29.setBackground(Color.WHITE);
		b30.setBackground(Color.WHITE);
		b31.setBackground(Color.WHITE);
		b32.setBackground(Color.WHITE);
		b33.setBackground(Color.WHITE);
		b34.setBackground(Color.WHITE);
		b35.setBackground(Color.WHITE);
		
		b0.setBorderPainted(false);
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b4.setBorderPainted(false);
		b5.setBorderPainted(false);
		b6.setBorderPainted(false);
		b7.setBorderPainted(false);
		b8.setBorderPainted(false);
		b9.setBorderPainted(false);
		b10.setBorderPainted(false);
		b11.setBorderPainted(false);
		b12.setBorderPainted(false);
		b13.setBorderPainted(false);
		b14.setBorderPainted(false);
		b15.setBorderPainted(false);
		b16.setBorderPainted(false);
		b17.setBorderPainted(false);
		b18.setBorderPainted(false);
		b19.setBorderPainted(false);
		b20.setBorderPainted(false);
		b21.setBorderPainted(false);
		b22.setBorderPainted(false);
		b23.setBorderPainted(false);
		b24.setBorderPainted(false);
		b25.setBorderPainted(false);
		b26.setBorderPainted(false);
		b27.setBorderPainted(false);
		b28.setBorderPainted(false);
		b29.setBorderPainted(false);
		b30.setBorderPainted(false);
		b31.setBorderPainted(false);
		b32.setBorderPainted(false);
		b33.setBorderPainted(false);
		b34.setBorderPainted(false);
		b35.setBorderPainted(false);
		ba.setBorderPainted(false);
		bb.setBorderPainted(false);
		bc.setBorderPainted(false);
		bd.setBorderPainted(false);
		be.setBorderPainted(false);
		bf.setBorderPainted(false);
		boff.setBorderPainted(false);
		
		b21.setEnabled(false);
		b22.setEnabled(false);
		b23.setEnabled(false);
		b24.setEnabled(false);
		b25.setEnabled(false);
		b26.setEnabled(false);
		b27.setEnabled(false);
		b28.setEnabled(false);
		b29.setEnabled(false);
		b30.setEnabled(false);
		b31.setEnabled(false);
		b32.setEnabled(false);
		b33.setEnabled(false);
		b34.setEnabled(false);
		b35.setEnabled(false);
		ba.setEnabled(false);
		bb.setEnabled(false);
		bc.setEnabled(false);
		bd.setEnabled(false);
		be.setEnabled(false);
		bf.setEnabled(false);
		
		numeric.setLayout(new GridLayout(5,4,1,1));
		numeric.add(b20);
		numeric.add(b19);
		numeric.add(b18);
		numeric.add(b13);
		
		numeric.add(b7);
		numeric.add(b8);
		numeric.add(b9);
		numeric.add(b12);
		
		numeric.add(b4);
		numeric.add(b5);
		numeric.add(b6);
		numeric.add(b11);
		
		numeric.add(b1);
		numeric.add(b2);
		numeric.add(b3);
		numeric.add(b10);
		
		numeric.add(b17);
		numeric.add(b0);
		numeric.add(b16);
		numeric.add(b14);
		
		label = new JLabel("Calculatrice ");
		String[] tab = {"Standard","Scientifique"};
		option = new JComboBox<String>(tab);
		
		op.setLayout(new GridLayout(2,2));
		op.add(label);
		op.add(option);
		op.add(err);
		op.add(nombre);
		
		ecrant.setLayout(new GridLayout(3,1));
		ecrant.add(op);
		ecrant.add(ecran);
		ecrant.add(base);
		
		phex.setLayout(new GridLayout(1,6));
		phex.add(ba);
		phex.add(bb);
		phex.add(bc);
		phex.add(bd);
		phex.add(be);
		phex.add(bf);

		operat1.setLayout(new GridLayout(1,5));
		operat1.add(b27);
		operat1.add(b26);
		operat1.add(b33);
		operat1.add(b34);
		operat1.add(b35);
		
		operat2.setLayout(new GridLayout(1,5));
		operat2.add(b28);
		operat2.add(b29);
		operat2.add(b30);
		operat2.add(b31);
		operat2.add(b32);

		operat3.setLayout(new GridLayout(1,5));
		operat3.add(b21);
		operat3.add(b22);
		operat3.add(b23);
		operat3.add(b24);
		operat3.add(b25);
		
		operat.setLayout(new GridLayout(4,1));
		operat.add(operat1);
		operat.add(operat2);
		operat.add(operat3);
		operat.add(phex);
		
		
		e = new Ecouteur(this);
		b1.addActionListener(e);
		b2.addActionListener(e);
		b3.addActionListener(e);
		b4.addActionListener(e);
		b5.addActionListener(e);
		b6.addActionListener(e);
		b7.addActionListener(e);
		b8.addActionListener(e);
		b9.addActionListener(e);
		b0.addActionListener(e);
		b10.addActionListener(e);
		b11.addActionListener(e);
		b12.addActionListener(e);
		b13.addActionListener(e);
		b14.addActionListener(e);
		b15.addActionListener(e);
		b16.addActionListener(e);
		b17.addActionListener(e);
		b18.addActionListener(e);
		b19.addActionListener(e);
		b20.addActionListener(e);
		b21.addActionListener(e);
		b22.addActionListener(e);
		b23.addActionListener(e);
		b24.addActionListener(e);
		b25.addActionListener(e);
		b26.addActionListener(e);
		b27.addActionListener(e);
		b28.addActionListener(e);
		b29.addActionListener(e);
		b30.addActionListener(e);
		b31.addActionListener(e);
		b32.addActionListener(e);
		b33.addActionListener(e);
		b34.addActionListener(e);
		b35.addActionListener(e);
		ba.addActionListener(e);
		bb.addActionListener(e);
		bc.addActionListener(e);
		bd.addActionListener(e);
		be.addActionListener(e);
		bf.addActionListener(e);
		option.addItemListener(e);
		dec.addActionListener(e);
		bin.addActionListener(e);
		oct.addActionListener(e);
		hex.addActionListener(e);
		bnd.addActionListener(e);
		
		content.setBackground(Color.cyan);
		content.setLayout(new GridLayout(3,1));
		content.add(ecrant);
		content.add(operat);
		content.add(numeric);
		
		this.setContentPane(content);
		this.setTitle("Calculatrice made by CHIF");
		this.setIconImage(image);
		this.setSize(375,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculatrice();
	}
}