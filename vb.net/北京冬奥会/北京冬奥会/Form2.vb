Public Class Form2
    Public IsDragging As Boolean = False, IsClick As Boolean = False
    Public StartPoint, FirstPoint, LastPoint As Point
    Private MYLabel(6) As Label

    Private Sub PictureBox2_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox2.MouseDown

        StartPoint = PictureBox2.PointToScreen(New Point(e.X, e.Y))
        FirstPoint = StartPoint
        IsDragging = True
    End Sub

    Private Sub PictureBox2_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox2.MouseMove
        If IsDragging Then
            Dim EndPoint As Point = PictureBox2.PointToScreen(New Point(e.X, e.Y))
            IsClick = False
            PictureBox2.Left += (EndPoint.X - StartPoint.X)
            PictureBox2.Top += (EndPoint.Y - StartPoint.Y)
            StartPoint = EndPoint
            LastPoint = EndPoint
            pen()
        End If
    End Sub

    Private Sub PictureBox2_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox2.MouseUp

        IsDragging = False
        If LastPoint = StartPoint Then IsClick = True Else IsClick = False
    End Sub

    Private Sub Form2_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        MYLabel(0) = Me.Label1
        MYLabel(1) = Me.Label2
        MYLabel(2) = Me.Label3
        MYLabel(3) = Me.Label4
        MYLabel(4) = Me.Label5
        MYLabel(5) = Me.Label6
    End Sub
    Private Sub pen()

        For i As Integer = 0 To 5
            If PictureBox2.Top + PictureBox2.Height >= MYLabel(i).Top _
               And PictureBox2.Top <= MYLabel(i).Top + MYLabel(i).Height _
               And PictureBox2.Left <= MYLabel(i).Left + MYLabel(i).Width _
               And PictureBox2.Left + PictureBox2.Width >= MYLabel(i).Left Then
                Dim frm As New Form1()
                MessageBox.Show("你输了！！", "提示")
                frm.Show()
                Me.Close()

            End If
        Next

        If PictureBox2.Top + PictureBox2.Height >= PictureBox1.Top _
           And PictureBox2.Top <= PictureBox1.Top + PictureBox1.Height _
           And PictureBox2.Left <= PictureBox1.Left + PictureBox1.Width _
           And PictureBox2.Left + PictureBox2.Width >= PictureBox1.Left Then

            MessageBox.Show("过关！！", "提示")
            PictureBox2.Location = New Point(15, 15)
        End If

    End Sub

End Class