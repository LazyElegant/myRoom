VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   5700
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   9345
   LinkTopic       =   "Form1"
   ScaleHeight     =   5700
   ScaleWidth      =   9345
   StartUpPosition =   3  '����ȱʡ
   Begin VB.CommandButton Command5 
      Caption         =   "���ݻ�ѧ�ɼ�����"
      Height          =   735
      Left            =   6840
      TabIndex        =   5
      Top             =   4680
      Width           =   1695
   End
   Begin VB.CommandButton Command4 
      Caption         =   "������ѧ�ɼ�����"
      Height          =   735
      Left            =   6840
      TabIndex        =   4
      Top             =   3600
      Width           =   1695
   End
   Begin VB.CommandButton Command3 
      Caption         =   "����Ӣ��ɼ�����"
      Height          =   735
      Left            =   6840
      TabIndex        =   3
      Top             =   2520
      Width           =   1695
   End
   Begin VB.CommandButton Command2 
      Caption         =   "����"
      Height          =   735
      Left            =   6840
      TabIndex        =   2
      Top             =   1440
      Width           =   1695
   End
   Begin VB.CommandButton Command1 
      Caption         =   "����"
      Height          =   735
      Left            =   6840
      TabIndex        =   1
      Top             =   360
      Width           =   1695
   End
   Begin VB.ListBox List1 
      Height          =   5280
      ItemData        =   "Form1.frx":0000
      Left            =   240
      List            =   "Form1.frx":0002
      TabIndex        =   0
      Top             =   240
      Width           =   5775
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim i As Integer

Private Sub Command1_Click()
    Call listStudent
End Sub

Private Sub Command2_Click()
    Dim englishScore As Integer     'Ӣ��ƽ����
    Dim englishMax As Integer       'Ӣ����߷�
    Dim englishMin As Integer       'Ӣ����ͷ�
    Dim mathScore As Integer        '��ѧƽ����
    Dim mathMax As Integer          '��ѧ��߷�
    Dim mathMin As Integer          '��ѧ��ͷ�
    Dim chemistryScore As Integer   '��ѧƽ����
    Dim chemistryMax As Integer     '��ѧ��߷�
    Dim chemistryMin As Integer     '��ѧ��ͷ�
    

    englishMin = Module1.Class(0).GetEnglish
    englishMax = Module1.Class(0).GetEnglish
    mathMin = Module1.Class(0).GetMath
    mathMax = Module1.Class(0).GetMath
    chemistryMax = Module1.Class(0).GetChemistry
    chemistryMin = Module1.Class(0).GetChemistry
    
    '��������Ӣ�����ֵ����Сֵ....
    For n = 0 To i
        englishScore = englishScore + Module1.Class(n).GetEnglish
        mathScore = mathScore + Module1.Class(n).GetMath
        chemistryScore = chemistryScore + Module1.Class(n).GetChemistry
        If englishMin > Module1.Class(n).GetEnglish Then
            englishMin = Module1.Class(n).GetEnglish
        End If
        If englishMax < Module1.Class(n).GetEnglish Then
            englishMax = Module1.Class(n).GetEnglish
        End If
        If mathMin > Module1.Class(n).GetMath Then
            mathMin = Module1.Class(n).GetMath
        End If
        If mathMax < Module1.Class(n).GetMath Then
            mathMax = Module1.Class(n).GetMath
        End If
        If chemistryMin > Module1.Class(n).GetChemistry Then
            chemistryMin = Module1.Class(n).GetChemistry
        End If
        If chemistryMax < Module1.Class(n).GetChemistry Then
            chemistryMax = Module1.Class(n).GetChemistry
        End If
        
    Next n
    
    'ͨ��ð����������һ�����ڶ�����������
    For n = 1 To i
        For m = 0 To n - 1
            If Module1.Class(m).GetMath + Module1.Class(m).GetEnglish + Module1.Class(m).GetChemistry < Module1.Class(n).GetMath + Module1.Class(n).GetEnglish + Module1.Class(n).GetChemistry Then
                Set student = Module1.Class(m)
                Set Module1.Class(m) = Module1.Class(n)
                Set Module1.Class(n) = student
            End If
        Next m
    Next n
    
    
    Module1.englishScore = englishScore \ i
    Module1.mathScore = mathScore \ i
    Module1.chemistryScore = chemistryScore \ i
    Module1.englishMax = englishMax
    Module1.englishMin = englishMin
    Module1.mathMax = mathMax
    Module1.mathMin = mathMin
    Module1.chemistryMax = chemistryMax
    Module1.chemistryMin = chemistryMin
    
    Module1.firstScore = (Module1.Class(0).GetMath + Module1.Class(0).GetEnglish + Module1.Class(0).GetChemistry) \ 3
    Module1.first = Module1.Class(0).GetName
    
    Module1.secondScore = (Module1.Class(1).GetMath + Module1.Class(1).GetEnglish + Module1.Class(1).GetChemistry) \ 3
    Module1.second = Module1.Class(1).GetName
    Module1.thirdScore = (Module1.Class(2).GetMath + Module1.Class(2).GetEnglish + Module1.Class(2).GetChemistry) \ 3
    Module1.third = Module1.Class(2).GetName
    
    Form2.Show
