Public Class Form3

    Private MYLabel(12) As Label

    Private Sub pen()

        For i As Integer = 0 To 11
            If PictureBox1.Top + PictureBox1.Height >= MYLabel(i).Top _
               And PictureBox1.Top <= MYLabel(i).Top + MYLabel(i).Height _
               And PictureBox1.Left <= MYLabel(i).Left + MYLabel(i).Width _
               And PictureBox1.Left + PictureBox1.Width >= MYLabel(i).Left Then
                Dim frm As New Form1()
                MessageBox.Show("你输了！！", "提示")
                frm.Show()
                Me.Close()

            End If
        Next

        If PictureBox1.Top + PictureBox1.Height >= PictureBox2.Top _
           And PictureBox1.Top <= PictureBox2.Top + PictureBox2.Height _
           And PictureBox1.Left <= PictureBox2.Left + PictureBox2.Width _
           And PictureBox1.Left + PictureBox1.Width >= PictureBox2.Left Then

            MessageBox.Show("过关！！", "提示")
            PictureBox1.Location = New Point(15, 15)
        End If

    End Sub

    Private Sub Form3_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        MYLabel(0) = Me.Label1
        MYLabel(1) = Me.Label2
        MYLabel(2) = Me.Label3
        MYLabel(3) = Me.Label4
        MYLabel(4) = Me.Label5
        MYLabel(5) = Me.Label6
        MYLabel(6) = Me.Label7
        MYLabel(7) = Me.Label8
        MYLabel(8) = Me.Label9
        MYLabel(9) = Me.Label10
        MYLabel(10) = Me.Label11
        MYLabel(11) = Me.Label12
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        PictureBox1.Top = PictureBox1.Top - 10
        pen()
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click

        PictureBox1.Top = PictureBox1.Top + 10
        pen()
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click

        PictureBox1.Left = PictureBox1.Left - 10
        pen()
    End Sub

    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click

        PictureBox1.Left = PictureBox1.Left + 10
        pen()
    End Sub

    Private Sub Label12_Click(sender As Object, e As EventArgs) Handles Label12.Click

    End Sub

    Private Sub PictureBox1_Click(sender As Object, e As EventArgs) Handles PictureBox1.Click

    End Sub
End Class