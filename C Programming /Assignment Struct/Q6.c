#include <stdio.h>

union Measurement {
    float temperature;
    float pressure;
};

struct HeatChamber {
    union Measurement measurement;
    int type; // 0 for temperature, 1 for pressure
};

void printMeasurement(struct HeatChamber *chamber) {
    if (chamber->type == 0) {
        printf("Temperature: %.2f°C\n", chamber->measurement.temperature);
    } else if (chamber->type == 1) {
        printf("Pressure: %.2f Pa\n", chamber->measurement.pressure);
    }
}

int main() {
    struct HeatChamber chamber;

    // Example for temperature
    chamber.measurement.temperature = 36.5;
    chamber.type = 0; // 0 for temperature
    printMeasurement(&chamber);

    // Example for pressure
    chamber.measurement.pressure = 101325;
    chamber.type = 1; // 1 for pressure
    printMeasurement(&chamber);

    return 0;
}
