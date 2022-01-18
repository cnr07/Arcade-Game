package cse212_TermProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*import sun.audio.AudioPlayer;
import sun.audio.AudioStream;*/


public class Game extends JPanel implements KeyListener,ActionListener{
	//1000 ms =1sn.
	Timer timer = new Timer();
	Timer timer2 = new Timer();
	Timer timer5 = new Timer();
	private static int time=0;//totaltime.
	private static int timecounter=0;
	private static int timecounter2=0;
	private static int laptime=60;
	private static int counterdown=0;
	private static int score=0;
	private static int speed=0;
	private String name;
	private String pw;
	private String logname,logpw;
	private static String realname="";
	private int islogin=0;
	private static int isup=0;
	private static int isup1=0;
	private static int isup2=0;
	private static int timecounterr=0;
	private static int islrup=0;
	private static int islrdown=0;
	private static int select=0;
	private static int runsec=0;
	private static int road=0;
	private static int isentered=0;
	private static int isentered2=0;
	private static int isentered3=0;
	private static int isentered4=0;
	private static int caner=0;
	private static int aa=0;
	
	private static int ispause=0;
	private static int isrestart=0;
	private static int kaza=0;
	private static int stage=1;
	
	
	private int ourmotorX=350;
	private int ourmotorY=429;
	private int ourmotordirX=50;
	private static String imagename;
	private static String imagename2="a";
	private static int a=0;
	
	private int racer1X=200;
	private int racer2X=250;
	private int racer3X=300;
	private int racer4X=350;
	private int racer5X=400;
	private int racer6X=450;
	private int racer7X=500;
	private int racer1Y=310;
	private int racer2Y=310;
	private int racer3Y=310;
	private int racer4Y=310;
	private int racer5Y=310;
	private int racer6Y=310;
	private int racer7Y=310;
	
	LinkedList<Integer> gamecontrols = new LinkedList<Integer>();
	static int indexgamecontrols=0;
	LinkedList<String> highstr = new LinkedList<String>();
	static int indexhighstr=0;
	LinkedList<Integer> highint = new LinkedList<Integer>();
	static int indexhighint=0;
	
	
	private BufferedImage image;//menu
	private BufferedImage image1;//bizim motor
	private BufferedImage image2;// yarýscý1
	private BufferedImage image3;// yarýscý2
	private BufferedImage image4;// yarýscý3
	private BufferedImage image5;// yarýscý4
	private BufferedImage image6;// yarýscý5
	private BufferedImage image7;// yarýscý6
	private BufferedImage image8;// yarýscý7
	
	
	
	JMenuBar menu = new JMenuBar();
    JMenu game1 = new JMenu("Game");
    JMenu user1 = new JMenu("User");
    JMenu quit1 = new JMenu("Quit");
    JMenuItem exit = new JMenuItem("Quit The Game!");
    JMenuItem login = new JMenuItem("Login");
    JMenuItem register = new JMenuItem("Register");
    JMenuItem start = new JMenuItem("Start");
    JMenuItem pause = new JMenuItem("Pause");
    JMenuItem restart = new JMenuItem("Restart");
    JMenuItem highscore = new JMenuItem("High Score");
    
