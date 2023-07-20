namespace Shooting
{
    partial class ShootingForm
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
            this.pbTarget = new System.Windows.Forms.PictureBox();
            this.gbGame = new System.Windows.Forms.GroupBox();
            this.lbFailuresStatic = new System.Windows.Forms.Label();
            this.lbSuccessesStatic = new System.Windows.Forms.Label();
            this.lbShotsStatic = new System.Windows.Forms.Label();
            this.btShoot = new System.Windows.Forms.Button();
            this.trbYCoord = new System.Windows.Forms.TrackBar();
            this.tbYCoord = new System.Windows.Forms.TextBox();
            this.Ycor = new System.Windows.Forms.Label();
            this.trbXCoord = new System.Windows.Forms.TrackBar();
            this.tbXCoord = new System.Windows.Forms.TextBox();
            this.Xcor = new System.Windows.Forms.Label();
            this.lab1 = new System.Windows.Forms.Label();
            this.lbShots = new System.Windows.Forms.Label();
            this.lbSuccesses = new System.Windows.Forms.Label();
            this.lbFailures = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pbTarget)).BeginInit();
            this.gbGame.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.trbYCoord)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.trbXCoord)).BeginInit();
            this.SuspendLayout();
            // 
            // pbTarget
            // 
            this.pbTarget.BackColor = System.Drawing.Color.PaleTurquoise;
            this.pbTarget.Location = new System.Drawing.Point(12, 12);
            this.pbTarget.Name = "pbTarget";
            this.pbTarget.Size = new System.Drawing.Size(520, 520);
            this.pbTarget.TabIndex = 0;
            this.pbTarget.TabStop = false;
            this.pbTarget.Paint += new System.Windows.Forms.PaintEventHandler(this.pbTarget_Paint);
            this.pbTarget.MouseClick += new System.Windows.Forms.MouseEventHandler(this.pbTarget_MouseClick);
            // 
            // gbGame
            // 
            this.gbGame.Controls.Add(this.lbFailures);
            this.gbGame.Controls.Add(this.lbSuccesses);
            this.gbGame.Controls.Add(this.lbShots);
            this.gbGame.Controls.Add(this.lbFailuresStatic);
            this.gbGame.Controls.Add(this.lbSuccessesStatic);
            this.gbGame.Controls.Add(this.lbShotsStatic);
            this.gbGame.Controls.Add(this.btShoot);
            this.gbGame.Controls.Add(this.trbYCoord);
            this.gbGame.Controls.Add(this.tbYCoord);
            this.gbGame.Controls.Add(this.Ycor);
            this.gbGame.Controls.Add(this.trbXCoord);
            this.gbGame.Controls.Add(this.tbXCoord);
            this.gbGame.Controls.Add(this.Xcor);
            this.gbGame.Controls.Add(this.lab1);
            this.gbGame.Location = new System.Drawing.Point(538, 12);
            this.gbGame.MaximumSize = new System.Drawing.Size(250, 520);
            this.gbGame.MinimumSize = new System.Drawing.Size(250, 520);
            this.gbGame.Name = "gbGame";
            this.gbGame.Size = new System.Drawing.Size(250, 520);
            this.gbGame.TabIndex = 14;
            this.gbGame.TabStop = false;
            // 
            // lbFailuresStatic
            // 
            this.lbFailuresStatic.AutoSize = true;
            this.lbFailuresStatic.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbFailuresStatic.Location = new System.Drawing.Point(31, 412);
            this.lbFailuresStatic.Name = "lbFailuresStatic";
            this.lbFailuresStatic.Size = new System.Drawing.Size(118, 25);
            this.lbFailuresStatic.TabIndex = 20;
            this.lbFailuresStatic.Text = "Промахов:";
            // 
            // lbSuccessesStatic
            // 
            this.lbSuccessesStatic.AutoSize = true;
            this.lbSuccessesStatic.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbSuccessesStatic.Location = new System.Drawing.Point(31, 374);
            this.lbSuccessesStatic.Name = "lbSuccessesStatic";
            this.lbSuccessesStatic.Size = new System.Drawing.Size(129, 25);
            this.lbSuccessesStatic.TabIndex = 19;
            this.lbSuccessesStatic.Text = "Попаданий:";
            // 
            // lbShotsStatic
            // 
            this.lbShotsStatic.AutoSize = true;
            this.lbShotsStatic.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbShotsStatic.Location = new System.Drawing.Point(16, 307);
            this.lbShotsStatic.Name = "lbShotsStatic";
            this.lbShotsStatic.Size = new System.Drawing.Size(127, 25);
            this.lbShotsStatic.TabIndex = 18;
            this.lbShotsStatic.Text = "Выстрелов:";
            // 
            // btShoot
            // 
            this.btShoot.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btShoot.Location = new System.Drawing.Point(19, 233);
            this.btShoot.Name = "btShoot";
            this.btShoot.Size = new System.Drawing.Size(208, 38);
            this.btShoot.TabIndex = 7;
            this.btShoot.Text = "Огонь!";
            this.btShoot.UseVisualStyleBackColor = true;
            this.btShoot.Click += new System.EventHandler(this.btShoot_Click);
            // 
            // trbYCoord
            // 
            this.trbYCoord.Location = new System.Drawing.Point(19, 182);
            this.trbYCoord.Maximum = 1000;
            this.trbYCoord.Minimum = -1000;
            this.trbYCoord.Name = "trbYCoord";
            this.trbYCoord.Size = new System.Drawing.Size(208, 45);
            this.trbYCoord.TabIndex = 17;
            this.trbYCoord.Scroll += new System.EventHandler(this.trbYCoord_Scroll);
            // 
            // tbYCoord
            // 
            this.tbYCoord.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.tbYCoord.Location = new System.Drawing.Point(59, 150);
            this.tbYCoord.Name = "tbYCoord";
            this.tbYCoord.Size = new System.Drawing.Size(163, 26);
            this.tbYCoord.TabIndex = 15;
            this.tbYCoord.Text = "0";
            this.tbYCoord.Validating += new System.ComponentModel.CancelEventHandler(this.tbYCoord_Validating);
            // 
            // Ycor
            // 
            this.Ycor.AutoSize = true;
            this.Ycor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Ycor.Location = new System.Drawing.Point(15, 153);
            this.Ycor.Name = "Ycor";
            this.Ycor.Size = new System.Drawing.Size(28, 20);
            this.Ycor.TabIndex = 17;
            this.Ycor.Text = "Y :";
            // 
            // trbXCoord
            // 
            this.trbXCoord.Location = new System.Drawing.Point(19, 94);
            this.trbXCoord.Maximum = 1000;
            this.trbXCoord.Minimum = -1000;
            this.trbXCoord.Name = "trbXCoord";
            this.trbXCoord.Size = new System.Drawing.Size(208, 45);
            this.trbXCoord.TabIndex = 16;
            this.trbXCoord.Scroll += new System.EventHandler(this.trbXCoord_Scroll);
            // 
            // tbXCoord
            // 
            this.tbXCoord.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.tbXCoord.Location = new System.Drawing.Point(59, 62);
            this.tbXCoord.Name = "tbXCoord";
            this.tbXCoord.Size = new System.Drawing.Size(163, 26);
            this.tbXCoord.TabIndex = 4;
            this.tbXCoord.Text = "0";
            this.tbXCoord.Validating += new System.ComponentModel.CancelEventHandler(this.tbXCoord_Validating);
            // 
            // Xcor
            // 
            this.Xcor.AutoSize = true;
            this.Xcor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Xcor.Location = new System.Drawing.Point(15, 65);
            this.Xcor.Name = "Xcor";
            this.Xcor.Size = new System.Drawing.Size(28, 20);
            this.Xcor.TabIndex = 3;
            this.Xcor.Text = "X :";
            // 
            // lab1
            // 
            this.lab1.AutoSize = true;
            this.lab1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lab1.Location = new System.Drawing.Point(6, 16);
            this.lab1.Name = "lab1";
            this.lab1.Size = new System.Drawing.Size(173, 40);
            this.lab1.TabIndex = 2;
            this.lab1.Text = "Введите координаты\r\nвыстрела:";
            // 
            // lbShots
            // 
            this.lbShots.AutoSize = true;
            this.lbShots.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbShots.Location = new System.Drawing.Point(33, 332);
            this.lbShots.Name = "lbShots";
            this.lbShots.Size = new System.Drawing.Size(0, 25);
            this.lbShots.TabIndex = 21;
            // 
            // lbSuccesses
            // 
            this.lbSuccesses.AutoSize = true;
            this.lbSuccesses.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbSuccesses.Location = new System.Drawing.Point(166, 374);
            this.lbSuccesses.Name = "lbSuccesses";
            this.lbSuccesses.Size = new System.Drawing.Size(0, 25);
            this.lbSuccesses.TabIndex = 22;
            // 
            // lbFailures
            // 
            this.lbFailures.AutoSize = true;
            this.lbFailures.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbFailures.Location = new System.Drawing.Point(166, 412);
            this.lbFailures.Name = "lbFailures";
            this.lbFailures.Size = new System.Drawing.Size(0, 25);
            this.lbFailures.TabIndex = 23;
            // 
            // ShootingForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 551);
            this.Controls.Add(this.gbGame);
            this.Controls.Add(this.pbTarget);
            this.MinimumSize = new System.Drawing.Size(816, 590);
            this.Name = "ShootingForm";
            this.Text = "Shooting";
            this.Load += new System.EventHandler(this.ShootingForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pbTarget)).EndInit();
            this.gbGame.ResumeLayout(false);
            this.gbGame.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.trbYCoord)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.trbXCoord)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pbTarget;
        private System.Windows.Forms.GroupBox gbGame;
        private System.Windows.Forms.Label lbFailuresStatic;
        private System.Windows.Forms.Label lbSuccessesStatic;
        private System.Windows.Forms.Label lbShotsStatic;
        private System.Windows.Forms.Button btShoot;
        private System.Windows.Forms.TrackBar trbYCoord;
        private System.Windows.Forms.TextBox tbYCoord;
        private System.Windows.Forms.Label Ycor;
        private System.Windows.Forms.TrackBar trbXCoord;
        private System.Windows.Forms.TextBox tbXCoord;
        private System.Windows.Forms.Label Xcor;
        private System.Windows.Forms.Label lab1;
        private System.Windows.Forms.Label lbFailures;
        private System.Windows.Forms.Label lbSuccesses;
        private System.Windows.Forms.Label lbShots;
    }
}

