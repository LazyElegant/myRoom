#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include <string.h>


struct Student
{
  char s_number[10];
  int math;
  int chinese;
  char s_name[8];
  int english;
  int geography;
  int chemistry;
  float avg; 
};

 
typedef struct node{
	Student student;
	struct node *next;//next的类型是指向本结构体数据类型的指针类型 
}Node,*LinkList;

struct Student class_1[45]; 
struct Student class_2[45]; 
struct Student class_3[45]; 
struct Student class_4[45]; 

void creat(){
	
	srand((unsigned int)time(NULL));
	printf("A班学生成绩为：\n");
	for(int i =0; i <45;i++){
		class_1[i].math =rand() % 100 + 1;
		class_1[i].chinese =rand() % 100 + 1;
		class_1[i].english =rand() % 100 + 1;
		class_1[i].geography =rand() % 100 + 1;
		class_1[i].chemistry =rand() % 100 + 1;
		int n = 2022001000;
		n = n + 1 + i;
		sprintf(class_1[i].s_number,"%d",n);
		sprintf(class_1[i].s_name,"学生%d",(i+1));
		printf("学号:%s,姓名:%s,数学成绩:%d,语文成绩:%d,英语成绩:%d,地理成绩:%d,化学成绩:%d\n",class_1[i].s_number,class_1[i].s_name,class_1[i].math,class_1[i].chinese,class_1[i].english,class_1[i].geography,class_1[i].chemistry); 
	} 
	printf("B班学生成绩为：\n");
	for(int i =0; i <45;i++){
		class_2[i].math =rand() % 100 + 1;
		class_2[i].chinese =rand() % 100 + 1;
		class_2[i].english =rand() % 100 + 1;
		class_2[i].geography =rand() % 100 + 1;
		class_2[i].chemistry =rand() % 100 + 1;
		int n = 2022001000;
		n = n + 46 + i ;
		sprintf(class_2[i].s_number,"%d",n);
		sprintf(class_2[i].s_name,"学生%d",(i+46));
		printf("学号:%s,姓名:%s,数学成绩:%d,语文成绩:%d,英语成绩:%d,地理成绩:%d,化学成绩:%d\n",class_2[i].s_number,class_2[i].s_name,class_2[i].math,class_2[i].chinese,class_2[i].english,class_2[i].geography,class_2[i].chemistry); 
	} 
	printf("C班学生成绩为：\n");
	for(int i =0; i <45;i++){
		class_3[i].math =rand() % 100 + 1;
		class_3[i].chinese =rand() % 100 + 1;
		class_3[i].english =rand() % 100 + 1;
		class_3[i].geography =rand() % 100 + 1;
		class_3[i].chemistry =rand() % 100 + 1;
		int n = 2022001000;
		n = n + 91 + i;
		sprintf(class_3[i].s_number,"%d",n);
		sprintf(class_3[i].s_name,"学生%d",(i+91));
		printf("学号:%s,姓名:%s,数学成绩:%d,语文成绩:%d,英语成绩:%d,地理成绩:%d,化学成绩:%d\n",class_3[i].s_number,class_3[i].s_name,class_3[i].math,class_3[i].chinese,class_3[i].english,class_3[i].geography,class_3[i].chemistry); 
	} 
}
void avg(){
	for(int i = 0;i<45;i++){
		int sum = class_1[i].math + class_1[i].chinese + class_1[i].english + class_1[i].chemistry + class_1[i].geography; 
		class_1[i].avg = (float)sum /5;
		sum = class_2[i].math + class_2[i].chinese + class_2[i].english + class_2[i].chemistry + class_2[i].geography; 
		class_2[i].avg = (float)sum /5;
		sum = class_3[i].math + class_3[i].chinese + class_3[i].english + class_3[i].chemistry + class_3[i].geography; 
		class_3[i].avg = (float)sum /5;
	}
	printf("A班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_1[i].s_number,class_1[i].s_name,class_1[i].avg); 
	}
	printf("B班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_2[i].s_number,class_2[i].s_name,class_2[i].avg); 
	}
	printf("C班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_3[i].s_number,class_3[i].s_name,class_3[i].avg); 
	}
	
} 
void maopao(){
	for (int i = 0; i < 45; i++)//每轮将一个最大的数放置末尾，剩下一个数默认最小不需要再循环
	{
		int j = 0;
		for (j = 0; j < 45 - 1 - i; j++)//每轮循环确定一个最大的数，前面的数都比它小，所以每一轮进行比较的数减少一个
		{
			if (class_1[j].avg <class_1[j+1].avg)//数据交换
			{
				Student temp ;
				temp = class_1[j];
				class_1[j]= class_1[j+1];
				class_1[j+1] = temp;
			}
			if (class_2[j].avg <class_2[j+1].avg)//数据交换
			{
				Student temp ;
				temp = class_2[j];
				class_2[j]= class_2[j+1];
				class_2[j+1] = temp;
			}
			if (class_3[j].avg <class_3[j+1].avg)//数据交换
			{
				Student temp ;
				temp = class_3[j];
				class_3[j]= class_3[j+1];
				class_3[j+1] = temp;
			}
		}
	}
	printf("A班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_1[i].s_number,class_1[i].s_name,class_1[i].avg); 
	}
	printf("B班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_2[i].s_number,class_2[i].s_name,class_2[i].avg); 
	}
	printf("C班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_3[i].s_number,class_3[i].s_name,class_3[i].avg); 
	}
} 
void xz(){
	for (int i = 0; i <44; i++)
	{
		for (int j = i + 1; j < 45; j++)
		{
			if (class_1[i].avg < class_1[j].avg)
			{
				Student temp = class_1[i];
				class_1[i] = class_1[j];
				class_1[j] = temp;
			}
			if (class_2[i].avg < class_2[j].avg)
			{
				Student temp = class_2[i];
				class_2[i] = class_2[j];
				class_2[j] = temp;
			}
			if (class_3[i].avg < class_3[j].avg)
			{
				Student temp = class_3[i];
				class_3[i] = class_3[j];
				class_3[j] = temp;
			}
		}
	}
	printf("A班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_1[i].s_number,class_1[i].s_name,class_1[i].avg); 
	}
	printf("B班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_2[i].s_number,class_2[i].s_name,class_2[i].avg); 
	}
	printf("C班学生成绩为：\n");
	for(int i =0; i <45;i++){
		printf("学号:%s,姓名:%s,平均分:%.2lf\n",class_3[i].s_number,class_3[i].s_name,class_3[i].avg); 
	}
}

 
//单链表的初始化：就是创建一个头结点  
LinkList InitList()
{
	LinkList head;//定义头指针变量 
	head = (Node*)malloc(sizeof(Node));//头指针指向分配的头结点内存空间 
	head->next=NULL;//头指针指针域为空 
	return head;//返回头结点地址，即头指针 
}
 
