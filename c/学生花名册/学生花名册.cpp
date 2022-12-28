#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node{
	char name[20];		//���� 
	int number;			//ѧ�� 
	char phone[20]; 	//�绰 
	struct node *next;	//ָ����һ���ڵ� 
}Node,*LinkList;

LinkList InitList()		//��ʼ������ 
{
	LinkList head;
	head = (Node*)malloc(sizeof(Node));
	head->next=NULL; 
	return head;
}

void meun(){   //�˵� 
	printf("-----ѧ�����������ϵͳ-----\n");
	printf("1.���ѧ����Ϣ\n");
	printf("2.��ָ��λ�ò���ѧ����Ϣ\n");
	printf("3.�޸�ѧ����Ϣ\n");
	printf("4.ɾ��ѧ����Ϣ\n");
	printf("5.��ʾ����ѧ��\n");
	printf("6.�˳�ϵͳ\n");
} 

void CreatByRear(LinkList head)  //���ѧ����Ϣ 
{
	Node *r,*s; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	while(r->next != NULL){
		r = r->next;	
	}
	int n = 0;
	printf ("�������м���ѧ����\n");
	scanf ("%d",&n); 
	for(int i = 0;i < n; i++){
		printf ("������ѧ��������\n");
		scanf ("%s",name);
		printf ("������ѧ��ѧ�ţ�\n");
		scanf ("%d",&number);
		printf ("������ѧ���绰��\n");
		scanf ("%s",phone);
		s = (Node*)malloc(sizeof(Node));
		strcpy(s->name ,name);
		s->number = number;
		strcpy(s->phone ,phone);
		r->next = s;//ԭ���Ľ��ָ���½�� 
		r = s;//rָ���½�� 
	}
	r->next = NULL;//�����β���ָ��Ϊ�� 
}

void Insert(LinkList head)  //���뺯�� 
{
	Node *r,*s; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	int indx = 0;
	printf("������Ҫ�����λ��(��0��ʼ)") ;
	scanf("%d",&indx);
	for(int i = 0; i< indx;i++){
		r = r->next;
		if(r == NULL){
			printf("�±�Խ��!!!\n");
			return;
		}	
	}
	printf ("������ѧ��������\n");
	scanf ("%s",name);
	printf ("������ѧ��ѧ�ţ�\n");
	scanf ("%d",&number);
	printf ("������ѧ���绰��\n");
	scanf ("%s",phone);
	s = (Node*)malloc(sizeof(Node));
	strcpy(s->name ,name);
	s->number = number;
	strcpy(s->phone ,phone);
	s->next = r->next;
	r->next = s;//ԭ���Ľ��ָ���½�� 
}

void Update(LinkList head)  //���뺯�� 
{
	Node *r; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	int indx = 0;
	printf("������Ҫ�޸ĵ�ѧ����ѧ��") ;
	scanf("%d",&indx);
	while(r->next!=NULL){
		r = r->next;
		if(r->number == indx){
			printf ("������Ҫ�޸ĵ�ѧ��������\n");
			scanf ("%s",name);
			printf ("������Ҫ�޸ĵ�ѧ���绰��\n");
			scanf ("%s",phone);
			strcpy(r->name ,name);
			strcpy(r->phone ,phone);	
			printf("�޸ĳɹ�!\n");
			return; 
		}
	}
	printf("���޴��ˣ�����\n");
}

void Delete(LinkList head)  //ɾ��ѧ������ 
{
	Node *r; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	int indx = 0;
	printf("������Ҫɾ����ѧ����ѧ��") ;
	scanf("%d",&indx);
	while(r->next!=NULL){
		if(r->next->number == indx){
			r->next = r->next->next;
			printf("ɾ���ɹ�!\n");
			
			return; 
	
		}
		r = r->next;
	
	}
	printf("���޴��ˣ�����\n");
}
void Show(LinkList head) //��ʾѧ����Ϣ 
{
	Node *p;
	p = head->next;
	while (p)
	{
		printf ("����:%s",p->name);
		printf ("ѧ��:%d",p->number);
		printf ("�绰:%s\n",p->phone);
		p = p->next; //ָ���ƶ�����һ����� 
	}  	
} 

int main(){
	LinkList ha,hb;//���嵥����ͷָ�� 
	ha = InitList();//��ʼ�������� 
	int select = 0;
	while(select != 6){
		meun();
		scanf("%d",&select);
		switch(select){
			case 1:
				CreatByRear(ha); 
				break;
			case 2:
				Insert(ha);
				break;
			case 3:
				Update(ha);
				break;
			case 4:
				Delete(ha);
				break;
			case 5:
				Show(ha);
				break;
		}
	} 
	printf("��лʹ�ã�����"); 
	return 0;
}
