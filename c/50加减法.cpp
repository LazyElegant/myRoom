#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int score = 100;  // 得分 

void calculate(int result,int answer){  //计算结果 
	if(result == answer){  //第一次回答 
		printf("\n回答正确\n");
		return;  //如果正确跳出函数 
	}else{
		score -= 3; //扣三分 
		printf("\n回答错误请重新回答：\n");
	}
	
	scanf("%d",&answer);
	if(result == answer){
		printf("\n回答正确\n");
		return;
	}else{
		score -= 2; //扣俩分
		printf("\n回答错误请重新回答：\n");
	}
	
	scanf("%d",&answer);
	if(result == answer){
		printf("\n回答正确\n");
	}else{
		score -= 5; //扣五分
		printf("\n回答错误\n");
	}
}

main(){
	char name[100];  // 名字 
	char date[30];  // 日期 
	
	printf("请输入你的名字:");
	gets(name);   //获取名字 
	
	printf("\n开始测试:\n");
	for(int i = 1; i<=10 ; i++){
		srand((unsigned)time(NULL));
		int random = rand() % 2;       // 产生 0 到 1 之间的随机数 ，用于判断这题用减法还是加法 
		int left = 0; 
		int right = 0;
		int result = 0; 
		int answer = 0; 
		
		if(random==1){ 	// 减法 
			left = rand() % 50+ 1; 	// 产生 1 到 50 之间的随机数 
			do{
				right = rand() % 51; 
			}while(left < right);   // 如果左边的数小于右边的数则重新给右边赋值以确保不会出现负数 
			
			
			printf("第%d题:%d-%d=",i,left,right);
			
			result = left - right; 		// 计算答案 
			scanf("%d",&answer); 		// 获取学生回答 
			
			calculate(result,answer);
			
			
		}else{ // 加法 
		
			left = rand() % 50+ 1; 	// 产生 1 到 50 之间的随机数 
			right = rand() % 51; 
			
			printf("第%d题:%d+%d=",i,left,right);
			
			result = left + right;
			scanf("%d",&answer);

			calculate(result,answer);
		}
	}
	
	printf("亲爱的%s:你的得分是:%d",name,score);	// 输出结果 
	
	FILE *fpl;
	fpl=fopen ("score.txt", "at+") ;	// 创建文件 
	if(NULL==fpl){			// 打开文件 
	    printf ("Failed to open the file !\n");
	    exit (0);
	}
	
	
	strcat(name,",日期：");   //拼接字符串 
	
	time_t current = time(NULL); // 利用time函数获取日历时间（返回1970之后的秒数，整型） 
	struct tm *timer = localtime(&current);  // 利用localtime函数 将日历时间转换为 分解时间（结构体类型），赋给struct tm型指针timer 
	char *wday_name[] = {"7","1","2","3","4","5","6"};//成员tm_wday的顺序为（0,1,2,3,4,5,6），将其转换为字符串，然后利用索引获取对应的字符串
	
	 
    snprintf(date,30,"%d年%d月%d日 %d:%d:%d",
    timer -> tm_year + 1900, timer -> tm_mon + 1, timer -> tm_mday,
    timer -> tm_hour, timer -> tm_min, timer -> tm_sec);  // 生成日期时间 
	strcat(name,date);  // 将日期并入字符串 
	strcat(name,",成绩：");
	
	char cpd[10];
	sprintf(cpd,"%d\n",score); // 将成绩转换成字符型 
	
	strcat(name,cpd);
	fputs ( name, fpl); 
	fclose (fpl); //关闭fpl指针对应文件（score.txt)的流
}
