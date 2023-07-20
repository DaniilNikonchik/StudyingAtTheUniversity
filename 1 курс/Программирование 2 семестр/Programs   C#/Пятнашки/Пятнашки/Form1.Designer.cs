namespace Пятнашки
{
    partial class Form1
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
            this.components = new System.ComponentModel.Container();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.bt15 = new System.Windows.Forms.Button();
            this.bt14 = new System.Windows.Forms.Button();
            this.bt13 = new System.Windows.Forms.Button();
            this.bt12 = new System.Windows.Forms.Button();
            this.bt11 = new System.Windows.Forms.Button();
            this.bt10 = new System.Windows.Forms.Button();
            this.bt9 = new System.Windows.Forms.Button();
            this.bt8 = new System.Windows.Forms.Button();
            this.bt7 = new System.Windows.Forms.Button();
            this.bt6 = new System.Windows.Forms.Button();
            this.bt5 = new System.Windows.Forms.Button();
            this.bt4 = new System.Windows.Forms.Button();
            this.bt3 = new System.Windows.Forms.Button();
            this.bt2 = new System.Windows.Forms.Button();
            this.bt1 = new System.Windows.Forms.Button();
            this.bt0 = new System.Windows.Forms.Button();
            this.timerSec = new System.Windows.Forms.Timer(this.components);
            this.lSec = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lDot = new System.Windows.Forms.Label();
            this.lMin = new System.Windows.Forms.Label();
            this.btStartGame = new System.Windows.Forms.Button();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.CellBorderStyle = System.Windows.Forms.TableLayoutPanelCellBorderStyle.Single;
            this.tableLayoutPanel1.ColumnCount = 4;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.Controls.Add(this.bt15, 3, 3);
            this.tableLayoutPanel1.Controls.Add(this.bt14, 2, 3);
            this.tableLayoutPanel1.Controls.Add(this.bt13, 1, 3);
            this.tableLayoutPanel1.Controls.Add(this.bt12, 0, 3);
            this.tableLayoutPanel1.Controls.Add(this.bt11, 3, 2);
            this.tableLayoutPanel1.Controls.Add(this.bt10, 2, 2);
            this.tableLayoutPanel1.Controls.Add(this.bt9, 1, 2);
            this.tableLayoutPanel1.Controls.Add(this.bt8, 0, 2);
            this.tableLayoutPanel1.Controls.Add(this.bt7, 3, 1);
            this.tableLayoutPanel1.Controls.Add(this.bt6, 2, 1);
            this.tableLayoutPanel1.Controls.Add(this.bt5, 1, 1);
            this.tableLayoutPanel1.Controls.Add(this.bt4, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.bt3, 3, 0);
            this.tableLayoutPanel1.Controls.Add(this.bt2, 2, 0);
            this.tableLayoutPanel1.Controls.Add(this.bt1, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.bt0, 0, 0);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 28);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 4;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 25F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(542, 456);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // bt15
            // 
            this.bt15.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt15.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt15.Location = new System.Drawing.Point(421, 355);
            this.bt15.Margin = new System.Windows.Forms.Padding(15);
            this.bt15.Name = "bt15";
            this.bt15.Size = new System.Drawing.Size(105, 85);
            this.bt15.TabIndex = 15;
            this.bt15.Tag = "15";
            this.bt15.Text = "-";
            this.bt15.UseVisualStyleBackColor = true;
            this.bt15.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt14
            // 
            this.bt14.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt14.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt14.Location = new System.Drawing.Point(286, 355);
            this.bt14.Margin = new System.Windows.Forms.Padding(15);
            this.bt14.Name = "bt14";
            this.bt14.Size = new System.Drawing.Size(104, 85);
            this.bt14.TabIndex = 14;
            this.bt14.Tag = "14";
            this.bt14.Text = "-";
            this.bt14.UseVisualStyleBackColor = true;
            this.bt14.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt13
            // 
            this.bt13.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt13.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt13.Location = new System.Drawing.Point(151, 355);
            this.bt13.Margin = new System.Windows.Forms.Padding(15);
            this.bt13.Name = "bt13";
            this.bt13.Size = new System.Drawing.Size(104, 85);
            this.bt13.TabIndex = 13;
            this.bt13.Tag = "13";
            this.bt13.Text = "-";
            this.bt13.UseVisualStyleBackColor = true;
            this.bt13.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt12
            // 
            this.bt12.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt12.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt12.Location = new System.Drawing.Point(16, 355);
            this.bt12.Margin = new System.Windows.Forms.Padding(15);
            this.bt12.Name = "bt12";
            this.bt12.Size = new System.Drawing.Size(104, 85);
            this.bt12.TabIndex = 12;
            this.bt12.Tag = "12";
            this.bt12.Text = "-";
            this.bt12.UseVisualStyleBackColor = true;
            this.bt12.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt11
            // 
            this.bt11.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt11.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt11.Location = new System.Drawing.Point(421, 242);
            this.bt11.Margin = new System.Windows.Forms.Padding(15);
            this.bt11.Name = "bt11";
            this.bt11.Size = new System.Drawing.Size(105, 82);
            this.bt11.TabIndex = 11;
            this.bt11.Tag = "11";
            this.bt11.Text = "-";
            this.bt11.UseVisualStyleBackColor = true;
            this.bt11.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt10
            // 
            this.bt10.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt10.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt10.Location = new System.Drawing.Point(286, 242);
            this.bt10.Margin = new System.Windows.Forms.Padding(15);
            this.bt10.Name = "bt10";
            this.bt10.Size = new System.Drawing.Size(104, 82);
            this.bt10.TabIndex = 10;
            this.bt10.Tag = "10";
            this.bt10.Text = "-";
            this.bt10.UseVisualStyleBackColor = true;
            this.bt10.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt9
            // 
            this.bt9.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt9.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt9.Location = new System.Drawing.Point(151, 242);
            this.bt9.Margin = new System.Windows.Forms.Padding(15);
            this.bt9.Name = "bt9";
            this.bt9.Size = new System.Drawing.Size(104, 82);
            this.bt9.TabIndex = 9;
            this.bt9.Tag = "9";
            this.bt9.Text = "-";
            this.bt9.UseVisualStyleBackColor = true;
            this.bt9.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt8
            // 
            this.bt8.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt8.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt8.Location = new System.Drawing.Point(16, 242);
            this.bt8.Margin = new System.Windows.Forms.Padding(15);
            this.bt8.Name = "bt8";
            this.bt8.Size = new System.Drawing.Size(104, 82);
            this.bt8.TabIndex = 8;
            this.bt8.Tag = "8";
            this.bt8.Text = "-";
            this.bt8.UseVisualStyleBackColor = true;
            this.bt8.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt7
            // 
            this.bt7.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt7.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt7.Location = new System.Drawing.Point(421, 129);
            this.bt7.Margin = new System.Windows.Forms.Padding(15);
            this.bt7.Name = "bt7";
            this.bt7.Size = new System.Drawing.Size(105, 82);
            this.bt7.TabIndex = 7;
            this.bt7.Tag = "7";
            this.bt7.Text = "-";
            this.bt7.UseVisualStyleBackColor = true;
            this.bt7.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt6
            // 
            this.bt6.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt6.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt6.Location = new System.Drawing.Point(286, 129);
            this.bt6.Margin = new System.Windows.Forms.Padding(15);
            this.bt6.Name = "bt6";
            this.bt6.Size = new System.Drawing.Size(104, 82);
            this.bt6.TabIndex = 6;
            this.bt6.Tag = "6";
            this.bt6.Text = "-";
            this.bt6.UseVisualStyleBackColor = true;
            this.bt6.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt5
            // 
            this.bt5.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt5.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt5.Location = new System.Drawing.Point(151, 129);
            this.bt5.Margin = new System.Windows.Forms.Padding(15);
            this.bt5.Name = "bt5";
            this.bt5.Size = new System.Drawing.Size(104, 82);
            this.bt5.TabIndex = 5;
            this.bt5.Tag = "5";
            this.bt5.Text = "-";
            this.bt5.UseVisualStyleBackColor = true;
            this.bt5.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt4
            // 
            this.bt4.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt4.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt4.Location = new System.Drawing.Point(16, 129);
            this.bt4.Margin = new System.Windows.Forms.Padding(15);
            this.bt4.Name = "bt4";
            this.bt4.Size = new System.Drawing.Size(104, 82);
            this.bt4.TabIndex = 4;
            this.bt4.Tag = "4";
            this.bt4.Text = "-";
            this.bt4.UseVisualStyleBackColor = true;
            this.bt4.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt3
            // 
            this.bt3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt3.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt3.Location = new System.Drawing.Point(421, 16);
            this.bt3.Margin = new System.Windows.Forms.Padding(15);
            this.bt3.Name = "bt3";
            this.bt3.Size = new System.Drawing.Size(105, 82);
            this.bt3.TabIndex = 3;
            this.bt3.Tag = "3";
            this.bt3.Text = "-";
            this.bt3.UseVisualStyleBackColor = true;
            this.bt3.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt2
            // 
            this.bt2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt2.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt2.Location = new System.Drawing.Point(286, 16);
            this.bt2.Margin = new System.Windows.Forms.Padding(15);
            this.bt2.Name = "bt2";
            this.bt2.Size = new System.Drawing.Size(104, 82);
            this.bt2.TabIndex = 2;
            this.bt2.Tag = "2";
            this.bt2.Text = "-";
            this.bt2.UseVisualStyleBackColor = true;
            this.bt2.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt1
            // 
            this.bt1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt1.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt1.Location = new System.Drawing.Point(151, 16);
            this.bt1.Margin = new System.Windows.Forms.Padding(15);
            this.bt1.Name = "bt1";
            this.bt1.Size = new System.Drawing.Size(104, 82);
            this.bt1.TabIndex = 1;
            this.bt1.Tag = "1";
            this.bt1.Text = "-";
            this.bt1.UseVisualStyleBackColor = true;
            this.bt1.Click += new System.EventHandler(this.bt15_Click);
            // 
            // bt0
            // 
            this.bt0.Dock = System.Windows.Forms.DockStyle.Fill;
            this.bt0.Font = new System.Drawing.Font("Tahoma", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.bt0.Location = new System.Drawing.Point(16, 16);
            this.bt0.Margin = new System.Windows.Forms.Padding(15);
            this.bt0.Name = "bt0";
            this.bt0.Size = new System.Drawing.Size(104, 82);
            this.bt0.TabIndex = 0;
            this.bt0.Tag = "0";
            this.bt0.Text = "-";
            this.bt0.UseVisualStyleBackColor = true;
            this.bt0.Click += new System.EventHandler(this.bt15_Click);
            // 
            // timerSec
            // 
            this.timerSec.Enabled = true;
            this.timerSec.Interval = 500;
            this.timerSec.Tick += new System.EventHandler(this.timerSec_Tick);
            // 
            // lSec
            // 
            this.lSec.AutoSize = true;
            this.lSec.Location = new System.Drawing.Point(510, 9);
            this.lSec.Name = "lSec";
            this.lSec.Size = new System.Drawing.Size(24, 17);
            this.lSec.TabIndex = 2;
            this.lSec.Text = "00";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(233, 8);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(223, 17);
            this.label1.TabIndex = 3;
            this.label1.Text = "Прошло времени с начала игры:";
            // 
            // lDot
            // 
            this.lDot.AutoSize = true;
            this.lDot.Location = new System.Drawing.Point(492, 9);
            this.lDot.Name = "lDot";
            this.lDot.Size = new System.Drawing.Size(12, 17);
            this.lDot.TabIndex = 4;
            this.lDot.Text = ":";
            // 
            // lMin
            // 
            this.lMin.AutoSize = true;
            this.lMin.Location = new System.Drawing.Point(462, 9);
            this.lMin.Name = "lMin";
            this.lMin.Size = new System.Drawing.Size(24, 17);
            this.lMin.TabIndex = 5;
            this.lMin.Text = "00";
            // 
            // btStartGame
            // 
            this.btStartGame.Location = new System.Drawing.Point(0, 3);
            this.btStartGame.Name = "btStartGame";
            this.btStartGame.Size = new System.Drawing.Size(120, 23);
            this.btStartGame.TabIndex = 6;
            this.btStartGame.Text = "Новая игра";
            this.btStartGame.UseVisualStyleBackColor = true;
            this.btStartGame.Click += new System.EventHandler(this.btStartGame_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(542, 484);
            this.Controls.Add(this.btStartGame);
            this.Controls.Add(this.lMin);
            this.Controls.Add(this.lDot);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lSec);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Пятнашки";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Button bt15;
        private System.Windows.Forms.Button bt14;
        private System.Windows.Forms.Button bt13;
        private System.Windows.Forms.Button bt12;
        private System.Windows.Forms.Button bt11;
        private System.Windows.Forms.Button bt10;
        private System.Windows.Forms.Button bt9;
        private System.Windows.Forms.Button bt8;
        private System.Windows.Forms.Button bt7;
        private System.Windows.Forms.Button bt6;
        private System.Windows.Forms.Button bt5;
        private System.Windows.Forms.Button bt4;
        private System.Windows.Forms.Button bt3;
        private System.Windows.Forms.Button bt2;
        private System.Windows.Forms.Button bt1;
        private System.Windows.Forms.Button bt0;
        private System.Windows.Forms.Timer timerSec;
        private System.Windows.Forms.Label lSec;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lDot;
        private System.Windows.Forms.Label lMin;
        private System.Windows.Forms.Button btStartGame;
    }
}

