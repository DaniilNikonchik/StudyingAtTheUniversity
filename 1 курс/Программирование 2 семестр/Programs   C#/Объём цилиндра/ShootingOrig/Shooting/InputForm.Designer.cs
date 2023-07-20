namespace Shooting
{
    partial class InputForm
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
            this.lab1 = new System.Windows.Forms.Label();
            this.lab2 = new System.Windows.Forms.Label();
            this.nudRadius = new System.Windows.Forms.NumericUpDown();
            this.nudShots = new System.Windows.Forms.NumericUpDown();
            this.btShoot = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.nudRadius)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudShots)).BeginInit();
            this.SuspendLayout();
            // 
            // lab1
            // 
            this.lab1.AutoSize = true;
            this.lab1.Font = new System.Drawing.Font("Microsoft YaHei", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lab1.Location = new System.Drawing.Point(12, 13);
            this.lab1.Name = "lab1";
            this.lab1.Size = new System.Drawing.Size(208, 21);
            this.lab1.TabIndex = 0;
            this.lab1.Text = "Введите радиус мишени:";
            // 
            // lab2
            // 
            this.lab2.AutoSize = true;
            this.lab2.Font = new System.Drawing.Font("Microsoft YaHei", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lab2.Location = new System.Drawing.Point(12, 55);
            this.lab2.Name = "lab2";
            this.lab2.Size = new System.Drawing.Size(218, 21);
            this.lab2.TabIndex = 1;
            this.lab2.Text = "Введите число выстрелов:";
            // 
            // nudRadius
            // 
            this.nudRadius.DecimalPlaces = 1;
            this.nudRadius.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.nudRadius.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.nudRadius.Location = new System.Drawing.Point(282, 12);
            this.nudRadius.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudRadius.Name = "nudRadius";
            this.nudRadius.Size = new System.Drawing.Size(120, 26);
            this.nudRadius.TabIndex = 2;
            this.nudRadius.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // nudShots
            // 
            this.nudShots.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.nudShots.Location = new System.Drawing.Point(282, 55);
            this.nudShots.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudShots.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudShots.Name = "nudShots";
            this.nudShots.Size = new System.Drawing.Size(120, 26);
            this.nudShots.TabIndex = 3;
            this.nudShots.Value = new decimal(new int[] {
            10,
            0,
            0,
            0});
            // 
            // btShoot
            // 
            this.btShoot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btShoot.Location = new System.Drawing.Point(114, 104);
            this.btShoot.Name = "btShoot";
            this.btShoot.Size = new System.Drawing.Size(205, 37);
            this.btShoot.TabIndex = 4;
            this.btShoot.Text = "В бой!";
            this.btShoot.UseVisualStyleBackColor = true;
            this.btShoot.Click += new System.EventHandler(this.btShoot_Click);
            // 
            // InputForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(441, 153);
            this.Controls.Add(this.btShoot);
            this.Controls.Add(this.nudShots);
            this.Controls.Add(this.nudRadius);
            this.Controls.Add(this.lab2);
            this.Controls.Add(this.lab1);
            this.MinimumSize = new System.Drawing.Size(457, 192);
            this.Name = "InputForm";
            this.Text = "Начальные настройки";
            ((System.ComponentModel.ISupportInitialize)(this.nudRadius)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudShots)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lab1;
        private System.Windows.Forms.Label lab2;
        private System.Windows.Forms.NumericUpDown nudRadius;
        private System.Windows.Forms.NumericUpDown nudShots;
        private System.Windows.Forms.Button btShoot;
    }
}