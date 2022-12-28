#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node{
	char name[20];		//姓名 
	int number;			//学号 
	char phone[20]; 	//电话 
	struct node *next;	//指向下一个节点 
}Node,*LinkList;

LinkList InitList()		//初始化函数 
{
	LinkList head;
	head = (Node*)malloc(sizeof(Node));
	head->next=NULL; 
	return head;
}

void meun(){   //菜单 
	printf("-----学生花名册管理系统-----\n");
	printf("1.添加学生信息\n");
	printf("2.按指定位置插入学生信息\n");
	printf("3.修改学生信息\n");
	printf("4.删除学生信息\n");
	printf("5.显示所有学生\n");
	printf("6.退出系统\n");
} 

void CreatByRear(LinkList head)  //添加学生信息 
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
	printf ("请输入有几个学生：\n");
	scanf ("%d",&n); 
	for(int i = 0;i < n; i++){
		printf ("请输入学生姓名：\n");
		scanf ("%s",name);
		printf ("请输入学生学号：\n");
		scanf ("%d",&number);
		printf ("请输入学生电话：\n");
		scanf ("%s",phone);
		s = (Node*)malloc(sizeof(Node));
		strcpy(s->name ,name);
		s->number = number;
		strcpy(s->phone ,phone);
		r->next = s;//原来的结点指向新结点 
		r = s;//r指向新结点 
	}
	r->next = NULL;//链表的尾结点指针为空 
}

void Insert(LinkList head)  //插入函数 
{
	Node *r,*s; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	int indx = 0;
	printf("请输入要插入的位置(从0开始)") ;
	scanf("%d",&indx);
	for(int i = 0; i< indx;i++){
		r = r->next;
		if(r == NULL){
			printf("下标越界!!!\n");
			return;
		}	
	}
	printf ("请输入学生姓名：\n");
	scanf ("%s",name);
	printf ("请输入学生学号：\n");
	scanf ("%d",&number);
	printf ("请输入学生电话：\n");
	scanf ("%s",phone);
	s = (Node*)malloc(sizeof(Node));
	strcpy(s->name ,name);
	s->number = number;
	strcpy(s->phone ,phone);
	s->next = r->next;
	r->next = s;//原来的结点指向新结点 
}

void Update(LinkList head)  //插入函数 
{
	Node *r; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	int indx = 0;
	printf("请输入要修改的学生的学号") ;
	scanf("%d",&indx);
	while(r->next!=NULL){
		r = r->next;
		if(r->number == indx){
			printf ("请输入要修改的学生姓名：\n");
			scanf ("%s",name);
			printf ("请输入要修改的学生电话：\n");
			scanf ("%s",phone);
			strcpy(r->name ,name);
			strcpy(r->phone ,phone);	
			printf("修改成功!\n");
			return; 
		}
	}
	printf("查无此人！！！\n");
}

void Delete(LinkList head)  //删除学生数据 
{
	Node *r; 
	char name[20];
	int number;
	char phone[20]; 
	r = head;
	int indx = 0;
	printf("请输入要删除的学生的学号") ;
	scanf("%d",&indx);
	while(r->next!=NULL){
		if(r->next->number == indx){
			r->next = r->next->next;
			printf("删除成功!\n");
			
			return; 
	
		}
		r = r->next;
	
	}
	printf("查无此人！！！\n");
}
void Show(LinkList head) //显示学生信息 
{
	Node *p;
	p = head->next;
	while (p)
	{
		printf ("姓名:%s",p->name);
		printf ("学号:%d",p->number);
		printf ("电话:%s\n",p->phone);
		p = p->next; //指针移动到下一个结点 
	}  	
} 

int main(){
	LinkList ha,hb;//定义单链表头指针 
	ha = InitList();//初始化单链表 
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
	printf("感谢使用！！！"); 
	return 0;
}
