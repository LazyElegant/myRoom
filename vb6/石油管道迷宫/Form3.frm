VERSION 5.00
Begin VB.Form Form3 
   Caption         =   "Form3"
   ClientHeight    =   8655
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   6900
   LinkTopic       =   "Form3"
   ScaleHeight     =   8655
   ScaleWidth      =   6900
   StartUpPosition =   3  '窗口缺省
   Begin VB.CommandButton Command1 
      Caption         =   "返回首页"
      Height          =   615
      Left            =   2280
      TabIndex        =   2
      Top             =   7680
      Width           =   2415
   End
   Begin VB.ListBox List1 
      Height          =   5280
      ItemData        =   "Form3.frx":0000
      Left            =   1320
      List            =   "Form3.frx":0002
      TabIndex        =   1
      Top             =   1560
      Width           =   4455
   End
   Begin VB.Label Label1 
      BorderStyle     =   1  'Fixed Single
      Caption         =   "成绩查询"
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   21.75
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   615
      Left            =   2400
      TabIndex        =   0
      Top             =   600
      Width           =   1935
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
    Form2.Show
    Form3.Hide
    
End Sub

Private Sub Form_Load()
    Dim txt As String
    Open "score.txt" For Input As #1
    Do While Not EOF(1)
        Input #1, txt
        List1.AddItem txt
    Loop
End Sub

