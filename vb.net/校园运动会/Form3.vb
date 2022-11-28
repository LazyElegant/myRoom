Imports System.IO

Public Class Form3

    Dim strData(1) As String
    Dim count As Integer

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Form2.Show()
        Me.Hide()
    End Sub

    Private Sub Form3_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        ListBox1.Items.Clear()
        ListBox2.Items.Clear()
        ListBox3.Items.Clear()
        ListBox4.Items.Clear()
        ListBox5.Items.Clear()

        For i As Integer = 1 To count - 1
            Dim data(6) As String
            data = strData(i).Split(",")
            Dim a As Integer
            a = data(0)
            For j As Integer = i + 1 To count - 1
                Dim data2(6) As String
                data2 = strData(j).Split(",")
                Dim b As Integer
                b = data2(0)
                If a > b Then
                    Dim tem As String
                    tem = strData(i)
                    strData(i) = strData(j)
                    strData(j) = tem
                End If
            Next
        Next
        For i As Integer = 1 To count - 1
            Dim data(6) As String
            data = strData(i).Split(",")
            ListBox1.Items.Add(data(0))
            ListBox2.Items.Add(data(1))
            ListBox3.Items.Add(data(2))
            ListBox4.Items.Add(data(3))
            ListBox5.Items.Add(data(4))
        Next
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim number As String

        number = InputBox("请输入要删除运动员的学号")


        For i As Integer = 1 To count - 1
            Dim data(6) As String
            data = strData(i).Split(",")
            If data(0).Trim = number Then
                ListBox1.Items.RemoveAt(i - 1)
                ListBox2.Items.RemoveAt(i - 1)
                ListBox3.Items.RemoveAt(i - 1)
                ListBox4.Items.RemoveAt(i - 1)
                ListBox5.Items.RemoveAt(i - 1)
                For j As Integer = i + 1 To count - 1
                    strData(i) = strData(j)
                Next
                count = count - 1
            End If

        Next
        Using sw As StreamWriter = New StreamWriter("roster.txt")
            Dim str As String
            str = ""
            For i As Integer = 1 To count - 1
                str = str + strData(i) + vbCrLf
            Next
            sw.WriteLine(str)

        End Using
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Form1.Show()

        Me.Hide()

    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        ListBox1.Items.Clear()
        ListBox2.Items.Clear()
        ListBox3.Items.Clear()
        ListBox4.Items.Clear()
        ListBox5.Items.Clear()
        count = 1
        Using sr As StreamReader = New StreamReader("roster.txt")
            Dim line As String
            line = sr.ReadLine()
            While line <> Nothing
                strData(count) = line
                count = count + 1
                ReDim Preserve strData(count)
                line = sr.ReadLine()
            End While
        End Using
        For i As Integer = 1 To count - 1
            Dim data(6) As String
            data = strData(i).Split(",")
            ListBox1.Items.Add(data(0))
            ListBox2.Items.Add(data(1))
            ListBox3.Items.Add(data(2))
            ListBox4.Items.Add(data(3))
            ListBox5.Items.Add(data(4))
        Next
    End Sub
End Class