    JLabel Score = new JLabel();
    JLabel Laptime = new JLabel();
    JLabel Speed = new JLabel();
    JLabel Stage = new JLabel();
    JLabel Top = new JLabel();
    
    
	
	
    public Game () {
    	add(Laptime);
        Laptime.setVisible(true);
        Laptime.setLayout(null);
        
        add(Stage);
        Stage.setVisible(true);
        Stage.setLayout(null);
    	
		add(menu);
		menu.add(game1);
		menu.add(user1);
		menu.add(quit1);
        exit.addActionListener(this);
        login.addActionListener(this);
        register.addActionListener(this);
        start.addActionListener(this);
        pause.addActionListener(this);
        restart.addActionListener(this);
        highscore.addActionListener(this);
        quit1.add(exit);
        user1.add(register);
        user1.add(login);
        user1.add(highscore);
        game1.add(start);
        game1.add(pause);
        game1.add(restart);
		
        
        add(Score);
        Score.setVisible(true);
        Score.setLayout(null);
        /*Score.setText("SCORE: "+score);
        Score.setForeground(Color.red);*/
        
        
        add(Speed);
        Speed.setVisible(true);
        Speed.setLayout(null);
        
        
        
        add(Top);
        Top.setVisible(true);
        Top.setLayout(null);
        
        
        
        
  
        
        
		try {
			image = ImageIO.read(new FileImageInputStream(new File("hangon_menu.png")));
			//image = ImageIO.read(new FileImageInputStream(new File("startroad.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		try {
			image1 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image3 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image4 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image5 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image6 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image7 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image8 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBackground(Color.BLACK); 
		
		
	}
    public int gettime() {
    	return time;
    }
    public void settime(int newtime) {
    	this.time=newtime;
    }
    
    public void playSoundhýzlý() {
    	
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("hýzlý.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            
            clip.start();
            aa++;
            if(aa%10==0) {
            	clip.close();
            }
            
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public void playSoundyavas() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("yavaþ.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0,26,image.getWidth(),image.getHeight(),this);
		g.drawImage(image1, ourmotorX, ourmotorY, image1.getWidth(), image1.getHeight(),this);
		g.drawImage(image2, racer1X, racer1Y, image2.getWidth(), image2.getHeight(),this);
		g.drawImage(image3, racer2X, racer2Y, image3.getWidth(), image3.getHeight(),this);
		g.drawImage(image4, racer3X, racer3Y, image4.getWidth(), image4.getHeight(),this);
		g.drawImage(image5, racer4X, racer4Y, image5.getWidth(), image5.getHeight(),this);
		g.drawImage(image6, racer5X, racer5Y, image6.getWidth(), image6.getHeight(),this);
		g.drawImage(image7, racer6X, racer6Y, image7.getWidth(), image7.getHeight(),this);
		g.drawImage(image8, racer7X, racer7Y, image8.getWidth(), image8.getHeight(),this);
		
	}
	@Override
	public void repaint() {
		super.repaint();
	}
	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int c = e.getKeyCode();
		
		//System.out.println(c);
		
		gamecontrols.add(indexgamecontrols, c);
		indexgamecontrols++; 
		
		if(c==KeyEvent.VK_UP && ispause==0) {
			//playSoundhýzlý();
			
			  
			if(isup2==1) {
				this.racersgo();
				this.racersgo();
				this.racersgo();
				this.racersgo();
				this.racersgo();
				this.racersgo();
				this.racersgo();
			}
			
			this.racersgo();
			this.racersgo();
			this.racersgo();
			this.racersgo();
			this.racersgo();
			this.racersgo();
			this.racersgo();
			
			
			
			
			speed++;
			if(speed>=299) {
				speed=299;
			}
			Speed.setText("SPEED: "+speed);
	        Speed.setForeground(Color.white);
	        Speed.repaint();
	        score+=speed*time;
			Score.setText("SCORE: "+score);
	        Score.setForeground(Color.red);
	        Score.repaint();
			
			if(isup==0 && isup1==0) {
				
				timecounterr++;
				if(timecounterr%30==0) {
					time++;
					laptime--;
					
					
					//this.playSoundhýzlý();
				}
				
		        Laptime.setText("LAPTIME: "+laptime);
				Laptime.setForeground(Color.yellow);
				Laptime.repaint();
				//System.out.println("xd"+time);
			}
			
			
			while(true) {
				if(imagename.contentEquals("startroad.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz1.png";
					break;
				}
				if(imagename.contentEquals("yoldüz1.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz2.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz2.png";
					break;
				}
				if(imagename.contentEquals("yoldüz2.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz1.png";
					break;
				}
			}
				
		}
		if(c==KeyEvent.VK_LEFT && ispause==0) {
			if(indexgamecontrols>1) {
				if(gamecontrols.get(indexgamecontrols-2)==38) {
					islrdown=0;
					islrup=1;
				}
				if(gamecontrols.get(indexgamecontrols-2)==40) {
					islrup=0;
					islrdown=1;
				}
			}
			
			/*while(true) {
				if(imagename.contentEquals("startroad.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz1.png";
					break;
				}
				if(imagename.contentEquals("yoldüz1.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz2.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz2.png";
					break;
				}
				if(imagename.contentEquals("yoldüz2.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz1.png";
					break;
				
				}
				
			}*/
			ourmotorX-=ourmotordirX;
			
		
		}
		if(c==KeyEvent.VK_RIGHT && ispause==0) {
			if(indexgamecontrols>1) {
				if(gamecontrols.get(indexgamecontrols-2)==38) {
					islrdown=0;
					islrup=1;
				}
				if(gamecontrols.get(indexgamecontrols-2)==40) {
					islrup=0;
					islrdown=1;
				}
			}
			
			/*while(true) {
				if(imagename.contentEquals("startroad.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz1.png";
					break;
				}
				if(imagename.contentEquals("yoldüz1.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz2.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz2.png";
					break;
				}
				if(imagename.contentEquals("yoldüz2.png")) {
					try {
						image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagename="yoldüz1.png";
					break;
				
				}
				
			}*/
			ourmotorX+=ourmotordirX;
			
		
		}
		if(c==KeyEvent.VK_DOWN && ispause==0) {
			timer.cancel();
			
			counterdown++;
			speed--;
			if(speed<=55) {
				speed=55;
			}
			Speed.setText("SPEED: "+speed);
	        Speed.setForeground(Color.white);
	        Speed.repaint();
	        if(time==0) {
	        	time++;
	        }
	        
	        if(counterdown%30==0 && isup1==0) {
	        	time++;
				laptime--;
				Laptime.setText("LAPTIME: "+laptime);
				Laptime.setForeground(Color.yellow);
				Laptime.repaint();
				score+=speed*time;
				Score.setText("SCORE: "+score);
		        Score.setForeground(Color.red);
		        Score.repaint();
	        }
	        if(counterdown%15==0) {
	        	while(true) {
					if(imagename.contentEquals("startroad.png")) {
						try {
							image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						imagename="yoldüz1.png";
						break;
					}
					if(imagename.contentEquals("yoldüz1.png")) {
						try {
							image = ImageIO.read(new FileImageInputStream(new File("yoldüz2.png")));
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						imagename="yoldüz2.png";
						break;
					}
					if(imagename.contentEquals("yoldüz2.png")) {
						try {
							image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						imagename="yoldüz1.png";
						break;
					
					}
					
				}
	        }
			//System.out.println("xd"+time);
		}
		
		
		
		
		
		
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int c=e.getKeyCode();
		
		if( ((c==KeyEvent.VK_UP && isup==0) || (islrup==1 && isup==0) ) && ispause==0 ) {
			//playSoundyavas();
			timecounter=0;
			timer2.cancel();
			
			timer = new Timer();
			
			
			TimerTask task2 = new TimerTask() {
		    	
		    	

				@Override
				public void run() {
					speed++;
					if(speed>=299) {
						speed=299;
					}
					Speed.setText("SPEED: "+speed);
			        Speed.setForeground(Color.white);
			        Speed.repaint();
					score+=speed*time;
					Score.setText("SCORE: "+score);
			        Score.setForeground(Color.red);
			        Score.repaint();
					timecounter++;
					if(timecounter%20==0) {
						time++;
						laptime--;
						Laptime.setText("LAPTIME: "+laptime);
						Laptime.setForeground(Color.yellow);
						Laptime.repaint();
						
						//System.out.println(time);
						//System.out.println(laptime);
					}
					
					
					while(true) {
						if(imagename.contentEquals("startroad.png")) {
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
								repaint();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imagename="yoldüz1.png";
							break;
						}
						if(imagename.contentEquals("yoldüz1.png")) {
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yoldüz2.png")));
								repaint();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imagename="yoldüz2.png";
							break;
						}
						if(imagename.contentEquals("yoldüz2.png")) {
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
								repaint();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imagename="yoldüz1.png";
							break;
						}
					}
					
					
					
				}
				
			};
			
			timer.scheduleAtFixedRate(task2,0,50);
			
			
			isup=1;
			isup1=0;
			
		}
		if((c==KeyEvent.VK_DOWN && isup1==0  || (islrdown==1 && isup1==0))&& ispause==0 ) {
			timecounter2=0;
			timer.cancel();
			timer2= new Timer();
			//playSoundyavas();
			
			
			TimerTask task3 = new TimerTask() {

				@Override
				public void run() {
					speed--;
					if(speed<=55) {
						speed=55;
					}
					Speed.setText("SPEED: "+speed);
			        Speed.setForeground(Color.white);
			        Speed.repaint();
					//System.out.println(speed);
					timecounter2++;
					if(timecounter2%2==0) {
						time++;
						laptime--;
						Laptime.setText("LAPTIME: "+laptime);
						Laptime.setForeground(Color.yellow);
						Laptime.repaint();
						score+=speed*time;
						Score.setText("SCORE: "+score);
				        Score.setForeground(Color.red);
				        Score.repaint();
				        
						//System.out.println("xd"+time);
					}
					
					while(true) {
						if(imagename.contentEquals("startroad.png")) {
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
								repaint();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imagename="yoldüz1.png";
							break;
						}
						if(imagename.contentEquals("yoldüz1.png")) {
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yoldüz2.png")));
								repaint();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imagename="yoldüz2.png";
							break;
						}
						if(imagename.contentEquals("yoldüz2.png")) {
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yoldüz1.png")));
								repaint();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imagename="yoldüz1.png";
							break;
						}
					}
					
					
					
				}
				
			};
			
			timer2.scheduleAtFixedRate(task3, 0, 500);
			
			
			isup1=1;
			isup=0;
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	PrintWriter yazma;
	PrintWriter yazma2;
	PrintWriter yazma3;
	File dosya = new File("RegisterGame.txt");
	File dosya2 = new File("HighScores.txt");
	File dosya3 = new File("realhighscores.txt");
	String Kelimeler3="";
	String Kelimeler="";
	String Kelimeler2="";
	String isname="";
	String ispw="";
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Object kod = event.getSource();
		Object kod2 = event.getActionCommand();
		//System.out.println(kod2);
        if(kod == exit){
            System.exit(0);
            
        }
        if(kod == register) {
        	JOptionPane.showMessageDialog(null,"Register ' e týkladýnýz Kayýt olmak zorundasýnýz..", "Warning",JOptionPane.WARNING_MESSAGE);
        	try {
        		Scanner sc =new Scanner(dosya);
        		while(sc.hasNext()) {
        			Kelimeler += sc.next();
        			Kelimeler += " ";
        		}
        		//C:/Users/User/Desktop/RegisterGame.txt
				yazma=new PrintWriter("RegisterGame.txt");
				
				while(true) {
					name=JOptionPane.showInputDialog("Enter Name:");
					
					if(name.contentEquals("") || name.contentEquals(" ")) {
						JOptionPane.showMessageDialog(null,"Name boþ BIRAKILAMAZ!", "Error",JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						
						break;
					}
				}
				while(true) {
					pw=JOptionPane.showInputDialog("Enter Password:");
					if(pw.contentEquals("") || pw.contentEquals(" ")) {
						JOptionPane.showMessageDialog(null,"Password boþ BIRAKILAMAZ!", "Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						break;
					}
				}
				
				//System.out.println("sda"+name+"asd");
				
				yazma.println(name+" "+pw);
				
				
				yazma.println(Kelimeler);
				Kelimeler="";
				
				
				
				//System.out.println(Kelimeler);
				yazma.close();
				sc.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
				JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				//System.err.println("HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
			}
        }
        if(kod==highscore) {
        	try {
        		String m="";
        		String n="";
        		String n1="";
        		int r=0;
        		int r1=0;
        		int r2=0;
				Scanner sc0 =new Scanner(dosya3);
				while(sc0.hasNext()) {
					n=sc0.next();
					r=Integer.parseInt(sc0.next());
					//System.out.println(n+r);
					highstr.add(indexhighstr, n);
					indexhighstr++;	
					highint.add(indexhighint, r);
					indexhighint++;
					if(indexhighstr>1) {
						if(highstr.get(indexhighstr-2).contentEquals(highstr.get(indexhighstr-1))) {
							highstr.remove(indexhighstr-1);
							indexhighstr--;
							highint.remove(indexhighint-1);
							indexhighint--;
						}
					}
					 
					
					//m+=sc0.next()+" "+sc0.nextInt()+"---";
					
					//JOptionPane.showMessageDialog(null,m, "High Scores!",JOptionPane.INFORMATION_MESSAGE);
				}
				for(int i = 0;i<indexhighstr;i++) {
					m+=highstr.get(i)+"-->"+highint.get(i)+"\n";
				}
				
				JOptionPane.showMessageDialog(null,m, "High Scores!",JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			}
        	
        }
        if(kod == login) {
        	
        	islogin=0;
        	int isok=0;
        	logname=JOptionPane.showInputDialog("Name:");
        	
        	logpw=JOptionPane.showInputDialog("Password:");
        	try {
				Scanner sc1 = new Scanner(dosya);
				while(sc1.hasNext()) {
					if(sc1.next().contentEquals(logname)) {
						if(sc1.next().contentEquals(logpw)) {
							
							isok=1;
							break;
						}
						
					}
					
				}
				if(isok==0) {
					
					JOptionPane.showMessageDialog(null,"Üye Giriþi Hatalý !! Tekrar Üye Giriþi Yapýn!", "Warning",JOptionPane.WARNING_MESSAGE);	
				}
				if(isok==1) {
					JOptionPane.showMessageDialog(null,"giriþ baþarýlý ");
					
					isok=0;
					islogin=1;
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			}
        	
        	
        	
        	
        }
        if(kod==start) {
        	if(islogin==0) {
        		JOptionPane.showMessageDialog(null,"Önce Giriþ Yapýn!!");
        	}
        	else {
        		JOptionPane.showMessageDialog(null,"Oyun Baþlamasý için yukarý ok tuþuna basýn(^),gaz(^),fren(v),sað(>),sol(<), Name: "+logname+" Password: "+logpw);
        		realname=logname;
        		//System.out.println(realname+"xd");
        		if(ispause==0) {
        			setBackground(Color.BLUE);
            		
            		try {
    					image = ImageIO.read(new FileImageInputStream(new File("startroad.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		imagename="startroad.png";
            		try {
    					image1 = ImageIO.read(new FileImageInputStream(new File("motorumuzdüzyeni.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		repaint();
        		}
        		
        		
        		if(ispause==1) {
        			ispause=0;
        			isup2=1;
        			select=0;
            		isup=0;
            		isup1=0;
            		timer = new Timer();
            		timer2=new Timer();
            		timer5=new Timer();
        		}
        		
        		
        		
        	}
        }
        if(kod==pause ) {
        	//kaza=0;
        	isup2=0;
        	ispause=1;
        	timer2.cancel();
			timer.cancel();
			timer5.cancel();
			//timer = new Timer();
        }
        if(kod==restart) {
        	caner=0;
        	racer1X=200;
        	racer2X=250;
        	racer3X=300;
        	racer4X=350;
        	racer5X=400;
        	racer6X=450;
        	racer7X=500;
        	racer1Y=310;
        	racer2Y=310;
        	racer3Y=310;
        	racer4Y=310;
        	racer5Y=310;
        	racer6Y=310;
        	racer7Y=310;
        	isup1=0;
        	isup=0;
        	time=0;
        	timecounter=0;
        	timecounter2=0;
        	laptime=60;
        	counterdown=0;
        	score=0;
        	speed=0;
        	timecounterr=0;
        	islrup=0;
        	islrdown=0;
        	select=0;
        	runsec=0;
        	isentered=0;
        	isentered2=0;
        	isentered3=0;
        	isentered4=0;
        	stage=1;
        	
        	isup2=0;
        	isrestart=1;
        	timer2.cancel();
			timer.cancel();
			timer5.cancel();
			
			if(islogin==0) {
        		JOptionPane.showMessageDialog(null,"Önce Giriþ Yapýn!!");
        	}
        	else {
        		JOptionPane.showMessageDialog(null,"Oyun Baþlamasý için yukarý ok tuþuna basýn(^),gaz(^),fren(v),sað(>),sol(<), Name: "+logname+" Password: "+logpw);
        		if(ispause==0 || isrestart==1) {
        			
        			
        			setBackground(Color.BLUE);
            		
            		try {
    					image = ImageIO.read(new FileImageInputStream(new File("startroad.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		imagename="startroad.png";
            		try {
    					image1 = ImageIO.read(new FileImageInputStream(new File("motorumuzdüzyeni.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		try {
    					image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		repaint();
        		}
        		
        		
        		if(ispause==1) {
        			ispause=0;
        			isup2=1;
        			select=0;
            		isup=0;
            		isup1=0;
            		timer = new Timer();
            		timer2=new Timer();
            		timer5=new Timer();
        		}
        		
        		
        		
        	}
			
        }
        
		
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void racersgo() {
		Stage.setText("STAGE: "+stage);
		Stage.setForeground(Color.MAGENTA);
		Stage.repaint();
		if(select==7) {
			timer5.cancel();
			try {
				image2 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image3 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image4 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image5 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image6 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image7 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image8 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			timer5 = new Timer();
			
			
			TimerTask task5 = new TimerTask() {
		    	
		    	

				@Override
				public void run() {
					
					runsec++;
					//System.out.println(runsec);
					if(ourmotorX<=50 || ourmotorX>=660) {
						
						kaza=1;
			        	isup2=0;
			        	ispause=1;
			        	timer2.cancel();
						timer.cancel();
						timer5.cancel();
						try {
							image2 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image3 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image4 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image5 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image6 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image7 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image8 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							
			        		Scanner sc2 =new Scanner(dosya2);
			        		while(sc2.hasNext()) {
			        			
			        			Kelimeler2+=sc2.next();
			        			Kelimeler2+=" ";
			       
			        		}
			        		//C:/Users/User/Desktop/RegisterGame.txt
							yazma2=new PrintWriter("HighScores.txt");
							
							
							
							//System.out.println("sda"+name+"asd");
							
							yazma2.println(realname+" "+score);
							//realname="";
							
							yazma2.println(Kelimeler2);
							Kelimeler2="";
							yazma2.close();
							sc2.close();
							
							//yazma3=new PrintWriter("HighScores.txt");
							Scanner sc3 =new Scanner(dosya2);
							while(sc3.hasNext()) {
								if(sc3.next().contentEquals(realname)) {
									
									
									int a = Integer.parseInt(sc3.next());
									
									if(score>=a) {
										
										score=score;
										//System.out.println(score+realname);
										
									}
									else {
										
										score=a;
										//System.out.println(score+"asd"+realname);
										
									}
								}
								
							}
							sc3.close();
							//yazma3.close();
							Scanner sc4 = new Scanner(dosya3);
							while(sc4.hasNext()) {
			        			
			        			Kelimeler3+=sc4.next();
			        			Kelimeler3+=" ";
			       
			        		}
							yazma3=new PrintWriter("realhighscores.txt");
							
							yazma3.println(realname+" "+score);
							yazma3.println(Kelimeler3);
							Kelimeler3="";
							yazma3.close();
							sc4.close();
							
							
							
							//System.out.println(Kelimeler);
							
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							//JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
							JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
							//System.err.println("HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
						}
						
						
						
						while(true) {
							caner++;
							if(caner>=0 && caner<250) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza1.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=250 && caner<500) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza2.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=500 && caner<750) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza3.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=750 && caner<1000) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza4.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=1000 && caner<1250) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza5.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=1250 && caner<1500) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza6.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=1500 && caner<1750) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza7.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=1750 && caner<2000) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza8.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=2000 && caner<2250) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("kaza9.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								break;
							}
						}
					
						JOptionPane.showMessageDialog(null,"Yoldaki beyaz bölümden uzak durarak kazadan kaçýnabilirsin.Þimdi istersen menuden tekrar baslat. ", "Yoldan Çýkma Kazasý",JOptionPane.ERROR_MESSAGE);
					}
					if(((ourmotorX-racer1X<=50 && ourmotorX-racer1X>=-50) && ourmotorY==racer1Y) ||((ourmotorX-racer2X<=50 && ourmotorX-racer2X>=-50) && ourmotorY==racer2Y) ||((ourmotorX-racer3X<=50 && ourmotorX-racer3X>=-50) && ourmotorY==racer3Y) ||((ourmotorX-racer4X<=50 && ourmotorX-racer4X>=-50) && ourmotorY==racer4Y) ||((ourmotorX-racer5X<=50 && ourmotorX-racer5X>=-50) && ourmotorY==racer5Y) ||((ourmotorX-racer6X<=50 && ourmotorX-racer6X>=-50) && ourmotorY==racer6Y) ||((ourmotorX-racer7X<=50 && ourmotorX-racer7X>=-50) && ourmotorY==racer7Y)||laptime==0) {
						kaza=1;
			        	isup2=0;
			        	ispause=1;
			        	timer2.cancel();
						timer.cancel();
						timer5.cancel();
						try {
							image2 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image3 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image4 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image5 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image6 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image7 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image8 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							
			        		Scanner sc2 =new Scanner(dosya2);
			        		while(sc2.hasNext()) {
			        			
			        			Kelimeler2+=sc2.next();
			        			Kelimeler2+=" ";
			       
			        		}
			        		//C:/Users/User/Desktop/RegisterGame.txt
							yazma2=new PrintWriter("HighScores.txt");
							
							
							
							//System.out.println("sda"+name+"asd");
							
							yazma2.println(realname+" "+score);
							//realname="";
							
							yazma2.println(Kelimeler2);
							Kelimeler2="";
							yazma2.close();
							sc2.close();
							
							//yazma3=new PrintWriter("HighScores.txt");
							Scanner sc3 =new Scanner(dosya2);
							while(sc3.hasNext()) {
								if(sc3.next().contentEquals(realname)) {
									
									
									int a = Integer.parseInt(sc3.next());
									
									if(score>=a) {
										
										score=score;
										//System.out.println(score+realname);
										
									}
									else {
										
										score=a;
										//System.out.println(score+"asd"+realname);
										
									}
								}
								
							}
							sc3.close();
							//yazma3.close();
							Scanner sc4 = new Scanner(dosya3);
							while(sc4.hasNext()) {
			        			
			        			Kelimeler3+=sc4.next();
			        			Kelimeler3+=" ";
			       
			        		}
							yazma3=new PrintWriter("realhighscores.txt");
							
							yazma3.println(realname+" "+score);
							yazma3.println(Kelimeler3);
							Kelimeler3="";
							yazma3.close();
							sc4.close();
							
							
							
							//System.out.println(Kelimeler);
							
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							//JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
							JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
							//System.err.println("HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
						}
						
						
						
						while(true) {
							caner++;
							if(caner>=0 && caner<250) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma1.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=250 && caner<500) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma2.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=500 && caner<750) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma3.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=750 && caner<1000) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma4.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=1000 && caner<1250) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma5.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								//break;
							}
							if(caner>=1250 && caner<1500) {
								try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma6.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								repaint();
								break;
							}
						}
					 
						JOptionPane.showMessageDialog(null,"Yoldaki diðer yarýþçýlardan uzak durarak kazadan kaçýnabilirsin.Laptime bitmeden check point e varabilmek için hýzlý git.Þimdi istersen menuden tekrar baslat. ", "Çarpýþma Kazasý yada Süre Bitti",JOptionPane.ERROR_MESSAGE);
					}
					
					//road=150*60;
					//System.out.println(road);
					//System.out.println(runsec*speed);
					if(runsec>=0 && runsec<30) {
						if(runsec%5==0 && runsec<16) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer1X=200;
							racer1Y=200;
							repaint();
						}
						if(runsec%2==0 && runsec<11) {
							try {
								image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer7X=500;
							racer4Y=200;
							repaint();
						}
						if(runsec%6==0 && runsec<19) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer1X=200;
							racer1Y=250;
							repaint();
						}
						if(runsec%3==0 && runsec<16) {
							try {
								image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer7X=500;
							racer4Y=250;
							repaint();
						}
						if(runsec%7==0 && runsec<22) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer1X=200;
							racer1Y=429;
							repaint();
						}
						if(runsec%4==0 && runsec<21) {
							try {
								image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer7X=500;
							racer4Y=429;
							repaint();
						}
						if(runsec%8==0) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer1X=200;
							racer1Y=200;
							repaint();
						}
						if(runsec%5==0) {
							try {
								image5 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer7X=500;
							racer4Y=200;
							repaint();
						}
					}
					if(runsec>=30 && runsec<80) {
						if(runsec%10==0) {
							try {
								image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer6X=450;
							//racer3X=300;
							racer6Y=200;
							racer3Y=200;
							repaint();
						}
						if(runsec%11==0) {
							try {
								image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer6X=450;
							//racer3X=300;
							racer6Y=250;
							racer3Y=250;
							repaint();
						}
						if(runsec%12==0) {
							try {
								image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer6X=450;
							//racer3X=300;
							racer6Y=429;
							racer3Y=429;
							repaint();
						}
						if(runsec%13==0) {
							try {
								image4 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image7 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer6X=450;
							//racer3X=300;
							racer6Y=200;
							racer3Y=200;
							repaint();
						}
					}
					if(runsec>=80) {
						if(runsec%20==0) {
							try {
								image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer5X=400;
							//racer2X=250;
							racer5Y=200;
							racer2Y=200;
							repaint();
						}
						if(runsec%5==0) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							racer1Y=200;
							repaint();
						}
						if(runsec%10==0) {
							try {
								image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer4X=350;
							racer7Y=200;
							
							repaint();
						}
						if(runsec%6==0) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							racer1Y=250;
							repaint();
						}
						if(runsec%21==0) {
							try {
								image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer5X=400;
							//racer2X=250;
							racer5Y=250;
							racer2Y=250;
							repaint();
						}
						if(runsec%11==0) {
							try {
								image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer4X=350;
							racer7Y=250;
							//racer7Y=250;
							repaint();
						}
						if(runsec%7==0) {
							
							if(!((racer1X-racer2X!=50 || racer1X-racer2X!=-50)||(racer1X-racer5X!=50 || racer1X-racer5X!=-50)||(racer1X-racer7X!=50 || racer1X-racer7X!=-50))) {
								try {
									image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								racer1Y=429;
								repaint();
							}
							
						}
						if(runsec%22==0) {
							try {
								image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer5X=400;
							//racer2X=250;
							racer5Y=429;
							racer2Y=429;
							repaint();
						}
						if(runsec%12==0) {
							try {
								image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmax.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer4X=350;
							racer7Y=429;
							//racer7Y=429;
							repaint();
						}
						if(runsec%8==0) {
							try {
								image2 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							racer1Y=200;
							repaint();
						}
						if(runsec%23==0) {
							try {
								image6 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								image3 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer5X=400;
							//racer2X=250;
							racer5Y=200;
							racer2Y=200;
							repaint();
						}
						if(runsec%13==0) {
							try {
								image8 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//racer4X=350;
							racer7Y=200;
							
							repaint();
						}
					}
					
					
					
					if((runsec*speed)>9000 && isentered==0) {
						int hold=0;
						
						while(hold<60) {
							Stage.setText("STAGE: "+stage);
							Stage.setForeground(Color.MAGENTA);
							Stage.repaint();
							stage=2;
							laptime=60;
							hold++;
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yolcheck.png")));
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							repaint();
						}
						
						isentered=1;
						
					}
					if((runsec*speed)>20000 && isentered2==0) {
						int hold=0;
						
						while(hold<60) {
							Stage.setText("STAGE: "+stage);
							Stage.setForeground(Color.MAGENTA);
							Stage.repaint();
							stage=3;
							laptime=60;
							hold++;
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yolcheck.png")));
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							repaint();
						}
						
						isentered2=1;
						
					}
					if((runsec*speed)>32000 && isentered3==0) {
						int hold=0;
						
						while(hold<60) {
							Stage.setText("STAGE: "+stage);
							Stage.setForeground(Color.MAGENTA);
							Stage.repaint();
							stage=4;
							laptime=60;
							hold++;
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yolcheck.png")));
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							repaint();
						}
						
						isentered3=1;
						
					}
					if((runsec*speed)>47000 && isentered4==0) {//finish
						int hold=0;
						
						while(hold<60) {
							Stage.setText("STAGE: "+stage);
							Stage.setForeground(Color.MAGENTA);
							Stage.repaint();
							stage=4;
							laptime=60;
							hold++;
							try {
								image = ImageIO.read(new FileImageInputStream(new File("yolfinish.png")));
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							repaint();
						}
						
						isentered4=1;
						kaza=1;
			        	isup2=0;
			        	ispause=1;
			        	timer2.cancel();
						timer.cancel();
						timer5.cancel();
						try {
							image2 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image3 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image4 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image5 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image6 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image7 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							image8 = ImageIO.read(new FileImageInputStream(new File("boþ.png")));
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							
			        		Scanner sc2 =new Scanner(dosya2);
			        		while(sc2.hasNext()) {
			        			
			        			Kelimeler2+=sc2.next();
			        			Kelimeler2+=" ";
			       
			        		}
			        		//C:/Users/User/Desktop/RegisterGame.txt
							yazma2=new PrintWriter("HighScores.txt");
							
							
							
							//System.out.println("sda"+name+"asd");
							
							yazma2.println(realname+" "+score);
							//realname="";
							
							yazma2.println(Kelimeler2);
							Kelimeler2="";
							yazma2.close();
							sc2.close();
							
							//yazma3=new PrintWriter("HighScores.txt");
							Scanner sc3 =new Scanner(dosya2);
							while(sc3.hasNext()) {
								if(sc3.next().contentEquals(realname)) {
									
									
									int a = Integer.parseInt(sc3.next());
									
									if(score>=a) {
										
										score=score;
										//System.out.println(score+realname);
										
									}
									else {
										
										score=a;
										//System.out.println(score+"asd"+realname);
										
									}
								}
								
							}
							sc3.close();
							//yazma3.close();
							Scanner sc4 = new Scanner(dosya3);
							while(sc4.hasNext()) {
			        			
			        			Kelimeler3+=sc4.next();
			        			Kelimeler3+=" ";
			       
			        		}
							yazma3=new PrintWriter("realhighscores.txt");
							
							yazma3.println(realname+" "+score);
							yazma3.println(Kelimeler3);
							Kelimeler3="";
							yazma3.close();
							sc4.close();
							
							
							
							//System.out.println(Kelimeler);
							
							
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							//JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
							JOptionPane.showMessageDialog(null,"HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
							//System.err.println("HATALI DÝRECT GÝRÝLÝ !! "+e.getMessage());
						}
						
						
						
						while(true) {
							caner++;
							if(caner>=0 && caner<250) {
								/*try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma1.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}*/
								
								repaint();
								//break;
							}
							if(caner>=250 && caner<500) {
								/*try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma2.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}*/
								
								repaint();
								//break;
							}
							if(caner>=500 && caner<750) {
								/*try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma3.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}*/
								
								repaint();
								//break;
							}
							if(caner>=750 && caner<1000) {
								/*try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma4.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}*/
								
								repaint();
								//break;
							}
							if(caner>=1000 && caner<1250) {
								/*try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma5.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}*/
								
								repaint();
								//break;
							}
							if(caner>=1250 && caner<1500) {
								/*try {
									image1 = ImageIO.read(new FileImageInputStream(new File("çarpma6.png")));
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}*/
								
								repaint();
								break;
							}
						}
					
						JOptionPane.showMessageDialog(null,"Tebrikler iþte skorun:"+score, "TEBRÝKLER OYUN BÝTTÝ",JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					
				}
				
			};
			select=8;
			timer5.scheduleAtFixedRate(task5,0,1000);
		}
		else if(select!=8) {
			try {
				image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýortadüz.png")));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			while(true) {
				if(select==0) {
					racer1Y-=30;
					racer2Y-=30;
					racer3Y-=30;
					racer4Y-=30;
					racer5Y-=30;
					racer6Y-=30;
					racer7Y-=30;
					
					racer1X+=15;
					racer2X+=15;
					racer3X+=15;
					racer4X+=15;
					racer5X+=15;
					racer6X+=15;
					racer7X+=15;
					select=1;
					repaint();
					break;
				}
				if(select==1) {
					//racer1Y-=30;
					racer2Y-=10;
					racer3Y-=20;
					racer4Y-=26;
					racer5Y-=20;
					racer6Y-=10;
					//racer7Y-=30;
					select=2;
					repaint();
					break;
				}
				if(select==2) {
					//racer1Y-=30;
					racer2Y-=10;
					racer3Y-=20;
					racer4Y-=26;
					racer5Y-=20;
					racer6Y-=10;
					//racer7Y-=30;
					select=3;
					repaint();
					break;
				}
				if(select==3) {
					//racer1Y-=30;
					racer2Y-=10;
					racer3Y-=20;
					racer4Y-=26;
					racer5Y-=20;
					racer6Y-=10;
					//racer7Y-=30;
					select=4;
					repaint();
					break;
				}
				if(select==4) {
					try {
						image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					select=5;
					repaint();
					break;
				}
				if(select==5) {
					try {
						image2 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image3 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image4 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image5 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image6 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image7 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image8 = ImageIO.read(new FileImageInputStream(new File("yarýscýdüzmin.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					racer1Y=200;
					racer2Y=200;
					racer3Y=200;
					racer4Y=200;
					racer5Y=200;
					racer6Y=200;
					racer7Y=200;
					
					racer1X=305;
					racer2X=325;
					racer3X=345;
					racer4X=365;
					racer5X=385;
					racer6X=405;
					racer7X=425;
					select=6;
					repaint();
					break;
				}
				if(select==6) {
					try {
						image2 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image3 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image4 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image5 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image6 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image7 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						image8 = ImageIO.read(new FileImageInputStream(new File("boþmavi.png")));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					racer1Y=150;
					racer2Y=150;
					racer3Y=150;
					racer4Y=150;
					racer5Y=150;
					racer6Y=150;
					racer7Y=150;
					select=7;
					repaint();
					break;
				}
				
				
				
			}
		}
		
		
		
		
	}
	
	
}
