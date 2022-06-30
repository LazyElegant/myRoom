Public Class Form2

    Private MYLabel(5) As Label
    Private Sub addLabel(num As Integer)
        Dim Label1 As New Label
        Randomize()
        Label1.Font = New System.Drawing.Font(New FontFamily("Sitka Heading"), 18, FontStyle.Bold, System.Drawing.GraphicsUnit.Point)
        Label1.Text = Chr(Asc("a") + Int(Rnd() * 26))
        Label1.Location = New Point(Int(Rnd() * Me.Width), 10)
        Label1.Width = 20
        MYLabel(num) = Label1
        Me.Controls.Add(MYLabel(num))
    End Sub
    Private Sub endForm()
        Timer1.Enabled = False
        Timer1.Stop()
        Dim frm As New Form1()
        MessageBox.Show("你输了！！", "提示")
        frm.Show()
        Me.Close()
    End Sub
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        For i As Integer = 0 To MYLabel.Length - 1
            Call addLabel(i)
        Next i
        Button1.Visible = False
        Timer1.Enabled = True
    End Sub
    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        For i As Integer = 0 To MYLabel.Length - 1
            MYLabel(i).Location = New Point(MYLabel(i).Left, MYLabel(i).Top + 10)
            If MYLabel(i).Top + MYLabel(i).Height >= Me.Height Then
                Call endForm()
                Exit For
            End If
        Next i
    End Sub

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.KeyPreview = True
    End Sub

    Private Sub Form2_KeyDown(sender As Object, e As KeyEventArgs) Handles Me.KeyDown
        For i As Integer = 0 To MYLabel.Length - 1
            If e.KeyCode = Asc(UCase(MYLabel(i).Text)) Then
                Me.Controls.Remove(MYLabel(i))
                Call addLabel(i)
            End If
        Next i
    End Sub
End Class