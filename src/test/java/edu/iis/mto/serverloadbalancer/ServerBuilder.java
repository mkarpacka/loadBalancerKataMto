package edu.iis.mto.serverloadbalancer;

import static edu.iis.mto.serverloadbalancer.Server.MAXIMUM_LOAD;

public class ServerBuilder {

	private int capacity;
	private double initialLoad;

	public ServerBuilder withCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Server build() {
		Server server = new Server(capacity);
		addInitialLoad(server);
		return server;
	}

	public void addInitialLoad(Server server) {
		if (initialLoad > 0) {
			int initialVmSize = (int) (initialLoad / (double) capacity * MAXIMUM_LOAD);
			Vm initialVm = VmBuilder.vm().ofSize(initialVmSize).build();
			server.addVm(initialVm);
		}
	}

	public static ServerBuilder server() {
		return new ServerBuilder();
	}

	public ServerBuilder withCurrentLoadOf(double initialLoad) {
		this.initialLoad = initialLoad;
		return this;
	}
}
