package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public static final double MAXIMUM_LOAD = 100.0d;
    private double currentLoadPecentage;
    private int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(Vm vm) {
        return vms.contains(vm);
    }

    public void addVm(Vm vm) {
        currentLoadPecentage = getCurrentLoadPecentage() + loadOfVm(vm);
        this.vms.add(vm);
    }

    private double loadOfVm(Vm vm) {
        return (double) vm.getSize() / (double) getCapacity() * MAXIMUM_LOAD;
    }

    public int countOfVms() {
        return vms.size();
    }

    public boolean canFit(Vm vm) {
        return getCurrentLoadPecentage() + loadOfVm(vm) <= MAXIMUM_LOAD;
    }

    public double getCurrentLoadPecentage() {
        return currentLoadPecentage;
    }

    public int getCapacity() {
        return capacity;
    }
}
