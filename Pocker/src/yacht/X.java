package yacht;


import java.util.*;




class Turn{
	
	private int one;
	private int two;
	private int three;
	private int four;
	private int five;
	private int six;
	private int bonus;
	private int chance;
	private int fourdice;
	private int fullHouse;
	private final int straight=15;
	private final int loyalstraight=20;
	private final int yacht=60;
	private int dice1;
	private int dice2;
	private int dice3;
	private int dice4;
	private int dice5;
	private int dice6;
	private final int zero=0;
	
	public Turn(int one , int two, int three, int four, int five, int six) {
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.six= six;
	}
	
	public int getone(int one) {
		return one*1;
	}
	public int gettwo(int two) {
		return two*2;
	}
	public int getthree(int three) {
		return three*3;
	}
	public int getfour(int four) {
		return four*4;
	}
	public int getfive(int five) {
		return five*5;
	}
	public int getsix(int six) {
		return six*6;
	}
	public int getchance(int one,int two, int three, int four, int five, int six) {
		return one*1+two*2+three*3+four*4+five*5+six*6;
	}
	public int getfd(int one,int two, int three, int four, int five, int six) {
		if(one==4||two==4||three==4||four==4||five==4||six==4) {
			return one*1 + two*2+ three*3 + four*4+ five*5 + six*6;
		}
		else {
			return zero;
		}
	}
	public int getfh(int one,int two, int three, int four, int five, int six ) {
		if((one==3||two==3||three==3||four==3||five==3||six==3)&&(one==2||two==2||three==2||four==2||five==2||six==2))
		return one*1 + two*2+ three*3 + four*4+ five*5 + six*6;
		else {
			return zero;}
	}
	public int getst(int one,int two, int three, int four, int five, int six ){
		if((three>=1&&four>=1&&one>=1&&two>=1)|(two>=1&&three>=1&&four>=1&&five>=1)|(three>=1&&four>=1&&five>=1&&six>=1))
			
			return straight;
		else
			return zero;
	}
	public int getls(int one,int two, int three, int four, int five, int six ){
		if((one==1&two==1&three==1&four==1&five==1)||(two==1&three==1&four==1&five==1&six==1))
			return loyalstraight;
		else
			return zero;
	}
	
	
	public int getyacht(int one,int two, int three, int four, int five, int six) {
		
		if(one==6|two==6|three==6|four==6|five==6|six==6) {
			return yacht;
		}
		else {
			return zero;
		}
	}
}



public class X {
	
