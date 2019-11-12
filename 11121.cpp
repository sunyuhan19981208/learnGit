#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#include <cmath>
#include <cstring>
#include <algorithm>
#define ms(x,y) memset(x,y,sizeof(x))
#define INF 0x3f3f3f3f
using namespace std;
const int maxn =1000005;//提交记得修改
struct node{
	int l,r,val;
	int lson,rson;
}p[maxn*30];
int T[maxn];
int cnt;
void build(int l,int r,int cur){
	p[cur].l=l,p[cur].r=r;
	if(l==r){
		scanf("%d",&p[cur].val);
		return;
	}
	int mid=(l+r)>>1;
	p[cur].lson=++cnt;
	p[cur].rson=++cnt;
	build(l,mid,p[cur].lson);
	build(mid+1,r,p[cur].rson);
}
void update(int tar,int val,int cur,int pre){
	int l=p[pre].l,r=p[pre].r;
	p[cur].l=l,p[cur].r=r;
	if(l==r){
		p[cur].val=val;
		return;
	}
	int mid=(l+r)>>1;
	if(tar<=mid){
		p[cur].rson=p[pre].rson;
		p[cur].lson=++cnt;
		update(tar,val,p[cur].lson,p[pre].lson);
	}
	else{
		p[cur].lson=p[pre].lson;
		p[cur].rson=++cnt;
		update(tar,val,p[cur].rson,p[pre].rson);
	}
}
int query(int tar,int cur){
	int l=p[cur].l,r=p[cur].r;
	if(l==r)return p[cur].val;
	int mid=(l+r)>>1;
	if(l<=mid)return query(tar,p[cur].lson);
	else return query(tar,p[cur].rson);
}
int main()
{
	freopen("in.txt","r",stdin);
	freopen("out.txt","w",stdout);//提交记得注释
	int n,m;
	scanf("%d%d",&n,&m);
	cnt=0;
	build(1,5,1);
	int rtcnt=0;
	T[rtcnt++]=1;
	int v,op,loc,val;

	for(int i=1;i<=n;i++)
		cout<<query(i,T[0])<<" ";
	cout<<endl;
	while(m--){
		scanf("%d%d",&v,&op);
		if(op==1){
			scanf("%d%d",&loc,&val);
			T[rtcnt++]=++cnt;
			update(loc,val,T[rtcnt],T[v]);
			for(int i=1;i<=n;i++)
				cout<<query(i,T[rtcnt])<<" ";
			cout<<endl;
		}
		else if(op==2){
			scanf("%d",&loc);
			printf("%d\n",query(loc,T[v]));
		}
	}
}