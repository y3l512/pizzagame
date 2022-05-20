package pizza10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


class MyFrame extends JFrame implements ActionListener {

	private int sum, temp1, temp2, temp3;
	private JButton order_button, cancle_button;
	private JPanel down_panel;
	private JPanel button_panel;
	private JPanel panel2;
	PizzaResult pizzaresult;

	private JTextField text;

	Header Header = new Header();
	TypePanel TypePanel = new TypePanel();
	PizzaMake PizzaMake = new PizzaMake();
	SizePanel SizePanel = new SizePanel();
	JTextField resulttext = new JTextField("���� �ϼ� ��ư�� ������ ����/���и� Ȯ���� �� �ֽ��ϴ�");
	

	public MyFrame() {

		this.setSize(600, 700);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("���� �����");

		this.order_button = new JButton("���� �ϼ�");
		this.order_button.addActionListener(this);
		this.cancle_button = new JButton("�ٽ��ϱ�");
		this.cancle_button.addActionListener(this);
		resulttext.setSize(1000,70);
		resulttext.setHorizontalAlignment(JTextField.CENTER);

		this.text = new JTextField();

		text.setEditable(false);
		text.setColumns(6);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());

		down_panel = new JPanel();
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(0,2));
		down_panel.setLayout(new BorderLayout());
		button_panel.add(this.order_button);
		button_panel.add(this.cancle_button);
		down_panel.add(button_panel,BorderLayout.CENTER);
		down_panel.add(this.text,BorderLayout.EAST);
		down_panel.add(resulttext,BorderLayout.SOUTH);		
		
		
		this.setLayout(new BorderLayout());
		
		this.add(panel2, BorderLayout.SOUTH);
		panel2.add(down_panel, BorderLayout.SOUTH);
		this.add(Header, BorderLayout.NORTH);
		this.add(PizzaMake, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.order_button) {

			String typeresult = TypePanel.TypeResult;
			String typelabel = OrderPanel.TypeLabel.getText();
			int typeprice = TypePanel.TypePrice;
			
			String maintoppingresult = MainToppingPanel.MainToppingResult;
			String maintoppinglabel = OrderPanel.MainToppingLabel.getText();
			int maintoppingprice = MainToppingPanel.MainToppingPrice;
			
			String extoppingresult = ExToppingPanel.ExToppingResult;
			String extoppinglabel = OrderPanel.ExToppingLabel.getText();
			int extoppingprice = ExToppingPanel.ExToppingPrice;
			
			String sizeresult = SizePanel.SizeResult;
			String sizelabel = OrderPanel.SizeLabel.getText();
			int sizeprice = SizePanel.SizePrice;
			
			text.setText(""+((typeprice+maintoppingprice+extoppingprice)*sizeprice)+"��");
			
			if(typeresult==typelabel&&maintoppingresult==maintoppinglabel&&extoppingresult==extoppinglabel&&sizelabel==sizeresult) {
				resulttext.setText("�����Դϴ�");
			}
			else{
				resulttext.setText("�����Դϴ�");
			}
			
			

		}

		if (e.getSource() == this.cancle_button) {

			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;

			this.text.setText(" " + sum);
			resulttext.setText("���� �ϼ� ��ư�� ������ ����/���и� Ȯ���� �� �ֽ��ϴ�");

		}

	}

	class Header extends JPanel {

		WelcomePanel welcom_panel = new WelcomePanel();
		OrderPanel order_panel = new OrderPanel();

		public Header() {

			setLayout(new BorderLayout());

			this.add(welcom_panel, BorderLayout.NORTH);
			this.add(order_panel, BorderLayout.CENTER);

		}

	}

	class WelcomePanel extends JPanel {

		private JLabel message;

		public WelcomePanel() {

			message = new JLabel("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�.");
			add(message);

		}

	}
	
	class OrderPanel extends JPanel {

		private String[] Type;
		private String[] MainTopping;
		private String[] ExTopping;
		private String[] Size;
		public static JLabel TypeLabel;
		public static JLabel MainToppingLabel;
		public static JLabel ExToppingLabel;
		public static JLabel SizeLabel;
		

		public OrderPanel() {

			String[] Type = { "��������(+5000)", "�(+6000)", "��(+7000)" };
			String[] MainTopping = { "�Ұ��(+5000)", "��������(+3000)", "����δ�(+4000)", "����(+5000)" };
			String[] ExTopping = { "�Ǹ�(+2000)", "ġ��(+3000)", "�ø���(+2000)", "������(+4000)" };
			String[] Size = { "����(X1)", "�̵��(X2)", "����(X3)" };

			setLayout(new GridLayout(4, 0));

			int rnd1 = (int) (Math.random() * 3);
			int rnd2 = (int) (Math.random() * 4);
			int rnd3 = (int) (Math.random() * 4);
			int rnd4 = (int) (Math.random() * 3);
			
			TypeLabel = new JLabel(Type[rnd1]);
			MainToppingLabel = new JLabel(MainTopping[rnd2]);
			ExToppingLabel = new JLabel(ExTopping[rnd3]);
			SizeLabel = new JLabel(Size[rnd4]);

			add(TypeLabel);
			add(MainToppingLabel);
			add(ExToppingLabel);
			add(SizeLabel);

			setBorder(BorderFactory.createTitledBorder("�ֹ���"));
			
		}
	

	}
	
	class Option extends JPanel{
		MainToppingPanel MainToppingPanel = new MainToppingPanel();
		ExToppingPanel ExToppingPanel = new ExToppingPanel();
		TypePanel TypePanel = new TypePanel();
		SizePanel SizePanel = new SizePanel();
		
		public Option() {
			setLayout(new GridLayout(0, 4));
			
			this.add(TypePanel);
			this.add(MainToppingPanel);
			this.add(ExToppingPanel);
			this.add(SizePanel);
		}
		
	}
	
	
	
	

	class PizzaMake extends JPanel{
		Option option = new Option();
		PizzaResult pizzaresult = new PizzaResult();
		
	
		public PizzaMake() {
			setLayout(new BorderLayout());
			add(option, BorderLayout.NORTH);
			add(pizzaresult, BorderLayout.CENTER);
			
		}
	}

	class PizzaResult extends JPanel{
		//����
		ImageIcon original = new ImageIcon("��������.png");
		ImageIcon grain = new ImageIcon("�.png");
		ImageIcon thin = new ImageIcon("��.png");
		//��������
		ImageIcon bulgogi = new ImageIcon("�Ұ��.png");
		ImageIcon potato = new ImageIcon("��������.png");
		ImageIcon peperoni = new ImageIcon("����δ�.png");
		ImageIcon shrimp = new ImageIcon("����.png");
		//�߰� ����
		ImageIcon pepper = new ImageIcon("�Ǹ�.png");
		ImageIcon cheese = new ImageIcon("ġ��.png");
		ImageIcon olive = new ImageIcon("�ø���.png");
		ImageIcon bacon = new ImageIcon("������.png");
		ImageIcon default1 = new ImageIcon("default.png");
		
		JLabel dough;
		JLabel main;
		JLabel ex;
		
		String typeresult = TypePanel.TypeResult;
		String maintoppingresult = MainToppingPanel.MainToppingResult;
		String extoppingresult = ExToppingPanel.ExToppingResult;
		
		
		public PizzaResult() {

			setLayout(null);
			
			dough = new JLabel(original);
			main = new JLabel(bulgogi);
			ex = new JLabel(olive);
			
			ex.setBounds(250,70, 100, 100);
			add(ex);
			main.setBounds(250, 70, 100, 100);
			add(main);	
			dough.setBounds(250,70, 100, 100);
			add(dough);
			
		
		setSize(500,500);
		setBackground(Color.white);
		}
	}

	class TypePanel extends JPanel {

		JRadioButton[] Type = new JRadioButton[3];
		String[] TypeName = {"��������(+5000)", "�(+6000)", "��(+7000)"};
		public static String TypeResult;
		public static int TypePrice;
		
		public ImageIcon[] i = {
				new ImageIcon("��������.png"),
				new ImageIcon("�.png"),
				new ImageIcon("��.png")
		};
		
		
		private ButtonGroup bg;
		JLabel pizzaimg = new JLabel();
		
		
		
		public TypePanel() {
			
			setLayout(new BorderLayout());
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new GridLayout(3, 1));
			
			add(pizzaimg);
			bg = new ButtonGroup();
			
			
			for(int i =0; i<Type.length; i++) {
				Type[i] = new JRadioButton(TypeName[i]);
				bg.add(Type[i]);
				Type[i].addItemListener(new MyItemListener());
				panel1.add(Type[i]);
			}
			
			add(panel1, BorderLayout.CENTER);
			add(pizzaimg, BorderLayout.NORTH);
			
	        this.setVisible(true);	
	        
			setBorder(BorderFactory.createTitledBorder("���� ����"));
			
		}
		
		class MyItemListener implements ItemListener{
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange()==ItemEvent.DESELECTED){
	                return;
	            }
	            if(Type[0].isSelected()){
	                pizzaimg.setIcon(i[0]);
	                TypeResult = TypeName[0];
	                TypePrice = 5000;
	            }
	            else if(Type[1].isSelected()){
	            	pizzaimg.setIcon(i[1]);
	            	TypeResult = TypeName[1];
	            	TypePrice = 6000;
	            }
	            else{
	            	pizzaimg.setIcon(i[2]);
	            	TypeResult = TypeName[2];
	            	TypePrice = 7000;
	            }
	        }
	        
	    }
	}

	

	class MainToppingPanel extends JPanel {

		private JRadioButton[] MainTopping = new JRadioButton[4];
		String[] MainToppingName = {"�Ұ��(+5000)","��������(+3000)","����δ�(+4000)", "����(+5000)"};
		ImageIcon[] i = {
				
				new ImageIcon("�Ұ��.png"),
				new ImageIcon("��������.png"),
				new ImageIcon("����δ�.png"),
				new ImageIcon("����.png")
				
		};
		
		JLabel MTla = new JLabel();
		
		public static String MainToppingResult;
		public static int MainToppingPrice;

		private ButtonGroup bg;
		
		

		public MainToppingPanel() {
			
			setLayout(new BorderLayout());
			
			JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(4, 1));

			bg=new ButtonGroup();
			
			for(int i = 0; i<MainTopping.length; i++) {
				MainTopping[i]=new JRadioButton(MainToppingName[i]);
				bg.add(MainTopping[i]);
				MainTopping[i].addItemListener(new MyItemListener1());
				jp.add(MainTopping[i]);
			}
			
			this.add(jp,BorderLayout.SOUTH);
			this.add(MTla,BorderLayout.CENTER);
			
			this.setVisible(true);

			setBorder(BorderFactory.createTitledBorder("���� ����"));
	
		}
		
		class MyItemListener1 implements ItemListener{
			@Override
			public void  itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.DESELECTED){
	                return;
	            }
				if(MainTopping[0].isSelected()) {
					MTla.setIcon(i[0]);
					MainToppingResult = MainToppingName[0];
					MainToppingPrice = 5000;
				}
				else if(MainTopping[1].isSelected()) {
					MTla.setIcon(i[1]);
					MainToppingResult = MainToppingName[1];
					MainToppingPrice = 3000;
				}
				else if(MainTopping[2].isSelected()) {
					MTla.setIcon(i[2]);
					MainToppingResult = MainToppingName[2];
					MainToppingPrice = 4000;
				}
				else if(MainTopping[3].isSelected()) {
					MTla.setIcon(i[3]);
					MainToppingResult = MainToppingName[3];
					MainToppingPrice = 5000;
				}
			}
			
		}

	}
	


	class ExToppingPanel extends JPanel {

		private JRadioButton[] ExTopping = new JRadioButton[4];
		String[] ExToppingName = {"�Ǹ�(+2000)", "ġ��(+3000)", "�ø���(+2000)", "������(+4000)"};
		ImageIcon[] i = {
				
				new ImageIcon("�Ǹ�.png"),
				new ImageIcon("ġ��.png"),
				new ImageIcon("�ø���.png"),
				new ImageIcon("������.png")
				
		};
		
		JLabel Exla = new JLabel();
		
		public static String ExToppingResult;
		public static int ExToppingPrice;

		private ButtonGroup bg;

		public ExToppingPanel() {
			
			setLayout(new BorderLayout());
			
			JPanel jp = new JPanel();
			jp.setLayout(new GridLayout(4, 1));

			bg=new ButtonGroup();
			
			for(int i = 0; i<ExTopping.length; i++) {
				ExTopping[i]=new JRadioButton(ExToppingName[i]);
				bg.add(ExTopping[i]);
				ExTopping[i].addItemListener(new MyItemListener1());
				jp.add(ExTopping[i]);
			}
			
			this.add(jp,BorderLayout.SOUTH);
			this.add(Exla,BorderLayout.CENTER);
			
			this.setVisible(true);

			setBorder(BorderFactory.createTitledBorder("���� ����"));
	
		}
		
		class MyItemListener1 implements ItemListener{
			@Override
			public void  itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.DESELECTED){
	                return;
	            }
				if(ExTopping[0].isSelected()) {
					Exla.setIcon(i[0]);
					ExToppingResult = ExToppingName[0];
					ExToppingPrice = 2000;
				}
				else if(ExTopping[1].isSelected()) {
					Exla.setIcon(i[1]);
					ExToppingResult = ExToppingName[1];
					ExToppingPrice = 3000;
				}
				else if(ExTopping[2].isSelected()) {
					Exla.setIcon(i[2]);
					ExToppingResult = ExToppingName[2];
					ExToppingPrice = 2000;
				}
				else if(ExTopping[3].isSelected()) {
					Exla.setIcon(i[3]);
					ExToppingResult = ExToppingName[3];
					ExToppingPrice = 4000;
				}
			}
			
		}
	}

	class SizePanel extends JPanel {

		private JRadioButton[] Size = new JRadioButton[3];
		String[] SizeName = {"����(X1)", "�̵��(X2)", "����(X3)" };
		public static String SizeResult;
		public static int SizePrice;
		private ButtonGroup bg;

		public SizePanel() {

			setLayout(new GridLayout(3, 1));
			bg=new ButtonGroup();

			for(int i = 0; i<Size.length; i++) {
				Size[i]=new JRadioButton(SizeName[i]);
				bg.add(Size[i]);
				Size[i].addItemListener(new MyItemListener1());
				add(Size[i]);
			}
			setVisible(true);
			setBorder(BorderFactory.createTitledBorder("ũ��"));
		}
		class MyItemListener1 implements ItemListener{
			@Override
			public void  itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.DESELECTED){
	                return;
	            }
				if(Size[0].isSelected()) {
					
					SizeResult = SizeName[0];
					SizePrice = 1;
				}
				else if(Size[1].isSelected()) {
					
					SizeResult = SizeName[1];
					SizePrice = 2;
				}
				else if(Size[2].isSelected()) {
					
					SizeResult =SizeName[2];
					SizePrice = 3;
				}
		
			}
			
		}
	}
}

public class PizzaTest {

	public static void main(String[] args) {

		MyFrame mf = new MyFrame();

	}

}