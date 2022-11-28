Imports System.IO

Public Class Form2

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Using sw As StreamWriter = New StreamWriter("roster.txt", True)
            Dim str As String

            str = TextBox4.Text + "," + TextBox1.Text + "," + TextBox2.Text + "," + TextBox3.Text + "," + ComboBox1.Items(ComboBox1.SelectedIndex)

            sw.WriteLine(str)
        End Using
        MsgBox("注册成功")
        TextBox1.Text = ""
        TextBox2.Text = ""
        TextBox3.Text = ""
        TextBox4.Text = ""
        ComboBox1.SelectedIndex = 0
    End Sub

    Private Sub Form2_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ComboBox1.Items.Add("1000米长跑")
        ComboBox1.Items.Add("跳高")
        ComboBox1.Items.Add("跳跃")
        ComboBox1.Items.Add("100米短跑")
        ComboBox1.Items.Add("拔河")
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Form1.Show()
        Me.Hide()
    End Sub
End Class