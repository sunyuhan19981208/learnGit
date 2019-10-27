package softwareSY;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
 
public class keypress extends JFrame{
	
	public keypress() {
		setTitle("俄罗斯方块 author:孙煜晗&&吴子涵");
		setBounds(400, 400, 22*13, 22*18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WorldMap mp=new WorldMap();
//		final JScrollPane scrollPane = new JScrollPane();
//		add(scrollPane, BorderLayout.CENTER);
//		JTextArea textArea = new JTextArea();
		addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) { // 按键被按下时被触发
					int keyCode = e.getKeyCode();// 获得与此事件中的键相关联的字符
					
					switch (keyCode) {
						case KeyEvent.VK_UP: // 判断按下的是否为上键
						try {
							gameMap.change();
						} catch (InterruptedException e2) {
							// TODO 自动生成的 catch 块
							e2.printStackTrace();
						}
							break;
						case KeyEvent.VK_DOWN: // 判断按下的是否为下键
						try {
							gameMap.movedown();
						} catch (InterruptedException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
							break;
						case KeyEvent.VK_LEFT: // 判断按下的是否为左键
						try {
							gameMap.moveleft();
						} catch (InterruptedException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
							break;
						case KeyEvent.VK_RIGHT:// 判断按下的是否为右键
						try {
							gameMap.moveright();
						} catch (InterruptedException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
							break;
					}
				
			}
			
			public void keyTyped(KeyEvent e) { // 发生击键事件时被触发
			}
			
			public void keyReleased(KeyEvent e) { // 按键被释放时被触发
//				String keyText = KeyEvent.getKeyText(e.getKeyCode());// 获得描述keyCode的标签
//				System.out.println("您释放的是“" + keyText + "”键");
//				System.out.println();
			}
		});
//		
		add(mp);
//		textArea.setLineWrap(true);//设置文本域自动换行
//		textArea.setRows(3);//设置文本域行数
//		textArea.setColumns(5);//设置文本域的列数
//		scrollPane.setViewportView(textArea);
//		
		setVisible(true);
	}
 
}
