namespace ShootingWF
{
    partial class Shooting
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.BEnterR = new System.Windows.Forms.Button();
            this.TBRadius = new System.Windows.Forms.TextBox();
            this.LERadius = new System.Windows.Forms.Label();
            this.LCurRadius = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.LTShoots = new System.Windows.Forms.Label();
            this.LAllShoots = new System.Windows.Forms.Label();
            this.BShoot = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.TBYShoot = new System.Windows.Forms.TextBox();
            this.TBXShoot = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // BEnterR
            // 
            this.BEnterR.BackColor = System.Drawing.Color.NavajoWhite;
            this.BEnterR.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.BEnterR.Location = new System.Drawing.Point(245, 15);
            this.BEnterR.Margin = new System.Windows.Forms.Padding(2);
            this.BEnterR.Name = "BEnterR";
            this.BEnterR.Size = new System.Drawing.Size(83, 24);
            this.BEnterR.TabIndex = 0;
            this.BEnterR.Text = "edit";
            this.BEnterR.UseVisualStyleBackColor = false;
            this.BEnterR.Click += new System.EventHandler(this.BEnterR_Click);
            // 
            // TBRadius
            // 
            this.TBRadius.Location = new System.Drawing.Point(121, 17);
            this.TBRadius.Margin = new System.Windows.Forms.Padding(2);
            this.TBRadius.Name = "TBRadius";
            this.TBRadius.Size = new System.Drawing.Size(120, 20);
            this.TBRadius.TabIndex = 1;
            this.TBRadius.TextChanged += new System.EventHandler(this.TBRadius_TextChanged);
            // 
            // LERadius
            // 
            this.LERadius.AutoSize = true;
            this.LERadius.Font = new System.Drawing.Font("Kristen ITC", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LERadius.Location = new System.Drawing.Point(4, 0);
            this.LERadius.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.LERadius.Name = "LERadius";
            this.LERadius.Size = new System.Drawing.Size(116, 36);
            this.LERadius.TabIndex = 4;
            this.LERadius.Text = "\r\nEnter the radius.";
            // 
            // LCurRadius
            // 
            this.LCurRadius.AutoSize = true;
            this.LCurRadius.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.LCurRadius.Location = new System.Drawing.Point(436, 12);
            this.LCurRadius.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.LCurRadius.Name = "LCurRadius";
            this.LCurRadius.Size = new System.Drawing.Size(107, 36);
            this.LCurRadius.TabIndex = 5;
            this.LCurRadius.Text = "Current radius:\r\n 50";
            this.LCurRadius.Click += new System.EventHandler(this.LCurRadius_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.LightPink;
            this.groupBox1.Controls.Add(this.LERadius);
            this.groupBox1.Controls.Add(this.LCurRadius);
            this.groupBox1.Controls.Add(this.TBRadius);
            this.groupBox1.Controls.Add(this.BEnterR);
            this.groupBox1.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.groupBox1.Location = new System.Drawing.Point(11, 2);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(2);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(2);
            this.groupBox1.Size = new System.Drawing.Size(570, 50);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // LTShoots
            // 
            this.LTShoots.AutoSize = true;
            this.LTShoots.BackColor = System.Drawing.Color.Pink;
            this.LTShoots.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.LTShoots.Location = new System.Drawing.Point(15, 254);
            this.LTShoots.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.LTShoots.Name = "LTShoots";
            this.LTShoots.Size = new System.Drawing.Size(51, 18);
            this.LTShoots.TabIndex = 7;
            this.LTShoots.Text = "Hits: 0";
            // 
            // LAllShoots
            // 
            this.LAllShoots.AutoSize = true;
            this.LAllShoots.BackColor = System.Drawing.Color.Pink;
            this.LAllShoots.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.LAllShoots.Location = new System.Drawing.Point(11, 226);
            this.LAllShoots.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.LAllShoots.Name = "LAllShoots";
            this.LAllShoots.Size = new System.Drawing.Size(88, 18);
            this.LAllShoots.TabIndex = 6;
            this.LAllShoots.Text = "All shoots: 0";
            this.LAllShoots.Click += new System.EventHandler(this.LAllShoots_Click);
            // 
            // BShoot
            // 
            this.BShoot.BackColor = System.Drawing.Color.NavajoWhite;
            this.BShoot.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.BShoot.ImageAlign = System.Drawing.ContentAlignment.BottomLeft;
            this.BShoot.Location = new System.Drawing.Point(0, 121);
            this.BShoot.Margin = new System.Windows.Forms.Padding(2);
            this.BShoot.Name = "BShoot";
            this.BShoot.Size = new System.Drawing.Size(88, 28);
            this.BShoot.TabIndex = 4;
            this.BShoot.Text = "shoot!";
            this.BShoot.UseVisualStyleBackColor = false;
            this.BShoot.Click += new System.EventHandler(this.BShoot_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.label2.Location = new System.Drawing.Point(4, 68);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(57, 18);
            this.label2.TabIndex = 3;
            this.label2.Text = "Enter Y";
            // 
            // TBYShoot
            // 
            this.TBYShoot.Location = new System.Drawing.Point(7, 88);
            this.TBYShoot.Margin = new System.Windows.Forms.Padding(2);
            this.TBYShoot.Name = "TBYShoot";
            this.TBYShoot.Size = new System.Drawing.Size(76, 20);
            this.TBYShoot.TabIndex = 1;
            // 
            // TBXShoot
            // 
            this.TBXShoot.Location = new System.Drawing.Point(7, 41);
            this.TBXShoot.Margin = new System.Windows.Forms.Padding(2);
            this.TBXShoot.Name = "TBXShoot";
            this.TBXShoot.Size = new System.Drawing.Size(76, 20);
            this.TBXShoot.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Kristen ITC", 9.75F);
            this.label1.Location = new System.Drawing.Point(4, 15);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(58, 18);
            this.label1.TabIndex = 2;
            this.label1.Text = "Enter X";
            // 
            // groupBox2
            // 
            this.groupBox2.BackColor = System.Drawing.Color.LightPink;
            this.groupBox2.Controls.Add(this.BShoot);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.TBYShoot);
            this.groupBox2.Controls.Add(this.TBXShoot);
            this.groupBox2.Location = new System.Drawing.Point(11, 56);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(2);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(2);
            this.groupBox2.Size = new System.Drawing.Size(105, 168);
            this.groupBox2.TabIndex = 7;
            this.groupBox2.TabStop = false;
            // 
            // Shooting
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.PeachPuff;
            this.ClientSize = new System.Drawing.Size(586, 348);
            this.Controls.Add(this.LTShoots);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.LAllShoots);
            this.Controls.Add(this.groupBox1);
            this.Cursor = System.Windows.Forms.Cursors.Cross;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Shooting";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Shooting";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.SizeChanged += new System.EventHandler(this.Form1_SizeChanged);
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseClick);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BEnterR;
        private System.Windows.Forms.TextBox TBRadius;
        private System.Windows.Forms.Label LERadius;
        private System.Windows.Forms.Label LCurRadius;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label LTShoots;
        private System.Windows.Forms.Label LAllShoots;
        private System.Windows.Forms.TextBox TBYShoot;
        private System.Windows.Forms.Button BShoot;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox TBXShoot;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox2;
    }
}

