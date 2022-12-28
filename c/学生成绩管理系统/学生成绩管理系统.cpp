#include<stdio.h>
#include<string.h>
#include<stdlib.h> 
/*MAXSIZE为顺序表最大长度*/
#define MAXSIZE 100

struct Student
{
	int id;          	//编号 
	char number[10]; 	//学号 
	int math;			//数学成绩 
	char name[8];		//姓名 
  	int english;		//英语成绩 
  	char sex[2];		//性别 
	int computer;		//计算机成绩 
	char major[10];		//系名 
  	int sum;			//总分 
};
// 顺序表结构 
typedef struct{
	Student* data[MAXSIZE]; //数据 
	int Length;            //长度 
}SqList;
// 菜单
void menu(){
	printf("-------学生成绩管理系统-------\n");
	printf("1.通过学号查找信息\n");
	printf("2.通过姓名查找信息\n");
	printf("3.通过位置i查找信息\n");
	printf("4.通过位置i插入一条信息\n");
	printf("5.通过位置i删除一条信息\n");
	printf("6.通过位置i修改一条信息\n");
	printf("7.根据总分进行冒泡排序\n");
	printf("8.根据总分进行快速排序\n");
	printf("9.根据总分进行选择排序\n");
	printf("10.输出全部数据\n");
	printf("0.退出\n");
} 

void CreateList(SqList *L)  //初始化顺序表 
{
	printf("开始初始化\n"); 
	L->Length=0; 
    FILE *in= fopen("111.txt", "r");		//读取同级文件下的111.txt文件 
    char buf[1024];
 	int count = 1;
 	fgets(buf, sizeof(buf), in);				
    while (fgets(buf, sizeof(buf), in) != NULL){    //将每一行读出 
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
	printf("初始化完成\n");
}
		//把所有数据输出 
void show(SqList *L){
	printf("编号\t学号\t\t姓名\t性别\t系名\t英语\t数学\t计算机\t总分\n");
	for(int i =0;i < L->Length; i++){
		printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
	}
}
		//通过学号查找 
void queryByNumber(SqList *L){
	printf("请输入学号："); 
	char str[220]; 
	scanf("%s",&str);
	for(int i =0;i < L->Length; i++){
		if(strcmp(L->data[i]->number, str) == 0){
			printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
			return; 
		}
	}
	printf("查无此人");
} 
		//通过下标查找
void queryById(SqList *L){
	printf("请输入位置i："); 
	int i;
	scanf("%d",&i);
	i = i -1; 
	if(i<L->Length && i >=0){
		printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
	}else{
		printf("查无此人");
	}
} 
		//通过姓名查找
void queryByName(SqList *L){
	printf("请输入姓名："); 
	char str[220]; 
	scanf("%s",&str);
	for(int i =0;i < L->Length; i++){
		if(strcmp(L->data[i]->name, str) == 0){
			printf("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\n",L->data[i]->id,L->data[i]->number,L->data[i]->name,L->data[i]->sex,L->data[i]->major,L->data[i]->english,L->data[i]->math,L->data[i]->computer,L->data[i]->sum);
			return; 
		}
	}
	printf("查无此人");
} 
		//插入数据 
void insert(SqList *L){
	printf("请输入位置i："); 
	int i;
	scanf("%d",&i);
	i = i -1;
	for(int j =L->Length-1;j>=i;j--){
		L->data[j+1] =L->data[j]; 
	}
	Student* s = new Student();
 	
	L->Length++;
	s->id = L->Length;	
	printf("请输入学号：\n"); 
	scanf("%s",&s->number);
	printf("请输入姓名：\n"); 
	scanf("%s",&s->name);
	printf("请输入性别：\n"); 
	scanf("%s",&s->sex);
	printf("请输入系名：\n"); 
	scanf("%s",&s->major);
	printf("请输入英语：\n"); 
	scanf("%d",&s->english);
	printf("请输入数学：\n"); 
	scanf("%d",&s->math);
	printf("请输入计算机：\n"); 
	scanf("%d",&s->computer);
	s->sum = s->english + s->math + s->computer; 
	L->data[i]= s;
	show(L);
}
		//修改数据
void update(SqList *L){
	printf("请输入位置i："); 
	int i;
	scanf("%d",&i);
	i = i -1;
	Student* s = new Student();
 	
	L->Length++;
	s->id = L->Length;	
	printf("请输入新的学号：\n"); 
	scanf("%s",&s->number);
	printf("请输入新的姓名：\n"); 
	scanf("%s",&s->name);
	printf("请输入新的性别：\n"); 
	scanf("%s",&s->sex);
	printf("请输入新的系名：\n"); 
	scanf("%s",&s->major);
	printf("请输入新的英语：\n"); 
	scanf("%d",&s->english);
	printf("请输入新的数学：\n"); 
	scanf("%d",&s->math);
	printf("请输入新的计算机：\n"); 
	scanf("%d",&s->computer);
	s->sum = s->english + s->math + s->computer; 
	L->data[i]= s;
	show(L);
}
		//删除数据
void deleteList(SqList *L){
	printf("请输入位置i："); 
	int i;
	scanf("%d",&i);
	i = i -1;
	for(int j =i;j<L->Length-1;j++){
		L->data[j] =L->data[j+1];
	}
	L->Length--;
	show(L);
}
		//冒泡排序 
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

		//快速排序 
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

		//选择排序
void arr_sort(SqList *L)
{
    int i,j;
    int min = 0;
    for(i = 0;i < L->Length - 1;i++)//排序次数
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


