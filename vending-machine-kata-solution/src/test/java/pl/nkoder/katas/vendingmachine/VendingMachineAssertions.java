package pl.nkoder.katas.vendingmachine;

public class VendingMachineAssertions {

    public static VendingMachineAssert assertThat(VendingMachine machine) {
        return new VendingMachineAssert(machine);
    }
}
