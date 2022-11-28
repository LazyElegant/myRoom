VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
Begin VB.Form Form1 
   Caption         =   "画图工具"
   ClientHeight    =   10500
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   14790
   LinkTopic       =   "Form1"
   ScaleHeight     =   10500
   ScaleWidth      =   14790
   StartUpPosition =   3  '窗口缺省
   Begin MSComDlg.CommonDialog CommonDialog1 
      Left            =   12240
      Top             =   7680
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
   Begin VB.CommandButton Command2 
      Caption         =   "裁剪图片"
      Height          =   495
      Left            =   960
      TabIndex        =   17
      Top             =   9720
      Width           =   2295
   End
   Begin VB.TextBox Text5 
      Height          =   270
      Left            =   7440
      TabIndex        =   16
      Text            =   "0"
      Top             =   9840
      Width           =   975
   End
   Begin VB.TextBox Text6 
      Height          =   270
      Left            =   4920
      TabIndex        =   15
      Text            =   "0"
      Top             =   9840
      Width           =   975
   End
   Begin VB.TextBox Text7 
      Height          =   270
      Left            =   12480
      TabIndex        =   14
      Text            =   "0"
      Top             =   9840
      Width           =   975
   End
   Begin VB.TextBox Text8 
      Height          =   270
      Left            =   9840
      TabIndex        =   13
      Text            =   "0"
      Top             =   9840
      Width           =   975
   End
   Begin VB.CommandButton Command1 
      Caption         =   "插入图片"
      Height          =   495
      Left            =   960
      TabIndex        =   8
      Top             =   8760
      Width           =   2295
   End
   Begin VB.TextBox Text1 
      Height          =   270
      Left            =   5160
      TabIndex        =   7
      Text            =   "0"
      Top             =   8880
      Width           =   975
   End
   Begin VB.TextBox Text2 
      Height          =   270
      Left            =   7680
      TabIndex        =   6
      Text            =   "0"
      Top             =   8880
      Width           =   975
   End
   Begin VB.TextBox Text3 
      Height          =   270
      Left            =   9720
      TabIndex        =   5
      Text            =   "0"
      Top             =   8880
      Width           =   975
   End
   Begin VB.TextBox Text4 
      Height          =   270
      Left            =   11760
      TabIndex        =   4
      Text            =   "0"
      Top             =   8880
      Width           =   975
   End
   Begin VB.ComboBox Combo1 
      Height          =   300
      ItemData        =   "Form1.frx":0000
      Left            =   10680
      List            =   "Form1.frx":0007
      TabIndex        =   1
      Text            =   "1"
      Top             =   8040
      Width           =   1455
   End
   Begin VB.PictureBox Picture1 
      Height          =   7215
      Left            =   480
      ScaleHeight     =   7155
      ScaleWidth      =   13755
      TabIndex        =   0
      Top             =   360
      Width           =   13815
   End
   Begin VB.Label Label7 
      Caption         =   "裁剪开始位置y2"
      Height          =   255
      Left            =   6120
      TabIndex        =   21
      Top             =   9840
      Width           =   1335
   End
   Begin VB.Label Label8 
      Caption         =   "裁剪开始位置x1"
      Height          =   255
      Left            =   3480
      TabIndex        =   20
      Top             =   9840
      Width           =   1335
   End
   Begin VB.Label Label9 
      Caption         =   "图片裁剪高度"
      Height          =   255
      Left            =   11160
      TabIndex        =   19
      Top             =   9840
      Width           =   1095
   End
   Begin VB.Label Label10 
      Caption         =   "图片裁剪宽度"
      Height          =   255
      Left            =   8640
      TabIndex        =   18
      Top             =   9840
      Width           =   1215
   End
   Begin VB.Label Label3 
      Caption         =   "画板起始位置x1"
      Height          =   255
      Left            =   3720
      TabIndex        =   12
      Top             =   8880
      Width           =   1455
   End
   Begin VB.Label Label4 
      Caption         =   "画板起始位置y1"
      Height          =   255
      Left            =   6360
      TabIndex        =   11
      Top             =   8880
      Width           =   1335
   End
   Begin VB.Label Label5 
      Caption         =   "图片宽度"
      Height          =   255
      Left            =   8880
      TabIndex        =   10
      Top             =   8880
      Width           =   855
   End
   Begin VB.Label Label6 
      Caption         =   "图片高度"
      Height          =   255
      Left            =   10920
      TabIndex        =   9
      Top             =   8880
      Width           =   855
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H000000FF&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   1
      Left            =   3000
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   0
      Left            =   2160
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H0000FF00&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   2
      Left            =   3840
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H0000FFFF&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   3
      Left            =   4680
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00C00000&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   4
      Left            =   6240
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00FFFF00&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   5
      Left            =   5400
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00FF00FF&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   6
      Left            =   7080
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Shape Shape1 
      BorderStyle     =   0  'Transparent
      FillColor       =   &H00FF8080&
      FillStyle       =   0  'Solid
      Height          =   375
      Index           =   7
      Left            =   7920
      Shape           =   1  'Square
      Top             =   8040
      Width           =   375
   End
   Begin VB.Label Label2 
      Caption         =   "线条粗细"
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
      Left            =   9360
      TabIndex        =   2
      Top             =   8040
      Width           =   1455
   End
   Begin VB.Label Label1 
      Caption         =   "线条颜色"
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
      Left            =   960
      TabIndex        =   3
      Top             =   8160
      Width           =   1455
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub Combo1_Click()
     Picture1.DrawWidth = Combo1.Text   '改变线条粗细
End Sub

Private Sub Command1_Click()
    CommonDialog1.ShowOpen
    Call Picture1.PaintPicture(LoadPicture(CommonDialog1.FileName), Text1.Text, Text2.Text, Text3.Text, Text4.Text)
End Sub

Private Sub Command2_Click()
    Call SavePicture(Picture1.Image, App.Path & "\1.jpg")
    Call Picture1.PaintPicture(LoadPicture(App.Path & "\1.jpg"), Text1.Text, Text2.Text, Text3.Text, Text4.Text, Text6.Text, Text5.Text, Text8.Text, Text7.Text)
    
End Sub

Private Sub Form_Load()
    Picture1.DrawWidth = 1
    For i = 2 To 14
        Combo1.AddItem ("" & i)
    Next i
    Text3.Text = Picture1.Width
    Text4.Text = Picture1.Height
    Text8.Text = Picture1.Width
    Text7.Text = Picture1.Height
    Picture1.AutoRedraw = True
End Sub

Private Sub Form_MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)
For i = 0 To 7

    If X > Shape1(i).Left And Y > Shape1(i).Top And X < (Shape1(i).Left + Shape1(i).Width) And Y < (Shape1(i).Top + Shape1(i).Height) Then  '判断是否点击到了shape
       Picture1.FillColor = Shape1(i).FillColor      '改变线条的颜色
    End If
Next i
End Sub

Private Sub Picture1_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)

    Picture1.CurrentX = X
    Picture1.CurrentY = Y
End Sub

Private Sub Picture1_MouseMove(Button As Integer, Shift As Integer, X As Single, Y As Single)
    
    If Button = 1 Then
        Picture1.Line -(X, Y), Picture1.FillColor
        
    End If
End Sub

