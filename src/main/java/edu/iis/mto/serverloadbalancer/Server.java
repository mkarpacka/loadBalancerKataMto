package edu.iis.mto.serverloadbalancer;

public class Server {

    public double currentLoadPercentage;
    public int capacity;

    public Server(int capacity) {
        super();
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return true;
    }
}

