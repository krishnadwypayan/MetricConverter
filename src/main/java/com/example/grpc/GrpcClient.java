package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        ConversionServiceGrpc.ConversionServiceBlockingStub stub = ConversionServiceGrpc.newBlockingStub(channel);

        System.out.println("Choose conversion system: \n" + "Exit : 100");
        System.out.println("    cm_to_inches = 0;\n" +
                "    inches_to_cm = 1;\n" +
                "    km_to_miles = 2;\n" +
                "    miles_to_km = 3;\n" +
                "    celcius_to_fah = 4;\n" +
                "    fah_to_celcius = 5;\n" +
                "    mt_to_ft = 6;\n" +
                "    ft_to_mt = 7;\n" +
                "    lbs_to_gms = 8;\n" +
                "    gms_to_lbs = 9;");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\nChoose Conversion System:");
            int convSys = scanner.nextInt();
            if (convSys == 100) {
                break;
            }

            ConversionSystem reqConvSystem = ConversionSystem.forNumber(convSys);
            System.out.println("Enter value:");
            double reqValue = scanner.nextDouble();

            GrpcResponse response = stub.convert(GrpcRequest.newBuilder()
                    .setConvSys(reqConvSystem)
                    .setValue(reqValue)
                    .build());

            String[] units = reqConvSystem.toString().split("_");

            System.out.println(reqValue + units[0] + " = " + response.getValue() + units[2]);
        }
    }
}
