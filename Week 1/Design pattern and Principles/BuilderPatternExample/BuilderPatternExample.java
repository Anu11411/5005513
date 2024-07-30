public class BuilderPatternExample {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setPowerSupply("500W")
                .setMotherboard("MSI Pro")
                .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
