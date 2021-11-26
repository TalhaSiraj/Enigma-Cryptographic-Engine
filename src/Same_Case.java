

import java.util.Random;

public class Same_Case {

	public static String ENCODING(String word)
	{
		String Temp = " ";
		int initial_temp  = Main.temprary.size();
		for(int loop = 0 ; loop< word.length() ; loop++)
		{
			Main.alphabat [loop] = word.charAt(loop);
		}
		int check = 0 ;
		while(check != word.length())
		{
			char alpha = Main.alphabat [check];
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
								Val = value+(loop+2);
								if(Main.temprary.size() == 0)
								{
									Main.temprary.add(Val);
								}
								else
								{
									if(Main.temprary.contains(Val))
									{
										int lastadd = Main.temprary.size()-1;
										int lastvalue = 3+Main.temprary.get(lastadd);
									if(lastvalue>=65 && lastvalue<91)
									{
										Main.temprary.add(lastvalue-3);
									}else
									{
										Main.temprary.add(lastvalue-5);
									}
										
									}
									else
									{
										Main.temprary.add(Val);
									}
								}
								
							}
						}
						if(value %2 != 0)
						{
							for(int loop = 0 ; loop <2 ; loop++)
							{
								Val = value+(loop+8);
								if(Main.temprary.size() == 0)
								{
									Main.temprary.add(Val);
								}
								else
								{
									if(Main.temprary.contains(Val))
									{
										int lastadd = Main.temprary.size()-8;
										int lastvalue = 1+Main.temprary.get(lastadd);
										if(lastvalue>=65 && lastvalue<91)
										{
											Main.temprary.add(lastvalue+1);
										}else
										{
											Main.temprary.add(lastvalue-4);
										}
										
									}
									else
									{
										Main.temprary.add(Val);
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
							Val = value - (loop-1);
							if(Main.temprary.size() == 0)
							{
								Main.temprary.add(Val);
							}
							else
							{
								if(Main.temprary.contains(Val))
								{
									int lastadd = Main.temprary.size()-1;
								int lastvalue = 9+Main.temprary.get(lastadd);
								if(lastvalue>=65 && lastvalue<91)
								{
									Main.temprary.add(lastvalue-2);
								}else
								{
									Main.temprary.add(lastvalue-6);
								}
								
								}
								else
								{
									Main.temprary.add(Val);
								}
							}
						}
						}
						if(value %2 != 0)
						{
						for(int loop = 10 ; loop >8; loop--)
						{
							Val = value - (loop-6);
							if(Main.temprary.size() == 0)
							{
								Main.temprary.add(Val);
							}
							else
							{
								if(Main.temprary.contains(Val))
								{
									int lastadd = Main.temprary.size()-1;
									int lastvalue = 3+Main.temprary.get(lastadd);
									if(lastvalue>=65 && lastvalue<91)
									{
										Main.temprary.add(lastvalue-8);
									}if(lastvalue>=91)
									{
										Main.temprary.add(lastvalue-12);
									}
									
								}
								else
								{
									Main.temprary.add(Val);
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
		for(int i = initial_temp ; i < Main.temprary.size()  ; i++)
		{
			int temp = Main.temprary.get(i);
			Temp +=(char)temp;
		}
		
		//Adding Serial number to identify number of code.
		int Serial = Rand();
		System.out.println("Your Serial is : "+Serial);
		
		Main.User_code_info.put(Serial, Temp);
		

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
		if(Main.random_serial.size() == 0)
		{
			Main.random_serial.add(num);
		}
		if(Main.random_serial.size() != 0)
		{
			if(Main.random_serial.contains(num))
			{
				num = num+1;
				Main.random_serial.add(num);
			}	
			else
			{
				Main.random_serial.add(num);
			}
		}
		
		return num;
	}
}
