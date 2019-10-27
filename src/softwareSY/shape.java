package softwareSY;

public class shape {
	int col=gameMap.col;
	int row=gameMap.row;
	int s[][]=new int[20][20];
	public void change(){};
	public void create(){};
	
}

class changtiao extends shape{//长条-0
//****
	int s[][]={{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,2,3,2,2,0,0,0,0}};

	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
	public void change(){
		if(gameMap.cur==0)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-2<0||gameMap.matrix[x-2][y]==1||gameMap.matrix[x-1][y]==1
					||gameMap.matrix[x+1][y]==1)return;
			gameMap.matrix[x+1][y]=2;
			gameMap.matrix[x-1][y]=2;
			gameMap.matrix[x-2][y]=2;
			
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x][y+1]=0;
			gameMap.matrix[x][y+2]=0;
		}
		else if(gameMap.cur==1)
		{
			int x=-1,y=-1;
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y-1<0||y+2>=col||
					gameMap.matrix[x][y-1]==1||gameMap.matrix[x][y+1]==1||gameMap.matrix[x][y+2]==1)return;
			gameMap.matrix[x][y-1]=2;
			gameMap.matrix[x][y+1]=2;
			gameMap.matrix[x][y+2]=2;
			gameMap.matrix[x+1][y]=0;
			gameMap.matrix[x-1][y]=0;
			gameMap.matrix[x-2][y]=0;
		}
		gameMap.cur++;
		gameMap.cur%=2;
	}
}
class Tsize extends shape{//T型-1
// *
//***
	int col=gameMap.col;
	int row=gameMap.row;
	int cur=gameMap.cur;
	public void change(){
		if(cur==0)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||gameMap.matrix[x-1][y]==1)return;
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x-1][y]=2;
		}
		if(cur==1)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(gameMap.matrix[x][y-1]==1||y-1<0)return;
			gameMap.matrix[x+1][y]=0;
			gameMap.matrix[x][y-1]=2;
		}
		if(cur==2)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(gameMap.matrix[x+1][y]==1)return;
			gameMap.matrix[x][y+1]=0;
			gameMap.matrix[x+1][y]=2;
		}
		if(cur==3)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(gameMap.matrix[x][y+1]==1||y+1>=col)return;
			gameMap.matrix[x][y+1]=2;
			gameMap.matrix[x-1][y]=0;
		}

		gameMap.cur++;
		gameMap.cur%=4;
	}
	int s[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,0,0,0,0,0},
			{0,0,0,0,0,2,3,2,0,0,0,0}
			};
	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
}
class L1 extends shape{//L1型-2
//*
//*
//**
	int col=gameMap.col;
	int row=gameMap.row;
	int cur=gameMap.cur;
	public void change(){
		if(cur==0)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y-1<0||x-1<0||y+1>=col||
					gameMap.matrix[x][y-1]==1||gameMap.matrix[x-1][y-1]==1||gameMap.matrix[x][y+1]==1)
				return;
			gameMap.matrix[x-1][y]=0;
			gameMap.matrix[x-1][y+1]=0;
			gameMap.matrix[x+1][y]=0;
			gameMap.matrix[x][y-1]=2;
			gameMap.matrix[x-1][y-1]=2;
			gameMap.matrix[x][y+1]=2;
		}
		if(cur==1)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||y-1<0||gameMap.matrix[x-1][y]==1||gameMap.matrix[x+1][y]==1||gameMap.matrix[x+1][y-1]==1)
				return;
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x-1][y-1]=0;
			gameMap.matrix[x][y+1]=0;
			gameMap.matrix[x-1][y]=2;
			gameMap.matrix[x+1][y]=2;
			gameMap.matrix[x+1][y-1]=2;
		}
		if(cur==2)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y-1<0||y+1>=col||gameMap.matrix[x][y+1]==1||gameMap.matrix[x][y-1]==1||gameMap.matrix[x+1][y+1]==1)
				return;
			gameMap.matrix[x+1][y]=0;
			gameMap.matrix[x-1][y]=0;
			gameMap.matrix[x+1][y-1]=0;
			gameMap.matrix[x][y+1]=2;
			gameMap.matrix[x][y-1]=2;
			gameMap.matrix[x+1][y+1]=2;
		}
		if(cur==3)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||y+1>=col||gameMap.matrix[x+1][y]==1||gameMap.matrix[x-1][y]==1||gameMap.matrix[x-1][y+1]==1)
				return;
			gameMap.matrix[x][y+1]=0;
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x+1][y+1]=0;
			
			gameMap.matrix[x+1][y]=2;
			gameMap.matrix[x-1][y]=2;
			gameMap.matrix[x-1][y+1]=2;
		}

		gameMap.cur++;
		gameMap.cur%=4;
	}
	int s[][]={
			{0,0,0,0,0,0,2,0,0,0,0,0},
			{0,0,0,0,0,0,3,0,0,0,0,0},
			{0,0,0,0,0,0,2,2,0,0,0,0}
			};
	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
}
class L2 extends shape{//L2型-3
// *
// *
//**
	int col=gameMap.col;
	int row=gameMap.row;
	int cur=gameMap.cur;
	public void change(){
		if(cur==0)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y-1<0||y+1>=col||gameMap.matrix[x][y-1]==1||gameMap.matrix[x+1][y-1]==1||
					gameMap.matrix[x][y+1]==1)return;
			gameMap.matrix[x-1][y]=0;
			gameMap.matrix[x-1][y-1]=0;
			gameMap.matrix[x+1][y]=0;
			
