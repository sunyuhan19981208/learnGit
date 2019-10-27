package softwareSY;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;  
import javax.swing.Timer;  
  
/** 
 *  
  */  
  
public class WorldMap extends JPanel {  
  
  
    private final int width = 22;  
  
    private final int height = 22;  
  
  
    private Timer timer;  
  
    private final int DELAY_TIME = 1200;  
  
    public WorldMap() {  
        this.startAnimation();
//        this.addKeyListener(new KeyListener() {
//			
//			public void keyPressed(KeyEvent e) { // ����������ʱ������
//					int keyCode = e.getKeyCode();// �������¼��еļ���������ַ�
//					
//					switch (keyCode) {
//						case KeyEvent.VK_UP: // �жϰ��µ��Ƿ�Ϊ�ϼ�
//							gameMap.change();
//							break;
//						case KeyEvent.VK_DOWN: // �жϰ��µ��Ƿ�Ϊ�¼�
//						try {
//							gameMap.movedown();
//						} catch (InterruptedException e1) {
//							// TODO �Զ����ɵ� catch ��
//							e1.printStackTrace();
//						}
//							break;
//						case KeyEvent.VK_LEFT: // �жϰ��µ��Ƿ�Ϊ���
//						try {
//							gameMap.moveleft();
//						} catch (InterruptedException e1) {
//							// TODO �Զ����ɵ� catch ��
//							e1.printStackTrace();
//						}
//							break;
//						case KeyEvent.VK_RIGHT:// �жϰ��µ��Ƿ�Ϊ�Ҽ�
//						try {
//							gameMap.moveright();
//						} catch (InterruptedException e1) {
//							// TODO �Զ����ɵ� catch ��
//							e1.printStackTrace();
//						}
//							break;
//					}
//				
//			}
//			
//			public void keyTyped(KeyEvent e) { // ���������¼�ʱ������
//			}
//			
//			public void keyReleased(KeyEvent e) { // �������ͷ�ʱ������
////				String keyText = KeyEvent.getKeyText(e.getKeyCode());// �������keyCode�ı�ǩ
////				System.out.println("���ͷŵ��ǡ�" + keyText + "����");
////				System.out.println();
//			}
//		});
    }  
  
    /** 
     * ��ͼ�ν��� 
     *  
     */  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        for (int i = 0; i < gameMap.row; i++) {  
            for (int j = 0; j < gameMap.col; j++) {  
                if (gameMap.matrix[i][j] >= 1) {  
                    g.fillRect( j * width, (gameMap.row-i) * height, width, height);  
                   
                } else {  
                	 g.drawRect( j * width, (gameMap.row-i) * height, width, height); 
                }  
            }  
        }  
    }  
  
    /** 
     * ��ʼ���� 
     *  
         */  
    private void startAnimation() {  
        // ������ʱ��  
        timer = new Timer(DELAY_TIME/10, new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                repaint();  
            }  
        });  
        // ������ʱ��  
        timer.start();  
    }  
  
   
}  