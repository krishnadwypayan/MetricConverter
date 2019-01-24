package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class ConversionServiceImpl extends ConversionServiceGrpc.ConversionServiceImplBase {

    private double cmToInches(double value) { return value*0.3937; }

    private double inchesToCm(double value) { return value*2.54; }

    private double kmToMiles(double value) { return value*0.6214; }

    private double milesToKm(double value) { return value*1.61; }

    private double celToFah(double value) { return (value * 9/5) + 32; }

    private double fahToCel(double value) { return (value - 32) * 5/9; }

    private double mtToFt(double value) { return value*3.281; }

    private double ftToMt(double value) { return value*0.3048; }

    private double lbsToGms(double value) { return value*453.592; }

    private double gmsToLbs(double value) { return value/453.592; }

    @Override
    public void convert(GrpcRequest request, StreamObserver<GrpcResponse> responseObserver) {
        double reqValue = request.getValue();
        ConversionSystem convSys = request.getConvSys();

        double respValue = 0;
        switch (convSys) {
            case cm_to_inches:
                respValue = cmToInches(reqValue);
                break;
            case inches_to_cm:
                respValue = inchesToCm(reqValue);
                break;
            case km_to_miles:
                respValue = kmToMiles(reqValue);
                break;
            case miles_to_km:
                respValue = milesToKm(reqValue);
                break;
            case celcius_to_fah:
                respValue = celToFah(reqValue);
                break;
            case fah_to_celcius:
                respValue = fahToCel(reqValue);
                break;
            case mt_to_ft:
                respValue = mtToFt(reqValue);
                break;
            case ft_to_mt:
                respValue = ftToMt(reqValue);
                break;
            case lbs_to_gms:
                respValue = lbsToGms(reqValue);
                break;
            case gms_to_lbs:
                respValue = gmsToLbs(reqValue);
                break;
            case UNRECOGNIZED:
                break;
        }

        responseObserver.onNext(GrpcResponse.newBuilder()
                .setValue(respValue)
                .build());

        responseObserver.onCompleted();
    }
}
