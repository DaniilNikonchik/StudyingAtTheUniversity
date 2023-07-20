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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.LTShoots = new System.Windows.Forms.Label();
            this.LAllShoots = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.BShoot = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.TBYShoot = new System.Windows.Forms.TextBox();
            this.TBXShoot = new System.Windows.Forms.TextBox();
            this.STOPShoot = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.groupBox1.AutoSize = true;
            this.groupBox1.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.groupBox1.Controls.Add(this.STOPShoot);
            this.groupBox1.Controls.Add(this.groupBox3);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.groupBox1.Location = new System.Drawing.Point(2, -2);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(218, 341);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.LTShoots);
            this.groupBox3.Controls.Add(this.LAllShoots);
            this.groupBox3.Location = new System.Drawing.Point(5, 21);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(207, 74);
            this.groupBox3.TabIndex = 7;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Инфо";
            // 
            // LTShoots
            // 
            this.LTShoots.AutoSize = true;
            this.LTShoots.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LTShoots.Location = new System.Drawing.Point(4, 41);
            this.LTShoots.Name = "LTShoots";
            this.LTShoots.Size = new System.Drawing.Size(140, 16);
            this.LTShoots.TabIndex = 10;
            this.LTShoots.Text = "Кол-во попаданий: 0";
            // 
            // LAllShoots
            // 
            this.LAllShoots.AutoSize = true;
            this.LAllShoots.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.LAllShoots.Location = new System.Drawing.Point(4, 22);
            this.LAllShoots.Name = "LAllShoots";
            this.LAllShoots.Size = new System.Drawing.Size(139, 16);
            this.LAllShoots.TabIndex = 9;
            this.LAllShoots.Text = "Кол-во выстрелов: 0";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.BShoot);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.TBYShoot);
            this.groupBox2.Controls.Add(this.TBXShoot);
            this.groupBox2.Location = new System.Drawing.Point(5, 184);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(207, 136);
            this.groupBox2.TabIndex = 7;
            this.groupBox2.TabStop = false;
            // 
            // BShoot
            // 
            this.BShoot.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.BShoot.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.BShoot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.BShoot.Location = new System.Drawing.Point(7, 68);
            this.BShoot.Name = "BShoot";
            this.BShoot.Size = new System.Drawing.Size(194, 60);
            this.BShoot.TabIndex = 4;
            this.BShoot.Text = "Выстрелить";
            this.BShoot.UseVisualStyleBackColor = false;
            this.BShoot.Click += new System.EventHandler(this.BShoot_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(4, 43);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(76, 16);
            this.label2.TabIndex = 3;
            this.label2.Text = "Введите Y";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(4, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(75, 16);
            this.label1.TabIndex = 2;
            this.label1.Text = "Введите X";
            // 
            // TBYShoot
            // 
            this.TBYShoot.Location = new System.Drawing.Point(85, 40);
            this.TBYShoot.Name = "TBYShoot";
            this.TBYShoot.Size = new System.Drawing.Size(116, 22);
            this.TBYShoot.TabIndex = 1;
            // 
            // TBXShoot
            // 
            this.TBXShoot.Location = new System.Drawing.Point(85, 12);
            this.TBXShoot.Name = "TBXShoot";
            this.TBXShoot.Size = new System.Drawing.Size(116, 22);
            this.TBXShoot.TabIndex = 0;
            // 
            // STOPShoot
            // 
            this.STOPShoot.BackColor = System.Drawing.Color.Red;
            this.STOPShoot.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.STOPShoot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.STOPShoot.Location = new System.Drawing.Point(6, 101);
            this.STOPShoot.Name = "STOPShoot";
            this.STOPShoot.Size = new System.Drawing.Size(206, 60);
            this.STOPShoot.TabIndex = 5;
            this.STOPShoot.Text = "Остановить";
            this.STOPShoot.UseVisualStyleBackColor = false;
            // 
            // Shooting
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 511);
            this.Controls.Add(this.groupBox1);
            this.Cursor = System.Windows.Forms.Cursors.Cross;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.MinimumSize = new System.Drawing.Size(800, 550);
            this.Name = "Shooting";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SHottiNG GAME";
            this.SizeChanged += new System.EventHandler(this.Form1_SizeChanged);
            this.groupBox1.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox TBYShoot;
        private System.Windows.Forms.TextBox TBXShoot;
        private System.Windows.Forms.Button BShoot;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Label LTShoots;
        private System.Windows.Forms.Label LAllShoots;
        private System.Windows.Forms.Button STOPShoot;
    }
}