//尾插法创建单链表 
void CreatByRear(LinkList head,Student student)
{
	Node *r,*s;//s指向新创建的结点 
	r = head;
	while(r->next != NULL)
	{
		r = r->next;
	}
	
	s = (Node*)malloc(sizeof(Node));//分配结点的内存空间 ，令s指向新分配的内存 
	//分别赋值姓名和学号 
	s->student = student;
	r->next = s;//原来的结点指向新结点 
	r = s;//r指向新结点 
	r->next = NULL;//链表的尾结点指针为空 
}
//单链表的遍历
void OutPut(LinkList head)
{
	Node *p;//循环所用的临时指针 
	p = head->next ;//p指向链表的首元结点 
	while (p)
	{
		printf ("姓名:%s,",p->student.s_name);//输出姓名 
		printf ("学号:%s\n",p->student.s_number);//输出学号 
		p = p->next; //移动临时指针到下一个结点 
	}  	
}
void creatNode(){
	LinkList ha;
	ha = InitList();
	for(int i =0;i <45 ; i++){
		CreatByRear(ha,class_1[i]);
	}
	for(int i =0;i <45 ; i++){
		CreatByRear(ha,class_2[i]);
	}
	for(int i =0;i <45 ; i++){
		CreatByRear(ha,class_3[i]);
	}
	OutPut(ha);
}

void meun(){
	printf("-----成绩排序-----\n");
	printf("1.生成学生成绩\n");
	printf("2.计算平均成绩\n");
	printf("3.冒泡排序\n"); 
	printf("4.选择排序\n"); 
	printf("5.创建链表\n");
	printf("6.退出\n");
}
 
int main(){
	int sel = 0;
	while(sel != 6){
		meun();
		scanf("%d",&sel);
		switch(sel){
			case 1:
				creat(); 
				break;
			case 2:
				avg();
				break;
			case 3:
				maopao();
				break;
			case 4:
				xz();
				break;
			case 5:
				creatNode();
				break;
		}
	}
	return 0;
} 
