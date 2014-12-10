import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;


class TestLibraryDemo extends JFrame implements ActionListener, ListSelectionListener
{
	LibraryCollection movie;

	//------------------------------------------------------------------------------
	// ����� UI�� ���� �ʿ��� ������ ���� 
	//------------------------------------------------------------------------------
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JPanel jp4;
	
	
	private JTextField title;
	private JTextField image;
	private JTextField publisher;
	private JTextField authors;
	private JTextField isbn;
	private JTextField availability;
	private JTextField renting;
	
	private JButton Jadd;
	private JButton Jmod;
	private JButton Jdel;
	
	private JList list;
	private JLabel icon;
	private JTextArea info;
	public int a;
	
	JMenuItem jmi1;
	JMenuItem jmi2;
	
	


	//------------------------------------------------------------------------------
	//������ - GUI�� �����Ѵ�.
	//------------------------------------------------------------------------------
	public TestLibraryDemo() 
	{
		JMenuBar jmb=new JMenuBar();
		JMenu menu=new JMenu("����");
		jmi1=new JMenuItem("�ҷ�����");
		menu.add(jmi1);
		jmi2=new JMenuItem("�����ϱ�");
		menu.add(jmi2);
		jmb.add(menu);
		
		setJMenuBar(jmb);
		jmi1.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK));//Ctrl+0
		jmi2.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK));//Ctrl+S
		
		movie=new LibraryCollection();	

		//------------------------------------------------------------------------------
		// ����� ȭ�鿡 ������Ʈ�� �����Ͽ� ��ġ
		// �� ������Ʈ ������ �ʿ��� ������ �߰�
		//------------------------------------------------------------------------------
		
		panel1 = new JPanel();
		panel1.add( new JLabel("���� ���� ���α׷�"));
		panel2=new JPanel(new GridLayout(1,2));
		panel3=new JPanel(new GridLayout(1,2));
		panel4=new JPanel(new GridLayout(1,2));
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel(new GridLayout(1,2));
		jp1.setBorder(new TitledBorder("�߰�/����"));
		a=0;
		//if(a!=0)
		jp3.setBorder(new TitledBorder("���� ���"));
		jp4.setBorder(new TitledBorder("���� ����"));
		
		
		title=new JTextField(10);
		publisher=new JTextField(10);
		authors=new JTextField(10);
		isbn=new JTextField(10);
		availability=new JTextField(10);
		renting=new JTextField(10);
		

		jp1.add(new Label("���� ����     "));
		jp1.add(title);
		jp1.add(new Label("���ǻ�        "));
		jp1.add(publisher);
		jp1.add(new Label("��  ��          "));
		jp1.add(authors);
		jp1.add(new Label("���� ��ȣ    "));
		jp1.add(isbn);
		jp1.add(new Label("���Ⱑ�ɿ���         "));
		jp1.add(availability);
		jp1.add(new Label("������     "));
		jp1.add(renting);
		
	
		Jadd=new JButton("�߰�");
		Jmod=new JButton("����");
		Jdel=new JButton("����");
		
		
		jp2.add(Jadd);
		jp2.add(Jmod);
		jp2.add(Jdel);
		 
	
		list=new JList();
		info=new JTextArea();
		
		
		
		jp3.add(list);
		
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(info,v,h);
		jp4.add(icon,BorderLayout.CENTER);
		jp4.add(jsp);
		
		panel3.add(jp2,BorderLayout.CENTER);
		panel3.add(jp3);
		panel2.add(jp1);
		panel2.add(panel3);
		panel4.add(panel2);
		panel4.add(jp4);
		
		
		//------------------------------------------------------------------------------
		//	Frame �Ӽ�
		//------------------------------------------------------------------------------
		

		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());		
		c.add(panel1,BorderLayout.NORTH);
		c.add(panel4,BorderLayout.CENTER);
		
			
		Jadd.addActionListener(this);
		Jmod.addActionListener(this);
		Jdel.addActionListener(this);
		list.addListSelectionListener(this);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		
		
		setTitle("Test Library");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	
	}
	
	
	
	

	//------------------------------------------------------------------------------
	// ������ �������̽��� ���� �� �޼ҵ� ����
	//� �̺�Ʈ�� �߻��ߴ����� ���� ������ ����� �����Ѵ�.
	//------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent event){

	if(event.getSource()==Jadd)//��ü�̸�))//if(event.getActionCommand().equals("�߰�"//���̸�))
	{
		Library newLibrary=new Library(title.getText(),publisher.getText(),authors.getText(),isbn.getText(),availability.getText(),renting.getText());
		library.addMovie(newLibrary);
			Vector Title=new Vector();
			for(int i=0;i<library.getLibraryCount();i++)
			{
				Title.addElement(library.getMovieAt(i).getTitle());
				
			}
			list.setListData(Title);
			info.setText("");
			info.setText(library.toString());
			title.setText("");
			publisher.setText("");
			authors.setText("");
			isbn.setText("");
			availability.setText("");
			renting.setText("");
		
			
			
	}
			
	else if(event.getSource()==Jmod)
	{
		jp3.setBorder(new TitledBorder("���� ��� ����"));
		//Jmod.hide();
		Library newLibrary2=library.getLibraryAt(list.getSelectedIndex());
		if(newLibrary2!=null)
			jp3.setBorder(new TitledBorder("����"));
		newLibrary2.setTitle(title.getText());
		newLibrary2.setPublisher(publisher.getText());
		newLibrary2.setAuthors(authors.getText());
		newLibrary2.setIsbn(isbn.getText());
		newLibrary2.setAvailability(availability.getText());
		newLibrary2.setRenting(renting.getText());
	
		info.setText("");
		info.setText(library.toString());
		
		title.setText("");
		publisher.setText("");
		authors.setText("");
		isbn.setText("");
		availability.setText("");
		renting.setText("");
		
		Vector Title=new Vector();
		
		for(int i=0;i<movie.getLibraryCount();i++)
		{
			Title.addElement(movie.getLibraryAt(i).getTitle());
		}
		
		list.setListData(Title);
		
		
		
		
		
	}
			
	else if(event.getSource()==Jdel)
	{
		
		movie.delLibrary(list.getSelectedIndex());
		info.setText("");
		info.setText(library.toString());
		title.setText("");
		publisher.setText("");
		authors.setText("");
		isbn.setText("");
		availability.setText("");
		renting.setText("");
		
		Vector Title=new Vector();
		for(int i=0;i<movie.getLibraryCount();i++)
		{
			Title.addElement(movie.getLibraryAt(i).getTitle());
			
		}
		list.setListData(Title);
		
		
	}
	
	
	else if((event.getActionCommand()).equals("�ҷ�����"))
	{
		try{
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movieinfo.txt"));
			int count=ois.readInt();
			movie=(LibraryCollection)ois.readObject();
			info.setText("");
			info.append(library.toString());
			
			Vector Title=new Vector();
			for(int i=0;i<count;i++)
			{
				Title.addElement(movie.getLibraryAt(i).getTitle());
				
			}
			list.setListData(Title);
			ois.close();
			
		}catch (IOException e) 
		{
			info.setText("1����");
		}catch (ClassNotFoundException e)
		{
			info.setText("2����");
		}
		
		

	}
	else if((event.getActionCommand()).equals("�����ϱ�"))
	{
		try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movieinfo.txt"));
				oos.writeInt(movie.getLibraryCount());
				oos.writeObject((Object)library);oos.close();
				info.setText("����ƽ��ϴ�!");
				oos.close();
				
		} catch (IOException e){
			info.setText("���忡��");
		}
		
		
	}
	
	}

	//------------------------------------------------------------------------------
	//���õ� �ε����� �ش�Ǵ� ��ȭ ������ textArea ���� ����Ѵ�.
	//------------------------------------------------------------------------------
	public void valueChanged(ListSelectionEvent event){

		Library newLibrary2=movie.getLibraryAt(list.getSelectedIndex());
		title.setText(newLibrary2.getTitle());
		publisher.setText(newLibrary2.getImage());
		authors.setText(newLibrary2.getGenre());
		isbn.setText(newLibrary2.getRunningtime());
		availability.setText(newLibrary2.getNation());
		renting.setText(newLibrary2.getFilmratings());
		
		info.setText("");
		info.append(newLibrary2.toString());
		
		
	}

	
}	

public class TestLibrary //extends Frame
{
	public static void main(String[] args)throws Exception 
	{
		//new TestLibrary();
		new TestLibraryDemo();
	}
}/**
public TestMovie(){
	super("����");
	this.init();
	this.start();
	this.setSize(300,200);
	this.setLocation(400,200);
	this.setVisible(true);
}
public void init(){
	System.out.println("�޷�");
}
public void start(){
	System.out.println("����");
}
}
}**/


