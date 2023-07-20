package Classes;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

abstract public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    public final Date creationDate = new Date();

    public String getCreationDate() {
        DateFormat dateFormatter = DateFormat.getDateTimeInstance(
                DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
        String dateOut = dateFormatter.format(creationDate);
        return dateOut;
    }

    private String name;

    public String getName() {
        return name;
    }

    public enum Type {Manager, Analyst, Programmer, Tester, Designer}

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type a) {
        this.type = a;
    }

    private String info = "";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return AppLocale.getString(AppLocale.worker) + ": " + name + ", " +
                AppLocale.getString(AppLocale.type) + ": " + AppLocale.getString(type.toString().toLowerCase()) + ", " +
                AppLocale.getString(AppLocale.info) + ": " + info + ", " +
                AppLocale.getString(AppLocale.creation) + ": " + getCreationDate();
    }

    public Worker() {}

    protected Worker(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
