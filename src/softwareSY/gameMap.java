package softwareSY;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class gameMap extends Thread{
	public static int row=15;
	public static int col=12;
	public static int matrix[][]=new int[50][50];//����֮��ĵ�ͼ 1Ϊ�е� 0Ϊû��
	public static int shapetype;
	public static int cur;
	public void run()
	{
		init();
		create();
//		for(int i=row+2;i>=0;i--){
//			for(int j=0;j<col;j++)
//				System.out.print(matrix[i][j]);
//			System.out.println();
//		}
		try {
			while(!judgelose())
			{
//				for(int i=row-1;i>=0;i--){
//					for(int j=0;j<col;j++)
//						System.out.print(matrix[i][j]);
//					System.out.println();
//				}
//
//				System.out.println();
//				System.out.println();
				try {
					movedown();
				} catch (InterruptedException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	static void init()//��ʼ��
	{
		for(int i=0;i<=row+4;i++)
			for(int j=0;j<=col;j++)
				matrix[i][j]=0;
	}
	static void reset()//����
	{
		init();
	}
	static boolean isSettle()//�жϷ����Ƿ�ͣ��
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<=col;j++)
				if(i==0&&matrix[i][j]>=2)
					return true;//����
				else if(matrix[i][j]>=2&&matrix[i-1][j]==1)
						return true;//�·��ж���
		}
		return false;
	}
	static void create()//�����µķ���
	{
		cur=0;
		Random random=new Random();
		shapetype=random.nextInt(6);
		shape a;
		switch(shapetype)
		{
		case 0:{a=new changtiao();a.create();break;}
		case 1:{a=new Tsize();a.create();break;}
		case 2:{a=new L1();a.create();break;}
		case 3:{a=new L2();a.create();break;}
		case 4:{a=new square();a.create();break;}
		case 5:{a=new Z1();a.create();break;}
		case 6:{a=new Z2();a.create();break;}
		}
	}
	public static void change() throws InterruptedException//�ı䷽����״
	{
		shape a=new shape();
		switch(shapetype)
		{
		case 0:{a=new changtiao();a.change();break;}
		case 1:{a=new Tsize();a.change();break;}
		case 2:{a=new L1();a.change();break;}
		case 3:{a=new L2();a.change();break;}
		case 4:{a=new square();a.change();break;}
		case 5:{a=new Z1();a.change();break;}
		case 6:{a=new Z2();a.change();break;}
		}
		if(isSettle())
		{
			sleep(500);
			if(!isSettle())
				return;
			clear();
			create();
		}
	}
	static void movedown() throws InterruptedException //����
	{
		for(int i=0;i<row+4;i++)
			for(int j=0;j<=col;j++)
				if(matrix[i][j]>=2){
					if(i-1<0||matrix[i-1][j]==1)
						return;
				}
		for(int i=0;i<row+4;i++)
			for(int j=0;j<=col;j++)
				if(matrix[i][j]>=2){
					matrix[i-1][j]=matrix[i][j];
					matrix[i][j]=0;
					}

		if(isSettle())
		{
			sleep(500);
			if(!isSettle())
				return;
			clear();
			create();
		}
	}
	static void moveright() throws InterruptedException//����
	{
		for(int i=0;i<row+4;i++)
			for(int j=0;j<=col;j++)
				if(matrix[i][j]>=2){
					if(j+1>=col||matrix[i][j+1]==1)
						return;
				}

		for(int i=0;i<row+4;i++)
			for(int j=col;j>=0;j--)
				if(matrix[i][j]>=2){
					matrix[i][j+1]=matrix[i][j];
					matrix[i][j]=0;
				}
		if(isSettle())
		{
			sleep(500);
			if(!isSettle())
				return;
			clear();
			create();
		}
	}
	static void moveleft() throws InterruptedException//����
	{
		for(int i=0;i<row+4;i++)
			for(int j=0;j<=col;j++)
				if(matrix[i][j]>=2){
					if(j-1<0||matrix[i][j-1]==1)return;
				}
		for(int i=0;i<row+4;i++)
			for(int j=0;j<=col;j++)
				if(matrix[i][j]>=2){
					matrix[i][j-1]=matrix[i][j];
					matrix[i][j]=0;
				}
		if(isSettle())
		{
			sleep(500);
			if(!isSettle())
				return;
			clear();
			create();
		}
	}
	static void clear() throws InterruptedException//����
	{
		int bottom=-1;
		int cnt=0;
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				if(matrix[i][j]>0)
					matrix[i][j]=1;
		for(int i=0;i<row;i++)
		{
			boolean flag=true;
			for(int j=0;j<col;j++)
				if(matrix[i][j]==0)
					flag =false;
			if(flag)
				cnt++;
			else{
				for(int j=0;j<col;j++){
					int temp=matrix[i][j];
					matrix[i][j]=0;
					matrix[i-cnt][j]=temp;
				}
				
			}
		}
//		if(bottom==-1){
//			judgelose();
//			return;
//		}
//		for(int i=bottom;i<row;i++)
//			for(int j=0;j<col;j++)
//				matrix[i][j]=matrix[i+cnt][j];
		judgelose();
	}
	static boolean judgelose() throws InterruptedException
	{
		for(int i=0;i<col;i++)
		 if(matrix[row-1][i]==1)
		 {
			 //frame�ӿ�
			 new endFrame();
			 sleep(100000);
			 reset();
			 return false;
		 }
		return false;
	}
}
