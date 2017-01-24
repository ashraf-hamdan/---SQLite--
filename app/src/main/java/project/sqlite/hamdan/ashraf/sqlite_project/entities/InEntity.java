package project.sqlite.hamdan.ashraf.sqlite_project.entities;

/**
 * Created by ashraf on 12/14/2016.
 */

public class InEntity {
    private String id;
    private String name;
    private String price;
    private String number;
    private String category;

    public InEntity() {
    }

    public InEntity(String id, String name, String price, String number, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
