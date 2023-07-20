package УПLab5v11;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CatalogTableModel implements TableModel {
    private final Set<TableModelListener> listeners = new HashSet<>();
    private List<GameNode> infoNodes = new ArrayList<>();

    private static final String[] columnNames = new String[]{"Тип", "Имя", "Создатель", "Стоимость"};
    private static final Class<?>[] columnTypes = new Class[]{String.class, String.class, String.class, String.class};

    CatalogTableModel() {}

    CatalogTableModel(List<GameNode> al) {
        setInfoNodes(al);
    }

    private void setInfoNodes(List<GameNode> gameNodes) {
        infoNodes = gameNodes;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return infoNodes.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GameNode busNode = infoNodes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> busNode.getType();
            case 1 -> busNode.getName();
            case 2 -> busNode.getProducer();
            case 3 -> busNode.getNumber();
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }
}
