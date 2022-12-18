VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H00FFFFFF&
   Caption         =   "ÌßÇò"
   ClientHeight    =   6735
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   9825
   LinkTopic       =   "Form1"
   ScaleHeight     =   6735
   ScaleWidth      =   9825
   StartUpPosition =   3  '´°¿ÚÈ±Ê¡
   Begin VB.Timer Timer1 
      Interval        =   300
      Left            =   360
      Top             =   1200
   End
   Begin VB.Image Image1 
      Height          =   4575
      Left            =   3000
      Top             =   960
      Width           =   3615
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Private Sub Form_Load()
    Image1.Stretch = True
    Image1.Picture = LoadPicture(App.Path & "/img/1.JPG")
    Timer1.Enabled = True
    Timer1.Interval = 300
    
End Sub

Private Sub Timer1_Timer()
    Static k As Integer
    k = k + 1
    Image1.Picture = LoadPicture(App.Path & "/img/" & k & ".JPG")
    If k = 8 Then k = 0
End Sub

