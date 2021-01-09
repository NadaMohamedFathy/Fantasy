import java.io.File;
import java.util.Scanner;

public class Main {
	
	static User user=new User();
	static Player player=new Player();
	static Files filee=new Files();
	static SquadRules squad;
	static CalculateBudget budget=new CalculateBudget();
	static Events event;
	static Observers observer;
	static ScoringOfWeek scoringOfWeek=new ScoringOfWeek();
	public static void main(String args[]) throws Exception
	{
		boolean choose=true;
		Scanner scan= new Scanner(System.in);
		Scanner scan1= new Scanner(System.in);
		while(choose) 
		{
			System.out.print("Choose option : " + '\n');
			System.out.print("(1) Sign in " + '\n');
			System.out.print("(2) Login " + '\n');
			System.out.print("(3) Add Player " + '\n');
			System.out.print("(4) Add Squad " + '\n');
			System.out.print("(5) New event for player " + '\n');
			System.out.print("(6) My score of a squad for a given game week " + '\n');
			System.out.print("(7) Exit " + '\n');
			System.out.println('\n' + "-------------------------------------------------------------------------------------------------" + '\n');
			System.out.print("Your choise : ");
			String choise= scan.nextLine();
			switch (choise)
			{
				case ("1"):
				{
					user.SignedInUser();
					break;
				}
				case ("2"):
				{
					user.LogedInUser();
					break;
				}
				case ("3"):
				{
					player.addPlayer();
					break;
				}
				case ("4"):
				{
					System.out.println("Login : ");
					int index=user.LogedInUser();
					if(index>=0)
					{
						System.out.println("Squad Size\r\n" + 
								"To join the game select a fantasy football squad of 15 players, consisting of:\r\n" + 
								"\r\n" + 
								"* 2 Goalkeepers\r\n" + 
								"* 5 Defenders\r\n" + 
								"* 5 Midfielders\r\n" + 
								"* 3 Forwards\r\n" + 
								"Budget\r\n" + 
								"The total value of your initial squad must not exceed £100 million.\r\n" + 
								"\r\n" + 
								"Players Per Team\r\n" + 
								"You can select up to 3 players from a single Premier League team.");
						String userfile=filee.UserFile(index);
						System.out.println('\n' + "-------------------------------------------------------------------------------------------------" + '\n');
						filee.displayFile("Players.txt");
						while(true)
						{
							boolean Nfile=false,Pfile=false,Bfile=false,Gfile=false,Ffile=false,Mfile=false,Dfile=false;
							String newBudgetOfUser=null;
							System.out.println("Enter name of the player you want to add to your squad : ");
							String playerName= scan.nextLine();
							int ind=-1;
							ind=filee.search("Players.txt",playerName);//index bta3 el player w mnha el club bta3o hykon ind+2 w el position bta3o ind+3
							if(ind>=0)
							{
								squad=new checkNOPinSquad();
								Nfile=squad.applayRules(userfile, playerName);
								squad=new checknumberOfPlayers();
								Pfile=squad.applayRules(userfile, playerName);
								squad=new checkBudget();
								Bfile=squad.applayRules(userfile, playerName);
								String position=filee.array.get(ind+3);//position of player
								if(position.equalsIgnoreCase("Goalkeeper"))
								{
									squad=new numberOfGoalkeepers();
									Gfile=squad.applayRules(userfile, playerName);
									if(Nfile && Pfile && Bfile && Gfile)
									{
										newBudgetOfUser=budget.calculateBudget(userfile, playerName);
										filee.writeFileBudget(userfile, playerName, newBudgetOfUser);
										System.out.println("You add this player to your squad");
									}
									else
									{
										System.out.println("You cannot add this player to your squad");
										if(Nfile==false)
										{
											break;
										}
									}
								}
								else if(position.equalsIgnoreCase("Forward"))
								{
									squad=new numberOfForwards();
									Ffile=squad.applayRules(userfile, playerName);
									if(Nfile && Pfile && Bfile &&Ffile)
									{
										newBudgetOfUser=budget.calculateBudget(userfile, playerName);
										filee.writeFileBudget(userfile, playerName, newBudgetOfUser);
										System.out.println("You add this player to your squad");
									}
									else
									{
										System.out.println("You cannot add this player to your squad");
										if(Nfile==false)
										{
											break;
										}
									}
								}
								else if(position.equalsIgnoreCase("Midfielder"))
								{
									squad=new numberOfMidfielders();
									Mfile=squad.applayRules(userfile, playerName);
									if(Nfile && Pfile && Bfile && Mfile)
									{
										newBudgetOfUser=budget.calculateBudget(userfile, playerName);
										filee.writeFileBudget(userfile, playerName, newBudgetOfUser);
										System.out.println("You add this player to your squad");
									}
									else
									{
										System.out.println("You cannot add this player to your squad");
										if(Nfile==false)
										{
											break;
										}
									}
								}
								else if(position.equalsIgnoreCase("Defender"))
								{
									squad=new numberOfDefenders();
									Dfile=squad.applayRules(userfile, playerName);
									if(Nfile && Pfile && Bfile && Dfile)
									{
										newBudgetOfUser=budget.calculateBudget(userfile, playerName);
										filee.writeFileBudget(userfile, playerName, newBudgetOfUser);
										System.out.println("You add this player to your squad");
									}
									else
									{
										System.out.println("You cannot add this player to your squad");
										if(Nfile==false)
										{
											break;
										}
									}
								}
							}
							else
							{
								System.out.println("You may entered the name of the player wrong or entered name of player that is not in the system.");
							}
						}
					}
					else
					{
						System.out.println("You cannot add squad" + '\n');
					}
					break;
				}
				case ("5"):
				{
					String Team1 = null;
					String Team2 = null;
					System.out.println("For which week ? (Enter the week like that --> Week 1 : )");
					String week=scan.nextLine();
					String file_week=week+".txt";
					File weekFile=new File(file_week);
					boolean file=weekFile.exists();
					if(file==false)
					{
						System.out.println("can not find this week");
					}
					else
					{
						if(file_week.equalsIgnoreCase("Week 1.txt"))
						{
							System.out.println("You are in week 1	\r\n" + "Now live match is : Liverpool VS Manchester City	\r\n");
							Team1="Liverpool";
							Team2="Manchester City";
							filee.ReadDG("Week 1.txt");
						}
						else if(file_week.equalsIgnoreCase("Week 2.txt"))//lsa m3mlnash homa men
						{
							System.out.println("You are in week 2	\r\n" + "Now live match is : Chelsea VS Aston Villa	\r\n");
							Team1="Chelsea";
							Team2="Aston Villa";
							filee.ReadDG("Week 2.txt");
						}
						filee.displayFile(file_week);
					}
					System.out.println('\n' + "-------------------------------------------------------------------------------------------------" + '\n');
					System.out.println("(1) For playing 60 minutes or more (excluding stoppage time)	\r\n" + 
							"(2) For each goal scored by a goalkeeper or defender	\r\n" + 
							"(3) For each goal scored by a midfielder	\r\n" + 
							"(4) For each goal scored by a forward	\r\n" + 
							"(5) For each goal assist	\r\n" + 
							"(6) For each yellow card	\r\n" + 
							"(7) For each red card	\r\n"+
							"(8) For each own goal	\r\n");
					System.out.println('\n' + "-------------------------------------------------------------------------------------------------" + '\n');
					System.out.print("Your choise : ");
					String choose1= scan.nextLine();
					switch (choose1)
					{
						case ("1"):
						{
							event=new ForPlayingUpTo60MinutesOrMore();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							System.out.println("How many players ? ");
							int n=scan1.nextInt();
							for(int i=0;i<n;i++)
							{
								System.out.println("Enter name of the player you want to add an event for : ");
								String name= scan.nextLine();
								event.applayEvent(name, file_week);
							}
							break;
						}
						case ("2"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							System.out.println("Enter team of the player you want to add an event for : ");
							String nameT= scan.nextLine();
							event=new GoalScoredByGoalkeeperOrDefender();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							System.out.println("Enter name of the player who made the assist : ");
							String nameAss= scan.nextLine();
							event=new GoalAssist();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(nameAss, file_week);
							event=new HaveGoal();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							if(nameT.equalsIgnoreCase(Team1))
							{
								for(int i=0;i<filee.Team2.size();i++)
								{
									event.applayEvent(filee.Team2.get(i), file_week);
								}
							}
							else if(nameT.equalsIgnoreCase(Team2))
							{
								for(int i=0;i<filee.Team1.size();i++)
								{
									event.applayEvent(filee.Team1.get(i), file_week);
								}
							}
							break;
						}
						case ("3"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							System.out.println("Enter team of the player you want to add an event for : ");
							String nameT= scan.nextLine();
							event=new GoalScoredByMidfielder();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							System.out.println("Enter name of the player who made the assist : ");
							String nameAss= scan.nextLine();
							event=new GoalAssist();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(nameAss, file_week);
							event=new HaveGoal();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							if(nameT.equalsIgnoreCase(Team1))
							{
								for(int i=0;i<filee.Team2.size();i++)
								{
									event.applayEvent(filee.Team2.get(i), file_week);
								}
							}
							else if(nameT.equalsIgnoreCase(Team2))
							{
								for(int i=0;i<filee.Team1.size();i++)
								{
									event.applayEvent(filee.Team1.get(i), file_week);
								}
							}
							break;
						}
						case ("4"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							System.out.println("Enter team of the player you want to add an event for : ");
							String nameT= scan.nextLine();
							event=new GoalScoredByForward();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							System.out.println("Enter name of the player who made the assist : ");
							String nameAss= scan.nextLine();
							event=new GoalAssist();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(nameAss, file_week);
							event=new HaveGoal();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							if(nameT.equalsIgnoreCase(Team1))
							{
								for(int i=0;i<filee.Team2.size();i++)
								{
									event.applayEvent(filee.Team2.get(i), file_week);
								}
							}
							else if(nameT.equalsIgnoreCase(Team2))
							{
								for(int i=0;i<filee.Team1.size();i++)
								{
									event.applayEvent(filee.Team1.get(i), file_week);
								}
							}
							break;
						}
						case ("5"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							event=new GoalAssist();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							break;
						}
						case ("6"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							event=new YellowCard();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							break;
						}
						case ("7"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							event=new RedCard();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							break;
						}
						case ("8"):
						{
							System.out.println("Enter name of the player you want to add an event for : ");
							String name= scan.nextLine();
							event=new OwnGoal();
							observer=new Players(event);
							observer=new Users(event);
							observer=new Week(event);
							event.applayEvent(name, file_week);
							break;
						}
						default:
						{
							break;
						}
			        }
					break;
				}
				case ("6"):
				{
					System.out.println("Login : ");
					int index=user.LogedInUser();
					System.out.println("For which week ? (Week 1 OR Week 2 : )");
					String week=scan.nextLine();
					String file_week=week+".txt";
					int score=scoringOfWeek.Score(index,file_week);
					System.out.println("The score of a squad for a given game week = " + score + '\n');
					break;
				}
				default:
				{
					choose=false;
					break;
				}
			}
		}
	}
	}
