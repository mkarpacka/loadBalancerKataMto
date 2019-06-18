package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public double currentLoadPercentage;
    public int capacity;
    private static final double MAXIMUM_LOAD = 100.0d;

    private List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        super();
        this.capacity = capacity;
    }

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public void addVm(Vm vm) {

        currentLoadPercentage = (double) vm.size / (double) capacity * MAXIMUM_LOAD;
        this.vms.add(vm);
    }

    public int countOfVms() {
        return vms.size();
    }
}

