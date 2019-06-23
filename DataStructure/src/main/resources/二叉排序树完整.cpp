#include<iostream>
#define N 100
using namespace std;
struct BiNode{
    int data;
    BiNode *lchild,*rchild;
};
class BiSortTree{
private:
    BiNode *root;   //��
    void InOrder(BiNode *bt); //�������
    void Release(BiNode *bt); //�ͷŶ�����
    BiNode *SearchBST(BiNode *&bt,int k);//����
public:
    void InsertBST(BiNode *&bt,BiNode *s);//����һ�����s(�ɹ��캯������)
    BiSortTree(int r[],int n); //���캯��
    void InOrder(){InOrder(root);}  //�������
    void DeleteBST(BiNode *p,BiNode *f);//ɾ��f������p
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
    if(p->lchild==NULL&&p->rchild==NULL){  //1)pΪҶ�ӽ��
        f->lchild=NULL;
        delete p;
    }
    else if(p->rchild==NULL){   //2)pֻ������
        f->lchild=p->lchild;
        delete p;
    }
    else if(p->lchild==NULL){    //2)pֻ���Һ���
        f->lchild=p->rchild;
        delete p;
    }
    else{                        //3)���Һ��Ӷ�����
        BiNode *par=p;    //parΪs����˫�׽��
        BiNode *s=p->rchild;//sΪ�����������µĽ�㣬s��ֵ����p�������ϵ�Ԫ��ֵ��С��p��������Ԫ�ص�ֵ����s�滻p������ԭ����������������
        while(s->lchild!=NULL)//����p�������������½��
        {
            par=s;
            s=s->lchild;
        }  //ѭ��������s��Ϊp�������������½�㣬pΪs��˫�׽��
        p->data=s->data;//�滻����
        if(par==p)par->rchild=s->rchild;//�������������p���Һ���û������������par==p
        else par->lchild=s->rchild;    //����һ�����
        delete s;
    }
}
BiNode *BiSortTree::SearchBST(BiNode *&bt,int k){
    if(bt==NULL){  //����ʧ�ܣ�������������Ϊk�Ľ�㣬���Һ��ʵ�λ�ý�ֵΪk�Ľ����뵽������������
        BiNode *s=new BiNode;s->data=k;s->lchild=NULL;s->rchild=NULL;
        InsertBST(bt,s); //�����������
        return NULL;
    }
    else if(bt->data==k)return bt;  //���ҳɹ������ش˽��
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
    cout<<"����������:\n";
    int r[]={63,55,90,42,58,70,10,45,67,83};
    for(int i=0;i<10;i++)
	cout<<r[i]<<' ';
    cout<<endl;
	int n=10;
    BiSortTree bst(r,n);
    cout<<"ǰ�����:\n";
    bst.InOrder();
	cout<<'\n';
    cout<<"������Ҫ���ҵ���:";
    int k;cin>>k;
    BiNode *kk=bst.SearchBST(k);
    if(kk!=NULL){
        for(int i=0;i<n;i++)
            if(kk->data==r[i])
		cout<<"���ҳɹ��������ڶ����������е�λ���±�:"<<i<<endl;
    }
    else{
        cout<<"����ʧ�ܣ��Ѳ�������������еĺ���λ��:"<<endl;
        bst.InOrder();
		cout<<'\n';
    }
    cout<<"������Ҫɾ������(����)���丸������:";
    int del,parent;cin>>del>>parent;
    BiNode *p=bst.SearchBST(del);
    BiNode *f=bst.SearchBST(del);
    bst.DeleteBST(p,f);
    cout<<"ɾ����:";
    bst.InOrder();cout<<'\n';
	return 0;
}