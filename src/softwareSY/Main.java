package softwareSY;
import java.*;
public class Main extends Thread{
	public static gameMap mp;
	public static keypress kp;
	public static Main mm;
	public static void main(String []args)
	{
		mm=new Main();
		mm.start();
	}
	public void run()
	{
		mp=new gameMap();
		kp=new keypress();
		dis d=new dis();
		mp.start();
		d.start();
	}
}
class dis extends Thread{
	public void run()
	{
		
		while(true)
		{
			
			for(int i=gameMap.row-1;i>=0;i--){
				for(int j=0;j<gameMap.col;j++)
					System.out.print(gameMap.matrix[i][j]);
				System.out.println();
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}   
			System.out.println();
			System.out.println();
		}
	}
}
