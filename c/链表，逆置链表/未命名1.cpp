#include<iostream>
using namespace std;

typedef struct _LinkNode {
	int data;
	struct _LinkNode* next;
}LinkNode, Linklist;   // A链表 

typedef struct Node{

    int data;
    Node* next;

}*ListNode;  // B链表 

Linklist* aHead = NULL; // A链表头节点 
Node* bHead = NULL;  // B链表头节点 

bool InitList() {		// 初始化 
	aHead = new LinkNode;
	aHead->next = NULL;
	aHead->data = 0; 
	bHead  = new Node;	
	bHead->next = bHead;
	bHead->data =0;
	return true;
}

bool ListInsert_back(LinkNode* node) { // A链表插入 

	LinkNode* last = NULL;
	last = aHead;
	while (last->next) {
		last = last->next;
	}
	node->next = NULL;
	last->next = node;
	return true;
}

bool BListInsert(int value) { // B链表插入 

   	Node* p = new Node;
	p->data = value;
   	p->next = bHead;
	Node* last = bHead;
   	while (last->next != bHead) {
		last = last->next;
	}
	last->next = p;
   	return true;
}
void LinkPrint() { // A链表遍历输出 

	LinkNode* p = NULL;
	if (!aHead) { cout << "此链表为空"<<endl; return; }
	p =aHead->next;
	cout << "A链表中的值为：" ;
	while (p) {
		cout << "->" << p->data;
		p = p->next;
	}
	cout << endl;
}

void ShowList(){// B链表遍历输出 
    Node* p = bHead->next;
	cout << "B链表中的值为：" ;
    while(p != bHead){
        cout << "->" << p->data ;
        p = p->next;
    }
    cout << endl;
}
void inverseA(LinkNode* pCur){ // 逆置A数组 
	if (NULL == pCur || NULL == pCur->next)
	{
		aHead->next = pCur;
	}
	else
	{
		inverseA(pCur->next);	//递归逆置后继结点
		pCur->next->next = pCur; //将后继结点指向当前结点。  
		pCur->next = NULL;
	}

}
void inverseB(Node* pCur){ // 逆置B数组 
 
	if (bHead == pCur || bHead == pCur->next)
	{
		bHead->next = pCur;
	}
	else
	{
		inverseB(pCur->next);	//递归逆置后继结点
		pCur->next->next = pCur; //将后继结点指向当前结点。  
		pCur->next = bHead;
	}
}
void FindValue(int val){
    LinkNode *p = aHead;
    while(p->next!= NULL ){
        if(p->next->data == val) {
        	
			p->next = p->next->next;
			if(p->next== NULL){
        		return; 
			}
		}
        p = p->next;
    }
}

void deleteList(){
	Node* p = bHead->next;
    while(p != bHead){
       	FindValue(p->data);
        p = p->next;
    }
}

void findIndex(int index){
	int count =0; 
	LinkNode* last = aHead;
	while (last->next) {
		last = last->next;
		count++; 
	}
	count = count - index;
	last = aHead;
	for(int i =0;i<=count;i++){
		last = last->next;
	}
	cout << "结点值为:"<<last->data  ;
}
int main()
{
	Linklist* s= NULL;
    int m;
    cout << "输入A链表的数量：" ;
    cin >> m;

    InitList();
	cout << "输入A链表中的值：" ;
	for(int i = 1; i <= m ; i++) {
		s = new LinkNode;//生成新结点s
		cin >> s->data;
		ListInsert_back(s);
    }
    cout << "输入B链表的数量：" ;
    cin >> m;
    	cout << "输入B链表中的值：" ;
	for(int i = 1; i <= m ; i++) {
		int value;
		cin >> value;
		BListInsert(value);
    }
    
    LinkPrint();
    ShowList();
    cout << "逆置后：" << endl;
    
    inverseA(aHead->next);
    inverseB(bHead->next);
    ShowList();
    LinkPrint();
    cout << "删除A链表中所有在B链表中出现的结点:" << endl;
    deleteList();
    
    LinkPrint();
    cout << "请输入k（A链表中倒数的结点下标）:" << endl;
    int k;
    cin >> k;
    findIndex(k);
    return 0;
}
