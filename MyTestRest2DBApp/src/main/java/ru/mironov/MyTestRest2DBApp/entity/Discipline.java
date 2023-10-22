package ru.mironov.MyTestRest2DBApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DISCIPLINES")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disid")
    private int disid;

    @Column(name = "disname")
    private String disname;

    public Discipline() {
    }

    public Discipline(String disname){
        this.disname = disname;
    }
}

