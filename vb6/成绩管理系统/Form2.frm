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
   StartUpPosition =   3  '窗口缺省
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
    Label1.Caption = "英语成绩平均分：" & Module1.englishScore & ",最高分：" & Module1.englishMax & ",最低分：" & Module1.englishMin & vbCrLf _
         & "数学成绩平均分：" & Module1.mathScore & ",最高分：" & Module1.mathMax & ",最低分：" & Module1.mathMin & vbCrLf _
         & "化学成绩平均分：" & Module1.chemistryScore & ",最高分：" & Module1.chemistryMax & ",最低分：" & Module1.chemistryMin & vbCrLf _
         & "第一名：" & Module1.first & ",平均分：" & Module1.firstScore & vbCrLf _
         & "第二名：" & Module1.second & ",平均分：" & Module1.secondScore & vbCrLf _
         & "第三名：" & Module1.third & ",平均分：" & Module1.thirdScore
         
         
End Sub
