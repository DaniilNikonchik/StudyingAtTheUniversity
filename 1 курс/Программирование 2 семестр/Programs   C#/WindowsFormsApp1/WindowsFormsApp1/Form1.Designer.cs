namespace WindowsFormsApp1
{
    partial class Lalala
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
            this.tbN2 = new System.Windows.Forms.TextBox();
            this.btSum = new System.Windows.Forms.Button();
            this.tbN1 = new System.Windows.Forms.TextBox();
            this.Rez = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.erCheck = new System.Windows.Forms.ErrorProvider(this.components);
            this.btDif = new System.Windows.Forms.Button();
            this.btComp = new System.Windows.Forms.Button();
            this.btPriv = new System.Windows.Forms.Button();
            this.btMax = new System.Windows.Forms.Button();
            this.btMin = new System.Windows.Forms.Button();
            this.btMixEqually = new System.Windows.Forms.Button();
            this.btMaxEqually = new System.Windows.Forms.Button();
            this.btPercent = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.erCheck)).BeginInit();
            this.SuspendLayout();
            // 
            // tbN2
            // 
            this.tbN2.Location = new System.Drawing.Point(268, 99);
            this.tbN2.Name = "tbN2";
            this.tbN2.Size = new System.Drawing.Size(167, 22);
            this.tbN2.TabIndex = 1;
            this.tbN2.Validating += new System.ComponentModel.CancelEventHandler(this.tbN2_Validating);
            this.tbN2.Validated += new System.EventHandler(this.tbN2_Validated);
            // 
            // btSum
            // 
            this.btSum.AccessibleName = "btSum";
            this.btSum.Location = new System.Drawing.Point(51, 150);
            this.btSum.Name = "btSum";
            this.btSum.Size = new System.Drawing.Size(37, 23);
            this.btSum.TabIndex = 2;
            this.btSum.Text = "+";
            this.btSum.UseVisualStyleBackColor = true;
            this.btSum.MouseClick += new System.Windows.Forms.MouseEventHandler(this.btSum_MouseClick);
            // 
            // tbN1
            // 
            this.tbN1.Location = new System.Drawing.Point(268, 49);
            this.tbN1.Name = "tbN1";
            this.tbN1.Size = new System.Drawing.Size(167, 22);
            this.tbN1.TabIndex = 3;
            this.tbN1.Validating += new System.ComponentModel.CancelEventHandler(this.tbN1_Validating);
            // 
            // Rez
            // 
            this.Rez.Location = new System.Drawing.Point(268, 151);
            this.Rez.Name = "Rez";
            this.Rez.ReadOnly = true;
            this.Rez.Size = new System.Drawing.Size(95, 22);
            this.Rez.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(48, 49);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(157, 17);
            this.label1.TabIndex = 5;
            this.label1.Text = "Введите первое число";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(49, 102);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(156, 17);
            this.label2.TabIndex = 6;
            this.label2.Text = "Введите второе число";
            // 
            // erCheck
            // 
            this.erCheck.ContainerControl = this;
            // 
            // btDif
            // 
            this.btDif.Location = new System.Drawing.Point(94, 150);
            this.btDif.Name = "btDif";
            this.btDif.Size = new System.Drawing.Size(37, 23);
            this.btDif.TabIndex = 7;
            this.btDif.Text = "-";
            this.btDif.UseVisualStyleBackColor = true;
            this.btDif.Click += new System.EventHandler(this.BtDif_Click);
            // 
            // btComp
            // 
            this.btComp.Location = new System.Drawing.Point(137, 150);
            this.btComp.Name = "btComp";
            this.btComp.Size = new System.Drawing.Size(37, 23);
            this.btComp.TabIndex = 8;
            this.btComp.Text = "*";
            this.btComp.UseVisualStyleBackColor = true;
            this.btComp.Click += new System.EventHandler(this.BtComp_Click);
            // 
            // btPriv
            // 
            this.btPriv.Location = new System.Drawing.Point(180, 150);
            this.btPriv.Name = "btPriv";
            this.btPriv.Size = new System.Drawing.Size(37, 23);
            this.btPriv.TabIndex = 9;
            this.btPriv.Text = "/";
            this.btPriv.UseVisualStyleBackColor = true;
            this.btPriv.Click += new System.EventHandler(this.BtPriv_Click);
            // 
            // btMax
            // 
            this.btMax.Location = new System.Drawing.Point(52, 179);
            this.btMax.Name = "btMax";
            this.btMax.Size = new System.Drawing.Size(37, 23);
            this.btMax.TabIndex = 10;
            this.btMax.Text = "<";
            this.btMax.UseVisualStyleBackColor = true;
            this.btMax.Click += new System.EventHandler(this.BtMax_Click);
            // 
            // btMin
            // 
            this.btMin.Location = new System.Drawing.Point(94, 179);
            this.btMin.Name = "btMin";
            this.btMin.Size = new System.Drawing.Size(37, 23);
            this.btMin.TabIndex = 11;
            this.btMin.Text = ">";
            this.btMin.UseVisualStyleBackColor = true;
            this.btMin.Click += new System.EventHandler(this.BtMin_Click);
            // 
            // btMixEqually
            // 
            this.btMixEqually.Location = new System.Drawing.Point(180, 179);
            this.btMixEqually.Name = "btMixEqually";
            this.btMixEqually.Size = new System.Drawing.Size(37, 23);
            this.btMixEqually.TabIndex = 13;
            this.btMixEqually.Text = ">=";
            this.btMixEqually.UseVisualStyleBackColor = true;
            this.btMixEqually.Click += new System.EventHandler(this.BtMinEqually_Click);
            // 
            // btMaxEqually
            // 
            this.btMaxEqually.Location = new System.Drawing.Point(137, 179);
            this.btMaxEqually.Name = "btMaxEqually";
            this.btMaxEqually.Size = new System.Drawing.Size(37, 23);
            this.btMaxEqually.TabIndex = 12;
            this.btMaxEqually.Text = "<=";
            this.btMaxEqually.UseVisualStyleBackColor = true;
            this.btMaxEqually.Click += new System.EventHandler(this.BtMaxEqually_Click);
            // 
            // btPercent
            // 
            this.btPercent.Location = new System.Drawing.Point(223, 150);
            this.btPercent.Name = "btPercent";
            this.btPercent.Size = new System.Drawing.Size(37, 23);
            this.btPercent.TabIndex = 14;
            this.btPercent.Text = "%";
            this.btPercent.UseVisualStyleBackColor = true;
            this.btPercent.Click += new System.EventHandler(this.BtPercent_Click);
            // 
            // Lalala
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.AppWorkspace;
            this.ClientSize = new System.Drawing.Size(535, 335);
            this.Controls.Add(this.btPercent);
            this.Controls.Add(this.btMixEqually);
            this.Controls.Add(this.btMaxEqually);
            this.Controls.Add(this.btMin);
            this.Controls.Add(this.btMax);
            this.Controls.Add(this.btPriv);
            this.Controls.Add(this.btComp);
            this.Controls.Add(this.btDif);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.Rez);
            this.Controls.Add(this.tbN1);
            this.Controls.Add(this.btSum);
            this.Controls.Add(this.tbN2);
            this.Name = "Lalala";
            this.Text = "Калькулятор";
            this.Load += new System.EventHandler(this.Lalala_Load);
            ((System.ComponentModel.ISupportInitialize)(this.erCheck)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.TextBox tbN2;
        private System.Windows.Forms.Button btSum;
        private System.Windows.Forms.TextBox tbN1;
        private System.Windows.Forms.TextBox Rez;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ErrorProvider erCheck;
        private System.Windows.Forms.Button btPriv;
        private System.Windows.Forms.Button btComp;
        private System.Windows.Forms.Button btDif;
        private System.Windows.Forms.Button btMin;
        private System.Windows.Forms.Button btMax;
        private System.Windows.Forms.Button btMixEqually;
        private System.Windows.Forms.Button btMaxEqually;
        private System.Windows.Forms.Button btPercent;
    }
}

