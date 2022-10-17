VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   6840
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   9810
   LinkTopic       =   "Form1"
   ScaleHeight     =   6840
   ScaleWidth      =   9810
   StartUpPosition =   3  '窗口缺省
   Begin VB.Timer Timer1 
      Interval        =   1000
      Left            =   8520
      Top             =   5640
   End
   Begin VB.Image Image2 
      Height          =   420
      Left            =   4440
      Picture         =   "Form1.frx":0000
      Stretch         =   -1  'True
      Top             =   2040
      Width           =   300
   End
   Begin VB.Image Image1 
      Height          =   330
      Left            =   480
      Picture         =   "Form1.frx":34F3
      Stretch         =   -1  'True
      Top             =   360
      Width           =   180
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   31
      Left            =   6000
      TabIndex        =   31
      Top             =   5760
      Width           =   2895
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1935
      Index           =   30
      Left            =   8760
      TabIndex        =   30
      Top             =   3840
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   29
      Left            =   5160
      TabIndex        =   29
      Top             =   4560
      Width           =   2775
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   28
      Left            =   5160
      TabIndex        =   28
      Top             =   3720
      Width           =   3735
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1095
      Index           =   27
      Left            =   5040
      TabIndex        =   27
      Top             =   2760
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   2175
      Index           =   26
      Left            =   5040
      TabIndex        =   26
      Top             =   4560
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   25
      Left            =   4080
      TabIndex        =   25
      Top             =   2760
      Width           =   1095
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   24
      Left            =   6240
      TabIndex        =   24
      Top             =   2760
      Width           =   3495
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1215
      Index           =   23
      Left            =   6120
      TabIndex        =   23
      Top             =   1680
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   22
      Left            =   4200
      TabIndex        =   22
      Top             =   1680
      Width           =   1935
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   21
      Left            =   7200
      TabIndex        =   21
      Top             =   1680
      Width           =   2535
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   20
      Left            =   4080
      TabIndex        =   20
      Top             =   840
      Width           =   4815
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   4455
      Index           =   19
      Left            =   4080
      TabIndex        =   19
      Top             =   840
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   18
      Left            =   3240
      TabIndex        =   18
      Top             =   3120
      Width           =   975
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   855
      Index           =   17
      Left            =   4080
      TabIndex        =   17
      Top             =   5280
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   16
      Left            =   2760
      TabIndex        =   16
      Top             =   6000
      Width           =   1335
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   15
      Left            =   1920
      TabIndex        =   15
      Top             =   5280
      Width           =   1335
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1575
      Index           =   14
      Left            =   1800
      TabIndex        =   14
      Top             =   5280
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1455
      Index           =   13
      Left            =   960
      TabIndex        =   13
      Top             =   4560
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   12
      Left            =   960
      TabIndex        =   12
      Top             =   4440
      Width           =   2175
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1455
      Index           =   11
      Left            =   3120
      TabIndex        =   11
      Top             =   3120
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   2895
      Index           =   10
      Left            =   3120
      TabIndex        =   10
      Top             =   -600
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   3015
      Index           =   9
      Left            =   2280
      TabIndex        =   9
      Top             =   840
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   8
      Left            =   120
      TabIndex        =   8
      Top             =   3720
      Width           =   2175
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   7
      Left            =   840
      TabIndex        =   7
      Top             =   3000
      Width           =   615
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   6
      Left            =   120
      TabIndex        =   6
      Top             =   2160
      Width           =   615
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   3135
      Index           =   5
      Left            =   1440
      TabIndex        =   5
      Top             =   0
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   1215
      Index           =   4
      Left            =   720
      TabIndex        =   4
      Top             =   1080
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   6855
      Index           =   3
      Left            =   9720
      TabIndex        =   3
      Top             =   120
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   6735
      Index           =   2
      Left            =   0
      TabIndex        =   2
      Top             =   120
      Width           =   135
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   1
      Left            =   0
      TabIndex        =   1
      Top             =   6720
      Width           =   9855
   End
   Begin VB.Label Label1 
      BackColor       =   &H00004080&
      Height          =   135
      Index           =   0
      Left            =   0
      TabIndex        =   0
      Top             =   0
      Width           =   9855
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Public IsDragging As Boolean
Public sum As Integer
Private Sub pen()

    For i = 0 To 31
        If Image1.Top + Image1.Height >= Label1(i).Top _
           And Image1.Top <= Label1(i).Top + Label1(i).Height _
           And Image1.Left <= Label1(i).Left + Label1(i).Width _
           And Image1.Left + Image1.Width >= Label1(i).Left Then
            MsgBox ("你输了！！")
            sum = 0
            Image1.Top = 360
            Image1.Left = 360
            IsDragging = False
            
        End If
    Next

    If Image1.Top + Image1.Height >= Image2.Top _
       And Image1.Top <= Image2.Top + Image2.Height _
       And Image1.Left <= Image2.Left + Image2.Width _
       And Image1.Left + Image1.Width >= Image2.Left Then
        MsgBox ("过关！！所用时间为" & sum & "秒")
        Dim a As String
        a = Form2.Text1.Text & ":" & sum & "秒"
        Open "score.txt" For Append As #1
            Print #1, a
        Close #1
        Form2.Show
        Form1.Hide
        sum = 0
        Image1.Top = 360
        Image1.Left = 360
        Timer1.Enabled = False
        
    End If

End Sub

Private Sub Form_Load()
    sum = 0
    Timer1.Enabled = True
    
End Sub

Private Sub Image1_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
    IsDragging = True
End Sub

Private Sub Image1_MouseMove(Button As Integer, Shift As Integer, X As Single, Y As Single)
    If IsDragging Then
        Image1.Left = Image1.Left + X
        Image1.Top = Image1.Top + Y
        Call pen
    End If
End Sub

Private Sub Image1_MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)
    IsDragging = False
End Sub

Private Sub Timer1_Timer()
    sum = sum + 1
End Sub