End Sub

Private Sub Command3_Click()
    'ͨ��ð����������Ӣ��ɼ�
    For n = 1 To i
        For m = 0 To n - 1
            If Module1.Class(m).GetEnglish < Module1.Class(n).GetEnglish Then
                Set student = Module1.Class(m)
                Set Module1.Class(m) = Module1.Class(n)
                Set Module1.Class(n) = student
            End If
        Next m
    Next n
    Call listStudent
    
End Sub

Private Sub Command4_Click()
    'ͨ��ð������������ѧ�ɼ�
    For n = 1 To i
        For m = 0 To n - 1
            If Module1.Class(m).GetMath < Module1.Class(n).GetMath Then
                Set student = Module1.Class(m)
                Set Module1.Class(m) = Module1.Class(n)
                Set Module1.Class(n) = student
            End If
        Next m
    Next n
    Call listStudent
    
End Sub

Private Sub Command5_Click()
    'ͨ��ð����������ѧ�ɼ�
    For n = 1 To i
        For m = 0 To n - 1
            If Module1.Class(m).GetChemistry < Module1.Class(n).GetChemistry Then
                Set student = Module1.Class(m)
                Set Module1.Class(m) = Module1.Class(n)
                Set Module1.Class(n) = student
            End If
        Next m
    Next n
    Call listStudent
End Sub

Private Sub Form_Load()

Randomize
'���ɰ༶����
i = Int((50 - 30 + 1) * Rnd + 30)
ReDim Preserve Module1.Class(i)
'��������ɼ����Ա�
For n = 0 To i

    Set student = New Class1
    
    With student
    .SetName ("��" & 10 + n)
    .SetSex (Int(2 * Rnd))
    .SetEnglish (Int((101) * Rnd))
    .SetMath (Int((101) * Rnd))
    .SetChemistry (Int((101) * Rnd))
    End With
    Set Module1.Class(n) = student
    
Next n

    List1.AddItem "����   ѧ������   �Ա�   Ӣ��ɼ�   ��ѧ�ɼ�   ��ѧ�ɼ�"

End Sub

'�����������module1�е�ѧ��
Private Sub listStudent()
    
    List1.Clear
    List1.AddItem "����   ѧ������   �Ա�   Ӣ��ɼ�   ��ѧ�ɼ�   ��ѧ�ɼ�"

    For n = 0 To i
        Dim str As String
        If Module1.Class(n).GetSex = 0 Then
            str = "��"
        Else
            str = "Ů"
        End If
        List1.AddItem Format(n, "00") & "     " & Module1.Class(n).GetName & "        " & str & "       " & Format(Module1.Class(n).GetEnglish, "00") & "         " & Format(Module1.Class(n).GetMath, "00") & "         " & Format(Module1.Class(n).GetChemistry, "00")
    Next n
End Sub
