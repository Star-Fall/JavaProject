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
	BiTree()//���캯������ʼ������㣻
	{root=NULL;}
	void GreetTree()//����������
	{root=Creat(root);}
	~BiTree()//�������������ٶ�����
	{Release(root);}
	void PreOrder(BiNode *bt)//ǰ�����
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
	void LeverOrder()//�������
	{LeverOrder(root);}
	void BiTreeDepth()//�������
	{cout<<"������ȣ�"<<BiTreeDepth(root)<<endl;}
	void BiTreeLeapNum()//Ҷ�ӽڵ���Ŀ
	{cout<<"Ҷ�ӽ����Ŀ��"<<LeapNum(root)<<endl;}
	void BiTreeLeve()//ָ�����Ĳ�����
	{
		char le;
		cout<<"��������Ϣ��";
		cin>>le;
		cout<<le<<"�Ĳ����ǣ�"<<getfloor(root,le)<<endl;
	}
	void InsertChild()//������
	{
		char child1,parent1;
		cout<<"���뺢����Ϣ��";cin>>child1;
		cout<<"����˫�׽����Ϣ��";cin>>parent1;
		InsertLeftChild(child1,parent1,root);
		cout<<"��������������������"<<endl;
		LeverOrder(root);
	}
	void DeleteNode()//ɾ����㣺
	{
		char node;
		cout<<"����ɾ���Ľ����Ϣ��";cin>>node;
		deleteNode(root,node);
		cout<<"ɾ����Ľ���������������"<<endl;
		LeverOrder(root);
	}
	void deleteNode(BiNode *T,char delchar)//ɾ���ڵ㼰���ӽڵ� 
	{ 
		if (T!=NULL)//������ڵ㲻Ϊ�� 
		{
			if (T->data==delchar)//������ڵ�ΪҪɾ���Ľڵ� 
			{
				delete T->lchild;//ɾ�����ӽڵ� 
				T->lchild=NULL;//��ָ��ָ��NULL 
				delete T->rchild;//ɾ���Һ��ӽڵ� 
				T->rchild=NULL;//��ָ��ָ��NULL 
				delete T;//ɾ���ڵ�T 
			}else 
				if (T->lchild!=NULL&&T->lchild->data==delchar)//�������ΪҪɾ���Ľڵ� 
				{
					delete T->lchild->lchild;//��ɾ�����ӵ����� 
					delete T->lchild->rchild;//��ɾ�����ӵ��Һ��� 
					delete T->lchild;//���ɾ������ 
					T->lchild=NULL;//��ָ���ÿ� 
				}
				else if (T->rchild!=NULL&&T->rchild->data==delchar)//����Һ���ΪҪɾ���Ľڵ� 
					{
						delete T->rchild->lchild;//��ɾ���Һ��ӵ����� 
						delete T->rchild->rchild;//��ɾ���Һ��ӵ��Һ��� 
						delete T->rchild;//���ɾ���Һ��� 
						T->rchild=NULL;//��ָ���ÿ�
					}else 
					{ 
						if(T->lchild!=NULL)//������Ӳ�Ϊ�� 
						{ 
							deleteNode(T->lchild,delchar);//�ݹ�ɾ�����ӽ�� 
						}
						if(T->rchild!=NULL)//����Һ��Ӳ�Ϊ�� 
						{ 
							deleteNode(T->rchild,delchar);//�ݹ�ɾ���Һ��ӽڵ� 
						} 
					} 
		} 
	} 
	void ChangeNode()
	{
		ChangeNode(root);
		cout<<"�������������󣺣����������"<<endl;
		LeverOrder(root);
	}
	void ChangeNode(BiNode *bt)//������������
	{
		if(bt!=NULL)
		{
			if(bt->lchild!=NULL&&bt->rchild!=NULL)//������������Ϊ��
			{
				BiNode *p;
				p=bt->lchild;
				bt->lchild=bt->rchild;
				bt->rchild=p;
			}
			else if(bt->lchild==NULL&&bt->rchild!=NULL)//��� �Ҳ���
			{
				bt->lchild=bt->rchild;
				bt->rchild=NULL;
			}else if(bt->lchild!=NULL&&bt->rchild==NULL)//�ҿ� �󲻿�
			{
				bt->rchild=bt->lchild;
				bt->lchild=NULL;
			}
			ChangeNode(bt->lchild);//�ݹ�
			ChangeNode(bt->rchild);
		}else return;
	}
	BiNode *TreeFindNode(BiNode *bt,char data)//���ս����Ϣ���ҽ��
	{
		BiNode *ptr;
		if(bt==NULL)return NULL;//����
		else if(bt->data==data)return bt;//�ݹ��������
		else
		{
			if(ptr=TreeFindNode(bt->lchild,data))//�ݹ飬����������ʼ��
				return ptr;
			else if(ptr=TreeFindNode(bt->rchild,data))//�ݹ飬����������ʼ��
				return ptr;
		}
	}
	BiNode *Creat(BiNode *bt)//ǰ����������
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
	int BiTreeDepth(BiNode *bt)//������� 
	{
		if(bt==NULL)return 0;
		return 
			BiTreeDepth(bt->lchild)>BiTreeDepth(bt->rchild)?BiTreeDepth(bt->lchild)+1:BiTreeDepth(bt->rchild)+1;
	}
	int LeapNum(BiNode *bt)//Ҷ�ӽڵ�
	{
		if(bt==NULL)return 0;
		else if(bt->lchild==NULL&&bt->rchild==NULL)return 1;
		else return LeapNum(bt->lchild)+LeapNum(bt->rchild);
	}
	int getfloor(BiNode *p,char x)//��ָ�����Ĳ��� 
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
	void InsertLeftChild(char child1,char parent1,BiNode *bt)//�����½�㵽ָ���������������
	{
		BiNode *parent;
		BiNode *child=new BiNode;//�����½��
		child->data=child1;//��ʼ���½��
		child->lchild=NULL;child->rchild=NULL;//�½������������Ϊ��
		parent=TreeFindNode(root,parent1);//Ѱ��˫�׽��
		if(!parent)
		{
			cout<<"û���ҵ�˫�ף�"<<endl;delete child;return;
		}
		else
		{
			cout<<"�Ѿ��ҵ�˫�׽�㣡"<<endl;
			char direction;
			cout<<"������뷽��L or R"<<endl;
			cin>>direction;
			if(direction=='L')//���
			{
				if(parent->lchild)
					cout<<"˫����������Ϊ�գ��޷����룡"<<endl;
				else
				{
					parent->lchild=child;cout<<"�����������ɹ�����"<<endl;
				}
			}
			else if(direction=='R')//�Ҳ�
			{
				if(parent->rchild)
					cout<<"˫����������Ϊ�գ��޷����룡"<<endl;
				else
				{
					parent->rchild=child;cout<<"�����������ɹ�����"<<endl;
				}
			}
		}
	}
	void LeverOrder(BiNode *bt)//�������
	{
		BiNode *queue[50];//���д洢�������Ľ��
		BiNode *p;
		int front,rear;
		front=rear=-1;
		if(bt==NULL)return;
		queue[++rear]=bt;		//��������
		while(front!=rear)		//���зǿ�ʱ
		{
			p=queue[++front];		//���ӣ�ȡ��ͷԪ��
			cout<<p->data;
			if(p->lchild!=NULL)		//���Ӳ�Ϊ��
				queue[++rear]=p->lchild;		//�������
			if(p->rchild!=NULL)		//�Һ��Ӳ�Ϊ��
				queue[++rear]=p->rchild;		//�Һ������
		}
	}
	/*void PreOrder(BiNode *bt)//ǰ�����
	{
		if(bt==NULL)return;
		else
		{
			cout<<bt->data;
			PreOrder(bt->lchild);
			PreOrder(bt->rchild);
		}
	}*/
	void Release(BiNode *bt)//���ٶ�����
	{
		if(bt!=NULL)
		{
			cout<<"���ٶ�������"<<endl;
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
	cout<<"				****************��������**************"<<endl;
	cout<<"					1��ǰ�򴴽���������"<<endl;
	cout<<"					2��ǰ����������"<<endl;
	cout<<"					3��������������"<<endl;
	cout<<"					4��������������"<<endl;
	cout<<"					5��������������"<<endl;
	cout<<"					6����������ȣ�"<<endl;
	cout<<"					7����Ҷ�ӽڵ����Ŀ��"<<endl;
	cout<<"					8����ָ�����Ĳ�����"<<endl;
	cout<<"					9����ָ�������������������"<<endl;
	cout<<"					10����������������"<<endl;
	cout<<"					11��ɾ��ָ����㼰��������"<<endl;
	cout<<"					12����������"<<endl;
	cout<<"����������ţ�"<<endl;
	cin>>order;
	while(order)
	{
		switch(order)
		{
		case 1:
			{
				cout<<"����ǰ�򴴽���������"<<endl;
				b.GreetTree();
				cout<<endl;
			}break;
		case 2:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"ǰ����������"<<endl;
					b.PreOrder(b.root);
					cout<<endl;
				}break;
			}
		case 3:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"������������"<<endl;
					cout<<endl;
				}
			}break;
		case 4:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"������������"<<endl;
					cout<<endl;
				}
			}break;
		case 5:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"������������"<<endl;
					b.LeverOrder();
					cout<<endl;
				}
			}break;
		case 6:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"�������Ϊ��  "<<endl;
					b.BiTreeDepth();
					cout<<endl;
				}
			}break;
		case 7:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else 
				{
					cout<<"Ҷ�ӽ�����ĿΪ��"<<endl;
					b.BiTreeLeapNum();
					cout<<endl;
				}
			}break;
		case 8:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"��ָ�����Ĳ�����"<<endl;
					b.BiTreeLeve();
					cout<<endl;
				}
			}break;
		case 9:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"��ָ������²��������������"<<endl;
					b.InsertChild();
					cout<<endl;
				}
			}break;
		case 10:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else
				{
					cout<<"��������������"<<endl;
					b.ChangeNode();
					cout<<endl;
				}
			}break;
		case 11:
			{
				if(b.root==NULL)cout<<"������Ϊ�գ����ȴ�����������"<<endl;
				else 
				{
					cout<<"ɾ��ָ����㼰��������"<<endl;
					b.DeleteNode();
					cout<<endl;
				}
			}break;
		case 12:
			{
				flag=0;
			}break;
		default:cout<<"����Ƿ����������룺"<<endl;
		}
		if(flag==0)break;
		else
		{
			cout<<"����������ţ�"<<endl;
			cin>>order;
		}
	
	}
	/*
	cout<<"ǰ������������"<<endl;
	cout<<"ǰ�������"<<endl;
	b.PreOrder();
	cout<<endl;
	cout<<"���������"<<endl;
	b.LeverOrder();
	cout<<endl;
	b.BiTreeDepth();//���������
	b.BiTreeLeapNum();//��Ҷ�ӽ����Ŀ
	cout<<endl;
	b.BiTreeLeve();//��ָ�����Ĳ���
	cout<<endl;
	b.InsertChild();//��ָ�����������������������
	cout<<endl;
	b.ChangeNode();//������������
	cout<<endl;
	b.DeleteNode();//ɾ��ָ�����
	cout<<endl;*/
	return 0;
}
