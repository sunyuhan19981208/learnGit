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
//			public void keyPressed(KeyEvent e) { // 按键被按下时被触发
//					int keyCode = e.getKeyCode();// 获得与此事件中的键相关联的字符
//					
//					switch (keyCode) {
//						case KeyEvent.VK_UP: // 判断按下的是否为上键
//							gameMap.change();
//							break;
//						case KeyEvent.VK_DOWN: // 判断按下的是否为下键
//						try {
//							gameMap.movedown();
//						} catch (InterruptedException e1) {
//							// TODO 自动生成的 catch 块
//							e1.printStackTrace();
//						}
//							break;
//						case KeyEvent.VK_LEFT: // 判断按下的是否为左键
//						try {
//							gameMap.moveleft();
//						} catch (InterruptedException e1) {
//							// TODO 自动生成的 catch 块
//							e1.printStackTrace();
//						}
//							break;
//						case KeyEvent.VK_RIGHT:// 判断按下的是否为右键
//						try {
//							gameMap.moveright();
//						} catch (InterruptedException e1) {
//							// TODO 自动生成的 catch 块
//							e1.printStackTrace();
//						}
//							break;
//					}
//				
//			}
//			
//			public void keyTyped(KeyEvent e) { // 发生击键事件时被触发
//			}
//			
//			public void keyReleased(KeyEvent e) { // 按键被释放时被触发
////				String keyText = KeyEvent.getKeyText(e.getKeyCode());// 获得描述keyCode的标签
////				System.out.println("您释放的是“" + keyText + "”键");
////				System.out.println();
//			}
//		});
    }  
  
    /** 
     * 画图形界面 
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
     * 开始动画 
     *  
         */  
    private void startAnimation() {  
        // 创建计时器  
        timer = new Timer(DELAY_TIME/10, new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                repaint();  
            }  
        });  
        // 开启计时器  
        timer.start();  
    }  
  
   
}  