			gameMap.matrix[x][y-1]=2;
			gameMap.matrix[x+1][y-1]=2;
			gameMap.matrix[x][y+1]=2;
		}
		if(cur==1)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y+1>=col||x-1<0||gameMap.matrix[x-1][y]==1||gameMap.matrix[x+1][y]==1||gameMap.matrix[x+1][y+1]==1)
				return;
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x+1][y-1]=0;
			gameMap.matrix[x][y+1]=0;
			
			gameMap.matrix[x-1][y]=2;
			gameMap.matrix[x+1][y]=2;
			gameMap.matrix[x+1][y+1]=2;
		}
		if(cur==2)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||y-1<0||y+1>=col||gameMap.matrix[x][y+1]==1||
					gameMap.matrix[x][y-1]==1||gameMap.matrix[x-1][y+1]==1)
				return;
			gameMap.matrix[x+1][y]=0;
			gameMap.matrix[x-1][y]=0;
			gameMap.matrix[x+1][y+1]=0;
			
			gameMap.matrix[x][y+1]=2;
			gameMap.matrix[x][y-1]=2;
			gameMap.matrix[x-1][y+1]=2;
		}
		if(cur==3)
		{
			int x=-1,y=-1;
			for(int i=0;i<row+4;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||y-1<0||gameMap.matrix[x+1][y]==1||gameMap.matrix[x-1][y]==1||gameMap.matrix[x-1][y-1]==1)
				return;
			gameMap.matrix[x][y+1]=0;
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x-1][y+1]=0;
			
			gameMap.matrix[x+1][y]=2;
			gameMap.matrix[x-1][y]=2;
			gameMap.matrix[x-1][y-1]=2;
		}

		gameMap.cur++;
		gameMap.cur%=4;
	}
	int s[][]={
			{0,0,0,0,0,0,2,0,0,0,0,0},
			{0,0,0,0,0,0,3,0,0,0,0,0},
			{0,0,0,0,0,2,2,0,0,0,0,0}
			};
	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
}
class square extends shape{//方块-4
//**
//**	
	int col=gameMap.col;
	int row=gameMap.row;
	int cur=gameMap.cur;
	public void change(){
		return;
	}
	int s[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,2,2,0,0,0,0,0},
			{0,0,0,0,0,2,2,0,0,0,0,0}
			};
	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
}
class Z1 extends shape{//Z1型-5
//**
// **
	int col=gameMap.col;
	int row=gameMap.row;
	int cur=gameMap.cur;
	public void change(){
		if(cur==0)
		{
			int x=-1,y=-1;
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y-1<0||x-1<0||gameMap.matrix[x][y-1]==1||gameMap.matrix[x-1][y-1]==1)return;
			gameMap.matrix[x][y+1]=0;
			gameMap.matrix[x+1][y-1]=0;
			gameMap.matrix[x][y-1]=2;
			gameMap.matrix[x-1][y-1]=2;
		}
		else if(cur==1)
		{
			int x=-1,y=-1;
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(y+1>=col||y-1<0||gameMap.matrix[x][y+1]==1||gameMap.matrix[x+1][y-1]==1)
				return;
			gameMap.matrix[x][y-1]=0;
			gameMap.matrix[x-1][y-1]=0;
			gameMap.matrix[x][y+1]=2;
			gameMap.matrix[x+1][y-1]=2;
		}

		gameMap.cur++;
		gameMap.cur%=2;
	}
	public int s[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,2,2,0,0,0,0,0},
			{0,0,0,0,0,0,3,2,0,0,0,0}
			};
	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
}
class Z2 extends shape{//Z2型-6
// **
//**
	int col=gameMap.col;
	int row=gameMap.row;
	int cur=gameMap.cur;
	public void change(){
		if(cur==0)
		{
			int x=-1,y=-1;
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||y-1<0||gameMap.matrix[x-1][y]==1||gameMap.matrix[x+1][y-1]==1)
				return;
			gameMap.matrix[x+1][y]=0;
			gameMap.matrix[x+1][y+1]=0;
			gameMap.matrix[x-1][y]=2;
			gameMap.matrix[x+1][y-1]=2;
		}
		else if(cur==1)
		{
			int x=-1,y=-1;
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					if(gameMap.matrix[i][j]==3)
					{
						x=i;
						y=j;
					}
			if(x==-1||y==-1)return;
			if(x-1<0||y+1>=col||gameMap.matrix[x+1][y]==1||gameMap.matrix[x+1][y+1]==1)
				return;
			gameMap.matrix[x+1][y]=2;
			gameMap.matrix[x+1][y+1]=2;
			gameMap.matrix[x-1][y]=0;
			gameMap.matrix[x+1][y-1]=0;
		}

		gameMap.cur++;
		gameMap.cur%=2;
	}
	int s[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,2,2,0,0,0,0},
			{0,0,0,0,0,2,3,0,0,0,0,0}
			};
	public void create(){
		for(int i=15;i<=17;i++)
			for(int j=0;j<12;j++)
				gameMap.matrix[i][j]=s[17-i][j];
		}
}
