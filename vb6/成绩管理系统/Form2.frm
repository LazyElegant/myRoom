VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   5940
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   6270
   LinkTopic       =   "Form2"
   ScaleHeight     =   5940
   ScaleWidth      =   6270
   StartUpPosition =   3  '����ȱʡ
   Begin VB.Label Label1 
      Height          =   4215
      Left            =   960
      TabIndex        =   0
      Top             =   720
      Width           =   4215
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()
    Label1.Caption = "Ӣ��ɼ�ƽ���֣�" & Module1.englishScore & ",��߷֣�" & Module1.englishMax & ",��ͷ֣�" & Module1.englishMin & vbCrLf _
         & "��ѧ�ɼ�ƽ���֣�" & Module1.mathScore & ",��߷֣�" & Module1.mathMax & ",��ͷ֣�" & Module1.mathMin & vbCrLf _
         & "��ѧ�ɼ�ƽ���֣�" & Module1.chemistryScore & ",��߷֣�" & Module1.chemistryMax & ",��ͷ֣�" & Module1.chemistryMin & vbCrLf _
         & "��һ����" & Module1.first & ",ƽ���֣�" & Module1.firstScore & vbCrLf _
         & "�ڶ�����" & Module1.second & ",ƽ���֣�" & Module1.secondScore & vbCrLf _
         & "��������" & Module1.third & ",ƽ���֣�" & Module1.thirdScore
         
         
End Sub
