VERSION 5.00
Object = "{6BF52A50-394A-11D3-B153-00C04F79FAA6}#1.0#0"; "wmp.dll"
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
Begin VB.Form Form1 
   Caption         =   "播放器"
   ClientHeight    =   6270
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   12570
   LinkTopic       =   "Form1"
   ScaleHeight     =   6270
   ScaleWidth      =   12570
   StartUpPosition =   3  '窗口缺省
   Begin VB.CommandButton Command1 
      Caption         =   "添加歌曲"
      Height          =   495
      Left            =   7320
      TabIndex        =   7
      Top             =   5640
      Width           =   1575
   End
   Begin VB.FileListBox File1 
      Height          =   5490
      Left            =   9480
      TabIndex        =   5
      Top             =   600
      Width           =   2655
   End
   Begin VB.CommandButton Command5 
      Caption         =   "下一首"
      Height          =   495
      Left            =   5640
      TabIndex        =   4
      Top             =   5640
      Width           =   1455
   End
   Begin VB.CommandButton Command4 
      Caption         =   "上一首"
      Height          =   495
      Left            =   3840
      TabIndex        =   3
      Top             =   5640
      Width           =   1575
   End
   Begin VB.CommandButton Command3 
      Caption         =   "后退10秒"
      Height          =   495
      Left            =   120
      TabIndex        =   2
      Top             =   5640
      Width           =   1695
   End
   Begin VB.CommandButton Command2 
      Caption         =   "快进10秒"
      Height          =   495
      Left            =   2040
      TabIndex        =   1
      Top             =   5640
      Width           =   1575
   End
   Begin MSComDlg.CommonDialog CommonDialog1 
      Left            =   4560
      Top             =   1800
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
   End
   Begin VB.Label Label1 
      Caption         =   "播放列表"
      Height          =   255
      Left            =   9600
      TabIndex        =   6
      Top             =   240
      Width           =   1935
   End
   Begin WMPLibCtl.WindowsMediaPlayer WindowsMediaPlayer1 
      Height          =   5295
      Left            =   0
      TabIndex        =   0
      Top             =   0
      Width           =   8895
      URL             =   ""
      rate            =   1
      balance         =   0
      currentPosition =   0
      defaultFrame    =   ""
      playCount       =   1
      autoStart       =   -1  'True
      currentMarker   =   0
      invokeURLs      =   -1  'True
      baseURL         =   ""
      volume          =   50
      mute            =   0   'False
      uiMode          =   "full"
      stretchToFit    =   0   'False
      windowlessVideo =   0   'False
      enabled         =   -1  'True
      enableContextMenu=   -1  'True
      fullScreen      =   0   'False
      SAMIStyle       =   ""
      SAMILang        =   ""
      SAMIFilename    =   ""
      captioningID    =   ""
      enableErrorDialogs=   0   'False
      _cx             =   15690
      _cy             =   9340
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim amount As Integer

Private Sub Command1_Click()
    Dim str1 As String, str2 As String
    Dim file
    
    CommonDialog1.ShowOpen
    str1 = CommonDialog1.FileName
    If CommonDialog1.FileTitle = "" Then
        Exit Sub
    End If
    str2 = App.Path & "\music\" & CommonDialog1.FileTitle
    Set file = CreateObject("scripting.filesystemobject")
    file.createtextfile (str2)
    
    Call FileCopy(str1, str2)
    File1.Refresh
End Sub

Private Sub Command2_Click()
    WindowsMediaPlayer1.Controls.currentPosition = WindowsMediaPlayer1.Controls.currentPosition + 10
End Sub

Private Sub Command3_Click()
    If WindowsMediaPlayer1.Controls.currentPosition - 10 > 0 Then
        WindowsMediaPlayer1.Controls.currentPosition = WindowsMediaPlayer1.Controls.currentPosition - 10
    Else
        WindowsMediaPlayer1.Controls.currentPosition = 0
    End If
End Sub

Private Sub Command4_Click()
    If amount - 1 >= 0 Then
        amount = amount - 1
        WindowsMediaPlayer1.URL = App.Path & "\music\" & File1.List(amount)
    Else
        amount = File1.ListCount - 1
        WindowsMediaPlayer1.URL = App.Path & "\music\" & File1.List(amount)
    End If
End Sub

Private Sub Command5_Click()
    If File1.ListCount <= amount + 1 Then
        amount = 0
        WindowsMediaPlayer1.URL = App.Path & "\music\" & File1.List(amount)
    Else
        amount = amount + 1
        WindowsMediaPlayer1.URL = App.Path & "\music\" & File1.List(amount)
    End If
End Sub
Private Sub File1_DblClick()
    If File1.ListIndex = -1 Then
         Exit Sub
    End If
    WindowsMediaPlayer1.URL = App.Path & "\music\" & File1.List(File1.ListIndex)
    amount = File1.ListIndex
    
End Sub

Private Sub Form_Load()
    File1.Path = App.Path & "\music"
    WindowsMediaPlayer1.URL = App.Path & "\music\" & File1.List(0)
    state = 1
    amount = 0
End Sub

Private Sub WindowsMediaPlayer1_PlayStateChange(ByVal NewState As Long)
    If NewState = 1 Then

        WindowsMediaPlayer1.Controls.play
    End If
End Sub

