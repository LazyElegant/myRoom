VERSION 5.00
Begin VB.Form Form2 
   Caption         =   "Form2"
   ClientHeight    =   5850
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   8730
   LinkTopic       =   "Form2"
   ScaleHeight     =   5850
   ScaleWidth      =   8730
   StartUpPosition =   3  '窗口缺省
   Begin VB.CommandButton Command3 
      Caption         =   "退出"
      Height          =   615
      Left            =   3120
      TabIndex        =   5
      Top             =   4800
      Width           =   2535
   End
   Begin VB.CommandButton Command2 
      Caption         =   "成绩查询"
      Height          =   615
      Left            =   3120
      TabIndex        =   4
      Top             =   3840
      Width           =   2535
   End
   Begin VB.CommandButton Command1 
      Caption         =   "开始游戏"
      Height          =   615
      Left            =   3120
      TabIndex        =   3
      Top             =   2880
      Width           =   2535
   End
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   3480
      TabIndex        =   2
      Top             =   1800
      Width           =   2655
   End
   Begin VB.Label Label2 
      Caption         =   "用户名:"
      Height          =   375
      Left            =   2640
      TabIndex        =   1
      Top             =   1920
      Width           =   855
   End
   Begin VB.Label Label1 
      BorderStyle     =   1  'Fixed Single
      Caption         =   "石油管道迷宫"
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   21.75
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   3000
      TabIndex        =   0
      Top             =   720
      Width           =   2775
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
    If Text1.Text <> "" Then
        Form1.Show
        Form2.Hide
    Else
        MsgBox ("用户名不可为空")
    End If
End Sub

Private Sub Command2_Click()
    Form3.Show
    Form2.Hide
    
End Sub

Private Sub Command3_Click()
    End
End Sub
