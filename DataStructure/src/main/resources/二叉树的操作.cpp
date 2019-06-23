#include<iostream>
using namespace std;
struct BiNode
{
	char data;
	struct BiNode *lchild,*rchild;
};
class BiTree
{
public:
	struct BiNode *root;
public:
	BiTree()//构造函数，初始化根结点；
	{root=NULL;}
	void GreetTree()//创建二叉树
	{root=Creat(root);}
	~BiTree()//析构函数。销毁二叉树
	{Release(root);}
	void PreOrder(BiNode *bt)//前序遍历
	{
		/*PreOrder(root);*/
		if(bt==NULL)return;
		else
		{
			cout<<bt->data;
			PreOrder(bt->lchild);
			PreOrder(bt->rchild);
		}
	}
	void LeverOrder()//层序遍历
	{LeverOrder(root);}
	void BiTreeDepth()//树的深度
	{cout<<"树的深度："<<BiTreeDepth(root)<<endl;}
	void BiTreeLeapNum()//叶子节点数目
	{cout<<"叶子结点数目："<<LeapNum(root)<<endl;}
	void BiTreeLeve()//指定结点的层数：
	{
		char le;
		cout<<"输入结点信息：";
		cin>>le;
		cout<<le<<"的层数是："<<getfloor(root,le)<<endl;
	}
	void InsertChild()//插入结点
	{
		char child1,parent1;
		cout<<"输入孩子信息：";cin>>child1;
		cout<<"输入双亲结点信息：";cin>>parent1;
		InsertLeftChild(child1,parent1,root);
		cout<<"插入后结果：（层序输出）"<<endl;
		LeverOrder(root);
	}
	void DeleteNode()//删除结点：
	{
		char node;
		cout<<"输入删除的结点信息：";cin>>node;
		deleteNode(root,node);
		cout<<"删除后的结果：（层序输出）"<<endl;
		LeverOrder(root);
	}
	void deleteNode(BiNode *T,char delchar)//删除节点及其子节点 
	{ 
		if (T!=NULL)//如果根节点不为空 
		{
			if (T->data==delchar)//如果根节点为要删除的节点 
			{
				delete T->lchild;//删除左孩子节点 
				T->lchild=NULL;//左指针指向NULL 
				delete T->rchild;//删除右孩子节点 
				T->rchild=NULL;//右指针指向NULL 
				delete T;//删除节点T 
			}else 
				if (T->lchild!=NULL&&T->lchild->data==delchar)//如果左孩子为要删除的节点 
				{
					delete T->lchild->lchild;//先删除左孩子的左孩子 
					delete T->lchild->rchild;//再删除左孩子的右孩子 
					delete T->lchild;//最后删除左孩子 
					T->lchild=NULL;//左指针置空 
				}
				else if (T->rchild!=NULL&&T->rchild->data==delchar)//如果右孩子为要删除的节点 
					{
						delete T->rchild->lchild;//先删除右孩子的左孩子 
						delete T->rchild->rchild;//再删除右孩子的右孩子 
						delete T->rchild;//最后删除右孩子 
						T->rchild=NULL;//右指针置空
					}else 
					{ 
						if(T->lchild!=NULL)//如果左孩子不为空 
						{ 
							deleteNode(T->lchild,delchar);//递归删除左孩子结点 
						}
						if(T->rchild!=NULL)//如果右孩子不为空 
						{ 
							deleteNode(T->rchild,delchar);//递归删除右孩子节点 
						} 
					} 
		} 
	} 
	void ChangeNode()
	{
		ChangeNode(root);
		cout<<"交换左右子树后：（层序输出）"<<endl;
		LeverOrder(root);
	}
	void ChangeNode(BiNode *bt)//交换左右子树
	{
		if(bt!=NULL)
		{
			if(bt->lchild!=NULL&&bt->rchild!=NULL)//左右子树都不为空
			{
				BiNode *p;
				p=bt->lchild;
				bt->lchild=bt->rchild;
				bt->rchild=p;
			}
			else if(bt->lchild==NULL&&bt->rchild!=NULL)//左空 右不空
			{
				bt->lchild=bt->rchild;
				bt->rchild=NULL;
			}else if(bt->lchild!=NULL&&bt->rchild==NULL)//右空 左不空
			{
				bt->rchild=bt->lchild;
				bt->lchild=NULL;
			}
			ChangeNode(bt->lchild);//递归
			ChangeNode(bt->rchild);
		}else return;
	}
	BiNode *TreeFindNode(BiNode *bt,char data)//按照结点信息查找结点
	{
		BiNode *ptr;
		if(bt==NULL)return NULL;//空树
		else if(bt->data==data)return bt;//递归结束条件
		else
		{
			if(ptr=TreeFindNode(bt->lchild,data))//递归，从左子树开始找
				return ptr;
			else if(ptr=TreeFindNode(bt->rchild,data))//递归，从右子树开始找
				return ptr;
		}
	}
	BiNode *Creat(BiNode *bt)//前序建立二叉树
	{
		char ch;
		cin>>ch;
		if(ch=='#')bt=NULL;
		else 
		{
			bt=new BiNode;bt->data=ch;
			bt->lchild=Creat(bt->lchild);
			bt->rchild=Creat(bt->rchild);
		}
		return bt;
	}
	int BiTreeDepth(BiNode *bt)//树的深度 
	{
		if(bt==NULL)return 0;
		return 
			BiTreeDepth(bt->lchild)>BiTreeDepth(bt->rchild)?BiTreeDepth(bt->lchild)+1:BiTreeDepth(bt->rchild)+1;
	}
	int LeapNum(BiNode *bt)//叶子节点
	{
		if(bt==NULL)return 0;
		else if(bt->lchild==NULL&&bt->rchild==NULL)return 1;
		else return LeapNum(bt->lchild)+LeapNum(bt->rchild);
	}
	int getfloor(BiNode *p,char x)//求指定结点的层数 
	{  
		int num1,num2,n;  
		if(p==NULL)   
			return 0;   
		else
		{   
			if(p->data==x) 
				return 1;   
			num1=getfloor(p->lchild,x);   
			num2=getfloor(p->rchild,x);   
			n=num1+num2;   
			if(num1!=0||num2!=0)    
				n++;   
			return n;   
		}  
	}
	void InsertLeftChild(char child1,char parent1,BiNode *bt)//插入新结点到指定结点的左或右子树
	{
		BiNode *parent;
		BiNode *child=new BiNode;//建立新结点
		child->data=child1;//初始化新结点
		child->lchild=NULL;child->rchild=NULL;//新结点左右子树都为空
		parent=TreeFindNode(root,parent1);//寻找双亲结点
		if(!parent)
		{
			cout<<"没有找到双亲！"<<endl;delete child;return;
		}
		else
		{
			cout<<"已经找到双亲结点！"<<endl;
			char direction;
			cout<<"输入插入方向：L or R"<<endl;
			cin>>direction;
			if(direction=='L')//左插
			{
				if(parent->lchild)
					cout<<"双亲左子树不为空！无法插入！"<<endl;
				else
				{
					parent->lchild=child;cout<<"插入左子树成功！！"<<endl;
				}
			}
			else if(direction=='R')//右插
			{
				if(parent->rchild)
					cout<<"双亲右子树不为空！无法插入！"<<endl;
				else
				{
					parent->rchild=child;cout<<"插入右子树成功！！"<<endl;
				}
			}
		}
	}
	void LeverOrder(BiNode *bt)//层序遍历
	{
		BiNode *queue[50];//队列存储二叉树的结点
		BiNode *p;
		int front,rear;
		front=rear=-1;
		if(bt==NULL)return;
		queue[++rear]=bt;		//根结点入队
		while(front!=rear)		//队列非空时
		{
			p=queue[++front];		//出队，取队头元素
			cout<<p->data;
			if(p->lchild!=NULL)		//左孩子不为空
				queue[++rear]=p->lchild;		//左孩子入队
			if(p->rchild!=NULL)		//右孩子不为空
				queue[++rear]=p->rchild;		//右孩子入队
		}
	}
	/*void PreOrder(BiNode *bt)//前序遍历
	{
		if(bt==NULL)return;
		else
		{
			cout<<bt->data;
			PreOrder(bt->lchild);
			PreOrder(bt->rchild);
		}
	}*/
	void Release(BiNode *bt)//销毁二叉树
	{
		if(bt!=NULL)
		{
			cout<<"销毁二叉树！"<<endl;
			Release(bt->lchild);
			Release(bt->rchild);
			delete bt;
		}
	}
};
int main()
{	
	BiTree b;
	int order;
	int flag=1;
	cout<<"				****************命令如下**************"<<endl;
	cout<<"					1，前序创建二叉树："<<endl;
	cout<<"					2，前序遍历输出："<<endl;
	cout<<"					3，中序遍历输出："<<endl;
	cout<<"					4，后序遍历输出："<<endl;
	cout<<"					5，层序遍历输出："<<endl;
	cout<<"					6，求树的深度："<<endl;
	cout<<"					7，求叶子节点的数目："<<endl;
	cout<<"					8，求指定结点的层数："<<endl;
	cout<<"					9，在指定结点插入左或右子树："<<endl;
	cout<<"					10，交换左右子树："<<endl;
	cout<<"					11，删除指定结点及其子树："<<endl;
	cout<<"					12，结束程序："<<endl;
	cout<<"输入命令序号："<<endl;
	cin>>order;
	while(order)
	{
		switch(order)
		{
		case 1:
			{
				cout<<"输入前序创建二叉树："<<endl;
				b.GreetTree();
				cout<<endl;
			}break;
		case 2:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"前序遍历输出："<<endl;
					b.PreOrder(b.root);
					cout<<endl;
				}break;
			}
		case 3:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"中序遍历输出："<<endl;
					cout<<endl;
				}
			}break;
		case 4:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"后序遍历输出："<<endl;
					cout<<endl;
				}
			}break;
		case 5:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"层序遍历输出："<<endl;
					b.LeverOrder();
					cout<<endl;
				}
			}break;
		case 6:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"树的深度为：  "<<endl;
					b.BiTreeDepth();
					cout<<endl;
				}
			}break;
		case 7:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else 
				{
					cout<<"叶子结点的数目为："<<endl;
					b.BiTreeLeapNum();
					cout<<endl;
				}
			}break;
		case 8:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"求指定结点的层数："<<endl;
					b.BiTreeLeve();
					cout<<endl;
				}
			}break;
		case 9:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"在指定结点下插入左或右子树："<<endl;
					b.InsertChild();
					cout<<endl;
				}
			}break;
		case 10:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else
				{
					cout<<"交换左右子树："<<endl;
					b.ChangeNode();
					cout<<endl;
				}
			}break;
		case 11:
			{
				if(b.root==NULL)cout<<"二叉树为空！请先创建二叉树："<<endl;
				else 
				{
					cout<<"删除指定结点及其子树："<<endl;
					b.DeleteNode();
					cout<<endl;
				}
			}break;
		case 12:
			{
				flag=0;
			}break;
		default:cout<<"输入非法！重新输入："<<endl;
		}
		if(flag==0)break;
		else
		{
			cout<<"输入命令序号："<<endl;
			cin>>order;
		}
	
	}
	/*
	cout<<"前序建立二叉树："<<endl;
	cout<<"前序遍历："<<endl;
	b.PreOrder();
	cout<<endl;
	cout<<"层序遍历："<<endl;
	b.LeverOrder();
	cout<<endl;
	b.BiTreeDepth();//求树的深度
	b.BiTreeLeapNum();//求叶子结点数目
	cout<<endl;
	b.BiTreeLeve();//求指定结点的层数
	cout<<endl;
	b.InsertChild();//在指定结点下面插入左或者右子树
	cout<<endl;
	b.ChangeNode();//交换左右子树
	cout<<endl;
	b.DeleteNode();//删除指定结点
	cout<<endl;*/
	return 0;
}
