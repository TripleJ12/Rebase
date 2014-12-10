import java.io.Serializable;

public class Library implements Serializable
{
	private String title; //도서 제목
	private String publisher;//출판사
	private String authors;//저자
	private String isbn;//고유번호
	private String availibility;//대출가능여부
	private String renting;//대출자
	//회원가입 변수 추가
	//private String id;//ID
	//private String pw; //Password
	//private String name;//학생 이름
	//private String major;//학과
	
	
	//------------------------------------------------------------------------------
	//생성자 - Library 를 생성한다. 
	//------------------------------------------------------------------------------
	public Library(String title,String publisher,String authors,String isbn,String availibility,String renting)
	{
		this.title=title;
		this.publisher=publisher;
		this.authors=authors;
		this.isbn=isbn;
		this.availibility=availibility;
		this.renting= renting;

	}
	
	//------------------------------------------------------------------------------
	//Library 정보를 반환한다.
	//------------------------------------------------------------------------------
	public String toString()
	{
		String description;
		description="<"+getTitle()+">"+"\n";
		description+="-출판사 ☞ "+getPublisher()+"\n";
		description+="-저자 ☞ "+getAuthors()+"\n";
		description+="-고유번호 ☞ "+getIsbn()+"\n";
		description+="-대출가능여부 ☞ "+getAvailibility()+"\n";
		description+="-대출자 ☞ "+getRenting()+"\n";
		/*description+="-ID ☞ "+getId()+"\n";
		/description+="-PW ☞ "+getPw()+" \n";
		description+="-이름 ☞ "+getName()+"\n";
		description+="-학과☞  "+getMajor()+"\n";*/

		
		return description;
	}
	
	//------------------------------------------------------------------------------
	//title 을 반환한다.
	//------------------------------------------------------------------------------
	public String getTitle()
	{
		return title;
	}
	
	//------------------------------------------------------------------------------
	//publisher 을 반환한다.
	//------------------------------------------------------------------------------
	public String getPublisher()
	{
		return publisher;
	}
	
	//------------------------------------------------------------------------------
	//authors 을 반환한다.
	//------------------------------------------------------------------------------
	public String getAuthors()
	{
		return authors;
	}
	//------------------------------------------------------------------------------
	//isbn 을 반환한다.
	//------------------------------------------------------------------------------
	public String getIsbn()
	{
		return isbn;
	}
		
	//------------------------------------------------------------------------------
	//availibility 을 반환한다.
	//------------------------------------------------------------------------------
	public String getAvailibility()
	{
		return availibility;
	}
	
	//------------------------------------------------------------------------------
	//renting 을 반환한다.
	//------------------------------------------------------------------------------
	public String getRenting()
	{
		return renting;
	}
	/*
	//------------------------------------------------------------------------------
	//id 을 반환한다.
	//------------------------------------------------------------------------------
	public String getId()
	{
		return id;
	}
	
	//------------------------------------------------------------------------------
	//pw 을 반환한다.
	//------------------------------------------------------------------------------
	public String getPw()
	{
		return pw;
	}
	
	//------------------------------------------------------------------------------
	//name 을 반환한다.
	//------------------------------------------------------------------------------
	public String getName()
	{
		return name;
	}
	
	//------------------------------------------------------------------------------
	//major 을 반환한다.
	//------------------------------------------------------------------------------
	public String getMajor()
	{
		return major;
	}
	*/
	//------------------------------------------------------------------------------
	//title 을 변경한다.
	//------------------------------------------------------------------------------
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	//------------------------------------------------------------------------------
	//publisher 을 변경한다.
	//------------------------------------------------------------------------------
	public void setPublisher(String publisher)
	{
		this.publisher=publisher;
	}
	
	//------------------------------------------------------------------------------
	//authors 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setAuthors(String authors)
	{
		this.authors=authors;
	}
	
	//------------------------------------------------------------------------------
	//isbn 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setIsbn(String isbn)
	{
		this.isbn=isbn;
	}
	
	//------------------------------------------------------------------------------
	//availibility 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setAvailibility(String availibility)
	{
		this.availibility=availibility;
	}
	
	//------------------------------------------------------------------------------
	//renting 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setRenting(String renting)
	{
		this.renting=renting;
	}
	/*
	//------------------------------------------------------------------------------
	//id 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setId(String id)
	{
		this.id=id;
	}
	
	//------------------------------------------------------------------------------
	//pw 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setPw(String pw)
	{
		this.pw=pw;
	}
	
	//------------------------------------------------------------------------------
	//name 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setName(String name)
	{
		this.name=name;
	}
	
	//------------------------------------------------------------------------------
	//major 을 변경한다.
	//------------------------------------------------------------------------------	
	public void setMajor(String major)
	{
		this.major=major;
	}*/

}
