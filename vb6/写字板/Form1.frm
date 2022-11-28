VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "写字板"
   ClientHeight    =   11190
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   15615
   LinkTopic       =   "Form1"
   ScaleHeight     =   11190
   ScaleWidth      =   15615
   StartUpPosition =   3  '窗口缺省
   Begin VB.CommandButton Command3 
      Caption         =   "全部替换"
      Height          =   375
      Left            =   12960
      TabIndex        =   12
      Top             =   10200
      Width           =   1095
   End
   Begin VB.CommandButton Command2 
      Caption         =   "替换"
      Height          =   375
      Left            =   12960
      TabIndex        =   11
      Top             =   9600
      Width           =   1095
   End
   Begin VB.TextBox Text4 
      Height          =   375
      Left            =   10920
      TabIndex        =   10
      Top             =   9840
      Width           =   1695
   End
   Begin VB.TextBox Text3 
      Height          =   375
      Left            =   7800
      TabIndex        =   8
      Top             =   9840
      Width           =   1695
   End
   Begin VB.CommandButton Command1 
      Caption         =   "查找"
      Height          =   375
      Left            =   4920
      TabIndex        =   6
      Top             =   9840
      Width           =   1095
   End
   Begin VB.TextBox Text2 
      Height          =   375
      Left            =   2880
      TabIndex        =   5
      Top             =   9840
      Width           =   1695
   End
   Begin VB.ComboBox Combo1 
      Height          =   300
      ItemData        =   "Form1.frx":0000
      Left            =   12000
      List            =   "Form1.frx":0007
      TabIndex        =   1
      Text            =   "16"
      Top             =   8760
      Width           =   1455
   End
   Begin VB.TextBox Text1 
      Height          =   8175
      Left            =   360
      MultiLine       =   -1  'True
      ScrollBars      =   2  'Vertical
      TabIndex        =   0
      Top             =   240
      Width           =   14895
   End
   Begin VB.Label Label5 
      Caption         =   "替换文本："
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   12
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   9840
      TabIndex        =   9
      Top             =   9960
      Width           =   1455
   End
   Begin VB.Label Label4 
      Caption         =   "原文本："
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   12
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   6840
      TabIndex        =   7
      Top             =   9960
      Width           =   1455
   End
   Begin VB.Label Label3 
      Caption         =   "查找文本："
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   12
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   1680
      TabIndex        =   4
      Top             =   9960
      Width           =   1455
   End
   Begin VB.Label Label2 
      Caption         =   "文本粗细"
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   12
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   10800
      TabIndex        =   2
      Top             =   8880
      Width           =   1455
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00FF8080&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   7
      Left            =   9240
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00FF00FF&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   6
      Left            =   8400
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00FFFF00&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   5
      Left            =   6720
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00C00000&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   4
      Left            =   7560
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H0000FFFF&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   3
      Left            =   6000
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H0000FF00&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   2
      Left            =   5160
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   0
      Left            =   3480
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H000000FF&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   1
      Left            =   4320
      Shape           =   1  'Square
      Top             =   8760
      Width           =   375
   End
   Begin VB.Label Label1 
      Caption         =   "文本颜色"
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   12
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   2280
      TabIndex        =   3
      Top             =   8880
      Width           =   1455
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Dim amount As Integer
Private Sub Combo1_Click()
    Text1.FontSize = Combo1.Text   '改变文本粗细
End Sub

Private Sub Command1_Click()
    
    amount = InStr(amount + 1, Text1.Text, Text2.Text)
    If amount = 0 Then
        If MsgBox("已经搜索到底是否从头搜索", vbOKCancel, "警告") = vbOK Then
            amount = 1
            amount = InStr(amount, Text1.Text, Text2.Text)
            If amount = 0 Then
                MsgBox ("无搜索结果")
                Exit Sub
            End If
        Else
            amount = 1
            Exit Sub
        End If
        
    End If
    Text1.SetFocus
    Text1.SelStart = amount - 1
    Text1.SelLength = Len(Text2.Text)
End Sub

Private Sub Command2_Click()
    amount = InStr(1, Text1.Text, Text3.Text)
    If amount = 0 Then
        MsgBox ("无搜索结果")
        Exit Sub
    End If
    
    If MsgBox("是否替换字符串", vbOKCancel, "警告") = vbOK Then
      Text1.Text = Replace(Text1.Text, Text3.Text, Text4.Text, 1, 1)
    End If
End Sub

Private Sub Command3_Click()
    If MsgBox("是否替换字符串", vbOKCancel, "警告") = vbOK Then
        Text1.Text = Replace(Text1.Text, Text3.Text, Text4.Text)
    End If
End Sub

Private Sub Form_MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)
For i = 0 To 7

    If X > Shape1(i).Left And Y > Shape1(i).Top And X < (Shape1(i).Left + Shape1(i).Width) And Y < (Shape1(i).Top + Shape1(i).Height) Then  '判断是否点击到了shape
       Text1.ForeColor = Shape1(i).FillColor       '改变线条的颜色
    End If
Next i
End Sub
Private Sub Form_Load()
    Text1.FontSize = 16
    Combo1.AddItem ("16")
    Combo1.AddItem ("18")
    Combo1.AddItem ("20")
    Combo1.AddItem ("22")
    Combo1.AddItem ("24")
    Combo1.AddItem ("26")
    amount = 1
    
End Sub

