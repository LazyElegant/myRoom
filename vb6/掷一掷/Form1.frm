VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "掷一掷"
   ClientHeight    =   7725
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   14970
   FillColor       =   &H00FFFF00&
   LinkTopic       =   "Form1"
   ScaleHeight     =   7725
   ScaleWidth      =   14970
   StartUpPosition =   3  '窗口缺省
   Begin VB.Frame Frame2 
      Caption         =   "运行结果"
      ForeColor       =   &H00FF0000&
      Height          =   2535
      Left            =   9960
      TabIndex        =   15
      Top             =   4200
      Width           =   3975
      Begin VB.Label Label5 
         Caption         =   "共"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   12
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   480
         TabIndex        =   18
         Top             =   1800
         Width           =   2535
      End
      Begin VB.Label Label4 
         Caption         =   "红队："
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   12
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   480
         TabIndex        =   17
         Top             =   1200
         Width           =   2535
      End
      Begin VB.Label Label3 
         Caption         =   "蓝队："
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   12
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   375
         Left            =   480
         TabIndex        =   16
         Top             =   600
         Width           =   2535
      End
   End
   Begin VB.CommandButton Command1 
      Caption         =   "运行"
      Height          =   375
      Left            =   12840
      TabIndex        =   14
      Top             =   3360
      Width           =   1095
   End
   Begin VB.TextBox Text1 
      Alignment       =   2  'Center
      Height          =   375
      Left            =   9960
      TabIndex        =   13
      Top             =   3360
      Width           =   2295
   End
   Begin VB.Frame Frame1 
      Caption         =   "点数之和统计"
      ForeColor       =   &H00FF0000&
      Height          =   6015
      Left            =   360
      TabIndex        =   0
      Top             =   720
      Width           =   8895
      Begin VB.Label Label1 
         Caption         =   "12"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   10
         Left            =   7800
         TabIndex        =   11
         Top             =   5400
         Width           =   375
      End
      Begin VB.Label Label1 
         Caption         =   "11"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   9
         Left            =   7080
         TabIndex        =   10
         Top             =   5400
         Width           =   375
      End
      Begin VB.Label Label1 
         Caption         =   "10"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   8
         Left            =   6360
         TabIndex        =   9
         Top             =   5400
         Width           =   375
      End
      Begin VB.Label Label1 
         Caption         =   "9"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   7
         Left            =   5640
         TabIndex        =   8
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "83"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   6
         Left            =   4920
         TabIndex        =   7
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "7"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   5
         Left            =   4200
         TabIndex        =   6
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "63"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   4
         Left            =   3480
         TabIndex        =   5
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "53"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   3
         Left            =   2760
         TabIndex        =   4
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "43"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   2
         Left            =   2040
         TabIndex        =   3
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "3"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   1
         Left            =   1320
         TabIndex        =   2
         Top             =   5400
         Width           =   135
      End
      Begin VB.Label Label1 
         Caption         =   "2"
         BeginProperty Font 
            Name            =   "宋体"
            Size            =   14.25
            Charset         =   134
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Index           =   0
         Left            =   600
         TabIndex        =   1
         Top             =   5400
         Width           =   135
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H00FF0000&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   10
         Left            =   7680
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H00FF0000&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   9
         Left            =   6960
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H00FF0000&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   8
         Left            =   6240
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H000000FF&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   7
         Left            =   5520
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H000000FF&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   6
         Left            =   4800
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H000000FF&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   5
         Left            =   4080
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H000000FF&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   4
         Left            =   3360
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H000000FF&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   3
         Left            =   2640
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H00FF0000&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   2
         Left            =   1920
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H00FF0000&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   1
         Left            =   1200
         Top             =   5280
         Width           =   495
      End
      Begin VB.Shape Shape1 
         BackColor       =   &H00FF0000&
         BackStyle       =   1  'Opaque
         Height          =   15
         Index           =   0
         Left            =   480
         Top             =   5280
         Width           =   495
      End
   End
   Begin VB.Label Label2 
      Caption         =   "请输入投掷次数：（小于2000次）"
      BeginProperty Font 
         Name            =   "宋体"
         Size            =   12
         Charset         =   134
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   735
      Left            =   10080
      TabIndex        =   12
      Top             =   2280
      Width           =   2055
   End
   Begin VB.Image Image2 
      Height          =   1095
      Left            =   12120
      Picture         =   "Form1.frx":0000
      Stretch         =   -1  'True
      Top             =   840
      Width           =   1095
   End
   Begin VB.Image Image1 
      Height          =   1095
      Left            =   10560
      Picture         =   "Form1.frx":52AD
      Stretch         =   -1  'True
      Top             =   840
      Width           =   1095
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
    Dim fre As Integer
    fre = CInt(Text1.Text)
    Dim a As Integer
    Dim b As Integer
    Dim sum As Integer
    Dim blue As Integer
    Dim red As Integer
    If fre >= 2000 Or fre <= 0 Then
        MsgBox ("次数需在0~1999之间！！！")
    Else
        For i = 1 To 10
            Shape1(i).Top = 5280
            Shape1(i).Height = 15
        Next i
        
        For i = 1 To fre
            a = Int(Rnd * 6) + 1
            b = Int(Rnd * 6) + 1
            sum = a + b
            
            Shape1(sum - 2).Height = Shape1(sum - 2).Height + 10
            Shape1(sum - 2).Top = Shape1(sum - 2).Top - 10
            
            If sum = 2 Or sum = 3 Or sum = 4 Or sum = 10 Or sum = 11 Or sum = 12 Then
                blue = blue + 1
            Else
                red = red + 1
            End If
            Label3.Caption = "蓝队:    " & blue & "     次"
            Label4.Caption = "红队:    " & red & "     次"
            Label5.Caption = "共 " & fre & "  次"
        Next i
    
    End If
    
End Sub

