namespace pilots
{
    partial class frmMain
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
            this.dgwGame = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dgwGame)).BeginInit();
            this.SuspendLayout();
            // 
            // dgwGame
            // 
            this.dgwGame.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgwGame.Location = new System.Drawing.Point(3, 0);
            this.dgwGame.Name = "dgwGame";
            this.dgwGame.RowHeadersVisible = false;
            this.dgwGame.RowHeadersWidth = 51;
            this.dgwGame.RowTemplate.Height = 24;
            this.dgwGame.Size = new System.Drawing.Size(422, 297);
            this.dgwGame.TabIndex = 0;
            this.dgwGame.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dwgGame_CellClick);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.dgwGame);
            this.Name = "frmMain";
            this.Text = "Холодильник братьев Пиллотов";
            this.Load += new System.EventHandler(this.frmMain_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgwGame)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dgwGame;
    }
}

