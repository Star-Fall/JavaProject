#include<iostream>
#define N 100
using namespace std;
struct BiNode{
    int data;
    BiNode *lchild,*rchild;
};
class BiSortTree{
private:
    BiNode *root;   //根
    void InOrder(BiNode *bt); //中序遍历
    void Release(BiNode *bt); //释放二叉树
    BiNode *SearchBST(BiNode *&bt,int k);//查找
public:
    void InsertBST(BiNode *&bt,BiNode *s);//插入一个结点s(由构造函数调用)
    BiSortTree(int r[],int n); //构造函数
    void InOrder(){InOrder(root);}  //中序遍历
    void DeleteBST(BiNode *p,BiNode *f);//删除f的左孩子p
    BiNode *SearchBST(int k){return SearchBST(root,k);}
    ~BiSortTree(){Release(root);}
};
void BiSortTree::InsertBST(BiNode *&bt,BiNode *s){
    if(bt==NULL){bt=s;}
    else if(s->data<bt->data)InsertBST(bt->lchild,s);
    else InsertBST(bt->rchild,s);
}
BiSortTree::BiSortTree(int r[],int n){
    root=NULL;
    for(int i=0;i<n;i++){
        BiNode *s=new BiNode;
	s->data=r[i];
        s->lchild=NULL;
	s->rchild=NULL;
        InsertBST(root,s);
    }
}
void BiSortTree::InOrder(BiNode *bt){
    if(bt==NULL)return;
    else{
		cout<<bt->data<<' ';
        InOrder(bt->lchild);
        InOrder(bt->rchild);
    }
}
void BiSortTree::DeleteBST(BiNode *p,BiNode *f){
    if(p->lchild==NULL&&p->rchild==NULL){  //1)p为叶子结点
        f->lchild=NULL;
        delete p;
    }
    else if(p->rchild==NULL){   //2)p只有左孩子
        f->lchild=p->lchild;
        delete p;
    }
    else if(p->lchild==NULL){    //2)p只有右孩子
        f->lchild=p->rchild;
        delete p;
    }
    else{                        //3)左右孩子都存在
        BiNode *par=p;    //par为s结点的双亲结点
        BiNode *s=p->rchild;//s为右子树最左下的结点，s的值大于p左子树上的元素值，小于p右子树上元素的值，用s替换p保持了原二叉排序树的特性
        while(s->lchild!=NULL)//查找p右子树的最左下结点
        {
            par=s;
            s=s->lchild;
        }  //循环结束后s即为p右子树的最左下结点，p为s的双亲结点
        p->data=s->data;//替换数据
        if(par==p)par->rchild=s->rchild;//处理特殊情况，p的右孩子没有左子树，即par==p
        else par->lchild=s->rchild;    //处理一般情况
        delete s;
    }
}
BiNode *BiSortTree::SearchBST(BiNode *&bt,int k){
    if(bt==NULL){  //查找失败，不存在数据域为k的结点，则找合适的位置将值为k的结点插入到二叉排序树中
        BiNode *s=new BiNode;s->data=k;s->lchild=NULL;s->rchild=NULL;
        InsertBST(bt,s); //插入二叉树中
        return NULL;
    }
    else if(bt->data==k)return bt;  //查找成功，返回此结点
    else if(bt->data<k)return SearchBST(bt->rchild,k);
    else return SearchBST(bt->lchild,k);
}
void BiSortTree::Release(BiNode *bt){
    if(bt==NULL)return;
    else{
        Release(bt->lchild);
        Release(bt->rchild);
        delete bt;
    }
}
int main(){
    cout<<"二叉排序树:\n";
    int r[]={63,55,90,42,58,70,10,45,67,83};
    for(int i=0;i<10;i++)
	cout<<r[i]<<' ';
    cout<<endl;
	int n=10;
    BiSortTree bst(r,n);
    cout<<"前序遍历:\n";
    bst.InOrder();
	cout<<'\n';
    cout<<"请输入要查找的数:";
    int k;cin>>k;
    BiNode *kk=bst.SearchBST(k);
    if(kk!=NULL){
        for(int i=0;i<n;i++)
            if(kk->data==r[i])
		cout<<"查找成功，此数在二叉排序树中的位置下标:"<<i<<endl;
    }
    else{
        cout<<"查找失败，已插入二叉排序树中的合适位置:"<<endl;
        bst.InOrder();
		cout<<'\n';
    }
    cout<<"请输入要删除的数(左孩子)和其父结点的数:";
    int del,parent;cin>>del>>parent;
    BiNode *p=bst.SearchBST(del);
    BiNode *f=bst.SearchBST(del);
    bst.DeleteBST(p,f);
    cout<<"删除后:";
    bst.InOrder();cout<<'\n';
	return 0;
}