package Gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import turban.utils.ErrorHandler;
import turban.utils.ErrorLevel;

public class DancingFrame extends JFrame{
	
	DancingTextPanel dancingPanel;
	JPanel panel;
	JButton btnStart, btnStopp, btnStartUtil, btnStoppUtil;
	java.util.Timer tim;
	boolean timerStarted;
	
	public DancingFrame()
	{
		super("Das DancingTextPanel");
		dancingPanel = new DancingTextPanel();
		add(dancingPanel, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		add(panel, BorderLayout.SOUTH);
		
		// Button : Swing Timer
		btnStart = new JButton("Start Swing Timer");
		btnStopp = new JButton("Stopp Swing Timer");
		
		
		// Button : Util Timer		
		btnStartUtil = new JButton("Start Util Timer");
		btnStoppUtil = new JButton("Stopp Util Timer");
		panel.add(btnStart);
		panel.add(btnStartUtil);
		panel.add(btnStopp);
		panel.add(btnStoppUtil);
		
		final javax.swing.Timer timer=new Timer(100
			    , new ActionListener(){
						public void actionPerformed(ActionEvent e){
							dancingPanel.repaint();
						}
			      });
		
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				try{
					if(!timerStarted){
						timer.start();
						timerStarted = true;
					}
				}catch(Throwable ex){
					ErrorHandler.logException(ex,true,DancingFrame.class, "Achtung! Fehler beim starten des Swing Timers!");
				}
				
			}
		});
		
		btnStopp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					timer.stop();
					timerStarted = false;
				}catch(Throwable ex){
					ErrorHandler.logException(ex,true,DancingFrame.class, "Achtung! Fehler beim stoppen des Swing Timers!");
				}
				
			}
		});
		
		btnStartUtil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				try{
					if(!timerStarted){
						timerStarted = true;
					tim = new java.util.Timer();
					tim.schedule(new TimerTask() {
			
			@Override
			public void run() {
				try {
					dancingPanel.repaint();
					
				} catch (Exception e) {
					ErrorHandler.logException(e,true,DancingFrame.class, "Achtung! Fehler beim starten des Util Timers!");	
				}
				
			}
		},0,100);
					}
				}catch(Throwable ex){
					ErrorHandler.logException(ex,true,DancingFrame.class, "Achtung! Fehler beim starten des UtilTimers!");
				}
				
			}
		});
		
		btnStoppUtil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//
				try{
					tim.cancel();
					timerStarted = false;
				}catch(Throwable ex){
					ErrorHandler.logException(ex,true,DancingFrame.class, "Achtung! Fehler beim stoppen des Util Timers!");
				}
				
			}
		});
		
	}

	
	public static void main(String[] args) {
		

		try {
			DancingFrame hauptfenster = new DancingFrame();
			hauptfenster.setSize(400, 400);
			hauptfenster.setVisible(true);
			hauptfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zum sauberen Beenden

		} catch (Exception ex) {
			ErrorHandler.logError(ErrorLevel.WARN, false, DancingFrame.class, "Hier entsteht nun der Erste Eintrag ins Logfile");
		}
	}
}
