#include <stdio.h>
#include <string.h>

union Vehicle {
    int numberOfWheels;
    float engineCapacity;
    char vehicleType[20];
};

void printVehicleDetails(union Vehicle *v, int type) {
    switch (type) {
        case 0:
            printf("Number of Wheels: %d\n", v->numberOfWheels);
            break;
        case 1:
            printf("Engine Capacity: %.2f liters\n", v->engineCapacity);
            break;
        case 2:
            printf("Vehicle Type: %s\n", v->vehicleType);
            break;
        default:
            printf("Unknown type\n");
            break;
    }
}

int main() {
    union Vehicle vehicle;

    // Store and print number of wheels
    vehicle.numberOfWheels = 4;
    printf("Storing Number of Wheels:\n");
    printVehicleDetails(&vehicle, 0);

    // Store and print engine capacity
    vehicle.engineCapacity = 2.5;
    printf("\nStoring Engine Capacity:\n");
    printVehicleDetails(&vehicle, 1);

    // Store and print vehicle type
    strcpy(vehicle.vehicleType, "Sedan");
    printf("\nStoring Vehicle Type:\n");
    printVehicleDetails(&vehicle, 2);

    return 0;
}
