VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Class1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False

Private name As String, sex As Integer, English As Integer, math As Integer, chemistry As Integer

Public Sub SetName(ByVal StrName As String)
    
    name = StrName

End Sub

Public Function GetName() As String
    
    GetName = name
    
End Function

Public Sub SetSex(ByVal StrSex As Integer)
    
    sex = StrSex

End Sub

Public Function GetSex() As Integer
    
    GetSex = sex
    
End Function


Public Sub SetEnglish(ByVal StrEnglish As Integer)
    
    English = StrEnglish

End Sub

Public Function GetEnglish() As Integer
    
    GetEnglish = English
    
End Function


Public Sub SetMath(ByVal StrMath As Integer)
    
    math = StrMath

End Sub

Public Function GetMath() As Integer
    
    GetMath = math
    
End Function

Public Sub SetChemistry(ByVal StrChemistry As Integer)
    
    chemistry = StrChemistry

End Sub

Public Function GetChemistry() As Integer
    
    GetChemistry = chemistry
    
End Function

