#include<stdio.h>
#include<string.h>
#include<stdlib.h> 
/*MAXSIZEΪ˳�����󳤶�*/
#define MAXSIZE 100

struct Student
{
	int id;          	//��� 
	char number[10]; 	//ѧ�� 
	int math;			//��ѧ�ɼ� 
	char name[8];		//���� 
  	int english;		//Ӣ��ɼ� 
  	char sex[2];		//�Ա� 
	int computer;		//������ɼ� 
	char major[10];		//ϵ�� 
  	int sum;			//�ܷ� 
};
// ˳���ṹ 
typedef struct{
	Student* data[MAXSIZE]; //���� 
	int Length;            //���� 
}SqList;
// �˵�
void menu(){
	printf("-------ѧ���ɼ�����ϵͳ-------\n");
	printf("1.ͨ��ѧ�Ų�����Ϣ\n");
	printf("2.ͨ������������Ϣ\n");
	printf("3.ͨ��λ��i������Ϣ\n");
	printf("4.ͨ��λ��i����һ����Ϣ\n");
	printf("5.ͨ��λ��iɾ��һ����Ϣ\n");
	printf("6.ͨ��λ��i�޸�һ����Ϣ\n");
	printf("7.�����ֽܷ���ð������\n");
	printf("8.�����ֽܷ��п�������\n");
	printf("9.�����ֽܷ���ѡ������\n");
	printf("10.���ȫ������\n");
	printf("0.�˳�\n");
} 

void CreateList(SqList *L)  //��ʼ��˳��� 
{
	printf("��ʼ��ʼ��\n"); 
	L->Length=0; 
    FILE *in= fopen("111.txt", "r");		//��ȡͬ���ļ��µ�111.txt�ļ� 
    char buf[1024];
 	int count = 1;
 	fgets(buf, sizeof(buf), in);				
    while (fgets(buf, sizeof(buf), in) != NULL){    //��ÿһ�ж��� 
    	Student* s = new Student();
	 	s->id = count++;	
		char* str1 = strtok(buf, "\t");
		str1 = strtok(NULL, "\t");
		strcpy(s->number ,str1);
		str1 = strtok(NULL, "\t");
		strcpy(s->name ,str1);
		str1 = strtok(NULL, "\t");
		strcpy(s->sex ,str1);
		str1 = strtok(NULL, "\t");
		strcpy(s->major ,str1);
		str1 = strtok(NULL, "\t");
		s->english = (str1[0] -'0') *10; 
		s->english = s->english + (str1[1] - '0');
		str1 = strtok(NULL, "\t");
		s->math = (str1[0] -'0') *10; 
		s->math = s->math + (str1[1] - '0');
		str1 = strtok(NULL, "\t");
		s->computer = (str1[0] -'0') *10; 
		s->computer = s->computer + (str1[1] - '0');
		s->sum = s->english + s->math + s->computer; 
		L->data[L->Length++]=s;
	}
 
    fclose(in);
	printf("��ʼ�����\n");
}
		//������������� 
void show(SqList *L){
	printf("���\tѧ��\t\t����\t�Ա�\tϵ��\tӢ��\t��ѧ\t�����\t�ܷ�\n");
	for(int i =0;i < L->Length; i++){
		printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
	}
}
		//ͨ��ѧ�Ų��� 
void queryByNumber(SqList *L){
	printf("������ѧ�ţ�"); 
	char str[220]; 
	scanf("%s",&str);
	for(int i =0;i < L->Length; i++){
		if(strcmp(L->data[i]->number, str) == 0){
			printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
			return; 
		}
	}
	printf("���޴���");
} 
		//ͨ���±����
void queryById(SqList *L){
	printf("������λ��i��"); 
	int i;
	scanf("%d",&i);
	i = i -1; 
	if(i<L->Length && i >=0){
		printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
	}else{
		printf("���޴���");
	}
} 
		//ͨ����������
void queryByName(SqList *L){
	printf("������������"); 
	char str[220]; 
	scanf("%s",&str);
	for(int i =0;i < L->Length; i++){
		if(strcmp(L->data[i]->name, str) == 0){
			printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
			return; 
		}
	}
	printf("���޴���");
} 
		//�������� 
