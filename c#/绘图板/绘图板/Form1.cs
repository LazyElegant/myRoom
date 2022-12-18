using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 绘图板
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private Point p1;
        private Color myColor;
        private static bool drawing = false;
        private static bool rubber = false;
        private int fontsize = 2;
        private float rateWidth = 1;
        private float rateHeight = 1;

        private void button2_Click(object sender, EventArgs e)
        {
            rubber = true;
            drawing = false;
        }

        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)  //pictureBox鼠标按下
        {
            p1 = new Point((int)(e.X * rateWidth), (int)(e.Y * rateHeight)); //计算当前鼠标坐标
            if (rubber == false) { 
                drawing = true;         //如果是不是橡皮擦模式，则开启绘画模式
            }
        }

        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)//pictureBox鼠标抬起
        {
            drawing = false;//关闭绘画模式
        }

        private void button1_Click(object sender, EventArgs e)
        {
            rubber = false;
        }

        private void 清除ToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            
            if(MessageBox .Show("是否清除画布","清除确认", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                pictureBox1.Image = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            }
            
        }

        private void 保存ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveImageDialog = new SaveFileDialog();  // 打开文件资源管理器
            saveImageDialog.Title = "图片保存";
            saveImageDialog.Filter = @"jpeg|*.jpg|png|*.png"; // 设置文件类型
            saveImageDialog.DefaultExt = "jpg";
            if (saveImageDialog.ShowDialog() == DialogResult.OK) // 判断是否选好文件夹
            {
                string fileName = saveImageDialog.FileName.ToString();   //获取输入的文件名
                if (fileName != "" && fileName != null) {            // 判断文件夹名是否为空
                    string fileExtName = fileName.Substring(fileName.LastIndexOf(".") + 1).ToString();  // 文件夹名加后缀
                    System.Drawing.Imaging.ImageFormat imgformat = null;
                    if (fileExtName != "") {
                        switch (fileExtName)  // 根据文件夹后缀名生成图片
                        {
                            case "jpg":
                                imgformat = System.Drawing.Imaging.ImageFormat.Jpeg;
                                break;
                            case "png":
                                imgformat = System.Drawing.Imaging.ImageFormat.Png;
                                break;
                            default:
                                imgformat = System.Drawing.Imaging.ImageFormat.Jpeg;
                                break;
                        }
                        try
                        {
                            Bitmap bit = new Bitmap(pictureBox1.Width, pictureBox1.Height);
                            pictureBox1.DrawToBitmap(bit, pictureBox1.ClientRectangle);
                            bit.Save(fileName, imgformat);       //保存图片
                        }
                        catch
                        {

                        }
                    }
                }
            }
         }

        private void Form1_Load(object sender, EventArgs e)
        {
            pictureBox1.Image = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            myColor = Color.Black;
            fontsize = 2;
        }

        private void 插入图片ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Bitmap curBitmap = null;
            OpenFileDialog openFileDialog = new OpenFileDialog();// 打开文件资源管理器
            openFileDialog.Filter = "jpeg文件|*.jpg";     // 设置文件类型
            openFileDialog.Title = "打开图片:";
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                curBitmap = (Bitmap)Image.FromFile(openFileDialog.FileName);// 将图片加载进Bitmap中
                Invalidate();
            }
            rateWidth  = (float)curBitmap.Width / pictureBox1.Width;// 计算宽度比率
            rateHeight = (float)curBitmap.Height / pictureBox1.Height;// 计算高度比率

            pictureBox1.Image = curBitmap;   //往pictureBox添加图片
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;


        }

        private void 红色ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            myColor = Color.Red;
        }

        private void 绿色ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            myColor = Color.Green;
        }

        private void 蓝色ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            myColor = Color.Blue;
        }
        private void 黑色ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            myColor = Color.Black;
        }

        private void 灰色ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            myColor = Color.Gray;
        }

        private void 黄色ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            myColor = Color.Yellow;
        }

        private void 橙色ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            myColor = Color.Orange;
        }

        private void toolStripMenuItem3_Click(object sender, EventArgs e)
        {
            fontsize = 2;
        }

        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            fontsize = 4;
        }

        private void toolStripMenuItem4_Click(object sender, EventArgs e)
        {
            fontsize = 6;

        }

        private void toolStripMenuItem5_Click(object sender, EventArgs e)
        {
            fontsize = 8;
        }

        private void toolStripMenuItem6_Click(object sender, EventArgs e)
        {
            fontsize = 10;
        }

        private void toolStripMenuItem7_Click(object sender, EventArgs e)
        {
            fontsize = 12;
        }

        private void pictureBox1_MouseMove(object sender, MouseEventArgs e) //pictureBox鼠标移动事件
        {
            Image img = pictureBox1.Image; //获取pictureBox的图像
            Graphics g = Graphics.FromImage(img); 
            if (e.Button == MouseButtons.Left) //按住鼠标左键
            {
                if (drawing) //判断是否是绘画模式
                {
                    Point currentPoint = new Point((int)(e.X * rateWidth), (int)(e.Y * rateHeight));//计算鼠标的坐标
                    g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;//消除锯齿
                    g.DrawLine(new Pen(myColor, fontsize), p1, currentPoint);//在鼠标的当前位置画线

                    p1.X = currentPoint.X; // 
                    p1.Y = currentPoint.Y;
                }
                else
                {
                    Point currentPoint = new Point((int)(e.X * rateWidth), (int)(e.Y * rateHeight));//计算鼠标的坐标
                    g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;//消除锯齿
                    g.DrawLine(new Pen(Color.White, 20), p1, currentPoint);//在鼠标的当前位置画线
                    p1.X = currentPoint.X;
                    p1.Y = currentPoint.Y;

                }
            }
            pictureBox1.Image =  img;//将画好的图像赋值回pictureBox
        }
    }
}
