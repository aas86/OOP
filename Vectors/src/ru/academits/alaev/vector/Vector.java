package ru.academits.alaev.vector;

public class Vector {
    private int n;      //размерность вектора
    private double[] vector;

    public Vector(int n) { //Конструктор вектора принимает число n – размерность вектора.
        this.n = n;
        this.vector = new double[n];
    }

    public double[] getVector(){
        return this.vector;
    }
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
