package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant {

    private int id;
    private String name;
    private ArrayList<Table> tables;
    private Till till;

    public Restaurant(String name) {
        this.name = name;
        this.tables = new ArrayList();
        this.till = new Till();
        setTables();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public Till getTill() {
        return till;
    }

    public void setTill(Till till) {
        this.till = till;
    }

    public void setTables(){
        Table table1 = Table.TABLETWO;
        Table table2 = Table.TABLETWO;
        Table table3 = Table.TABLETWO;
        Table table4 = Table.TABLETWO;
        Table table5 = Table.TABLETWO;
        Table table6 = Table.TABLETWO;
        Table table7 = Table.TABLEFOUR;
        Table table8 = Table.TABLEFOUR;
        Table table9 = Table.TABLEFOUR;
        Table table10 = Table.TABLEFOUR;
        Table table11 = Table.TABLESIX;
        Table table12 = Table.TABLESIX;
        this.tables = new ArrayList<Table>(Arrays.asList(table1, table2, table3, table4,
                table5, table6, table7, table8, table9, table10, table11, table12));
    }
}
