#include<iostream>
using namespace std;

typedef struct _LinkNode {
	int data;
	struct _LinkNode* next;
}LinkNode, Linklist;   // A���� 

typedef struct Node{

    int data;
    Node* next;

}*ListNode;  // B���� 

Linklist* aHead = NULL; // A����ͷ�ڵ� 
Node* bHead = NULL;  // B����ͷ�ڵ� 

bool InitList() {		// ��ʼ�� 
	aHead = new LinkNode;
	aHead->next = NULL;
	aHead->data = 0; 
	bHead  = new Node;	
	bHead->next = bHead;
	bHead->data =0;
	return true;
}

bool ListInsert_back(LinkNode* node) { // A������� 

	LinkNode* last = NULL;
	last = aHead;
	while (last->next) {
		last = last->next;
	}
	node->next = NULL;
	last->next = node;
	return true;
}

bool BListInsert(int value) { // B������� 

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
void LinkPrint() { // A���������� 

	LinkNode* p = NULL;
	if (!aHead) { cout << "������Ϊ��"<<endl; return; }
	p =aHead->next;
	cout << "A�����е�ֵΪ��" ;
	while (p) {
		cout << "->" << p->data;
		p = p->next;
	}
	cout << endl;
}

void ShowList(){// B���������� 
    Node* p = bHead->next;
	cout << "B�����е�ֵΪ��" ;
    while(p != bHead){
        cout << "->" << p->data ;
        p = p->next;
    }
    cout << endl;
}
void inverseA(LinkNode* pCur){ // ����A���� 
	if (NULL == pCur || NULL == pCur->next)
	{
		aHead->next = pCur;
	}
	else
	{
		inverseA(pCur->next);	//�ݹ����ú�̽��
		pCur->next->next = pCur; //����̽��ָ��ǰ��㡣  
		pCur->next = NULL;
	}

}
void inverseB(Node* pCur){ // ����B���� 
 
	if (bHead == pCur || bHead == pCur->next)
	{
		bHead->next = pCur;
	}
	else
	{
		inverseB(pCur->next);	//�ݹ����ú�̽��
		pCur->next->next = pCur; //����̽��ָ��ǰ��㡣  
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
	cout << "���ֵΪ:"<<last->data  ;
}
int main()
{
	Linklist* s= NULL;
    int m;
    cout << "����A�����������" ;
    cin >> m;

    InitList();
	cout << "����A�����е�ֵ��" ;
	for(int i = 1; i <= m ; i++) {
		s = new LinkNode;//�����½��s
		cin >> s->data;
		ListInsert_back(s);
    }
    cout << "����B�����������" ;
    cin >> m;
    	cout << "����B�����е�ֵ��" ;
	for(int i = 1; i <= m ; i++) {
		int value;
		cin >> value;
		BListInsert(value);
    }
    
    LinkPrint();
    ShowList();
    cout << "���ú�" << endl;
    
    inverseA(aHead->next);
    inverseB(bHead->next);
    ShowList();
    LinkPrint();
    cout << "ɾ��A������������B�����г��ֵĽ��:" << endl;
    deleteList();
    
    LinkPrint();
    cout << "������k��A�����е����Ľ���±꣩:" << endl;
    int k;
    cin >> k;
    findIndex(k);
    return 0;
}
