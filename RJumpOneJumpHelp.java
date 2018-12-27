package com.cmd.Runtime;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 作者 reading
 * 
 */
public class RJumpOneJumpHelp extends JFrame{
	private int x,y,x1,y1;
	private boolean flag;
	public static void main(String ages[]) {
		new RJumpOneJumpHelp();
	}
	public RJumpOneJumpHelp() {
		
		this.setTitle("挑一挑辅助");
		this.setSize(290,600);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setOpacity(0.4f);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlabel=new JLabel();
		this.add(jlabel);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					System.out.println("点击了");
					if(flag) {
						x=e.getX();
						y=e.getY();
						flag=false;
					}else {
						x1=e.getX();
						y1=e.getY();
						flag=true;
						double $x=Math.abs(x-x1);
						double  $y=Math.abs(y-y1);
						double dis=Math.sqrt( $x* $x+ $y* $y);
						String path="E:\\vs\\";
						String cmd =path+"adb shell input touchscreen swipe 180 187 180 187 "+Math.round(dis*5);
						Runtime runtime = Runtime.getRuntime();
						try {
							Process exec = runtime.exec(cmd);
							System.out.println(cmd);
						
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
}
