using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _2048
{
    public partial class Form2 : Form
    {

        private const int result = 2048;
        private int[][] map;
        private Button[] buttons;
        private int[] mergeArray;
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            map = new int[5][];
            buttons = new Button[25];
            buttons[0] = button1;
            buttons[1] = button2;
            buttons[2] = button3;
            buttons[3] = button4;
            buttons[4] = button5;
            buttons[5] = button6;
            buttons[6] = button7;
            buttons[7] = button8;
            buttons[8] = button9;
            buttons[9] = button10;
            buttons[10] = button11;
            buttons[11] = button12;
            buttons[12] = button13;
            buttons[13] = button14;
            buttons[14] = button15;
            buttons[15] = button16;
            buttons[16] = button17;
            buttons[17] = button18;
            buttons[18] = button19;
            buttons[19] = button20;
            buttons[20] = button21;
            buttons[21] = button22;
            buttons[22] = button23;
            buttons[23] = button24;
            buttons[24] = button25;

            for (int i = 0; i < 5; i++)
            {
                map[i] = new int[5];
            }
            mergeArray = new int[5];

            setNextPoint(getNextPoint(), getNextValue());
            setNextPoint(getNextPoint(), getNextValue());
            display();
        }
        private void setNextPoint(Point point, int value)
        {
            map[point.x][point.y] = value;
        }

        private Point getNextPoint()
        {
            Random random = new Random();
            int n_row = random.Next(0, 5), n_col = random.Next(0, 5);
            while (map[n_row][n_col] != 0)
            {
                n_row = random.Next(0, 5);
                n_col = random.Next(0, 5);
            }
            return new Point(n_row, n_col);
        }

        private int getNextValue()
        {
            Random random = new Random();
            return random.NextDouble() <= 0.8f ? 2 : 4;
        }

        private void display()
        {
            for (int i = 0; i < map.Length; i++) { 
                for(int j =0; j< map[i].Length; j++)
                {
                    if (map[i][j] == 0)
                    {
                        buttons[i * 5 + j].Text = "";
                        buttons[i * 5 + j].BackColor = Color.White;
                    }
                    else if (map[i][j] == 2)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightPink;
                    }
                    else if (map[i][j] == 4)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightGreen;
                    }else if (map[i][j] == 8)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightCoral;
                    }
                    else if (map[i][j] == 16)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightSalmon;
                    }
                    else if (map[i][j] == 32)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightSeaGreen;
                    }
                    else if (map[i][j] == 64)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightSkyBlue;
                    }
                    else if (map[i][j] == 128)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.LightYellow;
                    }
                    else if (map[i][j] == 256)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.Red;
                    }
                    else if (map[i][j] == 512)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.Blue;
                    }
                    else if (map[i][j] == 1024)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.Crimson;
                    }
                    else if (map[i][j] == 1024)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.Coral;
                    }
                    else if (map[i][j] == 2048)
                    {
                        buttons[i * 5 + j].Text = map[i][j] + "";
                        buttons[i * 5 + j].BackColor = Color.DarkRed;
                    }
                }
            }
        }
        private void Form2_KeyUp(object sender, KeyEventArgs e)
        {

            display();

            switch (e.KeyValue) {
                case 87:     // 上
                    toUp();
                    setNextPoint(getNextPoint(), getNextValue());
                    break;
                case 83:     // 下
                    toDown();
                    setNextPoint(getNextPoint(), getNextValue());
                    break;
                case 65:     // 左
                    toLeft();
                    setNextPoint(getNextPoint(), getNextValue());
                    break;
                case 68:     // 右
                    toRight();
                    setNextPoint(getNextPoint(), getNextValue());
                    break;
            }
            int t = check();
            if (t == 1)
            {
                MessageBox.Show("您赢了!");
                Form1 form1 = new Form1();
                form1.Show();
                this.Close();
            } else if (t == -1)
            {
                MessageBox.Show("您输了!");
                Form1 form1 = new Form1();
                form1.Show();
                this.Close();
            }
            display();
        }
        private void toRight()
        {
            for (int i = 0; i < 5; i++)
            {
                int prevValue = -1, prevDis = 5 - 1;
                for (int j = 5 - 1; j >= 0; j--)
                {
                    if (prevValue != map[i][j])
                    {
                        if (map[i][j] != 0)
                        {
                            prevValue = map[i][j];
                            prevDis = j;
                        }
                    }
                    else
                    {
                        setNextPoint(new Point(i, prevDis), prevValue * 2);
                        setNextPoint(new Point(i, j), 0);
                        break;
                    }
                }
                int pos = 5 - 1;
                for (int k = 5 - 1; k >= 0; k--)
                {
                    if (map[i][k] != 0)
                    {
                        mergeArray[pos--] = map[i][k];
                    }
                }
                for (; pos >= 0; pos--)
                {
                    mergeArray[pos] = 0;
                }
                mergeArray.CopyTo(map[i], 0);
            }
        }

        private void toLeft()
        {
            for (int i = 0; i < 5; i++)
            {
                int prevValue = -1, prevDis = 0;
                for (int j = 0; j < 5; j++)
                {
                    if (prevValue != map[i][j])
                    {
                        if (map[i][j] != 0)
                        {
                            prevValue = map[i][j];
                            prevDis = j;
                        }
                    }
                    else
                    {
                        setNextPoint(new Point(i, prevDis), prevValue * 2);
                        setNextPoint(new Point(i, j), 0);
                        break;
                    }
                }
                int pos = 0;
                for (int k = 0; k < 5; k++)
                {
                    if (map[i][k] != 0)
                    {
                        mergeArray[pos++] = map[i][k];
                    }
                }
                for (; pos < 5; pos++)
                {
                    mergeArray[pos] = 0;
                }
                mergeArray.CopyTo(map[i], 0);
            }
        }

        private void toDown()
        {
            for (int j = 0; j < 5; j++)
            {
                int prevValue = -1, prevDis = 5 - 1;
                for (int i = 5 - 1; i >= 0; i--)
                {
                    if (prevValue != map[i][j])
                    {
                        if (map[i][j] != 0)
                        {
                            prevValue = map[i][j];
                            prevDis = i;
                        }
                    }
                    else
                    {
                        setNextPoint(new Point(prevDis, j), prevValue * 2);
                        setNextPoint(new Point(i, j), 0);
                        break;
                    }
                }
                int pos = 5 - 1;
                for (int k = 5 - 1; k >= 0; k--)
                {
                    if (map[k][j] != 0)
                    {
                        mergeArray[pos--] = map[k][j];
                    }
                }
                for (; pos >= 0; pos--)
                {
                    mergeArray[pos] = 0;
                }
                for (int k = 5 - 1; k >= 0; k--)
                {
                    map[k][j] = mergeArray[k];
                }
            }
        }

        private void toUp()
        {
            for (int j = 0; j < 5; j++)
            {
                int prevValue = -1, prevDis = 0;
                for (int i = 0; i < 5; i++)
                {
                    if (prevValue != map[i][j])
                    {
                        if (map[i][j] != 0)
                        {
                            prevValue = map[i][j];
                            prevDis = i;
                        }
                    }
                    else
                    {
                        setNextPoint(new Point(prevDis, j), prevValue * 2);
                        setNextPoint(new Point(i, j), 0);
                        break;
                    }
                }
                int pos = 0;
                for (int k = 0; k < 5; k++)
                {
                    if (map[k][j] != 0)
                    {
                        mergeArray[pos++] = map[k][j];
                    }
                }
                for (; pos < 5; pos++)
                {
                    mergeArray[pos] = 0;
                }
                for (int k = 0; k < 5; k++)
                {
                    map[k][j] = mergeArray[k];
                }
            }
        }
        private int check()
        {
            bool isFull = true;
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if (map[i][j] == result) return 1;
                    if (map[i][j] == 0) isFull = false;
                }
            }
            return isFull ? -1 : 0;
        }
    }
    
}
