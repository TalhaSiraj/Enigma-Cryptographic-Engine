
import java.util.*;
public class Main {

	
	static ArrayList<Integer> temprary = new ArrayList<>();
	
	static char [] alphabat = new char[100];
	
	static ArrayList<Integer> random_serial = new ArrayList<>();
	
	static Hashtable<String,Node> table = new Hashtable<>(); 
	
	static Hashtable<Integer,String> User_code_info = new Hashtable<>();
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Character> Code = new ArrayList<>();//Take code characters
		String temp2 = null , word = null;
		Node Address = null;
		Slinkedlist save = new Slinkedlist();
		int Serial ,Selection;
		System.out.println("==========================================");
		System.out.println("		E N I G M A  		");
		System.out.println("==========================================");
		while(true)
		{
			Selection = Menu_Selection();
			if(Selection == 1)
			{
				System.out.print("Enter : ");
				word = input.next();
				if(word.equals(word.toLowerCase()))
				{
					word = word.toUpperCase();	
				}
				if(word == null)
				{
					
				}else
				{

					if(save.Available(word) == true)
					{
						Same_Case sc= new Same_Case();
						//Encoding Process...
						temp2 = sc.ENCODING(word);
						Address = save.Addfirst(word);
						table.put(temp2, Address);
						word =null;
					}
					if(save.Available(word) == false && word != null)
					{
						//Encoding Process...
						temp2 = ENCODING(word);
						Address = save.Addfirst(word);
						table.put(temp2, Address);
						word =null;
					}else{}	
				}
			}if(Selection == 2)
			{
				//DECONDING PROCESS...
				System.out.print("Enter user serail number : ");
				Serial = input.nextInt();
				
				if(User_code_info.containsKey(Serial))
				{
					String temp = User_code_info.get(Serial);
					System.out.println("Please input this Code : "+User_code_info.get(Serial));
					
					for(int i = 0 ; i < temp.length()-1 ; i++)
					{
						char sa;
						System.out.print("\nEnter Character : ");
						sa = input.next().charAt(0);
						Code.add(sa);	
					}
					
					String Result = Decoding(Code);
					System.out.println("******************************************");
					System.out.println("Decoded code is : "+Result+" .");
					System.out.println("******************************************");
					Code.removeAll(Code);

				}if(User_code_info.containsKey(Serial) == false)
				{
					System.out.println("Invalid Key.");
				}
				
			}
			System.out.println("");
			Selection = 0;
		}
		
		
	}
	public static int Menu_Selection()
	{
		Scanner input = new Scanner(System.in);
		int choose = 0 ;
		System.out.println("\n==========================================");
		System.out.println("		    M E N U 		");
		System.out.println("==========================================");
		System.out.println("Encoding press : 1");
		System.out.println("Decoding press : 2");
		System.out.print("Choose : ");
		choose = input.nextInt();
		
				if(choose == 1 || choose == 2)
				{
					if(choose == 1)
					{
						return 1;
					}
					if(choose == 2 && table.isEmpty() == false)
					{
						return 2;
					}
					else
					{
						System.out.println("Database is empty.");
						return Menu_Selection();
					}
						
				}
				return Menu_Selection();

	}
	
	public static String ENCODING(String word)
	{
		String Temp = " ";
		int initial_temp  = temprary.size();
		for(int loop = 0 ; loop< word.length() ; loop++)
		{
			alphabat [loop] = word.charAt(loop);
		}
		int check = 0 ;
		while(check != word.length())
		{
			char alpha = alphabat [check];
			int value = alpha ;
			for(int i = 65; i<91 ; i++)
			{
				if(i == value)
				{
					if(value>=65 && value<84)
					{
						int Val = 0;
						
						if(value %2 == 0)
						{
							for(int loop = 0 ; loop <2 ; loop++)
							{
								Val = value+(loop+3);
								if(temprary.size() == 0)
								{
									temprary.add(Val);
								}
								else
								{
									if(temprary.contains(Val))
									{
										int lastadd = temprary.size()-1;
										int lastvalue = 5+temprary.get(lastadd);
									if(lastvalue>=65 && lastvalue<91)
									{
										temprary.add(lastvalue-1);
									}else
									{
										temprary.add(lastvalue-8);
									}
										
									}
									else
									{
										temprary.add(Val);
									}
								}
								
							}
						}
						if(value %2 != 0)
						{
							for(int loop = 0 ; loop <2 ; loop++)
							{
								Val = value+(loop+3);
								if(temprary.size() == 0)
								{
									temprary.add(Val);
								}
								else
								{
									if(temprary.contains(Val))
									{
										int lastadd = temprary.size()-1;
										int lastvalue = 5+temprary.get(lastadd);
										if(lastvalue>=65 && lastvalue<91)
										{
											temprary.add(lastvalue+3);
										}else
										{
											temprary.add(lastvalue-7);
										}
										
									}
									else
									{
										temprary.add(Val);
									}
								}
							}
						}
						
					}
					
					if(value >= 84 && value < 91)
					{int Val = 0;
						if(value %2 == 0)
						{
						
						for(int loop = 10 ; loop >8; loop--)
						{
							Val = value - (loop-4);
							if(temprary.size() == 0)
							{
								temprary.add(Val);
							}
							else
							{
								if(temprary.contains(Val))
								{
									int lastadd = temprary.size()-1;
								int lastvalue = 5+temprary.get(lastadd);
								if(lastvalue>=65 && lastvalue<91)
								{
									temprary.add(lastvalue-1);
								}else
								{
									temprary.add(lastvalue-8);
								}
								
								}
								else
								{
									temprary.add(Val);
								}
							}
						}
						}
						if(value %2 != 0)
						{
						for(int loop = 10 ; loop >8; loop--)
						{
							Val = value - (loop-7);
							if(temprary.size() == 0)
							{
								temprary.add(Val);
							}
							else
							{
								if(temprary.contains(Val))
								{
									int lastadd = temprary.size()-1;
									int lastvalue = 4+temprary.get(lastadd);
									if(lastvalue>=65 && lastvalue<91)
									{
										temprary.add(lastvalue-1);
									}if(lastvalue>=91)
									{
										temprary.add(lastvalue-10);
									}
									
								}
								else
								{
									temprary.add(Val);
								}
							}
						}
						}
						
					}
									
				}	
			}
			check +=1;
	
		}
		
		//Creating Code ...
		for(int i = initial_temp ; i < temprary.size()  ; i++)
		{
			int temp = temprary.get(i);
			Temp +=(char)temp;
		}
		
		//Adding Serial number to identify number of code.
		int Serial = Rand();
		System.out.println("Your Serial is : "+Serial);
		
		User_code_info.put(Serial, Temp);
		

		return Temp;	
	}

	public  static int Rand()
	{
		Random serial = new Random();
		int num;
		num = serial.nextInt(100);
		if(num == 0)
		{
			num = num+1;
		}
		if(random_serial.size() == 0)
		{
			random_serial.add(num);
		}
		if(random_serial.size() != 0)
		{
			if(random_serial.contains(num))
			{
				num = num+1;
				random_serial.add(num);
			}	
			else
			{
				random_serial.add(num);
			}
		}
		
		return num;
	}
	public static String Decoding(ArrayList<Character> c)
	{
		Slinkedlist info = new Slinkedlist();
		String temp = " ";
		for(int i = 0 ; i < c.size() ; i++)
		{
			char placer = c.get(i);
			
			temp +=placer;
		}
		Node search = null;
		if(table.containsKey(temp))
		{
			search = table.get(temp);	
			String temp2 =info.Search(search);
			temp = null;
			return temp2;
		}
		else
		{
			temp = null;
			return "Invalid Code.";
		}
		
	}

}
