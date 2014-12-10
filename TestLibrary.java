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
	LibraryCollection library;

	//------------------------------------------------------------------------------
	// 사용자 UI를 위해 필요한 변수들 선언 
	//------------------------------------------------------------------------------
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel jp1;
	//private JPanel jp2;
	private JPanel jp3;
	private JPanel jp4;
	
	
	private JTextField title;
	private JTextField publisher;
	
	private JTextField authors;
	private JTextField isbn;
	private JTextField availability;
	private JTextField renting;
	private JTextField id;
	private JTextField pw;
	private JTextField name;
	private JTextField major;
	
	private JButton Jlogin; //로그인 버튼
	private JButton Jjoin; //회원가입 버튼
	
	private JButton Jadd; //추가 버튼
	private JButton Jmod; //수정 버튼
	private JButton Jdel; //삭제 버튼
	
	private JList list; // 도서목록
	//private JLabel icon;
	private JTextArea info; //도서 정보
	public int a;
	
	JMenuItem jmi1;
	JMenuItem jmi2;
	
	


	//------------------------------------------------------------------------------
	//생성자 - GUI를 구성한다.
	//------------------------------------------------------------------------------
	public TestLibraryDemo() 
	{
		JMenuBar jmb=new JMenuBar();
		JMenu menu=new JMenu("파일");
		jmi1=new JMenuItem("불러오기");
		menu.add(jmi1);
		jmi2=new JMenuItem("저장하기");
		menu.add(jmi2);
		jmb.add(menu);
		
		setJMenuBar(jmb);
		jmi1.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK));//Ctrl+0
		jmi2.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK));//Ctrl+S
		
		library=new LibraryCollection();	

		//------------------------------------------------------------------------------
		// 사용자 화면에 컴포넌트들 구성하여 배치
		// 각 컴포넌트 구성시 필요한 리스너 추가
		//------------------------------------------------------------------------------
		
		panel1 = new JPanel();
		//panel1.add( new JLabel("도서 관리 프로그램"));
		panel2=new JPanel(new GridLayout(1,1));
		panel3=new JPanel(new GridLayout(1,1));
		panel4=new JPanel(new GridLayout(0,1));
		jp1=new JPanel();
		//jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel(new GridLayout(1,3));
		jp1.setBorder(new TitledBorder("추가/수정"));
	
		jp3.setBorder(new TitledBorder("도서 목록"));
		jp4.setBorder(new TitledBorder("도서 정보"));
		
		id=new JTextField(10);
		pw=new JTextField(10);	
		
		title=new JTextField(10);
		publisher=new JTextField(10);
		authors=new JTextField(10);
		isbn=new JTextField(10);
		availability=new JTextField(10);
		renting=new JTextField(10);
		
		panel1.add(id);
		panel1.add(pw);
		jp1.add(new Label("도서 제목     "));
		jp1.add(title);
		jp1.add(new Label("출판사        "));
		jp1.add(publisher);
		jp1.add(new Label("저  자          "));
		jp1.add(authors);
		jp1.add(new Label("고유 번호    "));
		jp1.add(isbn);
		jp1.add(new Label("대출가능여부"));
		jp1.add(availability);
		jp1.add(new Label("대출자     "));
		jp1.add(renting);
		
		Jlogin=new JButton("로그인");
		Jjoin=new JButton("회원가입");
		Jadd=new JButton("추가");
		Jmod=new JButton("수정");
		Jdel=new JButton("삭제");
		
		panel1.add(Jlogin);
		panel1.add(Jjoin);
		
		jp1.add(Jadd);
		jp1.add(Jmod);
		jp1.add(Jdel);
		 
	
		list=new JList();
		info=new JTextArea();
		
		
		
		jp3.add(list);
		
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(info,v,h);
		//jp4.add(icon,BorderLayout.CENTER);
		jp4.add(jsp);
		
		//panel3.add(jp2);//,BorderLayout.CENTER);
		panel3.add(jp3);
		panel2.add(jp1);
		panel2.add(panel3);
		panel4.add(panel2);
		panel4.add(jp4);
		
		
		//------------------------------------------------------------------------------
		//	Frame 속성
		//------------------------------------------------------------------------------
		

		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());		
		c.add(panel1,BorderLayout.NORTH);
		c.add(panel4,BorderLayout.CENTER);
		
		Jlogin.addActionListener(this);
		Jjoin.addActionListener(this);
		
		Jadd.addActionListener(this);
		Jmod.addActionListener(this);
		Jdel.addActionListener(this);
		JSearch.addActionListener(this);
		list.addListSelectionListener(this);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		
		
		setTitle("Test Library");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	
	}
	
	
	
	

	//------------------------------------------------------------------------------
	// 리스너 인터페이스를 위한 각 메소드 구현
	//어떤 이벤트가 발생했는지에 따라 각각의 기능을 수행한다.
	//------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent event){

	if(event.getSource()==Jadd)//객체이름))//if(event.getActionCommand().equals("추가"//라벨이름))
	{
		
		Library newLibrary=new Library(title.getText(),publisher.getText(),authors.getText(),isbn.getText(),availability.getText(),renting.getText());//id.getText(),pw.getText(),name.getText(),major.getText());
		library.addLibrary(newLibrary);
			Vector Title=new Vector();
			for(int i=0;i<library.getLibraryCount();i++)
			{
				Title.addElement(library.getLibraryAt(i).getTitle());
				
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
		jp3.setBorder(new TitledBorder("도서 목록 뿌잉"));
		//Jmod.hide();
		Library newLibrary2=library.getLibraryAt(list.getSelectedIndex());
		if(newLibrary2!=null)
			jp3.setBorder(new TitledBorder("음슴"));
		newLibrary2.setTitle(title.getText());
		newLibrary2.setPublisher(publisher.getText());
		newLibrary2.setAuthors(authors.getText());
		newLibrary2.setIsbn(isbn.getText());
		newLibrary2.setAvailibility(availability.getText());
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
		
		for(int i=0;i<library.getLibraryCount();i++)
		{
			Title.addElement(library.getLibraryAt(i).getTitle());
		}
		
		list.setListData(Title);
		
		
		
		
		
	}
			
	else if(event.getSource()==Jdel)
	{
		
		library.delLibrary(list.getSelectedIndex());
		info.setText("");
		info.setText(library.toString());
		title.setText("");
		publisher.setText("");
		authors.setText("");
		isbn.setText("");
		availability.setText("");
		renting.setText("");
		
		Vector Title=new Vector();
		for(int i=0;i<library.getLibraryCount();i++)
		{
			Title.addElement(library.getLibraryAt(i).getTitle());
			
		}
		list.setListData(Title);
		
		
	}
	
	
	else if(event.getSource()==Jsearch)//객체이름))//if(event.getActionCommand().equals("추가"//라벨이름))
	{
 
		String str=curious.getText();
		info.setText("");
		String title;
			Vector Title=new Vector();
			list.setListData(Title);
			for(int i=0;i<library.getLibraryCount();i++)
			{
				title=(library.getLibraryAt(i).getTitle());
				if(title.contains(str))
				{
					Title.addElement(library.getLibraryAt(i).getTitle());
					info.setText(library.getLibraryAt(i).getTitle());
				}
			}
			list.setListData(Title);
			curious.setText("");
	}
	
	
	else if((event.getActionCommand()).equals("불러오기"))
	{
		try{
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("libraryinfo.txt"));
			int count=ois.readInt();
			library=(LibraryCollection)ois.readObject();
			info.setText("");
			info.append(library.toString());
			
			Vector Title=new Vector();
			for(int i=0;i<count;i++)
			{
				Title.addElement(library.getLibraryAt(i).getTitle());
				
			}
			list.setListData(Title);
			ois.close();
			
		}catch (IOException e) 
		{
			info.setText("1에러");
		}catch (ClassNotFoundException e)
		{
			info.setText("2에러");
		}
		
		

	}
	else if((event.getActionCommand()).equals("저장하기"))
	{
		try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libraryinfo.txt"));
				oos.writeInt(library.getLibraryCount());
				oos.writeObject((Object)library);oos.close();
				info.setText("저장됐습니다!");
				oos.close();
				
		} catch (IOException e){
			info.setText("저장에러");
		}
		
		
	}
	
	}

	//------------------------------------------------------------------------------
	//선택된 인덱스에 해당되는 영화 정보를 textArea 에서 출력한다.
	//------------------------------------------------------------------------------
	public void valueChanged(ListSelectionEvent event){

		Library newLibrary2=library.getLibraryAt(list.getSelectedIndex());
		title.setText(newLibrary2.getTitle());
		publisher.setText(newLibrary2.getPublisher());
		authors.setText(newLibrary2.getAuthors());
		isbn.setText(newLibrary2.getIsbn());
		availability.setText(newLibrary2.getAvailibility());
		renting.setText(newLibrary2.getRenting());
		
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
public TestLibrary(){
	super("제목");
	this.init();
	this.start();
	this.setSize(300,200);
	this.setLocation(400,200);
	this.setVisible(true);
}
public void init(){
	System.out.println("메롱");
}
public void start(){
	System.out.println("조주");
}
}
}**/