	public static void main(String[] args) {
			
		System.out.println("게임을 시작합니다");
		
		System.out.println("-----------");
		
		
		Scanner sc = new Scanner(System.in);
		Random ra = new Random();
	
	
	
		
		System.out.println("주사위를 굴리려면 d를 제외한 아무키나 입력하세요 ");

		
		
			int dice1=0;
			int dice2=0;
			int dice3=0;
			int dice4=0;
			int dice5=0;
			int count = 0;
			int one=0;
			int two=0;
			int three=0;
			int four=0;
			int five=0;
			int six=0;
			
			int []arr = new int[6];
			
			HashMap<String,Integer> h = new HashMap<String, Integer>();
		
			h.put("one",null);
			h.put("two",null);
			h.put("three",null);
			h.put("four",null);
			h.put("five",null);
			h.put("six",null);
		
			while (true) {
	
			{
			while(true) {
				
			
				String roll = sc.next();
				
				if(roll.equals("d")) {
					System.out.println("턴을 종료합니다");
					count=0;
					break;
				}
				
				 dice1 = ra.nextInt(6)+1;
				 dice2 = ra.nextInt(6)+1;
				 dice3 = ra.nextInt(6)+1;
				 dice4 = ra.nextInt(6)+1;
				 dice5 = ra.nextInt(6)+1;
				 		
				
				arr[0]=dice1;
				arr[1]=dice2;
				arr[2]=dice3;
				arr[3]=dice4;
				arr[4]=dice5;
			
				
				one=0;
				two=0;
				three=0;
				four=0;
				five=0;
				six=0;
			
				
				for (int i=0; i<6; i++) {
					
					if (arr[i]==1) {
						one=one+1;
						continue;
					}
					else if (arr[i]==2) {
						two=two+1;
						continue;
					}
					else if (arr[i]==3) {
						three=three+1;
						continue;
					}
					else if (arr[i]==4) {
						four=four+1;
						continue;
					}
					else if (arr[i]==5) {
						five=five+1;
						continue;
					}
					else if (arr[i]==6) {
						six=six+1;
						continue;
					}
				}	
			
			
			

			
			
					if(!roll.equals("d")) {
				/*		System.out.println("[dice1]: "+dice1);
						System.out.println("[dice2]: "+dice2);
						System.out.println("[dice3]: "+dice3);
						System.out.println("[dice4]: "+dice4);
						System.out.println("[dice5]: "+dice5);*/
						d(dice1);
						d(dice2);
						d(dice3);
						d(dice4);
						d(dice5);
					
					
						
						h.replace("one",one);
						h.replace("two",two);
						h.replace("three",three);
						h.replace("four",four);
						h.replace("five",five);
						h.replace("six",six);
										
						count ++;
						
						
					
						if (count == 3) {
							System.out.println("3번의 기회가 끝났습니다");
							count=0;
							break;
							}
						
						
					}
			
			
				
			System.out.println();
			System.out.println(3-count+"번의 기회가 더 남았습니다. 턴을 종료하시려면 d키를 입력하세요.");
		}
			
			Turn t = new Turn(h.get("one"),h.get("two"),h.get("three"),h.get("four"),h.get("five"),h.get("six"));
			
			
			
			System.out.println("옵션을 선택하세요.");
			System.out.println();
			System.out.println("1.원 2.투 3.쓰리 4.포 5.파이브 6.식스 7.찬스 8.포다이스 9.풀하우스 10.스트레이트 11.로얄 스트레이트 12.야추");
			
			int op = sc.nextInt();
			
			if(op==1) {
				System.out.println(t.getone(one)); 
			}
			else if(op==2) {
				System.out.println(t.gettwo(two)); 
				}
			else if(op==3) {
				System.out.println(t.getthree(three)); 
				}
			else if(op==4) {
				System.out.println(t.getfour(four)); 
				}
			else if(op==5) {
				System.out.println(t.getfive(five)); 
				}
			else if(op==6) {
				System.out.println(t.getsix(six)); 
				}
			else if(op==7) {
				System.out.println(t.getchance(one,two,three,four,five,six));
			}
			else if(op==8) {
				
				System.out.println(t.getfd(one, two, three, four, five, six));
			}
			else if(op==9) {
				System.out.println(t.getfh(one, two, three, four, five, six));
			}
			else if(op==10) {
				System.out.println(t.getst(one, two, three, four, five, six));
			}
			else if(op==11) {
				System.out.println(t.getls(one, two, three, four, five, six));
			}
			else if(op==12) {
				System.out.println(t.getyacht(one, two, three, four, five, six));
			}
			
			System.out.println("다음 상대 차례입니다. 주사위를 던지세요 ");
			System.out.println();
			
			}
			
			}
		
		
		
}
	public static void d(int dice) {
		
		if(dice==1) {
		System.out.println(" ------- ");
		System.out.println("|       |");
		System.out.println("|   0   |");
		System.out.println("|       |");
		System.out.println(" ------- ");
		}
		
		else if(dice==2) {
			System.out.println(" ------- ");
			System.out.println("|       |");
			System.out.println("|  0 0  |");
			System.out.println("|       |");
			System.out.println(" ------- ");
		}
		else if(dice==3) {
			System.out.println(" ------- ");
			System.out.println("| 0     |");
			System.out.println("|   0   |");
			System.out.println("|     0 |");
			System.out.println(" ------- ");
		}
		else if(dice==4) {
			System.out.println(" ------- ");
			System.out.println("| 0   0 |");
			System.out.println("|       |");
			System.out.println("| 0   0 |");
			System.out.println(" ------- ");
		}
		else if(dice==5) {
			System.out.println(" ------- ");
			System.out.println("| 0   0 |");
			System.out.println("|   0   |");
			System.out.println("| 0   0 |");
			System.out.println(" ------- ");
		}
		else if(dice==6) {
			System.out.println(" ------- ");
			System.out.println("| 0   0 |");
			System.out.println("| 0   0 |");
			System.out.println("| 0   0 |");
			System.out.println(" ------- ");
			
		}
		
	}
}
