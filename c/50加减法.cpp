#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int score = 100;  // �÷� 

void calculate(int result,int answer){  //������ 
	if(result == answer){  //��һ�λش� 
		printf("\n�ش���ȷ\n");
		return;  //�����ȷ�������� 
	}else{
		score -= 3; //������ 
		printf("\n�ش���������»ش�\n");
	}
	
	scanf("%d",&answer);
	if(result == answer){
		printf("\n�ش���ȷ\n");
		return;
	}else{
		score -= 2; //������
		printf("\n�ش���������»ش�\n");
	}
	
	scanf("%d",&answer);
	if(result == answer){
		printf("\n�ش���ȷ\n");
	}else{
		score -= 5; //�����
		printf("\n�ش����\n");
	}
}

main(){
	char name[100];  // ���� 
	char date[30];  // ���� 
	
	printf("�������������:");
	gets(name);   //��ȡ���� 
	
	printf("\n��ʼ����:\n");
	for(int i = 1; i<=10 ; i++){
		srand((unsigned)time(NULL));
		int random = rand() % 2;       // ���� 0 �� 1 ֮�������� �������ж������ü������Ǽӷ� 
		int left = 0; 
		int right = 0;
		int result = 0; 
		int answer = 0; 
		
		if(random==1){ 	// ���� 
			left = rand() % 50+ 1; 	// ���� 1 �� 50 ֮�������� 
			do{
				right = rand() % 51; 
			}while(left < right);   // �����ߵ���С���ұߵ��������¸��ұ߸�ֵ��ȷ��������ָ��� 
			
			
			printf("��%d��:%d-%d=",i,left,right);
			
			result = left - right; 		// ����� 
			scanf("%d",&answer); 		// ��ȡѧ���ش� 
			
			calculate(result,answer);
			
			
		}else{ // �ӷ� 
		
			left = rand() % 50+ 1; 	// ���� 1 �� 50 ֮�������� 
			right = rand() % 51; 
			
			printf("��%d��:%d+%d=",i,left,right);
			
			result = left + right;
			scanf("%d",&answer);

			calculate(result,answer);
		}
	}
	
	printf("�װ���%s:��ĵ÷���:%d",name,score);	// ������ 
	
	FILE *fpl;
	fpl=fopen ("score.txt", "at+") ;	// �����ļ� 
	if(NULL==fpl){			// ���ļ� 
	    printf ("Failed to open the file !\n");
	    exit (0);
	}
	
	
	strcat(name,",���ڣ�");   //ƴ���ַ��� 
	
	time_t current = time(NULL); // ����time������ȡ����ʱ�䣨����1970֮������������ͣ� 
	struct tm *timer = localtime(&current);  // ����localtime���� ������ʱ��ת��Ϊ �ֽ�ʱ�䣨�ṹ�����ͣ�������struct tm��ָ��timer 
	char *wday_name[] = {"7","1","2","3","4","5","6"};//��Աtm_wday��˳��Ϊ��0,1,2,3,4,5,6��������ת��Ϊ�ַ�����Ȼ������������ȡ��Ӧ���ַ���
	
	 
    snprintf(date,30,"%d��%d��%d�� %d:%d:%d",
    timer -> tm_year + 1900, timer -> tm_mon + 1, timer -> tm_mday,
    timer -> tm_hour, timer -> tm_min, timer -> tm_sec);  // ��������ʱ�� 
	strcat(name,date);  // �����ڲ����ַ��� 
	strcat(name,",�ɼ���");
	
	char cpd[10];
	sprintf(cpd,"%d\n",score); // ���ɼ�ת�����ַ��� 
	
	strcat(name,cpd);
	fputs ( name, fpl); 
	fclose (fpl); //�ر�fplָ���Ӧ�ļ���score.txt)����
}
