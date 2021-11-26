

public class Node {
private String data;
private Node Address;

Node(String data,Node ref)
{
	this.data = data;
	Address = ref;
}

public void setdata(String data)
{
	this.data = data;
}

public String getdata()
{
	return data;
}

public void setAddress(Node ref)
{
	Address= ref;
}
public Node getAddress()
{
	return Address;
}
}

