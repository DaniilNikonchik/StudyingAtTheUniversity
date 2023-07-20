namespace Дурак
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
            this.btYes = new System.Windows.Forms.Button();
            this.btNo = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.tbKod = new System.Windows.Forms.TextBox();
            this.tbOtvet = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btYes
            // 
            this.btYes.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btYes.Location = new System.Drawing.Point(669, 353);
            this.btYes.Name = "btYes";
            this.btYes.Size = new System.Drawing.Size(125, 50);
            this.btYes.TabIndex = 0;
            this.btYes.Text = "Да";
            this.btYes.UseVisualStyleBackColor = true;
            this.btYes.Click += new System.EventHandler(this.BtYes_Click);
            // 
            // btNo
            // 
            this.btNo.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btNo.Location = new System.Drawing.Point(1128, 353);
            this.btNo.Name = "btNo";
            this.btNo.Size = new System.Drawing.Size(125, 50);
            this.btNo.TabIndex = 1;
            this.btNo.Text = "Нет";
            this.btNo.UseVisualStyleBackColor = true;
            this.btNo.Click += new System.EventHandler(this.BtNo_Click);
            this.btNo.Enter += new System.EventHandler(this.btNo_Enter);
            this.btNo.MouseMove += new System.Windows.Forms.MouseEventHandler(this.btNo_MouseMove);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 40.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label1.Location = new System.Drawing.Point(768, 168);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(376, 78);
            this.label1.TabIndex = 2;
            this.label1.Text = "Вы дурак?";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 965);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(118, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "Введите чит-код";
            // 
            // tbKod
            // 
            this.tbKod.Location = new System.Drawing.Point(139, 977);
            this.tbKod.Name = "tbKod";
            this.tbKod.Size = new System.Drawing.Size(100, 22);
            this.tbKod.TabIndex = 4;
            this.tbKod.TextChanged += new System.EventHandler(this.TbKod_TextChanged);
            // 
            // tbOtvet
            // 
            this.tbOtvet.Location = new System.Drawing.Point(245, 977);
            this.tbOtvet.Name = "tbOtvet";
            this.tbOtvet.ReadOnly = true;
            this.tbOtvet.Size = new System.Drawing.Size(145, 22);
            this.tbOtvet.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 982);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(121, 17);
            this.label3.TabIndex = 6;
            this.label3.Text = "Мой год рожения";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1906, 1008);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.tbOtvet);
            this.Controls.Add(this.tbKod);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btNo);
            this.Controls.Add(this.btYes);
            this.MinimumSize = new System.Drawing.Size(1918, 1028);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Дурак";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btYes;
        private System.Windows.Forms.Button btNo;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tbKod;
        private System.Windows.Forms.TextBox tbOtvet;
        private System.Windows.Forms.Label label3;
    }
}

