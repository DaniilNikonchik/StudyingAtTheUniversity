namespace Events
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
            this.TBRestTime = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.BStart = new System.Windows.Forms.Button();
            this.Bstop = new System.Windows.Forms.Button();
            this.BClear = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.TBShootPause = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.TBShootSize = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.TBResult = new System.Windows.Forms.TextBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.SuspendLayout();
            // 
            // TBRestTime
            // 
            this.TBRestTime.Location = new System.Drawing.Point(153, 23);
            this.TBRestTime.Name = "TBRestTime";
            this.TBRestTime.Size = new System.Drawing.Size(108, 22);
            this.TBRestTime.TabIndex = 2;
            this.TBRestTime.Text = "1000";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label2.Location = new System.Drawing.Point(4, 23);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(105, 40);
            this.label2.TabIndex = 3;
            this.label2.Text = "Задержка\r\n вычислений";
            // 
            // BStart
            // 
            this.BStart.BackColor = System.Drawing.SystemColors.InactiveCaption;
            this.BStart.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F);
            this.BStart.Location = new System.Drawing.Point(7, 379);
            this.BStart.Name = "BStart";
            this.BStart.Size = new System.Drawing.Size(149, 62);
            this.BStart.TabIndex = 4;
            this.BStart.Text = "START";
            this.BStart.UseVisualStyleBackColor = false;
            this.BStart.Click += new System.EventHandler(this.BStart_Click);
            // 
            // Bstop
            // 
            this.Bstop.BackColor = System.Drawing.Color.Red;
            this.Bstop.Enabled = false;
            this.Bstop.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F);
            this.Bstop.Location = new System.Drawing.Point(162, 379);
            this.Bstop.Name = "Bstop";
            this.Bstop.Size = new System.Drawing.Size(167, 62);
            this.Bstop.TabIndex = 5;
            this.Bstop.Text = "STOP";
            this.Bstop.UseVisualStyleBackColor = false;
            this.Bstop.Click += new System.EventHandler(this.button1_Click);
            // 
            // BClear
            // 
            this.BClear.BackColor = System.Drawing.SystemColors.Menu;
            this.BClear.Font = new System.Drawing.Font("Microsoft Sans Serif", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.BClear.Location = new System.Drawing.Point(335, 379);
            this.BClear.Name = "BClear";
            this.BClear.Size = new System.Drawing.Size(212, 61);
            this.BClear.TabIndex = 6;
            this.BClear.Text = "CLEAR INFO";
            this.BClear.UseVisualStyleBackColor = false;
            this.BClear.Click += new System.EventHandler(this.BClear_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label4.Location = new System.Drawing.Point(6, 21);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(86, 20);
            this.label4.TabIndex = 8;
            this.label4.Text = "Задержка";
            // 
            // TBShootPause
            // 
            this.TBShootPause.Location = new System.Drawing.Point(118, 21);
            this.TBShootPause.Name = "TBShootPause";
            this.TBShootPause.Size = new System.Drawing.Size(152, 22);
            this.TBShootPause.TabIndex = 9;
            this.TBShootPause.Text = "1000";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label5.Location = new System.Drawing.Point(27, 55);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 20);
            this.label5.TabIndex = 10;
            this.label5.Text = "Размер";
            // 
            // TBShootSize
            // 
            this.TBShootSize.Location = new System.Drawing.Point(118, 55);
            this.TBShootSize.Name = "TBShootSize";
            this.TBShootSize.Size = new System.Drawing.Size(152, 22);
            this.TBShootSize.TabIndex = 11;
            this.TBShootSize.Text = "100";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.TBResult);
            this.groupBox1.Location = new System.Drawing.Point(14, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(547, 280);
            this.groupBox1.TabIndex = 12;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Инфо";
            // 
            // TBResult
            // 
            this.TBResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F);
            this.TBResult.Location = new System.Drawing.Point(6, 21);
            this.TBResult.Multiline = true;
            this.TBResult.Name = "TBResult";
            this.TBResult.ReadOnly = true;
            this.TBResult.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.TBResult.Size = new System.Drawing.Size(535, 248);
            this.TBResult.TabIndex = 1;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.TBShootPause);
            this.groupBox2.Controls.Add(this.TBShootSize);
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Location = new System.Drawing.Point(0, 283);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(284, 88);
            this.groupBox2.TabIndex = 13;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Параметры мишени";
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.label2);
            this.groupBox3.Controls.Add(this.TBRestTime);
            this.groupBox3.Location = new System.Drawing.Point(290, 286);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(270, 85);
            this.groupBox3.TabIndex = 12;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Общие параметры";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(577, 449);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.BClear);
            this.Controls.Add(this.Bstop);
            this.Controls.Add(this.BStart);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "EVENT EXPLORER";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.TextBox TBRestTime;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button BStart;
        private System.Windows.Forms.Button Bstop;
        private System.Windows.Forms.Button BClear;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox TBShootPause;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox TBShootSize;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox TBResult;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.GroupBox groupBox3;
    }
}

