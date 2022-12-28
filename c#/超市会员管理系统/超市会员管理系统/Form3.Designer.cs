
namespace 超市会员管理系统
{
    partial class Form3
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form3));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.积分管理ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.退出系统ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.退出系统ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.返回首页ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.添加积分ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.扣除积分ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.积分管理ToolStripMenuItem,
            this.退出系统ToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1100, 28);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // 积分管理ToolStripMenuItem
            // 
            this.积分管理ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.添加积分ToolStripMenuItem,
            this.扣除积分ToolStripMenuItem});
            this.积分管理ToolStripMenuItem.Name = "积分管理ToolStripMenuItem";
            this.积分管理ToolStripMenuItem.Size = new System.Drawing.Size(83, 24);
            this.积分管理ToolStripMenuItem.Text = "积分管理";
            // 
            // 退出系统ToolStripMenuItem
            // 
            this.退出系统ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.退出系统ToolStripMenuItem1,
            this.返回首页ToolStripMenuItem});
            this.退出系统ToolStripMenuItem.Name = "退出系统ToolStripMenuItem";
            this.退出系统ToolStripMenuItem.Size = new System.Drawing.Size(83, 24);
            this.退出系统ToolStripMenuItem.Text = "系统管理";
            // 
            // 退出系统ToolStripMenuItem1
            // 
            this.退出系统ToolStripMenuItem1.Name = "退出系统ToolStripMenuItem1";
            this.退出系统ToolStripMenuItem1.Size = new System.Drawing.Size(224, 26);
            this.退出系统ToolStripMenuItem1.Text = "退出系统";
            this.退出系统ToolStripMenuItem1.Click += new System.EventHandler(this.退出系统ToolStripMenuItem1_Click);
            // 
            // 返回首页ToolStripMenuItem
            // 
            this.返回首页ToolStripMenuItem.Name = "返回首页ToolStripMenuItem";
            this.返回首页ToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.返回首页ToolStripMenuItem.Text = "返回首页";
            this.返回首页ToolStripMenuItem.Click += new System.EventHandler(this.返回首页ToolStripMenuItem_Click);
            // 
            // 添加积分ToolStripMenuItem
            // 
            this.添加积分ToolStripMenuItem.Name = "添加积分ToolStripMenuItem";
            this.添加积分ToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.添加积分ToolStripMenuItem.Text = "添加积分";
            this.添加积分ToolStripMenuItem.Click += new System.EventHandler(this.添加积分ToolStripMenuItem_Click);
            // 
            // 扣除积分ToolStripMenuItem
            // 
            this.扣除积分ToolStripMenuItem.Name = "扣除积分ToolStripMenuItem";
            this.扣除积分ToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.扣除积分ToolStripMenuItem.Text = "扣除积分";
            this.扣除积分ToolStripMenuItem.Click += new System.EventHandler(this.扣除积分ToolStripMenuItem_Click);
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1100, 666);
            this.Controls.Add(this.menuStrip1);
            this.DoubleBuffered = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form3";
            this.Text = "柜台首页";
            this.Load += new System.EventHandler(this.Form3_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 积分管理ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 添加积分ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 扣除积分ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 退出系统ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 退出系统ToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem 返回首页ToolStripMenuItem;
    }
}