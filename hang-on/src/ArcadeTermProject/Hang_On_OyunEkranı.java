package cse212_TermProject;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Hang_On_OyunEkraný extends JFrame{
	private static int timecounter=0;
	public Hang_On_OyunEkraný (String title){
		super(title);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Game game = new Game();
		
		/*Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				timecounter++;
				game.settime(timecounter);
				//System.out.println(game.gettime());
			}
			
		};
		
		timer.schedule(task,0,1000);*/
		
		
		Hang_On_OyunEkraný ekran = new Hang_On_OyunEkraný("CSE212 - Hang on");
		ekran.setResizable(false);
		ekran.setFocusable(false);
		ekran.setSize(800,600);
		ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		game.requestFocus();
		game.addKeyListener(game);
		game.setFocusable(true);
		game.setFocusTraversalKeysEnabled(false);
		
		ekran.add(game); // jpanelimi jframe e ekledim..
		ekran.setVisible(true);
		
		
		
		
		
	}

}
