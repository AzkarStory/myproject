package project.model;

import javax.persistence.*;

@Entity
@Table(name = "cup")
public class Cup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String number;
    @Column
    private int cup;
    @Column(name = "cup_zapas")
    private int cupZapas;
    @Column(name = "total_cup")
    private int totalCup;

    public Cup() {
    }

    public Cup(Long id, String name, String number, int cup, int cupZapas, int totalCup) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.cup = cup;
        this.cupZapas = cupZapas;
        this.totalCup = totalCup;
    }

    public Cup(Long id, Integer cup){
        this.id = id;
        this.cup = cup;
    }

    public Cup(String name, String number, Integer cup){
        this.name = name;
        this.number = number;
        this.cup = cup;
        this.cupZapas = 0;
        this.totalCup = 1;
    }

    public Cup(String name, String number) {
        this.name = name;
        this.number = number;
        this.cup = 1;
        this.cupZapas = 0;
        this.totalCup = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public int getCupZapas() {
        return cupZapas;
    }

    public void setCupZapas(int cupZapas) {
        this.cupZapas = cupZapas;
    }

    public int getTotalCup() {
        return totalCup;
    }

    public void setTotalCup(int totalCup) {
        this.totalCup = totalCup;
    }
}
