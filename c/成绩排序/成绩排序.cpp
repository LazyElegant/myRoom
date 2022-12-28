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
	struct node *next;//next��������ָ�򱾽ṹ���������͵�ָ������ 
}Node,*LinkList;

struct Student class_1[45]; 
struct Student class_2[45]; 
struct Student class_3[45]; 
struct Student class_4[45]; 

void creat(){
	
	srand((unsigned int)time(NULL));
	printf("A��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		class_1[i].math =rand() % 100 + 1;
		class_1[i].chinese =rand() % 100 + 1;
		class_1[i].english =rand() % 100 + 1;
		class_1[i].geography =rand() % 100 + 1;
		class_1[i].chemistry =rand() % 100 + 1;
		int n = 2022001000;
		n = n + 1 + i;
		sprintf(class_1[i].s_number,"%d",n);
		sprintf(class_1[i].s_name,"ѧ��%d",(i+1));
		printf("ѧ��:%s,����:%s,��ѧ�ɼ�:%d,���ĳɼ�:%d,Ӣ��ɼ�:%d,����ɼ�:%d,��ѧ�ɼ�:%d\n",class_1[i].s_number,class_1[i].s_name,class_1[i].math,class_1[i].chinese,class_1[i].english,class_1[i].geography,class_1[i].chemistry); 
	} 
	printf("B��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		class_2[i].math =rand() % 100 + 1;
		class_2[i].chinese =rand() % 100 + 1;
		class_2[i].english =rand() % 100 + 1;
		class_2[i].geography =rand() % 100 + 1;
		class_2[i].chemistry =rand() % 100 + 1;
		int n = 2022001000;
		n = n + 46 + i ;
		sprintf(class_2[i].s_number,"%d",n);
		sprintf(class_2[i].s_name,"ѧ��%d",(i+46));
		printf("ѧ��:%s,����:%s,��ѧ�ɼ�:%d,���ĳɼ�:%d,Ӣ��ɼ�:%d,����ɼ�:%d,��ѧ�ɼ�:%d\n",class_2[i].s_number,class_2[i].s_name,class_2[i].math,class_2[i].chinese,class_2[i].english,class_2[i].geography,class_2[i].chemistry); 
	} 
	printf("C��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		class_3[i].math =rand() % 100 + 1;
		class_3[i].chinese =rand() % 100 + 1;
		class_3[i].english =rand() % 100 + 1;
		class_3[i].geography =rand() % 100 + 1;
		class_3[i].chemistry =rand() % 100 + 1;
		int n = 2022001000;
		n = n + 91 + i;
		sprintf(class_3[i].s_number,"%d",n);
		sprintf(class_3[i].s_name,"ѧ��%d",(i+91));
		printf("ѧ��:%s,����:%s,��ѧ�ɼ�:%d,���ĳɼ�:%d,Ӣ��ɼ�:%d,����ɼ�:%d,��ѧ�ɼ�:%d\n",class_3[i].s_number,class_3[i].s_name,class_3[i].math,class_3[i].chinese,class_3[i].english,class_3[i].geography,class_3[i].chemistry); 
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
	printf("A��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_1[i].s_number,class_1[i].s_name,class_1[i].avg); 
	}
	printf("B��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_2[i].s_number,class_2[i].s_name,class_2[i].avg); 
	}
	printf("C��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_3[i].s_number,class_3[i].s_name,class_3[i].avg); 
	}
	
} 
void maopao(){
	for (int i = 0; i < 45; i++)//ÿ�ֽ�һ������������ĩβ��ʣ��һ����Ĭ����С����Ҫ��ѭ��
	{
		int j = 0;
		for (j = 0; j < 45 - 1 - i; j++)//ÿ��ѭ��ȷ��һ����������ǰ�����������С������ÿһ�ֽ��бȽϵ�������һ��
		{
			if (class_1[j].avg <class_1[j+1].avg)//���ݽ���
			{
				Student temp ;
				temp = class_1[j];
				class_1[j]= class_1[j+1];
				class_1[j+1] = temp;
			}
			if (class_2[j].avg <class_2[j+1].avg)//���ݽ���
			{
				Student temp ;
				temp = class_2[j];
				class_2[j]= class_2[j+1];
				class_2[j+1] = temp;
			}
			if (class_3[j].avg <class_3[j+1].avg)//���ݽ���
			{
				Student temp ;
				temp = class_3[j];
				class_3[j]= class_3[j+1];
				class_3[j+1] = temp;
			}
		}
	}
	printf("A��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_1[i].s_number,class_1[i].s_name,class_1[i].avg); 
	}
	printf("B��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_2[i].s_number,class_2[i].s_name,class_2[i].avg); 
	}
	printf("C��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_3[i].s_number,class_3[i].s_name,class_3[i].avg); 
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
	printf("A��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_1[i].s_number,class_1[i].s_name,class_1[i].avg); 
	}
	printf("B��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_2[i].s_number,class_2[i].s_name,class_2[i].avg); 
	}
	printf("C��ѧ���ɼ�Ϊ��\n");
	for(int i =0; i <45;i++){
		printf("ѧ��:%s,����:%s,ƽ����:%.2lf\n",class_3[i].s_number,class_3[i].s_name,class_3[i].avg); 
	}
}

 
//������ĳ�ʼ�������Ǵ���һ��ͷ���  
LinkList InitList()
{
	LinkList head;//����ͷָ����� 
	head = (Node*)malloc(sizeof(Node));//ͷָ��ָ������ͷ����ڴ�ռ� 
	head->next=NULL;//ͷָ��ָ����Ϊ�� 
	return head;//����ͷ����ַ����ͷָ�� 
}
 
//β�巨���������� 
void CreatByRear(LinkList head,Student student)
{
	Node *r,*s;//sָ���´����Ľ�� 
	r = head;
	while(r->next != NULL)
	{
		r = r->next;
	}
	
	s = (Node*)malloc(sizeof(Node));//��������ڴ�ռ� ����sָ���·�����ڴ� 
	//�ֱ�ֵ������ѧ�� 
	s->student = student;
	r->next = s;//ԭ���Ľ��ָ���½�� 
	r = s;//rָ���½�� 
	r->next = NULL;//�����β���ָ��Ϊ�� 
}
//������ı���
void OutPut(LinkList head)
{
	Node *p;//ѭ�����õ���ʱָ�� 
	p = head->next ;//pָ���������Ԫ��� 
	while (p)
	{
		printf ("����:%s,",p->student.s_name);//������� 
		printf ("ѧ��:%s\n",p->student.s_number);//���ѧ�� 
		p = p->next; //�ƶ���ʱָ�뵽��һ����� 
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
	printf("-----�ɼ�����-----\n");
	printf("1.����ѧ���ɼ�\n");
	printf("2.����ƽ���ɼ�\n");
	printf("3.ð������\n"); 
	printf("4.ѡ������\n"); 
	printf("5.��������\n");
	printf("6.�˳�\n");
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
