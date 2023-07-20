
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

public class GameTable extends JTable {
    final DishTableModel model;
    public GameTable() {
        model = new DishTableModel(null);
        setModel(model);
    }

    public void setDishs(List<Game> games) {
        model.setDishs(games);
    }

    static class DishTableModel extends AbstractTableModel {
        private List<Game> games;

        public DishTableModel(List<Game> games) {
            this.games = games;
        }

        static final String[] columnNames = new String[]{
                "Name", "Creator", "price"
        };

        static final Class<?>[] columnTypes = new Class[]{
                String.class, String.class, String.class
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return games == null ? 0 : games.size();
        }

        public String getColumnName(int column) {
            return columnNames[column];
        }

        public Class<?> getColumnClass(int column) {
            return columnTypes[column];
        }

        public Object getValueAt(int row, int column) {
            Game dish = games.get(row);
            switch (column) {
                case 0:
                    return dish.getName();
                case 1:
                    return dish.getComplexity();
                case 2:
                    return dish.getExotic();
                default:
                    return null;
            }
        }

        public void setDishs(List<Game> games) {
            this.games = games;
            this.fireTableDataChanged();
        }
    }
}
