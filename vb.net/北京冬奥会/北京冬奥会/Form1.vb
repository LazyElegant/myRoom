Public Class Form1

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        Module1.Button(0) = Me.Button1
        Module1.Button(1) = Me.Button2
        Module1.Button(2) = Me.Button3
        Module1.Button(3) = Me.Button4
        Module1.Button(4) = Me.Button5
        Module1.Button(5) = Me.Button6
        Module1.Button(6) = Me.Button7
        Module1.Button(7) = Me.Button8
        Module1.Button(8) = Me.Button9
        Module1.Button(9) = Me.Button10
        Module1.Button(10) = Me.Button11
        Module1.Button(11) = Me.Button12

        For i = 0 To 11 Step 1

            Module1.Button(i).BackColor = System.Drawing.Color.FromArgb(CType(128, Byte), CType(255, Byte), CType(128, Byte))

        Next i
    End Sub

    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick

        Module1.Button(Module1.num).BackColor = System.Drawing.Color.FromArgb(CType(128, Byte), CType(255, Byte), CType(128, Byte))
        Module1.num += 1
        If Module1.num = 12 Then
            Module1.num = 0
            If Label1.Text = "北京冬奥会" Then
                Label1.Text = "一起向未来"
            Else
                Label1.Text = "北京冬奥会"
            End If
        End If

        Module1.Button(Module1.num).BackColor = System.Drawing.Color.FromArgb(CType(252, Byte), CType(115, Byte), CType(35, Byte))

    End Sub

    Private Sub Button14_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button14.Click
        End
    End Sub

    Private Sub Button13_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button13.Click
        Form2.Show()
        Timer1.Stop()
        Me.Hide()
    End Sub
End Class
