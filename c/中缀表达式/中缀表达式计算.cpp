#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<string.h>
#include<ctype.h>

#define ERROR 0
#define OK 1
#define STACK_INT_SIZE 10  /*�洢�ռ��ʼ������*/
#define STACKINCREMENT 5  /*�洢�ռ��������*/
#define M 50

typedef char ElemType; /*�����ַ���������*/
typedef double ElemType2;  /*������������������*/

/*�ַ�ջ*/
typedef struct {
	ElemType *base;
	ElemType *top;
	int stacksize;
} SqStack;

/*������ջ*/
typedef struct {
	ElemType2 *base;
	ElemType2 *top;
	int stacksize;
} NStack;

int InitStack(SqStack *S);   /*�����ջ*/
int push(SqStack *S,ElemType e); /*��ջ*/
int Pop(SqStack *S,ElemType *e);  /*��ջ*/
int StackEmpty(SqStack *s);  /*ջ���ж�*/
void in2post(ElemType *str,ElemType *p);  /*��׺���ʽת��׺���ʽ*/
double cal_post(char *str);  /*�����׺���ʽ*/

/*�ַ�ջ��ʼ��*/
int InitStack(SqStack *S) {
	S->base=(ElemType *)malloc(STACK_INT_SIZE * sizeof(ElemType));
	if(!S->base)
		return ERROR;  //����ʧ��
	S->top = S->base;
	S->stacksize = STACK_INT_SIZE;
	return OK;
}/*InitStack*/

/*������ջ��ʼ��*/
int InitStack_N(NStack *S) {
	S->base=(ElemType2 *)malloc(STACK_INT_SIZE * sizeof(ElemType2));
	if(!S->base)
		return ERROR;
	S->top = S->base;
	S->stacksize = STACK_INT_SIZE;
	return OK;
}

/*�ַ�ջ��ջ*/
int Push(SqStack *S,ElemType e) {
	//�ж�ջ��
	if(S->top - S->base >= S->stacksize) {
		S->base = (ElemType *)realloc(S->base,(S->stacksize + STACKINCREMENT)*sizeof(ElemType));
		if(NULL == S->base)  //����ʧ��
			return ERROR;
		S->top = S->base + S->stacksize;
		S->stacksize = S->stacksize+STACKINCREMENT;
	}
	*S->top = e;
	S->top++;
	return OK;
}

/*������ջ��ջ*/
int Push_N(NStack *S,ElemType2 e) {
	if(S->top - S->base >= S->stacksize) {
		S->base = (ElemType2 *)realloc(S->base,(S->stacksize + STACKINCREMENT)*sizeof(ElemType2));
		if(NULL == S->base)
			return ERROR;
		S->top = S->base + S->stacksize;
		S->stacksize = S->stacksize+STACKINCREMENT;
	}
	*S->top = e;
	S->top++;
	return OK;
}

/*�ַ�ջ��ջ*/
int Pop(SqStack *S,ElemType *e) {
	//�ж�ջ��
	if(S->top == S->base)
		return ERROR;
	S->top--;
	*e=*S->top;
	return OK;
}/*Pop*/

/*������ջ��ջ*/
int Pop_N(NStack *S,ElemType2 *e) {
	if(S->top == S->base)
		return ERROR;
	S->top--;
	*e=*S->top;
	return OK;
}

/*�ж�ջ��*/
int StackEmpty(SqStack *s) {
	if(s->top == s->base)
		return OK;
	return ERROR;
}/*StackEmpty*/

//strΪ��ת������׺���ʽ�ַ���,pΪת����ĺ�׺���ʽ�ַ���
void in2post(ElemType *str,ElemType *p) {  /*infix to postfix*/
	SqStack s;
	InitStack(&s);   //��ʼ��һ�����ַ�ջ
	ElemType e;
	int i;
	int j=0;
	for(i=0 ; i<strlen(str) ; i++) { //������׺���ʽ
		//�������ֺ�С����ֱ�����
		//ʹ��ѭ����������һ��������
		while(isdigit(str[i]) || '.'==str[i]) {
			p[j++]=str[i++];
			if(!isdigit(str[i]) && '.'!=str[i])
				p[j++]=' ';   //һ���������������ʹ�ÿո�����������������ַָ���
		}

		//����������ֱ����ջ
		if('('==str[i])
			Push(&s,str[i]);

		//����������ֱ�ӳ�ջ��ֱ��ջ��Ϊ������
		if(')'==str[i]) {
			while('(' != *(s.top-1)) {
				Pop(&s,&e);
				p[j++]=e;
				p[j++]=' ';
			}
			Pop(&s,&e);  //�����ų�ջ�������
		}

		//����+��
		//1.ջ��/ջ��Ϊ������:ֱ����ջ
		//2.����һֱ��ջ,ֱ��ջ��/ջ��Ϊ������,����ջ
		if('+'==str[i] || '-'==str[i]) {
			while(!StackEmpty(&s) && '('!=*(s.top-1)) {
				Pop(&s,&e);
				p[j++]=e;
				p[j++]=' ';
			}
			Push(&s,str[i]);
		}

		//����*��/
		//1.ջ��/ջ��Ϊ������/ջ��������Ϊ+ or -:ֱ����ջ
		//2.����һֱ��ջ,ֱ������1,����ջ
		if('*'==str[i] || '/'==str[i] || '%'==str[i]) {
			while(!StackEmpty(&s) && '('!=*(s.top-1) && '+'!=*(s.top-1) && '-'!=*(s.top-1)) {
				Pop(&s,&e);
				p[j++]=e;
				p[j++]=' ';
			}
			Push(&s,str[i]);
		}
	}
	//��׺���ʽ�������,������ջ���Ƿ���δ����ַ�
	//�ж�ջ��,�ǿ���ֱ�ӳ�ջ�����(�����Ų������)
	while(!StackEmpty(&s)) {
		Pop(&s,&e);
		if('('!=e)
			p[j++]=e;
		p[j++]=' ';
	}
	p[--j]='\0';
}/*infix2postfix*/

//strΪ������ĺ�׺���ʽ,����ֵΪ������
double cal_post(char *str) {  /*�����׺���ʽ*/
	int i;
	ElemType2 e,a,b;
	char d[M];
	NStack n;
	InitStack_N(&n);   //��ʼ��һ��������ջ����������
	for(i=0; i<strlen(str); i++) {
		int j=0;
		while(isdigit(str[i]) || '.'==str[i]) {
			d[j++]=str[i++];
			d[j]='\0';
			if(!isdigit(str[i]) && '.'!=str[i]) {
				e=atof(d);   //ʹ��atof()���ַ�����ʽ��������ת��Ϊdouble������
				Push_N(&n,e);   //��������ջ
			}
		}
		switch(str[i]) {
			case '+':
				Pop_N(&n,&b);
				Pop_N(&n,&a);
				Push_N(&n,a+b);
				break;
			case '-':
				Pop_N(&n,&b);
				Pop_N(&n,&a);
				Push_N(&n,a-b);
				break;
			case '*':
				Pop_N(&n,&b);
				Pop_N(&n,&a);
				Push_N(&n,a*b);
				break;
			case '/':
				Pop_N(&n,&b);
				Pop_N(&n,&a);
				Push_N(&n,a/b);
				break;
		}
	}
	Pop_N(&n,&e);
	return e;
}/*calculate_postfix*/

int main() {
	char str[M];
	char post[M];
	int i;
	printf("\n����һ����׺���ʽ��\n");
	gets(str);
	in2post(str,post);
	printf("\n\n�����׺���ʽ��\n");
	printf("%f",cal_post(post));
		
	return 0;
}
