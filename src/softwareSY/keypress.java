package softwareSY;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
 
public class keypress extends JFrame{
	
	public keypress() {
		setTitle("����˹���� author:������&&���Ӻ�");
		setBounds(400, 400, 22*13, 22*18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WorldMap mp=new WorldMap();
//		final JScrollPane scrollPane = new JScrollPane();
//		add(scrollPane, BorderLayout.CENTER);
//		JTextArea textArea = new JTextArea();
		addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) { // ����������ʱ������
					int keyCode = e.getKeyCode();// �������¼��еļ���������ַ�
					
					switch (keyCode) {
						case KeyEvent.VK_UP: // �жϰ��µ��Ƿ�Ϊ�ϼ�
						try {
							gameMap.change();
						} catch (InterruptedException e2) {
							// TODO �Զ����ɵ� catch ��
							e2.printStackTrace();
						}
							break;
						case KeyEvent.VK_DOWN: // �жϰ��µ��Ƿ�Ϊ�¼�
						try {
							gameMap.movedown();
						} catch (InterruptedException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
							break;
						case KeyEvent.VK_LEFT: // �жϰ��µ��Ƿ�Ϊ���
						try {
							gameMap.moveleft();
						} catch (InterruptedException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
							break;
						case KeyEvent.VK_RIGHT:// �жϰ��µ��Ƿ�Ϊ�Ҽ�
						try {
							gameMap.moveright();
						} catch (InterruptedException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
							break;
					}
				
			}
			
			public void keyTyped(KeyEvent e) { // ���������¼�ʱ������
			}
			
			public void keyReleased(KeyEvent e) { // �������ͷ�ʱ������
//				String keyText = KeyEvent.getKeyText(e.getKeyCode());// �������keyCode�ı�ǩ
//				System.out.println("���ͷŵ��ǡ�" + keyText + "����");
//				System.out.println();
			}
		});
//		
		add(mp);
//		textArea.setLineWrap(true);//�����ı����Զ�����
//		textArea.setRows(3);//�����ı�������
//		textArea.setColumns(5);//�����ı��������
//		scrollPane.setViewportView(textArea);
//		
		setVisible(true);
	}
 
}
