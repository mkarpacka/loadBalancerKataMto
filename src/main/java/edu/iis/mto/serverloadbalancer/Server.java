package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPecentage;
    public int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm vm) {
        return vms.contains(vm);
    }

    public void addVm(Vm vm) {
        currentLoadPecentage = (double) vm.size / (double) capacity * MAXIMUM_LOAD;
        this.vms.add(vm);
    }

    public int countOfVms() {
        return vms.size();
    }

    public boolean canFit(Vm vm) {
        return currentLoadPecentage + ((double) vm.size / (double) this.capacity * MAXIMUM_LOAD) <= MAXIMUM_LOAD;
    }
}