void insert(SqList *L){
	printf("������λ��i��"); 
	int i;
	scanf("%d",&i);
	i = i -1;
	for(int j =L->Length-1;j>=i;j--){
		L->data[j+1] =L->data[j]; 
	}
	Student* s = new Student();
 	
	L->Length++;
	s->id = L->Length;	
	printf("������ѧ�ţ�\n"); 
	scanf("%s",&s->number);
	printf("������������\n"); 
	scanf("%s",&s->name);
	printf("�������Ա�\n"); 
	scanf("%s",&s->sex);
	printf("������ϵ����\n"); 
	scanf("%s",&s->major);
	printf("������Ӣ�\n"); 
	scanf("%d",&s->english);
	printf("��������ѧ��\n"); 
	scanf("%d",&s->math);
	printf("������������\n"); 
	scanf("%d",&s->computer);
	s->sum = s->english + s->math + s->computer; 
	L->data[i]= s;
	show(L);
}
		//�޸�����
void update(SqList *L){
	printf("������λ��i��"); 
	int i;
	scanf("%d",&i);
	i = i -1;
	Student* s = new Student();
 	
	L->Length++;
	s->id = L->Length;	
	printf("�������µ�ѧ�ţ�\n"); 
	scanf("%s",&s->number);
	printf("�������µ�������\n"); 
	scanf("%s",&s->name);
	printf("�������µ��Ա�\n"); 
	scanf("%s",&s->sex);
	printf("�������µ�ϵ����\n"); 
	scanf("%s",&s->major);
	printf("�������µ�Ӣ�\n"); 
	scanf("%d",&s->english);
	printf("�������µ���ѧ��\n"); 
	scanf("%d",&s->math);
	printf("�������µļ������\n"); 
	scanf("%d",&s->computer);
	s->sum = s->english + s->math + s->computer; 
	L->data[i]= s;
	show(L);
}
		//ɾ������
void deleteList(SqList *L){
	printf("������λ��i��"); 
	int i;
	scanf("%d",&i);
	i = i -1;
	for(int j =i;j<L->Length-1;j++){
		L->data[j] =L->data[j+1];
	}
	L->Length--;
	show(L);
}
		//ð������ 
void Bubble_sort(SqList *L)
{
	int j,i;
	Student* tem;
	
	for (i = 0; i < L->Length-1;i ++)
	{
		int count = 0;
		for (j = 0; j <  L->Length-1 - i; j++)
		{
			if (L->data[j]->sum > L->data[j+1]->sum)
			{
				tem = L->data[j];
				L->data[j]=L->data[j+1];
				L->data[j+1]= tem;
				count = 1;
				
			}
		}
		if (count == 0)
				break;	
	}
	show(L); 
}

		//�������� 
void Quick_Sort(SqList *L, int l, int r) {
	if (l < r) {
		int i, j, x;
		i = l;
		j = r;
		x = L->data[i]->sum;
		Student* tem = L->data[i]; 
		while(i<j) {
			while (i<j &&  L->data[j]->sum>x) {
				j--;
			}
			if (i < j) {
				 L->data[i++] = L->data[j];
			}
			while (i < j &&  L->data[i]->sum < x) {
				i++; 
			}
			if (i < j) {
				L->data[j--] = L->data[i];
			}
		}
		L->data[i] = tem;
		Quick_Sort(L, l, i - 1);
		Quick_Sort(L, i+1, r);
	}
}

		//ѡ������
void arr_sort(SqList *L)
{
    int i,j;
    int min = 0;
    for(i = 0;i < L->Length - 1;i++)//�������
    {
        min = i;
        for(j = i + 1;j < L->Length-1;j++)
        {
            if(L->data[j]->sum < L->data[min]->sum)
            {
                min = j;
            }
        }
        if(i != min)
        {
            Student* temp = L->data[i];
            L->data[i] = L->data[min];
            L->data[min] = temp;
        }
    }
}

int main()
{
    SqList L;
 	CreateList(&L);
 	show(&L);
 	int select =-1;
 	while(select != 0){
 		menu();
		scanf("%d",&select);
		switch(select){
			case 1:
				queryByNumber(&L);
				break; 
			case 2:
				queryByName(&L);
				break;
			case 3:
				queryById(&L);
				break;
			case 4:
				insert(&L);
				break;
			case 5:
				deleteList(&L); 
				break;
			case 6:
				update(&L);
				break;
			case 7:
				Bubble_sort(&L);
				break;
			case 8:
				Quick_Sort(&L, 0, L.Length-1);
				show(&L);
				break;
			case 9:
				arr_sort(&L); 
				break;
			case 10:
				show(&L);
				break;
		}	
	}
    return 0;
}


