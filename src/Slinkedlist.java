

public class Slinkedlist {
	private Node head,tail;
	private int size;

	Slinkedlist()
	{
		head =tail =  null;
		size = 0;
	}

	public Node Addfirst(String value)
	{

		Node n = new Node(value , null);
		n.setAddress(head);
		head = n;
		size++;
		if(tail == null)
		{
			tail = n;
		}
		return head;
		
	}
	
	public String Search(Node address)
	{
		String data = address.getdata();
		String error = "Result not found.";
		if(data != null)
		{
			return data;
		}
		else
			return error;
	}
	public boolean Available(String value)
	{
		Node n = head;
		while(n != null)
		{
			String match = n.getdata();
			if(match.equals(value))
			{
				return true;
			}
			n = n.getAddress();
		}
		return false;
	}

	public void Delete_Data(Node address)
	{
		String data = address.getdata();
		if(data != null)
		{
			address = null;
			System.out.println("Data deleted.");
		}
		else
		{
			System.out.println("Data is not available.");
		}
	}
	}
